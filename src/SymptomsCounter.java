import java.util.ArrayList;
import java.util.TreeMap;

public class SymptomsCounter {

    public static void main(String args[]) throws Exception {

        /**
         *  BufferedReader and FileReader can be used to read a txt file
         */
        ComputeData computeData = new ComputeData("symptoms.txt");
        ArrayList<String> unsortedSymptoms = computeData.getSymptoms();
        TreeMap<String, Integer> sortedSymptoms = computeData.compute(unsortedSymptoms);
        /**
        * FileWriter, BufferedWriter, Set, Iterator, Map
         * */

        computeData.writeSymptoms(sortedSymptoms, "results.txt");


        /**
         * send the result.txt file into a list of String, send the list into a treemap
         * to order it, write the treemap into a file results.out.txt
         */
       // computeData.writeSymptoms(computeData.compute(computeData.getSymptoms()), "results.txt");

    }
}
