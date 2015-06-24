package entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by mandyxue on 15/6/18.
 */
public class UploadEntityPK implements Serializable {
    private String username;
    private String spotfood;



    @Column(name = "username", nullable = false, insertable = true, updatable = true, length = 15)
    @Id
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "spotfood", nullable = false, insertable = true, updatable = true, length = 50)
    @Id
    public String getSpotfood() {
        return spotfood;
    }

    public void setSpotfood(String spotfood) {
        this.spotfood = spotfood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UploadEntityPK that = (UploadEntityPK) o;

        if (spotfood != null ? !spotfood.equals(that.spotfood) : that.spotfood != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (spotfood != null ? spotfood.hashCode() : 0);
        return result;
    }
}
