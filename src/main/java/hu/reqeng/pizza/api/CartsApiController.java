package hu.reqeng.pizza.api;


import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import hu.reqeng.pizza.exception.CartServiceException;
import hu.reqeng.pizza.model.*;
import hu.reqeng.pizza.model.Error;
import hu.reqeng.pizza.service.CartService;
import hu.reqeng.pizza.service.OfferService;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-14T20:45:39.674Z")

@Controller
public class CartsApiController implements CartsApi {

    private static final Logger log = LoggerFactory.getLogger(CartsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final CartService cartService;

    private final OfferService offerService;

    @org.springframework.beans.factory.annotation.Autowired
    public CartsApiController(ObjectMapper objectMapper, HttpServletRequest request, CartService cartService, OfferService offerService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.cartService = cartService;
        this.offerService = offerService;
    }

    public ResponseEntity<Object> changeOrderQty(@ApiParam(value = "The id of the cart",required=true) @PathVariable("cartId") String cartId, @ApiParam(value = "" ,required=true )  @Valid @RequestBody List<ChangeOrderQtyRequest> itemsToChange) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                Cart cart = cartService.changeOrderQty(cartId, itemsToChange);
                Offer offer = offerService.getOfferIfAny(cart.getId());
                ChangeOrderQtySuccessResponse changeOrderQtySuccessResponse = new ChangeOrderQtySuccessResponse().cart(cart);
                if (offer != null) {
                    changeOrderQtySuccessResponse.setOffer(offer);
                }
                return ResponseEntity.ok(changeOrderQtySuccessResponse);
            } catch (CartServiceException e) {
                ChangeOrderQtyFailureResponse error = new ChangeOrderQtyFailureResponse()
                        .cart(e.getCart())
                        .error(new Error().message(e.getMessage()).code(e.getCode()));
                ResponseEntity.badRequest().body(error);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Object> checkout(@ApiParam(value = "The id of the cart",required=true) @PathVariable("cartId") String cartId) {
        String accept = request.getHeader("Accept");
        try {
            Cart cart = cartService.checkOut(cartId);
            String url = "https://redirect.to/"+cart.getId()+"/pay";
            CheckoutSuccessResponse checkoutSuccessResponse = new CheckoutSuccessResponse().cart(cart).redirectUrl(url);
            return ResponseEntity.ok(checkoutSuccessResponse);
        } catch (CartServiceException e) {
            CheckoutFailureResponse error = new CheckoutFailureResponse()
                    .cart(e.getCart())
                    .error(new Error().code(e.getCode()).message(e.getMessage()));
            return ResponseEntity.badRequest().body(error);
        }
    }

    public ResponseEntity<Void> clearCart(@ApiParam(value = "The id of the cart",required=true) @PathVariable("cartId") String cartId) {
        String accept = request.getHeader("Accept");
        cartService.clearCart(cartId);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<CreateCartResponse> createNewCart() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                Cart cart = cartService.createCart();
                CreateCartResponse createCartResponse = new CreateCartResponse().id(cart.getId());
                return ResponseEntity.created(null).body(createCartResponse);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CreateCartResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CreateCartResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
