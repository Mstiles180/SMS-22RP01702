import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String cartItems = "";
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("cart".equals(cookie.getName())) {
                    cartItems = cookie.getValue();
                    break;
                }
            }
        }

        // Display cart items
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h2>Items in Cart</h2>");
        if (cartItems.isEmpty()) {
            response.getWriter().println("<p>Your cart is empty.</p>");
        } else {
            String[] items = cartItems.split(",");
            response.getWriter().println("<ul>");
            for (String item : items) {
                response.getWriter().println("<li>" + item + "</li>");
            }
            response.getWriter().println("</ul>");
        }
        response.getWriter().println("<a href='/'>Add more items</a>");
        response.getWriter().println("<form action='RemoveItemServlet' method='POST'><input name='item' placeholder='Item to remove'>"
                + "<input type='submit' value='Remove Item'></form>");
        response.getWriter().println("<form action='ClearCartServlet' method='POST'><input type='submit' value='Clear Cart'></form>");
        response.getWriter().println("</body></html>");
    }
}
