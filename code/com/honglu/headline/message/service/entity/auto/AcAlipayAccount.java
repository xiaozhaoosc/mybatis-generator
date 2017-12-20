package com.honglu.headline.message.service.entity.auto;

import java.util.Date;

public class AcAlipayAccount {
    /**
     * 支付宝账户编号 ac_alipay_account.alipay_account_id
     */
    private Long alipayAccountId;

    /**
     * 客户编号 ac_alipay_account.customer_info_id
     */
    private Long customerInfoId;

    /**
     * 姓名 ac_alipay_account.name
     */
    private String name;

    /**
     * 账号 ac_alipay_account.account
     */
    private String account;

    /**
     * 创建时间 ac_alipay_account.create_time
     */
    private Date createTime;

    /**
     * 修改时间 ac_alipay_account.modify_time
     */
    private Date modifyTime;

    public AcAlipayAccount(Long alipayAccountId, Long customerInfoId, String name, String account, Date createTime, Date modifyTime) {
        this.alipayAccountId = alipayAccountId;
        this.customerInfoId = customerInfoId;
        this.name = name;
        this.account = account;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
        
    }

    public AcAlipayAccount() {
        super();
        
    }

    public Long getAlipayAccountId() {
        return alipayAccountId;
    }

    public AcAlipayAccount setAlipayAccountId(Long alipayAccountId) {
        this.alipayAccountId = alipayAccountId;
        return this;
    }

    public Long getCustomerInfoId() {
        return customerInfoId;
    }

    public AcAlipayAccount setCustomerInfoId(Long customerInfoId) {
        this.customerInfoId = customerInfoId;
        return this;
    }

    public String getName() {
        return name;
    }

    public AcAlipayAccount setName(String name) {
        this.name = name == null ? null : name.trim();
        return this;
    }

    public String getAccount() {
        return account;
    }

    public AcAlipayAccount setAccount(String account) {
        this.account = account == null ? null : account.trim();
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public AcAlipayAccount setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public AcAlipayAccount setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }
}