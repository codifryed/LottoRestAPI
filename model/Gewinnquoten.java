/*
 * Gewinnquoten
 * Wir geben die Gewinnquoten aus 
 *
 * OpenAPI spec version: 1.0.0
 * Contact: contact@wbstraining.de
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package wbs.jsf1.rest.v1.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import wbs.jsf1.rest.v1.model.Model6aus49;
import wbs.jsf1.rest.v1.model.Spiel6;
import wbs.jsf1.rest.v1.model.Spiel77;
import javax.validation.constraints.*;

/**
 * Gewinnquoten
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2018-03-15T00:05:48.184+01:00")
public class Gewinnquoten   {
  @JsonProperty("einsatz6aus49")
  private Long einsatz6aus49 = null;

  @JsonProperty("einsatzspiel77")
  private Long einsatzspiel77 = null;

  @JsonProperty("einsatzspiel6")
  private Long einsatzspiel6 = null;

  @JsonProperty("6aus49s")
  private List<Model6aus49> _6aus49s = null;

  @JsonProperty("spiel77s")
  private List<Spiel77> spiel77s = null;

  @JsonProperty("spiel6s")
  private List<Spiel6> spiel6s = null;

  public Gewinnquoten einsatz6aus49(Long einsatz6aus49) {
    this.einsatz6aus49 = einsatz6aus49;
    return this;
  }

  /**
   * Get einsatz6aus49
   * @return einsatz6aus49
   **/
  @JsonProperty("einsatz6aus49")
  @ApiModelProperty(value = "")
  public Long getEinsatz6aus49() {
    return einsatz6aus49;
  }

  public void setEinsatz6aus49(Long einsatz6aus49) {
    this.einsatz6aus49 = einsatz6aus49;
  }

  public Gewinnquoten einsatzspiel77(Long einsatzspiel77) {
    this.einsatzspiel77 = einsatzspiel77;
    return this;
  }

  /**
   * Get einsatzspiel77
   * @return einsatzspiel77
   **/
  @JsonProperty("einsatzspiel77")
  @ApiModelProperty(value = "")
  public Long getEinsatzspiel77() {
    return einsatzspiel77;
  }

  public void setEinsatzspiel77(Long einsatzspiel77) {
    this.einsatzspiel77 = einsatzspiel77;
  }

  public Gewinnquoten einsatzspiel6(Long einsatzspiel6) {
    this.einsatzspiel6 = einsatzspiel6;
    return this;
  }

  /**
   * Get einsatzspiel6
   * @return einsatzspiel6
   **/
  @JsonProperty("einsatzspiel6")
  @ApiModelProperty(value = "")
  public Long getEinsatzspiel6() {
    return einsatzspiel6;
  }

  public void setEinsatzspiel6(Long einsatzspiel6) {
    this.einsatzspiel6 = einsatzspiel6;
  }

  public Gewinnquoten _6aus49s(List<Model6aus49> _6aus49s) {
    this._6aus49s = _6aus49s;
    return this;
  }

  public Gewinnquoten add6aus49sItem(Model6aus49 _6aus49sItem) {
    if (this._6aus49s == null) {
      this._6aus49s = new ArrayList<>();
    }
    this._6aus49s.add(_6aus49sItem);
    return this;
  }

  /**
   * Get _6aus49s
   * @return _6aus49s
   **/
  @JsonProperty("6aus49s")
  @ApiModelProperty(value = "")
  public List<Model6aus49> get6aus49s() {
    return _6aus49s;
  }

  public void set6aus49s(List<Model6aus49> _6aus49s) {
    this._6aus49s = _6aus49s;
  }

  public Gewinnquoten spiel77s(List<Spiel77> spiel77s) {
    this.spiel77s = spiel77s;
    return this;
  }

  public Gewinnquoten addSpiel77sItem(Spiel77 spiel77sItem) {
    if (this.spiel77s == null) {
      this.spiel77s = new ArrayList<>();
    }
    this.spiel77s.add(spiel77sItem);
    return this;
  }

  /**
   * Get spiel77s
   * @return spiel77s
   **/
  @JsonProperty("spiel77s")
  @ApiModelProperty(value = "")
  public List<Spiel77> getSpiel77s() {
    return spiel77s;
  }

  public void setSpiel77s(List<Spiel77> spiel77s) {
    this.spiel77s = spiel77s;
  }

  public Gewinnquoten spiel6s(List<Spiel6> spiel6s) {
    this.spiel6s = spiel6s;
    return this;
  }

  public Gewinnquoten addSpiel6sItem(Spiel6 spiel6sItem) {
    if (this.spiel6s == null) {
      this.spiel6s = new ArrayList<>();
    }
    this.spiel6s.add(spiel6sItem);
    return this;
  }

  /**
   * Get spiel6s
   * @return spiel6s
   **/
  @JsonProperty("spiel6s")
  @ApiModelProperty(value = "")
  public List<Spiel6> getSpiel6s() {
    return spiel6s;
  }

  public void setSpiel6s(List<Spiel6> spiel6s) {
    this.spiel6s = spiel6s;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Gewinnquoten gewinnquoten = (Gewinnquoten) o;
    return Objects.equals(this.einsatz6aus49, gewinnquoten.einsatz6aus49) &&
        Objects.equals(this.einsatzspiel77, gewinnquoten.einsatzspiel77) &&
        Objects.equals(this.einsatzspiel6, gewinnquoten.einsatzspiel6) &&
        Objects.equals(this._6aus49s, gewinnquoten._6aus49s) &&
        Objects.equals(this.spiel77s, gewinnquoten.spiel77s) &&
        Objects.equals(this.spiel6s, gewinnquoten.spiel6s);
  }

  @Override
  public int hashCode() {
    return Objects.hash(einsatz6aus49, einsatzspiel77, einsatzspiel6, _6aus49s, spiel77s, spiel6s);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Gewinnquoten {\n");
    
    sb.append("    einsatz6aus49: ").append(toIndentedString(einsatz6aus49)).append("\n");
    sb.append("    einsatzspiel77: ").append(toIndentedString(einsatzspiel77)).append("\n");
    sb.append("    einsatzspiel6: ").append(toIndentedString(einsatzspiel6)).append("\n");
    sb.append("    _6aus49s: ").append(toIndentedString(_6aus49s)).append("\n");
    sb.append("    spiel77s: ").append(toIndentedString(spiel77s)).append("\n");
    sb.append("    spiel6s: ").append(toIndentedString(spiel6s)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
