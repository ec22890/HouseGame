package OOP.ec22890.MP;

class House_ec22890 extends House {
    private Room center;//Hemat
    private Room north;//Ilyas
    private Room east;//Hamid
    private Room west;//Tafsir
    private Room south;//Naveed

    //creator method
    public House_ec22890(){
        this.center = new Room_ec22890();
        this.north = new Room_ec22473();
        this.east = new Room_ec22626();
        this.west = new Room_ec22837();
        this.south = new Room_ec22621();
    }

    public Direction visit(Visitor v, Direction d) {
        Boolean visited[] = { false, false, false, false, false, false };
        String Recently_visited;

        while((visited[0] == false) || (visited[1] == false) || (visited[2] == false) || (visited[3] == false) || (visited[4] == false)){

            if(visited[0] == false){
                d = center.visit(v, d);
                visited[0] = true;
            }

            if(d.toString().equals("heading North")){
                d = north.visit(v, d);
                Recently_visited = "north";
                visited[1] = true;
                if(d.toString().equals("heading South")){
                    d = center.visit(v, d);
                }
                d = updated_direction(Recently_visited, d);
            }
            else if(d.toString().equals("heading East")){
                d = east.visit(v, d);
                Recently_visited = "east";
                visited[2] = true;
                if(d.toString().equals("heading West")){
                    d = center.visit(v, d);
                }
                d = updated_direction(Recently_visited, d);
            }
            else if(d.toString().equals("heading West")){
                d = west.visit(v, d);
                Recently_visited = "west";
                visited[3] = true;
                if(d.toString().equals("heading East")){
                    d = center.visit(v, d);
                }
                d = updated_direction(Recently_visited, d);
            }
            else if(d.toString().equals("heading South")){
                d = south.visit(v, d);
                Recently_visited = "south";
                visited[4] = true;
                if(d.toString().equals("heading North")){
                    d = center.visit(v, d);
                }
                d = updated_direction(Recently_visited, d);
            }
        }

        return d;
    }

    public Direction updated_direction(String Recently_visited, Direction d){
        if (Recently_visited.equals("north")){
            if(d.toString().equals("heading North")){
                return d.opposite(d);
            }
        }

        if (Recently_visited.equals("east")){
            if(d.toString().equals("heading East")){
                return d.opposite(d);
            }
        }

        if (Recently_visited.equals("west")){
            if(d.toString().equals("heading West")){
                return d.opposite(d);
            }
        }
        if (Recently_visited.equals("south")){
            if(d.toString().equals("heading South")){
                return d.opposite(d);
            }
        }
        return d;
    }
}
