package edu.kiet.www.myloaderexample;

import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;

class MyLoader implements LoaderManager.LoaderCallbacks<Cursor>{

    Context context;
    MyLoader(Context context)
    {
        this.context=context;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        String projection[]={ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER};
        if(i==1)
        {
            return new CursorLoader(context, ContactsContract.CommonDataKinds.Phone.CONTENT_URI,projection,null,null,null);
        }
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        StringBuffer data = new StringBuffer();
        if(cursor!=null && cursor.getCount()>0)
        {
            while (cursor.moveToNext())
            {
                data.append("Name="+cursor.getString(0)+"\n");
                data.append("Phone="+cursor.getString(1)+"\n\n");
            }
            AlertDialog.Builder builder =new AlertDialog.Builder(context);
            builder.setTitle("Contact Info");
            builder.setMessage(data);
            builder.setCancelable(true);
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
