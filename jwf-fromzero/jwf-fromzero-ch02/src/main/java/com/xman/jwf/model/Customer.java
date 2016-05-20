package com.xman.jwf.model;

public class Customer {
    /**
     * 主键
     */
    private long id;
    /**
     * 客户名称
     */
    private String name;
    /**
     * 联系人
     */
    private String contact;
    /**
     * 邮件地址
     */
    private String mail;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 备注
     */
    private String remark;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
