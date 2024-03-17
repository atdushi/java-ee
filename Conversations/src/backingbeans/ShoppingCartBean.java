package backingbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Demonstrates how to use a conversation to build up data over a number
 * of separate requests, without the need for (potentially troublesome) sessions.
 */
@ConversationScoped
@Named("shoppingCartBean")
public class ShoppingCartBean implements Serializable // important!
{
	private List<String> currentCart = new ArrayList<String>();

	@Inject
	private Conversation conversation;
	
	@ManagedProperty(value="#{param.product}")
	private String product;
	
	
	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	// you can't do this in the constructor as the conversation won't yet be 
	// available.
	@PostConstruct
	public void start()
	{
		// start the conversation
		conversation.begin();
	}
	
	public List<String> getAllItems()
	{
		System.out.println("Current cart is " + currentCart);
		return currentCart;
	}
	
	public String addProduct(String product)
	{
		System.out.println("product is " + product);
		this.currentCart.add(product);
		return "cart.xhtml";
	}
	
	public String checkout()
	{
		// go to the confirmation page
		return "confirm-order.xhtml?faces-redirect=true";
	}
	
	public String finalizeOrder()
	{
		// here we would process the order, etc
		conversation.end();
				
		// go back to the cart page
		return "cart.xhtml?faces-redirect=true";
	}
	
	public List<String> getAllAvailableProducts()
	{
		List<String> returnList = new ArrayList<String>();
		returnList.add("Eggs");
		returnList.add("Powerboat");
		returnList.add("Lard");
		returnList.add("Sugar");
		return returnList;
	}
}
