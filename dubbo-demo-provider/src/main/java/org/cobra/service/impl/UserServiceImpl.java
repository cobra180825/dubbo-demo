package org.cobra.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.cobra.entity.User;
import org.cobra.mapper.UserMapper;
import org.cobra.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Value("${spring.application.name}")
    private String applicationName;

    @Autowired
    private UserMapper userMapper;

    @Override
    @Cacheable(value = "DubboUserCache", key = "'user.findAll'")
    public List<User> findAll() {
        return userMapper.findAll();
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    @CacheEvict(value = "DubboUserCache", key = "'user.findAll'")
    public void deleteById(int id) {
        userMapper.deleteById(id);
    }

    @Override
    public String saySomething(String msg) {
        return "hi," + applicationName + ",i am from " + msg;
    }
}
