package com.sadi.asm2.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadi.asm2.model.Person.Staff;

@Service
@Transactional
public class StaffService {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {this.sessionFactory = sessionFactory;}
	
	public Staff createStaff(Staff staff) {
		this.sessionFactory.getCurrentSession().save(staff);
		return staff;
	}
	
	public List<Staff> getAllStaffs() {
		return this.sessionFactory.getCurrentSession().createQuery("from Staff").list();
	}
	
	public Staff getStaff(int id) {
		return (Staff) this.sessionFactory.getCurrentSession().get(Staff.class, id);
	}
	
	public void updateStaff(Staff staff) {
		this.sessionFactory.getCurrentSession().update(staff);
	}
	
	public List<Staff> searchStaff(Staff staff){
		List<Staff> staffList = this.sessionFactory.getCurrentSession()
				.createQuery("from Staff where id=:id or name=:name or address=:address or phone=:phone or email=:email")
				.setInteger("id", staff.getId())
				.setString("name", staff.getName())
				.setString("address", staff.getAddress())
				.setString("phone", staff.getPhone())
				.setString("email", staff.getEmail())
				.list();
		
		return staffList;
	}
}
