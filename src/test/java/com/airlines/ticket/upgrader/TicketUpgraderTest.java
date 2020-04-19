package com.airlines.ticket.upgrader;

import java.io.File;

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

  public void testWithInputFileLocation() {
    final ClassLoader classLoader = this.getClass().getClassLoader();
    final File configFile = new File(classLoader.getResource("csv").getFile());
    final ITicketsFileProcessor processor = TicketsUpgrader
        .getProcessorWithDefaultFileName(configFile.getAbsolutePath());
    processor.processFile();
    assertTrue(true);
  }

  public void testWithInputFileLocationAndName() {
    final ClassLoader classLoader = this.getClass().getClassLoader();
    final File configFile = new File(classLoader.getResource("csv").getFile());
    final ITicketsFileProcessor processor = TicketsUpgrader
        .getProcessorWithFileLocationAndName(configFile.getAbsolutePath(), "Input_1.csv");
    processor.processFile();
    assertTrue(true);
  }

  public void testWithInputFileName() {
    final ITicketsFileProcessor processor = TicketsUpgrader.getProcessorWithDefaultFileLocation("Input_2.csv");
    processor.processFile();
    assertTrue(true);
  }

  public void testWithInputFilePath() {

    final ClassLoader classLoader = this.getClass().getClassLoader();
    final File configFile = new File(classLoader.getResource("csv/Input_3.csv").getFile());
    final ITicketsFileProcessor processor = TicketsUpgrader.getProcessorWithFilePath(configFile.getAbsolutePath());
    processor.processFile();
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

  public void testWithUnsupportedFileFormat() {

    final ClassLoader classLoader = this.getClass().getClassLoader();
    final File configFile = new File(classLoader.getResource("txt/Input.txt").getFile());
    final ITicketsFileProcessor processor = TicketsUpgrader.getProcessorWithFilePath(configFile.getAbsolutePath());
    try {
      processor.processFile();
    } catch (final TicketUpgradeException e) {
      assertEquals("BS-101", e.getErrorCode());
      assertEquals("Invalid File Format Received!!!", e.getMessage());
    }
  }
}
