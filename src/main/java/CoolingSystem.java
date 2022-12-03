public class CoolingSystem implements Statusable {

    private float waterTemp;
    private State status;

    public CoolingSystem() {
        this.waterTemp = 0;
    }

    public float getWaterTemp() {
        return waterTemp;
    }

    public void setWaterTemp(float waterTemp) {
        this.waterTemp = waterTemp;
    }

    /**  getStatus()
     *
     * @return the state of the CoolingSystem room.
     *
     */
    public String getStatus(){
        this.setStatus();
        return this.status.toString();
    };

    /** setStatus()
     *
     * set the status of the CoolingSystem based on the water temperature
     *
     */
    public void setStatus(){
        if (this.waterTemp > 80 && this.waterTemp < 90) {
            this.status = State.ATTENTION;
        } else if (this.waterTemp > 90) {
            this.status = State.UNSTABLE;
        } else {
            this.status = State.STABLE;
        }
    };

    public void abductResidualHeat(float residualHeat){
        this.waterTemp = residualHeat * 0.50f;
    }

}
