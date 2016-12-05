/**
 * This file was generated by the JPA Modeler
 */
package com.hellokoding.account.Models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import java.io.Serializable;
import java.util.List;

/**
 * @author dzni0816
 */
@Entity
@Table(name = "groups")
public class Group1 implements Serializable {

    @Column(name = "GroupId", table = "groups", nullable = false)
    @Id
    private Long groupId;

    @Column(name = "Name", table = "groups", nullable = false)
    @Basic(optional = false)
    private String name;

    @OneToMany(targetEntity = Itemgroup.class, mappedBy = "groups1")
    private List<Itemgroup> itemgroups1;

    public Long getGroupId() {
        return this.groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Itemgroup> getItemgroups1() {
        return this.itemgroups1;
    }

    public void setItemgroups1(List<Itemgroup> itemgroups1) {
        this.itemgroups1 = itemgroups1;
    }

}
