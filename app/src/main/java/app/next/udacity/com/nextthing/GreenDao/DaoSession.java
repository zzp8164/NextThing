package app.next.udacity.com.nextthing.GreenDao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import app.next.udacity.com.nextthing.GreenDao.Next;

import app.next.udacity.com.nextthing.GreenDao.NextDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig nextDaoConfig;

    private final NextDao nextDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        nextDaoConfig = daoConfigMap.get(NextDao.class).clone();
        nextDaoConfig.initIdentityScope(type);

        nextDao = new NextDao(nextDaoConfig, this);

        registerDao(Next.class, nextDao);
    }
    
    public void clear() {
        nextDaoConfig.getIdentityScope().clear();
    }

    public NextDao getNextDao() {
        return nextDao;
    }

}
