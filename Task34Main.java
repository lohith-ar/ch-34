import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class Task34Main{
    static int noofrecords = 0;
    static String[] pid;
    static String[] data;
    static String[] data1;

    public static void main(String[] args) throws Exception {
        String l = "";
        FileReader f;
        try {
            f = new FileReader("flipkart_product_sample.csv");
            BufferedReader br = new BufferedReader(f);
            l=br.readLine();
            while ((l = br.readLine()) != null) {
                noofrecords++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        pid = new String[noofrecords];
        data = new String[noofrecords];


        Task34Main.readFromFile();
        data1 = new String[noofrecords];
        for (int j = 0; j < noofrecords - 1; j++) {
            data1[j] = data[j];
        }
    
        
        QuickSort.quickSort(pid, 0 , pid.length-1);
        // for(String pids: pid) System.out.println(pids);
        Task34Main.binarySearch(pid, "ACCDVFK6KGJUGSRH", 0, pid.length);
        Task34Main.binarySearch(pid, "SHTEBTB9JZZZKYBD", 0, pid.length);
        Task34Main.binarySearch(pid, "SHTEBTB9JZZZKYCD", 0, pid.length);

        
        // Task34Main.binarySearch(pid, "SHTEBS8Z97ECWYXJ", 0, pid.length-1);


        


    }

    static void readFromFile() {
        String l = "";
        int i = 0;

        FileReader f;
        try {
            f = new FileReader("flipkart_product_sample.csv");
            BufferedReader br = new BufferedReader(f);
            l = br.readLine();
            String tempString = "";
            while ((l = br.readLine()) != null) {

                data[i] = l;
                tempString = l.replaceAll("No rating available", "0");
                String temp1[] = tempString.split(",");
                pid[i] = temp1[0];
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception io) {
            io.printStackTrace();
        }
    }


    static int binarySearch(String[] pid, String item, int low, int high) {
    int index = 0;    
    while (low <= high ) {
        int mid = (low + high) / 2;
        if (pid[mid].compareTo(item)<0) {
            low = mid + 1;
        } else if (pid[mid].compareTo(item)>0) {
            high = mid - 1;
        } else if (pid[mid].compareTo(item)==0) {
            index = mid;
            System.out.println("\n"+item+" Element found");
            break;
        }
    }
    if(low>high) System.out.println("\n"+item+" pid is not found.");
    return -1;

   
}
    
}
