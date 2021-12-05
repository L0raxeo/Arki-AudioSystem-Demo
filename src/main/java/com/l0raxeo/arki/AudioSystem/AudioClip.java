package com.l0raxeo.arki.AudioSystem;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioClip
{

    public AudioInputStream audioInputStream;
    public Clip clip;

    public final String name;
    public final String path;
    public final float volume;

    public AudioClip(String name, String path, float volume)
    {
        this.name = name;
        this.path = path;
        this.volume = volume;

        createClip();
    }

    private void createClip()
    {
        try
        {
            audioInputStream =
                    AudioSystem.getAudioInputStream(new File(path).getAbsoluteFile());

            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
        {
            e.printStackTrace();
        }
    }

    public Clip getClip()
    {
        return clip;
    }

}
