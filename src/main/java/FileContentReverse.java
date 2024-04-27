import java.io.*;

/**
 * @Author Puspa Tripathy
 */
public class FileContentReverse {


    /** This method will reverse the provided string
     *
     * @param strFileContent
     * @return
     */
    public String reverseContent(String strFileContent) {

        System.out.println("strFileContent  "+strFileContent);
        StringBuilder builder = new StringBuilder(strFileContent);
        return builder.reverse().toString();
    }

    /**
     * Thid method will read from input file.
     * @param reader
     * @return
     * @throws IOException
     */
    public String readFileContent(Reader reader) throws IOException {
        BufferedReader br = null;

        StringBuilder lines = new StringBuilder();
        try {
            br = new BufferedReader(reader);
            String st;
            while ((st = br.readLine()) != null) {
                System.out.println(st);
                lines.append(st);
                lines.append("\n");
            }
        }
        catch (IOException e)
        {
            System.out.println("IOException +" + e.getMessage()) ;
            throw e;
        }
        catch (Exception e)
        {
            System.out.println("Exception +" + e.getMessage()) ;
            throw e;
        }
        finally {
            try {
                if(null!=reader && null != br) {
                    reader.close();
                    br.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            ;
        }
        return (lines.length()>0)?lines.deleteCharAt(lines.length()-1).toString():null;
    }

    /**
     * This method will write to an output file
     * @param strInput
     * @param writer
     * @return
     * @throws IOException
     */
    public boolean writeToFile(String strInput,Writer writer) throws IOException {
        boolean isWriten = false;
        System.out.println("strInput  :: "+strInput);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write(strInput);
        bw.flush();
        writer.close();
        bw.close();
        isWriten = true;
        return isWriten;
    }
}
