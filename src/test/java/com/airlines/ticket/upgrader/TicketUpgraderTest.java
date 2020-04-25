package com.airlines.ticket.upgrader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import com.airlines.ticket.upgrader.data.enums.DiscountCode;
import com.airlines.ticket.upgrader.data.enums.FieldType;
import com.airlines.ticket.upgrader.exception.exception.TicketUpgradeException;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for TicketUpgrader App.
 */
public class TicketUpgraderTest extends TestCase {

  /**
   * Create the test case
   *
   * @param testName
   *          name of the test case
   */
  public TicketUpgraderTest(final String testName) {
    super(testName);
  }

  /**
   * @return the suite of tests being tested
   */
  public static Test suite() {
    return new TestSuite(TicketUpgraderTest.class);
  }

  public void testAllInvalidData() {
    // Delete Output File If Exist Before it
    final ClassLoader classLoader = this.getClass().getClassLoader();

    deleteOutputFilesIfExist(classLoader, "csv/Input_2_valid.csv", "csv/Input_2_invalid.csv");

    final ITicketsFileProcessor processor = TicketsUpgrader.getProcessorWithDefaultFileLocation("Input_2.csv");
    processor.processFile();

    validateRecordCount(classLoader, "csv/Input_3_valid.csv", 0);
    validateRecordCount(classLoader, "csv/Input_3_invalid.csv", 5);

  }

  public void testAllValidData() {
    // Delete Output File If Exist Before it
    final ClassLoader classLoader = this.getClass().getClassLoader();

    deleteOutputFilesIfExist(classLoader, "csv/Input_2_valid.csv", "csv/Input_2_invalid.csv");

    final ITicketsFileProcessor processor = TicketsUpgrader.getProcessorWithDefaultFileLocation("Input_2.csv");
    processor.processFile();

    validateRecordCount(classLoader, "csv/Input_2_valid.csv", 5);
    validateRecordCount(classLoader, "csv/Input_2_invalid.csv", 0);

  }

  public void testInvalidErrorMessage() {

    // Delete Output File If Exist Before it
    final ClassLoader classLoader = this.getClass().getClassLoader();
    deleteOutputFilesIfExist(classLoader, "csv/Input_3_valid.csv", "csv/Input_3_invalid.csv");

    final ITicketsFileProcessor processor = TicketsUpgrader.getProcessorWithDefaultFileLocation("Input_3.csv");
    processor.processFile();

    final File configFile = new File(classLoader.getResource("csv/Input_3_invalid.csv").getFile());
    try (BufferedReader br = new BufferedReader(new FileReader(configFile.getAbsoluteFile()))) {

      // Skip First line as it contains headers
      br.readLine();

      // Read Remaing lines which contains actual data
      final String firstRecord = br.readLine();
      final String secondRecord = br.readLine();
      final String thirdRecord = br.readLine();
      final String fourthRecord = br.readLine();
      final String fifthRecord = br.readLine();
      assertTrue(firstRecord.contains(FieldType.PHONE.getFieldError()));
      assertTrue(secondRecord.contains(FieldType.PNR.getFieldError()));
      assertTrue(thirdRecord.contains(FieldType.EMAIL.getFieldError()));
      assertTrue(fourthRecord.contains(FieldType.TRAVEL_DATE.getFieldError()));
      assertTrue(fifthRecord.contains(FieldType.BOOKED_CABIN.getFieldError()));

    } catch (final IOException e) {
      assertTrue(false);
    }
  }

  public void testValidOfferCodes() {
    // Delete Output File If Exist Before it
    final ClassLoader classLoader = this.getClass().getClassLoader();
    deleteOutputFilesIfExist(classLoader, "csv/Input_2_valid.csv", "csv/Input_2_invalid.csv");

    final ITicketsFileProcessor processor = TicketsUpgrader.getProcessorWithDefaultFileLocation("Input_2.csv");
    processor.processFile();

    final File configFile = new File(classLoader.getResource("csv/Input_2_valid.csv").getFile());

    try (BufferedReader br = new BufferedReader(new FileReader(configFile.getAbsoluteFile()))) {

      // Skip First line as it contains headers
      br.readLine();

      // Read Remaing lines which contains actual data
      final String firstRecord = br.readLine();
      final String secondRecord = br.readLine();
      final String thirdRecord = br.readLine();
      final String fourthRecord = br.readLine();
      final String fifthRecord = br.readLine();
      assertTrue(firstRecord.contains(DiscountCode.OFFER_20.getDiscountCodeValue()));
      assertTrue(secondRecord.contains(DiscountCode.OFFER_30.getDiscountCodeValue()));
      assertTrue(fourthRecord.contains(DiscountCode.OFFER_25.getDiscountCodeValue()));
      assertTrue(!thirdRecord.contains("OFFER"));
      assertTrue(!fifthRecord.contains("OFFER"));

    } catch (final IOException e) {
      assertTrue(false);
    }

  }

  public void testWithInputFileLocation() {
    // Delete Output File If Exist Before it
    final ClassLoader classLoader = this.getClass().getClassLoader();
    deleteOutputFilesIfExist(classLoader, "csv/Input_valid.csv", "csv/Input_invalid.csv");

    final File configFile = new File(classLoader.getResource("csv").getFile());
    final ITicketsFileProcessor processor = TicketsUpgrader
        .getProcessorWithDefaultFileName(configFile.getAbsolutePath());
    processor.processFile();
    final URL validFile = classLoader.getResource("csv/Input_valid.csv");
    final URL invalidFile = classLoader.getResource("csv/Input_invalid.csv");
    assertNotNull(validFile);
    assertNotNull(invalidFile);
  }

  public void testWithInputFileLocationAndName() {

    // Delete Output File If Exist Before it
    final ClassLoader classLoader = this.getClass().getClassLoader();
    deleteOutputFilesIfExist(classLoader, "csv/Input_1_valid.csv", "csv/Input_1_invalid.csv");

    final File configFile = new File(classLoader.getResource("csv").getFile());
    final ITicketsFileProcessor processor = TicketsUpgrader
        .getProcessorWithFileLocationAndName(configFile.getAbsolutePath(), "Input_1.csv");
    processor.processFile();
    final URL validFile = classLoader.getResource("csv/Input_1_valid.csv");
    final URL invalidFile = classLoader.getResource("csv/Input_1_invalid.csv");
    assertNotNull(validFile);
    assertNotNull(invalidFile);
  }

  public void testWithInputFileName() {

    // Delete Output File If Exist Before it
    final ClassLoader classLoader = this.getClass().getClassLoader();
    deleteOutputFilesIfExist(classLoader, "csv/Input_2_valid.csv", "csv/Input_2_invalid.csv");
    final ITicketsFileProcessor processor = TicketsUpgrader.getProcessorWithDefaultFileLocation("Input_2.csv");
    processor.processFile();
    final URL validFile = classLoader.getResource("csv/Input_2_valid.csv");
    final URL invalidFile = classLoader.getResource("csv/Input_2_invalid.csv");
    assertNotNull(validFile);
    assertNotNull(invalidFile);
  }

  public void testWithInputFilePath() {

    // Delete Output File If Exist Before it
    final ClassLoader classLoader = this.getClass().getClassLoader();
    deleteOutputFilesIfExist(classLoader, "csv/Input_3_valid.csv", "csv/Input_3_invalid.csv");

    final File configFile = new File(classLoader.getResource("csv/Input_3.csv").getFile());
    final ITicketsFileProcessor processor = TicketsUpgrader.getProcessorWithFilePath(configFile.getAbsolutePath());
    processor.processFile();

    final URL validFileURL = classLoader.getResource("csv/Input_3_valid.csv");
    final URL invalidFileURL = classLoader.getResource("csv/Input_3_invalid.csv");
    assertNotNull(validFileURL);
    assertNotNull(invalidFileURL);

  }

  public void testWithMissingInputFile() {

    final ITicketsFileProcessor processor = TicketsUpgrader.getProcessorWithFilePath("C://test//csv//file.csv");
    try {
      processor.processFile();
    } catch (final TicketUpgradeException e) {
      assertEquals("SS-103", e.getErrorCode());
      assertEquals("Error occured during reading file C://test//csv//file.csv", e.getMessage());
    }
  }

  public void testWithUnsupportedConversionForFileFormat() {

    final ClassLoader classLoader = this.getClass().getClassLoader();
    final File configFile = new File(classLoader.getResource("txt/Input.txt").getFile());
    final ITicketsFileProcessor processor = TicketsUpgrader.getProcessorWithFilePath(configFile.getAbsolutePath());
    try {
      processor.processFile();
    } catch (final TicketUpgradeException e) {
      assertEquals("BS-102", e.getErrorCode());
      assertEquals("File processing not supported for .txt", e.getMessage());
    }
  }

  public void testWithUnsupportedFileFormat() {

    final ClassLoader classLoader = this.getClass().getClassLoader();
    final File configFile = new File(classLoader.getResource("pdf/input.pdf").getFile());
    final ITicketsFileProcessor processor = TicketsUpgrader.getProcessorWithFilePath(configFile.getAbsolutePath());
    try {
      processor.processFile();
    } catch (final TicketUpgradeException e) {
      assertEquals("BS-101", e.getErrorCode());
      assertEquals("Invalid File Format Received!!!", e.getMessage());
    }
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
