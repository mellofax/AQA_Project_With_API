package Core;

import Core.ConfigModels.DatabaseDetails;
import org.apache.logging.log4j.Level;
import org.codejargon.fluentjdbc.api.FluentJdbc;
import org.codejargon.fluentjdbc.api.FluentJdbcBuilder;
import org.codejargon.fluentjdbc.api.query.Query;
import org.postgresql.ds.PGSimpleDataSource;

import static Utils.LoggingUtils.log;

public class DBInterface {

    public static Query db;

    /**
     * Static method for interface configuration
     *
     * @param dbDetails - host, database_name, username, password
     */
    //todo Configuration for postgresql
    public static synchronized void configureDBInterface(DatabaseDetails dbDetails) {
/*        PGSimpleDataSource ds = new PGSimpleDataSource();
        ds.setServerNames(new String[]{dbDetails.getHost()});
        ds.setPortNumbers(new int[]{5432});
        ds.setUser(dbDetails.getUsername());
        ds.setPassword(dbDetails.getPassword());
        ds.setDatabaseName(dbDetails.getDbName());
        ds.setCurrentSchema("public");
        FluentJdbc fluentJdbc = new FluentJdbcBuilder()
                .connectionProvider(ds)
                .afterQueryListener(execution -> {
                    if (execution.success()) {
                        log(Level.DEBUG,
                                String.format("Query took %s ms to execute: %s%n",
                                        execution.executionTimeMs(),
                                        execution.sql())
                        );
                    }
                })
                .build();
        db = fluentJdbc.query();*/
    }
    //todo Configuration for sql server
/*    public static synchronized void configureDBInterface(DatabaseDetails dbDetails) {
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setURL(String.format("jdbc:sqlserver://%s;databaseName=%s;encrypt=true;trustServerCertificate=true;", dbDetails.getHost(), dbDetails.getDbName()));
        ds.setUser(dbDetails.getUsername());
        ds.setPassword(dbDetails.getPassword());
        FluentJdbc fluentJdbc = new FluentJdbcBuilder()
                .connectionProvider(ds)
                .afterQueryListener(execution -> {
                    if (execution.success()) {
                        log(Level.DEBUG,
                                String.format("Query took %s ms to execute: %s%n",
                                        execution.executionTimeMs(),
                                        execution.sql())
                        );
                    }
                })
                .build();
        db = fluentJdbc.query();
    }*/
}