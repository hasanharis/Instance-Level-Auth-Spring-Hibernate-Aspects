package com.umarashfaq.tyrion.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.umarashfaq.tyrion.annotation.AuthorizeRequest;
import com.umarashfaq.tyrion.authorization.Authorizer;
import com.umarashfaq.tyrion.exception.UnauthorizedException;

@Component
@Aspect
public class AuththorizationAspect {

	@Autowired
	private ApplicationContext appContext;
	
	@Around(value = "@annotation(annotation)")
    public Object LogExecutionTime(final ProceedingJoinPoint joinPoint, final AuthorizeRequest annotation) throws Throwable {
        
		Authorizer authorizer = (Authorizer) appContext.getBean(annotation.authorizer());
		boolean proceed = false;
		
		switch(annotation.authType())
		{
		case READ:
			proceed = authorizer.canRead(Long.parseLong(joinPoint.getArgs()[0].toString()));
			break;
			
		case EDIT:
			proceed = authorizer.canEdit(Long.parseLong(joinPoint.getArgs()[0].toString()));
			break;
			
		case DELETE:
			proceed = authorizer.canDelete(Long.parseLong(joinPoint.getArgs()[0].toString()));
			break;
		
		case CREATE:
			proceed = authorizer.canCreate();
			break;
		
		}
		
		if(proceed)
			throw new UnauthorizedException();
		
		final Object retVal = joinPoint.proceed();
        return retVal;		

    }
}
