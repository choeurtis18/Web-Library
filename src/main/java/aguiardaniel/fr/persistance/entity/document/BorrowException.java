package aguiardaniel.fr.persistance.entity.document;

public class BorrowException extends RuntimeException{

    public BorrowException() {
        super("You can't borrow this item");
    }
}
