package inspiredtesting.services;


import inspiredtesting.reports.dto.ReportConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import inspiredtesting.services.util.FilesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.IOException;

public class TestConfiguration {

    private static TestConfiguration testConfigurationInstance = null;
    private static final String REPORT_CONFIG_LOCATION = "config/config.yml";

    private ObjectMapper mapper = null;
    private ReportConfig reportConfig = null;

    private static final Logger logger
            = LoggerFactory.getLogger(TestConfiguration.class);

    private TestConfiguration(){
        initDefaultFactory();
        try {
            reportConfig = initReportConfig();
        } catch (IOException e) {
            logger.error("Failed to create report config {}", e.getMessage());
        }
    }

    public static TestConfiguration getInstance() {
        if (testConfigurationInstance==null){
            logger.info("Config instance null, creating new instance");
            testConfigurationInstance = new TestConfiguration();
        }
        return testConfigurationInstance;
    }

    private void initDefaultFactory(){
        mapper = new ObjectMapper(new YAMLFactory());
    }

    private ReportConfig initReportConfig() throws IOException {
        logger.info("Loading test report configs from location {}", REPORT_CONFIG_LOCATION);
        return mapper.readValue(FilesUtil.getFile(REPORT_CONFIG_LOCATION), ReportConfig.class);
    }

    public ReportConfig getReportConfig() {
        return reportConfig;
    }
}
