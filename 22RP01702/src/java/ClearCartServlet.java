

import javax.servlet.ServletException;

import javax.servlet.http.*;
import java.io.IOException;


public class ClearCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cart")) {
                    cookie.setValue("");
                    cookie.setMaxAge(0); // Deletes the cookie
                    response.addCookie(cookie);
                    break;
                }
            }
        }
        response.sendRedirect("ViewCartServlet");
    }
      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
        }
}