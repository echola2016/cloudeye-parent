package com.cloudeye.sys.basic.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cloudeye.sys.basic.model.User;
import com.cloudeye.sys.basic.mapper.UserMapper;
import com.cloudeye.base.service.CloudEyeBaseService;
@Service
@Transactional
public class UserService extends CloudEyeBaseService<UserMapper,User> {



 }
