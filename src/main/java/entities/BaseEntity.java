package entities;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//l'id viene messo nelle tabelle dei sottotipi, non avrò tabella BaseEntity
public abstract class BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	protected Long id;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}
}
