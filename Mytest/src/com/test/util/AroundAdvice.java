package com.test.util;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundAdvice implements MethodInterceptor {

	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("session.beginTransaction...");
		Object ojb = arg0.proceed();
		System.out.println("session.commit...");
		return ojb;
	}

}
