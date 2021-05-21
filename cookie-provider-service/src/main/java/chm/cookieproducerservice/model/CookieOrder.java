package chm.cookieproducerservice.model;

public class CookieOrder {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CookieOrder{" +
                "type='" + type + '\'' +
                '}';
    }
}
