public class SplitResult {
    private float residualHeatInKelvin;
    private float steam;

    public SplitResult(float residualHeatInKelvin, float steam) {
        this.residualHeatInKelvin = residualHeatInKelvin;
        this.steam = steam;
    }

    public float getResidualHeat() {
        return residualHeatInKelvin;
    }

    public float getSteam() {
        return steam;
    }
}
