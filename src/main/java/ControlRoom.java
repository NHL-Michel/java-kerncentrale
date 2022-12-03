import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.asList;

public class ControlRoom {
    private ArrayList<Statusable> states;

    public ControlRoom(ArrayList<Statusable> states) {
        this.states = states;
    }

    public ControlRoom() {
        this.states = new ArrayList<>();
    }

    /** isNuclearReactorStable()
     *
     * checks if the nuclear reactor is stable in all rooms
     *
     * @return true if all rooms are stable, false if 1 or more rooms need attention or are unstable
     */
    public boolean isNuclearReactorStable(){
        for (Statusable state : this.states) {
            // state.getStatus() != State.STABLE
            if (!state.getStatus().equals(State.STABLE)){
                return false;
            }
        }
        return true;
    }

    public void addState(Statusable s){
        this.states.add(s);
    }
}
