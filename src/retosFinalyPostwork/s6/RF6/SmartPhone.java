package retosFinalyPostwork.s6.RF6;

public class SmartPhone {

    float price;
    String name;
    String model;
    String processor;


    public SmartPhone(float price, String name, String model,String processor ) {
        this.price = price;
        this.name = name;
        this.model = model;
        this.processor = processor;

    }


    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getProcessor(){return processor;}



}