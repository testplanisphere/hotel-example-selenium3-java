package starhotel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Utils {

  public static final String BASE_URL = "https://takeya0x86.github.io/automation-testing-practice";

  private Utils() {
    throw new AssertionError();
  }

  public static WebDriver createWebDriver() {
    var githubActions = Boolean.parseBoolean(System.getenv("GITHUB_ACTIONS"));
    var browser = System.getenv("BROWSER");
    if (browser == null) {
      browser = "chrome";
    }
    switch (browser) {
      case "chrome": {
        var options = new ChromeOptions();
        if (githubActions) {
          options.setHeadless(true);
        }
        return new ChromeDriver(options);
      }
      case "firefox": {
        var options = new FirefoxOptions();
        if (githubActions) {
          options.setHeadless(true);
        }
        return new FirefoxDriver(options);
      }
      default:
        throw new RuntimeException(browser + " is not support.");
    }
  }
}