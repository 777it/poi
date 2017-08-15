package poi.domain.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poi.domain.dao.UserTDao;
import poi.domain.entity.UserT;
import poi.dto.general.UserDto;
import poi.dto.member.SessionUserDto;


/**
 * ユーザー機能を管理するためのサービスクラス.
 */
@Service
public class UserService {

	@Autowired
	protected UserTDao userTDao;
	@Autowired
	protected SessionUserDto sessionUserDto;
	
	
	/**
	 * ユーザーエンティティ*/
	protected UserT userEntity = new UserT();
	
	/**
	 * ログイン認証を行う.
	 * 
	 * @param loginId
	 *            ログインID
	 * @param passwd
	 *            パスワード
	 * @return true:認証成功、false:認証失敗
	 */
	public boolean authentication(final String loginId, final String password) {

		UserT entity = userTDao.selectByLoginIdAndPasswordAndDeletedAt(loginId, password);
		if (entity == null) {
			return false;
		}
		return true;
	}
	
	/**
	 * ユーザーテーブルに情報を登録する
	 * @param userDto
	 */
	public void registerUser(UserDto userDto) {
		userEntity.username = userDto.username;
		userEntity.mail = userDto.mail;
		userEntity.password = userDto.password;
		userEntity.birthday = userDto.birthday;
		userEntity.createdAt = LocalDateTime.now();
		userEntity.updatedAt = LocalDateTime.now();
		userTDao.insert(userEntity);
	}
	
	/**
	 * ユーザーテーブルから全ての情報を取得する
	 * @return
	 */
	public List<UserT> findAll() {
		List<UserT> user = userTDao.selectAll();
		return user;
	}
	
	/**
	 * ユーザー名を元にユーザー情報を取得する
	 * @param username
	 * @return
	 */
	public UserT selectByUserInfo(String username) {
		userEntity = userTDao.selectByLoginId(username);
		return userEntity;
	}
	
	/**
	 * フォームに入力されたユーザーの情報を取得し、セッションにセットする
	 * @param loginId
	 */
	public void selectUserAndSetSession(String loginId) {
		userEntity = userTDao.selectByLoginId(loginId);
		sessionUserDto.setId(userEntity.id);
		sessionUserDto.setUsername(userEntity.username);
	}

	/**
	 * フォームに入力されたユーザー情報を編集する
	 * @param userDto
	 */
	public void editUser(UserDto userDto) {
		userEntity.username = userDto.username;
		userEntity.mail = userDto.mail;
		userEntity.password = userDto.password;
		userEntity.birthday = userDto.birthday;
		userEntity.updatedAt = LocalDateTime.now();
		userTDao.update(userEntity);	
	}
}