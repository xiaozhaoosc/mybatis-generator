package com.honglu.headline.message.service.mapper.auto;

import com.honglu.headline.message.service.entity.auto.AcAlipayAccount;
import java.util.List;

public interface AcAlipayAccountMapper {
    int insert(AcAlipayAccount record);

    int insertSelective(AcAlipayAccount record);

    int updateByPrimaryKey(AcAlipayAccount record);

    int updateByPrimaryKeySelective(AcAlipayAccount record);

    int deleteByPrimaryKey(Long alipayAccountId);

    AcAlipayAccount selectOne(AcAlipayAccount record);

    List<AcAlipayAccount> selectList(AcAlipayAccount record);
}