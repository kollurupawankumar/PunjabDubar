package com.punjab.springmvc.cap;

import java.util.*;

/**
 * @author
 * Adrian Pasciak,
 * Chase Lee,
 * Christopher Schultz,
 * Nerijus Gelezinis (no-show),
 * Patrick Tam
 *
 */
public class Quantity {
  private int count = 0;
  private Date date;
  
  
  /**
   * Returns instance count
   * 
   * @return count
   */
  public int getCount() {
    return count;
  }
  
  
  /**
   * Sets instance count 
   * 
   * @param count
   */
  public void setCount(int count) {
    this.count = count;
  }
  
  
  /**
   * Sets instance date
   * @param date
   */
  public void setDate(Date date) {
    this.date = date;
  }
 
  
  /**
   * Returns instance date
   *  
   * @return date
   */
  public Date getDate() {
    return date;
  }
}
