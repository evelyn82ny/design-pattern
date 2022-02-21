package nayoung.designpattern.trace.templateMethodPattern;

import nayoung.designpattern.trace.LogTrace;
import nayoung.designpattern.trace.TraceStatus;

public abstract class AbstractTemplate<T> {

    private final LogTrace trace;

    public AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public T execute(String message) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);
            T result = order();
            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

    protected abstract T order();
}
