package com.l0raxeo.arki.AudioSystem;

import java.util.ArrayList;

public class AudioManager
{

    private static final ArrayList<AudioClip> curPlayingAudio = new ArrayList<>();

    public static void play(AudioClip audioClip)
    {
        audioClip.getClip().start();
        indexAudioClip(audioClip);
    }

    public static void loop(AudioClip audioClip, int amt)
    {
        audioClip.getClip().loop(amt);
        indexAudioClip(audioClip);
    }

    public static void stop(AudioClip audioClip)
    {
        audioClip.getClip().stop();
        audioClip.getClip().close();
        removeAudioClip(audioClip);
    }

    public static void stop(String name)
    {
        for (AudioClip audioClip : curPlayingAudio)
        {
            if (audioClip.name.equals(name))
            {
                audioClip.getClip().stop();
                audioClip.getClip().close();
                removeAudioClip(audioClip);
                break;
            }
        }
    }

    public static ArrayList<AudioClip> getAllCurPlayingAudio()
    {
        return curPlayingAudio;
    }

    private static void indexAudioClip(AudioClip audioClip)
    {
        curPlayingAudio.add(audioClip);
    }

    private static void removeAudioClip(AudioClip audioClip)
    {
        curPlayingAudio.remove(audioClip);
    }

}
