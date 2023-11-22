package OOP.ec22890.MP;


public interface Visitable {
    
    Direction visit( // Returns direction the visitor leaves towards.
                     Visitor visitor,
                     Direction directionVistorArrivesFrom);
}