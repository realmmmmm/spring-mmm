package com.mvc.io.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 *  上传文件
 *  常用方法：
 *  String getOriginalFilename()：获取上传文件的原名
 *  InputStream getInputStream()：获取文件流
 *  void transferTo(File dest)：  将上传文件保存到一个目录文件中
 */
@Controller
public class UploadingController {

    @GetMapping("/home")
    public String home(){
        return "/home/list";
    }

    // 批量上传CommonsMultipartFile则为数组即可
    @PostMapping("/uploading")
    public String uploading(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request){

        System.out.println(file);
        //获取文件名 : file.getOriginalFilename();
        String uploadFileName = file.getOriginalFilename();

        //如果文件名为空，直接回到首页！
        if ("".equals(uploadFileName)){
            System.out.println("名字为空 : ");
            return "redirect:/home";
        }
        System.out.println("上传文件名 : "+uploadFileName);
        //上传路径保存设置
        String path = request.getServletContext().getRealPath("/upload");
        System.out.println(path);
        //如果路径不存在，创建一个
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }

        //文件输入流
        InputStream is = null;
        try {
            is = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //文件输出流
        OutputStream os = null;
        try {
            os = new FileOutputStream(new File(realPath,uploadFileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //读取写出
        int len=0;
        byte[] buffer = new byte[1024];
        while (true){
            try {
                if (!((len = is.read(buffer))!=-1)) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                os.write(buffer,0,len);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                os.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/transpond";
    }


    /*
     * 采用file.Transto 来保存上传的文件
     */
    @RequestMapping("/upload2")
    @ResponseBody
    public String  fileUpload2(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) throws IOException {

        //上传路径保存设置
        String path = request.getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        //上传文件地址
        System.out.println("上传文件保存地址："+realPath);

        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(new File(realPath +"/"+ file.getOriginalFilename()));

        return "保存成功";
    }


    /**
     *  下载文件
     *  1、设置 response 响应头
     *  2、读取文件 -- InputStream
     *  3、写出文件 -- OutputStream
     *  4、执行操作
     *  5、关闭流 （先开后关）
     */
    @GetMapping("/download")
    @ResponseBody
    public String downloads(HttpServletResponse response , HttpServletRequest request) throws Exception{
        //要下载的图片地址
        String  path = request.getServletContext().getRealPath("/upload");
        String  fileName = "a.txt";

        //1、设置response 响应头
        response.reset(); //设置页面不缓存,清空buffer
        response.setCharacterEncoding("UTF-8"); //字符编码
        response.setContentType("multipart/form-data"); //二进制传输数据
        //设置响应头
        response.setHeader("Content-Disposition",
                "attachment;fileName="+ URLEncoder.encode(fileName, "UTF-8"));

        File file = new File(path,fileName);
        //2、 读取文件--输入流
        InputStream input=new FileInputStream(file);
        //3、 写出文件--输出流
        OutputStream out = response.getOutputStream();

        byte[] buff =new byte[1024];
        int index=0;
        //4、执行 写出操作
        while((index= input.read(buff))!= -1){
            out.write(buff, 0, index);
            out.flush();
        }
        out.close();
        input.close();
        return "ok";
    }

}
