package at.technikumwien.if15b082.data;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by rsoff on 04.12.2017.
 */
@Entity
@Table(name="t_movies")
public class Movie {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private String originalTitle;
  private Integer releaseYear;
  @OneToOne(optional = false, targetEntity = Studio.class)
  private Studio studio;
  @ManyToMany(targetEntity = Actor.class, fetch=FetchType.EAGER)
  private Collection actors;
  
  public Movie() {}
  
  public Movie(String originalTitle, int releaseYear) {
    this.originalTitle = originalTitle;
    this.releaseYear = releaseYear;
  }
  
  public String getOriginalTitle() {
    return originalTitle;
  }
  
  public void setOriginalTitle(String originalTitle) {
    this.originalTitle = originalTitle;
  }
  
  public int getReleaseYear() {
    return releaseYear;
  }
  
  public void setReleaseYear(int releaseYear) {
    this.releaseYear = releaseYear;
  }
}
