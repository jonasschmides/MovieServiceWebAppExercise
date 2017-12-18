package at.technikumwien.if15b082.data;

import java.sql.Date;
import java.util.Collection;
import javax.persistence.*;

/**
 * Created by rsoff on 04.12.2017.
 */

@Entity
@Table(name="t_actors")
public class Actor {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private String firstName;
  private String lastNsme;
  private String sex;
  private Date birthDate;
  @ManyToMany(targetEntity = Movie.class, fetch=FetchType.EAGER)
  private Collection<Movie> movies;
  
  
  public Actor() {}
  
  public Actor(String firstName, String lastNsme, String sex, Date birthDate) {
    this.firstName = firstName;
    this.lastNsme = lastNsme;
    this.sex = sex;
    this.birthDate = birthDate;
  }
  
  public String getFirstName() { return firstName; }
  
  public void setFirstName(String firstName) { this.firstName = firstName; }
  
  public Date getBirthDate() { return birthDate; }
  
  public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }
  
}
