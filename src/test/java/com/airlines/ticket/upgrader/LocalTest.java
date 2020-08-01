package com.airlines.ticket.upgrader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import junit.framework.TestCase;

/**
 * Unit test for TicketUpgrader App.
 */
public class LocalTest extends TestCase {

  public void testAllValidData() {
    // Delete Output File If Exist Before it
    final ClassLoader classLoader = this.getClass().getClassLoader();

    deleteOutputFilesIfExist(classLoader, "csv/Input_2_valid.csv", "csv/Input_2_invalid.csv");

    final ITicketsProcessor processor = TicketsUpgrader.getProcessorWithDefaultFileLocation("Input_2.csv");
    processor.processTickets();

    validateRecordCount(classLoader, "csv/Input_2_valid.csv", 5);
    validateRecordCount(classLoader, "csv/Input_2_invalid.csv", 0);

  }

  private void deleteOutputFilesIfExist(final ClassLoader classLoader, final String... files) {
    final URL validFileD = classLoader.getResource(files[0]);
    final URL invalidFileD = classLoader.getResource(files[1]);

    if (invalidFileD != null) {
      final File configFileD = new File(validFileD.getFile());
      configFileD.delete();
    }

    if (invalidFileD != null) {
      final File configFileD = new File(invalidFileD.getFile());
      configFileD.delete();
    }
  }

  private void validateRecordCount(final ClassLoader classLoader, final String filePath, final int count) {
    final File configFile = new File(classLoader.getResource(filePath).getFile());

    try (BufferedReader br = new BufferedReader(new FileReader(configFile.getAbsoluteFile()))) {

      // Skip First line as it contains headers
      br.readLine();

      int records = 0;

      // Read Remaing lines which contains actual data
      while (br.readLine() != null) {
        ++records;
      }
      assertEquals(records, count);

    } catch (final IOException e) {
      assertTrue(false);
    }
  }

}
