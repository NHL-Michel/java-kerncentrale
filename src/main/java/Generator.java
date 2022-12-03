public class Generator implements Statusable {
    private float totalYieldInKwh;
    private State status;

    public Generator() {
        this.totalYieldInKwh = 0;
    }

    public float getTotalYieldInKwh() {
        return totalYieldInKwh;
    }

    public void setTotalYieldInKwh(float totalYieldInKwh) {
        this.totalYieldInKwh = totalYieldInKwh;
    }

    /** getStatus()
     *
     * @return state of the Generator
     */
    public String getStatus(){
        this.setStatus();
        return this.status.toString();
    };

    /** setStatus()
     *
     * set the status, based on if the total yield in Kwh is more than 560f.
     */
    public void setStatus(){
        if (this.totalYieldInKwh > 560f){
            this.status = State.UNSTABLE;
        } else {
            this.status = State.STABLE;
        }
    };

    public float generateEnergy(float steam){
        float yieldInKwh = steam * 7.0f;
        this.totalYieldInKwh += yieldInKwh;

        return yieldInKwh;
    }
}
