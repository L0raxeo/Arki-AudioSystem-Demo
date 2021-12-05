package com.l0raxeo.arki.AudioSystem;

import java.util.Objects;
import java.util.Scanner;

public class Launcher
{

    public static void main(String[] args)
    {
        AudioClip sampleClip = new AudioClip("mormons", "bin/assets/sample_audio.wav", 1);
        AudioManager.loop(sampleClip, 1);

        Scanner sc = new Scanner(System.in);
        while (true)
        {
            if (Objects.equals(sc.next(), "stop"))
                AudioManager.stop("mormons");
        }
    }

}
