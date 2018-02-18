package com.springboot.jpa.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.jpa.entity.JsonResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e);
        mav.addObject("url", req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public JsonResponse<String> jsonErrorHandler(HttpServletRequest req, MyException e) throws Exception {
    	    JsonResponse<String> response = new JsonResponse<>();
    	    response.setMessage(e.getMessage());
    	    response.setCode(JsonResponse.ERROR);
    	    response.setData("Some Data");
        return response;
    }

}
