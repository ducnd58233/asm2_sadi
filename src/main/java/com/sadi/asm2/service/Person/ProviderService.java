package com.sadi.asm2.service.Person;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sadi.asm2.model.Person.Provider;


@Service
@Transactional
public class ProviderService {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Provider addProvider(Provider provider) {
		this.sessionFactory.getCurrentSession().save(provider);
		return provider;
	}
	
	public List<Provider> getAllProviders(){
		return this.sessionFactory.getCurrentSession().createQuery("from Provider").list();
	}
	
	public Provider getProvider(int id) {
		return (Provider) this.sessionFactory.getCurrentSession().get(Provider.class, id);
	}
	
	public void updateProvider(Provider provider) {
		this.sessionFactory.getCurrentSession().update(provider);
	}
	
	public void deleteProvider(int id) {
		Provider provider = this.getProvider(id);
		this.sessionFactory.getCurrentSession().delete(provider);
	}
	
	public List<Provider> searchProvider(Provider provider){
		List<Provider> providerList = this.sessionFactory.getCurrentSession()
				.createQuery("from Provider where id= :id or name= :name or address= :address or phone= :phone or fax= :fax or email= :email")
				.setInteger("id", provider.getId())
				.setString("name", provider.getName())
				.setString("address", provider.getAddress())
				.setString("phone", provider.getPhone())
				.list();
		return providerList;
	}
}
