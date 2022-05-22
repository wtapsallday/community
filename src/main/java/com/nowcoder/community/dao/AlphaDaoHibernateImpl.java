package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;

@Repository("alphaHibernate") //括号里表示你觉得不想使用下面这个类名，可能因为名字太长了，难的输入，那么就取别名
public class AlphaDaoHibernateImpl implements  AlphaDao{
    @Override
    public String select() {
        return "Hibernate";
    }
}
