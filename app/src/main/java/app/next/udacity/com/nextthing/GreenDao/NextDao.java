package app.next.udacity.com.nextthing.GreenDao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table NEXT.
*/
public class NextDao extends AbstractDao<Next, Long> {

    public static final String TABLENAME = "NEXT";

    /**
     * Properties of entity Next.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property ObjectId = new Property(1, String.class, "objectId", false, "OBJECT_ID");
        public final static Property Url = new Property(2, String.class, "url", false, "URL");
        public final static Property Description = new Property(3, String.class, "description", false, "DESCRIPTION");
        public final static Property Title = new Property(4, String.class, "title", false, "TITLE");
        public final static Property Vote = new Property(5, int.class, "vote", false, "VOTE");
        public final static Property Liked = new Property(6, Boolean.class, "liked", false, "LIKED");
        public final static Property CreateTime = new Property(7, java.util.Date.class, "createTime", false, "CREATE_TIME");
        public final static Property ModifyTime = new Property(8, java.util.Date.class, "modifyTime", false, "MODIFY_TIME");
    };


    public NextDao(DaoConfig config) {
        super(config);
    }
    
    public NextDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'NEXT' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'OBJECT_ID' TEXT NOT NULL ," + // 1: objectId
                "'URL' TEXT NOT NULL ," + // 2: url
                "'DESCRIPTION' TEXT NOT NULL ," + // 3: description
                "'TITLE' TEXT NOT NULL ," + // 4: title
                "'VOTE' INTEGER NOT NULL ," + // 5: vote
                "'LIKED' INTEGER," + // 6: liked
                "'CREATE_TIME' INTEGER," + // 7: createTime
                "'MODIFY_TIME' INTEGER);"); // 8: modifyTime
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'NEXT'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Next entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getObjectId());
        stmt.bindString(3, entity.getUrl());
        stmt.bindString(4, entity.getDescription());
        stmt.bindString(5, entity.getTitle());
        stmt.bindLong(6, entity.getVote());
 
        Boolean liked = entity.getLiked();
        if (liked != null) {
            stmt.bindLong(7, liked ? 1l: 0l);
        }
 
        java.util.Date createTime = entity.getCreateTime();
        if (createTime != null) {
            stmt.bindLong(8, createTime.getTime());
        }
 
        java.util.Date modifyTime = entity.getModifyTime();
        if (modifyTime != null) {
            stmt.bindLong(9, modifyTime.getTime());
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Next readEntity(Cursor cursor, int offset) {
        Next entity = new Next( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // objectId
            cursor.getString(offset + 2), // url
            cursor.getString(offset + 3), // description
            cursor.getString(offset + 4), // title
            cursor.getInt(offset + 5), // vote
            cursor.isNull(offset + 6) ? null : cursor.getShort(offset + 6) != 0, // liked
            cursor.isNull(offset + 7) ? null : new java.util.Date(cursor.getLong(offset + 7)), // createTime
            cursor.isNull(offset + 8) ? null : new java.util.Date(cursor.getLong(offset + 8)) // modifyTime
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Next entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setObjectId(cursor.getString(offset + 1));
        entity.setUrl(cursor.getString(offset + 2));
        entity.setDescription(cursor.getString(offset + 3));
        entity.setTitle(cursor.getString(offset + 4));
        entity.setVote(cursor.getInt(offset + 5));
        entity.setLiked(cursor.isNull(offset + 6) ? null : cursor.getShort(offset + 6) != 0);
        entity.setCreateTime(cursor.isNull(offset + 7) ? null : new java.util.Date(cursor.getLong(offset + 7)));
        entity.setModifyTime(cursor.isNull(offset + 8) ? null : new java.util.Date(cursor.getLong(offset + 8)));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Next entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Next entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}