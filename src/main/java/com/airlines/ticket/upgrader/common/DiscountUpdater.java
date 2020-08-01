package com.airlines.ticket.upgrader.common;

import com.airlines.ticket.upgrader.data.TicketInfo;
import com.airlines.ticket.upgrader.data.enums.DiscountCode;

/**
 * The class will update the discount code
 *
 * @author Gaurav Jeswani
 */
public class DiscountUpdater {

  /**
   * Private constructor to prevent initialization of class
   */
  private DiscountUpdater() {
    super();
  }

  /**
   * The method will update discount code in ticket on the basis of fare class
   *
   * @param ticketInfo
   */
  public static void updateDiscountCodeByFareClass(final TicketInfo ticketInfo) {

    final char fareClass = ticketInfo.getFareClass().charAt(0);

    ticketInfo.setAppliedDiscount(DiscountCode.getDiscountByClass(fareClass));

    // A to E
    //    if (fareClass <= 'E') {
    //      ticketInfo.setAppliedDiscount(DiscountCode.OFFER_20);
    //    } else if (fareClass <= 'K') {
    //      // F to K
    //      ticketInfo.setAppliedDiscount(DiscountCode.OFFER_30);
    //    } else if (fareClass <= 'R') {
    //      // L to R
    //      ticketInfo.setAppliedDiscount(DiscountCode.OFFER_25);
    //    } else {
    //      // S to Z
    //      ticketInfo.setAppliedDiscount(DiscountCode.NO_DICOUNT);
    //    }
  }

}
