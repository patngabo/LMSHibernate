package com.gcit.training.library.hbm.entities;
// default package
// Generated Feb 12, 2015 3:39:38 PM by Hibernate Tools 4.0.0

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * TblAuthor generated by hbm2java
 */
@Entity
@Table(name = "tbl_author", catalog = "library")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="authorName", scope=TblAuthor.class)
public class TblAuthor implements java.io.Serializable {

	private Integer authorId;
	private String authorName;

	public TblAuthor() {
	}

	public TblAuthor(String authorName) {
		this.authorName = authorName;
	}

	public TblAuthor(String authorName, Set<TblBook> tblBooks,
			Set<TblBook> tblBooks_1) {
		this.authorName = authorName;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "authorId", unique = true, nullable = false)
	public Integer getAuthorId() {
		return this.authorId;
	}

	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}

	@Column(name = "authorName", nullable = false, length = 45)
	public String getAuthorName() {
		return this.authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public static void main(String[] args) {
	
		Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());

        SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
        Session session = sessionFactory.openSession();
		
        TblAuthor a = new TblAuthor("Some New Author");
        Transaction tx = session.beginTransaction();
        session.save(a);
        tx.commit();
        session.close();
	}

}
