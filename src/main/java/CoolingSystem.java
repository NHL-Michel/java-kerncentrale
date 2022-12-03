public class CoolingSystem implements Statusable {

    private float waterTemp;

    public CoolingSystem() {
        this.waterTemp = 0;
    }

    public float getWaterTemp() {
        return waterTemp;
    }

    public void setWaterTemp(float waterTemp) {
        this.waterTemp = waterTemp;
    }

    /**
     * getStatus()
     *
     * @return the state of the CoolingSystem room.
     */
    public State getStatus() {
        if (this.waterTemp > 80 && this.waterTemp < 90) {
            return State.ATTENTION;
        } else if (this.waterTemp > 90) {
            return State.UNSTABLE;
        }
        return State.STABLE;
    }

    public void abductResidualHeat(float residualHeat) {
        this.waterTemp = residualHeat * 0.50f;
    }

}
