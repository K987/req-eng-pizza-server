package hu.reqeng.pizza.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Offer
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-14T20:45:39.674Z")




public class Offer   {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("offerings")
  @Valid
  private List<Item> offerings = new ArrayList<Item>();

  public Offer id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(example = "offer-543", required = true, value = "")
  @NotNull


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Offer offerings(List<Item> offerings) {
    this.offerings = offerings;
    return this;
  }

  public Offer addOfferingsItem(Item offeringsItem) {
    this.offerings.add(offeringsItem);
    return this;
  }

  /**
   * Get offerings
   * @return offerings
  **/
  @ApiModelProperty(required = true, value = "")
  @NotNull

  @Valid

  public List<Item> getOfferings() {
    return offerings;
  }

  public void setOfferings(List<Item> offerings) {
    this.offerings = offerings;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Offer offer = (Offer) o;
    return Objects.equals(this.id, offer.id) &&
        Objects.equals(this.offerings, offer.offerings);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, offerings);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Offer {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    offerings: ").append(toIndentedString(offerings)).append("\n");
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

