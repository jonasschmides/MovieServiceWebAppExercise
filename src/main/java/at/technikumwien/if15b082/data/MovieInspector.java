package at.technikumwien.if15b082.data;

import org.jboss.logging.Logger;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.Collection;
import java.util.stream.Collectors;

public class MovieInspector {
    private final static Logger LOGGER = Logger.getLogger(MovieInspector.class);
    private final static int MAX_SIZE = 3;

    @AroundInvoke
    public Object filter(InvocationContext ic) throws Exception {
        LOGGER.info("filter()");
        LOGGER.debugf("> method: %s", ic.getMethod().getName());

        Object result = ic.proceed();
        if (result == null || !(result instanceof Collection)) {
            return result;
        }

        Collection<?> collection = (Collection<?>) result;
        return collection
                .stream()
                .limit(MAX_SIZE)
                .collect(Collectors.toList());
    }
}
