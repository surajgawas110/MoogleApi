package com.assignment.Demandtec.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.Demandtec.model.Moogle;
import com.assignment.Demandtec.repository.MoogleRepository;

@Service
public class MoogleService {
	

	
	@Autowired
	private MoogleRepository moogleRepository;

	public Optional<Moogle> getSearchResult(int id){
		Optional<Moogle> moogle=moogleRepository.findById(id);
		return moogle;
	}
	public List<Moogle> getSearchResultAll(){
		List<Moogle> moogle=moogleRepository.findAll();
		return moogle;
	}
	public List<Moogle> getSearchResulKeyword(String keyword){
		//List<Moogle> moogle=moogleRepository.searchKeyword(keyword);
		try {
			List<Moogle> moogle=moogleRepository.search(keyword);
			return moogle;
		}
		catch(Exception e) {
			System.out.println("========== "+e);
			return null;
		}
		
		
	}
	
	//========================= fianls  ==========================================
	public List<Moogle> getSearchResultPrefixHeading(String keyword){
		try {
			List<Moogle> moogle=moogleRepository.searchPrefixHeading(keyword);
			return moogle;
		}
		catch(Exception e) {
			System.out.println("========== "+e);
			return null;
		}
	}
	public List<Moogle> getSearchResultPrefixShort(String keyword){
		try {
			List<Moogle> moogle=moogleRepository.searchPrefixShort(keyword);
			return moogle;
		}
		catch(Exception e) {
			System.out.println("========== "+e);
			return null;
		}
	}
	public List<Moogle> getSearchResultPrefixLong(String keyword){
		try {
			List<Moogle> moogle=moogleRepository.searchPrefixLong(keyword);
			return moogle;
		}
		catch(Exception e) {
			System.out.println("========== "+e);
			return null;
		}
	}
	public List<Moogle> getSearchResultPrefixContent(String keyword){
		try {
			List<Moogle> moogle=moogleRepository.searchPrefixContent(keyword);
			return moogle;
		}
		catch(Exception e) {
			System.out.println("========== "+e);
			return null;
		}
	}
	public List<Moogle> getSearchResultPrefixUrl(String keyword){
		try {
			List<Moogle> moogle=moogleRepository.searchPrefixUrl(keyword);
			return moogle;
		}
		catch(Exception e) {
			System.out.println("========== "+e);
			return null;
		}
	}

}
