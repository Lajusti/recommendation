package alejandro.lajusticia.recommendation.view.domain.service;

import alejandro.lajusticia.recommendation.view.application.exception.WrongViewFormatException;

public interface ViewService {

    void processView(String view) throws WrongViewFormatException;

}
