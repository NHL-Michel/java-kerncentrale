import java.time.LocalDateTime;

public class PowerPlant {
    private Generator generator;
    private Reactor reactor;
    private CoolingSystem coolingSystem;

    public PowerPlant(Generator generator, Reactor reactor, CoolingSystem coolingSystem) {
        this.generator = generator;
        this.reactor = reactor;
        this.coolingSystem = coolingSystem;
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
        for (Core core : reactor.getCores()){
            SplitResult sr = core.split(temp, timeInSeconds);
            generator.generateEnergy(sr.getSteam());
            coolingSystem.abductResidualHeat(sr.getResidualHeat());
        }
        return generator.getTotalYieldInKwh();
    }
}
