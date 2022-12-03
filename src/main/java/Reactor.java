import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Reactor implements Statusable {
    private Set<Core> cores;

    public Reactor() {
        this.cores = new HashSet<Core>();
    }

    public Set<Core> getCores() {
        return cores;
    }

    public void setCores(Set<Core> cores) {
        this.cores = cores;
    }

    private void addCore(Core c) {
        this.cores.add(c);
    }

    private Core removeCore(Core c) {

        Iterator<Core> it = this.cores.iterator();
        while (it.hasNext()) {
            Core tmpCore = it.next();
            if (tmpCore.equals(c)) {
                it.remove();
                return tmpCore;
            }
        }
        return null;
    }

    public State getStatus() {
        for (Core core : this.cores) {
            if (core.getRemainingPercentage() <= 0.2) {
                return State.ATTENTION;
            }
        }
        return State.STABLE;
    }
}
