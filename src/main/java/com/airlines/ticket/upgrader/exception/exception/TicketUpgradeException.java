
package com.airlines.ticket.upgrader.exception.exception;

/**
 * This is the base exception call for all custom exceptions
 *
 * @author Gaurav Jeswani
 */
public abstract class TicketUpgradeException extends RuntimeException {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  //The error code
  private final String errorCode;

  /**
   * Constructor of the class
   *
   * @param message
   */
  public TicketUpgradeException(final String message) {
    super(message);
    this.errorCode = null;
  }

  /**
   * Constructor of the class
   *
   * @param message
   * @param errorCode
   */
  public TicketUpgradeException(final String message, final String errorCode) {
    super(message);
    this.errorCode = errorCode;
  }

  /**
   * Constructor of the class
   *
   * @param message
   * @param cause
   * @param errorCode
   */
  public TicketUpgradeException(final String message, final String errorCode, final Throwable cause) {
    super(message, cause);
    this.errorCode = errorCode;
  }

  /**
   * Constructor of the class
   *
   * @param message
   * @param cause
   */
  public TicketUpgradeException(final String message, final Throwable cause) {
    super(message, cause);
    this.errorCode = null;
  }

  /**
   * Method will return error code.
   *
   * @return
   */
  public String getErrorCode() {
    return errorCode;
  }

}
