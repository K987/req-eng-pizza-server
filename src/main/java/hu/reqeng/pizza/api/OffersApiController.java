package hu.reqeng.pizza.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import hu.reqeng.pizza.exception.OfferServiceException;
import hu.reqeng.pizza.model.Cart;
import hu.reqeng.pizza.model.ChooseOfferFailureResponse;
import hu.reqeng.pizza.model.ChooseOfferRequest;
import hu.reqeng.pizza.model.ChooseOfferSuccessResponse;
import hu.reqeng.pizza.model.Error;
import hu.reqeng.pizza.service.OfferService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-14T20:45:39.674Z")

@Controller
public class OffersApiController implements OffersApi {

    private static final Logger log = LoggerFactory.getLogger(OffersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;
    private final OfferService offerService;

    @org.springframework.beans.factory.annotation.Autowired
    public OffersApiController(ObjectMapper objectMapper, HttpServletRequest request, OfferService offerService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.offerService = offerService;
    }


    @Override
    public ResponseEntity<Object> chooseOffer(@ApiParam(value = "The id of the offer",required=true) @PathVariable("offerId") String offerId, @RequestBody ChooseOfferRequest itemToChoose) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                Cart cart = offerService.chooseOffer(offerId, itemToChoose.getItemId());
                ChooseOfferSuccessResponse response = new ChooseOfferSuccessResponse().cart(cart);
                return ResponseEntity.ok(response);
            } catch (OfferServiceException e) {
                ChooseOfferFailureResponse error = new ChooseOfferFailureResponse().error(new Error().code(e.getCode()).message(e.getMessage()));
                return ResponseEntity.status(e.getCode()).body(error);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
