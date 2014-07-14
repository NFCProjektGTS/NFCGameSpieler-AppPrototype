package gtsoffenbach.nfcgamespieler_appprototype.gameinterface;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Parcelable;

/**
 * Created by Noli on 14.07.2014.
 */
public abstract class NFC {
    protected NfcAdapter mNfcAdapter;
    protected Context caller;
    protected Tag wTag;
    protected boolean WriteMode = false;
    protected boolean enabled = false;
    protected IntentFilter[] mTagFilters;
    protected NdefMessage[] mCurrentNdef;
    protected NdefMessage[] mWriteNdef;
    protected String payload = "";

    public abstract boolean isEnabled();

    public abstract String getPayload();

    public abstract void setPayload(String payload);

    public abstract void installService();

    public abstract void uninstallService();

    public abstract boolean checkNFC();

    public abstract void resolveIntent();

    public abstract byte[] rawTagData(Parcelable parc);

    public abstract NdefMessage[] RawNDEFContent(Intent intent);

    public abstract void printTag(NdefMessage[] msgs);

    public abstract int writeTag(Tag tag, NdefMessage message);

    public abstract void enableWrite();

    public abstract void disableWrite();

    public abstract void operate();

    public abstract void createWriteNdef(NdefMessage[] messages);

    public abstract void createWriteNdef(NdefMessage message);
}
