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
 * ChangeOrderQtyRequest
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-14T20:45:39.674Z")




public class ChangeOrderQtyRequest   {
  @JsonProperty("itemId")
  private String itemId = null;

  @JsonProperty("qty")
  private Integer qty = null;

  public ChangeOrderQtyRequest itemId(String itemId) {
    this.itemId = itemId;
    return this;
  }

  /**
   * Get itemId
   * @return itemId
  **/
  @ApiModelProperty(example = "item-123", required = true, value = "")
  @NotNull


  public String getItemId() {
    return itemId;
  }

  public void setItemId(String itemId) {
    this.itemId = itemId;
  }

  public ChangeOrderQtyRequest qty(Integer qty) {
    this.qty = qty;
    return this;
  }

  /**
   * Get qty
   * minimum: 0
   * @return qty
  **/
  @ApiModelProperty(example = "1", required = true, value = "")
  @NotNull

@Min(0)
  public Integer getQty() {
    return qty;
  }

  public void setQty(Integer qty) {
    this.qty = qty;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChangeOrderQtyRequest changeOrderQtyRequest = (ChangeOrderQtyRequest) o;
    return Objects.equals(this.itemId, changeOrderQtyRequest.itemId) &&
        Objects.equals(this.qty, changeOrderQtyRequest.qty);
  }

  @Override
  public int hashCode() {
    return Objects.hash(itemId, qty);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChangeOrderQtyRequest {\n");
    
    sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
    sb.append("    qty: ").append(toIndentedString(qty)).append("\n");
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

