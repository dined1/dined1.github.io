/**
 * This file was generated by the JPA Modeler
 */
package com.hellokoding.account.Models;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.ws.rs.FormParam;
import java.io.Serializable;

/**
 * @author dzni0816
 */
@Entity
@Table(name = "itemgroup")
@Transactional
public class Itemgroup implements Serializable {

    @Column(name = "IGId", table = "itemgroup", nullable = false)
    @Id
    private Long iGId;

    @ManyToOne(targetEntity = Group1.class)
    private Group1 groups1;

    @ManyToOne(targetEntity = Item.class)
    private Item item1;

    public Long getiGId() {
        return this.iGId;
    }

    public void setiGId(Long iGId) {
        this.iGId = iGId;
    }

    public Group1 getGroups1() {
        return this.groups1;
    }

    public void setGroups1(Group1 groups1) {
        this.groups1 = groups1;
    }

    public Item getItem1() {
        return this.item1;
    }

    public void setItem1(Item item1) {
        this.item1 = item1;
    }

}
