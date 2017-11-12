package poi.domain.dao;

/** */
@org.springframework.stereotype.Component()
@javax.annotation.Generated(value = { "Doma", "2.16.0" }, date = "2017-11-12T10:51:28.877+0900")
public class CategoryTDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements poi.domain.dao.CategoryTDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.16.0");
    }

    private static final java.lang.reflect.Method __method0 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(poi.domain.dao.CategoryTDao.class, "selectAll");

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(poi.domain.dao.CategoryTDao.class, "selectCategoryByUsernameAndDeletedAt", java.lang.String.class);

    private static final java.lang.reflect.Method __method2 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(poi.domain.dao.CategoryTDao.class, "insert", poi.domain.entity.CategoryT.class);

    private static final java.lang.reflect.Method __method3 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(poi.domain.dao.CategoryTDao.class, "update", poi.domain.entity.CategoryT.class, int.class);

    private static final java.lang.reflect.Method __method4 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(poi.domain.dao.CategoryTDao.class, "delete", int.class);

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
    public java.util.List<poi.domain.entity.CategoryT> selectCategoryByUsernameAndDeletedAt(java.lang.String username) {
        entering("poi.domain.dao.CategoryTDaoImpl", "selectCategoryByUsernameAndDeletedAt", username);
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method1);
            __query.setMethod(__method1);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/poi/domain/dao/CategoryTDao/selectCategoryByUsernameAndDeletedAt.sql");
            __query.setEntityType(poi.domain.entity._CategoryT.getSingletonInternal());
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
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<poi.domain.entity.CategoryT>> __command = getCommandImplementors().createSelectCommand(__method1, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<poi.domain.entity.CategoryT>(poi.domain.entity._CategoryT.getSingletonInternal()));
            java.util.List<poi.domain.entity.CategoryT> __result = __command.execute();
            __query.complete();
            exiting("poi.domain.dao.CategoryTDaoImpl", "selectCategoryByUsernameAndDeletedAt", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("poi.domain.dao.CategoryTDaoImpl", "selectCategoryByUsernameAndDeletedAt", __e);
            throw __e;
        }
    }

    @Override
    public int insert(poi.domain.entity.CategoryT entity) {
        entering("poi.domain.dao.CategoryTDaoImpl", "insert", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.AutoInsertQuery<poi.domain.entity.CategoryT> __query = getQueryImplementors().createAutoInsertQuery(__method2, poi.domain.entity._CategoryT.getSingletonInternal());
            __query.setMethod(__method2);
            __query.setConfig(__config);
            __query.setEntity(entity);
            __query.setCallerClassName("poi.domain.dao.CategoryTDaoImpl");
            __query.setCallerMethodName("insert");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setNullExcluded(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.prepare();
            org.seasar.doma.jdbc.command.InsertCommand __command = getCommandImplementors().createInsertCommand(__method2, __query);
            int __result = __command.execute();
            __query.complete();
            exiting("poi.domain.dao.CategoryTDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("poi.domain.dao.CategoryTDaoImpl", "insert", __e);
            throw __e;
        }
    }

    @Override
    public int update(poi.domain.entity.CategoryT entity, int id) {
        entering("poi.domain.dao.CategoryTDaoImpl", "update", entity, id);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.SqlFileUpdateQuery __query = getQueryImplementors().createSqlFileUpdateQuery(__method3);
            __query.setMethod(__method3);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/poi/domain/dao/CategoryTDao/update.sql");
            __query.addParameter("entity", poi.domain.entity.CategoryT.class, entity);
            __query.addParameter("id", int.class, id);
            __query.setCallerClassName("poi.domain.dao.CategoryTDaoImpl");
            __query.setCallerMethodName("update");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setEntityAndEntityType("entity", entity, poi.domain.entity._CategoryT.getSingletonInternal());
            __query.setNullExcluded(false);
            __query.setVersionIgnored(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames();
            __query.setUnchangedPropertyIncluded(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.jdbc.command.UpdateCommand __command = getCommandImplementors().createUpdateCommand(__method3, __query);
            int __result = __command.execute();
            __query.complete();
            exiting("poi.domain.dao.CategoryTDaoImpl", "update", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("poi.domain.dao.CategoryTDaoImpl", "update", __e);
            throw __e;
        }
    }

    @Override
    public int delete(int id) {
        entering("poi.domain.dao.CategoryTDaoImpl", "delete", id);
        try {
            org.seasar.doma.jdbc.query.SqlFileDeleteQuery __query = getQueryImplementors().createSqlFileDeleteQuery(__method4);
            __query.setMethod(__method4);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/poi/domain/dao/CategoryTDao/delete.sql");
            __query.addParameter("id", int.class, id);
            __query.setCallerClassName("poi.domain.dao.CategoryTDaoImpl");
            __query.setCallerMethodName("delete");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setVersionIgnored(false);
            __query.setOptimisticLockExceptionSuppressed(false);
            __query.prepare();
            org.seasar.doma.jdbc.command.DeleteCommand __command = getCommandImplementors().createDeleteCommand(__method4, __query);
            int __result = __command.execute();
            __query.complete();
            exiting("poi.domain.dao.CategoryTDaoImpl", "delete", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("poi.domain.dao.CategoryTDaoImpl", "delete", __e);
            throw __e;
        }
    }

}
