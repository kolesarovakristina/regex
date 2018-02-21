import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String [] args) {
        String fileName = "rawText.txt";
        String line = null;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            Pattern pattern1 = Pattern.compile("(B(A|B|C|J|L|N|R|S|Y)|CA|D(K|S|T)|G(A|L)|H(C|E)|IL|K(A|I|E|K|M|N|S)|L(E|C|M|V)|M(A|I|L|T|Y)|N(I|O|M|R|Z)|P(B|D|E|O|K|N|P|T|U|V)|R(A|K|S|V)|S(A|B|C|E|I|K|L|O|N|P|V)|T(A|C|N|O|R|S|T|V)|V(K|T)|Z(A|C|H|I|M|V))([ ]{0,1})([0-9]{3})([A-Z]{2})");
            Pattern pattern2 = Pattern.compile("([0-9]{2})(01|02|03|04|05|06|07|08|09|10|11|12|51|52|53|54|55|56|57|58|59|60|61|62)(([0]{1}[1-9]{1})|([1-2]{1}[0-9]{1})|([3]{1}[0-1]{1}))/([0-9]{3,4})");
            Pattern pattern3 = Pattern.compile("([0-9A-Fa-f]{2}[:]){5}([0-9A-Fa-f]{2})");
            FileWriter spz = new FileWriter("SPZ.txt");
            FileWriter roc = new FileWriter("RC.txt");
            FileWriter mac = new FileWriter("MacAdress.txt");


            while ((line = bufferedReader.readLine()) != null) {

                Matcher patt1 = pattern1.matcher(line);
                if (patt1.find()) {

                    int start = patt1.start(0);
                    int end = patt1.end(0);
                    spz.write(line.substring(start, end));
                    spz.write("; ");
                }

                Matcher patt2 = pattern2.matcher(line);
                if (patt2.find()) {

                    int start = patt2.start(0);
                    int end = patt2.end(0);
                    roc.write(line.substring(start, end));
                    roc.write("; ");
                }

                Matcher patt3 = pattern3.matcher(line);
                 if (patt3.find()) {

                    int start = patt3.start(0);
                    int end = patt3.end(0);
                    mac.write(line.substring(start, end));
                    mac.write("; ");
                }
            }
            spz.close();
            mac.close();
            roc.close();
        } catch(IOException e)
        {
            System.out.println("Error");
        }
    }
}
