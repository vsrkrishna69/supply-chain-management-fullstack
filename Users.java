
package jsp.supplychainmanagement.entity;
import jakarta.persistence.*;

	

	

	@Entity
	@Table(name = "users")
	public class Users {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		@Column(unique = true)
	    private String username;

	    private String password;

	    private String role; // ADMIN, CUSTOMER, SUPPLIER

		public static Object builder() {
			// TODO Auto-generated method stub
			return null;
		}

	    // getters and setters
	}



