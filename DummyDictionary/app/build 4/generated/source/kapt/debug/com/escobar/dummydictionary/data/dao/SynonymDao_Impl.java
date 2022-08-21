package com.escobar.dummydictionary.data.dao;

import androidx.room.RoomDatabase;
import java.lang.Class;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class SynonymDao_Impl implements SynonymDao {
  private final RoomDatabase __db;

  public SynonymDao_Impl(RoomDatabase __db) {
    this.__db = __db;
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
