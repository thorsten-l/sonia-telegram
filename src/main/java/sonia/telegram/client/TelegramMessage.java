package sonia.telegram.client;

//~--- non-JDK imports --------------------------------------------------------

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;

//~--- JDK imports ------------------------------------------------------------

import java.util.HashMap;

import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author th
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TelegramMessage
{

  /**
   * Constructs ...
   *
   */
  private TelegramMessage() {}

  /**
   * Constructs ...
   *
   *
   * @param chat
   * @param text
   */
  public TelegramMessage(TelegramChat chat, String text)
  {
    if (chat.getId() != 0l)
    {
      map.put("chat_id", String.valueOf(chat.getId()));
    }
    else
    {
      map.put("chat_id", chat.getName());
    }

    this.chat = chat;
    this.text = text;
    map.put("text", text);
    this.date = System.currentTimeMillis() / 1000l;
  }

  //~--- methods --------------------------------------------------------------

  @Override
  public String toString()
  {
    return "{message_id=" + messageId + ", chat=" + chat + ", date=" + date
      + ", test=" + text + "}";
  }

  //~--- get methods ----------------------------------------------------------

  /**
   * Method description
   *
   *
   * @return
   */
  public HashMap<String, String> getMap()
  {
    return map;
  }

  //~--- set methods ----------------------------------------------------------

  /**
   * Method description
   *
   *
   * @param value
   *
   * @return
   */
  public TelegramMessage setDisableWebPagePreview(boolean value)
  {
    map.put("disable_web_page_preview", String.valueOf(value));

    return this;
  }

  //~--- fields ---------------------------------------------------------------

  /** Field description */
  private final HashMap<String, String> map = new HashMap<>();

  /** Field description */
  @Getter
  @XmlElement(name = "message_id")
  private long messageId;

  /** Field description */
  @Getter
  private TelegramChat chat;

  /** Field description */
  @Getter
  private long date;

  /** Field description */
  @Getter
  private String text;
}
