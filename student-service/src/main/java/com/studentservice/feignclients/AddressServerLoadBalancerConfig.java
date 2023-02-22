/*
package com.studentservice.feignclients;


import feign.Feign;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

@LoadBalancerClient(value = "adress-service")
public class AddressServerLoadBalancerConfig {

    @LoadBalanced
    @Bean
    public Feign.Builder feignBuilder (){
        return Feign.builder();
    }

}
*/
