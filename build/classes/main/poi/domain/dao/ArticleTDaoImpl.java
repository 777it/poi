package poi.domain.dao;

/** */
@org.springframework.stereotype.Component()
@javax.annotation.Generated(value = { "Doma", "2.16.0" }, date = "2017-11-16T00:27:37.287+0900")
public class ArticleTDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements poi.domain.dao.ArticleTDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.16.0");
    }

    private static final java.lang.reflect.Method __method0 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(poi.domain.dao.ArticleTDao.class, "selectAll");

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(poi.domain.dao.ArticleTDao.class, "selectArticleCountByUsernameAndDeletedAt", java.lang.String.class);

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(poi.domain.dao.ArticleTDao.class, "selectArticleByUsernameAndDeletedAt", java.lang.String.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(poi.domain.dao.ArticleTDao.class, "selectArticleByUsernameAndCategoryAndDeletedAt", java.lang.String.class, java.lang.String.class);

    private static final java.lang.reflect.Method __method4 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(poi.domain.dao.ArticleTDao.class, "selectArticleByUsernameAndLevelAndDeletedAt", java.lang.String.class, int.class);

    private static final java.lang.reflect.Method __method5 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(poi.domain.dao.ArticleTDao.class, "selectArticleByUsernameAndCategoryAndLevelAndDeletedAt", java.lang.String.class, java.lang.String.class, int.class);

    private static final java.lang.reflect.Method __method6 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(poi.domain.dao.ArticleTDao.class, "selectArticleByArticleId", int.class);

    private static final java.lang.reflect.Method __method7 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(poi.domain.dao.ArticleTDao.class, "insert", poi.domain.entity.ArticleT.class);

    private static final java.lang.reflect.Method __method8 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(poi.domain.dao.ArticleTDao.class, "update", poi.domain.entity.ArticleT.class, int.class);

    private static final java.lang.reflect.Method __method9 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(poi.domain.dao.ArticleTDao.class, "delete", int.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public ArticleTDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<poi.domain.entity.ArticleT> selectAll() {
        entering("poi.domain.dao.ArticleTDaoImpl", "selectAll");
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method0);
            __query.setMethod(__method0);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/poi/domain/dao/ArticleTDao/selectAll.sql");
            __query.setEntityType(poi.domain.entity._ArticleT.getSingletonInternal());
            __query.setCallerClassName("poi.domain.dao.ArticleTDaoImpl");
            __query.setCallerMethodName("selectAll");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<poi.domain.entity.ArticleT>> __command = getCommandImplementors().createSelectCommand(__method0, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<poi.domain.entity.ArticleT>(poi.domain.entity._ArticleT.getSingletonInternal()));
            java.util.List<poi.domain.entity.ArticleT> __result = __command.execute();
            __query.complete();
            exiting("poi.domain.dao.ArticleTDaoImpl", "selectAll", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("poi.domain.dao.ArticleTDaoImpl", "selectAll", __e);
            throw __e;
        }
    }

    @Override
    public int selectArticleCountByUsernameAndDeletedAt(java.lang.String username) {
        entering("poi.domain.dao.ArticleTDaoImpl", "selectArticleCountByUsernameAndDeletedAt", username);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method1);
            __query.setMethod(__method1);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/poi/domain/dao/ArticleTDao/selectArticleCountByUsernameAndDeletedAt.sql");
            __query.addParameter("username", java.lang.String.class, username);
            __query.setCallerClassName("poi.domain.dao.ArticleTDaoImpl");
            __query.setCallerMethodName("selectArticleCountByUsernameAndDeletedAt");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.lang.Integer> __command = getCommandImplementors().createSelectCommand(__method1, __query, new org.seasar.doma.internal.jdbc.command.BasicSingleResultHandler<java.lang.Integer>(org.seasar.doma.wrapper.IntegerWrapper::new, true));
            int __result = __command.execute();
            __query.complete();
            exiting("poi.domain.dao.ArticleTDaoImpl", "selectArticleCountByUsernameAndDeletedAt", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("poi.domain.dao.ArticleTDaoImpl", "selectArticleCountByUsernameAndDeletedAt", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<poi.domain.entity.ArticleT> selectArticleByUsernameAndDeletedAt(java.lang.String username) {
        entering("poi.domain.dao.ArticleTDaoImpl", "selectArticleByUsernameAndDeletedAt", username);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method2);
            __query.setMethod(__method2);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/poi/domain/dao/ArticleTDao/selectArticleByUsernameAndDeletedAt.sql");
            __query.setEntityType(poi.domain.entity._ArticleT.getSingletonInternal());
            __query.addParameter("username", java.lang.String.class, username);
            __query.setCallerClassName("poi.domain.dao.ArticleTDaoImpl");
            __query.setCallerMethodName("selectArticleByUsernameAndDeletedAt");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<poi.domain.entity.ArticleT>> __command = getCommandImplementors().createSelectCommand(__method2, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<poi.domain.entity.ArticleT>(poi.domain.entity._ArticleT.getSingletonInternal()));
            java.util.List<poi.domain.entity.ArticleT> __result = __command.execute();
            __query.complete();
            exiting("poi.domain.dao.ArticleTDaoImpl", "selectArticleByUsernameAndDeletedAt", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("poi.domain.dao.ArticleTDaoImpl", "selectArticleByUsernameAndDeletedAt", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<poi.domain.entity.ArticleT> selectArticleByUsernameAndCategoryAndDeletedAt(java.lang.String username, java.lang.String category) {
        entering("poi.domain.dao.ArticleTDaoImpl", "selectArticleByUsernameAndCategoryAndDeletedAt", username, category);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method3);
            __query.setMethod(__method3);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/poi/domain/dao/ArticleTDao/selectArticleByUsernameAndCategoryAndDeletedAt.sql");
            __query.setEntityType(poi.domain.entity._ArticleT.getSingletonInternal());
            __query.addParameter("username", java.lang.String.class, username);
            __query.addParameter("category", java.lang.String.class, category);
            __query.setCallerClassName("poi.domain.dao.ArticleTDaoImpl");
            __query.setCallerMethodName("selectArticleByUsernameAndCategoryAndDeletedAt");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<poi.domain.entity.ArticleT>> __command = getCommandImplementors().createSelectCommand(__method3, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<poi.domain.entity.ArticleT>(poi.domain.entity._ArticleT.getSingletonInternal()));
            java.util.List<poi.domain.entity.ArticleT> __result = __command.execute();
            __query.complete();
            exiting("poi.domain.dao.ArticleTDaoImpl", "selectArticleByUsernameAndCategoryAndDeletedAt", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("poi.domain.dao.ArticleTDaoImpl", "selectArticleByUsernameAndCategoryAndDeletedAt", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<poi.domain.entity.ArticleT> selectArticleByUsernameAndLevelAndDeletedAt(java.lang.String username, int level) {
        entering("poi.domain.dao.ArticleTDaoImpl", "selectArticleByUsernameAndLevelAndDeletedAt", username, level);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method4);
            __query.setMethod(__method4);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/poi/domain/dao/ArticleTDao/selectArticleByUsernameAndLevelAndDeletedAt.sql");
            __query.setEntityType(poi.domain.entity._ArticleT.getSingletonInternal());
            __query.addParameter("username", java.lang.String.class, username);
            __query.addParameter("level", int.class, level);
            __query.setCallerClassName("poi.domain.dao.ArticleTDaoImpl");
            __query.setCallerMethodName("selectArticleByUsernameAndLevelAndDeletedAt");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<poi.domain.entity.ArticleT>> __command = getCommandImplementors().createSelectCommand(__method4, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<poi.domain.entity.ArticleT>(poi.domain.entity._ArticleT.getSingletonInternal()));
            java.util.List<poi.domain.entity.ArticleT> __result = __command.execute();
            __query.complete();
            exiting("poi.domain.dao.ArticleTDaoImpl", "selectArticleByUsernameAndLevelAndDeletedAt", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("poi.domain.dao.ArticleTDaoImpl", "selectArticleByUsernameAndLevelAndDeletedAt", __e);
            throw __e;
        }
    }

    @Override
    public java.util.List<poi.domain.entity.ArticleT> selectArticleByUsernameAndCategoryAndLevelAndDeletedAt(java.lang.String username, java.lang.String category, int level) {
        entering("poi.domain.dao.ArticleTDaoImpl", "selectArticleByUsernameAndCategoryAndLevelAndDeletedAt", username, category, level);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method5);
            __query.setMethod(__method5);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/poi/domain/dao/ArticleTDao/selectArticleByUsernameAndCategoryAndLevelAndDeletedAt.sql");
            __query.setEntityType(poi.domain.entity._ArticleT.getSingletonInternal());
            __query.addParameter("username", java.lang.String.class, username);
            __query.addParameter("category", java.lang.String.class, category);
            __query.addParameter("level", int.class, level);
            __query.setCallerClassName("poi.domain.dao.ArticleTDaoImpl");
            __query.setCallerMethodName("selectArticleByUsernameAndCategoryAndLevelAndDeletedAt");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<poi.domain.entity.ArticleT>> __command = getCommandImplementors().createSelectCommand(__method5, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<poi.domain.entity.ArticleT>(poi.domain.entity._ArticleT.getSingletonInternal()));
            java.util.List<poi.domain.entity.ArticleT> __result = __command.execute();
            __query.complete();
            exiting("poi.domain.dao.ArticleTDaoImpl", "selectArticleByUsernameAndCategoryAndLevelAndDeletedAt", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("poi.domain.dao.ArticleTDaoImpl", "selectArticleByUsernameAndCategoryAndLevelAndDeletedAt", __e);
            throw __e;
        }
    }

    @Override
    public poi.domain.entity.ArticleT selectArticleByArticleId(int id) {
        entering("poi.domain.dao.ArticleTDaoImpl", "selectArticleByArticleId", id);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method6);
            __query.setMethod(__method6);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/poi/domain/dao/ArticleTDao/selectArticleByArticleId.sql");
            __query.setEntityType(poi.domain.entity._ArticleT.getSingletonInternal());
            __query.addParameter("id", int.class, id);
            __query.setCallerClassName("poi.domain.dao.ArticleTDaoImpl");
            __query.setCallerMethodName("selectArticleByArticleId");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<poi.domain.entity.ArticleT> __command = getCommandImplementors().createSelectCommand(__method6, __query, new org.seasar.doma.internal.jdbc.command.EntitySingleResultHandler<poi.domain.entity.ArticleT>(poi.domain.entity._ArticleT.getSingletonInternal()));
            poi.domain.entity.ArticleT __result = __command.execute();
            __query.complete();
            exiting("poi.domain.dao.ArticleTDaoImpl", "selectArticleByArticleId", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("poi.domain.dao.ArticleTDaoImpl", "selectArticleByArticleId", __e);
            throw __e;
        }
    }

    @Override
    public int insert(poi.domain.entity.ArticleT entity) {
        entering("poi.domain.dao.ArticleTDaoImpl", "insert", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.AutoInsertQuery<poi.domain.entity.ArticleT> __query = getQueryImplementors().createAutoInsertQuery(__method7, poi.domain.entity._ArticleT.getSingletonInternal());
            __query.setMethod(__method7);
            __query.setConfig(__config);
            __query.setEntity(entity);
            __query.setCallerClassName("poi.domain.dao.ArticleTDaoImpl");
            __query.setCallerMethodName("insert");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setNullExcluded(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.jdbc.command.InsertCommand __command = getCommandImplementors().createInsertCommand(__method7, __query);
            int __result = __command.execute();
            __query.complete();
            exiting("poi.domain.dao.ArticleTDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("poi.domain.dao.ArticleTDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public int update(poi.domain.entity.ArticleT entity, int id) {
        entering("poi.domain.dao.ArticleTDaoImpl", "update", entity, id);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.SqlFileUpdateQuery __query = getQueryImplementors().createSqlFileUpdateQuery(__method8);
            __query.setMethod(__method8);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/poi/domain/dao/ArticleTDao/update.sql");
            __query.addParameter("entity", poi.domain.entity.ArticleT.class, entity);
            __query.addParameter("id", int.class, id);
            __query.setCallerClassName("poi.domain.dao.ArticleTDaoImpl");
            __query.setCallerMethodName("update");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setEntityAndEntityType("entity", entity, poi.domain.entity._ArticleT.getSingletonInternal());
            __query.setNullExcluded(false);
            __query.setVersionIgnored(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.setUnchangedPropertyIncluded(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.jdbc.command.UpdateCommand __command = getCommandImplementors().createUpdateCommand(__method8, __query);
            int __result = __command.execute();
            __query.complete();
            exiting("poi.domain.dao.ArticleTDaoImpl", "update", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("poi.domain.dao.ArticleTDaoImpl", "update", __e);
            throw __e;
        }
    }

    @Override
    public int delete(int id) {
        entering("poi.domain.dao.ArticleTDaoImpl", "delete", id);
        try {
            org.seasar.doma.jdbc.query.SqlFileDeleteQuery __query = getQueryImplementors().createSqlFileDeleteQuery(__method9);
            __query.setMethod(__method9);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/poi/domain/dao/ArticleTDao/delete.sql");
            __query.addParameter("id", int.class, id);
            __query.setCallerClassName("poi.domain.dao.ArticleTDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.jdbc.command.DeleteCommand __command = getCommandImplementors().createDeleteCommand(__method9, __query);
            int __result = __command.execute();
            __query.complete();
            exiting("poi.domain.dao.ArticleTDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("poi.domain.dao.ArticleTDaoImpl", "delete", __e);
            throw __e;
        }
    }

}
