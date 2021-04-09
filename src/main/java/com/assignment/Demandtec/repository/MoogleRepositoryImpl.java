package com.assignment.Demandtec.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.DisjunctionMaxQuery;
import org.apache.lucene.search.FuzzyQuery;
import org.apache.lucene.search.PhraseQuery;
import org.apache.lucene.search.PrefixQuery;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.WildcardQuery;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.BooleanJunction;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.apache.lucene.search.BooleanClause;
import org.apache.lucene.search.BooleanClause.Occur;

import com.assignment.Demandtec.model.Moogle;

public class MoogleRepositoryImpl  implements MoogleRepositoryExt {

	private List<Term> hitTerms= new ArrayList<Term>();
	private final EntityManager entityManager;

	@Override
	@Transactional(readOnly = true)
	public List<Moogle> search(final String keywords) {
		
		final FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);

		// Search query builder
		final QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder()
				.forEntity(Moogle.class).get();

		// Use a boolean junction and then add queries to it
		final BooleanJunction<BooleanJunction> outer = queryBuilder.bool();
		outer.must(queryBuilder.keyword().onFields("heading","shortDescription","longDescription","contentType","url").matching(keywords).createQuery());

		@SuppressWarnings("unchecked")
		List<Moogle> resultList = fullTextEntityManager.createFullTextQuery(outer.createQuery(), Moogle.class)
				.getResultList();
		return resultList;
	}
	//============= main ================
	@Override
	@Transactional(readOnly = true)
	public List<Moogle> searchPrefixHeading(final String keywords){
		String[] keyss=keywords.split(" ");
 		final FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
		BooleanQuery.Builder bqb = new BooleanQuery.Builder();
		for(int i=0; i < keyss.length;i++) {
			Query q = new PrefixQuery(new Term("heading",keyss[i]));
			bqb.add(q,BooleanClause.Occur.MUST);
		}
		@SuppressWarnings("unchecked")
		List<Moogle> resultList = fullTextEntityManager.createFullTextQuery(bqb.build(), Moogle.class)
				.getResultList();
		return resultList;
	}
	@Override
	@Transactional(readOnly = true)
	public List<Moogle> searchPrefixShort(final String keywords){
		String[] keyss=keywords.split(" ");
 		final FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
		BooleanQuery.Builder bqb = new BooleanQuery.Builder();
		for(int i=0; i < keyss.length;i++) {
			Query q = new PrefixQuery(new Term("shortDescription",keyss[i]));
			bqb.add(q,BooleanClause.Occur.MUST);
		}
		@SuppressWarnings("unchecked")
		List<Moogle> resultList = fullTextEntityManager.createFullTextQuery(bqb.build(), Moogle.class)
				.getResultList();
		return resultList;
	}
	@Override
	@Transactional(readOnly = true)
	public List<Moogle> searchPrefixLong(final String keywords){
		String[] keyss=keywords.split(" ");
 		final FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
		BooleanQuery.Builder bqb = new BooleanQuery.Builder();
		for(int i=0; i < keyss.length;i++) {
			Query q = new PrefixQuery(new Term("longDescription",keyss[i]));
			bqb.add(q,BooleanClause.Occur.MUST);
		}
		@SuppressWarnings("unchecked")
		List<Moogle> resultList = fullTextEntityManager.createFullTextQuery(bqb.build(), Moogle.class)
				.getResultList();
		return resultList;
	}
	@Override
	@Transactional(readOnly = true)
	public List<Moogle> searchPrefixUrl(final String keywords){
		String[] keyss=keywords.split(" ");
 		final FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
		BooleanQuery.Builder bqb = new BooleanQuery.Builder();
		for(int i=0; i < keyss.length;i++) {
			Query q = new PrefixQuery(new Term("url",keyss[i]));
			bqb.add(q,BooleanClause.Occur.MUST);
		}
		@SuppressWarnings("unchecked")
		List<Moogle> resultList = fullTextEntityManager.createFullTextQuery(bqb.build(), Moogle.class)
				.getResultList();
		return resultList;
	}
	@Override
	@Transactional(readOnly = true)
	public List<Moogle> searchPrefixContent(final String keywords){
		String[] keyss=keywords.split(" ");
 		final FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
		BooleanQuery.Builder bqb = new BooleanQuery.Builder();
		for(int i=0; i < keyss.length;i++) {
			Query q = new PrefixQuery(new Term("contentType",keyss[i]));
			bqb.add(q,BooleanClause.Occur.MUST);
		}
		@SuppressWarnings("unchecked")
		List<Moogle> resultList = fullTextEntityManager.createFullTextQuery(bqb.build(), Moogle.class)
				.getResultList();
		return resultList;
	}
	//=============== XX ====================
	public MoogleRepositoryImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
}
