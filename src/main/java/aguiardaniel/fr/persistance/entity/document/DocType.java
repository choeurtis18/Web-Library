package aguiardaniel.fr.persistance.entity.document;

public enum DocType {
    BOOK(1), CD(2), DVD(3);

    private final int typeID;

    DocType(int id) {
        this.typeID = id;
    }

    public static DocType getTypeById(int id) {
        for (DocType docType : DocType.values()) {
            if (docType.getTypeID() == id)
                return docType;
        }
        return null;
    }

    public static DocType getTypeFromString(String type) {
        return DocType.valueOf(type.toUpperCase());
    }

    public int getTypeID() {
        return typeID;
    }

}
