
package com.airlines.ticket.upgrader.exception.exception;

/**
 * The class is the Business Exception Class to throw all the business exception
 * to the Client in single exception with the error code and message.
 *
 * @author Gaurav Jeswani
 */
public class TicketUpgradeBusinessException extends TicketUpgradeException {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  /**
   * Constructor of the class
   *
   * @param message
   */
  public TicketUpgradeBusinessException(final String message) {
    super(message);
  }

  /**
   * Constructor of the class
   *
   * @param message
   * @param errorCode
   */
  public TicketUpgradeBusinessException(final String message, final String errorCode) {
    super(message, errorCode);
  }

  /**
   * Constructor of the class
   *
   * @param message
   * @param errorCode
   * @param cause
   */
  public TicketUpgradeBusinessException(final String message, final String errorCode, final Throwable cause) {
    super(message, errorCode, cause);
  }

  /**
   * Constructor of the class
   *
   * @param message
   * @param cause
   */
  public TicketUpgradeBusinessException(final String message, final Throwable cause) {
    super(message, cause);
  }
}
