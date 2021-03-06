// This class was generated from com.antlersoft.patchyamp.db.ISavedState by a tool
// Do not edit this file directly! PLX THX
package com.antlersoft.patchyamp.db;

public class SavedState extends com.antlersoft.android.dbimpl.IdImplementationBase implements ISavedState {

    public static final String GEN_TABLE_NAME = "SAVED_STATE";
    public static final int GEN_COUNT = 4;

    // Field constants
    public static final String GEN_FIELD__ID = "_id";
    public static final int GEN_ID__ID = 0;
    public static final String GEN_FIELD_CURRENTCONNECTIONID = "CURRENTCONNECTIONID";
    public static final int GEN_ID_CURRENTCONNECTIONID = 1;
    public static final String GEN_FIELD_CONNECTIONVALID = "CONNECTIONVALID";
    public static final int GEN_ID_CONNECTIONVALID = 2;
    public static final String GEN_FIELD_SHOW_SPLASH_VERSION = "SHOW_SPLASH_VERSION";
    public static final int GEN_ID_SHOW_SPLASH_VERSION = 3;

    // SQL Command for creating the table
    public static String GEN_CREATE = "CREATE TABLE SAVED_STATE (" +
    "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
    "CURRENTCONNECTIONID INTEGER," +
    "CONNECTIONVALID INTEGER," +
    "SHOW_SPLASH_VERSION INTEGER" +
    ")";

    // Members corresponding to defined fields
    private long gen__Id;
    private long gen_currentConnectionId;
    private boolean gen_connectionValid;
    private long gen_SHOW_SPLASH_VERSION;


    public static final com.antlersoft.android.dbimpl.NewInstance<SavedState> GEN_NEW = new com.antlersoft.android.dbimpl.NewInstance<SavedState>() {
        public SavedState get() {
            return new SavedState();
        }
    }
    ;

    public String Gen_tableName() { return GEN_TABLE_NAME; }

    // Field accessors
    public long get_Id() { return gen__Id; }
    public void set_Id(long arg__Id) { gen__Id = arg__Id; }
    public long getCurrentConnectionId() { return gen_currentConnectionId; }
    public void setCurrentConnectionId(long arg_currentConnectionId) { gen_currentConnectionId = arg_currentConnectionId; }
    public boolean getConnectionValid() { return gen_connectionValid; }
    public void setConnectionValid(boolean arg_connectionValid) { gen_connectionValid = arg_connectionValid; }
    public long getShowSplashVersion() { return gen_SHOW_SPLASH_VERSION; }
    public void setShowSplashVersion(long arg_SHOW_SPLASH_VERSION) { gen_SHOW_SPLASH_VERSION = arg_SHOW_SPLASH_VERSION; }

    public android.content.ContentValues Gen_getValues() {
        android.content.ContentValues values=new android.content.ContentValues();
        values.put(GEN_FIELD__ID,Long.toString(this.gen__Id));
        values.put(GEN_FIELD_CURRENTCONNECTIONID,Long.toString(this.gen_currentConnectionId));
        values.put(GEN_FIELD_CONNECTIONVALID,(this.gen_connectionValid ? "1" : "0"));
        values.put(GEN_FIELD_SHOW_SPLASH_VERSION,Long.toString(this.gen_SHOW_SPLASH_VERSION));
        return values;
    }

    /**
     * Return an array that gives the column index in the cursor for each field defined
     * @param cursor Database cursor over some columns, possibly including this table
     * @return array of column indices; -1 if the column with that id is not in cursor
     */
    public int[] Gen_columnIndices(android.database.Cursor cursor) {
        int[] result=new int[GEN_COUNT];
        result[0] = cursor.getColumnIndex(GEN_FIELD__ID);
        // Make compatible with database generated by older version of plugin with uppercase column name
        if (result[0] == -1) {
            result[0] = cursor.getColumnIndex("_ID");
        }
        result[1] = cursor.getColumnIndex(GEN_FIELD_CURRENTCONNECTIONID);
        result[2] = cursor.getColumnIndex(GEN_FIELD_CONNECTIONVALID);
        result[3] = cursor.getColumnIndex(GEN_FIELD_SHOW_SPLASH_VERSION);
        return result;
    }

    /**
     * Populate one instance from a cursor 
     */
    public void Gen_populate(android.database.Cursor cursor,int[] columnIndices) {
        if ( columnIndices[GEN_ID__ID] >= 0 && ! cursor.isNull(columnIndices[GEN_ID__ID])) {
            gen__Id = cursor.getLong(columnIndices[GEN_ID__ID]);
        }
        if ( columnIndices[GEN_ID_CURRENTCONNECTIONID] >= 0 && ! cursor.isNull(columnIndices[GEN_ID_CURRENTCONNECTIONID])) {
            gen_currentConnectionId = cursor.getLong(columnIndices[GEN_ID_CURRENTCONNECTIONID]);
        }
        if ( columnIndices[GEN_ID_CONNECTIONVALID] >= 0 && ! cursor.isNull(columnIndices[GEN_ID_CONNECTIONVALID])) {
            gen_connectionValid = (cursor.getInt(columnIndices[GEN_ID_CONNECTIONVALID]) != 0);
        }
        if ( columnIndices[GEN_ID_SHOW_SPLASH_VERSION] >= 0 && ! cursor.isNull(columnIndices[GEN_ID_SHOW_SPLASH_VERSION])) {
            gen_SHOW_SPLASH_VERSION = cursor.getLong(columnIndices[GEN_ID_SHOW_SPLASH_VERSION]);
        }
    }

    /**
     * Populate one instance from a ContentValues 
     */
    public void Gen_populate(android.content.ContentValues values) {
        gen__Id = values.getAsLong(GEN_FIELD__ID);
        gen_currentConnectionId = values.getAsLong(GEN_FIELD_CURRENTCONNECTIONID);
        gen_connectionValid = (values.getAsInteger(GEN_FIELD_CONNECTIONVALID) != 0);
        gen_SHOW_SPLASH_VERSION = values.getAsLong(GEN_FIELD_SHOW_SPLASH_VERSION);
    }
}
