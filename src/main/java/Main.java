import java.io.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException {
        FileContentReverse fileContentReverse = new FileContentReverse();
        FileReader reader = new FileReader("src/main/resources/Input.txt");
        String strInput =  fileContentReverse.readFileContent(reader);
        System.out.println("strInput  :: "+strInput);
        String reverseString = fileContentReverse.reverseContent(strInput);
        System.out.println("reverseString  :: "+reverseString);
        File file = new File("src/main/resources/output.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileWriter writer = new FileWriter(file);
        boolean isWritten = fileContentReverse.writeToFile(reverseString,writer);
        System.out.println("isWritten  :: "+isWritten);

    }

}