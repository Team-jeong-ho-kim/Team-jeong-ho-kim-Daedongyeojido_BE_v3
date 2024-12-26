package org.example.daedongyeojido_be.global.logging.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class RequestLoggingFilterConfig {

    @Bean
    public FilterRegistrationBean<CommonsRequestLoggingFilter> logFilter() {
        CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
        filter.setIncludeQueryString(true); // 쿼리 스트링 포함
        filter.setIncludePayload(true); // 요청 페이로드(본문) 포함
        filter.setMaxPayloadLength(10000); // 페이로드의 최대 길이 설정
        filter.setIncludeHeaders(false); // 헤더는 로그에 포함하지 않음
        filter.setAfterMessagePrefix("REQUEST DATA : "); // 로그 메시지 접두어

        FilterRegistrationBean<CommonsRequestLoggingFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(filter);
        registrationBean.setOrder(Ordered.HIGHEST_PRECEDENCE); // 필터 순서를 가장 높게 설정

        return registrationBean;
    }
}
