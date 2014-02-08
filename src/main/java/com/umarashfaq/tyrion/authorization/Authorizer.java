package com.umarashfaq.tyrion.authorization;

import java.util.List;

public interface Authorizer {

	boolean canRead(long id);
	boolean canEdit(long id);
	boolean canCreate();
	boolean canDelete(long id);
	List<Object> filter();
}
