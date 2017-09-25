package cn.smbms.units;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

/**
 * util type of FileUpLoad needed springmvc and apache log4j
 * @author SuLiang
 *
 */
public class FileUpLoadSpring {
	private Logger log = Logger.getLogger(this.getClass());
	private List<String> pathArray = null;

	public List<String> getPathArray() {
		return pathArray;
	}

	public void setPathArray(List<String> pathArray) {
		this.pathArray = pathArray;
	}

	public boolean fileUpLoad(MultipartFile[] attachs,
			HttpServletRequest request) {
		boolean status = true;
		for (int i = 0; i < attachs.length; i++) {

			if (!attachs[i].isEmpty()) {
				// �����ϴ�Ŀ��·��
				String path = request.getSession().getServletContext()
						.getRealPath(
								"statics" + File.separator + "uploadFiles");
				log.info("uploadFile path ========== >" + path);
				// ԭ�ļ���
				String oldFileName = attachs[i].getOriginalFilename();
				log.info("uploadFile oldFileName ========== >" + oldFileName);
				// �ļ���չ��(��׺)
				String suffix = FilenameUtils.getExtension(oldFileName);
				log.debug("uploadFile suffix ========== >" + suffix);
				// �ļ��ϴ�����ֽ�
				int fileSize = 500000;
				log.debug("uploadFile size textual " + fileSize);
				if (attachs[i].getSize() > fileSize) {
					request.setAttribute("uploadFileError", "�ϴ��ļ���С���ó���500KB");
					status = false;
					break;
				} else if ("/jpg/png/jpeg/pneg".indexOf("/" + suffix) != -1) {
					// ��������ļ���
					String fileName = System.currentTimeMillis()
							+ RandomUtils.nextInt(0, 1000000) + "_Personal.jpg";
					log.debug("new fileName ========== >" + fileName);
					// Ŀ���ļ�
					File targetFile = new File(path, fileName);
					if (!targetFile.exists())
						targetFile.mkdirs();
					try {
						// ������Ŀ���ļ�
						attachs[i].transferTo(targetFile);
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					pathArray.set(i, path + File.separator + fileName);
				} else {
					request.setAttribute("uploadFileError", "* �ϴ�ͼƬ��ʽ����ȷ!");
					status = false;
					break;
				}

			}

		}

		return status;
	}

}
