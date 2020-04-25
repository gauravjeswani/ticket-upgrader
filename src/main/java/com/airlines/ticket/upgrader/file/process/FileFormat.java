package com.airlines.ticket.upgrader.file.process;

import java.util.Arrays;
import java.util.Optional;

import com.airlines.ticket.upgrader.exception.exception.TicketUpgradeBusinessException;

/**
 * Enum class will be used to maintain all the file formats supported by the
 * application
 *
 * @author Gaurav Jeswani
 */
public enum FileFormat {

  CSV(".csv") {

    @Override
    public IFileProcessor getFileProcessor() {
      return new CSVFileProcessor();
    }
  },

  TXT(".txt") {

    @Override
    public IFileProcessor getFileProcessor() {

      throw new TicketUpgradeBusinessException("File processing not supported for " + getExtention(), "BS-102");
    }
  };

  private String extention;

  /**
   * Constructor of the class
   *
   * @param extention
   */
  FileFormat(final String extention) {
    this.extention = extention;
  }

  /**
   * The method will return the file format by file path with extention
   *
   * @param filePath
   * @return
   */
  public static FileFormat getFileFormatByFilePath(final String filePath) {
    final String[] filePathParts = filePath.split("\\.");

    final String extention = filePathParts[filePathParts.length - 1];

    final Optional<FileFormat> fileFormat = Arrays.stream(values())
        .filter(format -> format.extention.equalsIgnoreCase("." + extention)).findFirst();

    if (!fileFormat.isPresent()) {
      throw new TicketUpgradeBusinessException("Invalid File Format Received!!!", "BS-101");
    }

    return fileFormat.get();

  }

  /**
   * @return
   */
  public String getExtention() {
    return this.extention;
  }

  public abstract IFileProcessor getFileProcessor();
}
