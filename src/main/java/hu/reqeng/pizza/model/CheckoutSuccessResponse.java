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
 * CheckoutSuccessResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-14T20:45:39.674Z")




public class CheckoutSuccessResponse   {
  @JsonProperty("cart")
  private Cart cart = null;

  @JsonProperty("redirectUrl")
  private String redirectUrl = null;

  public CheckoutSuccessResponse cart(Cart cart) {
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

  public CheckoutSuccessResponse redirectUrl(String redirectUrl) {
    this.redirectUrl = redirectUrl;
    return this;
  }

  /**
   * Get redirectUrl
   * @return redirectUrl
  **/
  @ApiModelProperty(example = "https://redirect.to/cart-987/pay", required = true, value = "")
  @NotNull


  public String getRedirectUrl() {
    return redirectUrl;
  }

  public void setRedirectUrl(String redirectUrl) {
    this.redirectUrl = redirectUrl;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CheckoutSuccessResponse checkoutSuccessResponse = (CheckoutSuccessResponse) o;
    return Objects.equals(this.cart, checkoutSuccessResponse.cart) &&
        Objects.equals(this.redirectUrl, checkoutSuccessResponse.redirectUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cart, redirectUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CheckoutSuccessResponse {\n");
    
    sb.append("    cart: ").append(toIndentedString(cart)).append("\n");
    sb.append("    redirectUrl: ").append(toIndentedString(redirectUrl)).append("\n");
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

