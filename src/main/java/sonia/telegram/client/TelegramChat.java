package sonia.telegram.client;

//~--- non-JDK imports --------------------------------------------------------

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

/**
 *
 * @author th
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TelegramChat
{

  /**
   * Constructs ...
   *
   */
  private TelegramChat() {}

  /**
   * Constructs ...
   *
   *
   * @param id
   */
  public TelegramChat(long id)
  {
    this.id = id;
  }

  /**
   * Constructs ...
   *
   *
   * @param name
   */
  public TelegramChat(String name)
  {
    this.name = name;
  }

  //~--- methods --------------------------------------------------------------

  @Override
  public String toString()
  {
    return "{id=" + id + ", name=" + name + ", title=" + title + ", type="
      + type + "}";
  }

  //~--- fields ---------------------------------------------------------------

  /** Field description */
  @Getter
  private long id;

  /** Field description */
  @Getter
  private String name;

  /** Field description */
  @Getter
  private String title;

  /** Field description */
  @Getter
  private String type;
}
