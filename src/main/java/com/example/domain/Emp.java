package com.example.domain;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
//@ToString(exclude={"dept"})
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
	
	public enum Gender {
		M, F;
	}
	
	@Id
	@Column(precision=4)
	private BigInteger empno;
	@Column(length=10, nullable=false)
	private String ename;
	@Enumerated(EnumType.STRING)
	@Column(length=1)
	private Gender gender;
	@Column(length=9)
	private String job;
	private Integer mgr;
	@Temporal(TemporalType.DATE)
	private Date hiredate;
	private BigDecimal sal;
	private BigDecimal comm;

	@ManyToOne(fetch=FetchType.LAZY)
//	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="deptno")
	private Dept dept;
}



