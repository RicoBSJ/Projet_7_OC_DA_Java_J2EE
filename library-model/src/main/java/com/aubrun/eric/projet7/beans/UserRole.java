package com.aubrun.eric.projet7.beans;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name="user_role_id_generator", sequenceName = "user_role_id_seq", allocationSize=1)
@Table(name = "USER_ROLE")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "user_role_id_generator")
    @Column(name = "id_user_role")
    private Integer userRoleId;
    @Column(name = "user_role_name")
    private String userRoleName;

    public UserRole() {
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "userRoleId=" + userRoleId +
                ", userRoleName='" + userRoleName + '\'' +
                '}';
    }
}
