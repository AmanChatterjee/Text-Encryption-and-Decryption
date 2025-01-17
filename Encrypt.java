import java.io.*;

class Encrypt {
    // Instance variables
    private static int key;          // Encryption key
    private static String inpText;   // Input text to be encrypted
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // Encryption method
    private String encrypt(String inpText) {
        String abt = "1'b[sg-(Sk<B*Copj03R=KaNc\"fJw6;?#q+z.G}My$HVU\\7W2/tQ:e,OD_4FPhi YX])v|A@8>n&duTL!lIrE{%m9Z5x^";
        char c, d;
        int j;
        String enc = new String();

        for(int i = 0 ; i < inpText.length() ; i++){
            c = inpText.charAt(i);
            j = abt.indexOf(c);
            d = abt.charAt((j+key)%(abt.length()));
            enc += d;
        }

        return enc; //encrypted text
    }

    // Write to file method
    public void writeToFile(String enc, String filePath) throws IOException {
    File file = new File(filePath);

    boolean fileExists = file.exists();

    try (FileWriter writer = new FileWriter(file)) {
        writer.write(enc); // Write encrypted text to file
        if (!fileExists) {
            System.out.println("\nSuccessfully written to new file: " + file.getName());
        } else {
            System.out.println("\nOverwriting the File \nSuccessfully Overwritten file: " + file.getName());
        }
    } catch (IOException exc) {
        System.out.println("Error! Could not write to file.");
        exc.printStackTrace();
    }
}


    // Main method
    public static void main(String[] args) throws IOException {
        Encrypt obj = new Encrypt();

        System.out.print("Enter the key for encryption: ");

        // Read encryption key from user
        do {
            key = Integer.parseInt(br.readLine());
            if (key == 93) { // If key is 93, encrypted text will be the same as input text
                System.out.print("Choose another key: ");
                continue;
            }
            break;
        } while (true);

        System.out.print("Enter the string: ");
        inpText = br.readLine();

        String encText = obj.encrypt(inpText);

        System.out.println("\nEncrypted String: " + encText);

        System.out.print("\nEnter path of the file.\nSample path: C:\\Users\\Name\\Location\\Encrypt.txt\nInput path: ");
        String filePath = br.readLine(); // Read file path input from user

        obj.writeToFile(encText, filePath);
    }
}
