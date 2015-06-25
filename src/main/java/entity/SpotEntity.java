package entity;

import javax.persistence.*;

/**
 * Created by mandyxue on 15/6/25.
 */
@Entity
@Table(name = "spot", schema = "", catalog = "itrip")
public class SpotEntity {
    private String name;
    private String cnName;
    private String province;
    private String description;
    private Integer longtitude;
    private Integer latitude;
    private Integer packageThumbs;
    private Integer coupleThumbs;
    private Integer familyThumbs;

    @Id
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "cn_name", nullable = false, insertable = true, updatable = true, length = 50)
    public String getCnName() {
        return cnName;
    }

    public void setCnName(String cnName) {
        this.cnName = cnName;
    }

    @Basic
    @Column(name = "province", nullable = false, insertable = true, updatable = true, length = 30)
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Basic
    @Column(name = "description", nullable = false, insertable = true, updatable = true, length = 3000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "longtitude", nullable = true, insertable = true, updatable = true)
    public Integer getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Integer longtitude) {
        this.longtitude = longtitude;
    }

    @Basic
    @Column(name = "latitude", nullable = true, insertable = true, updatable = true)
    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "package_thumbs", nullable = true, insertable = true, updatable = true)
    public Integer getPackageThumbs() {
        return packageThumbs;
    }

    public void setPackageThumbs(Integer packageThumbs) {
        this.packageThumbs = packageThumbs;
    }

    @Basic
    @Column(name = "couple_thumbs", nullable = true, insertable = true, updatable = true)
    public Integer getCoupleThumbs() {
        return coupleThumbs;
    }

    public void setCoupleThumbs(Integer coupleThumbs) {
        this.coupleThumbs = coupleThumbs;
    }

    @Basic
    @Column(name = "family_thumbs", nullable = true, insertable = true, updatable = true)
    public Integer getFamilyThumbs() {
        return familyThumbs;
    }

    public void setFamilyThumbs(Integer familyThumbs) {
        this.familyThumbs = familyThumbs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SpotEntity that = (SpotEntity) o;

        if (cnName != null ? !cnName.equals(that.cnName) : that.cnName != null) return false;
        if (coupleThumbs != null ? !coupleThumbs.equals(that.coupleThumbs) : that.coupleThumbs != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (familyThumbs != null ? !familyThumbs.equals(that.familyThumbs) : that.familyThumbs != null) return false;
        if (latitude != null ? !latitude.equals(that.latitude) : that.latitude != null) return false;
        if (longtitude != null ? !longtitude.equals(that.longtitude) : that.longtitude != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (packageThumbs != null ? !packageThumbs.equals(that.packageThumbs) : that.packageThumbs != null)
            return false;
        if (province != null ? !province.equals(that.province) : that.province != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (cnName != null ? cnName.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (longtitude != null ? longtitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (packageThumbs != null ? packageThumbs.hashCode() : 0);
        result = 31 * result + (coupleThumbs != null ? coupleThumbs.hashCode() : 0);
        result = 31 * result + (familyThumbs != null ? familyThumbs.hashCode() : 0);
        return result;
    }
}
