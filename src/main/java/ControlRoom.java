import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.asList;

public class ControlRoom {
    private Generator generator;
    private CoolingSystem coolingSystem;
    private Reactor reactor;

    public ControlRoom(Generator generator, CoolingSystem coolingSystem, Reactor reactor) {
        this.generator = generator;
        this.coolingSystem = coolingSystem;
        this.reactor = reactor;
    }

    public Generator getGenerator() {
        return generator;
    }

    public void setGenerator(Generator generator) {
        this.generator = generator;
    }

    public CoolingSystem getCoolingSystem() {
        return coolingSystem;
    }

    public void setCoolingSystem(CoolingSystem coolingSystem) {
        this.coolingSystem = coolingSystem;
    }

    public Reactor getReactor() {
        return reactor;
    }

    public void setReactor(Reactor reactor) {
        this.reactor = reactor;
    }

    /** isNuclearReactorStable()
     *
     * checks if the nuclear reactor is stable in all rooms
     *
     * @return true if all rooms are stable, false if 1 or more rooms need attention or are unstable
     */
    public boolean isNuclearReactorStable(){
        boolean stable;
        String stateStable = Statusable.State.STABLE.toString();

        if (generator.getStatus().equals(stateStable) && coolingSystem.getStatus().equals(stateStable) && reactor.getStatus().equals(stateStable)){
            stable = true;
        } else {
            stable = false;
        }

        return stable;
    }
}
