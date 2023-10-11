package config;
/**
 * Модель данных блока testData в файле 'test.conf'
 */

import lombok.Data;

@Data
public class TestConfig {
    private String firstName;
    private String lastName;
    private String postCode;
    private String alertText;
}
