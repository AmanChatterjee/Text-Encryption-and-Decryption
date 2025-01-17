import java.io.*;

class Decrypt {
    private static int key;
    private static String decText;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    // Decryption Method
    private String decrypt(String s) {
        String abt = "1'b[sg-(Sk<B*Copj03R=KaNc\"fJw6;?#q+z.G}My$HVU\\7W2/tQ:e,OD_4FPhi YX])v|A@8>n&duTL!lIrE{%m9Z5x^";
        String dec = ""; 

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int j = abt.indexOf(c);
            int d_index = (j - key) % abt.length();
            if (d_index < 0) {
                d_index += abt.length();
            }
            char decrypted_char = abt.charAt(d_index);
            dec += decrypted_char;
        }

        return dec;
    }

    // Read file method
    private String readFile() throws IOException {
        String adrs, s, str = ""; // Path address of file containing encrypted text
        boolean status;
        do {
            status = false;
            System.out.print("Enter the file path: ");
            adrs = br.readLine(); // Read the entire line including spaces
            try {
                File file = new File(adrs);
                if (!file.exists() || file.isDirectory()) {
                    throw new FileNotFoundException("File does not exist or it is a directory.");
                }
                BufferedReader fileReader = new BufferedReader(new FileReader(file));
                while ((s = fileReader.readLine()) != null) {
                    str += s;
                }
                fileReader.close(); 
            } catch (FileNotFoundException exc) {
                System.out.println("Error: " + exc.getMessage());
                System.out.println("Try again.");
                status = true;
            }
        } while (status);
        
        return str;
    }

    // Main method
    public static void main(String args[]) throws IOException {
        Decrypt obj = new Decrypt();
        System.out.println("\nEnter the key for decryption: ");
        key = Integer.parseInt(br.readLine());
        // Read the content of the file into a string
        String rdText = obj.readFile();
        System.out.println("\nThe Encrypted Text:");
        for (int i = 0; i < rdText.length(); i++) {
            System.out.print(rdText.charAt(i));
        }
        decText = obj.decrypt(rdText); 
        System.out.println("\nThe Decrypted Text is: " + decText);
    }
}
