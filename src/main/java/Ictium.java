public class Ictium extends Core {

    @Override
    public SplitResult split(int tmpInKelvin, int timeInSeconds) {
        float steam = 40 * tmpInKelvin;
        float residualHeatInKelvin = timeInSeconds / 0.3f * 18;

        if (tmpInKelvin > 333) {
            this.remainingPercentage = this.remainingPercentage - 0.00006f * tmpInKelvin * timeInSeconds + 0.0004f;
        }

        return new SplitResult(residualHeatInKelvin, steam);
    }
}
