package com.example.demo2.AdminControler;

import com.example.demo2.ResIpml.CategoryRes;
import com.example.demo2.ResIpml.GoodsRes;
import com.example.demo2.Response.CommonResponse;
import com.example.demo2.Response.ResponseEnum;
import com.example.demo2.entity.Category;
import com.example.demo2.entity.Goods;
import com.example.demo2.entity.Images;
import com.example.demo2.tools.fileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.UUID;

import static java.net.URLDecoder.*;

@RestController
@RequestMapping("/Admin")
public class AdminControoller {

    @Autowired
    CategoryRes categoryRes;

    @Autowired
    GoodsRes goodsRes;
    @PostMapping("/saveCateGory")
    public CommonResponse addCateGory(@RequestBody @Validated Category category){
        CommonResponse commonResponse=new CommonResponse();
        commonResponse.setCode(ResponseEnum.RESPONSE_ENUM_Success.getCode());
        commonResponse.setMessage(ResponseEnum.RESPONSE_ENUM_Success.getDesc());
        commonResponse.setResult(categoryRes.save(category));
        return commonResponse;
    }

    @PostMapping("/addGoods")
    public CommonResponse addGoods(@RequestBody @Validated Goods goods){

        CommonResponse commonResponse=new CommonResponse();
        String uuid=UUID.randomUUID().toString();
        goods.setGoodsBanners(uuid);
       for(Images images :goods.getGoodsBanner()) {
           images.setImageUid(uuid);
       }
        commonResponse.setCode(ResponseEnum.RESPONSE_ENUM_Success.getCode());
        commonResponse.setMessage(ResponseEnum.RESPONSE_ENUM_Success.getDesc());
        commonResponse.setResult(goodsRes.save(goods));
        return commonResponse;

    }
    @PostMapping("/editGoods")
    public CommonResponse editGoods(@RequestBody @Validated Goods goods){
        CommonResponse commonResponse=new CommonResponse();
        commonResponse.setCode(ResponseEnum.RESPONSE_ENUM_Success.getCode());
        commonResponse.setMessage(ResponseEnum.RESPONSE_ENUM_Success.getDesc());
        commonResponse.setResult(goodsRes.save(goods));
        return commonResponse;
    }

    @PostMapping("/upLoadPicture")
    public CommonResponse upLoadPicture(@RequestParam("fileContent")String fileContent) throws FileNotFoundException {
        CommonResponse commonResponse=new CommonResponse();
        commonResponse.setCode(ResponseEnum.RESPONSE_ENUM_Success.getCode());
        commonResponse.setMessage(ResponseEnum.RESPONSE_ENUM_Success.getDesc());
        commonResponse.setResult(fileUtil.GenerateImage(fileContent));
        return commonResponse;
    }


}
