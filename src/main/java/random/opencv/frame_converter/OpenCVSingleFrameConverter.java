package random.opencv.frame_converter;

import java.io.File;
import java.util.ArrayList;

import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

import random.opencv.file.OpenCVFile;
import random.opencv.loader.OpenCVPropertyLoader;
import random.opencv.type.OpenCVTypes;

public class OpenCVSingleFrameConverter {
	
	public OpenCVSingleFrameConverter() {
		OpenCVPropertyLoader.loadProperties();
	}
	
	public void convertVideoToSingleFrame() throws Exception {
		ArrayList<File> fileList = new OpenCVFile().getVideoFileNames();
		VideoCapture video = new VideoCapture();
		
		for (File file : fileList) {
			String fileName = file.getName().replace(OpenCVTypes.VIDEO_SUFFIX, "");
			String fileParent = file.getParent();
			video.open(file.getAbsolutePath());
			Mat frame = new Mat();

			if (video.isOpened()) {
				video.read(frame);
				Imgcodecs.imwrite(fileParent + File.separator + fileName + OpenCVTypes.IMAGE_SUFFIX, frame);
				video.release();
				file.delete();
				System.out.println("Converted sucessfully: " + fileParent + File.separator + fileName + OpenCVTypes.IMAGE_SUFFIX);
			}
		}
		
		System.out.println("Finished.");
	}
}
