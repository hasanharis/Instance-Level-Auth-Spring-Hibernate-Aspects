package com.umarashfaq.tyrion.business;

import java.io.Serializable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.umarashfaq.tyrion.annotation.AuthorizeRequest;
import com.umarashfaq.tyrion.authorization.AuthRequestType;
import com.umarashfaq.tyrion.authorization.PersonAuthorizer;
import com.umarashfaq.tyrion.domain.Person;

@Service
@Transactional
public class PersonManager extends BaseService<Person>{

	@Override
	@AuthorizeRequest(authType = AuthRequestType.READ, authorizer = PersonAuthorizer.class)
	public Person findById(Serializable id){
		return super.findById(id);
	}
}
