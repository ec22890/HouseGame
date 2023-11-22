package OOP.ec22890.MP;


public class Item {
    
    final String name;
    
    public Item(String nameOfItem) {
        name = nameOfItem;
    }
    
    public boolean equals(Item x) {
        return name.equals(x.name);
    }
    
    public String toString() {return name + "("+this.hashCode()+")";}
}