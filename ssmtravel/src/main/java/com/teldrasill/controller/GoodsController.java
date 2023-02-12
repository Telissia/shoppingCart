package com.teldrasill.controller;

import com.teldrasill.pojo.Goods;
import com.teldrasill.service.GoodsService;
import com.teldrasill.service.GoodsTypeService;
import com.teldrasill.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/goods")
public class GoodsController
{
    //controller调用service层
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private GoodsTypeService goodsTypeService;

    //查询商品列表
    @RequestMapping("/allGoods")
    public String list(Model model,Integer pageCur)
    {
        List<Goods> list = goodsService.queryAllGoods();
        int temp = list.size();
        model.addAttribute("totalCount", temp);
        int totalPage = 0;
        if (temp == 0) {
            totalPage = 0;//总页数
        } else {
            //返回大于或者等于指定表达式的最小整数
            totalPage = (int) Math.ceil((double) temp / 10);
        }
        if (pageCur == null) {
            pageCur = 1;
        }
        if ((pageCur - 1) * 10 > temp) {
            pageCur = pageCur - 1;
        }
        //分页查询
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startIndex", (pageCur - 1) * 10);//起始位置
        map.put("perPageSize", 10);//每页10个
        list = goodsService.selectAllGoodsByPage(map);
        model.addAttribute("list", list);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("pageCur", pageCur);
        return "allGoods";
    }
    //跳转添加商品页面
    @RequestMapping("/toAddGoods")
    public String toAddGoods(Model model)
    {
//        model.addAttribute("goods",new Goods());
        model.addAttribute("goodsType",goodsTypeService.queryAllGoodsType());
        return "addGoods";
    }

    //添加商品的请求
    @PostMapping("/addGoods")
    public String AddGoods(Goods goods, Model model, HttpServletRequest request, @RequestParam("logoImage") MultipartFile multipartFile) throws IOException
    {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        goods.setGpicture(fileName);

        String uploadDir = "/travel-logos/" + MyUtil.getStringID();

        Path uploadPath = Paths.get(uploadDir);

        if(!Files.exists(uploadPath))
        {
            Files.createDirectories(uploadPath);
        }

        try(InputStream inputStream = multipartFile.getInputStream())
        {
            Path filePath = uploadPath.resolve(fileName);
            System.out.println(filePath.toFile().getAbsolutePath());
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        }
        catch (IOException e)
        {
            throw new IOException("Could not save upload file: " + fileName);
        }

        /*//防止文件产生重复，错误覆盖
        //文件新名
        String newfileName = "";
        //得到上传原本文件名
        String fileName = goods.getLogoImage().getOriginalFilename();
        if(fileName.length() > 0)
        {
            //得到文件扩展名
            String fileType = fileName.substring(fileName.indexOf("."));//.jpg
            //赋值新文件名
            newfileName = MyUtil.getStringID() + fileType;

            goods.setGpicture(newfileName);//只读写文件名，再去找文件
            String realPath = "D:\\Environment\\idea\\Logos";
            //String realPath = request.getServletContext().getRealPath("logos");
            System.out.println(realPath);
            File targetFile = new File(realPath, newfileName);
            if(!targetFile.exists())
            {
                targetFile.mkdirs();
                //创建多级目录
            }
            try {
                goods.getLogoImage().transferTo(targetFile);
            } catch (IllegalStateException | IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        System.out.println("addgoods>=" + goods);*/
        goodsService.addGoods(goods);
        return "redirect:/goods/allGoods";
        //请求复用，重定向请求到allGoods
    }

    @RequestMapping("/selectAGoods")
    public String selectAGoods(Model model, Integer id){
        Goods goods = goodsService.queryGoodsById(id);
        model.addAttribute("goodsType",goodsTypeService.queryAllGoodsType());
        model.addAttribute("goods",goods);
        return "goodsDetail";
    }
}
