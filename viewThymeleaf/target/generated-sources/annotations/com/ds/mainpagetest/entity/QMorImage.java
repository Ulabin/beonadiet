package com.ds.mainpagetest.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMorImage is a Querydsl query type for MorImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMorImage extends EntityPathBase<MorImage> {

    private static final long serialVersionUID = 1048913140L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMorImage morImage = new QMorImage("morImage");

    public final StringPath imgName = createString("imgName");

    public final NumberPath<Long> inum = createNumber("inum", Long.class);

    public final QMyOwnRecipePost morPost;

    public final StringPath path = createString("path");

    public final StringPath uuid = createString("uuid");

    public QMorImage(String variable) {
        this(MorImage.class, forVariable(variable), INITS);
    }

    public QMorImage(Path<? extends MorImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMorImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMorImage(PathMetadata metadata, PathInits inits) {
        this(MorImage.class, metadata, inits);
    }

    public QMorImage(Class<? extends MorImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.morPost = inits.isInitialized("morPost") ? new QMyOwnRecipePost(forProperty("morPost")) : null;
    }

}

