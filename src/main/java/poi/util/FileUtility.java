package poi.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public final class FileUtility {

	private static final Logger logger = LoggerFactory.getLogger(FileUtility.class);

	private FileUtility() {
		// privateコンストラクタ
	}

	/**
	 * ファイル名から拡張子を返します。
	 * 
	 * @param fileName
	 *            ファイル名
	 * @return ファイルの拡張子(ピリオド付き)
	 */
	public static String getSuffix(final String fileName) {

		if (StringUtils.isEmpty(fileName)) {
			return fileName;
		}

		int point = fileName.lastIndexOf(".");
		if (point != -1) {
			String result = fileName.substring(point + 1);
			return result;
		}
		return fileName;
	}

	/**
	 * 指定したファイルの拡張子が画像かどうか確認します.
	 * @param fileName
	 * @return true:画像、false:画像以外
	 */
	public static boolean isImage(final String fileName) {
		String suffix = FileUtility.getSuffix(fileName);
		if("jpeg".equals(suffix)) {
			return true;
		}
		if("jpg".equals(suffix)) {
			return true;
		}
		if("png".equals(suffix)) {
			return true;		
		}
		if("gif".equals(suffix)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 指定したファイルの拡張子がPDFかどうか確認します.
	 * @param fileName
	 * @return true:PDF、false:PDF以外
	 */
	public static boolean isPDF(final String fileName) {
		String suffix = FileUtility.getSuffix(fileName);
		if("PDF".equals(suffix)) {
			return true;
		}
		return false;
	}

	/**
	 * ディレクトリを作成する.
	 * 
	 * @param path
	 *            パス
	 * @return true:成功、false:失敗
	 */
	public static final boolean mkDir(final String path) {
		Path dir = Paths.get(path);
		if(Files.exists(dir)) {
			logger.debug(dir + "は既に存在します。");
			return true;
		}
		try {
			Files.createDirectories(dir);
			logger.debug(dir + "を作成しました。");
			return true;
		} catch (IOException e) {
			logger.debug(dir + "の作成に失敗しました。", e);
			return false;
		}
	}

	/**
	 * ファイルを保存する.
	 * 
	 * @param filePath
	 *            ファイルパス
	 * @param file
	 *            ファイル
	 * @return true:成功、false:失敗
	 */
	public static final boolean save(final String filePath, MultipartFile file) {
		try {
			FileUtils.copyInputStreamToFile(file.getInputStream(), new File(filePath));
			logger.debug(filePath + "を作成しました。");
			return true;
		} catch (IOException e) {
			logger.debug(filePath + "の作成に失敗しました。", e);
			return false;
		}
	}
}
