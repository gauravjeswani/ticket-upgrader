
package com.airlines.ticket.upgrader.exception.exception;

/**
 * The class is the System Exception Class to wrap all the System Exceptions to
 * single one to send to the client.
 *
 * @author Gaurav Jeswani
 */
public class TicketUpgradeSystemException extends TicketUpgradeException {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constructor of the class
   *
   * @param message
   */
  public TicketUpgradeSystemException(final String message) {
    super(message);
  }

  /**
   * Constructor of the class
   *
   * @param message
   * @param errorCode
   */
  public TicketUpgradeSystemException(final String message, final String errorCode) {
    super(message, errorCode);
  }

  /**
   * Constructor of the class
   *
   * @param message
   * @param errorCode
   * @param cause
   */
  public TicketUpgradeSystemException(final String message, final String errorCode, final Throwable cause) {
    super(message, errorCode, cause);
  }

  /**
   * Constructor of the class
   *
   * @param message
   * @param cause
   */
  public TicketUpgradeSystemException(final String message, final Throwable cause) {
    super(message, cause);
  }

}
