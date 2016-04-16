/**
 * This file is part of Aion-Lightning <aion-lightning.org>.
 *
 *  Aion-Lightning is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  Aion-Lightning is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details. *
 *  You should have received a copy of the GNU General Public License
 *  along with Aion-Lightning.
 *  If not, see <http://www.gnu.org/licenses/>.
 */


//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2011.09.06 at 02:39:47 DU CEST 
//


package com.aionemu.packetsamurai.utils.collector.data.npcskills;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NpcSkillTemplate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NpcSkillTemplate">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="skillid" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="skilllevel" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="probability" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="maxhp" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="minhp" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NpcSkillTemplate")
public class NpcSkillTemplate {

	@XmlAttribute
	protected Integer minhp;

	@XmlAttribute
	protected Integer maxhp;

	@XmlAttribute
	protected Integer probability;

	@XmlAttribute
	protected Integer skilllevel;

	@XmlAttribute
	protected Integer skillid;

	@XmlTransient
	protected NpcSkillUseStats stats = new NpcSkillUseStats();

	/**
	 * Gets the value of the skillid property.
	 * 
	 * @return possible object is {@link Integer }
	 */
	public Integer getSkillid() {
		return skillid;
	}

    /**
     * Sets the value of the skillid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSkillid(Integer value) {
        this.skillid = value;
    }

    /**
     * Gets the value of the skilllevel property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSkilllevel() {
        return skilllevel;
    }

    /**
     * Sets the value of the skilllevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSkilllevel(Integer value) {
        this.skilllevel = value;
    }

    /**
     * Gets the value of the probability property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getProbability() {
        return probability;
    }

    /**
     * Sets the value of the probability property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setProbability(Integer value) {
        this.probability = value;
    }

    /**
     * Gets the value of the maxhp property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxhp() {
        return maxhp;
    }

    /**
     * Sets the value of the maxhp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxhp(Integer value) {
        this.maxhp = value;
    }

    /**
     * Gets the value of the minhp property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMinhp() {
        return minhp;
    }

    /**
     * Sets the value of the minhp property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMinhp(Integer value) {
        this.minhp = value;
    }
    
    public NpcSkillUseStats getStats() {
    	return stats;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((skillid == null) ? 0 : skillid.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NpcSkillTemplate other = (NpcSkillTemplate) obj;
		if (skillid == null) {
			if (other.skillid != null)
				return false;
		}
		else if (!skillid.equals(other.skillid))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NpcSkillTemplate [skillid=" + skillid + ", skilllevel="
				+ skilllevel + "]";
	}

}
