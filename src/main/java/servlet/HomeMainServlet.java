package servlet;

import admin.UserManager;
import model.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/UsHome")
public class HomeMainServlet extends HttpServlet {

    private final UserManager userManager = new UserManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userManager.getAllUsers();
        req.setAttribute("user", users);
        req.getRequestDispatcher("/WEB-INF/UsHome.jsp").forward(req,resp);
    }
}