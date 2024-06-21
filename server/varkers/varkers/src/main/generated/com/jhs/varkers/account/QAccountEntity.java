package com.jhs.varkers.account;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAccountEntity is a Querydsl query type for AccountEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAccountEntity extends EntityPathBase<AccountEntity> {

    private static final long serialVersionUID = 1220530109L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAccountEntity accountEntity = new QAccountEntity("accountEntity");

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final DateTimePath<java.util.Date> deletedAt = createDateTime("deletedAt", java.util.Date.class);

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final StringPath profileImage = createString("profileImage");

    public final DateTimePath<java.util.Date> updatedAt = createDateTime("updatedAt", java.util.Date.class);

    public final com.jhs.varkers.user.QUserEntity user;

    public final ListPath<com.jhs.varkers.vark.VarkEntity, com.jhs.varkers.vark.QVarkEntity> varks = this.<com.jhs.varkers.vark.VarkEntity, com.jhs.varkers.vark.QVarkEntity>createList("varks", com.jhs.varkers.vark.VarkEntity.class, com.jhs.varkers.vark.QVarkEntity.class, PathInits.DIRECT2);

    public QAccountEntity(String variable) {
        this(AccountEntity.class, forVariable(variable), INITS);
    }

    public QAccountEntity(Path<? extends AccountEntity> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAccountEntity(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAccountEntity(PathMetadata metadata, PathInits inits) {
        this(AccountEntity.class, metadata, inits);
    }

    public QAccountEntity(Class<? extends AccountEntity> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new com.jhs.varkers.user.QUserEntity(forProperty("user")) : null;
    }

}

