package at.technikumwien.if15b082.data;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by rsoff on 04.12.2017.
 */
@Entity
@Table(name="t_studios")
public class Studio {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String countrycode;
  private String postcode;
  @OneToMany(targetEntity = Movie.class, fetch = FetchType.LAZY)
  private Collection Movies;
  
  public Studio() {}
  
  public Studio(String name, String countrycode, String postcode, Collection movies) {
    this.name = name;
    this.countrycode = countrycode;
    this.postcode = postcode;
  }
  
  public String getName() { return name; }
  
  public void setName(String name) { this.name = name; }
  
  public String getCountrycode() { return countrycode; }
  
  public void setCountrycode(String countrycode) { this.countrycode = countrycode; }
  
  public String getPostcode() { return postcode; }
  
  public void setPostcode(String postcode) { this.postcode = postcode; }
}
