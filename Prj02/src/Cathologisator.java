
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.id3.ID3v1Tag;
import org.jaudiotagger.tag.images.Artwork;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


import java.io.File;
import java.util.List;


public class Cathologisator {
    public File file = new File("D://mp3.html");

    public static void main(String[] args) throws IOException, ReadOnlyFileException, TagException, InvalidAudioFrameException, CannotReadException {
        if (args.length != 1) {
            System.out.println("Pls, enter only one path");
        }
        String path = args[0];
        Cathologisator mp3 = new Cathologisator();
        mp3.extract(new File(path));

    }

    public void extract(File dir) throws IOException, TagException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException {
        File l[] = dir.listFiles();
        MP3File f = new MP3File();
        if (l == null) {
            System.out.println("[skipped] " + dir);
            return;
        }
        for (File x : l) {
            if (x.isDirectory())
                extract(x);
            if (x.isHidden() || !x.canRead())
                continue;
            else if (x.getName().endsWith(".mp3"))
                f = (MP3File) AudioFileIO.read(x);
            Tag tag = f.getTag();


        }

    }
}

