package com.ds.mainpagetest.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMyOwnRecipe is a Querydsl query type for MyOwnRecipe
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMyOwnRecipe extends EntityPathBase<MyOwnRecipe> {

    private static final long serialVersionUID = -1823301889L;

    public static final QMyOwnRecipe myOwnRecipe = new QMyOwnRecipe("myOwnRecipe");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Integer> category = createNumber("category", Integer.class);

    public final StringPath detail = createString("detail");

    public final StringPath explanation = createString("explanation");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> likeCount = createNumber("likeCount", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> modDate = _super.modDate;

    public final StringPath name = createString("name");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> regDate = _super.regDate;

    public final NumberPath<Integer> views = createNumber("views", Integer.class);

    public QMyOwnRecipe(String variable) {
        super(MyOwnRecipe.class, forVariable(variable));
    }

    public QMyOwnRecipe(Path<? extends MyOwnRecipe> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMyOwnRecipe(PathMetadata metadata) {
        super(MyOwnRecipe.class, metadata);
    }

}

