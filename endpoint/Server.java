package endpoint;

import javax.xml.ws.Endpoint;

public class Server {
    public static final int port = 8080;
    public static final String url = "http://localhost:%d/PizzaService";

    public static void main(String[] args) {
        Pizzeria service = new Pizzeria();
        Endpoint.publish(String.format(url, port), service);
    }
}
