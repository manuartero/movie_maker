package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Helper class, no neeed to extend or instanciate it
 * <p>
 * @author manutero
 */
public final class FileHelper {

  private FileHelper() {
    throw new AssertionError();
  }

  /**
   * Read a .txt file and return each line as a String in a Java list
   * <p>
   * @param filePath path to a non binary file
   * @return list of each read line of the txt file
   */
  public static List<String> readTextFile(String filePath) {
    List<String> response = new LinkedList<>();
    try {
      BufferedReader br = new BufferedReader(new FileReader(filePath));
      String line;
      while ((line = br.readLine()) != null) {
        if (!line.equals("")) {
          response.add(line);
        }
      }
      br.close();
    } catch (IOException e) {
      java.util.logging.Logger.getLogger(FileHelper.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
    } 
    return response;
  }

}
