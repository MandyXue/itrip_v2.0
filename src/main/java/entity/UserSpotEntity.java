package entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by mandyxue on 15/6/10.
 */
@Entity
@Table(name = "user_spot", schema = "", catalog = "itripdb")
@IdClass(UserSpotEntityPK.class)
public class UserSpotEntity {
    private String username;
    private String spotname;
    private Date date;
    private String type;

    public UserSpotEntity(String username, String spotname, Date date, String type) {
        this.username = username;
        this.spotname = spotname;
        this.date = date;
        this.type = type;
    }

    public UserSpotEntity() {
    }

    @Id
    @Column(name = "username", nullable = false, insertable = true, updatable = true, length = 15)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Id
    @Column(name = "spotname", nullable = false, insertable = true, updatable = true, length = 30)
    public String getSpotname() {
        return spotname;
    }

    public void setSpotname(String spotname) {
        this.spotname = spotname;
    }

    @Basic
    @Column(name = "date", nullable = false, insertable = true, updatable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "type", nullable = false, insertable = true, updatable = true, length = 15)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserSpotEntity that = (UserSpotEntity) o;

        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (spotname != null ? !spotname.equals(that.spotname) : that.spotname != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (spotname != null ? spotname.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }
}
