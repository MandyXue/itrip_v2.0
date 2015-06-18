package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by AngelYang on 2015/6/10.
 */
@WebServlet(name = "UploadServlet", urlPatterns = {"/upload"})
@MultipartConfig
public class UploadController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String path = this.getServletContext().getRealPath("/");//获取服务器地址
        Part p = request.getPart("file1");                      //获取用户选择上传文件
        if (p.getContentType().contains("image")) {             //处理图象文件
            String fname1 = p.getSubmittedFileName();           //获取文件名
            int path_idx = fname1.lastIndexOf("\\") + 1;          //截取文件名
            String fname2 = fname1.substring(path_idx, fname1.length());
            p.write(path + "/upload/" + fname2);                  //写入web根路径下的upload文件夹中

            out.write("文件上传成功");
        } else {
            out.write("请选择图片文件！！！");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
