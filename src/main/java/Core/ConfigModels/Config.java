package Core.ConfigModels;

public class Config {
    private String project;
    private DatabaseDetails databaseDetails;
    private DriverDetails driverDetails;

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public DatabaseDetails getDatabaseDetails() {
        return databaseDetails;
    }

    public void setDatabaseDetails(DatabaseDetails databaseDetails) {
        this.databaseDetails = databaseDetails;
    }

    public DriverDetails getDriverDetails() {
        return driverDetails;
    }

    public void setDriverDetails(DriverDetails driverDetails) {
        this.driverDetails = driverDetails;
    }
}
