
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



class ManagerGenerator{
    int manager_id;
    int employee_id;

    public ManagerGenerator(int manager_id, int employee_id){
        this.manager_id = manager_id;
        this.employee_id = employee_id;
    }
}

class ServerGenerator{
    int employee_id;
    int pin_code;
    String fname;
    String lname;
    public ServerGenerator(){
        int employee_id = 0;
        int pin_code = 0;
        String fname = "";
        String lnmae = "";
    }
    public ServerGenerator(int employee_id, int pin_code, String fname, String lname){
        this.employee_id = employee_id;
        this.pin_code = pin_code;
        this.fname = fname;
        this.lname = lname;
    }
}

class ItemGenerator{
    int item_id;
    String Description;
    double store_cost;
    double menu_cost;
    int number_available;
    boolean selected = false;

    public ItemGenerator(){
        int item_id = 0;
        String Description = "";
        double store_cost = 0.0;
        double menu_cost = 0.0;
        int number_available = 0;
    }
    public ItemGenerator(int item_id, String Description, double store_cost, double menu_cost, int number_available){
        this.item_id = item_id;
        this.Description = Description;
        this.store_cost = store_cost;
        this.menu_cost = menu_cost;
        this.number_available = number_available;

    }
}

class Menu_ItemGenerator{
    int item_id;
    String Description;
    double store_cost;
    double menu_cost;
    ArrayList<ItemGenerator> items_in_menu_item;
    public Menu_ItemGenerator(){
        int item_id = 0;
        String Description = "";
        double store_cost = 0.00;
        double menu_cost = 0.00;
        ArrayList<ItemGenerator> items_in_menu_item = new ArrayList<ItemGenerator>();
    }
    public Menu_ItemGenerator(int item_id, String Description, double store_cost, double menu_cost, ArrayList<ItemGenerator> items_in_menu_item){
        this.item_id = item_id;
        this.Description = Description;
        this.store_cost = store_cost;
        this.menu_cost = menu_cost;
        this.items_in_menu_item = items_in_menu_item;
    }
}

class Order{
    ArrayList<ItemGenerator> menu_items;
    ArrayList<ItemGenerator> add_ons;
    double total_cost;
    double cost_from_menu;
    int transaction_number;
    Calendar transaction_date;
    ServerGenerator server;
    public Order(){
        // ArrayList<Item> menu_items = new ArrayList<Item>();
        // ArrayList<Item> add_ons = new ArrayList<Item>();
        // int total_cost = 0;
        // long transaction_number = 0; 
    }
    public Order(ArrayList<ItemGenerator> menu_selection, ArrayList<ItemGenerator> add_ons, double cost_from_menu, int transaction_number, Calendar transaction_date){
        this.menu_items = menu_selection;
        this.add_ons = add_ons;
        this.cost_from_menu = cost_from_menu;
        this.transaction_number = transaction_number;
        this.transaction_date = transaction_date;
    }
    public Order makeOrder(int transaction_number, ArrayList<Menu_ItemGenerator> selections, ArrayList<ItemGenerator> addons, ServerGenerator theServer, Calendar transaction_date){
        ArrayList<ItemGenerator> menu_items = new ArrayList<ItemGenerator>();
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
    ArrayList<ItemGenerator> items_of_inventory;
}


class Main {
    static Order make_random_order(int transaction_number, ArrayList<ArrayList<Menu_ItemGenerator>> selections, ArrayList<ArrayList<ItemGenerator>> addons, ArrayList<ServerGenerator> Servers, ArrayList<ItemGenerator> cheeses, ArrayList<ItemGenerator> patties, ArrayList<ItemGenerator> sauces, Calendar transaction_date){
        // ArrayList<ArrayList<Menu_Item>> menu_items_storage = new ArrayList<ArrayList<Menu_Item>>();
        // menu_items_storage.addAll(selections);
        // ArrayList<ArrayList<Item>> addons_storage = new ArrayList<ArrayList<Item>>();
        // addons_storage.addAll(addons);
        ArrayList<ItemGenerator> selected_addons = new ArrayList<ItemGenerator>();
        ArrayList<ItemGenerator> menu_items = new ArrayList<ItemGenerator>();
        double total_menu_items_cost = 0;

        int index = new Random().nextInt(Servers.size());
        ServerGenerator server = Servers.get(index);
        int number_of_options = new Random().nextInt(selections.size());
        number_of_options += 1;
        for(int i = 0; i < number_of_options; i++){
            int first_position = new Random().nextInt(selections.size());
            int second_position = new Random().nextInt(selections.get(first_position).size());
            //System.out.println(selections.get(first_position).get(second_position).Description + " menu item");
            total_menu_items_cost += selections.get(first_position).get(second_position).menu_cost;
            boolean stop_adding_chicken = false;
            ItemGenerator cheese_type = new ItemGenerator();
            ItemGenerator patty_type = new ItemGenerator();
            ItemGenerator sauce_type = new ItemGenerator();
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
        ServerGenerator server1 = new ServerGenerator(529006731, 6789, "Ivan", "Martinez");
        //Server2
        ServerGenerator server2 = new ServerGenerator(928006887, 1234, "Xavier", "Garza");
        //Server3
        ServerGenerator server3 = new ServerGenerator(229000879, 3333, "Brandon", "Nguyen");
        //Server4
        ServerGenerator server4 = new ServerGenerator(928006235, 5687, "Binh", "Do-Cao");
        ArrayList<ServerGenerator> Servers = new ArrayList<ServerGenerator>();
        Servers.add(server1);
        Servers.add(server2);
        Servers.add(server3);
        Servers.add(server4);
        //Burger indregients and add ons 
        //Also for salad - bacon 
        ItemGenerator patty = new ItemGenerator(0, "patty", 0.00, 0.00, 0);
        ItemGenerator beef_patty = new ItemGenerator(1, "beef", 0.00, 3.29, 1);
        ItemGenerator chipotle_meat = new ItemGenerator(2, "chipotle", 0.00, 3.29, 1);

        ItemGenerator bacon = new ItemGenerator(3, "bacon", 0.00, 1.35, 1);
        ItemGenerator avocado = new ItemGenerator(4, "avocado", 0.00, 1.25, 1);

        //Cheese for burgers and sandwiches
        ItemGenerator cheese = new ItemGenerator(0, "cheese", 0.00, 0.00, 0); 
        ItemGenerator american_cheese = new ItemGenerator(5, "american cheese", 0.00, 0.60, 1);
        ItemGenerator cheddar_cheese = new ItemGenerator(6, "cheddar cheese", 0.00, 0.60, 1);
        ItemGenerator pepperjeck_cheese = new ItemGenerator(7, "pepperjack cheese", 0.00, 0.60, 1);
        ItemGenerator swiss_cheese = new ItemGenerator(8, "swiss cheese", 0.00, 0.60, 1);

        //Burger ingredients
        ItemGenerator lettuce = new ItemGenerator(9, "lettuce", 0.00, 0.00, 1);
        ItemGenerator tomatoes = new ItemGenerator(10, "tomatoes", 0.00, 0.00, 1);
        ItemGenerator onions = new ItemGenerator(11, "onions", 0.00, 0.00, 1);
        ItemGenerator pickles = new ItemGenerator(12, "pickles", 0.00, 0.00, 1);

        //Condiments
        ItemGenerator ketchup = new ItemGenerator(13, "ketchup", 0.00, 0.00, 1);
        ItemGenerator mayo = new ItemGenerator(14, "mayo", 0.00, 0.00, 1);
        ItemGenerator mustard = new ItemGenerator(15, "mustard", 0.00, 0.00, 1);

        //Bread for burgers and sandwiches 
        ItemGenerator burger_buns = new ItemGenerator(16, "buns", 0.00, 0.00, 1);
        ItemGenerator texas_toast_slices = new ItemGenerator(17, "texas toast", 0.00, 0.00, 1);

        //Sides and beverages 
        ItemGenerator french_fries = new ItemGenerator(18, "french fries", 0.00, 1.89, 1);
        ItemGenerator tater_tots = new ItemGenerator(19, "tater tots", 0.00, 1.99, 1);
        ItemGenerator fountain_drink = new ItemGenerator(20, "fountain drink", 0.00, 2.19, 1);

        //Chicken sandwich and salad ingredients 
        ItemGenerator grilled_chicken_breast = new ItemGenerator(21, "grilled chicken", 0.00, 0.00, 1); 
        ItemGenerator fried_chicken_breast = new ItemGenerator(22, "crispy chicken", 0.00, 0.00, 1);

        //Chicken tender basket ingredient
        ItemGenerator chicken_tenders = new ItemGenerator(23, "chicken tenders", 0.00, 1.00, 1);
        ItemGenerator sauce = new ItemGenerator(0, "sauce", 0.00, 0.00, 0);
        ItemGenerator ranch_sauce = new ItemGenerator(24, "ranch", 0.00, 0.00, 1);
        ItemGenerator bbq_sauce = new ItemGenerator(25, "bbq sauce", 0.00, 0.00, 1);
        ItemGenerator honey_mustard_sauce = new ItemGenerator(26, "honey mustard", 0.00, 0.00, 1);
        ItemGenerator spicey_ranch_sauce = new ItemGenerator(27, "spicey ranch", 0.00, 0.00, 1);
        ItemGenerator gleem_sauce = new ItemGenerator(28, "gig em sauce", 0.00, 0.00, 1);

        //Salad ingredients 
        ItemGenerator leafy_greens = new ItemGenerator(29, "lettuce", 0.00, 0.00, 1); //lettuce? onions? carrots?
        ItemGenerator croutons = new ItemGenerator(30, "croutons", 0.00, 0.00, 1);
        ItemGenerator chicken_bacon = new ItemGenerator(31, "chicken bacon", 0.00, 0.00, 1);
        ItemGenerator shredded_cheddar = new ItemGenerator(32, "shredded cheddar", 0.00, 0.00, 1);
        ItemGenerator grape_tomatoes = new ItemGenerator(33, "grape tomatoes", 0.00, 0.00, 1);
        ItemGenerator carrots = new ItemGenerator(34, "carrots", 0.00, 0.00, 1);
        ItemGenerator caesar_dressing = new ItemGenerator(35, "ceasar dressing", 0.00, 0.00, 1);
        ItemGenerator hard_boiled_egg = new ItemGenerator(36, "hard boiled eggs", 0.00, 0.00, 1);
        ItemGenerator cucumber = new ItemGenerator(37, "cucumber", 0.00, 0.00, 1);

        //Menu ItemGenerators 
        ArrayList<ItemGenerator> Hamburger_Ingredients = new ArrayList<ItemGenerator>();
        Hamburger_Ingredients.add(burger_buns);
        Hamburger_Ingredients.add(patty);
        Hamburger_Ingredients.add(lettuce);
        Hamburger_Ingredients.add(onions);
        Hamburger_Ingredients.add(tomatoes);
        Menu_ItemGenerator Hamburger = new Menu_ItemGenerator(1, "Hamburger", 0.00, 5.09, Hamburger_Ingredients);

        ArrayList<ItemGenerator> Cheeseburger_Ingredients = new ArrayList<ItemGenerator>();
        Cheeseburger_Ingredients.addAll(Hamburger_Ingredients);
        Cheeseburger_Ingredients.add(cheese);
        Menu_ItemGenerator Cheeseburger = new Menu_ItemGenerator(2, "Cheeseburger", 0, 5.59, Cheeseburger_Ingredients);

        ArrayList<ItemGenerator> BaconCheeseburger_Ingredients = new ArrayList<ItemGenerator>();
        BaconCheeseburger_Ingredients.addAll(Cheeseburger_Ingredients);
        BaconCheeseburger_Ingredients.add(bacon);
        Menu_ItemGenerator Bacon_Cheeseburger = new Menu_ItemGenerator(3, "Bacon Cheeseburger", 0, 6.79, BaconCheeseburger_Ingredients);

        ArrayList<ItemGenerator> DoubleCheeseburger_Ingredients = new ArrayList<ItemGenerator>();
        DoubleCheeseburger_Ingredients.addAll(Cheeseburger_Ingredients);
        DoubleCheeseburger_Ingredients.add(cheese);
        DoubleCheeseburger_Ingredients.add(patty);
        Menu_ItemGenerator Double_Cheeseburger = new Menu_ItemGenerator(4, "Double Cheeseburger", 0, 8.59, Cheeseburger_Ingredients);


        ArrayList<ItemGenerator> GrilledCheese_Ingredients = new ArrayList<ItemGenerator>();
        GrilledCheese_Ingredients.add(texas_toast_slices);
        GrilledCheese_Ingredients.add(patty);
        Menu_ItemGenerator Grilled_Cheese = new Menu_ItemGenerator(5, "Grilled Cheese", 0, 3.49, Cheeseburger_Ingredients);

        ArrayList<ItemGenerator> French_Fries_list = new ArrayList<ItemGenerator>();
        French_Fries_list.add(french_fries);
        Menu_ItemGenerator French_Fries = new Menu_ItemGenerator(6, "Fench Fries", 0, 1.89, French_Fries_list);

        ArrayList<ItemGenerator> Tater_tots_list = new ArrayList<ItemGenerator>();
        Tater_tots_list.add(tater_tots);
        Menu_ItemGenerator Tater_Tots = new Menu_ItemGenerator(7, "Tater Tots", 0, 1.99, Tater_tots_list);

        ArrayList<ItemGenerator> Grilled_Chicken_Sandwich_Ingredients = new ArrayList<ItemGenerator>();
        Grilled_Chicken_Sandwich_Ingredients.add(burger_buns);
        Grilled_Chicken_Sandwich_Ingredients.add(grilled_chicken_breast);
        Grilled_Chicken_Sandwich_Ingredients.add(cheese);
        Menu_ItemGenerator Grilled_Chicken_Sandwich = new Menu_ItemGenerator(8, "Grilled Chicken Sandwich", 0, 5.59, Grilled_Chicken_Sandwich_Ingredients  );

        ArrayList<ItemGenerator> Crispy_Chicken_Sandwich_Ingredients = new ArrayList<ItemGenerator>();
        Crispy_Chicken_Sandwich_Ingredients.add(burger_buns);
        Crispy_Chicken_Sandwich_Ingredients.add(fried_chicken_breast);
        Menu_ItemGenerator Crispy_Chicken_Sandwich = new Menu_ItemGenerator(9, "Crispy Chicken Sandwich", 0, 5.59, Crispy_Chicken_Sandwich_Ingredients  );

        ArrayList<ItemGenerator> Aggie_Chicken_Club_Ingredients = new ArrayList<ItemGenerator>();
        Aggie_Chicken_Club_Ingredients.add(burger_buns);
        Aggie_Chicken_Club_Ingredients.add(grilled_chicken_breast);
        Aggie_Chicken_Club_Ingredients.add(bacon);
        Aggie_Chicken_Club_Ingredients.add(cheese);
        Aggie_Chicken_Club_Ingredients.add(avocado);
        Menu_ItemGenerator  Aggie_Chicken_Club = new Menu_ItemGenerator(10, "Aggie Chicken Club", 0, 6.99, Aggie_Chicken_Club_Ingredients  );

        ArrayList<ItemGenerator> Tender_Basket_Ingredients = new ArrayList<ItemGenerator>();
        Tender_Basket_Ingredients.add(chicken_tenders);
        Tender_Basket_Ingredients.add(chicken_tenders);
        Tender_Basket_Ingredients.add(chicken_tenders);
        Tender_Basket_Ingredients.add(sauce);
        Menu_ItemGenerator Tender_Basket = new Menu_ItemGenerator(11, "Tender Basket", 0, 5.99, Tender_Basket_Ingredients);

        ArrayList<ItemGenerator> Chicken_Caesar_Salad_Ingredients = new ArrayList<ItemGenerator>();
        Chicken_Caesar_Salad_Ingredients.add(leafy_greens);
        Chicken_Caesar_Salad_Ingredients.add(grilled_chicken_breast);
        Chicken_Caesar_Salad_Ingredients.add(croutons);
        Chicken_Caesar_Salad_Ingredients.add(caesar_dressing);
        Menu_ItemGenerator Chicken_Caesar_Salad = new Menu_ItemGenerator(12, "Chicken Caesar Salad", 0, 7.29, Chicken_Caesar_Salad_Ingredients);

        ArrayList<ItemGenerator> Chicken_Bacon_Ranch_Salad_Ingredients = new ArrayList<ItemGenerator>();
        Chicken_Bacon_Ranch_Salad_Ingredients.add(leafy_greens);
        Chicken_Bacon_Ranch_Salad_Ingredients.add(chicken_bacon);
        Chicken_Bacon_Ranch_Salad_Ingredients.add(croutons);
        Chicken_Bacon_Ranch_Salad_Ingredients.add(ranch_sauce);
        Chicken_Bacon_Ranch_Salad_Ingredients.add(shredded_cheddar);
        Chicken_Bacon_Ranch_Salad_Ingredients.add(grape_tomatoes);
        Chicken_Bacon_Ranch_Salad_Ingredients.add(carrots);
        Menu_ItemGenerator Chicken_Bacon_Ranch = new Menu_ItemGenerator(13, "Chicken Caesar Salad", 0, 7.29, Chicken_Bacon_Ranch_Salad_Ingredients);

        ArrayList<ItemGenerator> Cobb_Salad_Ingredients = new ArrayList<ItemGenerator>();
        Cobb_Salad_Ingredients.add(leafy_greens);
        Cobb_Salad_Ingredients.add(hard_boiled_egg);
        Cobb_Salad_Ingredients.add(croutons);
        Cobb_Salad_Ingredients.add(bacon);
        Cobb_Salad_Ingredients.add(grape_tomatoes);
        Cobb_Salad_Ingredients.add(carrots);
        Menu_ItemGenerator Cobb_Salad = new Menu_ItemGenerator(14, "Cobb Salad", 0, 6.49, Cobb_Salad_Ingredients);

        ArrayList<ItemGenerator> Fountain_drink_list = new ArrayList<ItemGenerator>();
        Fountain_drink_list.add(fountain_drink);
        Menu_ItemGenerator Fountain = new Menu_ItemGenerator(15, "Fountain Drink", 0, 2.19, Fountain_drink_list);

        //System.out.println(Fountain.Description);

        ArrayList<Menu_ItemGenerator> Burgers = new ArrayList<Menu_ItemGenerator>();
        Burgers.add(Hamburger);
        Burgers.add(Cheeseburger);
        Burgers.add(Double_Cheeseburger);
        Burgers.add(Bacon_Cheeseburger);
        Burgers.add(Grilled_Cheese);

        ArrayList<ItemGenerator> addons_burgers = new ArrayList<ItemGenerator>(); // add drop down menu for addons and for general types 
        addons_burgers.add(patty);
        addons_burgers.add(cheese);
        addons_burgers.add(bacon);
        addons_burgers.add(avocado);
        addons_burgers.add(french_fries);
        addons_burgers.add(tater_tots);
        //addons_burgers.add(fountain_drink);

        ArrayList<Menu_ItemGenerator> Sides = new ArrayList<Menu_ItemGenerator>();
        Sides.add(French_Fries);
        Sides.add(Tater_Tots);


        ArrayList<Menu_ItemGenerator> Chicken_Sandwiches = new ArrayList<Menu_ItemGenerator>();
        Chicken_Sandwiches.add(Grilled_Chicken_Sandwich);
        Chicken_Sandwiches.add(Crispy_Chicken_Sandwich);
        Chicken_Sandwiches.add(Aggie_Chicken_Club);


        ArrayList<ItemGenerator> addons_chicken_sandwiches = new ArrayList<ItemGenerator>();
        addons_chicken_sandwiches.add(french_fries);
        addons_chicken_sandwiches.add(tater_tots);
        //addons_chicken_sandwiches.add(fountain_drink);

        ArrayList<Menu_ItemGenerator> Salads = new ArrayList<Menu_ItemGenerator>();
        Salads.add(Cobb_Salad);
        Salads.add(Chicken_Bacon_Ranch);
        Salads.add(Chicken_Caesar_Salad);

        ArrayList<Menu_ItemGenerator> drink = new ArrayList<Menu_ItemGenerator>();
        drink.add(Fountain);

        ArrayList<Menu_ItemGenerator> tenders = new ArrayList<Menu_ItemGenerator>();
        tenders.add(Tender_Basket);

        ArrayList<ItemGenerator> addons_tenders = new ArrayList<ItemGenerator>();
        addons_tenders.addAll(addons_chicken_sandwiches);
        addons_tenders.add(chicken_tenders);

        ArrayList<ItemGenerator> cheeses = new ArrayList<ItemGenerator>();
        cheeses.add(american_cheese);
        cheeses.add(cheddar_cheese);
        cheeses.add(pepperjeck_cheese);
        cheeses.add(swiss_cheese);

        ArrayList<ItemGenerator> patties = new ArrayList<ItemGenerator>();
        patties.add(beef_patty);
        patties.add(chipotle_meat);

        ArrayList<ItemGenerator> sauces = new ArrayList<ItemGenerator>();
        sauces.add(bbq_sauce);
        sauces.add(ranch_sauce);
        sauces.add(honey_mustard_sauce);
        sauces.add(spicey_ranch_sauce);
        sauces.add(gleem_sauce);

        addons_tenders.addAll(sauces);


        ArrayList<ArrayList<Menu_ItemGenerator>> menu_items = new ArrayList<ArrayList<Menu_ItemGenerator>>();
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

        ArrayList<ArrayList<ItemGenerator>> addons = new ArrayList<ArrayList<ItemGenerator>>();
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


