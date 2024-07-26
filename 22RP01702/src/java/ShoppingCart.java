import javax.servlet.http.Cookie;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<String> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    public void removeItem(String item) {
        items.remove(item);
    }

    public void clearCart() {
        items.clear();
    }

    public List<String> getItems() {
        return items;
    }

    public void saveToCookie(Cookie cookie) {
        // Implement logic to serialize items to a string and store in cookie value
    }

    public void loadFromCookie(Cookie cookie) {
        // Implement logic to deserialize items from cookie value and populate items list
    }
}
