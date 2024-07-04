package com.jhs.varkers.receiver;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QReceiverEntity is a Querydsl query type for ReceiverEntity
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReceiverEntity extends EntityPathBase<ReceiverEntity> {

    private static final long serialVersionUID = 565907103L;

    public static final QReceiverEntity receiverEntity = new QReceiverEntity("receiverEntity");

    public final NumberPath<Long> accountId = createNumber("accountId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> varkId = createNumber("varkId", Long.class);

    public QReceiverEntity(String variable) {
        super(ReceiverEntity.class, forVariable(variable));
    }

    public QReceiverEntity(Path<? extends ReceiverEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QReceiverEntity(PathMetadata metadata) {
        super(ReceiverEntity.class, metadata);
    }

}

