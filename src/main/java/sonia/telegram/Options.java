package sonia.telegram;

//~--- non-JDK imports --------------------------------------------------------

import lombok.Getter;
import lombok.Setter;

import org.kohsuke.args4j.Option;

/**
 *
 * @author your name
 */
public class Options
{

  /**
   * Field description
   */
  @Option(name = "--help", usage = "Displays this help")
  @Getter
  @Setter
  private boolean displayHelp = false;

  /**
   * Field description
   */
  @Option(name = "--version", usage = "Display programm version")
  @Getter
  @Setter
  private boolean displayVersion = false;

  /**
   * Field description
   */
  @Option(
    name = "--verbose",
    aliases = "-v",
    usage = "Display server result"
  )
  @Getter
  @Setter
  private boolean verbose = false;

  /**
   * Field description
   */
  @Option(
    name = "--debug",
    aliases = "-d",
    usage = "Debugging infos enabled"
  )
  @Getter
  @Setter
  private boolean debug = false;

  /**
   * Field description
   */
  @Option(
    name = "--api-token",
    aliases = "-a",
    usage = "Telegram API (Bot) token"
  )
  @Getter
  @Setter
  private String token;

  /**
   * Field description
   */
  @Option(
    name = "--chat-name",
    aliases = "-n",
    usage = "Chat name"
  )
  @Getter
  @Setter
  private String chatName;

  /**
   * Field description
   */
  @Option(
    name = "--chat-id",
    aliases = "-i",
    usage = "Chat ID"
  )
  @Getter
  @Setter
  private long chatId;

  /**
   * Field description
   */
  @Option(
    name = "--text",
    aliases = "-t",
    usage = "Message text to send"
  )
  @Getter
  @Setter
  private String text;
}
