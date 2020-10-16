package com.aubrun.eric.projet7.beans;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORY")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "category_id_generator")
    @SequenceGenerator(name="category_id_generator", sequenceName = "category_id_seq", allocationSize=1)
    @Column(name = "category_id")
    private Integer categoryId;
    @Column(name = "name_category")
    private String nameCategory;

    public Category() {
        super();
    }

    public Category(Integer categoryId, String nameCategory) {
        super();
        this.categoryId = categoryId;
        this.nameCategory = nameCategory;
    }

    public Category(String nameCategory) {
        super();
        this.nameCategory = nameCategory;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", nameCategory='" + nameCategory + '\'' +
                '}';
    }
}
