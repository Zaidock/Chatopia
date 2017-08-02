package com.zaidock.chat.music;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.zaidock.chat.Game;

public class Music {
	
	public enum TracksNight {

	}

	public Tracks music;
	
	public enum Tracks {
		Planetarium
	}
	
	public enum TracksDay {
		insertHere
	}
	
	public enum TrackList {
		Day, Night
	}
	

	public void resetTrack() {
		switch (Game.currentPlace) {
			case worldDay:;
			case worldNight:;
			case chathub: try {
					playTrack(Tracks.Planetarium);
				} catch (UnsupportedAudioFileException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			case introMission:;
			case titlemenu:;
		}
	}
	
	public void playTrack(Tracks trackname) throws UnsupportedAudioFileException, IOException {
		File track;
		if (trackname != Tracks.Planetarium) {
			track = new File("music/" + trackname + ".mp3");
		} else {
			track = new File("music/unlisccenced/" + trackname + ".mp3");
		}
		
		AudioSystem.getAudioInputStream(track);
	}
	
	public void playTrackList(TrackList tracks) {
		switch (tracks) {
			case Day: {
				double randnum = Math.random();
				TracksDay[] enumvalue = TracksDay.values();
				int enumlength = enumvalue.length;
				double fraction = 1 / enumvalue.length;
				for (int i = 0; i < enumlength; i++) {
					if (randnum > fraction * i && randnum < fraction * i+1) {
						music = Tracks.valueOf(enumvalue[i].name());
					}
				}
			}
			case Night: {
				double randnum = Math.random();
				TracksNight[] enumvalue = TracksNight.values();
				int enumlength = enumvalue.length;
				double fraction = 1 / enumvalue.length;
				for (int i = 0; i < enumlength; i++) {
					if (randnum > fraction * i && randnum < fraction * i+1) {
						music = Tracks.valueOf(enumvalue[i].name());
					}
				}
			}
		}
	}
}
