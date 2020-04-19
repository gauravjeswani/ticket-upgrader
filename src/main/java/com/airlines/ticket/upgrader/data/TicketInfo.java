package com.airlines.ticket.upgrader.data;

import com.airlines.ticket.upgrader.data.enums.DiscountCode;
import com.airlines.ticket.upgrader.data.enums.FieldType;

/**
 * Class will be used as data container for ticket info
 * 
 * @author Gaurav Jeswani
 */
public class TicketInfo {

  private DiscountCode appliedDiscount;

  private String bookedCabin;

  private String email;

  private String fareClass;

  private String firstName;

  private FieldType invalidField;

  private String lastName;

  private String pax;

  private String phone;

  private String pnr;

  private String ticketingDate;

  private String travelDate;

  /**
   * Default Constructor of the class
   */
  public TicketInfo() {
    super();
  }

  /**
   * Constructor of the class to populate data from String array with sequence
   * of
   * First_name,Last_name,PNR,Fare_class,Travel_date,Pax,Ticketing_date,Email,Mobile_p
   * hone,Booked_cabin
   *
   * @param ticketData
   */
  public TicketInfo(final String[] ticketData) {
    this.firstName = ticketData[0];
    this.lastName = ticketData[1];
    this.pnr = ticketData[2];
    this.fareClass = ticketData[3];
    this.travelDate = ticketData[4];
    this.pax = ticketData[5];
    this.ticketingDate = ticketData[6];
    this.email = ticketData[7];
    this.phone = ticketData[8];
    this.bookedCabin = ticketData[9];
  }

  /**
   * @return the appliedDiscount
   */
  public DiscountCode getAppliedDiscount() {
    return appliedDiscount;
  }

  /**
   * @return the bookedCabin
   */
  public String getBookedCabin() {
    return bookedCabin;
  }

  /**
   * @return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @return the fareClass
   */
  public String getFareClass() {
    return fareClass;
  }

  /**
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * @return the invalidField
   */
  public FieldType getInvalidField() {
    return invalidField;
  }

  /**
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * @return the pax
   */
  public String getPax() {
    return pax;
  }

  /**
   * @return the phone
   */
  public String getPhone() {
    return phone;
  }

  /**
   * @return the pnr
   */
  public String getPnr() {
    return pnr;
  }

  /**
   * @return the ticketingDate
   */
  public String getTicketingDate() {
    return ticketingDate;
  }

  /**
   * @return the travelDate
   */
  public String getTravelDate() {
    return travelDate;
  }

  /**
   * @param appliedDiscount
   *          the appliedDiscount to set
   */
  public void setAppliedDiscount(final DiscountCode appliedDiscount) {
    this.appliedDiscount = appliedDiscount;
  }

  /**
   * @param bookedCabin
   *          the bookedCabin to set
   */
  public void setBookedCabin(final String bookedCabin) {
    this.bookedCabin = bookedCabin;
  }

  /**
   * @param email
   *          the email to set
   */
  public void setEmail(final String email) {
    this.email = email;
  }

  /**
   * @param fareClass
   *          the fareClass to set
   */
  public void setFareClass(final String fareClass) {
    this.fareClass = fareClass;
  }

  /**
   * @param firstName
   *          the firstName to set
   */
  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  /**
   * @param invalidField
   *          the invalidField to set
   */
  public void setInvalidField(final FieldType invalidField) {
    this.invalidField = invalidField;
  }

  /**
   * @param lastName
   *          the lastName to set
   */
  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  /**
   * @param pax
   *          the pax to set
   */
  public void setPax(final String pax) {
    this.pax = pax;
  }

  /**
   * @param phone
   *          the phone to set
   */
  public void setPhone(final String phone) {
    this.phone = phone;
  }

  /**
   * @param pnr
   *          the pnr to set
   */
  public void setPnr(final String pnr) {
    this.pnr = pnr;
  }

  /**
   * @param ticketingDate
   *          the ticketingDate to set
   */
  public void setTicketingDate(final String ticketingDate) {
    this.ticketingDate = ticketingDate;
  }

  /**
   * @param travelDate
   *          the travelDate to set
   */
  public void setTravelDate(final String travelDate) {
    this.travelDate = travelDate;
  }

}
