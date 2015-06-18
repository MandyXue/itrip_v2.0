package entity;

import javax.persistence.*;

/**
 * Created by mandyxue on 15/6/18.
 */
@Entity
@Table(name = "upload", schema = "", catalog = "itripdb")
@IdClass(UploadEntityPK.class)
public class UploadEntity {
    private String username;
    private String spotfood;
    private String pictures;
    private int pvalid;
    private String description;
    private int dvalid;

    public UploadEntity(String username,  String spotfood, String pictures, String description) {
        this.username = username;
        this.dvalid = 0;
        this.spotfood = spotfood;
        this.pictures = pictures;
        this.pvalid = 0;
        this.description = description;
    }

    public UploadEntity() {
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
    @Column(name = "spotfood", nullable = false, insertable = true, updatable = true, length = 50)
    public String getSpotfood() {
        return spotfood;
    }

    public void setSpotfood(String spotfood) {
        this.spotfood = spotfood;
    }

    @Basic
    @Column(name = "pictures", nullable = true, insertable = true, updatable = true, length = 50)
    public String getPictures() {
        return pictures;
    }

    public void setPictures(String pictures) {
        this.pictures = pictures;
    }

    @Basic
    @Column(name = "pvalid", nullable = false, insertable = true, updatable = true)
    public int getPvalid() {
        return pvalid;
    }

    public void setPvalid(int pvalid) {
        this.pvalid = pvalid;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 3000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "dvalid", nullable = false, insertable = true, updatable = true)
    public int getDvalid() {
        return dvalid;
    }

    public void setDvalid(int dvalid) {
        this.dvalid = dvalid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UploadEntity that = (UploadEntity) o;

        if (dvalid != that.dvalid) return false;
        if (pvalid != that.pvalid) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (pictures != null ? !pictures.equals(that.pictures) : that.pictures != null) return false;
        if (spotfood != null ? !spotfood.equals(that.spotfood) : that.spotfood != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (spotfood != null ? spotfood.hashCode() : 0);
        result = 31 * result + (pictures != null ? pictures.hashCode() : 0);
        result = 31 * result + pvalid;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + dvalid;
        return result;
    }
}
