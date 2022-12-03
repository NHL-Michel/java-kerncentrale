public class Nhlium extends Core  {

    @Override
    public SplitResult split(int tmpInKelvin, int timeInSeconds) throws MeltDownException {
        float steam;
        float residualHeatInKelvin;
        this.remainingPercentage = this.remainingPercentage - (0.06f * timeInSeconds);

        if (tmpInKelvin < 323){
            steam = (float) tmpInKelvin / 62 * timeInSeconds * 0.7f;
            residualHeatInKelvin = timeInSeconds * 5f;
        } else {
            steam = (float) (0.9f * tmpInKelvin * 0.5f / timeInSeconds * Math.sqrt(4) * timeInSeconds);
            residualHeatInKelvin = tmpInKelvin / 0.5f;
        }

        if (timeInSeconds > 60 && tmpInKelvin > 100 || this.remainingPercentage < 0.1){
            throw new MeltDownException("NHLIUM MELTDOWN, WE F*CKED UP ");
        }

        return new SplitResult(residualHeatInKelvin, steam);
    }
}
