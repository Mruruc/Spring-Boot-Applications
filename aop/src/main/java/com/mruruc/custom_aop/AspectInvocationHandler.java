package com.mruruc.custom_aop;

import com.mruruc.custom_aop.annotations.After;
import com.mruruc.custom_aop.annotations.Before;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AspectInvocationHandler implements InvocationHandler {
    private final Object target;
    private final Aspect aspect;

    public AspectInvocationHandler(Object target, Aspect aspect) {
        this.target = target;
        this.aspect = aspect;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        boolean isTransactional = method.isAnnotationPresent(Before.class) || method.isAnnotationPresent(After.class);
        if (isTransactional) {
            try {
                if (method.isAnnotationPresent(Before.class)) aspect.before();
                Object result = method.invoke(target, args);
                if (method.isAnnotationPresent(After.class)) aspect.after();
                return result;
            } catch (Exception e) {
                aspect.onException();
                throw e;
            }
        } else {
            return method.invoke(target, args);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T createProxy(T target, Aspect aspect) {
        return (T) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new AspectInvocationHandler(target, aspect));
    }
}
