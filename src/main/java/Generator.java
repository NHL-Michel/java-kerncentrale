public class Generator implements Statusable {
    private float totalYieldInKwh;

    public Generator() {
        this.totalYieldInKwh = 0;
    }

    public float getTotalYieldInKwh() {
        return totalYieldInKwh;
    }

    public void setTotalYieldInKwh(float totalYieldInKwh) {
        this.totalYieldInKwh = totalYieldInKwh;
    }

    /**
     * getStatus()
     *
     * @return state of the Generator
     */
    public State getStatus() {
        if (this.totalYieldInKwh > 560f) {
            return State.UNSTABLE;
        }
        return State.STABLE;
    }

    public float generateEnergy(float steam) {
        float yieldInKwh = steam * 7.0f;
        this.totalYieldInKwh += yieldInKwh;

        return yieldInKwh;
    }
}
