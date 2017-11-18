package poi.domain.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poi.domain.dao.CategoryTDao;
import poi.domain.entity.CategoryT;
import poi.dto.member.CategoryTDto;

@Service
public class CategoryService {
	
	@Autowired
	protected CategoryTDao categoryTDao;
	/**
	 * ユーザーエンティティ*/
	protected CategoryT categoryEntity = new CategoryT();

	/**
	 * ユーザー名とカテゴリに紐づくカテゴリを取得
	 * 新規追加のカテゴリかチェックするため
	 * @param username
	 * @return
	 */
	public String selectCategoryByselectedCategory(String username, String cateogry) {
		String newCategory = categoryTDao.selectCategoryByUsernameAndcategoryAndDeletedAt(username, cateogry);
		return newCategory;
	}
	
	/**
	 * カテゴリを新規登録する
	 * @param categoryTDto
	 */
	public void register(CategoryTDto categoryTDto) {
		categoryEntity.username = categoryTDto.username;
		categoryEntity.category = categoryTDto.category;
		categoryEntity.createdAt = LocalDateTime.now();
		categoryEntity.updatedAt = LocalDateTime.now();
		int result = categoryTDao.insert(categoryEntity);
		System.out.println("「category_t」に" + result + "件の記事を登録");
	}
	
	/**
	 * カテゴリを編集する
	 * @param categoryTDto
	 * @param categoryId
	 */
	public void updatecategory(CategoryTDto categoryTDto, String categoryId) {
		int categoryIdInt = Integer.parseInt(categoryId);
		categoryEntity.category = categoryTDto.category;
		int result = categoryTDao.update(categoryEntity, categoryIdInt);
		System.out.println("「category_t」の" + result + "件の記事を更新");	
	}
	
	/**
	 * カテゴリを削除する
	 * @param categoryId
	 */
	public void deletecategory(String categoryId) {
		int categoryIdInt = Integer.parseInt(categoryId);
		int result = categoryTDao.delete(categoryIdInt);
		System.out.println("「category_t」の" + result + "件の記事を削除");
	}
}
