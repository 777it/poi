package poi.constant;

public final class UrlConstant {

	public static final String SLASH = "/";
	public static final String DIRECTORY_ALL = "/**";
	public static final String CSS = "/css";
	public static final String IMAGES = "/images";
	public static final String JS = "/js";
	public static final String FONTS = "/fonts";
	public static final String DESIGN = "/design";

	private static final String REDIRECT = "redirect:";
	private static final String FORWARD = "forward:";

	private UrlConstant() {
		// privateコンストラクタ
	}

	/** 画面. */
	public static class Page {

		private static final String MEMBER = "member";

		private static final String GENERAL = "general";

		/** 会員. */
		public static class Member {

			/** ログイン画面. */
			public static final String LOGIN = MEMBER + "/login";
			/** トップ画面(検索). */
			public static final String TOP = MEMBER + "/top";
			/** 記事画面. */
			public static final String SELECT = MEMBER + "/select";
			/** 記事作成画面. */
			public static final String CREATE = MEMBER + "/create";
			/** 記事編集画面. */
			public static final String UPDATE = MEMBER + "/update";
			/** 記事削除画面. */
			public static final String DELETE = MEMBER + "/delete";
			/** 操作完了画面. */
			public static final String COMPLETE = MEMBER + "/complete";
			/** 設定画面. */
			public static final String SETTING = MEMBER + "/setting";
			/** 設定画面. */
			public static final String SETTING_CATEGORY = MEMBER + "/setting-category";
			/** ヘルプ画面. */
			public static final String HELP = MEMBER + "/help";
		}

		/** 一般. */
		public static class General {

			/** 初期表示. */
			public static final String INDEX = GENERAL + "/index";
			/** 新規登録画面. */
			public static final String REGISTER = GENERAL + "/register";
			/** 新規登録画面（確認.） */
			public static final String CONFIRM = GENERAL + "/confirm";
		}

		/** 共通エラー. */
		public static class Error {

			/** ルート. */
			private static final String ROOT = "/error";

			/** システムエラー. */
			public static final String SYSTEM_ERROR = ROOT;

			/** 404. */
			public static final String NOT_FOUND = ROOT + "/404";

			/** セッションタイムアウト. */
			public static final String SESSION_TIMEOUT = ROOT + "/session-timeout";

		}

	}

	/** コントローラー. */
	public static class Controller {

		public static final String MEMBER = "/member";

		public static final String GENERAL = "/general";

		/** 会員. */
		public static class Member {

			/** ルート */
			public static final String ROOT = MEMBER + "/";

			/** 初期表示. */
			public static final String INDEX = MEMBER + "/index";
			/** ログイン画面. */
			public static final String LOGIN = MEMBER + "/login";
			/** トップ画面(検索). */
			public static final String TOP = MEMBER + "/top";
			/** 記事画面. */
			public static final String SELECT = MEMBER + "/select";
			/** 記事検索画面(カテゴリ・レベル検索). */
			public static final String SEARCH = MEMBER + "/search";
			/** 記事検索画面(カテゴリ・レベル検索)（リダイレクト). */
			public static final String REDIRECT_SEARCH = REDIRECT + SEARCH;
			/** 記事作成画面. */
			public static final String CREATE = MEMBER + "/create";
			/** 記事作成画面(リダイレクト). */
			public static final String REDIRECT_CREATE = REDIRECT + CREATE;
			/** 記事編集画面. */
			public static final String UPDATE = MEMBER + "/update";
			/** 記事編集画面(URLにパラメータ). */
			public static final String UPDATE_ID = MEMBER + "/update/{articleId}";
			/** 記事削除画面. */
			public static final String DELETE = MEMBER + "/delete/{articleId}";
			/** 操作完了画面. */
			public static final String COMPLETE = MEMBER + "/complete";
			/** 設定画面(アカウント). */
			public static final String SETTING = MEMBER + "/setting";
			/** 設定画面(カテゴリ). */
			public static final String SETTING_CATEGORY = MEMBER + "/setting-category";
			/** ヘルプ画面. */
			public static final String HELP = MEMBER + "/help";
			/** ログアウト画面. */
			public static final String LOGOUT = MEMBER + "/logout";
			/** ログイン画面（リダイレクト）. */
			public static final String REDIRECT_TOP = REDIRECT + TOP;
			/** ログイン画面（フォワード）. */
			public static final String FORWARD_LOGIN = FORWARD + LOGIN;
			
			/** カテゴリ作成. */
			public static final String ADD_CATEGORY = MEMBER + "/add-category/{category}";
			/** カテゴリ削除. */
			public static final String DELETE_CATEGORY = MEMBER + "/delete-category/{categoryId}";
			
		}

		/** 一般. */
		public static class General {

			/** ルート */
			public static final String ROOT = GENERAL + "/";
			/** 初期表示（リダイレクト）. */
			public static final String REDIRECT_ROOT = REDIRECT + ROOT;
			/** 初期表示. */
			public static final String INDEX = GENERAL + "/index";
			/** 新規登録画面. */
			public static final String REGISTER = GENERAL + "/register";
			/** 新規登録画面（確認）. */
			public static final String CONFIRM = GENERAL + "/confirm";
			/** 新規登録. */
			public static final String CREATE_ACCOUNT = GENERAL + "/create";
			/** ログイン画面（リダイレクト）. */
			public static final String REDIRECT_LOGOUT = REDIRECT + ROOT;
			/** セッションリセット. */
			public static final String RESET = GENERAL + "/reset";
		}

		/** 共通エラー. */
		public static class Error {

			/** システムエラー. */
			public static final String SYSTEM_ERROR = "/error";

			/** 404. */
			public static final String NOT_FOUND = "/404";

			/** 500. */
			public static final String INTERNAL_SERVER_ERROR = "/500";

			/** セッションタイムアウト. */
			public static final String SESSION_TIMEOUT = "/session-timeout";

		}
	}
}
