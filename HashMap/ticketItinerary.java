package HashMap;

import java.util.HashMap;

public class ticketItinerary {
    
     public static String getStart( HashMap<String,String> tickets){

        HashMap<String,String> revTicekt=new HashMap<>();

        for(String keys:tickets.keySet()){
            revTicekt.put(tickets.get(keys),keys);
        }
        for(String keys:tickets.keySet()){

            if(!revTicekt.containsKey(keys)){
                return keys;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        HashMap<String,String> tickets= new HashMap<>();
        tickets.put("chennai","banglore");
        tickets.put("bombay","dehli");
        tickets.put("goa","chennai");
        tickets.put("dehli","goa");

        String start= getStart(tickets);
        System.out.print(start + " ->");

        for(String key:tickets.keySet()){

            System.out.print(tickets.get(key)  + " ->");
            start=tickets.get(key);
        }

    }
}
