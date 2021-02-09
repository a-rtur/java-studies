package random.opencv.file;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

import random.opencv.type.OpenCVTypes;

public class OpenCVFile {
	public ArrayList<File> getVideoFileNames() throws Exception {
		ArrayList<File> fileName = new ArrayList<File>();
		try (Stream<Path> fileStream = Files.walk(Paths.get(OpenCVTypes.FILE_INPUT))) {
			fileStream.forEach(file -> {
				if (Files.isRegularFile(file)) {
					if (file.getFileName().toString().endsWith(OpenCVTypes.VIDEO_SUFFIX)) {
						fileName.add(file.toFile());
					}
				}
			});
		}
		return fileName;
	}
	
	public void createFramesFolder() {
		if (!new File(OpenCVTypes.FRAME_OUTPUT).exists()) {
            new File(OpenCVTypes.FRAME_OUTPUT).mkdir();
        }
	}
}
