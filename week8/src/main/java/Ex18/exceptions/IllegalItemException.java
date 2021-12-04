package Ex18.exceptions;

import Ex18.entities.Item;

public class IllegalItemException extends Exception {
    private Item item;

    public IllegalItemException(Item item) {
        this.item = item;
    }

    @Override
    public String getMessage() {
        return "Unable too create existing Item: " + item;
    }
}
