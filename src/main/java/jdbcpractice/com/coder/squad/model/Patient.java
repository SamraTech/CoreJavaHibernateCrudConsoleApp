package jdbcpractice.com.coder.squad.model;

import java.sql.Date;

import javax.persistence.Table;

import org.hibernate.annotations.Columns;
import org.hibernate.annotations.NamedQuery;


@javax.persistence.Entity
@Table(name = "Patient")
//@NamedQuery(name = "patient.name",query ="select p.pName,from Patient p group by p.pName having count(p.pName)>1 " )
public class Patient {
@javax.persistence.Id
@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
private int pId;
private String pName;
@javax.persistence.Column(name = "pCon")
private String pContact;
@javax.persistence.Column(name = "pEmail")
private String email;

private java.sql.Date pDate;
@javax.persistence.Column(name = "flag")
private boolean enabled;
public int getpId() {
	return pId;
}
public void setpId(int pId) {
	this.pId = pId;
}
public String getpName() {
	return pName;
}
public void setpName(String pName) {
	this.pName = pName;
}
public String getpContact() {
	return pContact;
}
public void setpContact(String pContact) {
	this.pContact = pContact;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Date getpDate() {
	return pDate;
}
public void setpDate(Date pDate) {
	System.out.println(pDate);
	this.pDate = pDate;
}
public boolean isEnabled() {
	return enabled;
}
public void setEnabled(boolean enabled) {
	this.enabled = enabled;
}
@Override
public String toString() {
	return "Patient [pId=" + pId + ", pName=" + pName + ", pContact=" + pContact + ", email=" + email + ", pDate="
			+ pDate + ", enabled=" + enabled + "]";
}
public Patient(int pId, String pName, String pContact, String email, Date pDate, boolean enabled) {
	super();
	this.pId = pId;
	this.pName = pName;
	this.pContact = pContact;
	this.email = email;
	this.pDate = pDate;
	this.enabled = enabled;
}
public Patient() {
	super();
	// TODO Auto-generated constructor stub
}
public Patient(String pName, String pContact, String email, Date pDate, boolean enabled) {
	super();
	this.pName = pName;
	this.pContact = pContact;
	this.email = email;
	this.pDate = pDate;
	this.enabled = enabled;
}
public Patient(int pId) {
	super();
	this.pId = pId;
}
public Patient(String pName) {
	super();
	this.pName = pName;
}
public Patient(int pId, String email) {
	super();
	this.pId = pId;
	this.email = email;
}






}
