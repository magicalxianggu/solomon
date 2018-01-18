package com.magical.score.handlers;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhouxp on 2018/1/16
 */
@Component //交给spring管理方便其他类获取该类对象
@Scope(value="singleton")//单例
public class ModuleHandlerBeans implements ApplicationContextAware{

    private ApplicationContext applicationContext;

    /**
     * 获取到的类的实例对象
     */
    private Map<String, Object> classInstances;


    /**
     * 待扫描的基础包名
     */
    private String[] basePackages;


    /**
     * 通过依赖注入获取配置文件中的属性值
     * @param basePackages
     */
    @Resource
    public void setBasePackages(String... basePackages) {
        this.basePackages = basePackages;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


    public void init(){
        if(this.applicationContext == null){
            return;
        }
        if(this.classInstances == null){
            this.classInstances = new HashMap<String,Object>();
        }
        //获取有ModuleHandler注解的实例
        Map<String, Object> beansWithModuleHandlerMap = this.applicationContext.getBeansWithAnnotation(ModuleHandler.class);

        Class<? extends Object> clazz = null;
        for(Map.Entry<String, Object> entry : beansWithModuleHandlerMap.entrySet()){

            clazz = entry.getValue().getClass();//获取到实例对象的class信息
           if(""!=clazz.getAnnotation(ModuleHandler.class).value()) {
               classInstances.put(clazz.getAnnotation(ModuleHandler.class).value(),entry.getValue());
           }else {

               classInstances.put(ClassUtil.getDefaultInstanceName(entry.getValue().getClass()),entry.getValue());
           }

        }


        classInstances = beansWithModuleHandlerMap;



      //  Map<String, Object> beansWithAnnotationMap = this.applicationContext.getBeansWithAnnotation(org.springframework.stereotype.Service.class);

//        Class<? extends Object> clazz = null;
//        for(Map.Entry<String, Object> entry : beansWithModuleHandlerMap.entrySet()){
//            clazz = entry.getValue().getClass();//获取到实例对象的class信息
//            Class<? extends Object>  [] interfaces = clazz.getInterfaces();
//            for(Class<? extends Object>  aInterface : interfaces){
//                String aInterfaceName = aInterface.getName();//接口的完整名
//                for(String packageName : this.basePackages){
//                    if(aInterfaceName.startsWith(packageName)){//如果这个接口是在指定的包下
//
//                        //接口实例名(只是将接口的首字母换成小写)
//                        String aInterfaceSimpleName = ClassUtil.getDefaultInstanceName(aInterface);
//
////                        //如果这个接口没有NotServiceBean注解
////                        if(beansWithNotAutowired2ServiceMap.containsValue(entry.getValue())){
////                            System.out.println(entry.getValue() + " has NotAutowired2Service Annotation");
////                        }else{
//                            classInstances.put(aInterfaceSimpleName, entry.getValue());
//                        //}
//                    }
//                }
//            }
//        }
    }

    public Map<String, Object> getClassInstances() {
        if(this.classInstances == null){
            init();
        }
        return this.classInstances;
    }
}

