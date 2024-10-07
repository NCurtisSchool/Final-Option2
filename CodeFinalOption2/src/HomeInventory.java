public class HomeInventory {
    private int square_feet;
    private String address;
    private String city;
    private String state;
    private int zip_code;
    private String model_name;
    private String sale_status;

    public HomeInventory() {
        square_feet = 0;
        address = "NA";
        city = "NA";
        state = "NA";
        zip_code = 0;
        model_name = "NA";
        sale_status = "NA";
    }
    
    public HomeInventory(int square_feet, String address, String city,
    String state, int zip_code, String model_name, String sale_status) {
        this.square_feet = square_feet;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip_code = zip_code;
        this.model_name = model_name;
        this.sale_status = sale_status;
    }

    // getters
    public int get_square_feet() {return square_feet;}
    public String get_address() {return address;}
    public String get_city() {return city;}
    public String get_state() {return state;}
    public int get_zip_code() {return zip_code;}
    public String get_model_name() { return model_name;}
    public String get_sale_status() {return sale_status;}

    // setters
    public void set_square_feet(int square_feet) {this.square_feet = square_feet;}
    public void set_address(String address) {this.address = address;}
    public void set_city(String city) {this.city = city;}
    public void set_state(String state) {this.state = state;}
    public void set_zip_code(int zip_code) {this.zip_code = zip_code;}
    public void set_model_name(String model_name) {this.model_name = model_name;}
    public void set_sale_status(String sale_status) {this.sale_status = sale_status;}
    

    @Override
    public String toString() {
        return String.format(
            "Square feet of property: " + this.square_feet +
            "\nAddress of property: " + this.address +
            "\nCity of property: " + this.city +
            "\nState of property: " + this.state +
            "\nZip code of property: \" + this.zip_code" +
            "\nModel name of property: " + this.model_name +
            "\nSale status of property: " + this.sale_status
        );
    }

    void displayInfo() {
        System.out.println("Square feet of property: " + this.square_feet);
        System.out.println("Address of property: " + this.address);
        System.out.println("City of property: " + this.city);
        System.out.println("State of property: " + this.state);
        System.out.println("Zip code of property: " + this.zip_code);
        System.out.println("Model name of property: " + this.model_name);
        System.out.println("Sale status of property: " + this.sale_status);
    }
}