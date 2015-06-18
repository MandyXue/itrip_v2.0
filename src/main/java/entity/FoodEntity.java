package entity;

import javax.persistence.*;

/**
 * Created by mandyxue on 15/6/10.
 */
@Entity
@Table(name = "food", schema = "", catalog = "itripdb")
public class FoodEntity {
    private String name;
    private String cnName;
    private String province;
    private String description;
    private Integer thumbs;

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
    @Column(name = "thumbs", nullable = true, insertable = true, updatable = true)
    public Integer getThumbs() {
        return thumbs;
    }

    public void setThumbs(Integer thumbs) {
        this.thumbs = thumbs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FoodEntity that = (FoodEntity) o;

        if (cnName != null ? !cnName.equals(that.cnName) : that.cnName != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (province != null ? !province.equals(that.province) : that.province != null) return false;
        if (thumbs != null ? !thumbs.equals(that.thumbs) : that.thumbs != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (cnName != null ? cnName.hashCode() : 0);
        result = 31 * result + (province != null ? province.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (thumbs != null ? thumbs.hashCode() : 0);
        return result;
    }
}
