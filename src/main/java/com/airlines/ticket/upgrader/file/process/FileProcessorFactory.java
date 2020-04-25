
package com.airlines.ticket.upgrader.file.process;

/**
 * This class will work as Factory Class to create the FileFormat for file
 * processing
 * 
 * @author Gaurav Jeswani
 */
public final class FileProcessorFactory {

  /**
   * Constructor of the class
   */
  private FileProcessorFactory() {
    super();
  }

  /**
   * @param objectType
   * @return
   */
  public static FileFormat getFactory(final String objectType) {
    return FileFormat.getFileFormatByFilePath(objectType);
  }

}
