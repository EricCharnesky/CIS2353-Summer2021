
package adtbag;


public class ShoppingCart {
    BagInterface<Item> bag;
    
    public ShoppingCart(BagInterface<Item> bag){
        this.bag = bag;
    }
    
    public void addItem(Item item)
    {
        bag.add(item);
    }
}
