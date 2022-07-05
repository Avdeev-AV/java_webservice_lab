package endpoint;

import java.util.ArrayList;
import java.util.Objects;

public class Order {

    public Order(){}
    public Order(String order_id, ArrayList<Pizza> pizzas, String address, double sum, String status){
        this.order_id = order_id;
        this.pizzas = pizzas;
        this.address = address;
        this.sum = sum;
        this.status = status;
    }
    public String order_id;
    public ArrayList<Pizza> pizzas;
    public String address;
    public double sum;
    public String status;

    public String toString(){
        return "Order: order_id="+order_id+"\tpizzas="+pizzas+"\taddress="+address+"\tsum="+sum+"\tstatus="+status+"";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.sum, sum) == 0 && order_id.equals(order.order_id)  && address.equals(order.address);
    }

}
