package client;

import webservice.*;
import javax.xml.datatype.*;
import java.net.URL;
import java.util.*;

public class PizzeriaClient {
    public static final int port = 8080;
    public static final String url = "http://localhost:%d/PizzaService?wsdl";
    static PizzeriaService service;


    public static void main(String[] args) throws Exception {
        int type = 0; //0 - manager, 1 - client
        service = new PizzeriaService(new URL(String.format(url, port)));
        Pizzeria port = service.getPizzeriaPort();

        ArrayList<Pizza> pizzas_test = new ArrayList<>();
        //Add test
        pizzas_test.add(createPizza("0", "Cheesy", "MORE CHEESE", 500.0));
        pizzas_test.add(createPizza("1", "Pepperoni", "Classic pepperoni", 450.0));
        pizzas_test.add(createPizza("2", "Calzone", "Something between pizza and pie", 475.0));
        port.addNewPizzaToMenu(pizzas_test);

        if (type == 0) {
            //Block 1: Remove from menu and print test
            int pizza_to_delete = 0;
            port.removePizzaFromMenu(pizza_to_delete);
            for (int i = 0; i < port.getMenuSize(); i++)
                printPizza(port.getPizza(i));

        } else if (type == 1) {
            //Block 2: Order actions test
            Order test_order = createOrder("0", "test_address", "formed",0);
            double total = 0;
            int[] pizzas_index = {1,0,1};
            for (int i = 0; i < pizzas_index.length; i++) {
                test_order.getPizzas().add(port.getPizza(pizzas_index[i]));
                total += test_order.getPizzas().get(i).getPrice();
            }

            test_order.setSum(total);

            port.createOrder(test_order);

            port.changeOrderStatus(0,"ready");

            printOrder(port.getOrder(0));

        }
    }

    public static void printPizza(Pizza pizza) {
        System.out.println(pizza.getId() + "\t" + pizza.getName() + "\t"
                + pizza.getDescription() + "\t" + pizza.getPrice());
    }

    public static Pizza createPizza(String id, String name, String description, double price) {
        Pizza pizza = new Pizza();
        pizza.setId(id);
        pizza.setName(name);
        pizza.setDescription(description);
        pizza.setPrice(price);
        return pizza;
    }

    public static Order createOrder(String order_id, String address,String status, double cost) {
        Order order = new Order();
        order.setOrderId(order_id);
        order.setAddress(address);
        order.setStatus(status);
        order.setSum(cost);
        return order;
    }

    public static void printOrder(Order order) {
        System.out.println(order.getOrderId() + "\t" + order.getAddress() + "\t"
                + order.getSum() + "\t" + order.getStatus());
        for (int i = 0; i < order.getPizzas().size(); i++){
            printPizza(order.getPizzas().get(i));
        }
    }
}
