package audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;



public class BaseAudio extends Thread {
	public AudioPlayer ap;
	public BaseAudio() {
		ap = new AudioPlayer("resource\\audio\\LawnGarden.wav");
	}
	
	public void run() {
		System.out.println("播放器控制器开始启动");
		ap.run();
		System.out.println("播放器开始计时");
		try {
			this.sleep(5000);
			ap.stopPlay();
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		BaseAudio b = new BaseAudio();
		b.run();
	}
}

class AudioPlayer extends Thread {
	public String name;
	public final int EXTERNAL_BUFFER_SIZE = 10000000;
	SourceDataLine auline = null;
	boolean running = true;
	
	public AudioPlayer(String name) {
		this.name = name;
	}
	
	public void run() {
		System.out.println("播放器开始启动");
		File soundFile = new File(name);
		if(!soundFile.exists()) {
			System.err.println("资源文件未能找到:" + name);
			return;
		}
		
		System.out.println("资源文件加载完成。");
		AudioInputStream ais = null;
		try {
			ais = AudioSystem.getAudioInputStream(soundFile);
		}
		catch(Exception e) {
			e.printStackTrace();
			return;
		}
		
		System.out.println("AudioInputStream创建完成。");
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
		System.out.println("Auline创建完成。");
		
		auline.start();
		int nBytesRead = 0;
		byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];
		
		System.out.println("开始播放");
		try {
			if(nBytesRead != -1 && running) {
				nBytesRead = ais.read(abData, 0, abData.length);
				System.out.println("读取完毕");
				if(nBytesRead >= 0) {
					auline.write(abData, 0, nBytesRead);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return;
		}
		System.out.println("播放完成。");
	}
	
	public void stopPlay() {
		running = false;
	}
}