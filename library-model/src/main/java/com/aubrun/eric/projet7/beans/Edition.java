package com.aubrun.eric.projet7.beans;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name="edition_id_generator", sequenceName = "edition_id_seq", allocationSize=1)
@Table(name = "EDITION")
public class Edition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "edition_id_generator")
    @Column(name = "id_edition")
    private Integer editionId;
    @Column(name = "edition_name")
    private String nameEdition;

    public Edition() {
    }

    public Integer getEditionId() {
        return editionId;
    }

    public void setEditionId(Integer editionId) {
        this.editionId = editionId;
    }

    public String getNameEdition() {
        return nameEdition;
    }

    public void setNameEdition(String nameEdition) {
        this.nameEdition = nameEdition;
    }

    @Override
    public String toString() {
        return "Edition{" +
                "editionId=" + editionId +
                ", nameEdition='" + nameEdition + '\'' +
                '}';
    }
}
