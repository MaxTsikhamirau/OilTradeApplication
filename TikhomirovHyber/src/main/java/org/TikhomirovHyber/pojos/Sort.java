package org.TikhomirovHyber.pojos;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sort")
public class Sort implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sort_id")
	private Integer sort_id;

	@Column(name = "sort_name")
	private String sort_name;

	public Integer getSort_id() {
		return sort_id;
	}

	public Sort() {

	}

	public Sort(String sort_name) {
		super();
		this.sort_name = sort_name;
	}

	public void setSort_id(Integer sort_id) {
		this.sort_id = sort_id;
	}

	public String getSort_name() {
		return sort_name;
	}

	public void setSort_name(String sort_name) {
		this.sort_name = sort_name;
	}

	@Override
	public String toString() {
		return "Sort [sort_id=" + sort_id + ", sort_name=" + sort_name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sort_id == null) ? 0 : sort_id.hashCode());
		result = prime * result + ((sort_name == null) ? 0 : sort_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sort other = (Sort) obj;
		if (sort_id == null) {
			if (other.sort_id != null)
				return false;
		} else if (!sort_id.equals(other.sort_id))
			return false;
		if (sort_name == null) {
			if (other.sort_name != null)
				return false;
		} else if (!sort_name.equals(other.sort_name))
			return false;
		return true;
	}

}
