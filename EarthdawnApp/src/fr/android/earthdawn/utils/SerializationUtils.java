/**
 *
 */
package fr.android.earthdawn.utils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import android.content.Context;
import android.util.Log;

/**
 * @author DrMabulle
 *
 */
public final class SerializationUtils
{
    private static final String EXTENSION = ".ser";

    public static final void serializeOnDisk(final Object obj, final String fileName, final Context ctx)
    {
        ObjectOutput out = null;
        try
        {
            out = new ObjectOutputStream(ctx.openFileOutput(fileName + EXTENSION, Context.MODE_PRIVATE));
            out.writeObject(obj);
        }
        catch (final IOException e)
        {
            Log.e("Serialization", "Serialization failed", e);
        }
        finally
        {
            closeSilently(out);
        }
    }

    public static final Object deserializeFromDisk(final String fileName, final Context ctx)
    {
        ObjectInputStream in = null;
        Object obj = null;
        try
        {
            in = new ObjectInputStream(ctx.openFileInput(fileName + EXTENSION));
            obj = in.readObject();
        }
        catch (final IOException e)
        {
            Log.e("Serialization", "Deserialization failed", e);
        }
        catch (final ClassNotFoundException e)
        {
            Log.e("Serialization", "Deserialization failed", e);
        }
        finally
        {
            closeSilently(in);
        }
        return obj;
    }

    private static final void closeSilently(final ObjectOutput out)
    {
        try
        {
            if (out != null)
            {
                out.close();
            }
        }
        catch (final IOException e)
        {
            Log.e("Serialization", "Closing ObjectOutput failed", e);
        }
    }

    private static final void closeSilently(final ObjectInputStream in)
    {
        try
        {
            if (in != null)
            {
                in.close();
            }
        }
        catch (final IOException e)
        {
            Log.e("Serialization", "Closing ObjectInputStream failed", e);
        }
    }
}
