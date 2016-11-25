/**
 * This file was generated by the JPA Modeler
 */
package com.mycompany.mavenproject1;

import javax.persistence.*;
import javax.ws.rs.FormParam;
import java.io.Serializable;
import java.util.List;

/**
 * @author dzni0816
 */

@Entity
@Table(name = "item")
public class Item implements Serializable {




    @Column(name = "ItemId", table = "item", nullable = false)
    @Id
    @FormParam("itemId")
    private Integer itemId;

    @Column(name = "Name", table = "item")
    @Basic
    @FormParam("name")
    private String name;

    @Column(name = "Type", table = "item")
    @Basic
    @FormParam("type")
    private String type;

    @Column(name = "Description", table = "item")
    @Basic
    @FormParam("description")
    private String description;

    @Column(name = "DefMP", table = "item", precision = 12)
    @Basic
    @FormParam("defMP")
    private Float defMP;

    @Column(name = "DefOTP", table = "item", precision = 12)
    @Basic
    @FormParam("defOTP")
    private Float defOTP;

    @Column(name = "ModifiedDate", table = "item")
    @Basic
    @FormParam("modifiedDate")
    private String modifiedDate;

    @OneToMany(targetEntity = ProductItems.class, mappedBy = "item1")
    private List<ProductItems> productItemses1;

    @OneToMany(targetEntity = Itemgroup.class, mappedBy = "item1")
    private List<Itemgroup> itemgroups1;

    @OneToMany(targetEntity = Itemdiscount.class, mappedBy = "item1")
    private List<Itemdiscount> itemdiscounts1;

    public Integer getItemId() {
        return this.itemId;
    }

    public void setItemId(Integer itemId) {
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

    public List<ProductItems> getProductItemses1() {
        return this.productItemses1;
    }

    public void setProductItemses1(List<ProductItems> productItemses1) {
        this.productItemses1 = productItemses1;
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

}
