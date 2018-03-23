package sonia.telegram.client;

//~--- non-JDK imports --------------------------------------------------------

import org.glassfish.jersey.logging.LoggingFeature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//~--- JDK imports ------------------------------------------------------------

import java.io.Closeable;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author th
 */
public class TelegramClient implements Closeable
{

  /** Field description */
  private final static Logger LOGGER = LoggerFactory.getLogger(
    TelegramClient.class.getName());

  /** Field description */
  private final static String TELEGRAM_API_URL = "https://api.telegram.org";

  //~--- constructors ---------------------------------------------------------

  /**
   * Constructs ...
   *
   *
   * @param apiToken
   * @param debuggingEnabled
   */
  public TelegramClient(String apiToken, boolean debuggingEnabled)
  {
    if (debuggingEnabled)
    {
      client = ClientBuilder.newBuilder().property(LoggingFeature
        .LOGGING_FEATURE_VERBOSITY_CLIENT, LoggingFeature.Verbosity.PAYLOAD_ANY)
        .property(LoggingFeature.LOGGING_FEATURE_LOGGER_LEVEL_CLIENT, "WARNING")
        .build();
    }
    else
    {
      client = ClientBuilder.newBuilder().build();
    }

    target = client.target(TELEGRAM_API_URL);
    this.apiToken = apiToken;
    LOGGER.debug("apiToken=" + apiToken);
  }

  //~--- methods --------------------------------------------------------------

  @Override
  public void close()
  {
    client.close();
  }

  /**
   * Method description
   *
   *
   * @param message
   *
   * @return
   */
  public TelegramMessageResult send(TelegramMessage message)
  {

    TelegramMessageResult result = target.path("bot" + apiToken).path(
      "sendmessage").request().accept(MediaType.APPLICATION_JSON).post(
      Entity.json(message.getMap()), TelegramMessageResult.class);

    return result;
  }

  //~--- fields ---------------------------------------------------------------

  /** Field description */
  private final Client client;

  /** Field description */
  private final WebTarget target;

  /** Field description */
  private final String apiToken;
}
