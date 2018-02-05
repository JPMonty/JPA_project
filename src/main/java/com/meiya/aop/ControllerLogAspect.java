package com.meiya.aop;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.tools.ant.util.FileUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStreamReader;
import java.util.Optional;

/**
 * @author zhumengdi E-mail:montyzhu7@163.com
 * @version created：2018/1/10 下午7:20
 */
@Aspect
@Component
public class ControllerLogAspect {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("within(@org.springframework.stereotype.Controller *)")
    private static void withinController() {
    }

    @Pointcut("execution(@org.springframework.web.bind.annotation.RequestMapping * *(..))")
    private static void executionRequestMapping() {
    }


    @Pointcut("(" +
            "withinController()" +
            "&& executionRequestMapping())")
    private static void logHttp() {
    }


    @Around("logHttp()")
    public Object aroundCall(final ProceedingJoinPoint joinPoint) throws Throwable {

        final ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        final HttpServletRequest request = requestAttributes.getRequest();

        final String requestURI = request.getRequestURI();

        final String queryString = request.getQueryString();

        Optional<String> postData = Optional.<String>empty();

        if (StringUtils.equals(HttpMethod.POST.name(), request.getMethod())) {
            final String s = FileUtils.readFully(new InputStreamReader(request.getInputStream(), "utf-8"));
            postData = Optional.of(s);
        }

        logger.info(request.getMethod() + "-" + requestURI + "?" + queryString + postData.map(e -> "  postData: " + JSONObject.toJSONString(e)).orElse(""));

        long start = System.currentTimeMillis();

         Object proceed;
        try {
            proceed = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            proceed = "{\"data\" : \"发生未知错误，请联系我们!\"}";
        }
        long end = System.currentTimeMillis();

        final HttpServletResponse response = requestAttributes.getResponse();


        logger.info(request.getMethod() + "-" + requestURI + "?" + queryString + postData.map(e -> "  postData: " + JSONObject.toJSONString(e)).orElse("") + "  ======  elapsed by [" + (end - start) + "]ms" + "  status: [" + response.getStatus() + "]");

        return proceed;
    }


}
