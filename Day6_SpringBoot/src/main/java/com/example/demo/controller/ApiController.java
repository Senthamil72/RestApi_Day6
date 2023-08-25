package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Child;
//import com.example.demo.model.StudentEntity;
import com.example.demo.service.ChildService;
@RestController
public class ApiController {
@Autowired
ChildService sser;
@PostMapping("add")
public Child adddet(@RequestBody Child ss)
{
	return sser.saveinfo(ss);
} 
@GetMapping("show")
public List show()
{
	return sser.showinfo();
}
@PutMapping("update")
public Child update(@RequestBody Child ss)
{
	return sser.updateinfo(ss);
}
@DeleteMapping("Delete")
public String  deletedet(@RequestBody Child ss)
{
	sser.deleteinfo(ss);
	return "Deleted Successfully";
}
@GetMapping("sort/{name}")
public List<Child> getsortinfo(@PathVariable String name)
{
	return sser.sortinfo(name);
}
@GetMapping("paging/{pageno}/{pagesize}")
public List<Child> showpageinfo(@PathVariable int pageno,@PathVariable int pagesize)
{
	//sser.sortinfo(name);
	return sser.getbypage(pageno, pagesize);
}
@GetMapping("paging/{pageno}/{pagesize}/{s}")
public List<Child> showpageinfon(@PathVariable int pageno,@PathVariable int pagesize,@PathVariable String s)
{
	return sser.sortpaging(pageno,pagesize,s);
}
}
