package OOP.ec22890.MP;



class House_ec22473 extends House {
    
    public final int position = 5;
    private Room[] rooms;
    
   public House_ec22473(){
        rooms = new Room[position];
        rooms[0] = new Room_ec22626(); // Hamid
        rooms[1] = new Room_ec22621(); // Tafsir
        rooms[2] = new Room_ec22473(); // Ilyas
        rooms[3] = new Room_ec22890(); // Hemat 
        rooms[4] = new Room_ec22837(); // Naveed
   }
    
   public Direction visit(Visitor visitor, Direction location){
       int NUM = 0;
       Room present = rooms[NUM];
       Direction d = present.visit(visitor,location);
       boolean leave = false;
       
       while(!leave)
       {
           if(d == Direction.TO_NORTH){
               if(present == rooms[0]){
                   NUM = NUM + 3;
                   present = rooms[NUM];
               }
               else if(present == rooms[1]){
                   NUM = NUM + 2;
                   present = rooms[NUM];
               }
               else if(present == rooms[2]){
                   NUM = NUM + 1;
                   present = rooms[NUM];
               }
               else if(present == rooms[3]){
                   NUM = NUM + 1;
                   present = rooms[NUM];
               }
               else if(present == rooms[4]){
                   NUM = NUM - 2;
                   present = rooms[NUM];
               }
           }
           
           else if(d == Direction.TO_SOUTH){
               if(present == rooms[0]){
                   NUM = NUM + 4;
                   present = rooms[NUM];
               }
               else if(present == rooms[1]){
                   NUM = NUM + 3;
                   present = rooms[NUM];
               }
               else if(present == rooms[2]){
                   NUM = NUM + 2;
                   present = rooms[NUM];
               }
               else if(present == rooms[3]){
                   NUM = NUM - 1;
                   present = rooms[NUM];
               }
               else if(present == rooms[4]){
                   NUM = NUM - 1;
                   present = rooms[NUM];
               }
           }
           
           else if(d == Direction.TO_WEST){
               if(present == rooms[0]){
                   NUM = NUM + 2;
                   present = rooms[NUM];
               }
               else if(present == rooms[1]){
                   NUM = NUM - 1;
                   present = rooms[NUM];
               }
               else if(present == rooms[2]){
                   NUM = NUM - 1;
                   present = rooms[NUM];
               }
               else if(present == rooms[3]){
                   NUM = NUM - 2;
                   present = rooms[NUM];
               }
               else if(present == rooms[4]){
                   NUM = NUM - 3;
                   present = rooms[NUM];
               }
           }
           
           else if(d == Direction.TO_EAST){
               if(present == rooms[0]){
                   NUM = NUM + 1;
                   present = rooms[NUM];
               }
               else if(present == rooms[1]){
                   NUM = NUM + 1;
                   present = rooms[NUM];
               }
               else if(present == rooms[2]){
                   NUM = NUM - 2;
                   present = rooms[NUM];
               }
               else if(present == rooms[3]){
                   NUM = NUM - 3;
                   present = rooms[NUM];
               }
               else if(present == rooms[4]){
                   NUM = NUM - 4;
                   present = rooms[NUM];
               }
               
           }
           leave = askLeave(visitor);
       }
       return d;
   }
       
       public boolean askLeave(Visitor v) {
        boolean leave = false;
        char choice = v.getChoice("Would you like to exit the house? (Y/N)", new char[] {'Y', 'N'});
        if ((choice == 'Y')) {
            leave = true;
        }
        return leave;
    }
}
       
               

                   
               
           
    
         
        
