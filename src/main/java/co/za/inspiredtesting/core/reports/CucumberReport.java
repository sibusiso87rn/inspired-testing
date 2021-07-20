package co.za.inspiredtesting.core.reports;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by Sibusiso Radebe
 */
public class CucumberReport {

    private static final Logger logger
            = LoggerFactory.getLogger(CucumberReport.class);

    private final int trendsLimit;

    public CucumberReport(){
        this.trendsLimit    = 100;
    }

    public void createReport(){

    }
}
