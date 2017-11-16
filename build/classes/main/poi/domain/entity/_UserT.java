package poi.domain.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "2.16.0" }, date = "2017-11-17T08:00:57.264+0900")
public final class _UserT extends org.seasar.doma.jdbc.entity.AbstractEntityType<poi.domain.entity.UserT> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.16.0");
    }

    private static final _UserT __singleton = new _UserT();

    private final org.seasar.doma.jdbc.entity.NamingType __namingType = null;

    private final org.seasar.doma.jdbc.id.BuiltinIdentityIdGenerator __idGenerator = new org.seasar.doma.jdbc.id.BuiltinIdentityIdGenerator();

    /** the id */
    public final org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, poi.domain.entity.UserT, java.lang.Integer, Object> $id = new org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<>(poi.domain.entity.UserT.class, java.lang.Integer.class, java.lang.Integer.class, () -> new org.seasar.doma.wrapper.IntegerWrapper(), null, null, "id", "id", __namingType, false, __idGenerator);

    /** the username */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, poi.domain.entity.UserT, java.lang.String, Object> $username = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(poi.domain.entity.UserT.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "username", "username", __namingType, true, true, false);

    /** the mail */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, poi.domain.entity.UserT, java.lang.String, Object> $mail = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(poi.domain.entity.UserT.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "mail", "mail", __namingType, true, true, false);

    /** the password */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, poi.domain.entity.UserT, java.lang.String, Object> $password = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(poi.domain.entity.UserT.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "password", "password", __namingType, true, true, false);

    /** the passwordFailedCount */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, poi.domain.entity.UserT, java.lang.Integer, Object> $passwordFailedCount = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(poi.domain.entity.UserT.class, java.lang.Integer.class, java.lang.Integer.class, () -> new org.seasar.doma.wrapper.IntegerWrapper(), null, null, "passwordFailedCount", "password_failed_count", __namingType, true, true, false);

    /** the birthday */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, poi.domain.entity.UserT, java.lang.String, Object> $birthday = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(poi.domain.entity.UserT.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "birthday", "birthday", __namingType, true, true, false);

    /** the createdAt */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, poi.domain.entity.UserT, java.time.LocalDateTime, Object> $createdAt = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(poi.domain.entity.UserT.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, () -> new org.seasar.doma.wrapper.LocalDateTimeWrapper(), null, null, "createdAt", "created_at", __namingType, true, true, false);

    /** the updatedAt */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, poi.domain.entity.UserT, java.time.LocalDateTime, Object> $updatedAt = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(poi.domain.entity.UserT.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, () -> new org.seasar.doma.wrapper.LocalDateTimeWrapper(), null, null, "updatedAt", "updated_at", __namingType, true, true, false);

    /** the deletedAt */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, poi.domain.entity.UserT, java.time.LocalDateTime, Object> $deletedAt = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(poi.domain.entity.UserT.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, () -> new org.seasar.doma.wrapper.LocalDateTimeWrapper(), null, null, "deletedAt", "deleted_at", __namingType, true, true, false);

    private final java.util.function.Supplier<org.seasar.doma.jdbc.entity.NullEntityListener<poi.domain.entity.UserT>> __listenerSupplier;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final boolean __isQuoteRequired;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<poi.domain.entity.UserT, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<poi.domain.entity.UserT, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<poi.domain.entity.UserT, ?>> __entityPropertyTypeMap;

    private _UserT() {
        __listenerSupplier = () -> ListenerHolder.listener;
        __immutable = false;
        __name = "UserT";
        __catalogName = "";
        __schemaName = "";
        __tableName = "user_t";
        __isQuoteRequired = false;
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<poi.domain.entity.UserT, ?>> __idList = new java.util.ArrayList<>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<poi.domain.entity.UserT, ?>> __list = new java.util.ArrayList<>(9);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<poi.domain.entity.UserT, ?>> __map = new java.util.HashMap<>(9);
        __idList.add($id);
        __list.add($id);
        __map.put("id", $id);
        __list.add($username);
        __map.put("username", $username);
        __list.add($mail);
        __map.put("mail", $mail);
        __list.add($password);
        __map.put("password", $password);
        __list.add($passwordFailedCount);
        __map.put("passwordFailedCount", $passwordFailedCount);
        __list.add($birthday);
        __map.put("birthday", $birthday);
        __list.add($createdAt);
        __map.put("createdAt", $createdAt);
        __list.add($updatedAt);
        __map.put("updatedAt", $updatedAt);
        __list.add($deletedAt);
        __map.put("deletedAt", $deletedAt);
        __idPropertyTypes = java.util.Collections.unmodifiableList(__idList);
        __entityPropertyTypes = java.util.Collections.unmodifiableList(__list);
        __entityPropertyTypeMap = java.util.Collections.unmodifiableMap(__map);
    }

    @Override
    public org.seasar.doma.jdbc.entity.NamingType getNamingType() {
        return __namingType;
    }

    @Override
    public boolean isImmutable() {
        return __immutable;
    }

    @Override
    public String getName() {
        return __name;
    }

    @Override
    public String getCatalogName() {
        return __catalogName;
    }

    @Override
    public String getSchemaName() {
        return __schemaName;
    }

    @Override
    public String getTableName() {
        return getTableName(org.seasar.doma.jdbc.Naming.DEFAULT::apply);
    }

    @Override
    public String getTableName(java.util.function.BiFunction<org.seasar.doma.jdbc.entity.NamingType, String, String> namingFunction) {
        if (__tableName.isEmpty()) {
            return namingFunction.apply(__namingType, __name);
        }
        return __tableName;
    }

    @Override
    public boolean isQuoteRequired() {
        return __isQuoteRequired;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preInsert(poi.domain.entity.UserT entity, org.seasar.doma.jdbc.entity.PreInsertContext<poi.domain.entity.UserT> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preUpdate(poi.domain.entity.UserT entity, org.seasar.doma.jdbc.entity.PreUpdateContext<poi.domain.entity.UserT> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preDelete(poi.domain.entity.UserT entity, org.seasar.doma.jdbc.entity.PreDeleteContext<poi.domain.entity.UserT> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preDelete(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postInsert(poi.domain.entity.UserT entity, org.seasar.doma.jdbc.entity.PostInsertContext<poi.domain.entity.UserT> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postUpdate(poi.domain.entity.UserT entity, org.seasar.doma.jdbc.entity.PostUpdateContext<poi.domain.entity.UserT> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postDelete(poi.domain.entity.UserT entity, org.seasar.doma.jdbc.entity.PostDeleteContext<poi.domain.entity.UserT> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<poi.domain.entity.UserT, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<poi.domain.entity.UserT, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<poi.domain.entity.UserT, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, poi.domain.entity.UserT, ?, ?> getGeneratedIdPropertyType() {
        return $id;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, poi.domain.entity.UserT, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public poi.domain.entity.UserT newEntity(java.util.Map<String, org.seasar.doma.jdbc.entity.Property<poi.domain.entity.UserT, ?>> __args) {
        poi.domain.entity.UserT entity = new poi.domain.entity.UserT();
        if (__args.get("id") != null) __args.get("id").save(entity);
        if (__args.get("username") != null) __args.get("username").save(entity);
        if (__args.get("mail") != null) __args.get("mail").save(entity);
        if (__args.get("password") != null) __args.get("password").save(entity);
        if (__args.get("passwordFailedCount") != null) __args.get("passwordFailedCount").save(entity);
        if (__args.get("birthday") != null) __args.get("birthday").save(entity);
        if (__args.get("createdAt") != null) __args.get("createdAt").save(entity);
        if (__args.get("updatedAt") != null) __args.get("updatedAt").save(entity);
        if (__args.get("deletedAt") != null) __args.get("deletedAt").save(entity);
        return entity;
    }

    @Override
    public Class<poi.domain.entity.UserT> getEntityClass() {
        return poi.domain.entity.UserT.class;
    }

    @Override
    public poi.domain.entity.UserT getOriginalStates(poi.domain.entity.UserT __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(poi.domain.entity.UserT __entity) {
    }

    /**
     * @return the singleton
     */
    public static _UserT getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _UserT newInstance() {
        return new _UserT();
    }

    private static class ListenerHolder {
        private static org.seasar.doma.jdbc.entity.NullEntityListener<poi.domain.entity.UserT> listener = new org.seasar.doma.jdbc.entity.NullEntityListener<>();
    }

}
