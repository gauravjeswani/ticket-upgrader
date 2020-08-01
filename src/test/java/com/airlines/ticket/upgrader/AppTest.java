package com.airlines.ticket.upgrader;

/**
 * Test application with absolute path in system
 *
 * @author Gaurav Jeswani
 */
public class AppTest {

  public static void main(final String[] args) {
    //Create a input file in D drive named as Input.csv or change the path. Check console to get the location of newly created files
    TicketsUpgrader.getProcessorWithFilePath("D://Input_1.csv").processTickets();
  }
}
