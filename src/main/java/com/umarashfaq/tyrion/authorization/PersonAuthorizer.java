package com.umarashfaq.tyrion.authorization;

import org.springframework.stereotype.Component;

@Component
public class PersonAuthorizer extends BaseAuthorization{

	@Override
	public boolean canRead(long id){
		return super.canRead(id);
	}
}
