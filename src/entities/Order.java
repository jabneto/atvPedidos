package entities;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date moment;
	private OrderStatus status;
	
	private Cliente client;
	private List<OrderItem> items = new ArrayList<>();
	
	public Order(Date moment, OrderStatus status, Cliente client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Cliente getClient() {
		return client;
	}

	public void setClient(Cliente client) {
		this.client = client;
	}

	public List<OrderItem> getItems() {
		return items;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public double total() {
		double sum = 0.0;
		for(OrderItem item : items) {
			sum += item.subTotal();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order:");
		sb.append(sdf.format(moment) + "\n");
		sb.append("Status do pedido: ");
		sb.append((status) + "\n");
		sb.append("Cliente: ");
		sb.append((client) + "\n");
		sb.append("Itens do pedido: ");
		
		for (OrderItem item : items) {
			sb.append(item + "\n");
		}
		sb.append("Total price: $ " );
		sb.append(String.format("%.2f", total()));
		return sb.toString();
	}
	
}
