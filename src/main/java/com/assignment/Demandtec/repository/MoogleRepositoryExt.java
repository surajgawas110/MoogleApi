package com.assignment.Demandtec.repository;

import java.util.List;

import com.assignment.Demandtec.model.Moogle;

public interface MoogleRepositoryExt {
	List<Moogle> search(final String keywords);
	List<Moogle> searchPrefixHeading(String keywords);
	List<Moogle> searchPrefixShort(String keywords);
	List<Moogle> searchPrefixLong(String keywords);
	List<Moogle> searchPrefixUrl(String keywords);
	List<Moogle> searchPrefixContent(String keywords);
}
