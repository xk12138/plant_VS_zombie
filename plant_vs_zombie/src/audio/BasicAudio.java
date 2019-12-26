package audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;



public class BasicAudio {
	public AudioPlayer ap;
	
	public BasicAudio(String name) {
		ap = new AudioPlayer(name);
	}
		
	public void change(String name) {
		ap.stopPlay();
		ap = new AudioPlayer(name);
	}
	
	public void add(String name) {
		AudioPlayer t = new AudioPlayer(name);
		t.loop = false;
	}
	public void stop() {
		ap.stopPlay();
	}
	public void setLoop(boolean loop) {
		ap.loop = loop;
	}
}


class AudioPlayer implements Runnable {
	public String name;
	public final int EXTERNAL_BUFFER_SIZE = 65536;
	SourceDataLine auline = null;
	boolean running = true;
	Thread t;
	public boolean loop = true;
	public AudioPlayer(String name) {
		this.name = name;
		start();
	}
	
	public void start() {
		if(t == null) {
			t = new Thread(this);
			t.start();
		}
	}
	
	public void run() {
		//System.out.println("播放器开始启动");
		File soundFile = new File(name);
		if(!soundFile.exists()) {
			System.err.println("资源文件未能找到:" + name);
			return;
		}
		
		//System.out.println("资源文件加载完成。");
		AudioInputStream ais = null;
		try {
			ais = AudioSystem.getAudioInputStream(soundFile);
		}
		catch(Exception e) {
			e.printStackTrace();
			return;
		}
		
		//System.out.println("AudioInputStream创建完成。");
		AudioFormat format = ais.getFormat();
		DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
		
		try {
			auline = (SourceDataLine)AudioSystem.getLine(info);
			auline.open(format);
		}
		catch(Exception e) {
			e.printStackTrace();
			return;
		}
		//System.out.println("Auline创建完成。");
		
		auline.start();
		int nBytesRead = 0;
		byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];
		
		//System.out.println("开始播放");
			try {
				int i = 0;
				while(nBytesRead != -1 && running) {
					nBytesRead = ais.read(abData, 0, abData.length);
					//System.out.println("读取完毕:");
					if(nBytesRead >= 0) {
						//System.out.println(nBytesRead);
						auline.write(abData, 0, nBytesRead);
						//System.out.println("读取完毕");
					}
				}
				if(loop == true) {
					run();
				}
			}
			catch(Exception e) {
				e.printStackTrace();
				return;
			}
		
		System.out.println("播放完成。");
	}
	
	public void stopPlay() {
		auline.stop();
		loop = false;
		running = false;
	}
}