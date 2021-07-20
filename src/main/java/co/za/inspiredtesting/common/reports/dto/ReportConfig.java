package co.za.inspiredtesting.common.reports.dto;

public class ReportConfig {

    private String projectName;
    private String trendsPathName;
    private String cucumberReportPathName;
    private String environment;

    public ReportConfig(){
    }

    public ReportConfig(String projectName, String trendsPathName, String cucumberReportPathName, String environment) {
        super();
        this.projectName = projectName;
        this.trendsPathName = trendsPathName;
        this.cucumberReportPathName = cucumberReportPathName;
        this.environment = environment;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getTrendsPathName() {
        return trendsPathName;
    }

    public void setTrendsPathName(String trendsPathName) {
        this.trendsPathName = trendsPathName;
    }

    public String getCucumberReportPathName() {
        return cucumberReportPathName;
    }

    public void setCucumberReportPathName(String cucumberReportPathName) {
        this.cucumberReportPathName = cucumberReportPathName;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
