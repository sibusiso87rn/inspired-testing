package inspiredtesting.reports;

import inspiredtesting.services.TestConfiguration;
import inspiredtesting.reports.dto.ReportConfig;
import inspiredtesting.services.util.FilesUtil;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Sibusiso Radebe
 */
public class CucumberReport {

        private ReportConfig reportConfig = TestConfiguration.getInstance().getReportConfig();

        private static final Logger logger = LoggerFactory.getLogger(CucumberReport.class);
        private final String trendsPathName;
        private final int trendsLimit;

        public CucumberReport(){
            this.trendsLimit    = 10;
            this.trendsPathName = reportConfig.getTrendsPathName();
        }

        public void createReport(){

            logger.info("******************Building Report******************");
            File reportOutputDirectory = new File("target");
            List<String> jsonFiles = new ArrayList<>();

            logger.info("Setting report target to : {}",reportConfig.getCucumberReportPathName());
            jsonFiles.add("target/cucumber-report.json");

            String projectName = reportConfig.getProjectName();

            Configuration configuration = new Configuration(reportOutputDirectory, projectName);
            String buildNumber = System.getenv("BUILD_NUMBER") != null ? System.getenv("BUILD_NUMBER") : Integer.toString(ThreadLocalRandom.current().nextInt(1, 100));
            configuration.setBuildNumber(buildNumber);

            //Trends this will file will need to maintained and not deleted in order to keep the trend
            try {
                logger.info("Saving trends file on location: "+ trendsPathName);
                configuration.setTrends(FilesUtil.getFile(trendsPathName),this.trendsLimit);
            }catch (Exception e){
                logger.warn("Trends file not found, creating new one {}",e.getMessage());
                configuration.setTrends(new File("target/"+trendsPathName),this.trendsLimit);
            }

            try{
                configuration.addClassifications("Application Name", projectName);
                configuration.addClassifications("Test Environment", reportConfig.getEnvironment());
                configuration.addClassifications("Machine IP",   InetAddress.getLocalHost().getHostAddress());
                configuration.addClassifications("Machine Name", InetAddress.getLocalHost().getHostName());
            }catch(UnknownHostException e){
                logger.error("Failed to get localhost address {}", e.getMessage());
            }
            configuration.addClassifications("Username", System.getProperty("user.name"));
            configuration.addClassifications("Platform Version", System.getProperty("os.name"));
            ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
            try {
                reportBuilder.generateReports();
            }catch (Exception e){
                logger.error("Report fails to generate as there are no features were available to execute: {}",e.getMessage());
            }
        }
}
