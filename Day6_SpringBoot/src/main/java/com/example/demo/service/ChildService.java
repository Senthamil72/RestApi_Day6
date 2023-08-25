package com.example.demo.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Child;
//import com.example.demo.model.StudentEntity;
//import com.example.demo.model.StudentEntity;
import com.example.demo.repository.ChildRepo;

@Service
public class ChildService {
	@Autowired
	ChildRepo sr;
	public Child saveinfo(Child ss)
	{
		return sr.save(ss);
	}
	public List<Child> showinfo()
	{
		return sr.findAll();
	}
	public Child updateinfo(Child ss)
	{
		return sr.saveAndFlush(ss);
	}
	public void deleteinfo(Child ss)
	{
		sr.delete(ss);
	}
	public List<Child> sortinfo(String s)
	{
		return sr.findAll(Sort.by(Sort.Direction.DESC,s));
			}
	public List<Child> getbypage(int pgno,int pgsize)
	{
		//sr.findAll(Sort.by(Sort.Direction.DESC,s));
		Page<Child>p=sr.findAll(PageRequest.of(pgno,pgsize));
		return p.getContent();
	}
	public List<Child>sortpaging(int pgno,int pgsize,String str)
	{
		Page<Child>p=sr.findAll(PageRequest.of(pgno,pgsize,Sort.by(str)));
		return p.getContent();
	}
}
