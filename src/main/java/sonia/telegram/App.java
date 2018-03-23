
package sonia.telegram;

//~--- non-JDK imports --------------------------------------------------------

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import sonia.telegram.client.TelegramChat;
import sonia.telegram.client.TelegramClient;
import sonia.telegram.client.TelegramMessage;
import sonia.telegram.client.TelegramMessageResult;

/**
 *
 * @author th
 */
public class App
{

  /** Field description */
  private final static Logger LOGGER = LoggerFactory.getLogger(
    App.class.getName());

  /** Field description */
  private final static Options OPTIONS = new Options();

  /** Field description */
  private static CmdLineParser parser;

  //~--- methods --------------------------------------------------------------

  /**
   * Method description
   *
   *
   * @param args
   *
   */
  public static void main(String[] args)
  {
    LOGGER.info("SONIA Telegram sender started.");

    parser = new CmdLineParser(OPTIONS);

    try
    {
      parser.parseArgument(args);

      if (OPTIONS.isDisplayHelp() || (args.length == 0))
      {
        parser.printUsage(System.out);
      }
      else if (OPTIONS.isDisplayVersion())
      {
        System.out.println("Version 0.1");
      }
      else
      {
        LOGGER.debug("API token = " + OPTIONS.getToken());
        LOGGER.debug("Chat name = " + OPTIONS.getChatName());
        LOGGER.debug("Chat Id = " + OPTIONS.getChatId());
        LOGGER.debug("Verbose = " + OPTIONS.isVerbose());
        LOGGER.debug("Debugging enabled = " + OPTIONS.isDebug());
        LOGGER.debug("Message text = " + OPTIONS.getText());

        try (TelegramClient client = new TelegramClient(OPTIONS.getToken(),
          OPTIONS.isDebug()))
        {
          TelegramChat chat;

          if (OPTIONS.getChatId() != 0l)
          {
            chat = new TelegramChat(OPTIONS.getChatId());
          }
          else
          {
            chat = new TelegramChat(OPTIONS.getChatName());
          }

          TelegramMessage message = new TelegramMessage(chat,
            OPTIONS.getText());

          LOGGER.debug("sending messge = " + message);

          TelegramMessageResult result = client.send(message);

          if (OPTIONS.isVerbose())
          {
            System.out.println("result=" + result);
          }
        }
        catch (Exception e)
        {
          LOGGER.error(" Error sending Message ", e);
        }

      }
    }
    catch (CmdLineException ex)
    {
      LOGGER.error("Command line error", ex);
    }
  }
}
