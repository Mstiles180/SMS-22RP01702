import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddItemServlet")
public class AddItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String itemName = request.getParameter("item");
        String encodedItemName = URLEncoder.encode(itemName, StandardCharsets.UTF_8.toString());

        // Retrieve existing cookies
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

        // If cart cookie exists, append item; otherwise, create a new cookie
        String cartItems = (cartCookie != null) ? cartCookie.getValue() : "";
        if (!cartItems.isEmpty()) {
            cartItems += ":"; // Separate items with a comma
        }
        cartItems += encodedItemName;

        Cookie newCartCookie = new Cookie("cart", cartItems);
        newCartCookie.setMaxAge(60 * 60 * 24); // 1 day
        response.addCookie(newCartCookie);

        response.sendRedirect("ViewCartServlet");
    }
}
