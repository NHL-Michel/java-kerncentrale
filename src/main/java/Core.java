public abstract class Core {
    public static final int FULL_PERCENTAGE = 100;
    protected float remainingPercentage;

    public Core() {
        this.remainingPercentage = FULL_PERCENTAGE;
    }

    public abstract SplitResult split(int tmpInKelvin, int timeInSeconds) throws MeltDownException;

    public float getRemainingPercentage() {
        return remainingPercentage;
    }

    public void setRemainingPercentage(int remainingPercentage) {
        this.remainingPercentage = remainingPercentage;
    }
}
