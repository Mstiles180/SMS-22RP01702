import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String itemToRemove = request.getParameter("item");

        Cookie[] cookies = request.getCookies();
        Cookie cartCookie = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("cart".equals(cookie.getName())) {
                    cartCookie = cookie;
                    break;
                }
            }
        }

        if (cartCookie != null) {
            String cartItems = cartCookie.getValue();
            String[] items = cartItems.split(",");
            StringBuilder newCartItems = new StringBuilder();
            for (String item : items) {
                if (!item.equals(itemToRemove)) {
                    if (newCartItems.length() > 0) {
                        newCartItems.append(",");
                    }
                    newCartItems.append(item);
                }
            }
            Cookie newCartCookie = new Cookie("cart", newCartItems.toString());
            newCartCookie.setMaxAge(60 * 60 * 24); // 1 day
            response.addCookie(newCartCookie);
        }

        response.sendRedirect("ViewCartServlet");
    }
}
