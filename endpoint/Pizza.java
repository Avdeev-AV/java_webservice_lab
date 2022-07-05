package endpoint;

import java.util.Objects;

public class Pizza {

	public Pizza(){}
	public Pizza(String id, String name, String description,double price){
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public String id;
	public String name;
	public String description;
	public double price;

	public String toString(){
		return "Pizza: id= "+id+"\tName= "+name+"\tDescription="+description+"\tPrice="+price+"";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Pizza pizza = (Pizza) o;
		return Double.compare(pizza.price, price) == 0 && id.equals(pizza.id) && name.equals(pizza.name) && description.equals(pizza.description);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, description, price);
	}
}