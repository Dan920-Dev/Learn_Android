package com.escobar.dummydictionary.data.model;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import com.escobar.dummydictionary.data.dao.AntonymDao;
import com.escobar.dummydictionary.data.dao.AntonymDao_Impl;
import com.escobar.dummydictionary.data.dao.SynonymDao;
import com.escobar.dummydictionary.data.dao.SynonymDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DummyDictionaryDatabase_Impl extends DummyDictionaryDatabase {
  private volatile WordDao _wordDao;

  private volatile SynonymDao _synonymDao;

  private volatile AntonymDao _antonymDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `word_table` (`term` TEXT NOT NULL, `definition` TEXT NOT NULL, `is_fav` INTEGER NOT NULL DEFAULT 0, PRIMARY KEY(`term`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '976531f016cf1dcdb663af4ddbda3191')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `word_table`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsWordTable = new HashMap<String, TableInfo.Column>(3);
        _columnsWordTable.put("term", new TableInfo.Column("term", "TEXT", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWordTable.put("definition", new TableInfo.Column("definition", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsWordTable.put("is_fav", new TableInfo.Column("is_fav", "INTEGER", true, 0, "0", TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysWordTable = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesWordTable = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoWordTable = new TableInfo("word_table", _columnsWordTable, _foreignKeysWordTable, _indicesWordTable);
        final TableInfo _existingWordTable = TableInfo.read(_db, "word_table");
        if (! _infoWordTable.equals(_existingWordTable)) {
          return new RoomOpenHelper.ValidationResult(false, "word_table(com.escobar.dummydictionary.data.model.Word).\n"
                  + " Expected:\n" + _infoWordTable + "\n"
                  + " Found:\n" + _existingWordTable);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "976531f016cf1dcdb663af4ddbda3191", "d14ebd2e41b0d7c000970f83d2396650");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "word_table");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `word_table`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(WordDao.class, WordDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(SynonymDao.class, SynonymDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(AntonymDao.class, AntonymDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  public List<Migration> getAutoMigrations(
      @NonNull Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecsMap) {
    return Arrays.asList();
  }

  @Override
  public WordDao wordDao() {
    if (_wordDao != null) {
      return _wordDao;
    } else {
      synchronized(this) {
        if(_wordDao == null) {
          _wordDao = new WordDao_Impl(this);
        }
        return _wordDao;
      }
    }
  }

  @Override
  public SynonymDao synonymDao() {
    if (_synonymDao != null) {
      return _synonymDao;
    } else {
      synchronized(this) {
        if(_synonymDao == null) {
          _synonymDao = new SynonymDao_Impl(this);
        }
        return _synonymDao;
      }
    }
  }

  @Override
  public AntonymDao antonymDao() {
    if (_antonymDao != null) {
      return _antonymDao;
    } else {
      synchronized(this) {
        if(_antonymDao == null) {
          _antonymDao = new AntonymDao_Impl(this);
        }
        return _antonymDao;
      }
    }
  }
}
