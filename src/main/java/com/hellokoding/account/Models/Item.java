/**
 * This file was generated by the JPA Modeler
 */
package com.hellokoding.account.Models;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.ws.rs.FormParam;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

/**
 * @author dzni0816
 */

@Entity
@Table(name = "item")
@Transactional
public class Item implements Serializable {

    @Column(name = "ItemId", table = "item", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long itemId;

    @Column(name = "Name", table = "item")
    @Basic
    private String name;

    @Column(name = "Type", table = "item")
    @Basic
    private String type;

    @Column(name = "Description", table = "item")
    @Basic
    private String description;

    @Column(name = "DefMP", table = "item", precision = 12)
    @Basic
    private Float defMP;

    @Column(name = "DefOTP", table = "item", precision = 12)
    @Basic
    private Float defOTP;

    @Column(name = "ModifiedDate", table = "item")
    @Basic
    private String modifiedDate;

    @Column(name = "Quantity", table = "item")
    @Basic
    private BigInteger quantity;

    @OneToMany(targetEntity = ItemLocations.class, mappedBy = "item")
    private List<ItemLocations> itemlocations;

//    @OneToMany(targetEntity = ProductItems.class, mappedBy = "item1")
//    private List<ProductItems> productItemses1;

    @OneToMany(targetEntity = Itemgroup.class, mappedBy = "item1")
    private List<Itemgroup> itemgroups1;

    @OneToMany(targetEntity = Itemdiscount.class, mappedBy = "item1")
    private List<Itemdiscount> itemdiscounts1;

    @OneToMany(targetEntity = ItemCharacteristic.class, mappedBy = "item")
    private List<ItemCharacteristic> itemCharacteristic;

    public Long getItemId() {
        return this.itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getDefMP() {
        return this.defMP;
    }

    public void setDefMP(Float defMP) {
        this.defMP = defMP;
    }

    public Float getDefOTP() {
        return this.defOTP;
    }

    public void setDefOTP(Float defOTP) {
        this.defOTP = defOTP;
    }

    public String getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public List<Itemgroup> getItemgroups1() {
        return this.itemgroups1;
    }

    public void setItemgroups1(List<Itemgroup> itemgroups1) {
        this.itemgroups1 = itemgroups1;
    }

    public List<Itemdiscount> getItemdiscounts1() {
        return this.itemdiscounts1;
    }

    public void setItemdiscounts1(List<Itemdiscount> itemdiscounts1) {
        this.itemdiscounts1 = itemdiscounts1;
    }

    public List<ItemCharacteristic> getItemCharacteristic() {
        return itemCharacteristic;
    }

    public void setItemCharacteristic(List<ItemCharacteristic> itemCharacteristic) {
        this.itemCharacteristic = itemCharacteristic;
    }

    public List<ItemLocations> getItemlocations() {
        return itemlocations;
    }

    public void setItemlocations(List<ItemLocations> itemlocations) {
        this.itemlocations = itemlocations;
    }

    public BigInteger getQuantity() {
        return quantity;
    }

    public void setQuantity(BigInteger quantity) {
        this.quantity = quantity;
    }
}
