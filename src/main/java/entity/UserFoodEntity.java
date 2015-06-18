package entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by mandyxue on 15/6/10.
 */
@Entity
@Table(name = "user_food", schema = "", catalog = "itripdb")
@IdClass(UserFoodEntityPK.class)
public class UserFoodEntity {
    private String username;
    private String foodname;
    private Date date;

    public UserFoodEntity(String username, String foodname, Date date) {
        this.username = username;
        this.foodname = foodname;
        this.date = date;
    }

    public UserFoodEntity() {
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
    @Column(name = "foodname", nullable = false, insertable = true, updatable = true, length = 50)
    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    @Basic
    @Column(name = "date", nullable = false, insertable = true, updatable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserFoodEntity that = (UserFoodEntity) o;

        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (foodname != null ? !foodname.equals(that.foodname) : that.foodname != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (foodname != null ? foodname.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
