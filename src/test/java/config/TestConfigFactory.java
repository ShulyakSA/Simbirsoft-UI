package config;
/**
 * Класс реализует получение настроек из файла 'test.conf' по отдельным блокам
 */

import com.typesafe.config.Config;
import com.typesafe.config.ConfigBeanFactory;
import com.typesafe.config.ConfigFactory;

public class TestConfigFactory {
    private volatile Config config;
    private volatile WebConfig webConfig;
    private volatile TestConfig testConfig;

    private TestConfigFactory() {
        config = ConfigFactory.systemProperties()
                .withFallback(ConfigFactory.systemEnvironment())
                .withFallback(ConfigFactory.parseResources("test.conf"));
    }

    /**
     * Получение данных из блока 'web' файла 'test.conf'
     * @return возвращает объект с данными класса 'WebConfig'
     */
    public synchronized WebConfig getWebConfig() {
        if (webConfig == null) {
            webConfig = ConfigBeanFactory.create(config.getConfig("web"), WebConfig.class);
        }
        return webConfig;
    }

    /**
     * Получение данных из блока 'testData' файла 'test.conf'
     * @return возвращает объект с данными класса 'TestConfig'
     */
    public synchronized TestConfig getTestConfig() {
        if (testConfig == null) {
            testConfig = ConfigBeanFactory.create(config.getConfig("testData"), TestConfig.class);
        }
        return testConfig;
    }

    /**
     * Синглтон, обеспечивает получение одного объекта конфигураций для всех потоков
     * @return возвращает экземпляр класса
     */
    public synchronized static TestConfigFactory getInstance() {
        return new TestConfigFactory();
    }
}
