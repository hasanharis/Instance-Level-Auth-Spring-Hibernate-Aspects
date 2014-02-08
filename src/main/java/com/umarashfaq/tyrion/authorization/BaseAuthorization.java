package com.umarashfaq.tyrion.authorization;

import java.util.List;

public class BaseAuthorization implements Authorizer{

	@Override
	public boolean canRead(long id) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean canEdit(long id) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean canCreate() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean canDelete(long id) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public List<Object> filter() {
		// TODO Auto-generated method stub
		return null;
	}

}
