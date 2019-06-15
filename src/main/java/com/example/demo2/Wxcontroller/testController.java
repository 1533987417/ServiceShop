package com.example.demo2.Wxcontroller;

import com.example.demo2.Request.GetGoodsRequest;
import com.example.demo2.Request.WeiXinRequest;
import com.example.demo2.ResIpml.*;
import com.example.demo2.Response.*;
import com.example.demo2.entity.*;

import com.example.demo2.tools.*;

import com.example.demo2.tools.WxEntity.*;

import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.data.domain.*;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

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


    @Autowired
    GoodAttributeRes goodAttributeRes;

    @Autowired
    UserRes userRes;
    @Autowired
    LoggerClient loggerClient;
    @RequestMapping(value = "/hello")
    public String test(@RequestParam("path") String url){

       /* CreateOrderRequest request=new CreateOrderRequest();*/



       return url;
    }
    @RequestMapping(value = "/getCategory",method = RequestMethod.GET)
    public CommonResponse getCategory(@RequestParam("categoryPid") Integer categoryPid){
        CommonResponse<List<Category>> response=new CommonResponse<List<Category>>();
        if(categoryPid==null){
            response.setErrno(ResponseEnum.RESPONSE_ENUM_Parm_Error.getCode());
            response.setErrmsg(ResponseEnum.RESPONSE_ENUM_Parm_Error.getDesc());
        }else {
            response.setData(categoryRes.getAllByCategoryPidAndCategoryStatusOrderByCategorySort(Long.valueOf(categoryPid),Long.valueOf(0)));
            response.setErrno(ResponseEnum.RESPONSE_ENUM_Success.getCode());
            response.setErrmsg(ResponseEnum.RESPONSE_ENUM_Success.getDesc());

        }
        return  response;
    }

    @RequestMapping(value = "/getCategoryById",method = RequestMethod.GET)
    public CommonResponse getCategoryById(@RequestParam("id") Integer id){
        CommonResponse<Category> response=new CommonResponse<Category>();
        if(id==null){
            response.setErrno(ResponseEnum.RESPONSE_ENUM_Parm_Error.getCode());
            response.setErrmsg(ResponseEnum.RESPONSE_ENUM_Parm_Error.getDesc());
        }else {
            response.setData(categoryRes.getOne(Long.valueOf(id)));
            response.setErrno(ResponseEnum.RESPONSE_ENUM_Success.getCode());
            response.setErrmsg(ResponseEnum.RESPONSE_ENUM_Success.getDesc());

        }
        return  response;
    }
    @RequestMapping(value = "/getGoods",method = RequestMethod.POST)
    public CommonResponse getGoodsByCateGory(@RequestBody GetGoodsRequest request){
        CommonResponse<PageResponse<Goods>> response=new CommonResponse<>();
        if(request==null){
            response.setErrno(ResponseEnum.RESPONSE_ENUM_Parm_Error.getCode());
            response.setErrmsg(ResponseEnum.RESPONSE_ENUM_Parm_Error.getDesc());
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
            response.setData(new PageResponse(pageData.getContent(),pageData.getTotalElements(),pageData.getTotalPages()));
            response.setErrno(ResponseEnum.RESPONSE_ENUM_Success.getCode());
            response.setErrmsg(ResponseEnum.RESPONSE_ENUM_Success.getDesc());

        }
        return  response;
    }
    @RequestMapping(value = "/getAttribute",method = RequestMethod.GET)
    public CommonResponse getAttribute(@RequestParam("goodId") Long goodId){
        CommonResponse<List<AttributeResponse>> response=new CommonResponse<List<AttributeResponse>>();
        if(goodId==null){
            response.setErrno(ResponseEnum.RESPONSE_ENUM_Parm_Error.getCode());
            response.setErrmsg(ResponseEnum.RESPONSE_ENUM_Parm_Error.getDesc());
        }else {
            List<AttributeResponse> responseList=new ArrayList<>();
            List<GoodAttribute> all= goodAttributeRes.getGoodAttributesByAttributeGoodIdAndAndAttributeStatus(goodId, Long.valueOf(0));
            List<GoodAttribute> parent=all.stream().filter(x->x.getAttributePid()==0).collect(Collectors.toList());
            for (GoodAttribute e:parent
                 ) {
                AttributeResponse response1=new AttributeResponse();
                response1.setGoodAttribute(e);
               response1.setGoodChildAttribute(all.stream().filter(x->String.valueOf(x.getAttributePid()).equals(String.valueOf(e.getIdgoodAttribute()))).collect(Collectors.toList())); ;
                responseList.add(response1);
            }
            response.setData(responseList);
            response.setErrno(ResponseEnum.RESPONSE_ENUM_Success.getCode());
            response.setErrmsg(ResponseEnum.RESPONSE_ENUM_Success.getDesc());

        }
        return  response;
    }

    @RequestMapping(value = "/getGoodById",method = RequestMethod.GET)
    public CommonResponse getGoodById(@RequestParam("id") Integer id){
        CommonResponse<Goods> response=new CommonResponse<Goods>();
        if(id==null){
            response.setErrno(ResponseEnum.RESPONSE_ENUM_Parm_Error.getCode());
            response.setErrmsg(ResponseEnum.RESPONSE_ENUM_Parm_Error.getDesc());
        }else {
            response.setData(goodsRes.getOne(Long.valueOf(id)));
            response.setErrno(ResponseEnum.RESPONSE_ENUM_Success.getCode());
            response.setErrmsg(ResponseEnum.RESPONSE_ENUM_Success.getDesc());

        }
        return  response;
    }

    @RequestMapping(value = "/saveAdress",method = RequestMethod.POST)
    public CommonResponse saveAdress(@RequestBody @Validated Address adress){
        CommonResponse commonResponse=new CommonResponse();
        commonResponse.setData(addressRes.save(adress));
        commonResponse.setErrmsg(ResponseEnum.RESPONSE_ENUM_Success.getDesc());
        commonResponse.setData(ResponseEnum.RESPONSE_ENUM_Success.getCode());
        return  commonResponse;
    }

    @RequestMapping(value = "/getAdress",method = RequestMethod.GET)
    public CommonResponse saveAdress(@RequestParam("userId") Long userId){
        CommonResponse commonResponse=new CommonResponse();

        if(userId==null){
            commonResponse.setErrno(ResponseEnum.RESPONSE_ENUM_Parm_Error.getCode());
            commonResponse.setErrmsg(ResponseEnum.RESPONSE_ENUM_Parm_Error.getDesc());
        }else{
            commonResponse.setData(addressRes.getByUserIdAndAddressStatus(userId, Long.valueOf(0)));
            commonResponse.setErrmsg(ResponseEnum.RESPONSE_ENUM_Success.getDesc());
            commonResponse.setErrno(ResponseEnum.RESPONSE_ENUM_Success.getCode());
        }


        return  commonResponse;
    }

    @RequestMapping(value = "/getRegionByPid",method = RequestMethod.GET)
    public CommonResponse getRegionByPid(@RequestParam("parentId") Long parentId){
        CommonResponse commonResponse=new CommonResponse();

        if(parentId==null){
            commonResponse.setErrno(ResponseEnum.RESPONSE_ENUM_Parm_Error.getCode());
            commonResponse.setErrmsg(ResponseEnum.RESPONSE_ENUM_Parm_Error.getDesc());
        }else{
            commonResponse.setData(regionRes.getByParentId(parentId));
            commonResponse.setErrmsg(ResponseEnum.RESPONSE_ENUM_Success.getDesc());
            commonResponse.setErrno(ResponseEnum.RESPONSE_ENUM_Success.getCode());
        }


        return  commonResponse;
    }


    @RequestMapping(value = "/getCommentsByGid",method = RequestMethod.GET)
    public CommonResponse getCommentsByGid(@RequestParam("commentGid") Long commentGid,@RequestParam("pageIndex") Integer pageIndex,@RequestParam("pageSize") Integer pageSize,
                                           @RequestParam("hasPic")  Integer hasPic){
        CommonResponse commonResponse=new CommonResponse();

        if(commentGid==null){
            commonResponse.setErrno(ResponseEnum.RESPONSE_ENUM_Parm_Error.getCode());
            commonResponse.setErrmsg(ResponseEnum.RESPONSE_ENUM_Parm_Error.getDesc());
        }else{
            Pageable pageable1=new PageRequest(pageIndex-1,pageSize);
            Comments comments=new Comments();
            comments.setCommentGid(commentGid);
            comments.setCommentStatus(0);
            if(hasPic==1){
                comments.setCommentHasPic(hasPic);
            }

            Example<Comments> example =Example.of(comments);
            Page<Comments> pageData=commentRes.findAll(example,pageable1);
            commonResponse.setData(new PageResponse(pageData.getContent(),pageData.getTotalElements(),pageData.getTotalPages()));
            commonResponse.setErrmsg(ResponseEnum.RESPONSE_ENUM_Success.getDesc());
            commonResponse.setErrno(ResponseEnum.RESPONSE_ENUM_Success.getCode());
        }
        return  commonResponse;
    }

    @RequestMapping(value = "/AddComments",method = RequestMethod.POST)
    public CommonResponse getCommentsByGid(@RequestBody Comments comment){
        CommonResponse commonResponse=new CommonResponse();
        String uuid= UUID.randomUUID().toString();
        comment.setCommentUrl(uuid);
        comment.setCommentHasPic(0);
        if(comment.getCommentPics().size()>0){
            comment.setCommentHasPic(1);
        }
        for(Images images :comment.getCommentPics()) {
            images.setImageUid(uuid);
        }
            commonResponse.setData(commentRes.save(comment));
            commonResponse.setErrmsg(ResponseEnum.RESPONSE_ENUM_Success.getDesc());
            commonResponse.setErrno(ResponseEnum.RESPONSE_ENUM_Success.getCode());
        return  commonResponse;
    }

    @RequestMapping(value = "/SaveToCart",method = RequestMethod.POST)
    public CommonResponse AddToCart(@RequestBody Cart cart){
        CommonResponse commonResponse=new CommonResponse();
        commonResponse.setData(cartRes.save(cart));
        commonResponse.setErrmsg(ResponseEnum.RESPONSE_ENUM_Success.getDesc());
        commonResponse.setErrno(ResponseEnum.RESPONSE_ENUM_Success.getCode());
        return  commonResponse;
    }
    @RequestMapping(value = "/deleteCart",method = RequestMethod.GET)
    public CommonResponse deleteCart(@RequestParam("cartIds")String cartIds ){

        String[] list=cartIds.split(",");
        for (String i:list
             ) {
            if(!StringUtils.isEmpty(i)){
                cartRes.updateStatusCart(Long.valueOf(1), Long.valueOf(i));
            }

        }
        CommonResponse commonResponse=new CommonResponse();
        commonResponse.setData(true);
        commonResponse.setErrmsg(ResponseEnum.RESPONSE_ENUM_Success.getDesc());
        commonResponse.setErrno(ResponseEnum.RESPONSE_ENUM_Success.getCode());
        return  commonResponse;
    }
    @RequestMapping(value = "/getMyCart",method = RequestMethod.GET)
    public CommonResponse getMyCart(@RequestParam("cartUserId")Long cartUserId){
        CommonResponse commonResponse=new CommonResponse();

        List<Cart> list=cartRes.getAllByCartUserIdAndCartGoodStatus(cartUserId, Long.valueOf(0));
        List<CartResponse> responseList=new ArrayList<>();
        for (Cart c:list
             ) {
            CartResponse entity=new CartResponse();
            entity.setIsValid(0);
            long price=0;
            StringBuffer checkedText=new StringBuffer();
            List<AttributeValue> attributeValueList= JsonParse.getInstance().fromJson(c.getCartGoodAttributeValue(),new TypeToken<List<AttributeValue>>() {
        }.getType());
            for (AttributeValue a:attributeValueList
                 ) {
                GoodAttribute goodAttribute= goodAttributeRes.getByIdgoodAttributeAndAndAttributeStatus(Long.valueOf(a.getValueId()),Long.valueOf(0));
                if (goodAttribute==null){
                    entity.setIsValid(1);//重新选择
                }else {
                    price=price+goodAttribute.getAttributePrice();
                    checkedText.append(goodAttribute.getAttributeName());
                    checkedText.append(" ");
                }
            }
            Goods goods=goodsRes.getOne(c.getCartGoodId());
            entity.setGoodName(goods.getGoodsName());
            entity.setGoodIcon(goods.getGoodsIcon());
            entity.setCheckedAttribute(checkedText.toString());
            entity.setPrice(price);

            if(goods.getGoodsStatus()!=0){
                entity.setIsValid(1);//无效
            }
            entity.setCartGoodCount(c.getCartGoodCount());
            entity.setIdcart(c.getIdcart());
            entity.setCartGoodId(c.getCartGoodId());
            responseList.add(entity);

        }
        commonResponse.setData(responseList);
        commonResponse.setErrmsg(ResponseEnum.RESPONSE_ENUM_Success.getDesc());
        commonResponse.setErrno(ResponseEnum.RESPONSE_ENUM_Success.getCode());
        return  commonResponse;
    }

    @PostMapping(value = "/payCallBack",consumes = MediaType.APPLICATION_XML_VALUE,produces = MediaType.APPLICATION_XML_VALUE)
    public NoticeResponse payCallBack(@RequestBody NoticeRequest request){
        NoticeResponse response =new NoticeResponse();
        response.setReturn_msg(request.getReturn_msg());
        response.setReturn_code(request.getReturn_code());
        return response;

    }

    @PostMapping(value = "/reFundCallBack",consumes = MediaType.APPLICATION_XML_VALUE,produces = MediaType.APPLICATION_XML_VALUE)
    public NoticeResponse reFundCallBack(@RequestBody ReFundNoticeRequest request){
        NoticeResponse response =new NoticeResponse();
        response.setReturn_msg(request.getReturn_msg());
        response.setReturn_code(request.getReturn_code());
        return response;

    }


    @PostMapping(value = "/loginByWeiXin")
    public CommonResponse loginByWeiXin(@RequestBody WeiXinRequest request){
        CommonResponse<UserInfoResponse> response=new CommonResponse<>();

        HttpClient httpClient=new HttpClient();
        String resultStr= httpClient.getOpenId("https://api.weixin.qq.com/sns/jscode2session?appid=wxb79f1c37818b2ba6&secret=19b2b88ff3f9a869eaa97033260e35b8&grant_type=authorization_code&js_code="+request.getCode());
        Result result=JsonParse.getInstance().fromJson(resultStr,Result.class);
        System.out.println(JsonParse.getInstance().toJson(result));
        loggerClient.info(JsonParse.getInstance().toJson(result),"",response.getLogId());

       User user= userRes.getUserByOpenId(result.getOpenid());
       enUserInfo userInfo=request.getUserInfo().getUserInfo();


        //根据openId查找用户是否注册登记
       if(user==null||user.getIdUser()==0){
           user =new User();
           user.setUsername("微信用户"+UUID.randomUUID().toString());
           user.setOpenId(result.getOpenid());
           user.setLevelId(0);
           user.setAvatar(userInfo.getAvatarUrl());
           user.setGender(userInfo.getGender());
           user.setNickname(userInfo.getNickName());
           userRes.save(user);//更新用户信息
       }else {
           user.setAvatar(userInfo.getAvatarUrl());
           user.setGender(userInfo.getGender());
           user.setNickname(userInfo.getNickName());
           userRes.save(user);//更新用户信息
       }


        UserInfoResponse u=new UserInfoResponse();
        u.setToken(JwtUtil.generateToken(result.getOpenid()));
        u.setUserInfo(user);
       response.setErrmsg(ResponseEnum.RESPONSE_ENUM_Success.getDesc());
        response.setErrno(ResponseEnum.RESPONSE_ENUM_Success.getCode());
        response.setData(u);


        return response;


    }


    public static void main(String[] args) {
        Logger logger = Logger.getLogger(testController.class);
        HttpClient httpClient=new HttpClient();;
        String result= httpClient.getOpenId("https://api.weixin.qq.com/sns/jscode2session?appid=wxb79f1c37818b2ba6&secret=19b2b88ff3f9a869eaa97033260e35b8&js_code=043oWr7Y0ClGhW1HmWaY0d3o7Y0oWr7r&grant_type=authorization_code");
        System.out.println(JsonParse.getInstance().toJson(result));
    }

}
