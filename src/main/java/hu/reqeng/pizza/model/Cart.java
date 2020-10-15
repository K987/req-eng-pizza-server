package hu.reqeng.pizza.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Cart
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-14T20:45:39.674Z")




public class Cart   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("total")
  private BigDecimal total = null;

  @JsonProperty("remainingToCheckOut")
  private BigDecimal remainingToCheckOut = null;

  @JsonProperty("items")
  @Valid
  private List<CartItem> items = new ArrayList<>();

  public Cart id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "cart-987", required = true, value = "")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Cart total(BigDecimal total) {
    this.total = total;
    return this;
  }

  /**
   * Get total
   * @return total
  **/
  @ApiModelProperty(example = "3.0", value = "")

  @Valid

  public BigDecimal getTotal() {
    return total;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }

  public Cart remainingToCheckOut(BigDecimal remainingToCheckOut) {
    this.remainingToCheckOut = remainingToCheckOut;
    return this;
  }

  /**
   * Get remainingToCheckOut
   * @return remainingToCheckOut
  **/
  @ApiModelProperty(example = "7.0", value = "")

  @Valid

  public BigDecimal getRemainingToCheckOut() {
    return remainingToCheckOut;
  }

  public void setRemainingToCheckOut(BigDecimal remainingToCheckOut) {
    this.remainingToCheckOut = remainingToCheckOut;
  }

  public Cart items(List<CartItem> items) {
    this.items = items;
    return this;
  }

  public Cart addItemsItem(CartItem itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<CartItem>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Get items
   * @return items
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<CartItem> getItems() {
    return items;
  }

  public void setItems(List<CartItem> items) {
    this.items = items;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cart cart = (Cart) o;
    return Objects.equals(this.id, cart.id) &&
        Objects.equals(this.total, cart.total) &&
        Objects.equals(this.remainingToCheckOut, cart.remainingToCheckOut) &&
        Objects.equals(this.items, cart.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, total, remainingToCheckOut, items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Cart {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
    sb.append("    remainingToCheckOut: ").append(toIndentedString(remainingToCheckOut)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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

