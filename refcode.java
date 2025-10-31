import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class MenuItem {
    protected String name;
    protected double price;

    public MenuItem(String name, double price) {
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

class AppsAndStarters extends MenuItem {
    private boolean isShareable;
    
    public AppsAndStarters(String name, double price, boolean isShareable) {
        super(name, price);
        this.isShareable = isShareable;
    }
    
    public boolean getIsShareable() {
        return isShareable;
    }
    
    public void setIsShareable(boolean isShareable) {
        this.isShareable = isShareable;
    }
}

class MainCourses extends MenuItem {
    private double prepTime;
    
    public MainCourses(String name, double price, double prepTime) {
        super(name, price);
        this.prepTime = prepTime;
    }
    
    public double getPrepTime() {
        return prepTime;
    }
    
    public void setPrepTime(double prepTime) {
        this.prepTime = prepTime;
    }
}

class Desserts extends MenuItem {
    private String dessertType;
    private boolean isShareable;
    
    public Desserts(String name, double price, String dessertType, boolean isShareable) {
        super(name, price);   
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

class Beverages extends MenuItem {
    private boolean isAlcoholic;
    private String size;
    
    public Beverages(String name, double price, boolean isAlcoholic, String size) {
        super(name, price);    
        this.isAlcoholic = isAlcoholic;
        this.size = size;
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

class MenuFileReader {
    private static final String BASE_PATH = "C:\\Users\\Deanna\\Desktop\\perpro\\java\\shoppingcart\\menuitemFiles\\";
    
    public static List<AppsAndStarters> readAppetizersFromFile() {
        List<AppsAndStarters> appetizers = new ArrayList<>();
        File file = new File(BASE_PATH + "appetizers.txt");

        if (!file.exists()) {
            System.out.println("Appetizers file not found at: " + file.getAbsolutePath());
            return appetizers;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String name = scanner.nextLine().trim();
                if (name.isEmpty()) continue;
                
                if (!scanner.hasNextLine()) {
                    System.out.println("Warning: Incomplete data for appetizer: " + name);
                    break;
                }
                String priceStr = scanner.nextLine().trim();
                
                if (!scanner.hasNextLine()) {
                    System.out.println("Warning: Missing shareable flag for appetizer: " + name);
                    break;
                }
                String shareableStr = scanner.nextLine().trim();
                
                try {
                    double price = Double.parseDouble(priceStr);
                    boolean isShareable = Boolean.parseBoolean(shareableStr);
                    
                    AppsAndStarters item = new AppsAndStarters(name, price, isShareable);
                    appetizers.add(item);
                    
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing data for appetizer: " + name);
                }
            }
            System.out.println("Successfully loaded " + appetizers.size() + " appetizers.");
            
        } catch (FileNotFoundException e) {
            System.out.println("Error reading appetizers file: " + e.getMessage());
        }
        
        return appetizers;
    }
    
    public static List<MainCourses> readMainCoursesFromFile() {
        List<MainCourses> mainCourses = new ArrayList<>();
        File file = new File(BASE_PATH + "maincourses.txt");

        if (!file.exists()) {
            System.out.println("Main courses file not found at: " + file.getAbsolutePath());
            return mainCourses;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String name = scanner.nextLine().trim();
                if (name.isEmpty()) continue;
                
                if (!scanner.hasNextLine()) {
                    System.out.println("Warning: Incomplete data for main course: " + name);
                    break;
                }
                String priceStr = scanner.nextLine().trim();
                
                if (!scanner.hasNextLine()) {
                    System.out.println("Warning: Missing prep time for main course: " + name);
                    break;
                }
                String prepTimeStr = scanner.nextLine().trim();
                
                try {
                    double price = Double.parseDouble(priceStr);
                    double prepTime = Double.parseDouble(prepTimeStr);
                    
                    MainCourses item = new MainCourses(name, price, prepTime);
                    mainCourses.add(item);
                    
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing data for main course: " + name);
                }
            }
            System.out.println("Successfully loaded " + mainCourses.size() + " main courses.");
            
        } catch (FileNotFoundException e) {
            System.out.println("Error reading main courses file: " + e.getMessage());
        }
        
        return mainCourses;
    }
    
    public static List<Desserts> readDessertsFromFile() {
        List<Desserts> desserts = new ArrayList<>();
        File file = new File(BASE_PATH + "desserts.txt");

        if (!file.exists()) {
            System.out.println("Desserts file not found at: " + file.getAbsolutePath());
            return desserts;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String name = scanner.nextLine().trim();
                if (name.isEmpty()) continue;
                
                if (!scanner.hasNextLine()) {
                    System.out.println("Warning: Incomplete data for dessert: " + name);
                    break;
                }
                String priceStr = scanner.nextLine().trim();
                
                if (!scanner.hasNextLine()) {
                    System.out.println("Warning: Missing dessert type for: " + name);
                    break;
                }
                String dessertType = scanner.nextLine().trim();
                
                if (!scanner.hasNextLine()) {
                    System.out.println("Warning: Missing shareable flag for dessert: " + name);
                    break;
                }
                String shareableStr = scanner.nextLine().trim();
                
                try {
                    double price = Double.parseDouble(priceStr);
                    boolean isShareable = Boolean.parseBoolean(shareableStr);
                    
                    Desserts item = new Desserts(name, price, dessertType, isShareable);
                    desserts.add(item);
                    
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing data for dessert: " + name);
                }
            }
            System.out.println("Successfully loaded " + desserts.size() + " desserts.");
            
        } catch (FileNotFoundException e) {
            System.out.println("Error reading desserts file: " + e.getMessage());
        }
        
        return desserts;
    }
    
    public static List<Beverages> readBeveragesFromFile() {
        List<Beverages> beverages = new ArrayList<>();
        File file = new File(BASE_PATH + "beverages.txt");

        if (!file.exists()) {
            System.out.println("Beverages file not found at: " + file.getAbsolutePath());
            return beverages;
        }

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String name = scanner.nextLine().trim();
                if (name.isEmpty()) continue;
                
                if (!scanner.hasNextLine()) {
                    System.out.println("Warning: Incomplete data for beverage: " + name);
                    break;
                }
                String priceStr = scanner.nextLine().trim();
                
                if (!scanner.hasNextLine()) {
                    System.out.println("Warning: Missing alcoholic flag for beverage: " + name);
                    break;
                }
                String alcoholicStr = scanner.nextLine().trim();
                
                if (!scanner.hasNextLine()) {
                    System.out.println("Warning: Missing size for beverage: " + name);
                    break;
                }
                String size = scanner.nextLine().trim();
                
                try {
                    double price = Double.parseDouble(priceStr);
                    boolean isAlcoholic = Boolean.parseBoolean(alcoholicStr);
                    
                    Beverages item = new Beverages(name, price, isAlcoholic, size);
                    beverages.add(item);
                    
                } catch (NumberFormatException e) {
                    System.out.println("Error parsing data for beverage: " + name);
                }
            }
            System.out.println("Successfully loaded " + beverages.size() + " beverages.");
            
        } catch (FileNotFoundException e) {
            System.out.println("Error reading beverages file: " + e.getMessage());
        }
        
        return beverages;
    }
}

public class refcode {
    public static void main(String[] args) {
        System.out.println("=== RESTAURANT MENU SYSTEM ===\n");
        
        // Read all menu items
        List<AppsAndStarters> appetizers = MenuFileReader.readAppetizersFromFile();
        List<MainCourses> mainCourses = MenuFileReader.readMainCoursesFromFile();
        List<Desserts> desserts = MenuFileReader.readDessertsFromFile();
        List<Beverages> beverages = MenuFileReader.readBeveragesFromFile();
        
        // Display appetizers
        System.out.println("\n=== APPETIZERS ===");
        if (appetizers.isEmpty()) {
            System.out.println("No appetizers available.");
        } else {
            for (AppsAndStarters item : appetizers) {
                System.out.printf("Name: %s, Price: %.2f PHP, Shareable: %s%n", 
                    item.getName(), item.getPrice(), item.getIsShareable());
            }
        }
        
        // Display main courses
        System.out.println("\n=== MAIN COURSES ===");
        if (mainCourses.isEmpty()) {
            System.out.println("No main courses available.");
        } else {
            for (MainCourses item : mainCourses) {
                System.out.printf("Name: %s, Price: %.2f PHP, Prep Time: %.1f mins%n", 
                    item.getName(), item.getPrice(), item.getPrepTime());
            }
        }
        
        // Display desserts
        System.out.println("\n=== DESSERTS ===");
        if (desserts.isEmpty()) {
            System.out.println("No desserts available.");
        } else {
            for (Desserts item : desserts) {
                System.out.printf("Name: %s, Price: %.2f PHP, Type: %s, Shareable: %s%n", 
                    item.getName(), item.getPrice(), item.getDessertType(), item.getIsShareable());
            }
        }
        
        // Display beverages
        System.out.println("\n=== BEVERAGES ===");
        if (beverages.isEmpty()) {
            System.out.println("No beverages available.");
        } else {
            for (Beverages item : beverages) {
                System.out.printf("Name: %s, Price: %.2f PHP, Alcoholic: %s, Size: %s%n", 
                    item.getName(), item.getPrice(), item.getIsAlcoholic(), item.getSize());
            }
        }
        
        System.out.println("\n=== SYSTEM READY ===");
    }
}