package com.m2sili.convertisseur;

import android.test.ActivityInstrumentationTestCase2;

/**
 * This is a simple framework for a test of an Application.  See
 * {@link android.test.ApplicationTestCase ApplicationTestCase} for more information on
 * how to write and extend Application tests.
 * <p/>
 * To run this test, you can type:
 * adb shell am instrument -w \
 * -e class com.m2sili.convertisseur.ConvertisseurTest \
 * com.m2sili.convertisseur.tests/android.test.InstrumentationTestRunner
 */
public class ConvertisseurTest extends ActivityInstrumentationTestCase2<Convertisseur> {

    public ConvertisseurTest() {
        super("com.m2sili.convertisseur", Convertisseur.class);
    }

}
