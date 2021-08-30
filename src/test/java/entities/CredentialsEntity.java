package entities;

import com.opencsv.bean.CsvBindByName;
import util.helpers.CsvParser;
import util.config.ReadConfig;

import java.util.List;

public class CredentialsEntity {
    @CsvBindByName(column = "user")
    private String user;

    @CsvBindByName(column = "email")
    private String email;

    @CsvBindByName(column = "password")
    private String password;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static List<CredentialsEntity> getCredentials() {
        return CsvParser.parseCsvToList(CredentialsEntity.class, ReadConfig.getConfigProperty("cred_path"));
    }
}

