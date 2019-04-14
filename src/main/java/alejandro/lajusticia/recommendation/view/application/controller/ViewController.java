package alejandro.lajusticia.recommendation.view.application.controller;

import alejandro.lajusticia.recommendation.view.application.exception.WrongViewFormatException;
import alejandro.lajusticia.recommendation.view.domain.service.ViewService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/views")
class ViewController {

    private final ViewService viewService;

    public ViewController(final ViewService viewService) {
        this.viewService = viewService;
    }

    @PostMapping
    ResponseEntity createView(@RequestBody String view) {
        try {
            viewService.processView(view);
            return new ResponseEntity(HttpStatus.OK);
        } catch (WrongViewFormatException e) {
            return new ResponseEntity<>(
                    e.getMessage(),
                    HttpStatus.BAD_REQUEST
            );
        }
    }
}
