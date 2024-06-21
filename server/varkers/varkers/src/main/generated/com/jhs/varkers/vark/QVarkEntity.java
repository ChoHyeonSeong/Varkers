package com.jhs.varkers.vark;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QVarkEntity is a Querydsl query type for VarkEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QVarkEntity extends EntityPathBase<VarkEntity> {

    private static final long serialVersionUID = -1253722817L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QVarkEntity varkEntity = new QVarkEntity("varkEntity");

    public final com.jhs.varkers.account.QAccountEntity account;

    public final StringPath content = createString("content");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public QVarkEntity(String variable) {
        this(VarkEntity.class, forVariable(variable), INITS);
    }

    public QVarkEntity(Path<? extends VarkEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QVarkEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QVarkEntity(PathMetadata metadata, PathInits inits) {
        this(VarkEntity.class, metadata, inits);
    }

    public QVarkEntity(Class<? extends VarkEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.account = inits.isInitialized("account") ? new com.jhs.varkers.account.QAccountEntity(forProperty("account"), inits.get("account")) : null;
    }

}

