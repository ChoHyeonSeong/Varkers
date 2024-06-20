package com.jhs.varkers.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserEntity is a Querydsl query type for UserEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserEntity extends EntityPathBase<UserEntity> {

    private static final long serialVersionUID = -90612321L;

    public static final QUserEntity userEntity = new QUserEntity("userEntity");

    public final ListPath<com.jhs.varkers.account.AccountEntity, com.jhs.varkers.account.QAccountEntity> accounts = this.<com.jhs.varkers.account.AccountEntity, com.jhs.varkers.account.QAccountEntity>createList("accounts", com.jhs.varkers.account.AccountEntity.class, com.jhs.varkers.account.QAccountEntity.class, PathInits.DIRECT2);

    public final DateTimePath<java.util.Date> birth = createDateTime("birth", java.util.Date.class);

    public final DateTimePath<java.util.Date> createdAt = createDateTime("createdAt", java.util.Date.class);

    public final NumberPath<Long> currentAccountId = createNumber("currentAccountId", Long.class);

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> maxAccountCount = createNumber("maxAccountCount", Integer.class);

    public final StringPath password = createString("password");

    public QUserEntity(String variable) {
        super(UserEntity.class, forVariable(variable));
    }

    public QUserEntity(Path<? extends UserEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserEntity(PathMetadata metadata) {
        super(UserEntity.class, metadata);
    }

}

