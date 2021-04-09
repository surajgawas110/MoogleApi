package com.assignment.Demandtec.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.Demandtec.model.Moogle;
import com.assignment.Demandtec.model.MoogleDataReturned;
import com.assignment.Demandtec.model.PhrasePerPageRequest;
import com.assignment.Demandtec.services.MoogleService;

@RestController
public class MoogleController {

	@Autowired
	private MoogleService moogleService;
	
	@GetMapping("/page/{id}")
	public ResponseEntity<?> getPageById(@PathVariable("id") Integer id){
		Optional<Moogle> moogle=moogleService.getSearchResult(id);
		if(moogle.isPresent()) {
			return ResponseEntity.ok(moogle);
		}
		else {
			return ResponseEntity.ok("No moogle present");
		}
	}
	//================== final two ================================================================
	@GetMapping("/search/{keyword}")
	public ResponseEntity<?> getSearch1(@PathVariable("keyword") String keyword){
		List<String> hits = new ArrayList<String>();
		int count =0;
		keyword=keyword.toLowerCase();
		List<Moogle> moogle=moogleService.getSearchResultPrefixHeading(keyword);
		for(int i=0;i < moogle.size();i++) {
			hits.add(moogle.get(i).getHeading());
			count=count+1;
			if(count > 10) {
				break;
			}
		}
		if(count <= 10) {
			List<Moogle> moogleShort=moogleService.getSearchResultPrefixShort(keyword);
			for(int i=0;i < moogleShort.size();i++) {
				hits.add(moogleShort.get(i).getShortDescription());
				count=count+1;
				if(count > 10) {
					break;
				}
			}
		}
		if(count <= 10) {
			List<Moogle> moogleLong=moogleService.getSearchResultPrefixLong(keyword);
			for(int i=0;i < moogleLong.size();i++) {
				hits.add(moogleLong.get(i).getLongDescription());
				count=count+1;
				if(count > 10) {
					break;
				}
			}
		}
		if(count <= 10) {
			List<Moogle> moogleContent=moogleService.getSearchResultPrefixContent(keyword);
			for(int i=0;i < moogleContent.size();i++) {
				hits.add(moogleContent.get(i).getContentType());
				count=count+1;
				if(count > 10) {
					break;
				}
			}
		}
		if(count <= 10) {
			List<Moogle> moogleUrl=moogleService.getSearchResultPrefixUrl(keyword);
			for(int i=0;i < moogleUrl.size();i++) {
				hits.add(moogleUrl.get(i).getUrl());
				count=count+1;
				if(count > 10) {
					break;
				}
			}
		}
		return ResponseEntity.ok(hits);
	}
	@PostMapping("/search")
	public ResponseEntity<?> getSearchPhrasePerPage(@RequestBody PhrasePerPageRequest pageRequest){
		String keyword = pageRequest.getKeywords();
		int pageNumber = pageRequest.getPageNumber();
		int totalRows=0;
		List<Moogle> moogleHit=new ArrayList<Moogle>();
		keyword=keyword.toLowerCase();
		List<Moogle> moogleHeading=moogleService.getSearchResultPrefixHeading(keyword);
		List<Moogle> moogleShortDescription=moogleService.getSearchResultPrefixShort(keyword);
		List<Moogle> moogleLongDescription=moogleService.getSearchResultPrefixLong(keyword);
		List<Moogle> moogleUrl=moogleService.getSearchResultPrefixUrl(keyword);
		List<Moogle> moogleContentType=moogleService.getSearchResultPrefixContent(keyword);
		
		if(moogleHeading.size() > 0) {
			moogleHit.addAll(moogleHeading);
		}
		if(moogleShortDescription.size() > 0) {
			moogleHit.addAll(moogleShortDescription);	
		}
		if(moogleLongDescription.size() > 0) {
			moogleHit.addAll(moogleLongDescription);	
		}
		if(moogleUrl.size() > 0) {
			moogleHit.addAll(moogleUrl);	
		}
		if(moogleContentType.size() > 0) {
			moogleHit.addAll(moogleContentType);	
		}
		
		int lastIndex=pageNumber*10;
		int startIndex=lastIndex-10;
		totalRows=moogleHit.size();
		if(lastIndex > totalRows) {
			lastIndex=totalRows;
		}
		MoogleDataReturned moogleDataReturned = new MoogleDataReturned();
		moogleDataReturned.setMoogles(moogleHit.subList(startIndex, lastIndex));
		moogleDataReturned.setPages(moogleHit.size());
		return ResponseEntity.ok(moogleDataReturned);
	}
	
}
