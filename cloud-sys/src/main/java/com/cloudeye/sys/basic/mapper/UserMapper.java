package com.cloudeye.sys.basic.mapper;
import org.apache.ibatis.annotations.Mapper;
import com.cloudeye.sys.basic.model.User;
import java.util.List;
import com.cloudeye.base.mapper.CloudEyeBaseMapper;
@Mapper
public interface UserMapper extends CloudEyeBaseMapper<User> {



 }
