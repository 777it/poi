package poi.domain.dao;

/** */
@org.springframework.stereotype.Component()
@javax.annotation.Generated(value = { "Doma", "2.16.0" }, date = "2017-08-14T08:48:42.843+0900")
public class CategoryTDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements poi.domain.dao.CategoryTDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.16.0");
    }

    private static final java.lang.reflect.Method __method0 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(poi.domain.dao.CategoryTDao.class, "selectAll");

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(poi.domain.dao.CategoryTDao.class, "selectCategoryByUsernameAndDeletedAt", java.lang.String.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public CategoryTDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<poi.domain.entity.CategoryT> selectAll() {
        entering("poi.domain.dao.CategoryTDaoImpl", "selectAll");
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method0);
            __query.setMethod(__method0);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/poi/domain/dao/CategoryTDao/selectAll.sql");
            __query.setEntityType(poi.domain.entity._CategoryT.getSingletonInternal());
            __query.setCallerClassName("poi.domain.dao.CategoryTDaoImpl");
            __query.setCallerMethodName("selectAll");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<poi.domain.entity.CategoryT>> __command = getCommandImplementors().createSelectCommand(__method0, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<poi.domain.entity.CategoryT>(poi.domain.entity._CategoryT.getSingletonInternal()));
            java.util.List<poi.domain.entity.CategoryT> __result = __command.execute();
            __query.complete();
            exiting("poi.domain.dao.CategoryTDaoImpl", "selectAll", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("poi.domain.dao.CategoryTDaoImpl", "selectAll", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<java.lang.String> selectCategoryByUsernameAndDeletedAt(java.lang.String username) {
        entering("poi.domain.dao.CategoryTDaoImpl", "selectCategoryByUsernameAndDeletedAt", username);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method1);
            __query.setMethod(__method1);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/poi/domain/dao/CategoryTDao/selectCategoryByUsernameAndDeletedAt.sql");
            __query.addParameter("username", java.lang.String.class, username);
            __query.setCallerClassName("poi.domain.dao.CategoryTDaoImpl");
            __query.setCallerMethodName("selectCategoryByUsernameAndDeletedAt");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<java.lang.String>> __command = getCommandImplementors().createSelectCommand(__method1, __query, new org.seasar.doma.internal.jdbc.command.BasicResultListHandler<java.lang.String>(org.seasar.doma.wrapper.StringWrapper::new));
            java.util.List<java.lang.String> __result = __command.execute();
            __query.complete();
            exiting("poi.domain.dao.CategoryTDaoImpl", "selectCategoryByUsernameAndDeletedAt", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("poi.domain.dao.CategoryTDaoImpl", "selectCategoryByUsernameAndDeletedAt", __e);
            throw __e;
        }
    }

}
