package OOP.ec22890.MP;


import java.util.*;
/***********************************************/
/* *                   N                    *  */
/*   *                                    *    */
/*     *         W    TAFSIR   E        *      */
/*       *           (ROOM1)          *        */
/*         *                        *          */
/*           *          S         *            */
/*             ******************              */          
/*     N       *        N       *      N       */
/*    NAVEED   *  W    HAMID  E *   W ILYAS  E */
/* W  (ROOM4) E*     (ROOM5)    *    (ROOM2)   */
/*             *        S       *       S      */  
/*      S      ******************              */                 
/*            *                  *             */
/*          *           N          *           */
/*        *       W   HEMAT     E    *         */
/*      *            (ROOM3)           *       */
/*    *                                  *     */
/*  *                   S                  *   */
/***********************************************/



class House_ec22626 extends House {

    private Room room1;//Tafsir
    private Room room2;//Ilyas
    private Room room3;//Hemat
    private Room room4;//Naveed
    private Room room5;//Hamid
    
    
    //creator method
    public House_ec22626(){
        this.room1 = new Room_ec22621();
        this.room2 = new Room_ec22473();
        this.room3 = new Room_ec22890();
        this.room4 = new Room_ec22837();
        this.room5 = new Room_ec22626();
    }
        
    

    public Direction visit(Visitor v, Direction d)
    {
       
        //array of rooms
        Room[] Rooms = {room1, room2, room3,room4, room5};

       
        //sets the initial location of the visitor in the house
        d = Rooms[4].visit(v,d);
        
         Direction direction = d;
        //this question is asked at the beginning of each time the user enters a room.
        String x = checkLeave(v);
        
        if(x.equalsIgnoreCase("b")){
            return d;
            
        }
         
            String selection = direction.toString();
        
 
           /*Switch Case allows the user to enter a room, then sets their location to that particular room in the house*/
            switch(selection){
                

                case "heading North":
                if(d.toString().equals("heading North")){
                d = Rooms[0].visit(v,d);
                d = room1(Rooms, v, d);
                }
                break;

                case "heading East":
                if(d.toString().equals("heading East")){
                d = Rooms[1].visit(v,d);
                d = room2(Rooms, v, d);
                }
                break;

                case "heading South":
                if(d.toString().equals("heading South")){
                d = Rooms[2].visit(v,d);
                d = room3(Rooms, v, d);
                }
                break;

                case "heading West":
                if(d.toString().equals("heading West")){
                d = Rooms[3].visit(v,d);
                d = room4(Rooms, v, d);
                }
                break;
                 
            

            }
            
              

   
    return d;
}


    /*ALLOWS THE USER TO ENTER DIFFERENT DIRECTIONS WHILST IN THE ROOMS*/    
    
    
    
    public Direction room1(Room[] Rooms, Visitor v, Direction d){
        String x = checkLeave(v);
        
        if(x.equalsIgnoreCase("b")){
            return d;
            
        }
        
        
      
        if(d.toString().equals("heading North")){
                d = Rooms[2].visit(v,d);
             d = room3(Rooms, v, d);
            
        }
                else if(d.toString().equals("heading East")){
                    d = Rooms[1].visit(v,d);
                     d = room2(Rooms, v, d);
                }
                else if(d.toString().equals("heading South")){
                    d = Rooms[4].visit(v,d);
                    d = room5(Rooms, v, d);
                }
                else if(d.toString().equals("heading West")){
                    d = Rooms[3].visit(v,d);
                     d = room4(Rooms, v, d);
                }
     
        return d;
        
    }
            

    
    public Direction room2(Room[] Rooms, Visitor v, Direction d)
    {
        String x = checkLeave(v);
        
        if(x.equalsIgnoreCase("b")){
            return d;
            
        }
    
        if(d.toString().equals("heading North")){
                d = Rooms[0].visit(v,d);
             d = room1(Rooms, v, d);
        }
                else if(d.toString().equals("heading East")){
                    d = Rooms[3].visit(v,d);
                     d = room4(Rooms, v, d);
                }
                else if(d.toString().equals("heading South")){
                    d = Rooms[2].visit(v,d);
                     d = room3(Rooms, v, d);
                }
                else if(d.toString().equals("heading West")){
                    d = Rooms[4].visit(v,d);
                    d = room5(Rooms, v, d);
                }
            

            return d;
        
       
    }
    
    public Direction room3(Room[] Rooms, Visitor v, Direction d){
        String x = checkLeave(v);
        
        if(x.equalsIgnoreCase("b")){
            return d;
            
        }
       
        if(d.toString().equals("heading North")){
                d = Rooms[4].visit(v,d);
            d = room5(Rooms, v, d);
        }
                else if(d.toString().equals("heading East")){
                    d = Rooms[1].visit(v,d);
                     d = room2(Rooms, v, d);
                }
                else if(d.toString().equals("heading South")){
                    d = Rooms[0].visit(v,d);
                     d = room1(Rooms, v, d);
                }
                else if(d.toString().equals("heading West")){
                    d = Rooms[3].visit(v,d);
                     d = room4(Rooms, v, d);
                } 
           
            return d;
        

    }
    public Direction room4(Room[] Rooms, Visitor v, Direction d){
        String x = checkLeave(v);
        
        if(x.equalsIgnoreCase("b")){
            return d;
            
        }
          
        if(d.toString().equals("heading North")){
                d = Rooms[0].visit(v,d);
             d = room1(Rooms, v, d);
        }
                else if(d.toString().equals("heading East")){
                    d = Rooms[4].visit(v,d);
                    d = room5(Rooms, v, d);
                }
                else if(d.toString().equals("heading South")){
                    d = Rooms[2].visit(v,d);
                     d = room3(Rooms, v, d);
                }
                else if(d.toString().equals("heading West")){
                    d = Rooms[1].visit(v,d);
                     d = room2(Rooms, v, d);
                }
           
            return d;

    }
     public Direction room5(Room[] Rooms, Visitor v, Direction d){
         String x = checkLeave(v);
        
        if(x.equalsIgnoreCase("b")){
            return d;
            
        }
         
        if(d.toString().equals("heading North")){
                d = Rooms[0].visit(v,d);
             d = room1(Rooms, v, d);
        }
                else if(d.toString().equals("heading East")){
                    d = Rooms[1].visit(v,d);
                     d = room2(Rooms, v, d);
                }
                else if(d.toString().equals("heading South")){
                    d = Rooms[2].visit(v,d);
                     d = room3(Rooms, v, d);
                }
                else if(d.toString().equals("heading West")){
                    d = Rooms[3].visit(v,d);
                     d = room4(Rooms, v, d);
                }
        
            
                return d;
            }

    public String checkLeave(Visitor v) {
        char choice = v.getChoice("Do you want to a) continue, b) leave ?", new char[] {'a', 'b'});
        if ((choice == 'a')) {
            return String.valueOf(choice);
        }
        return String.valueOf(choice);
    }


}
