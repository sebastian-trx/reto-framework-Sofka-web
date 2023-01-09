package co.com.client.webproject.test.stepdefinition.setup;

import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.sofka.test.automationtools.selenium.Browser;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GeneralSetup {

        protected TestInfo testInfo;

        public Browser browser(){
            Browser browserConfiguration = new Browser();
            browserConfiguration.setBrowser(Browser.Browsers.CHROME);
            browserConfiguration.setIncognito(true);
            browserConfiguration.setMaximized(true);
            browserConfiguration.setAutoDriverDownload(true);
            browserConfiguration.setChromeOptions(chromeOptions());
            rutaDinamicaEvidencias();

            return browserConfiguration;
        }

        private ChromeOptions chromeOptions(){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("start-maximized");
            return options;
        }

        //metodo para poner la ruta de las evidencias en el configuration.properties
        private void rutaDinamicaEvidencias(){
            String configurationFilePath = "\\src\\main\\resources\\properties\\configuration.properties";
            String evidencePath ="\\src\\test\\evidence";
            String userDir = "user.dir";

            Properties props = new Properties();
            // Cargamos el archivo .properties existente
            try (FileInputStream fis =
                         new FileInputStream(
                                 System.getProperty(userDir)
                                         +configurationFilePath)) {

               props.load(fis);

            } catch (IOException e) {
                e.printStackTrace();
            }

            // Modificamos la propiedad en el archivo .properties
            props.setProperty("files.evidence",
                    System.getProperty(userDir)+evidencePath);

            // Guardamos los cambios en el archivo .properties
            try (FileOutputStream fos =
                         new FileOutputStream(
                                 System.getProperty(userDir)
                                         +configurationFilePath)) {

                props.store(fos, null);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
