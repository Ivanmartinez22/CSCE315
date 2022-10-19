package Project2;

import java.util.ArrayList;

class Manager{
    int manager_id;
    int employee_id;
    public Manager(int manager_id, int employee_id){
        this.manager_id = manager_id;
        this.employee_id = employee_id;
    }
}

class Server{
    int employee_id;
    int pin_code;
    String fname;
    String lname;
    public Server(int employee_id, int pin_code, String fname, String lname){
        this.employee_id = employee_id;
        this.pin_code = pin_code;
        this.fname = fname;
        this.lname = lname;
    }
}

class Item{
    int item_id;
    String Description;
    float store_cost;
    float menu_cost;
    int number_available;

    public Item(int item_id, String Description, float store_cost, float menu_cost, int number_available){
        this.item_id = item_id;
        this.Description = Description;
        this.store_cost = store_cost;
        this.menu_cost = menu_cost;
        this.number_available = number_available;
    }
}

class Menu_Item{
    int item_id;
    String Description;
    float store_cost;
    float menu_cost;
    ArrayList<Item> items_in_menu_item;
    public Menu_Item(int item_id, String Description, float store_cost, float menu_cost, ArrayList<Item> items_in_menu_item){
        this.item_id = item_id;
        this.Description = Description;
        this.store_cost = store_cost;
        this.menu_cost = menu_cost;
        this.items_in_menu_item = items_in_menu_item;
    }
}

class Order{
    ArrayList<Item> items_in_order;
    int total_cost;
    int transaction_number;
    public Order(ArrayList<Item> items_in_order, int total_cost, int transaction_number){
        this.items_in_order = items_in_order;
        this.total_cost = total_cost;
        this.transaction_number = transaction_number;
    }
}

class Inventory{
    ArrayList<Item> items_of_inventory;
}



class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!"); 
    }
}








