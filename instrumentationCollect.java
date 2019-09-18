import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class instrumentationCollect {

    public instrumentationCollect() {
    }

    public void InstrumentationBSTUpdate(Performance[] temp) throws IOException {
        try (PrintWriter writer = new PrintWriter("InstrumentationBST.txt", "utf-8")) {
            for (Performance num : temp) {
                writer.write(num.PrinterFIND() + "\r\n");
            }
        }
    }
    public void InstrumentationAVLUpdate(Performance[] temp) throws IOException {
        try (PrintWriter writer = new PrintWriter("InstrumentationAVL.txt", "utf-8")) {
            for (Performance num : temp) {
                writer.write(num.PrinterFIND() + "\r\n");
            }
        }
    }


    public void CreateBSTcsv(Performance[] temp) throws IOException {
        try (PrintWriter writer = new PrintWriter("BST_InstrumentationCSV.csv", "UTF-8")) {
            String out = "";
            String lineSep = System.getProperty("line.separator");
            for (Performance each : temp) {
               writer.print(each.MAX);
               writer.print("; ");
               writer.print(each.MIN);
               writer.print("; ");
               writer.println(each.getAverage());

            }
        }
    }
    public void CreateAVLcsv(Performance[] temp) throws IOException {
        try (PrintWriter writer = new PrintWriter("AVL_InstrumentationCSV.csv", "UTF-8")) {
            for (Performance each : temp) {
                writer.print(each.MAX);
                writer.print("; ");
                writer.print(each.MIN);
                writer.print("; ");
                writer.println(each.getAverage());

            }
        }
    }
}