package com.airlines.ticket.upgrader;

import java.io.File;

import com.airlines.ticket.upgrader.common.CommonConstants;

/**
 * This call is the entry point for all further operations to process the file.
 * Validating each ticket data from file and will write the data with status to
 * new files.
 *
 * @author Gaurav Jeswani
 */
public class TicketsUpgrader {

  /**
   * Default constructor to prevent initialization of class Constructor of the
   * class
   */
  private TicketsUpgrader() {
    super();
  }

  /**
   * The method will return the {@link ITicketsProcessor} with default file
   * location {@link CommonConstants.DEFAULT_FILE_LOCATION}
   *
   * @param inputFileName
   * @return
   */
  public static ITicketsProcessor getProcessorWithDefaultFileLocation(final String inputFileName) {

    //File Path
    final ClassLoader classLoader = TicketsUpgrader.class.getClassLoader();
    final File configFile = new File(classLoader.getResource(CommonConstants.DEFAULT_FILE_LOCATION).getFile());

    return getProcessorWithFileLocationAndName(configFile.getAbsolutePath(), inputFileName);
  }

  /**
   * The method will return the {@link ITicketsProcessor} with default file
   * location {@link CommonConstants.DEFAULT_FILE_LOCATION} and file name for
   * processing {@link CommonConstants.DEFAULT_FILE_NAME}
   *
   * @return
   */
  public static ITicketsProcessor getProcessorWithDefaultFileLocationAndName() {

    return getProcessorWithDefaultFileLocation(CommonConstants.DEFAULT_FILE_NAME);
  }

  /**
   * The method will return the {@link ITicketsProcessor} with default file
   * name for processing {@link CommonConstants.DEFAULT_FILE_NAME}
   *
   * @return
   */
  public static ITicketsProcessor getProcessorWithDefaultFileName(final String inputFileLocation) {

    return getProcessorWithFileLocationAndName(inputFileLocation, CommonConstants.DEFAULT_FILE_NAME);
  }

  /**
   * The method will return the {@link ITicketsProcessor} with input file
   * location and name
   *
   * @return
   */
  public static ITicketsProcessor getProcessorWithFileLocationAndName(final String inputFileLocation,
      final String inputFileName) {

    // This slash code is written just to Print Input/Output path in decent way
    String pathSlash = "\\";

    if (inputFileLocation.contains("/")) {
      pathSlash = "/";
    }

    return getProcessorWithFilePath(inputFileLocation + pathSlash + inputFileName);
  }

  /**
   * The method will return the {@link ITicketsProcessor} with Input File
   * Path(complete path with file name) to process
   *
   * @return
   */
  public static ITicketsProcessor getProcessorWithFilePath(final String inputFilePath) {
    final TicketsFileProcessor ticketsFileProcessor = new TicketsFileProcessor(inputFilePath);
    return ticketsFileProcessor;
  }

}
