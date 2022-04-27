package az.yigim.linkpayment.entity.concretes;

import az.yigim.linkpayment.entity.abstracts.Entity;

public class User implements Entity {

    private Integer id;
    private String username;
    private String password;
    private String salt;

    public User() {
    }

    public User(Integer id, String username, String password, String salt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.salt = salt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return String.format("User{id=%d, username='%s', password='%s', salt='%s'}", id, username, password, salt);
    }
}
