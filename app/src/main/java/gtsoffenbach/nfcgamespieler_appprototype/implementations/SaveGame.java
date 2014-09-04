package gtsoffenbach.nfcgamespieler_appprototype.implementations;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Noli on 02.09.2014.
 */
public class SaveGame {
    public static final String path = "secretfile.secret";
    public static boolean newGame = true;
    public static Level[] levels = new Level[]{new Level("Armageddon", 0, false), new Level("Armageddon2", 1, false), new Level("Armageddon3", 2, false)};

    private Context caller;
    private FileOutputStream fos;
    private FileInputStream fis;
    private String content;

    SaveGame(Context caller) {
        this.caller = caller;
    }

    public void loadGame() {
        try {
            //fos = caller.openFileOutput(path, Context.MODE_PRIVATE);
            fis = caller.openFileInput(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            save();
            return;
        }
        newGame = false;
        int n;
        StringBuffer fileContent = new StringBuffer("");
        try {

            byte[] buffer = new byte[1024];

            while ((n = fis.read(buffer)) != -1) {
                fileContent.append(new String(buffer, 0, n));
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        content = fileContent.toString();

        if (content != "" || content != null) {
            //Load from file
            String[] parts = content.split("#");
            for (int i = 0; i < parts.length; i++) {
                String[] set = parts[i].split(",");
                levels[Integer.valueOf(set[0])].setUnlocked(set[1] == "1" ? true : false);
                levels[Integer.valueOf(set[0])].setLevelnumber(Integer.valueOf(set[0]));
            }
        }
    }

    private void createSaveGame() {
        try {
            new File(path).createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save() {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < levels.length; i++) {
            if (i == levels.length - 1) {
                sb.append(levels[i].getLevelnumber()).append(",").append(levels[i].isUnlocked() ? 1 : 0);
            } else {
                sb.append(levels[i].getLevelnumber()).append(",").append(levels[i].isUnlocked() ? 1 : 0).append("#");
            }
        }

        try {
            //File f = new File(path);
            //f.delete();
            //f.createNewFile();
            fos = caller.openFileOutput(path, Context.MODE_PRIVATE);
            fos.write(sb.toString().getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
