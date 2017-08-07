package poi.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poi.domain.dao.UserTDao;
import poi.domain.entity.UserT;


/**
 * ユーザー機能を管理するためのサービスクラス.
 */
@Service
public class UserService {

	@Autowired
	protected UserTDao userTDao;

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

	public UserT setUp(final String loginId, final String password) {
		UserT entity = userTDao.selectByLoginIdAndPasswordAndDeletedAt(loginId, password);
		if (entity == null) {
			// TODO エラー
		}
		return entity;
	}
}