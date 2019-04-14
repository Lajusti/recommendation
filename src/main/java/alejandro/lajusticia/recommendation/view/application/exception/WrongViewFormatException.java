package alejandro.lajusticia.recommendation.view.application.exception;

public class WrongViewFormatException extends Exception {

    private static final String MESSAGE = "Wrong format for the view: %s, the valid format is: " +
            "id,user_id,tag_id,product_name";

    public WrongViewFormatException(String view) {
        super(String.format(MESSAGE, view));
    }

}
