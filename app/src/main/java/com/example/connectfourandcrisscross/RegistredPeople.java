package com.example.connectfourandcrisscross;

public class RegistredPeople {
    public String name;
    public String Id;
    public String password;

    public RegistredPeople(String name, String id, String password) {
        this.name = name;
        Id = id;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
