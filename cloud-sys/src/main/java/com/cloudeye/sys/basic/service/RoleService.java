package com.cloudeye.sys.basic.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cloudeye.sys.basic.model.Role;
import com.cloudeye.sys.basic.mapper.RoleMapper;
import com.cloudeye.base.service.CloudEyeBaseService;
@Service
@Transactional
public class RoleService extends CloudEyeBaseService<RoleMapper,Role> {



 }
