package com.gmail.genadyms.parse.dao.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "project")
@Getter
@Setter
public class ProjectEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "unique_id")
	private String uniqueIdentifier;
	@Column(name = "description")
	private String description;

	@Override
	public String toString()
	{
		return "ProjectEntity{" + "id=" + id + ", uniqueIdentifier='" + uniqueIdentifier + '\'' + ", description='" + description + '\'' + '}';
	}
}
