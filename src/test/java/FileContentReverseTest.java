import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class FileContentReverseTest {

   private FileContentReverse  reverse;


   @BeforeEach
   void init()
   {
       reverse  = new FileContentReverse();
   }

   @AfterEach
   void teardown()
   {
      reverse = null;
   }

   @Test
   void testReverseContent()
   {
       assertEquals("CBA",reverse.reverseContent("ABC"));
   }

   @Test
   void testReadFileContent() throws IOException {

      String expectedContent = "ABC";
      Reader mockedReader = new StringReader(expectedContent);
      String actualContent = reverse.readFileContent(mockedReader);
      assertEquals(expectedContent, actualContent);
   }

   @Test
   void testReadFileContentWithMultiLine() throws IOException {

      String expectedContent = "ABC\nCDE\nFGH";
      Reader mockedReader = new StringReader(expectedContent);
      String actualContent = reverse.readFileContent(mockedReader);
      assertEquals(expectedContent, actualContent);
   }

   @Test
   void testReadFileContentWithException()
   {
      assertThrows(NullPointerException.class,
              ()->{reverse.readFileContent(null);} );
   }

   @Test
   void testWriteToOutputFile() throws IOException {
      Writer mockedWriter = new StringWriter(3);
      assertTrue(reverse.writeToFile("ABC\nCDE\nFGH",mockedWriter));
   }

   @Test
   void testWriteToOutputFileWithException()
   {
      assertThrows(NullPointerException.class,
              ()->{reverse.writeToFile("ABC\nCDE\nFGH",null);} );
   }

}
