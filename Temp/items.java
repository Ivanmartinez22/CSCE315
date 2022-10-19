
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Collections;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors



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
    public Server(){
        int employee_id = 0;
        int pin_code = 0;
        String fname = "";
        String lnmae = "";
    }
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
    double store_cost;
    double menu_cost;
    int number_available;
    boolean selected = false;

    public Item(){
        int item_id = 0;
        String Description = "";
        double store_cost = 0.0;
        double menu_cost = 0.0;
        int number_available = 0;
    }
    public Item(int item_id, String Description, double store_cost, double menu_cost, int number_available){
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
    double store_cost;
    double menu_cost;
    ArrayList<Item> items_in_menu_item;
    public Menu_Item(){
        int item_id = 0;
        String Description = "";
        double store_cost = 0.00;
        double menu_cost = 0.00;
        ArrayList<Item> items_in_menu_item = new ArrayList<Item>();
    }
    public Menu_Item(int item_id, String Description, double store_cost, double menu_cost, ArrayList<Item> items_in_menu_item){
        this.item_id = item_id;
        this.Description = Description;
        this.store_cost = store_cost;
        this.menu_cost = menu_cost;
        this.items_in_menu_item = items_in_menu_item;
    }
}

// class ItemStorage {
//     ArrayList<Server> servers_array;
//     ArrayList<ArrayList<Menu_Item>> menu_items_array;
//     ArrayList<ArrayList<Item>> addon_items_array;
//     ArrayList<Item> patties_array;
//     ArrayList<Item> cheeses_array;
//     ArrayList<Item> sauces_array;
//     public ItemStorage(){
//         //Server1
//         Server server1 = new Server(529006731, 6789, "Ivan", "Martinez");
//         //Server2
//         Server server2 = new Server(928006887, 1234, "Xavier", "Garza");
//         //Server3
//         Server server3 = new Server(229000879, 3333, "Brandon", "Nguyen");
//         //Server4
//         Server server4 = new Server(928006235, 5687, "Binh", "Do-Cao");
//         ArrayList<Server> Servers = new ArrayList<Server>();
//         Servers.add(server1);
//         Servers.add(server2);
//         Servers.add(server3);
//         Servers.add(server4);
//         //Burger indregients and add ons 
//         //Also for salad - bacon 
//         Item patty = new Item(0, "patty", 0.00, 0.00, 0);
//         Item beef_patty = new Item(1, "Beef Patty", 0.00, 3.29, 1);
//         Item chipotle_meat = new Item(2, "Chipotle Meat", 0.00, 3.29, 1);

//         Item bacon = new Item(3, "Bacon", 0.00, 1.35, 1);
//         Item avocado = new Item(4, "Avacado", 0.00, 1.25, 1);

//         //Cheese for burgers and sandwiches
//         Item cheese = new Item(0, "cheese", 0.00, 0.00, 0); 
//         Item american_cheese = new Item(5, "American Cheese", 0.00, 0.60, 1);
//         Item cheddar_cheese = new Item(6, "Cheddar Cheese", 0.00, 0.60, 1);
//         Item pepperjeck_cheese = new Item(7, "Pepperjack Cheese", 0.00, 0.60, 1);
//         Item swiss_cheese = new Item(8, "Swiss Cheese", 0.00, 0.60, 1);

//         //Burger ingredients
//         Item lettuce = new Item(9, "Lettuce", 0.00, 0.00, 1);
//         Item tomatoes = new Item(10, "Tomatoes", 0.00, 0.00, 1);
//         Item onions = new Item(11, "Onions", 0.00, 0.00, 1);
//         Item pickles = new Item(12, "Pickles", 0.00, 0.00, 1);

//         //Condiments
//         Item ketchup = new Item(13, "Ketchup", 0.00, 0.00, 1);
//         Item mayo = new Item(14, "Mayo", 0.00, 0.00, 1);
//         Item mustard = new Item(15, "Mustard", 0.00, 0.00, 1);

//         //Bread for burgers and sandwiches 
//         Item burger_buns = new Item(16, "Burger Buns", 0.00, 0.00, 1);
//         Item texas_toast_slices = new Item(17, "Texas Toast", 0.00, 0.00, 1);

//         //Sides and beverages 
//         Item french_fries = new Item(18, "French Fries", 0.00, 1.89, 1);
//         Item tater_tots = new Item(19, "Tater Tots", 0.00, 1.99, 1);
//         Item fountain_drink = new Item(20, "Fountain Drink", 0.00, 2.19, 1);

//         //Chicken sandwich and salad ingredients 
//         Item grilled_chicken_breast = new Item(21, "Grilled Chicken Breast", 0.00, 0.00, 1); 
//         Item fried_chicken_breast = new Item(22, "Fried Chicken Breast", 0.00, 0.00, 1);

//         //Chicken tender basket ingredient
//         Item chicken_tenders = new Item(23, "Chicken Tenders", 0.00, 1.00, 1);
//         Item sauce = new Item(0, "sauce", 0.00, 0.00, 0);
//         Item ranch_sauce = new Item(24, "Ranch Sauce", 0.00, 0.00, 1);
//         Item bbq_sauce = new Item(25, "BBQ Sauce", 0.00, 0.00, 1);
//         Item honey_mustard_sauce = new Item(26, "Honey Mustard Sauce", 0.00, 0.00, 1);
//         Item spicey_ranch_sauce = new Item(27, "Spicey Ranch Sauce", 0.00, 0.00, 1);
//         Item gleem_sauce = new Item(28, "Gle'em Sauce", 0.00, 0.00, 1);

//         //Salad ingredients 
//         Item leafy_greens = new Item(29, "Leafy Greens", 0.00, 0.00, 1); //lettuce? onions? carrots?
//         Item croutons = new Item(30, "Croutons", 0.00, 0.00, 1);
//         Item chicken_bacon = new Item(31, "Chicken Bacon", 0.00, 0.00, 1);
//         Item shredded_cheddar = new Item(32, "Shredded Cheddar", 0.00, 0.00, 1);
//         Item grape_tomatoes = new Item(33, "Grape Tomatoes", 0.00, 0.00, 1);
//         Item carrots = new Item(34, "Carrots", 0.00, 0.00, 1);
//         Item caesar_dressing = new Item(35, "Ceasar Dressing", 0.00, 0.00, 1);
//         Item hard_boiled_egg = new Item(36, "Hard Boiled Eggs", 0.00, 0.00, 1);
//         Item cucumber = new Item(37, "Cucumber", 0.00, 0.00, 1);

//         //Menu Items 
//         ArrayList<Item> Hamburger_Ingredients = new ArrayList<Item>();
//         Hamburger_Ingredients.add(burger_buns);
//         Hamburger_Ingredients.add(patty);
//         Hamburger_Ingredients.add(lettuce);
//         Hamburger_Ingredients.add(onions);
//         Hamburger_Ingredients.add(tomatoes);
//         Menu_Item Hamburger = new Menu_Item(1, "Hamburger", 0.00, 5.09, Hamburger_Ingredients);

//         ArrayList<Item> Cheeseburger_Ingredients = new ArrayList<Item>();
//         Cheeseburger_Ingredients.addAll(Hamburger_Ingredients);
//         Cheeseburger_Ingredients.add(cheese);
//         Menu_Item Cheeseburger = new Menu_Item(2, "Cheeseburger", 0, 5.59, Cheeseburger_Ingredients);

//         ArrayList<Item> BaconCheeseburger_Ingredients = new ArrayList<Item>();
//         BaconCheeseburger_Ingredients.addAll(Cheeseburger_Ingredients);
//         BaconCheeseburger_Ingredients.add(bacon);
//         Menu_Item Bacon_Cheeseburger = new Menu_Item(3, "Bacon Cheeseburger", 0, 6.79, BaconCheeseburger_Ingredients);

//         ArrayList<Item> DoubleCheeseburger_Ingredients = new ArrayList<Item>();
//         DoubleCheeseburger_Ingredients.addAll(Cheeseburger_Ingredients);
//         DoubleCheeseburger_Ingredients.add(cheese);
//         DoubleCheeseburger_Ingredients.add(patty);
//         Menu_Item Double_Cheeseburger = new Menu_Item(4, "Double Cheeseburger", 0, 8.59, Cheeseburger_Ingredients);


//         ArrayList<Item> GrilledCheese_Ingredients = new ArrayList<Item>();
//         GrilledCheese_Ingredients.add(texas_toast_slices);
//         GrilledCheese_Ingredients.add(patty);
//         Menu_Item Grilled_Cheese = new Menu_Item(5, "Grilled Cheese", 0, 3.49, Cheeseburger_Ingredients);

//         ArrayList<Item> French_Fries_list = new ArrayList<Item>();
//         French_Fries_list.add(french_fries);
//         Menu_Item French_Fries = new Menu_Item(6, "Fench Fries", 0, 1.89, French_Fries_list);

//         ArrayList<Item> Tater_tots_list = new ArrayList<Item>();
//         Tater_tots_list.add(tater_tots);
//         Menu_Item Tater_Tots = new Menu_Item(7, "Tater Tots", 0, 1.99, Tater_tots_list);

//         ArrayList<Item> Grilled_Chicken_Sandwich_Ingredients = new ArrayList<Item>();
//         Grilled_Chicken_Sandwich_Ingredients.add(burger_buns);
//         Grilled_Chicken_Sandwich_Ingredients.add(grilled_chicken_breast);
//         Grilled_Chicken_Sandwich_Ingredients.add(cheese);
//         Menu_Item Grilled_Chicken_Sandwich = new Menu_Item(8, "Grilled Chicken Sandwich", 0, 5.59, Grilled_Chicken_Sandwich_Ingredients  );

//         ArrayList<Item> Crispy_Chicken_Sandwich_Ingredients = new ArrayList<Item>();
//         Crispy_Chicken_Sandwich_Ingredients.add(burger_buns);
//         Crispy_Chicken_Sandwich_Ingredients.add(fried_chicken_breast);
//         Menu_Item Crispy_Chicken_Sandwich = new Menu_Item(9, "Crispy Chicken Sandwich", 0, 5.59, Crispy_Chicken_Sandwich_Ingredients  );

//         ArrayList<Item> Aggie_Chicken_Club_Ingredients = new ArrayList<Item>();
//         Aggie_Chicken_Club_Ingredients.add(burger_buns);
//         Aggie_Chicken_Club_Ingredients.add(grilled_chicken_breast);
//         Aggie_Chicken_Club_Ingredients.add(bacon);
//         Aggie_Chicken_Club_Ingredients.add(cheese);
//         Aggie_Chicken_Club_Ingredients.add(avocado);
//         Menu_Item  Aggie_Chicken_Club = new Menu_Item(10, "Aggie Chicken Club", 0, 6.99, Aggie_Chicken_Club_Ingredients  );

//         ArrayList<Item> Tender_Basket_Ingredients = new ArrayList<Item>();
//         Tender_Basket_Ingredients.add(chicken_tenders);
//         Tender_Basket_Ingredients.add(chicken_tenders);
//         Tender_Basket_Ingredients.add(chicken_tenders);
//         Tender_Basket_Ingredients.add(sauce);
//         Menu_Item Tender_Basket = new Menu_Item(11, "Tender Basket", 0, 5.99, Tender_Basket_Ingredients);

//         ArrayList<Item> Chicken_Caesar_Salad_Ingredients = new ArrayList<Item>();
//         Chicken_Caesar_Salad_Ingredients.add(leafy_greens);
//         Chicken_Caesar_Salad_Ingredients.add(grilled_chicken_breast);
//         Chicken_Caesar_Salad_Ingredients.add(croutons);
//         Chicken_Caesar_Salad_Ingredients.add(caesar_dressing);
//         Menu_Item Chicken_Caesar_Salad = new Menu_Item(12, "Chicken Caesar Salad", 0, 7.29, Chicken_Caesar_Salad_Ingredients);

//         ArrayList<Item> Chicken_Bacon_Ranch_Salad_Ingredients = new ArrayList<Item>();
//         Chicken_Bacon_Ranch_Salad_Ingredients.add(leafy_greens);
//         Chicken_Bacon_Ranch_Salad_Ingredients.add(chicken_bacon);
//         Chicken_Bacon_Ranch_Salad_Ingredients.add(croutons);
//         Chicken_Bacon_Ranch_Salad_Ingredients.add(ranch_sauce);
//         Chicken_Bacon_Ranch_Salad_Ingredients.add(shredded_cheddar);
//         Chicken_Bacon_Ranch_Salad_Ingredients.add(grape_tomatoes);
//         Chicken_Bacon_Ranch_Salad_Ingredients.add(carrots);
//         Menu_Item Chicken_Bacon_Ranch = new Menu_Item(13, "Chicken Caesar Salad", 0, 7.29, Chicken_Bacon_Ranch_Salad_Ingredients);

//         ArrayList<Item> Cobb_Salad_Ingredients = new ArrayList<Item>();
//         Cobb_Salad_Ingredients.add(leafy_greens);
//         Cobb_Salad_Ingredients.add(hard_boiled_egg);
//         Cobb_Salad_Ingredients.add(croutons);
//         Cobb_Salad_Ingredients.add(bacon);
//         Cobb_Salad_Ingredients.add(grape_tomatoes);
//         Cobb_Salad_Ingredients.add(carrots);
//         Menu_Item Cobb_Salad = new Menu_Item(14, "Cobb Salad", 0, 6.49, Cobb_Salad_Ingredients);

//         ArrayList<Item> Fountain_drink_list = new ArrayList<Item>();
//         Fountain_drink_list.add(fountain_drink);
//         Menu_Item Fountain = new Menu_Item(15, "Fountain Drink", 0, 2.19, Fountain_drink_list);

//         //System.out.println(Fountain.Description);

//         ArrayList<Menu_Item> Burgers = new ArrayList<Menu_Item>();
//         Burgers.add(Hamburger);
//         Burgers.add(Cheeseburger);
//         Burgers.add(Double_Cheeseburger);
//         Burgers.add(Bacon_Cheeseburger);
//         Burgers.add(Grilled_Cheese);

//         ArrayList<Item> addons_burgers = new ArrayList<Item>(); // add drop down menu for addons and for general types 
//         addons_burgers.add(patty);
//         addons_burgers.add(cheese);
//         addons_burgers.add(bacon);
//         addons_burgers.add(avocado);
//         addons_burgers.add(french_fries);
//         addons_burgers.add(tater_tots);
//         //addons_burgers.add(fountain_drink);

//         ArrayList<Menu_Item> Sides = new ArrayList<Menu_Item>();
//         Sides.add(French_Fries);
//         Sides.add(Tater_Tots);


//         ArrayList<Menu_Item> Chicken_Sandwiches = new ArrayList<Menu_Item>();
//         Chicken_Sandwiches.add(Grilled_Chicken_Sandwich);
//         Chicken_Sandwiches.add(Crispy_Chicken_Sandwich);
//         Chicken_Sandwiches.add(Aggie_Chicken_Club);


//         ArrayList<Item> addons_chicken_sandwiches = new ArrayList<Item>();
//         addons_chicken_sandwiches.add(french_fries);
//         addons_chicken_sandwiches.add(tater_tots);
//         //addons_chicken_sandwiches.add(fountain_drink);

//         ArrayList<Menu_Item> Salads = new ArrayList<Menu_Item>();
//         Salads.add(Cobb_Salad);
//         Salads.add(Chicken_Bacon_Ranch);
//         Salads.add(Chicken_Caesar_Salad);

//         ArrayList<Menu_Item> drink = new ArrayList<Menu_Item>();
//         drink.add(Fountain);

//         ArrayList<Menu_Item> tenders = new ArrayList<Menu_Item>();
//         tenders.add(Tender_Basket);

//         ArrayList<Item> addons_tenders = new ArrayList<Item>();
//         addons_tenders.addAll(addons_chicken_sandwiches);
//         addons_tenders.add(chicken_tenders);

//         ArrayList<Item> cheeses = new ArrayList<Item>();
//         cheeses.add(american_cheese);
//         cheeses.add(cheddar_cheese);
//         cheeses.add(pepperjeck_cheese);
//         cheeses.add(swiss_cheese);

//         ArrayList<Item> patties = new ArrayList<Item>();
//         patties.add(beef_patty);
//         patties.add(chipotle_meat);

//         ArrayList<Item> sauces = new ArrayList<Item>();
//         sauces.add(bbq_sauce);
//         sauces.add(ranch_sauce);
//         sauces.add(honey_mustard_sauce);
//         sauces.add(spicey_ranch_sauce);
//         sauces.add(gleem_sauce);

//         addons_tenders.addAll(sauces);


//         ArrayList<ArrayList<Menu_Item>> menu_items = new ArrayList<ArrayList<Menu_Item>>();
//         menu_items.add(Burgers);
//         menu_items.add(Chicken_Sandwiches);
//         menu_items.add(tenders);
//         menu_items.add(Salads);
//         menu_items.add(Sides);
//         menu_items.add(drink);

//         ArrayList<ArrayList<Item>> addons = new ArrayList<ArrayList<Item>>();
//         addons.add(addons_burgers);
//         addons.add(addons_chicken_sandwiches);
//         addons.add(addons_tenders);
//         addons.add(Fountain_drink_list);



//         this.menu_items_array = menu_items;
//         this.addon_items_array = addons;
//         this.cheeses_array = cheeses;
//         this.patties_array = patties;
//         this.sauces_array = sauces;
//         this.servers_array = Servers;
//     }
// }

class Order{
    ArrayList<Item> menu_items;
    ArrayList<Item> add_ons;
    double total_cost;
    double cost_from_menu;
    int transaction_number;
    Calendar transaction_date;
    Server server;
    public Order(){
        // ArrayList<Item> menu_items = new ArrayList<Item>();
        // ArrayList<Item> add_ons = new ArrayList<Item>();
        // int total_cost = 0;
        // long transaction_number = 0; 
    }
    public Order(ArrayList<Item> menu_selection, ArrayList<Item> add_ons, double cost_from_menu, int transaction_number, Calendar transaction_date){
        this.menu_items = menu_selection;
        this.add_ons = add_ons;
        this.cost_from_menu = cost_from_menu;
        this.transaction_number = transaction_number;
        this.transaction_date = transaction_date;
    }
    public Order makeOrder(int transaction_number, ArrayList<Menu_Item> selections, ArrayList<Item> addons, Server theServer, Calendar transaction_date){
        ArrayList<Item> menu_items = new ArrayList<Item>();
        double total_menu_items_cost = 0.00;
        for(int i = 0; i < selections.size(); i++){
            menu_items.addAll(selections.get(i).items_in_menu_item);
            total_menu_items_cost += selections.get(i).menu_cost;
        }
        Order current_Order = new Order(menu_items, addons, total_menu_items_cost, transaction_number, transaction_date);
        current_Order.server = theServer;
        return current_Order;
    }
    public void calcualte_total_cost(){
        total_cost = cost_from_menu;
        for(int i = 0; i < add_ons.size(); i++){
            total_cost += add_ons.get(i).menu_cost;
        }
    }
    public String OrderWriteUp(){
        String output = String.valueOf(transaction_number);
        output += ";"; 
        output += String.valueOf(server.employee_id);
        output += ";"; 
        output += "{";
        for(int i = 0; i < menu_items.size(); i++){
            output += menu_items.get(i).Description;
            output += ",";
        }
        // System.out.println("");
        for(int i = 0; i < add_ons.size(); i++){
            output += add_ons.get(i).Description;
            output += ",";
        }
        output += "}";
        output += ";";
        calcualte_total_cost();
        output += String.valueOf(total_cost);
        output += ";";

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");


        String date_string = sdf.format(transaction_date.getTime());
        output += date_string;
        output = output.replace(",}", "}");

        // System.out.println(output);
        return output;

    }
    public String Header(){
        String output = "order_id";
        output += ";"; 
        output += "employee_id";
        output += ";"; 
        output += "order_items";
        output += ";";
        output += "cost";
        output += ";";
        output += "order_time";

        // System.out.println(output);
        return output;

    }
}

class Inventory{
    ArrayList<Item> items_of_inventory;
}


class Main {
    static Order make_random_order(int transaction_number, ArrayList<ArrayList<Menu_Item>> selections, ArrayList<ArrayList<Item>> addons, ArrayList<Server> Servers, ArrayList<Item> cheeses, ArrayList<Item> patties, ArrayList<Item> sauces, Calendar transaction_date){
        // ArrayList<ArrayList<Menu_Item>> menu_items_storage = new ArrayList<ArrayList<Menu_Item>>();
        // menu_items_storage.addAll(selections);
        // ArrayList<ArrayList<Item>> addons_storage = new ArrayList<ArrayList<Item>>();
        // addons_storage.addAll(addons);
        ArrayList<Item> selected_addons = new ArrayList<Item>();
        ArrayList<Item> menu_items = new ArrayList<Item>();
        double total_menu_items_cost = 0;

        int index = new Random().nextInt(Servers.size());
        Server server = Servers.get(index);
        int number_of_options = new Random().nextInt(selections.size());
        number_of_options += 1;
        for(int i = 0; i < number_of_options; i++){
            int first_position = new Random().nextInt(selections.size());
            int second_position = new Random().nextInt(selections.get(first_position).size());
            //System.out.println(selections.get(first_position).get(second_position).Description + " menu item");
            total_menu_items_cost += selections.get(first_position).get(second_position).menu_cost;
            boolean stop_adding_chicken = false;
            Item cheese_type = new Item();
            Item patty_type = new Item();
            Item sauce_type = new Item();
            // Collections.shuffle(cheeses);
            // Collections.shuffle(patties);
            // Collections.shuffle(sauces);
            for(int j = 0; j < selections.get(first_position).get(second_position).items_in_menu_item.size(); j++){
                if(selections.get(first_position).get(second_position).items_in_menu_item.get(j).Description == "cheese"){
                    index = new Random().nextInt(cheeses.size());
                    selections.get(first_position).get(second_position).items_in_menu_item.set(j, cheeses.get(index));
                    cheese_type = cheeses.get(index);
                }
                else if(selections.get(first_position).get(second_position).items_in_menu_item.get(j).Description == "patty"){
                    index = new Random().nextInt(patties.size());
                    selections.get(first_position).get(second_position).items_in_menu_item.set(j, patties.get(index));
                    patty_type = patties.get(index);
                }
                else if(selections.get(first_position).get(second_position).items_in_menu_item.get(j).Description == "sauce"){
                    index = new Random().nextInt(sauces.size());
                    selections.get(first_position).get(second_position).items_in_menu_item.set(j, sauces.get(index));
                    sauce_type = sauces.get(index);
                }
            }
            int get_drink = new Random().nextInt(10);
            get_drink += 1;
            if(get_drink <= 8 ){
                selected_addons.add(addons.get(8).get(0));
            }
            menu_items.addAll(selections.get(first_position).get(second_position).items_in_menu_item);


            if(first_position <= 8){
                int num = new Random().nextInt(2);
                int number_of_addons = 0;
                if(num == 1){
                    number_of_addons = new Random().nextInt(addons.get(first_position).size()+1);
                }
                //System.out.println(first_position);
                if(number_of_addons != 0){
                    for(int k = 0; k < addons.get(first_position).size(); k++){
                        if(addons.get(first_position).get(k).Description == "cheese"){
                            addons.get(first_position).set(k, cheese_type);
                        }
                        else if(addons.get(first_position).get(k).Description == "patty"){
                            addons.get(first_position).set(k, patty_type);
                        }
                        else if(addons.get(first_position).get(k).Description == "sauce"){
                            addons.get(first_position).set(k, sauce_type);
                        }
                    }


                    for(int l = 0; l < addons.size(); l++){
                        int addon_index = new Random().nextInt(addons.get(first_position).size());
                        if(addons.get(first_position).get(addon_index).Description != null){
                            if(!addons.get(first_position).get(addon_index).selected){
                                addons.get(first_position).get(addon_index).selected = true;
                                selected_addons.add(addons.get(first_position).get(addon_index));
                            }

                        }
                    }


                }
            }


        }



        Calendar start_date = Calendar.getInstance();
        start_date.set(2022,9,12);
        Order current_Order = new Order(menu_items, selected_addons, total_menu_items_cost, transaction_number, transaction_date);
        current_Order.server = server;
        return current_Order;
    }

    // static Order make_order(int transaction_number, ArrayList<Menu_Item> selections, ArrayList<Item> addons, Server theServer, Calendar transaction_date){
    //     ArrayList<Item> menu_items = new ArrayList<Item>();
    //     double total_menu_items_cost = 0.00;
    //     for(int i = 0; i < selections.size(); i++){
    //         // for(int j = 0; j < selections.get(i).items_in_menu_item.size(); j++){

    //         // }
    //         menu_items.addAll(selections.get(i).items_in_menu_item);
    //         total_menu_items_cost += selections.get(i).menu_cost;
    //     }
    //     Order current_Order = new Order(menu_items, addons, total_menu_items_cost, transaction_number, transaction_date);
    //     current_Order.server = theServer;
    //     return current_Order;
    // }


    public static void main(String[] args) {

        //Server1
        Server server1 = new Server(529006731, 6789, "Ivan", "Martinez");
        //Server2
        Server server2 = new Server(928006887, 1234, "Xavier", "Garza");
        //Server3
        Server server3 = new Server(229000879, 3333, "Brandon", "Nguyen");
        //Server4
        Server server4 = new Server(928006235, 5687, "Binh", "Do-Cao");
        ArrayList<Server> Servers = new ArrayList<Server>();
        Servers.add(server1);
        Servers.add(server2);
        Servers.add(server3);
        Servers.add(server4);
        //Burger indregients and add ons 
        //Also for salad - bacon 
        Item patty = new Item(0, "patty", 0.00, 0.00, 0);
        Item beef_patty = new Item(1, "beef", 0.00, 3.29, 1);
        Item chipotle_meat = new Item(2, "chipotle", 0.00, 3.29, 1);

        Item bacon = new Item(3, "bacon", 0.00, 1.35, 1);
        Item avocado = new Item(4, "avocado", 0.00, 1.25, 1);

        //Cheese for burgers and sandwiches
        Item cheese = new Item(0, "cheese", 0.00, 0.00, 0); 
        Item american_cheese = new Item(5, "american cheese", 0.00, 0.60, 1);
        Item cheddar_cheese = new Item(6, "cheddar cheese", 0.00, 0.60, 1);
        Item pepperjeck_cheese = new Item(7, "pepperjack cheese", 0.00, 0.60, 1);
        Item swiss_cheese = new Item(8, "swiss cheese", 0.00, 0.60, 1);

        //Burger ingredients
        Item lettuce = new Item(9, "lettuce", 0.00, 0.00, 1);
        Item tomatoes = new Item(10, "tomatoes", 0.00, 0.00, 1);
        Item onions = new Item(11, "onions", 0.00, 0.00, 1);
        Item pickles = new Item(12, "pickles", 0.00, 0.00, 1);

        //Condiments
        Item ketchup = new Item(13, "ketchup", 0.00, 0.00, 1);
        Item mayo = new Item(14, "mayo", 0.00, 0.00, 1);
        Item mustard = new Item(15, "mustard", 0.00, 0.00, 1);

        //Bread for burgers and sandwiches 
        Item burger_buns = new Item(16, "buns", 0.00, 0.00, 1);
        Item texas_toast_slices = new Item(17, "texas toast", 0.00, 0.00, 1);

        //Sides and beverages 
        Item french_fries = new Item(18, "french fries", 0.00, 1.89, 1);
        Item tater_tots = new Item(19, "tater tots", 0.00, 1.99, 1);
        Item fountain_drink = new Item(20, "fountain drink", 0.00, 2.19, 1);

        //Chicken sandwich and salad ingredients 
        Item grilled_chicken_breast = new Item(21, "grilled chicken", 0.00, 0.00, 1); 
        Item fried_chicken_breast = new Item(22, "crispy chicken", 0.00, 0.00, 1);

        //Chicken tender basket ingredient
        Item chicken_tenders = new Item(23, "chicken tenders", 0.00, 1.00, 1);
        Item sauce = new Item(0, "sauce", 0.00, 0.00, 0);
        Item ranch_sauce = new Item(24, "ranch", 0.00, 0.00, 1);
        Item bbq_sauce = new Item(25, "bbq sauce", 0.00, 0.00, 1);
        Item honey_mustard_sauce = new Item(26, "honey mustard", 0.00, 0.00, 1);
        Item spicey_ranch_sauce = new Item(27, "spicey ranch", 0.00, 0.00, 1);
        Item gleem_sauce = new Item(28, "gig em sauce", 0.00, 0.00, 1);

        //Salad ingredients 
        Item leafy_greens = new Item(29, "lettuce", 0.00, 0.00, 1); //lettuce? onions? carrots?
        Item croutons = new Item(30, "croutons", 0.00, 0.00, 1);
        Item chicken_bacon = new Item(31, "chicken bacon", 0.00, 0.00, 1);
        Item shredded_cheddar = new Item(32, "shredded cheddar", 0.00, 0.00, 1);
        Item grape_tomatoes = new Item(33, "grape tomatoes", 0.00, 0.00, 1);
        Item carrots = new Item(34, "carrots", 0.00, 0.00, 1);
        Item caesar_dressing = new Item(35, "ceasar dressing", 0.00, 0.00, 1);
        Item hard_boiled_egg = new Item(36, "hard boiled eggs", 0.00, 0.00, 1);
        Item cucumber = new Item(37, "cucumber", 0.00, 0.00, 1);

        //Menu Items 
        ArrayList<Item> Hamburger_Ingredients = new ArrayList<Item>();
        Hamburger_Ingredients.add(burger_buns);
        Hamburger_Ingredients.add(patty);
        Hamburger_Ingredients.add(lettuce);
        Hamburger_Ingredients.add(onions);
        Hamburger_Ingredients.add(tomatoes);
        Menu_Item Hamburger = new Menu_Item(1, "Hamburger", 0.00, 5.09, Hamburger_Ingredients);

        ArrayList<Item> Cheeseburger_Ingredients = new ArrayList<Item>();
        Cheeseburger_Ingredients.addAll(Hamburger_Ingredients);
        Cheeseburger_Ingredients.add(cheese);
        Menu_Item Cheeseburger = new Menu_Item(2, "Cheeseburger", 0, 5.59, Cheeseburger_Ingredients);

        ArrayList<Item> BaconCheeseburger_Ingredients = new ArrayList<Item>();
        BaconCheeseburger_Ingredients.addAll(Cheeseburger_Ingredients);
        BaconCheeseburger_Ingredients.add(bacon);
        Menu_Item Bacon_Cheeseburger = new Menu_Item(3, "Bacon Cheeseburger", 0, 6.79, BaconCheeseburger_Ingredients);

        ArrayList<Item> DoubleCheeseburger_Ingredients = new ArrayList<Item>();
        DoubleCheeseburger_Ingredients.addAll(Cheeseburger_Ingredients);
        DoubleCheeseburger_Ingredients.add(cheese);
        DoubleCheeseburger_Ingredients.add(patty);
        Menu_Item Double_Cheeseburger = new Menu_Item(4, "Double Cheeseburger", 0, 8.59, Cheeseburger_Ingredients);


        ArrayList<Item> GrilledCheese_Ingredients = new ArrayList<Item>();
        GrilledCheese_Ingredients.add(texas_toast_slices);
        GrilledCheese_Ingredients.add(patty);
        Menu_Item Grilled_Cheese = new Menu_Item(5, "Grilled Cheese", 0, 3.49, Cheeseburger_Ingredients);

        ArrayList<Item> French_Fries_list = new ArrayList<Item>();
        French_Fries_list.add(french_fries);
        Menu_Item French_Fries = new Menu_Item(6, "Fench Fries", 0, 1.89, French_Fries_list);

        ArrayList<Item> Tater_tots_list = new ArrayList<Item>();
        Tater_tots_list.add(tater_tots);
        Menu_Item Tater_Tots = new Menu_Item(7, "Tater Tots", 0, 1.99, Tater_tots_list);

        ArrayList<Item> Grilled_Chicken_Sandwich_Ingredients = new ArrayList<Item>();
        Grilled_Chicken_Sandwich_Ingredients.add(burger_buns);
        Grilled_Chicken_Sandwich_Ingredients.add(grilled_chicken_breast);
        Grilled_Chicken_Sandwich_Ingredients.add(cheese);
        Menu_Item Grilled_Chicken_Sandwich = new Menu_Item(8, "Grilled Chicken Sandwich", 0, 5.59, Grilled_Chicken_Sandwich_Ingredients  );

        ArrayList<Item> Crispy_Chicken_Sandwich_Ingredients = new ArrayList<Item>();
        Crispy_Chicken_Sandwich_Ingredients.add(burger_buns);
        Crispy_Chicken_Sandwich_Ingredients.add(fried_chicken_breast);
        Menu_Item Crispy_Chicken_Sandwich = new Menu_Item(9, "Crispy Chicken Sandwich", 0, 5.59, Crispy_Chicken_Sandwich_Ingredients  );

        ArrayList<Item> Aggie_Chicken_Club_Ingredients = new ArrayList<Item>();
        Aggie_Chicken_Club_Ingredients.add(burger_buns);
        Aggie_Chicken_Club_Ingredients.add(grilled_chicken_breast);
        Aggie_Chicken_Club_Ingredients.add(bacon);
        Aggie_Chicken_Club_Ingredients.add(cheese);
        Aggie_Chicken_Club_Ingredients.add(avocado);
        Menu_Item  Aggie_Chicken_Club = new Menu_Item(10, "Aggie Chicken Club", 0, 6.99, Aggie_Chicken_Club_Ingredients  );

        ArrayList<Item> Tender_Basket_Ingredients = new ArrayList<Item>();
        Tender_Basket_Ingredients.add(chicken_tenders);
        Tender_Basket_Ingredients.add(chicken_tenders);
        Tender_Basket_Ingredients.add(chicken_tenders);
        Tender_Basket_Ingredients.add(sauce);
        Menu_Item Tender_Basket = new Menu_Item(11, "Tender Basket", 0, 5.99, Tender_Basket_Ingredients);

        ArrayList<Item> Chicken_Caesar_Salad_Ingredients = new ArrayList<Item>();
        Chicken_Caesar_Salad_Ingredients.add(leafy_greens);
        Chicken_Caesar_Salad_Ingredients.add(grilled_chicken_breast);
        Chicken_Caesar_Salad_Ingredients.add(croutons);
        Chicken_Caesar_Salad_Ingredients.add(caesar_dressing);
        Menu_Item Chicken_Caesar_Salad = new Menu_Item(12, "Chicken Caesar Salad", 0, 7.29, Chicken_Caesar_Salad_Ingredients);

        ArrayList<Item> Chicken_Bacon_Ranch_Salad_Ingredients = new ArrayList<Item>();
        Chicken_Bacon_Ranch_Salad_Ingredients.add(leafy_greens);
        Chicken_Bacon_Ranch_Salad_Ingredients.add(chicken_bacon);
        Chicken_Bacon_Ranch_Salad_Ingredients.add(croutons);
        Chicken_Bacon_Ranch_Salad_Ingredients.add(ranch_sauce);
        Chicken_Bacon_Ranch_Salad_Ingredients.add(shredded_cheddar);
        Chicken_Bacon_Ranch_Salad_Ingredients.add(grape_tomatoes);
        Chicken_Bacon_Ranch_Salad_Ingredients.add(carrots);
        Menu_Item Chicken_Bacon_Ranch = new Menu_Item(13, "Chicken Caesar Salad", 0, 7.29, Chicken_Bacon_Ranch_Salad_Ingredients);

        ArrayList<Item> Cobb_Salad_Ingredients = new ArrayList<Item>();
        Cobb_Salad_Ingredients.add(leafy_greens);
        Cobb_Salad_Ingredients.add(hard_boiled_egg);
        Cobb_Salad_Ingredients.add(croutons);
        Cobb_Salad_Ingredients.add(bacon);
        Cobb_Salad_Ingredients.add(grape_tomatoes);
        Cobb_Salad_Ingredients.add(carrots);
        Menu_Item Cobb_Salad = new Menu_Item(14, "Cobb Salad", 0, 6.49, Cobb_Salad_Ingredients);

        ArrayList<Item> Fountain_drink_list = new ArrayList<Item>();
        Fountain_drink_list.add(fountain_drink);
        Menu_Item Fountain = new Menu_Item(15, "Fountain Drink", 0, 2.19, Fountain_drink_list);

        //System.out.println(Fountain.Description);

        ArrayList<Menu_Item> Burgers = new ArrayList<Menu_Item>();
        Burgers.add(Hamburger);
        Burgers.add(Cheeseburger);
        Burgers.add(Double_Cheeseburger);
        Burgers.add(Bacon_Cheeseburger);
        Burgers.add(Grilled_Cheese);

        ArrayList<Item> addons_burgers = new ArrayList<Item>(); // add drop down menu for addons and for general types 
        addons_burgers.add(patty);
        addons_burgers.add(cheese);
        addons_burgers.add(bacon);
        addons_burgers.add(avocado);
        addons_burgers.add(french_fries);
        addons_burgers.add(tater_tots);
        //addons_burgers.add(fountain_drink);

        ArrayList<Menu_Item> Sides = new ArrayList<Menu_Item>();
        Sides.add(French_Fries);
        Sides.add(Tater_Tots);


        ArrayList<Menu_Item> Chicken_Sandwiches = new ArrayList<Menu_Item>();
        Chicken_Sandwiches.add(Grilled_Chicken_Sandwich);
        Chicken_Sandwiches.add(Crispy_Chicken_Sandwich);
        Chicken_Sandwiches.add(Aggie_Chicken_Club);


        ArrayList<Item> addons_chicken_sandwiches = new ArrayList<Item>();
        addons_chicken_sandwiches.add(french_fries);
        addons_chicken_sandwiches.add(tater_tots);
        //addons_chicken_sandwiches.add(fountain_drink);

        ArrayList<Menu_Item> Salads = new ArrayList<Menu_Item>();
        Salads.add(Cobb_Salad);
        Salads.add(Chicken_Bacon_Ranch);
        Salads.add(Chicken_Caesar_Salad);

        ArrayList<Menu_Item> drink = new ArrayList<Menu_Item>();
        drink.add(Fountain);

        ArrayList<Menu_Item> tenders = new ArrayList<Menu_Item>();
        tenders.add(Tender_Basket);

        ArrayList<Item> addons_tenders = new ArrayList<Item>();
        addons_tenders.addAll(addons_chicken_sandwiches);
        addons_tenders.add(chicken_tenders);

        ArrayList<Item> cheeses = new ArrayList<Item>();
        cheeses.add(american_cheese);
        cheeses.add(cheddar_cheese);
        cheeses.add(pepperjeck_cheese);
        cheeses.add(swiss_cheese);

        ArrayList<Item> patties = new ArrayList<Item>();
        patties.add(beef_patty);
        patties.add(chipotle_meat);

        ArrayList<Item> sauces = new ArrayList<Item>();
        sauces.add(bbq_sauce);
        sauces.add(ranch_sauce);
        sauces.add(honey_mustard_sauce);
        sauces.add(spicey_ranch_sauce);
        sauces.add(gleem_sauce);

        addons_tenders.addAll(sauces);


        ArrayList<ArrayList<Menu_Item>> menu_items = new ArrayList<ArrayList<Menu_Item>>();
        menu_items.add(Burgers);
        menu_items.add(Burgers);
        menu_items.add(Burgers);
        menu_items.add(Burgers);
        menu_items.add(Chicken_Sandwiches);
        menu_items.add(Chicken_Sandwiches);
        menu_items.add(tenders);
        menu_items.add(tenders);
        menu_items.add(Salads);
        menu_items.add(Sides);
        menu_items.add(drink);

        ArrayList<ArrayList<Item>> addons = new ArrayList<ArrayList<Item>>();
        addons.add(addons_burgers);
        addons.add(addons_burgers);
        addons.add(addons_burgers);
        addons.add(addons_burgers);
        addons.add(addons_chicken_sandwiches);
        addons.add(addons_chicken_sandwiches);
        addons.add(addons_tenders);
        addons.add(addons_tenders);
        addons.add(Fountain_drink_list);
        addons.add(null);
        addons.add(null);


        ArrayList<String> football_dates = new ArrayList<String>();
        football_dates.add("09/03/2022");
        football_dates.add("09/10/2022");
        football_dates.add("09/17/2022");
        football_dates.add("09/24/2022");
        football_dates.add("10/01/2022");
        football_dates.add("10/08/2022");
        football_dates.add("10/22/2022");
        football_dates.add("10/29/2022");
        football_dates.add("11/5/2022");
        football_dates.add("11/12/2022");
        football_dates.add("11/19/2022");
        football_dates.add("11/26/2022");
        football_dates.add("12/03/2022");
        Calendar date = Calendar.getInstance();
        date.set(date.MONTH, 8);
        date.set(date.DATE, 12);
        date.set(date.YEAR, 2022);
        date.set(date.MINUTE, 0);

        // Calendar end_date = Calendar.getInstance();
        // end_date.set(date.MONTH, 9);
        // end_date.set(date.DATE, 3);
        // end_date.set(date.YEAR, 2022);
        // end_date.set(date.MINUTE, 0);
        ArrayList<String> orders_to_write = new ArrayList<String>();
        double total_revenue = 0.00;
        int transaction_num = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String date_string = sdf.format(date.getTime());
        Order myOrder = new Order();
        orders_to_write.add(myOrder.Header());
        int days = 0;
        while(days < 21){
            double daily_sales = 0.00;
            while(daily_sales < 2142.85){
                myOrder = make_random_order(transaction_num, menu_items, addons, Servers, cheeses, patties, sauces, date);
                String order_write_up = myOrder.OrderWriteUp();
                //System.out.println(daily_sales);
                boolean isGameDay = football_dates.contains(date_string);
                daily_sales += myOrder.total_cost;
                orders_to_write.add(order_write_up);
                transaction_num += 1;
                if(isGameDay){ // doubling of orders on game days 

                    myOrder = make_random_order(transaction_num, menu_items, addons, Servers, cheeses, patties, sauces, date);
                    order_write_up = myOrder.OrderWriteUp();
                    orders_to_write.add(order_write_up);
                    transaction_num += 1;
                }
            }

            date.add(Calendar.MINUTE, 1440);
            date_string = sdf.format(date.getTime());
            System.out.println(date_string);
            days += 1;

        }

        try{
            File myObj = new File("Sales_Data_Sheet.csv");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        }
        catch(IOException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();

        }

        try {
            FileWriter myWriter = new FileWriter("Sales_Data_Sheet.csv");
            for(int i = 0; i < orders_to_write.size(); i++){
                myWriter.write(orders_to_write.get(i) + "\n");
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

    }
}


