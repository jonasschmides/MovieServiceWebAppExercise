package at.technikumwien.if15b082.data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

/**
 * Created by rsoff on 04.12.2017.
 */
@XmlRootElement
@Entity
@Table(name="t_movies")
@NamedQuery(name="Movie.selectAll", query="SELECT n FROM Movie n")
public class Movie {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
  private String originalTitle;
  private Integer releaseYear;
  @ManyToOne (optional = false, targetEntity = Studio.class)
  private Studio studio;
  @ManyToMany(mappedBy = "movies")
  private Collection<Actor> actors;
  
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
