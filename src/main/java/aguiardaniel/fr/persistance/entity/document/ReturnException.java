package aguiardaniel.fr.persistance.entity.document;

public class ReturnException extends RuntimeException {

    public ReturnException() {
        super("You can't return this item");
    }
}
