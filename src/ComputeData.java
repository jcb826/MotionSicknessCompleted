import java.io.*;
import java.util.*;

public class ComputeData implements ISymptomReader {

    private String filePath;

    // Setting the filepath attribute at instanciation
    public ComputeData(String filePath) {
        this.filePath = filePath;
    }

    // reads the symptoms.txt file and stores the symptoms in an ArrayList of Strings
    @Override
    public ArrayList<String> getSymptoms() {
        ArrayList<String> result = new ArrayList<String>();

        if (filePath != null) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filePath));
                String line = reader.readLine();

                while (line != null) {
                    result.add(line);
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    /**
     * Stores the List of string on a TreeMap<String, Integer> sorting at the same time the
     * symptoms and counting symptoms
     */
    public TreeMap<String, Integer> compute(List<String> symptoms) {
        TreeMap<String, Integer> result = new TreeMap<String, Integer>();
        for (String symptom : symptoms) {
            if (result.containsKey(symptom)) {
                int i = result.get(symptom) + 1;
                result.put(symptom, i);
            } else {
                result.put(symptom, 1);
            }
        }
        return result;
    }

    /**
     * Writes the treemap ( with all the symptoms ordered and with the numbers of
     * each symptom ) on a file ( result.txt)
     *
     * @param list     list of sorted symptoms
     * @param fileName name of the target file
     */

    public void writeSymptoms(TreeMap<String, Integer> list, String fileName) {
        File file = new File(fileName);
        try {
            FileWriter writer = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(writer);
            // get the whole entrys
            Set set = list.entrySet();
            // create an iterator to browse the treemap
            Iterator it = set.iterator();
            // write into the result.txt file what is into the treemap
            while (it.hasNext()) {
                Map.Entry mentry = (Map.Entry) it.next();
                bw.write(mentry.getKey() + " = " + mentry.getValue());
                bw.newLine();
            }

            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
