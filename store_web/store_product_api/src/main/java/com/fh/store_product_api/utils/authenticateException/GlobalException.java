package com.fh.store_product_api.utils.authenticateException;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@ControllerAdvice
public class GlobalException {


    @ExceptionHandler(AuthenticateException.class)
    public void authenticateException(AuthenticateException e, HttpServletRequest request, HttpServletResponse response){
        String type = request.getHeader("X-Requested-With");
        if("XMLHttpRequest".equals(type)){
                response.setHeader("NORIGHT",e.getCode().toString());
        }else {
            try {
                response.sendRedirect("noRight.jsp");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

    }



}
