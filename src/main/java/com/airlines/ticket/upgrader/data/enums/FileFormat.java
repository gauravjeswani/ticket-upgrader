package com.airlines.ticket.upgrader.data.enums;

/**
 * Enum class will be used to maintain all the file formats supported by the
 * application
 *
 * @author z0043nrm
 */
public enum FileFormat {

  CSV(".csv");

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
   * @return
   */
  public String getExtention() {
    return this.extention;
  }
}
