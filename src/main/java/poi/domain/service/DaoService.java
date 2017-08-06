package poi.domain.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poi.domain.dao.UserTDao;
import poi.domain.entity.UserT;
import poi.dto.general.SessionRegisterDto;

@Service
public class DaoService {

	
	@Autowired
	protected UserTDao userTDao;
	
	protected UserT userEntity = new UserT();
	
	public void registerUser(SessionRegisterDto sessionRegisterDto) {
		// ユーザーテーブルに情報を登録する
		userEntity.username = sessionRegisterDto.getUsername();
		userEntity.mail = sessionRegisterDto.getMail();
		userEntity.password = sessionRegisterDto.getPassword();
		userEntity.birthday = sessionRegisterDto.getBirthday();
		userEntity.createdAt = LocalDateTime.now();
		userEntity.updatedAt = LocalDateTime.now();
		userTDao.insert(userEntity);
	}
	public List<UserT> findAll() {
		List<UserT> user = userTDao.selectAll();
		return user;
	}
}
