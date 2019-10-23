package controller;

import viewer.*;
import bullet.*;

public class MainController implements Runnable {
	public MainViewer mainViewer;
	public Thread t;
	
	public MainController() {
		mainViewer = new MainViewer();
		start();
	}
	
	public void start() {
		if(t == null) {
			t = new Thread(this);
			t.start();
		}
	}
	
	@SuppressWarnings("static-access")
	public void run() {
		System.out.println("The MainController is running.");
		while(true) {
			
			// ����ö���߳��ܹ�ͬ������������ĵȴ���������ġ�
			try {
				t.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		MainController mainController = new MainController();
	}
}
