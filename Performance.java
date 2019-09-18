/**
 * @author Jesse Smart
 * SMRJES001
 */
public class Performance {
    int MAX = 0;
    int MIN = 35;
    int TOTAL = 0;
    int size = 1;
    double average;

    public Performance(int size){
        this.size = size;
    }

    public void UpdatePerformance(int i ){
        if (MAX == 0){
            MAX = i;
            MIN = i;
            TOTAL += i;
        }
        else {
            if( i > MAX) {
                MAX = i;
            }
            if( i < MIN){
                MIN = i;
            }
            TOTAL += i;
        }

    }
    public String PrinterFIND(){
        return "Search Performance for subset size " + size + "=  Min: " + MIN +"  Max: " + MAX + "  Average: " + this.getAverage() ;
    }
    public int getMAX() {
        return MAX;
    }

    public int getMIN() {
        return MIN;
    }

    public double getAverage() {
        if (size == 0){
            this.size = 1;
        }
        return  ( TOTAL/size*100)/100;
    }

    public int getTOTAL() {
        return TOTAL;
    }
    //each set for each tree size will be one object.
    //the objects can then be stored in a list
}
