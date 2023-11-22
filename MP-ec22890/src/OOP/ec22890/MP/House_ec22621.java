package OOP.ec22890.MP;


class House_ec22621 extends House {
    Room room1;
    Room room2;
    Room room3;
    Room room4; 
    Room room5;
    
    public House_ec22621() {
        this.room1 = new Room_ec22626();  //Hamid
        this.room2 = new Room_ec22473();  //Ilyas
        this.room3 = new Room_ec22890();  //Hemat
        this.room4 = new Room_ec22837();  //Naveed
        this.room5 = new Room_ec22621();  //Tafsir 
    }
    
    public Direction visit(Visitor v, Direction d) {
        Room[] rooms = {room1, room2, room3, room4, room5};
        int pos = 4;
        boolean leave = false;
        while (!leave){
            d = rooms[pos].visit(v, d);
            if (d.toString().equals("heading North")) {
                pos = visitNorth(rooms[pos]);
            }
            else if (d.toString().equals("heading East")) {
                pos = visitEast(rooms[pos]);
            }
            else if (d.toString().equals("heading South")) {
                pos = visitSouth(rooms[pos]);
            }
            else if (d.toString().equals("heading West")) {
                pos = visitWest(rooms[pos]);
            }
            leave = checkLeave(v);
        }
        return d;
    }
    
    public int visitNorth(Room r) {
        int pos = 0;
        if (r == room1) {
            pos = 1; 
        }
        else if(r == room2) {
            pos = 4;
        }
        else if (r == room3) {
            pos = 0;
        }
        else if (r == room4) {
            pos = 0;
        }
        else if (r == room5) {
            pos = 0;
        }
        return pos;
    }

    public int visitEast(Room r) {
        int pos = 0;
        if (r == room1) {
            pos = 3; 
        }
        else if(r == room2) {
            pos = 3;
        }
        else if (r == room3) {
            pos = 4 ;
        }
        else if (r == room4) {
            pos = 2;
        }
        else if (r == room5) {
            pos = 3;
        }
        return pos;
    }

    public int visitSouth(Room r) {
        int pos = 0;
        if (r == room1) {
            pos = 4; 
        }
        else if(r == room2) {
            pos = 0;
        }
        else if (r == room3) {
            pos = 1;
        }
        else if (r == room4) {
            pos = 1;
        }
        else if (r == room5) {
            pos = 1;
        }
        return pos;
    }

    public int visitWest(Room r) {
        int pos = 0;
        if (r == room1) {
            pos = 2; 
        }
        else if(r == room2) {
            pos = 2;
        }
        else if (r == room3) {
            pos = 3;
        }
        else if (r == room4) {
            pos = 4;
        }
        else if (r == room5) {
            pos = 2;
        }
        return pos;
    }

    public boolean checkLeave(Visitor v) {
        boolean leave = false;
        char choice = v.getChoice("Would you like to exit the house? (Y/N)", new char[] {'Y', 'N'});
        if ((choice == 'Y')) {
            leave = true;
        }
        return leave;
    }
    
}
