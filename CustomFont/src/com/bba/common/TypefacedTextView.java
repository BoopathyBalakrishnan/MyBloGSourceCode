/**
 * 
 */
package com.bba.common;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author Boopathy Balakrishnan
 *
 */
public class TypefacedTextView extends TextView {
	public TypefacedTextView(Context context) {
        super(context);
        init();
   }

   public TypefacedTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
   }

   public TypefacedTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
   }

   private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                      "fonts/GEORGIA.ttf");
            setTypeface(tf);
        }
   }
}
