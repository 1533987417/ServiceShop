package com.example.demo2.Wxcontroller;

import com.example.demo2.Request.GetGoodsRequest;
import com.example.demo2.ResIpml.*;
import com.example.demo2.Response.CommonResponse;
import com.example.demo2.Response.PageResponse;
import com.example.demo2.Response.ResponseEnum;
import com.example.demo2.entity.*;

import com.example.demo2.tools.HttpClient;
import com.example.demo2.tools.WxEntity.CreateOrderRequest;
import com.example.demo2.tools.XMLUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/wxApi")
public class testController {
    @Autowired
    CategoryRes categoryRes;

    @Autowired
    GoodsRes goodsRes;

    @Autowired
    AddressRes addressRes;

    @Autowired
    RegionRes regionRes;

    @Autowired
    CartRes cartRes;
    @Autowired
    CommentRes commentRes;
    Logger logger = LoggerFactory.getLogger(testController.class);
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String test(){
        HttpClient client=new HttpClient();
        CreateOrderRequest request=new CreateOrderRequest();
        request.setAppid("44444");

        return client.post("https://api.mch.weixin.qq.com/pay/unifiedorder", XMLUtil.convertToXml(request));
    }
    @RequestMapping(value = "/getCategory",method = RequestMethod.GET)
    public CommonResponse getCategory(@RequestParam("categoryPid") Integer categoryPid){
        CommonResponse<List<Category>> response=new CommonResponse<List<Category>>();
        if(categoryPid==null){
            response.setCode(ResponseEnum.RESPONSE_ENUM_Parm_Error.getCode());
            response.setMessage(ResponseEnum.RESPONSE_ENUM_Parm_Error.getDesc());
        }else {
            response.setResult(categoryRes.getAllByCategoryPidAndCategoryStatus(Long.valueOf(categoryPid), Long.valueOf(0)));
            response.setCode(ResponseEnum.RESPONSE_ENUM_Success.getCode());
            response.setMessage(ResponseEnum.RESPONSE_ENUM_Success.getDesc());

        }
        return  response;
    }

    @RequestMapping(value = "/getGoods",method = RequestMethod.GET)
    public CommonResponse getGoodsByCateGory(@RequestBody GetGoodsRequest request){
        CommonResponse<PageResponse<Goods>> response=new CommonResponse<>();
        if(request==null){
            response.setCode(ResponseEnum.RESPONSE_ENUM_Parm_Error.getCode());
            response.setMessage(ResponseEnum.RESPONSE_ENUM_Parm_Error.getDesc());
        }else {
            Pageable pageable1=new PageRequest(request.getPageIndex()-1,request.getPageSize());
            Goods goods=new Goods();
            goods.setGoodsCategoryId(Long.valueOf(request.getCategoryId()));
            goods.setGoodsName(request.getGoodsName());
            if(request.getGoodStatus()==null){
                goods.setGoodsStatus(Long.valueOf(0));
            }else {
                goods.setGoodsStatus(Long.valueOf(request.getGoodStatus()));
            }
            ExampleMatcher matcher = ExampleMatcher.matching()
                    .withMatcher("goodsName",ExampleMatcher.GenericPropertyMatchers.contains())
                    ;
            Example<Goods> example =Example.of(goods,matcher);
            Page<Goods> pageData= goodsRes.findAll(example,pageable1);
            response.setResult(new PageResponse(pageData.getContent(),pageData.getTotalElements(),pageData.getTotalPages()));
            response.setCode(ResponseEnum.RESPONSE_ENUM_Success.getCode());
            response.setMessage(ResponseEnum.RESPONSE_ENUM_Success.getDesc());

        }
        return  response;
    }

    @RequestMapping(value = "/saveAdress",method = RequestMethod.POST)
    public CommonResponse saveAdress(@RequestBody @Validated Address adress){
        CommonResponse commonResponse=new CommonResponse();
        commonResponse.setResult(addressRes.save(adress));
        commonResponse.setMessage(ResponseEnum.RESPONSE_ENUM_Success.getDesc());
        commonResponse.setCode(ResponseEnum.RESPONSE_ENUM_Success.getCode());
        return  commonResponse;
    }

    @RequestMapping(value = "/getAdress",method = RequestMethod.GET)
    public CommonResponse saveAdress(@RequestParam("userId") Long userId){
        CommonResponse commonResponse=new CommonResponse();

        if(userId==null){
            commonResponse.setCode(ResponseEnum.RESPONSE_ENUM_Parm_Error.getCode());
            commonResponse.setMessage(ResponseEnum.RESPONSE_ENUM_Parm_Error.getDesc());
        }else{
            commonResponse.setResult(addressRes.getByUserIdAndAddressStatus(userId, Long.valueOf(0)));
            commonResponse.setMessage(ResponseEnum.RESPONSE_ENUM_Success.getDesc());
            commonResponse.setCode(ResponseEnum.RESPONSE_ENUM_Success.getCode());
        }


        return  commonResponse;
    }

    @RequestMapping(value = "/getRegionByPid",method = RequestMethod.GET)
    public CommonResponse getRegionByPid(@RequestParam("parentId") Long parentId){
        CommonResponse commonResponse=new CommonResponse();

        if(parentId==null){
            commonResponse.setCode(ResponseEnum.RESPONSE_ENUM_Parm_Error.getCode());
            commonResponse.setMessage(ResponseEnum.RESPONSE_ENUM_Parm_Error.getDesc());
        }else{
            commonResponse.setResult(regionRes.getByParentId(parentId));
            commonResponse.setMessage(ResponseEnum.RESPONSE_ENUM_Success.getDesc());
            commonResponse.setCode(ResponseEnum.RESPONSE_ENUM_Success.getCode());
        }


        return  commonResponse;
    }


    @RequestMapping(value = "/getCommentsByGid",method = RequestMethod.GET)
    public CommonResponse getCommentsByGid(@RequestParam("commentGid") Long commentGid,@RequestParam("pageIndex") Integer pageIndex,@RequestParam("pageSize") Integer pageSize){
        CommonResponse commonResponse=new CommonResponse();

        if(commentGid==null){
            commonResponse.setCode(ResponseEnum.RESPONSE_ENUM_Parm_Error.getCode());
            commonResponse.setMessage(ResponseEnum.RESPONSE_ENUM_Parm_Error.getDesc());
        }else{
            Pageable pageable1=new PageRequest(pageIndex-1,pageSize);
            Comments comments=new Comments();
            comments.setCommentGid(commentGid);
            Example<Comments> example =Example.of(comments);
            Page<Comments> pageData=commentRes.findAll(example,pageable1);
            commonResponse.setResult(new PageResponse(pageData.getContent(),pageData.getTotalElements(),pageData.getTotalPages()));
            commonResponse.setMessage(ResponseEnum.RESPONSE_ENUM_Success.getDesc());
            commonResponse.setCode(ResponseEnum.RESPONSE_ENUM_Success.getCode());
        }
        return  commonResponse;
    }

    @RequestMapping(value = "/AddComments",method = RequestMethod.POST)
    public CommonResponse getCommentsByGid(@RequestBody Comments comment){
        CommonResponse commonResponse=new CommonResponse();

        String uuid= UUID.randomUUID().toString();
        comment.setCommentUrl(uuid);
        for(Images images :comment.getCommentPics()) {
            images.setImageUid(uuid);
        }
            commonResponse.setResult(commentRes.save(comment));
            commonResponse.setMessage(ResponseEnum.RESPONSE_ENUM_Success.getDesc());
            commonResponse.setCode(ResponseEnum.RESPONSE_ENUM_Success.getCode());
        return  commonResponse;
    }

    @RequestMapping(value = "/SaveToCart",method = RequestMethod.POST)
    public CommonResponse AddToCart(@RequestBody Cart cart){
        CommonResponse commonResponse=new CommonResponse();
        commonResponse.setResult(cartRes.save(cart));
        commonResponse.setMessage(ResponseEnum.RESPONSE_ENUM_Success.getDesc());
        commonResponse.setCode(ResponseEnum.RESPONSE_ENUM_Success.getCode());
        return  commonResponse;
    }

    @RequestMapping(value = "/getMyCart",method = RequestMethod.GET)
    public CommonResponse getMyCart(@RequestParam("cartUserId")Long cartUserId){
        CommonResponse commonResponse=new CommonResponse();
        commonResponse.setResult(cartRes);
        commonResponse.setMessage(ResponseEnum.RESPONSE_ENUM_Success.getDesc());
        commonResponse.setCode(ResponseEnum.RESPONSE_ENUM_Success.getCode());
        return  commonResponse;
    }

    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(testController.class);

        logger.info("sdsdsds");
        logger.error("错误");
        logger.debug("调试");
    }

}
