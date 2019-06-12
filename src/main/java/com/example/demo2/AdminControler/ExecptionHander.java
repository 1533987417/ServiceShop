package com.example.demo2.AdminControler;

import com.example.demo2.Response.CommonResponse;
import com.example.demo2.Response.ResponseEnum;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class ExecptionHander {
    /**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {}

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "Magical Sam");
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
   public CommonResponse handleConstraintViolationException(ConstraintViolationException e) {
        CommonResponse response=new CommonResponse();
        response.setErrno(ResponseEnum.RESPONSE_ENUM_Parm_Error.getCode());
        response.setErrmsg(e.getMessage()); ;
        ;
        return response;
    }

    /**
     * 请求的 JSON 参数在请求体内的参数校验
     *
     * @param e 异常信息
     * @return 返回数据
     * @throws JsonProcessingException jackson 的异常
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResponse handleBindException1(MethodArgumentNotValidException e) throws JsonProcessingException {
        e.getBindingResult().getAllErrors().forEach(System.out::println);
        CommonResponse response=new CommonResponse();
        response.setErrno(ResponseEnum.RESPONSE_ENUM_Parm_Error.getCode());
       response.setErrmsg(e.getBindingResult().getFieldError().getField()+":"+e.getBindingResult().getFieldError().getDefaultMessage()); ;
       ;
        return response;
    }

    /***
     *500错误处理
     * @param e
     * @return
     */
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public CommonResponse handleException1(Exception e)  {
        CommonResponse response=new CommonResponse();
        response.setErrno(ResponseEnum.RESPONSE_ENUM_Exception.getCode());
        response.setErrmsg(e.getMessage()); ;
        ;
        return response;
    }
}
