package random.opencv.frame_converter;

import java.io.File;
import java.util.ArrayList;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

import random.opencv.file.OpenCVFile;
import random.opencv.loader.OpenCVPropertyLoader;
import random.opencv.type.OpenCVTypes;

public class OpenCVMultipleFrameConverter {

	public OpenCVMultipleFrameConverter() {
		OpenCVPropertyLoader.loadProperties();
		new OpenCVFile().createFramesFolder();
	}

	public void convertVideoToMultipleFrames() throws Exception {
		ArrayList<File> fileList = new OpenCVFile().getVideoFileNames();
		VideoCapture video = new VideoCapture();
		
		for (File file : fileList) {
			video.open(file.getAbsolutePath());
			int currentFrame = 1;
			Mat frame = new Mat();

			if (video.isOpened()) {
				video.read(frame);
				
				while (video.read(frame)) {
					Imgcodecs.imwrite(OpenCVTypes.FRAME_OUTPUT + File.separator + currentFrame + "_" + file.getName().replace(".mp4", "") + OpenCVTypes.IMAGE_SUFFIX, frame);
					currentFrame++;
				}
				
				video.release();
			}
		}
		
		System.out.println("Finished.");
	}
}