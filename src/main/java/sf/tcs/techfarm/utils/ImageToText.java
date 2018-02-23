package sf.tcs.techfarm.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.protobuf.ByteString;

public class ImageToText {
	
	public static String getTextDescription(String fileName) throws IOException, Exception{
		
		String description = "";
		 try (ImageAnnotatorClient vision = ImageAnnotatorClient.create()) {
		      Path path = Paths.get(fileName);
		      byte[] data = Files.readAllBytes(path);
		      ByteString imgBytes = ByteString.copyFrom(data);
		      List<AnnotateImageRequest> requests = new ArrayList<>();
		      Image img = Image.newBuilder().setContent(imgBytes).build();
		      Feature feat = Feature.newBuilder().setType(Type.TEXT_DETECTION).build();
		      AnnotateImageRequest request = AnnotateImageRequest.newBuilder()
		          .addFeatures(feat)
		          .setImage(img)
		          .build();
		      requests.add(request);
		      BatchAnnotateImagesResponse response = vision.batchAnnotateImages(requests);
		      List<AnnotateImageResponse> responses = response.getResponsesList();

		      for (AnnotateImageResponse res : responses) {
		        if (res.hasError()) {
		          System.out.printf("Error: %s\n", res.getError().getMessage());
		        }

		        for (EntityAnnotation annotation : res.getTextAnnotationsList()) {
		        	description = annotation.getDescription();
		        	System.out.printf("description---"+description);
		        	break;
		        }
		      }
		    }
		return description;
		
	}

}
