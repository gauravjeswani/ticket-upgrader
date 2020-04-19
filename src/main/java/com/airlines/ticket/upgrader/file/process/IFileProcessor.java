package com.airlines.ticket.upgrader.file.process;

import java.util.List;

import com.airlines.ticket.upgrader.data.TicketInfo;

/**
 * The base interface for all file processors for different file formats
 *
 * @author Gaurav Jeswani
 */
public interface IFileProcessor {

  /**
   * The method will read file at input location return the tickets info list
   * populated from input file
   *
   * @param filePath
   * @return
   */
  List<TicketInfo> readFile(String filePath);

  /**
   * @param data
   * @param filePath
   */
  void writeFile(List<TicketInfo> data, String filePath);
}
