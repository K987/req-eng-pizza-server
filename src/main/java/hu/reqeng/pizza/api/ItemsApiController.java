package hu.reqeng.pizza.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import hu.reqeng.pizza.model.GetItemsResponse;
import hu.reqeng.pizza.model.Item;
import hu.reqeng.pizza.service.ItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-14T20:45:39.674Z")

@Controller
public class ItemsApiController implements ItemsApi {

    private static final Logger log = LoggerFactory.getLogger(ItemsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private final ItemService itemService;

    @org.springframework.beans.factory.annotation.Autowired
    public ItemsApiController(ObjectMapper objectMapper, HttpServletRequest request, ItemService itemService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.itemService = itemService;
    }

    public ResponseEntity<GetItemsResponse> getItems() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                List<Item> items = itemService.getAllItems();
                GetItemsResponse itemsResponse = new GetItemsResponse();
                itemsResponse.addAll(items);
                return ResponseEntity.ok().body(itemsResponse);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GetItemsResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GetItemsResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
