/*
 * Copyright (C) 2001-2016 Food and Agriculture Organization of the
 * United Nations (FAO-UN), United Nations World Food Programme (WFP)
 * and United Nations Environment Programme (UNEP)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or (at
 * your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301, USA
 *
 * Contact: Jeroen Ticheler - FAO - Viale delle Terme di Caracalla 2,
 * Rome - Italy. email: geonetwork@osgeo.org
 */
package org.fao.geonet.domain.userfeedback;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.fao.geonet.domain.GeonetEntity;

/**
 * A Keyword associated with a user feedback, like a tag.
 */
@Entity(name = "GUF_Keywords")
@Table(name = "GUF_Keywords")
@SequenceGenerator(name = Keyword.ID_SEQ_NAME, initialValue = 100, allocationSize = 1)
public class Keyword extends GeonetEntity implements Serializable {

    /** The Constant ID_SEQ_NAME. */
    static final String ID_SEQ_NAME = "gufkey_id_seq";

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -5828055384917117874L;

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = Keyword.ID_SEQ_NAME)
    private long id;

    /** The value. */
    @Column
    private String value;

    /** The userfeedbacks. */
    @ManyToMany(mappedBy = "keywords")
    private List<UserFeedback> userfeedbacks;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Gets the userfeedbacks.
     *
     * @return the userfeedbacks
     */
    public List<UserFeedback> getUserfeedbacks() {
        return userfeedbacks;
    }

    /**
     * Gets the value.
     *
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Sets the userfeedbacks.
     *
     * @param userfeedbacks the new userfeedbacks
     */
    public void setUserfeedbacks(List<UserFeedback> userfeedbacks) {
        this.userfeedbacks = userfeedbacks;
    }

    /**
     * Sets the value.
     *
     * @param value the new value
     */
    public void setValue(String value) {
        this.value = value;
    }

}
