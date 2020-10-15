/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.16).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package hu.reqeng.pizza.api;

import hu.reqeng.pizza.model.GetItemsResponse;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-14T20:45:39.674Z")
@Api(value = "items", description = "the items API")
@RequestMapping(value = "/v1")
public interface ItemsApi {

    @ApiOperation(value = "Retrieves the orderable items list", nickname = "getItems", notes = "", response = GetItemsResponse.class, tags={ "item", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "List of orderable items", response = GetItemsResponse.class),
        @ApiResponse(code = 500, message = "Internal server error") })
    @RequestMapping(value = "/items",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<GetItemsResponse> getItems();

}
