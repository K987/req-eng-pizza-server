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
 * ChooseOfferSuccessResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-14T20:45:39.674Z")




public class ChooseOfferSuccessResponse   {
  @JsonProperty("cart")
  private Cart cart = null;

  public ChooseOfferSuccessResponse cart(Cart cart) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChooseOfferSuccessResponse chooseOfferSuccessResponse = (ChooseOfferSuccessResponse) o;
    return Objects.equals(this.cart, chooseOfferSuccessResponse.cart);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cart);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChooseOfferSuccessResponse {\n");
    
    sb.append("    cart: ").append(toIndentedString(cart)).append("\n");
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

