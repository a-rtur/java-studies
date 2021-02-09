package random.opencv.main;

import random.opencv.frame_converter.OpenCVSingleFrameConverter;

public class OpenCVMain {
	
	public static void main(String[] args) throws Exception {
		new OpenCVSingleFrameConverter().convertVideoToSingleFrame();
	}
}
