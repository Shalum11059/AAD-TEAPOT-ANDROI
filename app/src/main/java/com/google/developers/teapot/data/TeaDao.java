package com.google.developers.teapot.data;

import androidx.annotation.WorkerThread;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.DatabaseView;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.room.Update;
import androidx.sqlite.db.SupportSQLiteQuery;

import static androidx.room.OnConflictStrategy.REPLACE;

/**
 * Room data access object.
 */
@Dao
public interface TeaDao {

    /**
     * Returns all data in table for Paging
     *
     */
    @WorkerThread
    @Query("SELECT * FROM tea_table where favorite = 1")
    DataSource.Factory<Integer, Tea> getAll();

    /**
     * Returns a Tea based on the tea name.
     *
     * @param name of a tea
     */
    @WorkerThread
    @Query("SELECT * from tea_table WHERE name = :name")
    LiveData<Tea> getTea(String name);

    /**
     * Update tea if its favorite or not.
     *
     * @param name of a tea
     */
    @WorkerThread
    @Query("UPDATE tea_table SET name = :name WHERE name = :name")
    void updateFavorite(String name);

    /**
     * Returns a random Tea
     */
    @WorkerThread
    @Query("Select * from tea_table Where type")
    Tea getRandomTea();

    @WorkerThread
    @Query("SELECT * from tea_table ORDER BY favorite ASC")
    LiveData<Tea> getRecentTea();

    @WorkerThread
    @Insert
    void insert(Tea... tea);

    @WorkerThread
    @Delete
    void delete(Tea tea);
}
