/**
 * This file was generated by the JPA Modeler
 */
package com.mycompany.mavenproject1;

import javax.persistence.*;
import javax.ws.rs.FormParam;
import java.io.Serializable;

/**
 * @author dzni0816
 */
@Entity
@Table(name = "itemdiscount")
public class Itemdiscount implements Serializable {

    @Column(name = "IDid", table = "itemdiscount", nullable = false)
    @Id
    @FormParam("IDid")
    private Integer IDid;

    @ManyToOne(targetEntity = Item.class)
    private Item item1;

    @ManyToOne(targetEntity = Discountrule.class)
    private Discountrule discountrule1;

    public Integer getIDid() {
        return this.IDid;
    }

    public void setIDid(Integer IDid) {
        this.IDid = IDid;
    }

    public Item getItem1() {
        return this.item1;
    }

    public void setItem1(Item item1) {
        this.item1 = item1;
    }

    public Discountrule getDiscountrule1() {
        return this.discountrule1;
    }

    public void setDiscountrule1(Discountrule discountrule1) {
        this.discountrule1 = discountrule1;
    }

}
