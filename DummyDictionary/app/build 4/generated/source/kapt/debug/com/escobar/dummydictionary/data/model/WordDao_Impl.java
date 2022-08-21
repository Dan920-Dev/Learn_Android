package com.escobar.dummydictionary.data.model;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@SuppressWarnings({"unchecked", "deprecation"})
public final class WordDao_Impl implements WordDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Word> __insertionAdapterOfWord;

  private final EntityDeletionOrUpdateAdapter<Word> __deletionAdapterOfWord;

  private final EntityDeletionOrUpdateAdapter<Word> __updateAdapterOfWord;

  public WordDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfWord = new EntityInsertionAdapter<Word>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `word_table` (`term`,`definition`,`is_fav`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Word value) {
        if (value.getTerm() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTerm());
        }
        if (value.getDefinition() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDefinition());
        }
        final int _tmp = value.isFav() ? 1 : 0;
        stmt.bindLong(3, _tmp);
      }
    };
    this.__deletionAdapterOfWord = new EntityDeletionOrUpdateAdapter<Word>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `word_table` WHERE `term` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Word value) {
        if (value.getTerm() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTerm());
        }
      }
    };
    this.__updateAdapterOfWord = new EntityDeletionOrUpdateAdapter<Word>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `word_table` SET `term` = ?,`definition` = ?,`is_fav` = ? WHERE `term` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Word value) {
        if (value.getTerm() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getTerm());
        }
        if (value.getDefinition() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getDefinition());
        }
        final int _tmp = value.isFav() ? 1 : 0;
        stmt.bindLong(3, _tmp);
        if (value.getTerm() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getTerm());
        }
      }
    };
  }

  @Override
  public Object insertWord(final List<Word> word, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfWord.insert(word);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteWord(final Word word, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfWord.handle(word);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object updateWord(final Word word, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfWord.handle(word);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public LiveData<List<Word>> getAllWords() {
    final String _sql = "SELECT * FROM  word_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"word_table"}, false, new Callable<List<Word>>() {
      @Override
      public List<Word> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfTerm = CursorUtil.getColumnIndexOrThrow(_cursor, "term");
          final int _cursorIndexOfDefinition = CursorUtil.getColumnIndexOrThrow(_cursor, "definition");
          final int _cursorIndexOfIsFav = CursorUtil.getColumnIndexOrThrow(_cursor, "is_fav");
          final List<Word> _result = new ArrayList<Word>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Word _item;
            final String _tmpTerm;
            if (_cursor.isNull(_cursorIndexOfTerm)) {
              _tmpTerm = null;
            } else {
              _tmpTerm = _cursor.getString(_cursorIndexOfTerm);
            }
            final String _tmpDefinition;
            if (_cursor.isNull(_cursorIndexOfDefinition)) {
              _tmpDefinition = null;
            } else {
              _tmpDefinition = _cursor.getString(_cursorIndexOfDefinition);
            }
            final boolean _tmpIsFav;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsFav);
            _tmpIsFav = _tmp != 0;
            _item = new Word(_tmpTerm,_tmpDefinition,_tmpIsFav);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
