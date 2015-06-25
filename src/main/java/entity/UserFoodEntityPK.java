package entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by mandyxue on 15/6/25.
 */
public class UserFoodEntityPK implements Serializable {
    private String username;
    private String foodname;

    @Column(name = "username", nullable = false, insertable = true, updatable = true, length = 15)
    @Id
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "foodname", nullable = false, insertable = true, updatable = true, length = 50)
    @Id
    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserFoodEntityPK that = (UserFoodEntityPK) o;

        if (foodname != null ? !foodname.equals(that.foodname) : that.foodname != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (foodname != null ? foodname.hashCode() : 0);
        return result;
    }
}
