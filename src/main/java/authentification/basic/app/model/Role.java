package authentification.basic.app.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String role;

//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "user_id")
//	// @JoinTable(name = "role_user",joinColumns = @JoinColumn(name="user_id"),
//	// inverseJoinColumns = @JoinColumn(name="role_id"))
//	private User user;
//	@Override
//	public String getAuthority() {
//		return this.role;
//	}

}
