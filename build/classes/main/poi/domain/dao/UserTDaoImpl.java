package poi.domain.dao;

/** */
@org.springframework.stereotype.Component()
@javax.annotation.Generated(value = { "Doma", "2.16.0" }, date = "2017-08-06T15:47:09.048+0900")
public class UserTDaoImpl extends org.seasar.doma.internal.jdbc.dao.AbstractDao implements poi.domain.dao.UserTDao {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.16.0");
    }

    private static final java.lang.reflect.Method __method0 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(poi.domain.dao.UserTDao.class, "selectAll");

    private static final java.lang.reflect.Method __method1 = org.seasar.doma.internal.jdbc.dao.AbstractDao.getDeclaredMethod(poi.domain.dao.UserTDao.class, "insert", poi.domain.entity.UserT.class);

    /**
     * @param config the config
     */
    @org.springframework.beans.factory.annotation.Autowired()
    public UserTDaoImpl(org.seasar.doma.jdbc.Config config) {
        super(config);
    }

    @Override
    public java.util.List<poi.domain.entity.UserT> selectAll() {
        entering("poi.domain.dao.UserTDaoImpl", "selectAll");
        try {
            org.seasar.doma.jdbc.query.SqlFileSelectQuery __query = getQueryImplementors().createSqlFileSelectQuery(__method0);
            __query.setMethod(__method0);
            __query.setConfig(__config);
            __query.setSqlFilePath("META-INF/poi/domain/dao/UserTDao/selectAll.sql");
            __query.setEntityType(poi.domain.entity._UserT.getSingletonInternal());
            __query.setCallerClassName("poi.domain.dao.UserTDaoImpl");
            __query.setCallerMethodName("selectAll");
            __query.setResultEnsured(false);
            __query.setResultMappingEnsured(false);
            __query.setFetchType(org.seasar.doma.FetchType.LAZY);
            __query.setQueryTimeout(-1);
            __query.setMaxRows(-1);
            __query.setFetchSize(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.prepare();
            org.seasar.doma.jdbc.command.SelectCommand<java.util.List<poi.domain.entity.UserT>> __command = getCommandImplementors().createSelectCommand(__method0, __query, new org.seasar.doma.internal.jdbc.command.EntityResultListHandler<poi.domain.entity.UserT>(poi.domain.entity._UserT.getSingletonInternal()));
            java.util.List<poi.domain.entity.UserT> __result = __command.execute();
            __query.complete();
            exiting("poi.domain.dao.UserTDaoImpl", "selectAll", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("poi.domain.dao.UserTDaoImpl", "selectAll", __e);
            throw __e;
        }
    }

    @Override
    public int insert(poi.domain.entity.UserT entity) {
        entering("poi.domain.dao.UserTDaoImpl", "insert", entity);
        try {
            if (entity == null) {
                throw new org.seasar.doma.DomaNullPointerException("entity");
            }
            org.seasar.doma.jdbc.query.AutoInsertQuery<poi.domain.entity.UserT> __query = getQueryImplementors().createAutoInsertQuery(__method1, poi.domain.entity._UserT.getSingletonInternal());
            __query.setMethod(__method1);
            __query.setConfig(__config);
            __query.setEntity(entity);
            __query.setCallerClassName("poi.domain.dao.UserTDaoImpl");
            __query.setCallerMethodName("insert");
            __query.setQueryTimeout(-1);
            __query.setSqlLogType(org.seasar.doma.jdbc.SqlLogType.FORMATTED);
            __query.setNullExcluded(false);
            __query.setIncludedPropertyNames();
            __query.setExcludedPropertyNames("passwordFailedCount");
            __query.prepare();
            org.seasar.doma.jdbc.command.InsertCommand __command = getCommandImplementors().createInsertCommand(__method1, __query);
            int __result = __command.execute();
            __query.complete();
            exiting("poi.domain.dao.UserTDaoImpl", "insert", __result);
            return __result;
        } catch (java.lang.RuntimeException __e) {
            throwing("poi.domain.dao.UserTDaoImpl", "insert", __e);
            throw __e;
        }
    }

}