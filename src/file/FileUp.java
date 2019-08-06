package file;

import board.PostVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;

public class FileUp {
    private final static String STATIC = "static";
    public static <T> T fileUpload(HttpServletRequest request, String folder, T vo) throws Exception {
        String savePath = request.getServletContext().getRealPath("/") + STATIC + folder;

        MultipartRequest mpr = new MultipartRequest(
                request,savePath,1024 * 1024 * 20, "UTF-8",
                new DefaultFileRenamePolicy());

        if(vo instanceof PostVO){
            ((PostVO) vo).setOriginalfilename(mpr.getOriginalFileName("file"));
            ((PostVO) vo).setFilesystemname(STATIC + folder + "/" + mpr.getFilesystemName("file"));
            ((PostVO) vo).setCategory(Integer.parseInt(mpr.getParameter("category")));
            ((PostVO) vo).setContents(mpr.getParameter("contents"));
        }
        return vo;
    }
}
