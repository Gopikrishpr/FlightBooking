package flightbooking;
import java.util.*;
public class FlightBooking {
    static Scanner sc = new Scanner(System.in);
    public static List<Flight> NoOfFlights(int n,int t){
        List<Flight> flights = new ArrayList();
        for(int i=0;i<n;i++)
        {
            Flight f = new Flight(t);
            flights.add(f);
        }
        return flights;
    }
    public static void BookingTickets(List<Flight> flights,int fId){
        System.out.print("How many tickets do you want : ");
        int t = sc.nextInt();
        if(flights.get(fId-1).RemainingTickets == 0 || t > flights.get(fId-1).RemainingTickets){
            System.err.println("Please check the remaining tickets of the flight : "+ fId +"\n");
            return;
        }
        flights.get(fId-1).Bookings(t); 
    }
    public static void PassengerId(List<Flight> flights,String str,int idf){
        if(str.equalsIgnoreCase("yes")){
            System.out.print("Enter your passenger ids are from start to end (Ex -> 2 11) : ");
            int s = sc.nextInt();
            int e = sc.nextInt();
            flights.get(idf-1).Cancelling(s,e);
        }
        else if(str.equalsIgnoreCase("no")){
            System.out.print("Enter Your passenger Id is : ");
            int s = sc.nextInt();
            flights.get(idf-1).Cancelling(s);
        } 
        else{
            System.out.println("Warning : You have to write YES/NO");
            return;
        }
    }
    public static void main(String[] args) {
        int TotalTickets = 50;
        int n =2;
        List<Flight> flights = NoOfFlights(n,TotalTickets);
        //flights.forEach((f) -> System.out.println(f));
        while(true){
            int count=0;
            for(Flight f : flights){
                System.out.print("Flight Id : "+ ++count+ "  Total Tickets : "+
                   TotalTickets + "  Remaining Seats : " + f.RemainingTickets + "  " );
                if(f.RemainingTickets == 50)
                    System.out.println("Curent Ticket Price : " + 5000);
                else
                    System.out.println("Current Ticket Price : " + (f.pId.get(f.pId.size()-1)+200));
            }
            System.out.printf("Enter your choice : 1.Book  2.Cancel  3.Print\n");
            int choice = sc.nextInt();
            switch(choice){
                case 1: {
                    System.out.print("Enter the flight Id : ");
                    int fId = sc.nextInt();
                    if(fId > n){
                       System.err.println("Invalid Flight ID and choose Flight Id between 1 to"+" "+n+"\n");
                       break;
                    }
                    BookingTickets(flights,fId);
                    break;
                }
                case 2: {
                    System.out.print("Enter your Flight Id :");
                    int idf = sc.nextInt();
                    if(idf > n){
                        System.out.println("Invalid Flight Id and Try again");
                        return;
                    }
                    String str;
                    System.out.print("Did you buy more than one tickets(Yes / No) : ");
                    str = sc.next();
                    PassengerId(flights,str,idf);
                    break;
                }
                case 3: {
                    System.out.println("Printing details of the flights : ");
                    int id =1;
                    for(Flight f : flights){
                        f.printings(id);
                        id++;
                    }
                    break;   
                }
                default:{
                    System.out.println("Invalid Choice");
                }
            }
        }
    }
    
}
