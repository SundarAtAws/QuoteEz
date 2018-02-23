package sf.tcs.techfarm.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import sf.tcs.techfarm.utils.ImageToText;

@Controller
public class ImageProcessingController {

	private String filePath;

	@RequestMapping(value = "/welcome")
	public String welcome(HttpServletRequest request) {
		request.getSession().setAttribute("vinDescList", null);
		request.getSession().setAttribute("dlDescList", null);
		request.getSession().setAttribute("VehicleList",null);
		request.getSession().setAttribute("householdDrivers",null);
		return "QuoteEz";
	}

	@RequestMapping(value = "/vinImageToText", method = RequestMethod.POST)
	public String vinImageToText(MultipartHttpServletRequest request) throws IOException, Exception {
		String fileName = storeImages(request);
		String imagepath = filePath + fileName;
		String description = ImageToText.getTextDescription(imagepath);
		description = description.replaceAll("\\s+","");
		buildVINDescInRequest(request, fileName, description);
		return "home";
	}
	
	@RequestMapping(value = "/dlImageToText", method = RequestMethod.POST)
	public String dlImageToText(MultipartHttpServletRequest  request) throws IOException, Exception {
		String fileName = storeImages(request);
		String imagepath = filePath + fileName;
		String description = ImageToText.getTextDescription(imagepath);
		buildDLDescInRequest(request, fileName, description);
		return "home";
	}

	private void buildVINDescInRequest(HttpServletRequest request, String fileName, String description) {
		fileName = fileName.substring(0, (fileName.length()) - 4);
		List<String> vinDescList;
		if (null != request.getSession().getAttribute("vinDescList")) {
			vinDescList = (List<String>) request.getSession().getAttribute("vinDescList");
		} else {
			vinDescList = new ArrayList<String>();
		}
		vinDescList.add(description);
		request.getSession().setAttribute("vinDescList", vinDescList);
	}
	
	private void buildDLDescInRequest(HttpServletRequest request, String fileName, String description) {
		fileName = fileName.substring(0, (fileName.length()) - 4);
		description = isLicenseNumber(description);
		List<String> dlDescList;
		if (null != request.getSession().getAttribute("dlDescList")) {
			dlDescList = (List<String>) request.getSession().getAttribute("dlDescList");
		} else {
			dlDescList = new ArrayList<String>();
		}
		dlDescList.add(description);
		request.getSession().setAttribute("dlDescList", dlDescList);
	}

	private String isLicenseNumber(String description) {
		if (description.contains("DL")) {
			int dlIndex = description.lastIndexOf("DL");
			description = description.substring(dlIndex + 2, dlIndex + 11);
		} else {
			return description;
		}
		return description;
	}

	private String storeImages(MultipartHttpServletRequest  request) throws IOException {
		Iterator<String> itr =  request.getFileNames();
	     MultipartFile mpf = request.getFile(itr.next());
		String fileNamePath = "/files/info.txt";
		ClassLoader classLoader = getClass().getClassLoader();
		File jsonInputFile = new File(classLoader.getResource(fileNamePath).getFile());
		filePath = jsonInputFile.getParent();
		filePath = filePath + "\/";
		if (!mpf.getOriginalFilename().isEmpty()) {
	         BufferedOutputStream outputStream = new BufferedOutputStream(
	               new FileOutputStream(
	                     new File(filePath, mpf.getOriginalFilename())));
	         outputStream.write(mpf.getBytes());
	         outputStream.flush();
	         outputStream.close();
	      }
		return mpf.getOriginalFilename();
	}

}
