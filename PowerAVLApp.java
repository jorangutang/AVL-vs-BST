/**
 * @author Jesse Smart
 *  01/03/2019
 * This is the driver class for the PowerBST.
 * It can run in the terminal with the argument for a specific search or without on which returns all.
 */
public class PowerAVLApp{
    public static void main(String[] args) throws Exception {
        PowerAVL poweravl = new PowerAVL(500);

        if(args.length != 0)
        {
            if (args[0].contains("txt")){
                poweravl.FileIteratorFind(args[0]);
            }
            else if (poweravl.find(args[0]) == null){
                System.out.println(args[0] + "  could not be found.");
            }
            else{
                poweravl.printDateTimeAVL(args[0]);
                System.out.println("Number of Search comparison operations performed: " + poweravl.getFindFrequency());
                System.out.println("Number of Insertion comparison operations performed: " + poweravl.getInsertFrequency());
            }
        }
        else{
            poweravl.printAllDateTimesAVL();
        }
    }
}

