package poi.domain.entity;

/** */
@javax.annotation.Generated(value = { "Doma", "2.16.0" }, date = "2017-11-12T16:38:38.188+0900")
public final class _ArticleT extends org.seasar.doma.jdbc.entity.AbstractEntityType<poi.domain.entity.ArticleT> {

    static {
        org.seasar.doma.internal.Artifact.validateVersion("2.16.0");
    }

    private static final _ArticleT __singleton = new _ArticleT();

    private final org.seasar.doma.jdbc.entity.NamingType __namingType = null;

    private final org.seasar.doma.jdbc.id.BuiltinIdentityIdGenerator __idGenerator = new org.seasar.doma.jdbc.id.BuiltinIdentityIdGenerator();

    /** the id */
    public final org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, poi.domain.entity.ArticleT, java.lang.Integer, Object> $id = new org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<>(poi.domain.entity.ArticleT.class, java.lang.Integer.class, java.lang.Integer.class, () -> new org.seasar.doma.wrapper.IntegerWrapper(), null, null, "id", "id", __namingType, false, __idGenerator);

    /** the username */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, poi.domain.entity.ArticleT, java.lang.String, Object> $username = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(poi.domain.entity.ArticleT.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "username", "username", __namingType, true, true, false);

    /** the title */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, poi.domain.entity.ArticleT, java.lang.String, Object> $title = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(poi.domain.entity.ArticleT.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "title", "title", __namingType, true, true, false);

    /** the body */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, poi.domain.entity.ArticleT, java.lang.String, Object> $body = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(poi.domain.entity.ArticleT.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "body", "body", __namingType, true, true, false);

    /** the category */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, poi.domain.entity.ArticleT, java.lang.String, Object> $category = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(poi.domain.entity.ArticleT.class, java.lang.String.class, java.lang.String.class, () -> new org.seasar.doma.wrapper.StringWrapper(), null, null, "category", "category", __namingType, true, true, false);

    /** the level */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, poi.domain.entity.ArticleT, java.lang.Integer, Object> $level = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(poi.domain.entity.ArticleT.class, java.lang.Integer.class, java.lang.Integer.class, () -> new org.seasar.doma.wrapper.IntegerWrapper(), null, null, "level", "level", __namingType, true, true, false);

    /** the createdAt */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, poi.domain.entity.ArticleT, java.time.LocalDateTime, Object> $createdAt = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(poi.domain.entity.ArticleT.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, () -> new org.seasar.doma.wrapper.LocalDateTimeWrapper(), null, null, "createdAt", "created_at", __namingType, true, true, false);

    /** the updatedAt */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, poi.domain.entity.ArticleT, java.time.LocalDateTime, Object> $updatedAt = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(poi.domain.entity.ArticleT.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, () -> new org.seasar.doma.wrapper.LocalDateTimeWrapper(), null, null, "updatedAt", "updated_at", __namingType, true, true, false);

    /** the deletedAt */
    public final org.seasar.doma.jdbc.entity.DefaultPropertyType<java.lang.Object, poi.domain.entity.ArticleT, java.time.LocalDateTime, Object> $deletedAt = new org.seasar.doma.jdbc.entity.DefaultPropertyType<>(poi.domain.entity.ArticleT.class, java.time.LocalDateTime.class, java.time.LocalDateTime.class, () -> new org.seasar.doma.wrapper.LocalDateTimeWrapper(), null, null, "deletedAt", "deleted_at", __namingType, true, true, false);

    private final java.util.function.Supplier<org.seasar.doma.jdbc.entity.NullEntityListener<poi.domain.entity.ArticleT>> __listenerSupplier;

    private final boolean __immutable;

    private final String __catalogName;

    private final String __schemaName;

    private final String __tableName;

    private final boolean __isQuoteRequired;

    private final String __name;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<poi.domain.entity.ArticleT, ?>> __idPropertyTypes;

    private final java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<poi.domain.entity.ArticleT, ?>> __entityPropertyTypes;

    private final java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<poi.domain.entity.ArticleT, ?>> __entityPropertyTypeMap;

    private _ArticleT() {
        __listenerSupplier = () -> ListenerHolder.listener;
        __immutable = false;
        __name = "ArticleT";
        __catalogName = "";
        __schemaName = "";
        __tableName = "article_t";
        __isQuoteRequired = false;
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<poi.domain.entity.ArticleT, ?>> __idList = new java.util.ArrayList<>();
        java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<poi.domain.entity.ArticleT, ?>> __list = new java.util.ArrayList<>(9);
        java.util.Map<String, org.seasar.doma.jdbc.entity.EntityPropertyType<poi.domain.entity.ArticleT, ?>> __map = new java.util.HashMap<>(9);
        __idList.add($id);
        __list.add($id);
        __map.put("id", $id);
        __list.add($username);
        __map.put("username", $username);
        __list.add($title);
        __map.put("title", $title);
        __list.add($body);
        __map.put("body", $body);
        __list.add($category);
        __map.put("category", $category);
        __list.add($level);
        __map.put("level", $level);
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
    public void preInsert(poi.domain.entity.ArticleT entity, org.seasar.doma.jdbc.entity.PreInsertContext<poi.domain.entity.ArticleT> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preUpdate(poi.domain.entity.ArticleT entity, org.seasar.doma.jdbc.entity.PreUpdateContext<poi.domain.entity.ArticleT> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void preDelete(poi.domain.entity.ArticleT entity, org.seasar.doma.jdbc.entity.PreDeleteContext<poi.domain.entity.ArticleT> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.preDelete(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postInsert(poi.domain.entity.ArticleT entity, org.seasar.doma.jdbc.entity.PostInsertContext<poi.domain.entity.ArticleT> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postInsert(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postUpdate(poi.domain.entity.ArticleT entity, org.seasar.doma.jdbc.entity.PostUpdateContext<poi.domain.entity.ArticleT> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postUpdate(entity, context);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public void postDelete(poi.domain.entity.ArticleT entity, org.seasar.doma.jdbc.entity.PostDeleteContext<poi.domain.entity.ArticleT> context) {
        Class __listenerClass = org.seasar.doma.jdbc.entity.NullEntityListener.class;
        org.seasar.doma.jdbc.entity.NullEntityListener __listener = context.getConfig().getEntityListenerProvider().get(__listenerClass, __listenerSupplier);
        __listener.postDelete(entity, context);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<poi.domain.entity.ArticleT, ?>> getEntityPropertyTypes() {
        return __entityPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.EntityPropertyType<poi.domain.entity.ArticleT, ?> getEntityPropertyType(String __name) {
        return __entityPropertyTypeMap.get(__name);
    }

    @Override
    public java.util.List<org.seasar.doma.jdbc.entity.EntityPropertyType<poi.domain.entity.ArticleT, ?>> getIdPropertyTypes() {
        return __idPropertyTypes;
    }

    @Override
    public org.seasar.doma.jdbc.entity.GeneratedIdPropertyType<java.lang.Object, poi.domain.entity.ArticleT, ?, ?> getGeneratedIdPropertyType() {
        return $id;
    }

    @Override
    public org.seasar.doma.jdbc.entity.VersionPropertyType<java.lang.Object, poi.domain.entity.ArticleT, ?, ?> getVersionPropertyType() {
        return null;
    }

    @Override
    public poi.domain.entity.ArticleT newEntity(java.util.Map<String, org.seasar.doma.jdbc.entity.Property<poi.domain.entity.ArticleT, ?>> __args) {
        poi.domain.entity.ArticleT entity = new poi.domain.entity.ArticleT();
        if (__args.get("id") != null) __args.get("id").save(entity);
        if (__args.get("username") != null) __args.get("username").save(entity);
        if (__args.get("title") != null) __args.get("title").save(entity);
        if (__args.get("body") != null) __args.get("body").save(entity);
        if (__args.get("category") != null) __args.get("category").save(entity);
        if (__args.get("level") != null) __args.get("level").save(entity);
        if (__args.get("createdAt") != null) __args.get("createdAt").save(entity);
        if (__args.get("updatedAt") != null) __args.get("updatedAt").save(entity);
        if (__args.get("deletedAt") != null) __args.get("deletedAt").save(entity);
        return entity;
    }

    @Override
    public Class<poi.domain.entity.ArticleT> getEntityClass() {
        return poi.domain.entity.ArticleT.class;
    }

    @Override
    public poi.domain.entity.ArticleT getOriginalStates(poi.domain.entity.ArticleT __entity) {
        return null;
    }

    @Override
    public void saveCurrentStates(poi.domain.entity.ArticleT __entity) {
    }

    /**
     * @return the singleton
     */
    public static _ArticleT getSingletonInternal() {
        return __singleton;
    }

    /**
     * @return the new instance
     */
    public static _ArticleT newInstance() {
        return new _ArticleT();
    }

    private static class ListenerHolder {
        private static org.seasar.doma.jdbc.entity.NullEntityListener<poi.domain.entity.ArticleT> listener = new org.seasar.doma.jdbc.entity.NullEntityListener<>();
    }

}
