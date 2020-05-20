package com.shop.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Maps;
import com.shop.common.ServerResponse;
import com.shop.dao.ShippingMapper;
import com.shop.pojo.Shipping;
import com.shop.service.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2020/5/20.
 */
@Service("iShippingService")
public class ShippingServiceImpl implements IShippingService {

    @Autowired
    private ShippingMapper shippingMapper;

    /**
     *  添加收货地址
     * @param userId
     * @param shipping
     * @return
     */
    public ServerResponse add(Integer userId, Shipping shipping){
        shipping.setUserId(userId);
        //Shipping对象里没有id，但是却需要返回id，可在ShippingMapper.xml的insert标签里添加“useGeneratedKeys="true" keyProperty="id"”配置，这样在插入语句后mybatis自动生成的id会自动添加到Shipping对象里
        int rowCount = shippingMapper.insert(shipping);
        if (rowCount > 0){
            Map result = Maps.newHashMap();
            result.put("shippingId", shipping.getId());
            return ServerResponse.createBySuccess("新建地址成功", result);
        }
        return ServerResponse.createByErrorMessage("新建地址失败");
    }

    /**
     *  删除收货地址（注意横向越权）
     * @param userId        此参数用来防止横向越权，因为如果删除不添加此权限，则所有用户登录后如果知道其他用户的地址id都可删除其他用户的地址
     * @param shippingId
     * @return
     */
    public ServerResponse<String> delete(Integer userId, Integer shippingId){
        int rowCount = shippingMapper.deleteByShippingIdAndUserId(shippingId, userId);
        if (rowCount > 0){
            return ServerResponse.createBySuccessMessage("删除地址成功");
        }
        return ServerResponse.createByErrorMessage("删除地址失败");
    }

    /**
     *  更新收货地址（注意横向越权）
     * @param userId
     * @param shipping
     * @return
     */
    public ServerResponse update(Integer userId, Shipping shipping){
        shipping.setUserId(userId);
        //Shipping对象里没有id，但是却需要返回id，可在ShippingMapper.xml的insert标签里添加“useGeneratedKeys="true" keyProperty="id"”配置，这样在插入语句后mybatis自动生成的id会自动添加到Shipping对象里
        int rowCount = shippingMapper.updateByShipping(shipping);
        if (rowCount > 0){
            return ServerResponse.createBySuccess("更新地址成功");
        }
        return ServerResponse.createByErrorMessage("更新地址失败");
    }

    /**
     * 查看收货地址详情（注意横向越权）
     * @param userId
     * @param shippingId
     * @return
     */
    public ServerResponse<Shipping> select(Integer userId, Integer shippingId){
        Shipping shipping = shippingMapper.selectByShippingIdAndUserId(shippingId, userId);
        if (shipping != null){
            return ServerResponse.createBySuccess("成功", shipping);
        }
        return ServerResponse.createByErrorMessage("无法查询到地址");
    }

    public ServerResponse<PageInfo> list(Integer userId, int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Shipping> shippingList = shippingMapper.selectByUserId(userId);
        PageInfo pageInfo = new PageInfo(shippingList);
        return ServerResponse.createBySuccess(pageInfo);
    }
}
