import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class MyBazaar {

    private List<Person> users;
    private List<Item> items;
    private List<Campaign> campaigns;
    private List<Order> orders;

    private int nextCustomerID = 1;
    private int nextItemID = 1;
    private static final SimpleDateFormat DATE_DOT = new SimpleDateFormat("dd.MM.yyyy");

    public MyBazaar(){
        users= new ArrayList<>();
        items= new ArrayList<>();
        campaigns= new ArrayList<>();
        orders= new ArrayList<>();
    }

    private Admin findAdminByName(String name){
        for(Person p: users){
            if(p instanceof Admin && p.getName().equals(name)){
                return (Admin) p;
            }
        }
        return null;
    }

    private Technician findTechByName(String name){
        for(Person p: users){
            if(p instanceof Technician && p.getName().equals(name)){
                return (Technician) p;
            }
        }
        return null;
    }

    private Person findEmployeeByName(String name) {
        for (Person p : users) {
            if ((p instanceof Admin || p instanceof Technician) &&
                    p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    private Customer findCustomerByID(int id) {
        for (Person p : users) {
            if (p instanceof Customer) {
                Customer c = (Customer) p;
                if (c.getCustomerID() == id) return c;
            }
        }
        return null;
    }

    private Item findItemByID(int id) {
        for (Item t : items) {
            if (t.getItemID() == id) return t;
        }
        return null;
    }

    private boolean isEmployee(Person p) {
        return (p instanceof Admin) || (p instanceof Technician);
    }

    private Campaign findCampaignForItem(Item item) {
        ItemType type = item.getItemType();
        Date now = new Date();
        for (Campaign c : campaigns) {
            if (c.getItemType() == type && c.isActive(now)) {
                return c;
            }
        }
        return null;
    }

    private Date parseDateDot(String text) {
        try {
            return DATE_DOT.parse(text);
        } catch (ParseException e) {
            return new Date();
        }
    }



    public void loadUsers(String usersFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(usersFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split("\\t+");
                String type = parts[0];

                if (type.equals("ADMIN")) {
                    String name = parts[1];
                    String email = parts[2];
                    String birthDate = parts[3];
                    double salary = Double.parseDouble(parts[4]);
                    String password = parts[5];
                    Admin admin = new Admin(name, email, birthDate, salary, password);
                    users.add(admin);

                } else if (type.equals("TECH")) {
                    String name = parts[1];
                    String email = parts[2];
                    String birthDate = parts[3];
                    double salary = Double.parseDouble(parts[4]);
                    boolean isSenior = parts[5].equals("1");
                    Technician tech = new Technician(name, email, birthDate, salary, isSenior);
                    users.add(tech);

                } else if (type.equals("CUSTOMER")) {
                    String name = parts[1];
                    String email = parts[2];
                    String birthDate = parts[3];
                    double balance = Double.parseDouble(parts[4]);
                    String password = parts[5];
                    Customer c = new Customer(nextCustomerID, name, email, birthDate, balance, password);
                    nextCustomerID++;
                    users.add(c);
                }
            }
        } catch (IOException e) {
            System.out.println("Error while reading users file: " + e.getMessage());
        }
    }


    public void loadItems(String itemsFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(itemsFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] p = line.split("\\t+");
                String type = p[0];

                Item item = null;

                switch (type) {
                    case "DESKTOP":
                        item = new Desktop(
                        nextItemID,
                                Double.parseDouble(p[1]),
                                1,
                                ItemType.DESKTOP,
                                p[2],
                                p[3],
                                Integer.parseInt(p[4]),
                                Integer.parseInt(p[5]),
                                p[6],
                                p[7],
                                Integer.parseInt(p[8]),
                                Integer.parseInt(p[9]),
                                p[10]

                        );
                        break;

                    case "LAPTOP":
                        item = new Laptop(
                                nextItemID,
                                Double.parseDouble(p[1]),
                                1,
                                ItemType.LAPTOP,
                                p[2],
                                p[3],
                                Integer.parseInt(p[4]),
                                Integer.parseInt(p[5]),
                                p[6],
                                p[7],
                                Integer.parseInt(p[8]),
                                Integer.parseInt(p[9]),
                                p[10].equals("1")
                        );
                        break;

                    case "TABLET":
                        item = new Tablet(
                                nextItemID,
                                Double.parseDouble(p[1]),
                                1,
                                ItemType.TABLET,
                                p[2],
                                p[3],
                                Integer.parseInt(p[4]),
                                Integer.parseInt(p[5]),
                                p[6],
                                p[7],
                                Integer.parseInt(p[8]),
                                Integer.parseInt(p[9]),
                                p[10]

                        );
                        break;

                    case "TV":
                        item = new TV(
                                nextItemID,
                                Double.parseDouble(p[1]),
                                1,
                                ItemType.TV,
                                p[2],
                                p[3],
                                Integer.parseInt(p[4]),
                                Integer.parseInt(p[5]),
                                Integer.parseInt(p[6])
                        );
                        break;

                    case "SMARTPHONE":
                        item = new SmartPhone(
                                nextItemID,
                                Double.parseDouble(p[1]),
                                1,
                                ItemType.SMARTPHONE,
                                p[2],
                                p[3],
                                Integer.parseInt(p[4]),
                                Integer.parseInt(p[5]),
                                p[6]
                        );
                        break;

                    case "BOOK":
                        List<String> authors = Arrays.asList(p[5].split(","));

                        item = new Book(
                                nextItemID,
                                Double.parseDouble(p[1]),
                                1,
                                ItemType.BOOK,
                                p[2],
                                p[3],
                                p[4],
                                authors,
                                Integer.parseInt(p[6])
                        );
                        break;

                    case "CDDVD":
                        List<String> songs = Arrays.asList(p[6].split(","));

                        item = new CDDVD(
                                nextItemID,
                                Double.parseDouble(p[1]),
                                1,
                                ItemType.CDDVD,
                                p[2],
                                p[3],
                                p[4],
                                p[5],
                                songs
                        );
                        break;

                    case "HAIRCARE":
                        item = new HairCare(
                                nextItemID,
                                Double.parseDouble(p[1]),
                                1,
                                ItemType.HAIRCARE,
                                p[2],
                                p[3],
                                p[4].equals("1"),
                                Integer.parseInt(p[5]),
                                Double.parseDouble(p[6]),
                                p[7].equals("1")
                        );
                        break;

                    case "SKINCARE":
                        item = new SkinCare(
                                nextItemID,
                                Double.parseDouble(p[1]),
                                1,
                                ItemType.HAIRCARE,
                                p[2],
                                p[3],
                                p[4].equals("1"),
                                Integer.parseInt(p[5]),
                                Double.parseDouble(p[6]),
                                p[7].equals("1")
                        );
                        break;

                    case "PERFUME":
                        item = new Perfume(
                                nextItemID,
                                Double.parseDouble(p[1]),
                                1,
                                ItemType.PERFUME,
                                p[2],
                                p[3],
                                p[4].equals("1"),
                                Integer.parseInt(p[5]),
                                Double.parseDouble(p[6]),
                                Integer.parseInt(p[7])
                        );
                        break;
                }

                if (item != null) {
                    items.add(item);
                    nextItemID++;
                }
            }

        } catch (IOException e) {
            System.out.println("Error while reading items file: " + e.getMessage());
        }

    }


    public void processCommands(String commandsFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(commandsFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;

                String[] parts = line.split("\\t+");
                String cmd = parts[0];

                switch (cmd) {
                    case "ADDCUSTOMER":
                        AddCustomer(parts);
                        break;
                    case "SHOWCUSTOMER":
                        ShowCustomer(parts);
                        break;
                    case "SHOWCUSTOMERS":
                        ShowCustomers(parts);
                        break;
                    case "SHOWADMININFO":
                        ShowAdminInfo(parts);
                        break;
                    case "CREATECAMPAIGN":
                        CreateCampaign(parts);
                        break;
                    case "ADDADMIN":
                        AddAdmin(parts);
                        break;
                    case "ADDTECH":
                        AddTech(parts);
                        break;
                    case "LISTITEM":
                        ListItem(parts);
                        break;
                    case "SHOWITEMSLOWONSTOCK":
                        ShowItemsLowOnStock(parts);
                        break;
                    case "SHOWVIP":
                        ShowVIP(parts);
                        break;
                    case "DISPITEMSOF":
                        DispItemsOf(parts);
                        break;
                    case "ADDITEM":
                        AddItem(parts);
                        break;
                    case "SHOWORDERS":
                        ShowOrders(parts);
                        break;
                    case "CHPASS":
                        ChangePassword(parts);
                        break;
                    case "DEPOSITMONEY":
                        DepositMoney(parts);
                        break;
                    case "SHOWCAMPAIGNS":
                        ShowCampaigns(parts);
                        break;
                    case "ADDTOCART":
                        AddToCart(parts);
                        break;
                    case "EMPTYCART":
                        EmptyCart(parts);
                        break;
                    case "ORDER":
                       Order(parts);
                        break;
                    default:

                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error while reading commands file: " + e.getMessage());
        }
    }



    private void AddCustomer(String[] parts) {

        String adminName = parts[1];
        Admin admin = findAdminByName(adminName);
        if (admin == null) {
            System.out.println("No admin person named " + adminName + " exists!");
            return;
        }

        String customerName = parts[2];
        String customerMail = parts[3];
        String birthDate = parts[4];
        double initialBalance = Double.parseDouble(parts[5]);
        String password = parts[6];

        Customer c = new Customer(nextCustomerID, customerName , customerMail , birthDate, initialBalance, password);
        nextCustomerID++;
        users.add(c);
    }


    private void ShowCustomer(String[] parts) {
        String adminName = parts[1];
        Admin admin = findAdminByName(adminName);

        if (admin == null) {
            System.out.println("No admin person named " + adminName + " exists!");
            return;
        }

        int customerID = Integer.parseInt(parts[2]);
        Customer c = findCustomerByID(customerID);
        if (c == null) {
            System.out.println("No customer with ID number " + customerID + " exists!");
            return;
        }

        System.out.println(c.toString());

    }


    private void ShowCustomers(String[] parts) {
        String adminName = parts[1];
        Admin admin = findAdminByName(adminName);

        if (admin == null) {
            System.out.println("No admin person named " + adminName + " exists!");
            return;
        }

        for (Person p : users) {
            if (p instanceof Customer) {
                Customer c = (Customer) p;
                System.out.println(c.toString());
            }
        }
    }


    private void ShowAdminInfo(String[] parts) {
        String adminName = parts[1];
        Admin admin = findAdminByName(adminName);

        if (admin == null) {
            System.out.println("No admin person named " + adminName + " exists!");
            return;
        }

        admin.displayPersonalData();

    }


    private void CreateCampaign(String[] parts) {
        String adminName = parts[1];
        Admin admin = findAdminByName(adminName);

        if (admin == null) {
            System.out.println("No admin person named " + adminName + " exists!");
            return;
        }

        Date start = parseDateDot(parts[2]);
        Date end = parseDateDot(parts[3]);
        String itemTypeStr = parts[4];
        double rate = Double.parseDouble(parts[5]);

        if (rate > Campaign.MAX_DISCOUNT_RATE) {
            System.out.println("Campaign was not created. Discount rate exceeds maximum rate of 50%.");
            return;
        }

        ItemType type;
        try {
            type = ItemType.valueOf(itemTypeStr);
        } catch (IllegalArgumentException e) {

            return;
        }


        for (Campaign c : campaigns) {
            if (c.getItemType() == type) {
                System.out.println("Campaign was not created. There is already an active campaign on " + itemTypeStr + ".");
                return;
            }
        }

        Campaign cmp = new Campaign(start, end, type, rate);
        campaigns.add(cmp);
    }


    private void AddAdmin(String[] parts) {
        String adminName = parts[1];
        Admin admin = findAdminByName(adminName);
        if (admin == null) {
            System.out.println("No admin person named " + adminName + " exists!");
            return;
        }

        String newAdminName = parts[2];
        String newAdminMail = parts[3];
        String newAdminBirthDate = parts[4];
        double newAdminSalary = Double.parseDouble(parts[5]);
        String newAdminPassword = parts[6];

        Admin newAdmin = new Admin(newAdminName, newAdminMail, newAdminBirthDate, newAdminSalary, newAdminPassword);
        users.add(newAdmin);
    }


    private void AddTech(String[] parts) {
        String adminName = parts[1];
        Admin admin = findAdminByName(adminName);
        if (admin == null) {
            System.out.println("No admin person named " + adminName + " exists!");
            return;
        }

        String newTechName = parts[2];
        String newTechMail = parts[3];
        String newTechBirthDate = parts[4];
        double newTechSalary = Double.parseDouble(parts[5]);
        boolean isSenior = parts[6].equals("1");

        Technician tech = new Technician(newTechName, newTechMail, newTechBirthDate, newTechSalary, isSenior);
        users.add(tech);
    }


    private void ListItem(String[] parts) {
        String name = parts[1];
        Person emp = findEmployeeByName(name);
        if (emp == null) {
            System.out.println("No admin or technician person named " + name + " exists!");
            return;
        }

        for (Item it : items) {
            System.out.println(it.toString());
            System.out.println("-----------------------");
        }
    }


    private void ShowItemsLowOnStock(String[] parts) {
        String name = parts[1];
        Person emp = findEmployeeByName(name);
        if (emp == null) {
            System.out.println("No admin or technician person named " + name + " exists!");
            return;
        }

        Integer maxStock = null;
        if (parts.length > 2) {
            maxStock = Integer.parseInt(parts[2]);
        }


        Map<String, Integer> stockMap = new LinkedHashMap<>();
        for (Item it : items) {
            int s = it.getStock();
            if (maxStock != null && s >= maxStock) {
                continue;
            }

            String typeName = it.getClass().getSimpleName();
            stockMap.put(typeName, stockMap.getOrDefault(typeName, 0) + s);
        }

        for (Map.Entry<String, Integer> e : stockMap.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }


    private void ShowVIP(String[] parts) {
        String name = parts[1];
        Person emp = findEmployeeByName(name);
        if (emp == null) {
            System.out.println("No admin or technician person named " + name + " exists!");
            return;
        }

        for (Person p : users) {
            if (p instanceof Customer) {
                Customer c = (Customer) p;
                if (c.getStatus() == CustomerStatus.GOLDEN) {
                    System.out.println(c.toString());
                }
            }
        }
    }


    private void DispItemsOf(String[] parts) {
        String techName = parts[1];
        Technician tech = findTechByName(techName);
        if (tech == null) {
            System.out.println("No technician person named " + techName + " exists!");
            return;
        }

        if (parts.length < 3) return;

        String[] typeTokens = parts[2].split(":");

        Set<String> requestedTypes = new HashSet<>();
        for (String t : typeTokens) {
            requestedTypes.add(t.trim().toUpperCase());
        }

        for (Item it : items) {
            String simpleNameUpper = it.getClass().getSimpleName().toUpperCase();
            if (requestedTypes.contains(simpleNameUpper)) {
                System.out.println(it.toString());
                System.out.println("-----------------------");
            }
        }
    }


    private void AddItem(String[] parts) {
        String techName = parts[1];
        Technician tech = findTechByName(techName);
        if (tech == null) {
            System.out.println("No technician person named " + techName + " exists!");
            return;
        }

        if (parts.length < 3) return;

        String[] token = parts[2].split(":");
        String itemTypeRaw = token[0].trim();
        String[] args = Arrays.copyOfRange(token, 1, token.length);

        Item item = null;
        try {
            switch (itemTypeRaw.toUpperCase()) {
                case "DESKTOP":
                    item = new Desktop(
                            nextItemID,
                            Double.parseDouble(args[0]),
                            1,
                            ItemType.DESKTOP,
                            args[1],
                            args[2],
                            Integer.parseInt(args[3]),
                            Integer.parseInt(args[4]),
                            args[5],
                            args[6],
                            Integer.parseInt(args[7]),
                            Integer.parseInt(args[8]),
                            args[9]
                    );
                    break;
                case "LAPTOP":
                    item = new Laptop(
                            nextItemID,
                            Double.parseDouble(args[0]),
                            1,
                            ItemType.LAPTOP,
                            args[1],
                            args[2],
                            Integer.parseInt(args[3]),
                            Integer.parseInt(args[4]),
                            args[5],
                            args[6],
                            Integer.parseInt(args[7]),
                            Integer.parseInt(args[8]),
                            args[9].equals("1")
                    );
                    break;
                case "TABLET":
                    item = new Tablet(
                            nextItemID,
                            Double.parseDouble(args[0]),
                            1,
                            ItemType.TABLET,
                            args[1],
                            args[2],
                            Integer.parseInt(args[3]),
                            Integer.parseInt(args[4]),
                            args[5],
                            args[6],
                            Integer.parseInt(args[7]),
                            Integer.parseInt(args[8]),
                            args[9]
                    );
                    break;
                case "TV":
                    item = new TV(
                            nextItemID,
                            Double.parseDouble(args[0]),
                            1,
                            ItemType.TV,
                            args[1],
                            args[2],
                            Integer.parseInt(args[3]),
                            Integer.parseInt(args[4]),
                            Integer.parseInt(args[5])
                    );
                    break;
                case "SMARTPHONE":
                    item = new SmartPhone(
                            nextItemID,
                            Double.parseDouble(args[0]),
                            1,
                            ItemType.SMARTPHONE,
                            args[1],
                            args[2],
                            Integer.parseInt(args[3]),
                            Integer.parseInt(args[4]),
                            args[5]
                    );
                    break;
                case "BOOK":
                    List<String> authors = Arrays.asList(args[4].split(","));
                    item = new Book(
                            nextItemID,
                            Double.parseDouble(args[0]),
                            1,
                            ItemType.BOOK,
                            args[1],
                            args[2],
                            args[3],
                            authors,
                            Integer.parseInt(args[5])
                    );
                    break;
                case "CDDVD":
                    List<String> songs = Arrays.asList(args[4].split(","));
                    item = new CDDVD(
                            nextItemID,
                            Double.parseDouble(args[0]),
                            1,
                            ItemType.CDDVD,
                            args[1],
                            args[2],
                            args[3],
                            args[4],
                            songs
                    );
                    break;
                case "HAIRCARE":
                    item = new HairCare(
                            nextItemID,
                            Double.parseDouble(args[0]),
                            1,
                            ItemType.HAIRCARE,
                            args[1],
                            args[2],
                            args[3].equals("1"),
                            Integer.parseInt(args[4]),
                            Double.parseDouble(args[5]),
                            args[6].equals("1")
                    );
                    break;
                case "SKINCARE":
                    item = new SkinCare(
                            nextItemID,
                            Double.parseDouble(args[0]),
                            1,
                            ItemType.SKINCARE,
                            args[1],
                            args[2],
                            args[3].equals("1"),
                            Integer.parseInt(args[4]),
                            Double.parseDouble(args[5]),
                            args[6].equals("1")
                    );
                    break;
                case "PERFUME":
                    item = new Perfume(
                            nextItemID,
                            Double.parseDouble(args[0]),
                            1,
                            ItemType.PERFUME,
                            args[1],
                            args[2],
                            args[3].equals("1"),
                            Integer.parseInt(args[4]),
                            Double.parseDouble(args[5]),
                            Integer.parseInt(args[6])
                    );
                    break;
                default:
                    System.out.println("No item type " + itemTypeRaw + " found");
                    return;
            }
        } catch (Exception e) {

            System.out.println("No item type " + itemTypeRaw + " found");
            return;
        }

        if (item != null) {
            items.add(item);
            nextItemID++;
        }
    }


    private void ShowOrders(String[] parts) {
        String techName = parts[1];
        Technician tech = findTechByName(techName);
        if (tech == null) {
            System.out.println("No technician person named " + techName + " exists!");
            return;
        }

        if (!tech.isSenior()) {
            System.out.println(techName + " is not authorized to display orders!");
            return;
        }

        System.out.println("Order History:");
        for (Order o : orders) {
            System.out.println(o.toString());
        }
    }


    private void ChangePassword(String[] parts) {
        int customerID = Integer.parseInt(parts[1]);
        String oldPass = parts[2];
        String newPass = parts[3];

        Customer c = findCustomerByID(customerID);
        if (c == null) {
            System.out.println("No customer with ID number " + customerID + " exists!");
            return;
        }

        if (!c.getPassword().equals(oldPass)) {
            System.out.println("The given password does not match the current password. Please try again.");
            return;
        }

        c.changePassword(oldPass,newPass);
        System.out.println("The password has been successfully changed.");
    }


    private void DepositMoney(String[] parts) {
        int customerID = Integer.parseInt(parts[1]);
        double loadAmount = Double.parseDouble(parts[2]);

        Customer c = findCustomerByID(customerID);
        if (c == null) {
            System.out.println("No customer with ID number " + customerID + " exists!");
            return;
        }

       c.depositMoney(loadAmount);

    }


    private void ShowCampaigns(String[] parts) {
        int customerID = Integer.parseInt(parts[1]);
        Customer c = findCustomerByID(customerID);
        if (c == null) {
            System.out.println("No customer with ID number " + customerID + " exists!");
            return;
        }

        if (campaigns.isEmpty()) {
            System.out.println("No campaign has been created so far!");
            return;
        }

        System.out.println("Active campaigns:");
        Date now = new Date();
        for (Campaign cmp : campaigns) {
            if (cmp.isActive(now)) {
                System.out.println(cmp.toString());
            }
        }
    }


    private void AddToCart(String[] parts) {
        int customerID = Integer.parseInt(parts[1]);
        int itemID = Integer.parseInt(parts[2]);

        Customer c = findCustomerByID(customerID);
        if (c == null) {
            System.out.println("No customer with ID number " + customerID + " exists!");
            return;
        }

        Item it = findItemByID(itemID);
        if (it == null) {
            System.out.println("Invalid item ID");
            return;
        }

        if (it.getStock() <= 0) {
            System.out.println("We are sorry. The item is temporarily unavailable.");
            return;
        }

        ShoppingCart cart = c.getShoppingCart();
        cart.addItem(it);

        String typeName = it.getClass().getSimpleName();
        System.out.println("The item " + typeName + " has been successfully added to your cart.");
    }


    private void EmptyCart(String[] parts) {
        int customerID = Integer.parseInt(parts[1]);

        Customer c = findCustomerByID(customerID);
        if (c == null) {
            System.out.println("No customer with ID number " + customerID + " exists!");
            return;
        }

        c.getShoppingCart().emptyCart();
        System.out.println("The cart has been emptied.");
    }



    private void Order(String[] parts) {

        int customerID = Integer.parseInt(parts[1]);
        String givenPassword = parts[2];

        Customer c = findCustomerByID(customerID);
        if (c == null) {
            System.out.println("No customer with ID number " + customerID + " exists!");
            return;
        }


        if (!c.getPassword().equals(givenPassword)) {
            System.out.println("Order could not be placed. Invalid password.");
            return;
        }

        ShoppingCart cart = c.getShoppingCart();
        List<Item> cartItems = cart.getItems();

        if (cartItems.isEmpty()) {
            System.out.println("You should add some items to your cart before order request!");
            return;
        }

        double totalBeforeStatus = 0.0;
        Date now = new Date();


        for (Item it : cartItems) {
            double price = it.getPrice();
            Campaign cmp = findCampaignForItem(it);

            if (cmp != null && cmp.isActive(now)) {
                price = price * (1 - cmp.getDiscountRate() / 100.0);
            }

            totalBeforeStatus += price;
        }


        double finalCost = totalBeforeStatus;
        CustomerStatus oldStatus = c.getStatus();

        if (oldStatus == CustomerStatus.SILVER) {
            finalCost *= (1 - Customer.SILVER_DISCOUNT);
        } else if (oldStatus == CustomerStatus.GOLDEN) {
            finalCost *= (1 - Customer.GOLDEN_DISCOUNT);
        }


        if (c.getBalance() < finalCost) {
            System.out.println("Order could not be placed. Insufficient funds.");
            return;
        }


        double newBalance = c.getBalance() - finalCost;

        c.depositMoney(-finalCost);


        for (Item it : cartItems) {
            it.setStock(it.getStock() - 1);
        }


        Order order = new Order(
                new Date(),
                c.getCustomerID(),
                new ArrayList<>(cartItems),
                finalCost
        );
        orders.add(order);


        c.getOrderHistory().add(order);


        double updatedTotalSpent = c.getTotalSpent() + finalCost;
        c.updateStatusAfterOrder(updatedTotalSpent);


        cart.emptyCart();

        System.out.println("Done! Your order will be delivered as soon as possible. Thank you!");

        CustomerStatus newStatus = c.getStatus();


        if (oldStatus != newStatus) {
            if (newStatus == CustomerStatus.SILVER) {
                System.out.println("Congratulations! You have been upgraded to a SILVER MEMBER! You have earned");
                System.out.println("a discount of 10% on all purchases.");
            } else if (newStatus == CustomerStatus.GOLDEN) {
                System.out.println("Congratulations! You have been upgraded to a GOLDEN MEMBER! You have earned");
                System.out.println("a discount of 15% on all purchases.");
            }
            return;
        }


        if (newStatus == CustomerStatus.CLASSIC) {
            double remaining = Customer.SILVER_LIMIT - updatedTotalSpent;
            if (remaining > 0) {
                System.out.println("You need to spend " + remaining + " more TL to become a SILVER MEMBER.");
            }
        } else if (newStatus == CustomerStatus.SILVER) {
            double remaining = Customer.GOLDEN_LIMIT - updatedTotalSpent;
            if (remaining > 0) {
                System.out.println("You need to spend " + remaining + " more TL to become a GOLDEN MEMBER.");
            }
        }
    }



}
