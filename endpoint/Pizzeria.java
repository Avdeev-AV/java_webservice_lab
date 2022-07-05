package endpoint;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;

@WebService()
public class Pizzeria {
	private ArrayList<Pizza> menu;
	private ArrayList<Order> order;

	public Pizzeria() {
		menu = new ArrayList<Pizza>();
		order = new ArrayList<Order>();
	}

    @WebMethod()
	public void addNewPizzaToMenu(Pizza[] pizza) {
		for (int i = 0; i < pizza.length; i++)
			menu.add(pizza[i]);
	}

	@WebMethod()
	public void RemovePizzaFromMenu(int index) {
			menu.remove(index);
	}

	@WebMethod()
	public Pizza getPizza(int index) {
		return menu.get(index);
	}

	@WebMethod()
	public int getMenuSize() {
		return menu.size();
	}

	@WebMethod()
	public void createOrder(Order current_order) {
			order.add(current_order);
	}

	@WebMethod()
	public void addPizzaToOrder(Order current_order, int pizza_index) {
		current_order.pizzas.add(menu.get(pizza_index));
	}

	@WebMethod()
	public Order getOrder(int index) {
		return order.get(index);
	}

	@WebMethod()
	public void changeOrderStatus(int index, String new_status) {
		order.get(index).status = new_status;
	}
}


