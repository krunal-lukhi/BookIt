package fwk.lifecycle;

import fwk.common.LoggingUtils;
import org.slf4j.Logger;
import org.springframework.context.SmartLifecycle;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author Krunal Lukhi
 * @since 06/08/23
 */
public abstract class AbstractAppSmartLifeCycle implements SmartLifecycle {
    protected final static Logger LOGGER = LoggingUtils.getLogger(AbstractAppSmartLifeCycle.class);
    private final AtomicReference<State> state = new AtomicReference<State>();

    private Layer layer;

    public AbstractAppSmartLifeCycle(Layer layer) {
        this.layer = layer;
    }

    public void onStart() {

    }

    public abstract void onStop() throws Exception;

    @Override
    public void start() {
        LOGGER.info("staring: {} [layer {}] using SmartLifeCycle", getClass().getSimpleName(), layer.name());
        state.set(State.STARTED);
        onStart();
    }

    @Override
    public void stop(Runnable callback) {
        stop();
        if (callback != null) {
            callback.run();
        }
    }

    @Override
    public int getPhase() {
        return layer.phase;
    }

    @Override
    public void stop() {
        if (state.compareAndSet(State.STARTED, State.STOPPED)) {
            try {
                LOGGER.info("stopping: {} [layer {}] using SmartLifeCycle", getClass().getSimpleName(), layer.name());
                onStop();
            } catch (Exception e) {
                LOGGER.warn("Could not stop safely: {} [layer {}] using SmartLifeCycle", getClass().getSimpleName(), layer.name());
            }
        }
    }

    @Override
    public boolean isAutoStartup() {
        return true;
    }

    @Override
    public boolean isRunning() {
        return state.get() == State.STARTED;
    }

    public enum State {
        STARTED,
        INIT,
        STOPPED,
        ;
    }

    public enum Layer {
        APPLICATION(1),
        PERSISTENCE(2),
        ;
        private int phase;

        Layer(int phase) {
            this.phase = phase;
        }
    }
}
