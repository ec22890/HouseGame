package OOP.ec22890.MP;


public class House_ec22837 extends House {
    Room middle_room;
    Room north_room;
    Room east_room;
    Room west_room;
    Room south_room;

    Item rope = new Item("Rope");

    char[] yes_no_choice = {
        'y',
        'n'
    };


    public House_ec22837() {
        middle_room = new Room_ec22621();
        north_room = new Room_ec22890();
        south_room = new Room_ec22837();
        west_room = new Room_ec22626();
        east_room = new Room_ec22473();
    }

    public Direction visit(Visitor visitor, Direction directionVistorArrivesFrom) {
        visitor.tell(directionVistorArrivesFrom.toString());
        if (directionVistorArrivesFrom == Direction.FROM_NORTH) {
            visitor.tell("you entered the house from the north");
            visitnorth(visitor, directionVistorArrivesFrom);
        } else if (directionVistorArrivesFrom == Direction.FROM_SOUTH) {
            visitor.tell("you entered the house from the south");
            visitsouth(visitor, directionVistorArrivesFrom);
        } else if (directionVistorArrivesFrom == Direction.FROM_EAST) {
            visitor.tell("you entered the house from the east");
            visiteast(visitor, directionVistorArrivesFrom);
        } else if (directionVistorArrivesFrom == Direction.FROM_WEST) {
            visitor.tell("you entered the house from the west");
            visitwest(visitor, directionVistorArrivesFrom);
        }

        return directionVistorArrivesFrom;
    }
    public void visitsouth(Visitor visitor, Direction d) {
        visitor.tell("\n you are in the south room");
        d = south_room.visit(visitor, d);
        if (d == Direction.TO_NORTH) {
            visitmiddle(visitor, d);
        } else if (d == Direction.TO_SOUTH) {
            visitor.tell("you are attempting to go south but there is no room, only a window");
            if (visitor.hasEqualItem(rope)) {
                visitor.tell("you have a rope so you can exit through the window using it.");
                visitoutside(visitor, Direction.TO_SOUTH);
            } else {
                visitor.tell("you dont have a rope so you cant exit through the window");
                visitor.tell("you have to go back to the middle room now");
                visitmiddle(visitor, Direction.FROM_SOUTH);
            }
        } else if (d == Direction.TO_EAST) {
            d = Direction.TO_NORTH;
            visiteast(visitor, d);
        } else if (d == Direction.TO_WEST) {
            d = Direction.TO_NORTH;
            visitwest(visitor, d);
        }
    }
    public void visitmiddle(Visitor visitor, Direction d) {
        visitor.tell("\n you are in the middle room");
        d = middle_room.visit(visitor, d);
        if (d == Direction.TO_NORTH) {
            visitnorth(visitor, d);
        } else if (d == Direction.TO_SOUTH) {
            visitsouth(visitor, d);
        } else if (d == Direction.TO_EAST) {
            visiteast(visitor, d);
        } else if (d == Direction.TO_WEST) {
            visitwest(visitor, d);
        }
    }
    public void visitnorth(Visitor visitor, Direction d) {
        visitor.tell("\n you are in the north room");
        d = north_room.visit(visitor, d);
        if (d == Direction.TO_NORTH) {
            visitor.tell("you are attempting to go north but there is no room, only a window");
            if (visitor.hasEqualItem(rope)) {
                visitor.tell("you have a rope so you can exit through the window using it.");
                visitoutside(visitor, Direction.TO_NORTH);
            } else {
                visitor.tell("you dont have a rope so you cant exit through the window");
                visitor.tell("you have to go back to the middle room now");
                visitmiddle(visitor, Direction.FROM_NORTH);
            }
        } else if (d == Direction.TO_SOUTH) {
            visitmiddle(visitor, d);
        } else if (d == Direction.TO_EAST) {
            d = Direction.TO_SOUTH;
            visiteast(visitor, d);
        } else if (d == Direction.TO_WEST) {
            d = Direction.TO_SOUTH;
            visitwest(visitor, d);
        }
    }
    public void visitwest(Visitor visitor, Direction d) {
        visitor.tell("\n you are in the west room");
        d = west_room.visit(visitor, d);
        if (d == Direction.TO_NORTH) {
            d = Direction.TO_EAST;
            visitnorth(visitor, d);
        } else if (d == Direction.TO_SOUTH) {
            d = Direction.TO_EAST;
            visitsouth(visitor, d);
        } else if (d == Direction.TO_EAST) {
            visitmiddle(visitor, d);
        } else if (d == Direction.TO_WEST) {
            visitor.tell("you are attempting to go west but there is no room, only a window");
            if (visitor.hasEqualItem(rope)) {
                visitor.tell("you have a rope so you can exit through the window using it.");
                visitoutside(visitor, Direction.TO_WEST);
            } else {
                visitor.tell("you dont have a rope so you cant exit through the window");
                visitor.tell("you have to go back to the middle room now");
                visitmiddle(visitor, Direction.FROM_WEST);
            }
        }
    }
    public void visiteast(Visitor visitor, Direction d) {
        visitor.tell("\n you are in the east room");
        d = east_room.visit(visitor, d);
        if (d == Direction.TO_NORTH) {
            d = Direction.TO_WEST;
            visitnorth(visitor, d);
        } else if (d == Direction.TO_SOUTH) {
            d = Direction.TO_WEST;
            visitsouth(visitor, d);
        } else if (d == Direction.TO_EAST) {
            visitor.tell("you are attempting to go east but there is no room, only a window");
            if (visitor.hasEqualItem(rope)) {
                visitor.tell("you have a rope so you can exit through the window using it.");
                visitoutside(visitor, Direction.TO_EAST);
            } else {
                visitor.tell("you dont have a rope so you cant exit through the window");
                visitor.tell("you have to go back to the middle room now");
                visitmiddle(visitor, Direction.FROM_EAST);
            }
        } else if (d == Direction.TO_WEST) {
            visitmiddle(visitor, d);
        }
    }
    public void visitoutside(Visitor visitor, Direction d) {
        visitor.tell(d.toString());
        visitor.tell("you have exited through a window using rope and find yourself outside");
        char choice = visitor.getChoice("do you want to reenter the house? (y/n)", yes_no_choice);
        if (choice == 'y') {
            visitor.tell("you climb back up the rope and return to the middle room");
            visitor.tell(Direction.opposite(d).toString());
            visitmiddle(visitor, Direction.opposite(d));
        } else if (choice == 'n') {
            visitor.tell("Smart choice. you escaped and now you are free!");
        }
    }
}
