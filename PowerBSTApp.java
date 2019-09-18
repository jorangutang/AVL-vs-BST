/**
 * @author Jesse Smart
 *  01/03/2019
 * This is the driver class for the PowerBST.
 * It can run in the terminal with the argument for a specific search or without on which returns all.
 * This main class will run an iteration from 1 to 500.
 */
public class PowerBSTApp{
    public static void main(String[] args) throws Exception {
        //for (int i = 0; i < 500; i++) {
            PowerBST powerbst = new PowerBST(500);

            if (args.length != 0) {
                if (args[0].contains("txt")){
                    powerbst.FileIteratorFind(args[0]);
                }
                else if (powerbst.find(args[0]) == null) {
                    System.out.println(args[0] + "  could not be found.");
                }
                else {
                    powerbst.printDateTimeBST(args[0]); // this IS THE CHANGE YOU MADE!!
                    System.out.println("Number of Search comparison operations performed: " + powerbst.getFindfrequency());
                    System.out.println("Number of Insertion comparison operations performed: " + powerbst.getInsertfrequency());
                }
            } else {
                powerbst.printAllDateTimesBST();
            }
        }
    }
