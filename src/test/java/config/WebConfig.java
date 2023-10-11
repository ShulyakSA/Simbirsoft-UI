package config;
/**
 * Модель данных блока web в файле 'test.conf'
 */

import lombok.Data;

@Data
public class WebConfig {
    private String url;
    private String browser;
    private boolean clearCookies=true;
    private boolean holdBrowserOpen = false;
    int explicitWait;
}
