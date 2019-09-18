import java.io.IOException;
import java.lang.instrument.Instrumentation;
import java.util.ArrayList;

/**
 *
 * this is a test class to test the performance of different sized BST trees
 */
public class testDrivers {

    public static void main(String[] args) throws IOException {

        Performance[] outfiles = new Performance[500];
        Performance[] outfiles2 = new Performance[500];
        instrumentationCollect out = new instrumentationCollect();

        PowerBST powerbst = new PowerBST(500);  //Trees are made here
        PowerAVL powerAVL = new PowerAVL(500);

        for (int i = 1; i <= 500; i++) {
            Performance obj2 = new Performance(i);
            Performance obj = new Performance(i);
            for (int j = 0; j < i; j++) {
                String item = powerbst.readingsNodelist[j].Datime;  //search item from the list created
                powerAVL.find(item);
                powerbst.find(item);
                obj.UpdatePerformance(powerbst.Findfrequency);
                obj2.UpdatePerformance(powerAVL.FindFrequency);
            }
            System.out.println("BST: " + obj.PrinterFIND());
            System.out.println("AVL: " + obj2.PrinterFIND());
            outfiles[i-1] = obj;
            outfiles2[i-1] = obj2;

        }
        System.out.println("The BST insertion process took: " + powerbst.getInsertfrequency() + " operation to build the tree.");
        System.out.println("The AVL insertion process took: " + powerAVL.getInsertFrequency() + " operation to build the tree.");
        out.InstrumentationBSTUpdate(outfiles);
        out.InstrumentationAVLUpdate(outfiles2);
        out.CreateAVLcsv(outfiles2);
        out.CreateBSTcsv(outfiles);
    }
}
