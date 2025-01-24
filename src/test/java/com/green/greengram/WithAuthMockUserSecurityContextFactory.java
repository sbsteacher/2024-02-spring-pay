package com.green.greengram;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

import java.util.List;

public class WithAuthMockUserSecurityContextFactory implements WithSecurityContextFactory<WithAuthUser> {

    @Override
    public SecurityContext createSecurityContext(WithAuthUser annotation) { //annotation으로 WithAuthUser정보가 주입된다.
        SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
        //List<String> roles = List.of(annotation.roles());

        return securityContext; //테스트 때 사용하는 인증처리가 될 것이다.
    }
}
