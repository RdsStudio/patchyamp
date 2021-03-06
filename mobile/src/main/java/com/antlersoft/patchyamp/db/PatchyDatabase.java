/*
 * Copyright (C) 2017 Michael A. MacDonald
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.antlersoft.patchyamp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Database upgrader for PatchyAmp
 */

public class PatchyDatabase extends SQLiteOpenHelper {
    static final int DBV_0_1_X = 1;

    public final static String TAG = PatchyDatabase.class.toString();

    private static Object mInstanceLock = new Object();
    private static PatchyDatabase mInstance;

    private PatchyDatabase(Context context) {
        super(context, "PatchyDatabase", null, DBV_0_1_X);
    }

    public static PatchyDatabase getInstance(Context context) {
        synchronized (mInstanceLock) {
            if (mInstance == null) {
                mInstance = new PatchyDatabase(context);
            }
            return mInstance;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(AbstractConnectionBean.GEN_CREATE);
        db.execSQL(SavedState.GEN_CREATE);
    }

    private void defaultUpgrade(SQLiteDatabase db)
    {
        Log.i(TAG, "Doing default database upgrade (drop and create tables)");
        db.execSQL("DROP TABLE IF EXISTS " + AbstractConnectionBean.GEN_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + SavedState.GEN_TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < DBV_0_1_X) {
            defaultUpgrade(db);
        }
        /*
        else {
            // Intermediate upgrades
            if (oldVersion < xxxx) {
                ...
            } ...
            // Current upgrade
            ...
        }
         */
    }
    /**
     * Return the object representing the app global state in the database, or null
     * if the object hasn't been set up yet
     * @return Object representing the single persistent instance of SavedState, which
     * is the app's global state
     */
    public static SavedState getMostRecent(SQLiteDatabase db)
    {
        ArrayList<SavedState> recents = new ArrayList<>(1);
        SavedState.getAll(db, SavedState.GEN_TABLE_NAME, recents, SavedState.GEN_NEW);
        if (recents.size() == 0)
            return null;
        return recents.get(0);
    }

}
