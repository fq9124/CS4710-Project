import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.PreparedStatement;
 
/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @author www.codejava.net
 */
public class ControlServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PeopleDAO peopleDAO;
 
    public void init() {
        peopleDAO = new PeopleDAO(); 
    }
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);
        try {
            switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
            	insertPeople(request, response);
                break;
            case "/delete":
            	deletePeople(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
            	updatePeople(request, response);
                break;
            default:          	
            	listPeople(request, response);           	
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    
    private void listPeople(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<People> listPeople = new ArrayList<>();
        People person = new People();
        person.setName("fake_guy");
        person.setId(1);
        person.setAddress("51 fake st");
        person.setStatus("st");
        listPeople.add(person);
        request.setAttribute("listPeople", listPeople);       
        RequestDispatcher dispatcher = request.getRequestDispatcher("PeopleList.jsp");       
        dispatcher.forward(request, response);
    }
 //This is the pack we need to follow
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("PeopleForm.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        People existingPeople = peopleDAO.getPeople(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("PeopleForm.jsp");
        request.setAttribute("people", existingPeople);
        dispatcher.forward(request, response);
 
    }
 
    private void insertPeople(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String status = request.getParameter("status");
        People newPeople = new People(name, address, status);
        peopleDAO.insert(newPeople);
        response.sendRedirect("list");
    }
 
    private void updatePeople(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        
        System.out.println(id);
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String status = request.getParameter("status");
        
        System.out.println(name);
        
        People people = new People(id,name, address, status);
        peopleDAO.update(people);
        response.sendRedirect("list");
    }
 
    private void deletePeople(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        //People people = new People(id);
        peopleDAO.delete(id);
        response.sendRedirect("list"); 
    }

}