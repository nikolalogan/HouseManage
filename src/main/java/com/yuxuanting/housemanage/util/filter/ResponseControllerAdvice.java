package com.yuxuanting.housemanage.util.filter;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nikolalogan.core.controller.exception.APIException;
import com.nikolalogan.core.controller.response.Resp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author: yuxuanting
 * @description:
 * @date: 2020-09-08 21:17
 */

@RestControllerAdvice(basePackages = {"com.yuxuanting.housemanage.controller"}) // 注意哦，这里要加上需要扫描的包
//@RestControllerAdvice() // 注意哦，这里要加上需要扫描的包
@Slf4j
public class ResponseControllerAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> aClass) {
        // 如果接口返回的类型本身就是ResultVO那就没有必要进行额外的操作，返回false
        log.info(JSONUtil.toJsonStr(returnType));
        return !returnType.getParameterType().equals(Resp.class);
    }

    @Override
    public Object beforeBodyWrite(Object data, MethodParameter returnType, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest request, ServerHttpResponse response) {
        // String类型不能直接包装，所以要进行些特别的处理
        if (returnType.getGenericParameterType().equals(String.class)) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                // 将数据包装在R里后，再转换为json字符串响应给前端
                return objectMapper.writeValueAsString(new Resp<>(data));
            } catch (JsonProcessingException e) {
                throw new APIException("返回String类型错误");
            }
        }
        // 将原本的数据包装在R里
        log.info(JSONUtil.toJsonStr(data));
        return new Resp<>(data);
    }
}