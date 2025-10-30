import hospitalsysproject.main; 
import java.util.*;


abstract class menuItem {
    String name;
    double price;

    public menuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class AppsAndStarters extends menuItem {
    private boolean isShareable;
    public AppsAndStarters(String name, double price) {
        super(name, price);
        this.isShareable = isShareable;
    }
    
    public boolean getIsShareable() {
        return isShareable;
    }
    
    public void setIsShareable(boolean isShareable) {
        this.isShareable = isShareable;
    }

    //custom methods
    //retrieve from file


}

class mainCourses extends menuItem {
    private double prepTime;
    public mainCourses(String name, double price) {
        super(name,price);
        this.prepTime = prepTime;
    }
    
    public double getPrepTime() {
        return prepTime;
    }
    
    public void setPrepTime(double prepTime) {
        this.prepTime = prepTime;
    }
}

class Desserts extends menuItem {
    private String dessertType;
    private boolean isShareable;
    public Desserts(String name, double price) {
        super(name,price);   
        this.dessertType = dessertType; 
        this.isShareable = isShareable;
    }
    
    public String getDessertType() {
        return dessertType;
    }
    
    public void setDessertType(String dessertType) {
        this.dessertType = dessertType;
    }

    public boolean getIsShareable() {
        return isShareable;
    }

    public void setIsShareable(boolean isShareable) {
        this.isShareable = isShareable;
    }
}

class Beverages extends menuItem {
    private boolean isAlcoholic;
    private String size;
    public Beverages(String name, double price) {
        super(name,price);    
        this.isAlcoholic = isAlcoholic;
    }
    
    public boolean getIsAlcoholic() {
        return isAlcoholic;
    }
    
    public void setIsAlcoholic(boolean isAlcoholic) {
        this.isAlcoholic = isAlcoholic;
    }
    
    public String getSize() {
        return size;
    }
    
    public void setSize(String size) {
        this.size = size;
    }
}

class readFile() {
    
}

