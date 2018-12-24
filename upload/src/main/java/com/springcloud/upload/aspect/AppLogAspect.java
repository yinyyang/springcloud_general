package com.springcloud.upload.aspect;

import io.swagger.annotations.ApiOperation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Enumeration;

@Component
@Order(-5)
@Aspect
public class AppLogAspect {
    private Logger LOGGER = LoggerFactory.getLogger(AppLogAspect.class);
    // 保证每个线程都有一个单独的实例
    private ThreadLocal<Long> threadLocal = new ThreadLocal<>();
    @Autowired
    private Environment env;

    @Pointcut("execution(* com.springcloud.upload.web..*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint) throws Exception{
        threadLocal.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //访问操作描述
        String uriDesc = getControllerMethodDescription(joinPoint);
        //访问操作
        String uri = request.getRequestURI();
        //请求参数
        String reqParam = null;
        //当前项目名称
        String appName = env.getProperty("spring.application.name");

        // 记录请求的内容
        LOGGER.info("Request URL: " + request.getRequestURL().toString());
        LOGGER.info("URI："+ uri);
        String contentType = request.getContentType();
        LOGGER.info("contentType: " + contentType);
        LOGGER.info("Request Method: "+ request.getMethod());
        LOGGER.info("IP: "+ request.getRemoteAddr());
        LOGGER.info("User-Agent: " +request.getHeader("User-Agent"));
        LOGGER.info("Class Method: " + joinPoint.getSignature().getDeclaringTypeName() + "."  + joinPoint.getSignature().getName());

        if(contentType != null && contentType.indexOf("multipart/form-data") != -1){
            Object [] o = joinPoint.getArgs();
            MultipartFile file = (MultipartFile)o[0];
            LOGGER.info(file.getOriginalFilename());
            LOGGER.info("Params: " + o[0]);
            reqParam = file.getOriginalFilename();
        }else{
            Object [] o = joinPoint.getArgs();
            if(o != null && o.length > 0){
                LOGGER.info("Params: " + o[0].toString());
                reqParam = o[0].toString();
            }
        }

        Enumeration<String> enums = request.getParameterNames();
        while (enums.hasMoreElements()) {
            String paraName = enums.nextElement();
            LOGGER.info(paraName + ":" + request.getParameter(paraName));
        }


    }

    @After("pointcut()")
    public void doAfter(JoinPoint joinPoint) {
        LOGGER.info("doAfter(): " + joinPoint.toString());
    }


    @AfterReturning(returning = "ret", pointcut = "pointcut()")
    public void doAfterReturning(Object ret) {
        // 处理完请求，返回内容
        LOGGER.info("返回内容 : " + ret);
        LOGGER.info("耗时 : " + ((System.currentTimeMillis() - threadLocal.get())) + "ms");
    }


    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    private String getControllerMethodDescription(JoinPoint joinPoint)  throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    Object temp = method.getAnnotation(ApiOperation.class);
                    if(temp != null){
                        description = method.getAnnotation(ApiOperation.class).value();
                    }
                    break;
                }
            }
        }
        return description;
    }
}
