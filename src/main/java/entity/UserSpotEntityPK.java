package entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by AngelYang on 2015/6/4.
 */
public class UserSpotEntityPK implements Serializable {
    private String username;
    private String spotname;

    @Column(name = "username", nullable = false, insertable = true, updatable = true, length = 15)
    @Id
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "spotname", nullable = false, insertable = true, updatable = true, length = 30)
    @Id
    public String getSpotname() {
        return spotname;
    }

    public void setSpotname(String spotname) {
        this.spotname = spotname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserSpotEntityPK that = (UserSpotEntityPK) o;

        if (spotname != null ? !spotname.equals(that.spotname) : that.spotname != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (spotname != null ? spotname.hashCode() : 0);
        return result;
    }
}
