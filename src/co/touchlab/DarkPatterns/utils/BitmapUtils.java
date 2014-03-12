package co.touchlab.DarkPatterns.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/**
 * User: davidredding
 * Date: 3/11/14
 * Time: 10:55 PM
 */
public class BitmapUtils {

    public static Bitmap blurBitmap (Context context,Bitmap originalBitmap, int radius) {

        // Create another bitmap that will hold the results of the filter.
        Bitmap blurredBitmap;
        blurredBitmap = Bitmap.createBitmap(originalBitmap);

        // Create the Renderscript instance that will do the work.
        RenderScript rs = RenderScript.create(context);

        // Allocate memory for Renderscript to work with
        Allocation input = Allocation.createFromBitmap (rs, originalBitmap, Allocation.MipmapControl.MIPMAP_FULL, Allocation.USAGE_SCRIPT);
        Allocation output = Allocation.createTyped (rs, input.getType());

        // Load up an instance of the specific script that we want to use.
        ScriptIntrinsicBlur script = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
        script.setInput(input);

        // Set the blur radius
        script.setRadius (radius);

        // Start the ScriptIntrinisicBlur
        script.forEach(output);

        // Copy the output to the blurred bitmap
        output.copyTo(blurredBitmap);

        return blurredBitmap;
    }
}
