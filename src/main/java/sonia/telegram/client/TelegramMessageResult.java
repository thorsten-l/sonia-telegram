/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package sonia.telegram.client;

//~--- non-JDK imports --------------------------------------------------------

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

//~--- JDK imports ------------------------------------------------------------

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author th
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TelegramMessageResult
{
  @Override
  public String toString()
  {
    return "{ok=" + ok + ", message=" + message + "}";
  }

  //~--- fields ---------------------------------------------------------------

  /** Field description */
  @Getter
  private boolean ok;

  /** Field description */
  @Getter
  @XmlElement(name = "result")
  private TelegramMessage message;
}
