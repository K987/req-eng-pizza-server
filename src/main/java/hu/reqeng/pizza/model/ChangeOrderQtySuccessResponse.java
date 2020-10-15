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
 * ChangeOrderQtySuccessResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-14T20:45:39.674Z")




public class ChangeOrderQtySuccessResponse   {
  @JsonProperty("cart")
  private Cart cart = null;

  @JsonProperty("offer")
  private Offer offer = null;

  public ChangeOrderQtySuccessResponse cart(Cart cart) {
    this.cart = cart;
    return this;
  }

  /**
   * Get cart
   * @return cart
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public Cart getCart() {
    return cart;
  }

  public void setCart(Cart cart) {
    this.cart = cart;
  }

  public ChangeOrderQtySuccessResponse offer(Offer offer) {
    this.offer = offer;
    return this;
  }

  /**
   * Get offer
   * @return offer
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Offer getOffer() {
    return offer;
  }

  public void setOffer(Offer offer) {
    this.offer = offer;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChangeOrderQtySuccessResponse changeOrderQtySuccessResponse = (ChangeOrderQtySuccessResponse) o;
    return Objects.equals(this.cart, changeOrderQtySuccessResponse.cart) &&
        Objects.equals(this.offer, changeOrderQtySuccessResponse.offer);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cart, offer);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChangeOrderQtySuccessResponse {\n");
    
    sb.append("    cart: ").append(toIndentedString(cart)).append("\n");
    sb.append("    offer: ").append(toIndentedString(offer)).append("\n");
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

