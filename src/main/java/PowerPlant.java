import java.util.logging.Level;
import java.util.logging.Logger;

public class PowerPlant {
    private Generator generator;
    private Reactor reactor;
    private CoolingSystem coolingSystem;
    private final Logger mdLogger = Logger.getLogger("meltdown logger");

    public PowerPlant(Generator generator, Reactor reactor, CoolingSystem coolingSystem) {
        this.generator = generator;
        this.reactor = reactor;
        this.coolingSystem = coolingSystem;

        ControlRoom controlRoom = new ControlRoom();
        controlRoom.addState(generator);
        controlRoom.addState(reactor);
        controlRoom.addState(coolingSystem);
    }

    public Generator getGenerator() {
        return generator;
    }

    public void setGenerator(Generator generator) {
        this.generator = generator;
    }

    public Reactor getReactor() {
        return reactor;
    }

    public void setReactor(Reactor reactor) {
        this.reactor = reactor;
    }

    public CoolingSystem getCoolingSystem() {
        return coolingSystem;
    }

    public void setCoolingSystem(CoolingSystem coolingSystem) {
        this.coolingSystem = coolingSystem;
    }

    public float run(int temp, int timeInSeconds) {
        try {
            for (Core core : reactor.getCores()) {
                SplitResult sr = core.split(    temp, timeInSeconds);
                generator.generateEnergy(sr.getSteam());
                coolingSystem.abductResidualHeat(sr.getResidualHeat());
            }
        } catch (MeltDownException me) {
            mdLogger.log(Level.SEVERE, String.format("%s", me));
        }
        return generator.getTotalYieldInKwh();
    }
}
