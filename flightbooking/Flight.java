package flightbooking;
import java.util.*;
public class Flight {
    int count=0;
    int RemainingTickets;
    int price=0;
    List<Integer> pId = new ArrayList();
    public Flight(int rt){
        this.RemainingTickets=rt;
    }   
    public void Bookings(int Tickets){
        int copy = count;
        for(int i=0;i<Tickets;i++,count++){
            int pCopy = price;
            price+=(count*200)+5000;
            pId.add(count,price-pCopy);
        }
        RemainingTickets-=Tickets;
        System.err.println("Booked SuccessFully and Your Ticket Amount is : "+price);
        if(Tickets == 1)
            System.err.println("Your Passenger Id is : "+ ++copy + "\n");
        else
            System.err.println("Your Passenger id from " + ++copy + " to " + count + "\n");
        price=0;
    }
    public void Cancelling(int start,int end){
        int s=0;
        try{
           for(int i = start-1; i<end;i++){
              s+=pId.get(i);
              pId.set(i,0);
           }
        this.RemainingTickets+=(end-start+1);
        }catch(Exception e){}
        if(s == 0)
            System.err.println("Warning : You are trying to cancel before you book");
        else
            System.err.println("Cancelled Successfully and Refunded Amound is "+s);
    }
    public void Cancelling(int start){
        try{
        System.err.println("Cancelled Sucessfully and Refunded Amound is "+pId.get(start-1));
        pId.set(start-1,0);
        this.RemainingTickets++;
        }catch(Exception e){
            System.err.println("Warning : You are trying to cancel before you book");
        }
        
    }
    public void printings(int id){
        System.err.println("Flight Id \t Passenger ID \t Ticket Price \t Cancelled(Yes/No)");
        for(int i =0; i<=pId.size()-1;i++){
            System.out.print(id + "\t\t    " + (i+1) + " \t\t  " + pId.get(i) + "     \t\t");
            if(pId.get(i) == 0)
               System.out.println("Yes");
            else
                System.out.println("No");
        }
        System.out.println();
    }
}

