package at.technikumwien.if15b082.data;

import org.jboss.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by rsoff on 04.12.2017.
 */

@Stateless
public class MovieService {
  private final static Logger LOGGER = Logger.getLogger(MovieService.class);

  @PersistenceContext
  private EntityManager em;
  @Resource
  private SessionContext ctx;

  @Interceptors(MovieInspector.class)


  public List<Movie> getAllMovies() {
    LOGGER.info("getAllMovies()");
    LOGGER.debugf("> principal: %s", ctx.getCallerPrincipal());

    return em
            .createNamedQuery("News.selectAll", Movie.class)
            .getResultList();
  }
}
