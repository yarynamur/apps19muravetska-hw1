package ua.edu.ucu.tempseries;

public class TemperatureSeriesAnalysis {
    double[] tempSeries;
    int len;
    double tempminimum = - 273;

    public TemperatureSeriesAnalysis() {

    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) a

    public void checklen(){
        if (this.len==0){
            throw new IllegalArgumentException();
        }
    }

    public double average() {
        this.checklen();
        int sum=0;
        for(int i=0; i<this.len; i++) {
            sum+=this.tempSeries[i];
        }
        int avarage=sum/this.len;
        return avarage;
    }

    public double deviation() {
        this.checklen();
        double avg = this.average();
        double devSum = 0;
        for(int i=0; i<this.len; i++) {
            devSum+=Math.pow(this.tempSeries[i]-avg, 2);
        }
        double deviation = Math.sqrt(devSum/this.len);
        return deviation;
    }

    public double min() {
        this.checklen();
        double min = 0;
        for(int i=0; i<this.len; i++){
            if (this.tempSeries[i]<min){
                min = this.tempSeries[i];
            }
        }
        return min;
    }

    public double max() {
        this.checklen();
        double min = 0;
        for(int i=0; i<this.len; i++){
            if (this.tempSeries[i]>min){
                min = this.tempSeries[i];
            }
        }
        return min;

    public double findTempClosestToZero() {
        this.checklen();
        double closestToZero;
        double smallestDist = Integer.MAX_VALUE;
            for(int i=0; i<this.len; i++){
                if (Math.abs(this.tempSeries[i]) < smallestDist) {
                    smallestDist = Math.abs(this.tempSeries[i]);
                    closestToZero = this.tempSeries[i];
                }
                if (Math.abs(this.tempSeries[i]) == smallestDist){
                    if (this.tempSeries[i] > closestToZero){
                        closestToZero = this.tempSeries[i];
                    }
                }
            }

        return closestToZero;
    }

    public double findTempClosestToValue(double tempValue) {
        this.checklen();
        double closestToValue;
        double smallestDist = Integer.MAX_VALUE;
        for(int i=0; i<this.len; i++){
            double dist = Math.abs(tempValue - this.tempSeries[i]);
            if (dist < smallestDist) {
                smallestDist =dist;
                closestToValue = this.tempSeries[i];
            }
            if (dist == smallestDist){
                if (this.tempSeries[i] > closestToValue){
                    closestToValue = this.tempSeries[i];
                }
            }
        }
        return closestToValue;
    }

    public double[] findTempsLessThen(double tempValue) {
        this.checklen();
        int size = 0;
        for(int i=0; i<this.len; i++){
            if (this.tempSeries[i] < tempValue){
                size++;
            }
        }
        double newArraay[size];
        int index = 0;
        for(int i=0; i<this.len; i++){
            if (this.tempSeries[i] < tempValue){
                newArraay[index] = this.tempSeries[i];
                index++;
            }
        }
        return newArraay;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        this.checklen();
        int size = 0;
        for(int i=0; i<this.len; i++){
            if (this.tempSeries[i] < tempValue){
                size++;
            }
        }
        double newArraay[size];
        int index = 0;
        for(int i=0; i<this.len; i++){
            if (this.tempSeries[i] < tempValue){
                newArraay[index] = this.tempSeries[i];
                index++;
            }
        }
        return newArraay;
    }

    public TempSummaryStatistics summaryStatistics() {
        this.checklen();
        return new TempSummaryStatistics(this);
    }

    public int addTemps(double... temps) {
        double sum = 0;
        int curLen = this.tempSeries.length;
        for(int i=0; i<temps.lenght; i++){
            if (curLen == this.tempSeries.length) {
                int newTemps =new double[this.len*2];
                System.arraycopy(this.tempSeries,0, newTemps, 0, this.len);
                }
            this.tempSeries[curLen++] = temps[i];
        }
        for (int i=0; i<this.tempSeries.lenght; i++){
            sum += this.tempSeries[i];
        }
        return sum;
        }
    }
}


