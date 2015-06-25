package controller;

import entity.UploadEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * Created by AngelYang on 2015/6/12.
 */
@WebServlet(name = "UploadServlet",urlPatterns = {"/upload"})
@MultipartConfig
public class UploadController extends HttpServlet {

    private EntityManagerFactory emf;

    @Override
    public void init() throws ServletException {
        super.init();
        emf= Persistence.createEntityManagerFactory("ProjectPU");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String type=request.getParameter("type");
        String spotfood=request.getParameter("spotfood");
        String dsp=request.getParameter("description");
        String description= new String(dsp.getBytes("ISO-8859-1"),"UTF-8");//对乱码进行处理

        request.setAttribute("type",type);
        request.setAttribute("spotfood",spotfood);

        //Get Image File
        String path = request.getSession().getServletContext().getRealPath("/");//获取服务器地址
        Part p = request.getPart("file1");                      //获取用户选择上传文件
        if (p.getContentType().contains("image")) {             //处理图象文件
            String fname1 = p.getSubmittedFileName();           //获取文件名
            int path_idx = fname1.lastIndexOf("\\") + 1;        //截取文件名
            String fname2 = fname1.substring(path_idx, fname1.length());
            p.write(path+"/upload/"+fname2);                              //写入web根路径下的upload文件夹中


            //Save
            EntityManager em=emf.createEntityManager();
            HttpSession session=request.getSession();
            String username= (String) session.getAttribute("userId");
            UploadEntity uploadEntity=new UploadEntity(username,spotfood,fname2,description);
            em.getTransaction().begin();
            em.persist(uploadEntity);
            em.getTransaction().commit();
            request.setAttribute("upload","success");

            request.getRequestDispatcher("WEB-INF/jsp/uploadsuccess.jsp").forward(request,response);
        } else {
            request.setAttribute("upload","fail");
            request.getRequestDispatcher("WEB-INF/jsp/uploadfail.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
