package aguiardaniel.fr.persistance.entity.document;

public enum DocType {
    BOOK, CD, DVD;

    public static DocType getTypeFromString(String type) {
        return DocType.valueOf(type.toUpperCase());
    }
}
