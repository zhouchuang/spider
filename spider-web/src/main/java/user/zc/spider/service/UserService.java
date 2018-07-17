package user.zc.spider.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.zc.spider.dao.UserInfoMapper;
import user.zc.spider.model.UserInfo;

/**
 * 创建时间：2015-1-27 下午5:22:59
 * @author zhouchuang
 * @version 2.2
 */
@Service("userService")
public class UserService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	

	public List<UserInfo> getUsers() {
		return userInfoMapper.selectAll();
	}

	public int insert(UserInfo userInfo) {
		
		int result = userInfoMapper.insert(userInfo);
		
		System.out.println(result);
		return result;
	}

	public UserInfo getUserById(int id) {
		return userInfoMapper.selectByPrimaryKey(id);
	}
}
