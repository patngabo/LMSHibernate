package com.gcit.training;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gcit.training.library.hbm.entities.TblAuthor;
import com.gcit.training.library.hbm.entities.TblBook;

/**
 * Handles requests for the application home page.
 */
@RestController
public class HomeRestController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeRestController.class);

	@PersistenceContext
	private EntityManager em;

	@Transactional
	@RequestMapping(value = "/author/add", method = { RequestMethod.GET,
			RequestMethod.POST }, consumes = "application/json")
	public String addAuthor(@RequestBody TblAuthor author) {

		try {
			em.persist(author);
		} catch (Exception e) {
			e.printStackTrace();
			return "Author create failed: " + e.getMessage();
		}

		return "Author created succesfully!";
	}

	@RequestMapping(value = "/authors/getAll", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json")
	public List<TblAuthor> getAllAuthors() {
		try {
//			em.createQuery(
//					"from TblAuthor where authorName = :aName and authorId = :aId")
//					.setParameter("aName", "Search String")
//					.setParameter("aId", "Search String").getResultList();
			//em.createQuery("from TblAuthor").setFirstResult(21).setMaxResults(10).getResultList();
			@SuppressWarnings("unchecked")
			List<TblAuthor> list = em.createQuery("from TblAuthor").getResultList(); 
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Transactional
	@RequestMapping(value = "/book/add", method = { RequestMethod.GET,
			RequestMethod.POST }, consumes = "application/json")
	public void createBook(@RequestBody TblBook b) {
		try {
			em.persist(b);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
