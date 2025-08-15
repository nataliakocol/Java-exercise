import java.util.ArrayList;

class Company
{
    private String name;
}

class Depot
{
    private String name;
    private ArrayList<Vehicle> vehicles = new ArrayList<>();


    public Depot(String name)
    {
        this.name = name;
    }

    public void addVehicle(Vehicle vehicle)
    {
        vehicles.add(vehicle);
    }

    public String getName()
    {
        return name;
    };

    public Vehicle getVehicle(String registration)
    {
        for(int i = 0; i < vehicles.size(); i++){
            if(vehicles.get(i).getRegistration().equals(registration))
                return vehicles.get(i);
        }
        return null;
    };
}

abstract class Vehicle
{
    private String registration;
    private int numberSeats;

    public Vehicle(String registration, int numberSeats){
        this.registration = registration;
        this.numberSeats = numberSeats;
    }

    public String getRegistration(){
        return registration;
    }

    public int getNumberSeats(){
        return numberSeats;
    }

    public abstract int getHireCost(int days);
}

class Bus extends Vehicle
{
    public Bus(String registration, int numberSeats)
    {
        super(registration,numberSeats);

    }

    @Override
    public int getHireCost(int days)
    {
        return 10;
    }
}

class Coach extends Vehicle{

    private boolean luxury;

    public Coach(String registration, int numberSeats, boolean luxury){
        super(registration, numberSeats);
        this.luxury = luxury;
    }

    @Override
    public int getHireCost(int days)
    {
        return 10*numberSeats;
    }

    public boolean isLuxury(){
        return luxury;
    }
}

public class Main {

    public static void main(String[] args) {

        int x = 5;

        Depot depot = new Depot("aaaa");

        var coach = new Coach("gh5783", 67, true);
        depot.addVehicle(coach);

        var bus = new Bus("tg54", 34);
        depot.addVehicle(bus);

        Vehicle found = depot.getVehicle("tg54");
        found.getHireCost(1);

        if(depot.getVehicle("sd45") == null)
            System.out.println("OK");



    }
}

