package gtsoffenbach.nfcgamespieler_appprototype.implementations;

import android.app.Activity;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Parcelable;

import gtsoffenbach.nfcgamespieler_appprototype.gameinterface.NFC;

/**
 * Created by Noli on 14.07.2014.
 */
public class GameNFC extends NFC {

    GameNFC(Activity caller) {
        this.caller = caller;
        this.mNfcAdapter = NfcAdapter.getDefaultAdapter(caller);

    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public String getPayload() {
        return null;
    }

    @Override
    public void setPayload(String payload) {

    }

    @Override
    public void installService() {

    }

    @Override
    public void uninstallService() {

    }

    @Override
    public boolean checkNFC() {
        return false;
    }

    @Override
    public void resolveIntent() {

    }

    @Override
    public byte[] rawTagData(Parcelable parc) {
        return new byte[0];
    }

    @Override
    public NdefMessage[] RawNDEFContent(Intent intent) {
        return new NdefMessage[0];
    }

    @Override
    public void printTag(NdefMessage[] msgs) {

    }

    @Override
    public int writeTag(Tag tag, NdefMessage message) {
        return 0;
    }

    @Override
    public void enableWrite() {

    }

    @Override
    public void disableWrite() {

    }

    @Override
    public void operate() {

    }

    @Override
    public void createWriteNdef(NdefMessage[] messages) {

    }

    @Override
    public void createWriteNdef(NdefMessage message) {

    }
}
