package com.jyoti.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.server.ServerWebExchange;


@SpringBootApplication
@EnableDiscoveryClient
public class ApiGateway {

	public static void main(String[] args) {
		SpringApplication.run(ApiGateway.class, args);
	}

	@Bean
 	public RouteLocator routerBuilder(RouteLocatorBuilder routeLocatorBuilder){ 
        	return routeLocatorBuilder.routes()
                        .route("USER-DETAILS",r->r.path("/userOperations/saveUsers")
                        		.and().method(HttpMethod.POST)
                                .uri("http://54.206.61.156:31130/api/user/saveUsers"))
                        
                        .route("USER-DETAILS",r->r.path("/userOperations/saveMutipleUsers")
                        		.and().method(HttpMethod.POST)
                                .uri("http://54.206.61.156:31130/api/user/saveMutipleUsers"))
                        
                        .route("USER-DETAILS",r->r.path("/userOperations/getUsers")
                        		.and().method(HttpMethod.GET)
                                .uri("http://54.206.61.156:31130/api/user/getUsers"))
                        
                        .route("USER-DETAILS",r->r.path("/userOperations/getUsers")
                        		.and().method(HttpMethod.GET)
                                .uri("http://54.206.61.156:31130/api/user/getUsers/{userid}"))
                        
                        .route("USER-DETAILS",r->r.path("/userOperations/getUsersWithPagination")
                        		.and().method(HttpMethod.GET)
                                .uri("http://54.206.61.156:31130/api/user/getUsersByPagination"))
                        
                        .build(); 
    	}

	//Reference for other available options of route configuration in spring-cloud gateway.
	
	// @Bean
	// public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
	// 	return builder.routes()
	// 		.route("path_route", r -> r.path("/get")
	// 			.uri("http://httpbin.org"))
	// 		.route("host_route", r -> r.host("*.myhost.org")
	// 			.uri("http://httpbin.org"))
	// 		.route("rewrite_route", r -> r.host("*.rewrite.org")
	// 			.filters(f -> f.rewritePath("/foo/(?<segment>.*)", "/${segment}"))
	// 			.uri("http://httpbin.org"))
	// 		.route("hystrix_route", r -> r.host("*.hystrix.org")
	// 			.filters(f -> f.hystrix(c -> c.setName("slowcmd")))
	// 			.uri("http://httpbin.org"))
	// 		.route("hystrix_fallback_route", r -> r.host("*.hystrixfallback.org")
	// 			.filters(f -> f.hystrix(c -> c.setName("slowcmd").setFallbackUri("forward:/hystrixfallback")))
	// 			.uri("http://httpbin.org"))
	// 		.route("limit_route", r -> r
	// 			.host("*.limited.org").and().path("/anything/**")
	// 			.filters(f -> f.requestRateLimiter(c -> c.setRateLimiter(redisRateLimiter())))
	// 			.uri("http://httpbin.org"))
	// 		.build();
	// }
	
	
	
	//Reference, HOW TO HANDLE or modify requestbody and pass to next target
//	@Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("dynamic_route", r -> r
//                        .path("/your-path/{variable}")
//                        .and()
//                        .method(HttpMethod.POST)
//                        .filters(f -> f
//                                .modifyRequestBody(String.class, String.class, (exchange, body) -> {
//                                    // Here you can modify the request body if needed
//                                    // For example, log or transform the body content
//                                    return Mono.just(body);
//                                })
//                        )
//                        .uri("http://target-service:8080/target-path/{variable}"))  // Forward the request to target service
//                .build();
//    }
	
	
	//Reference hpw to modify requestBody and pass anything in header  then foloow this 
//	@Bean
//	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//	    return builder.routes()
//	            .route("example_route", r -> r
//	                    .path("/api/{id}")  // Path with variable
//	                    .filters(f -> f
//	                            .modifyRequestBody(String.class, String.class, (exchange, body) -> {
//	                                // Here you can handle request body
//	                                return Mono.just(body);  // Pass the body as-is or modify it
//	                            })
//	                            .addRequestHeader("X-Example-Header", "value")  // Add custom headers if needed
//	                    )
//	                    .uri("http://target-service:8080/target-path/{id}")  // Pass variables and route to the target service
//	            )
//	            .build();
//	}


	
	//Reference if you want to do something with additionally with the path variable
	
    // Optional custom filter to capture path variables
//    public static class PathVariableFilter implements GatewayFilter {
//        @Override
//        public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//            String variable = exchange.getRequest().getURI().getPath().split("/")[2]; // Extract path variable
//
//            // Do something with the extracted path variable, if needed
//            System.out.println("Extracted path variable: " + variable);
//
//            // Continue with the chain
//            return chain.filter(exchange);
//        }
//    }

}
