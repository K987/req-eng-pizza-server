package hu.reqeng.pizza.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ChangeOrderQtyFailureResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-14T20:45:39.674Z")




public class ChangeOrderQtyFailureResponse   {
  @JsonProperty("cart")
  private Cart cart = null;

  @JsonProperty("error")
  private Error error = null;

  public ChangeOrderQtyFailureResponse cart(Cart cart) {
    this.cart = cart;
    return this;
  }

  /**
   * Get cart
   * @return cart
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Cart getCart() {
    return cart;
  }

  public void setCart(Cart cart) {
    this.cart = cart;
  }

  public ChangeOrderQtyFailureResponse error(Error error) {
    this.error = error;
    return this;
  }

  /**
   * Get error
   * @return error
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Error getError() {
    return error;
  }

  public void setError(Error error) {
    this.error = error;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChangeOrderQtyFailureResponse changeOrderQtyFailureResponse = (ChangeOrderQtyFailureResponse) o;
    return Objects.equals(this.cart, changeOrderQtyFailureResponse.cart) &&
        Objects.equals(this.error, changeOrderQtyFailureResponse.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cart, error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChangeOrderQtyFailureResponse {\n");
    
    sb.append("    cart: ").append(toIndentedString(cart)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

