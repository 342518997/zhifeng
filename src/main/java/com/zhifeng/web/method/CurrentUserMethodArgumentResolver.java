package com.zhifeng.web.method;

import com.zhifeng.web.annotation.CurrentUser;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * <p>用于绑定@FormModel的方法参数解析器
 * <p>User:
 * <p>Date:
 * <p>Version:
 */

public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    //用于判定是否需要处理该参数分解，返回true为需要，并会去调用下面的方法resolveArgument。
    public boolean supportsParameter(MethodParameter methodParameter) {
        if (methodParameter.hasParameterAnnotation(CurrentUser.class)) {
            return true;
        }
        return false;
    }
    //真正用于处理参数分解的方法，返回的Object就是controller方法上的形参对象。
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        CurrentUser currentUserAnnotation = methodParameter.getParameterAnnotation(CurrentUser.class);
        return nativeWebRequest.getAttribute(currentUserAnnotation.value(), NativeWebRequest.SCOPE_REQUEST);
    }

}
