package com.orient.sapclient;

import com.orient.sapclient.service.SapService;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SapClientApplicationTests {

    @Test
    void contextLoads() {

        try {
            //接口地址
            String address = "http://localhost:8080/orient/sap?wsdl" ;
            //代理工厂
            JaxWsProxyFactoryBean jwpfb = new JaxWsProxyFactoryBean();
            //设置代理地址
            jwpfb.setAddress(address);
            //添加拦截器认证
//            jwpfb.getOutInterceptors().add(new LoginInterceptor("root", "admin"));

            //设置接口类型
            jwpfb.setServiceClass(SapService.class);
            //创建一个代理接口实现
            SapService ds = (SapService) jwpfb.create();

            String user = "我是世界之王！！！！" ;
            String result = ds.sayHello(user);
            System.out.println(result);
            String res2 = ds.sayBye();
            System.out.println(res2);

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
