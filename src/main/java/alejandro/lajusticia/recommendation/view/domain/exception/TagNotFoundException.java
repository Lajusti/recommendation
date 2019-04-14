package alejandro.lajusticia.recommendation.view.domain.exception;

public class TagNotFoundException extends Exception {

    private static final String MESSAGE = "Tag with id: %s not found";

    public TagNotFoundException(String id) {
        super(String.format(MESSAGE, id));
    }

}
