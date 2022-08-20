package com.nt.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "EMPLOYEE_INFO_TAB")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class EmployeeInfo {

	@Id
	@GeneratedValue
	private Integer eno;

	@Column(length = 20)
	@NonNull
	private String ename;

	@ElementCollection //Enables the collection mapping
	@CollectionTable(name = "EMPLOYEE_FRIENDS", joinColumns = @JoinColumn(name = "EMP_ID", referencedColumnName = "ENO")) //To specify the child table and fk column
	@Column(name = "FRIEND_NAME", length = 20) //To store the List elements
	@OrderColumn(name = "FRIEND_INDEX") //To store List element indexes
	@ListIndexBase(1)
	@NonNull
	private List<String> friends;

	@ElementCollection //Enables the collection mapping
	@CollectionTable(name = "EMPLOYEE_PHONES", joinColumns = @JoinColumn(name = "EMP_ID", referencedColumnName = "ENO"))
	@Column(name = "EMPLOYEE_PHONES") //To store Set elements
	@NonNull
	private Set<Long> phones;

	@ElementCollection //Enables the collection mapping
	@CollectionTable(name = "EMPLOYEE_IDDETAILS", joinColumns = @JoinColumn(name = "EMP_ID", referencedColumnName = "ENO"))
	@Column(name = "ID_NUMBER") //To store Map element values
	@MapKeyColumn(name = "ID_TYPE", length = 20) //To store map element keys
	@NonNull
	private Map<String, Long> idDetails;

}
