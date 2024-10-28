package pjm.microservice.dashboard.model;

import java.sql.Timestamp;

public class AuthLogin {

    private String id;

    private String username;

    private String kdHakAkses;

    private String nmHakAkses;

    private String hakAkses;

    private Timestamp iat;

    private Timestamp exp;

    private Boolean checkDB;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKdHakAkses() {
        return kdHakAkses;
    }

    public void setKdHakAkses(String kdHakAkses) {
        this.kdHakAkses = kdHakAkses;
    }

    public String getNmHakAkses() {
        return nmHakAkses;
    }

    public void setNmHakAkses(String nmHakAkses) {
        this.nmHakAkses = nmHakAkses;
    }

    public String getHakAkses() {
        return hakAkses;
    }

    public void setHakAkses(String hakAkses) {
        this.hakAkses = hakAkses;
    }

    public Timestamp getIat() {
        return iat;
    }

    public void setIat(Timestamp iat) {
        this.iat = iat;
    }

    public Timestamp getExp() {
        return exp;
    }

    public void setExp(Timestamp exp) {
        this.exp = exp;
    }

    public Boolean getCheckDB() {
        return checkDB;
    }

    public void setCheckDB(Boolean checkDB) {
        this.checkDB = checkDB;
    }
}
