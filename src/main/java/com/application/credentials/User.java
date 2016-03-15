
package com.application.credentials;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.application.database.BaseEntity;

@Entity
@Table(name = "SYSTEM_USER", uniqueConstraints = { @UniqueConstraint(columnNames = "username") })
public class User extends BaseEntity implements UserDetails{
	private static final long serialVersionUID = -5265930306807871353L;

    @NotNull(message="User Username cannot be empty.")
    @Column(name = "USERNAME")
	private String username;

    @NotNull(message="User Password cannot be empty.")
	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@NotNull
	@Column(name = "LAST_NAME")
	private String lastName;

	@Email
	@Column(name = "EMAIL")
	private String email;

    @NotNull(message="User Enabled flag must be set to true or false.")
	@Column(name = "ENABLED")
	private boolean enabled = true;

    @NotNull(message="User Expired flag must be set to true or false.")
	@Column(name = "EXPIRED")
	private boolean expired = false;

    @NotNull(message="User Locked flag must be set to true or false.")
	@Column(name = "LOCKED")
	private boolean locked = false;

    @NotNull(message="User Change Password On Next Login flag must be set to true or false.")
	@Column(name = "CHANGE_PASS")
	private Boolean changePass = false;

    @NotNull(message="User Master User flag must be set to true or false.")
	@Column(name = "MASTER_USER")
	private Boolean masterUser = false;

	@Column(name = "NUM_INVALID_LOGIN")
	private Integer numInvalidLogin=0;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TZ_PASSWORD_UPDATED_ON")
	private Date passwordUpdatedOn;


	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "PASSWORD_EXPIRES_ON")
	private Date passwordExpiresOn;

    @NotNull(message="User Expire Password flag must be set to true or false.")
	@Column(name = "EXPIRE_PASSWORD")
	private Boolean expirePass = true;

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public boolean isExpired() {
		return expired;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Transient
	public String getFullName() {
		if (firstName != null) {
			return firstName + " " + lastName;
		}
		return lastName;
	}

	@Override
	public boolean validate() {
		return true;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> aut = new ArrayList<SimpleGrantedAuthority>();
		aut.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		return aut;
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}
}
