package visitor.improved;


public abstract class CarPart {

    void acceptCarPartVisitor(CarPartVisitor visitor){
        visitor.visit(this);
    }

}
