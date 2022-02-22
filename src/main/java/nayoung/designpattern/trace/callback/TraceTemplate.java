package nayoung.designpattern.trace.callback;

import nayoung.designpattern.trace.LogTrace;
import nayoung.designpattern.trace.TraceStatus;
import org.springframework.stereotype.Component;

@Component
public class TraceTemplate {

    private final LogTrace trace;

    public TraceTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public <T> T execute(String message, TraceCallback<T> callback) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);
            T result = callback.order();
            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}
