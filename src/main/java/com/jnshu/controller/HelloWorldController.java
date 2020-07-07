package com.jnshu.controller;

import com.jnshu.pojo.Student;
import com.jnshu.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/** HelloWorldController是一个基于注解的控制器,
 *  可以同时处理多个请求动作，并且无须实现任何接口。
 *  org.springframework.stereotype.Controller注解用于指示该类是一个控制器
 */
@Controller
@RequestMapping(value = "student")
public class HelloWorldController {

    @Autowired(required=false)
    StudentService studentService;

    private static final Logger log = LogManager.getLogger(HelloWorldController.class);

    //查询所有学生
    @RequestMapping(method = RequestMethod.GET)
    public String findAll(Model model) {

        List<Student> list = studentService.findAllStudent();

        System.out.println("查询结果为" + list);
        log.info(list);

        model.addAttribute("list",list);

        System.out.println("查询成功！！");
        return "allstudent";
    }

    //--------------------------------------------通过id更改一个学员的姓名------------------------------------------------------------------

//get方法跳转表单

    //    先通过要修改学员的id，  获取所有信息
    @RequestMapping(value = "/up/{id}", method = RequestMethod.GET)
    public ModelAndView put(@PathVariable("id") long id) {
        ModelAndView mv = new ModelAndView();
        Student student = studentService.findStudentById(id);
        mv.addObject("s",student);
        mv.setViewName("forput");
        return mv;
    }


    //表单提交后跳转到此处
    @RequestMapping(value = "/update")
    public ModelAndView update(Student student) {

        ModelAndView mv = new ModelAndView();

        studentService.updateStudent(student);

        mv.setViewName("redirect:/student");

        return mv;
    }




    //    ------------------------------------以下是关于删除的代码---------------------------------------

    //    提交删除按钮
    @RequestMapping(value = "/delete/{id}")
    public ModelAndView deleteid(@PathVariable(value = "id") long id) {
        ModelAndView mv = new ModelAndView();

        studentService.deleteStudent(id);
        System.out.print("要删除的用户id为：" +id);
        log.info("要删除的用户id为：" +id);

        mv.setViewName("redirect:/student");
        System.out.print("删除成功");
        return mv;
    }

    //   --------------------- 以下部分是增加学员，先用get跳转到表单，然后在表单里提交post-----------------------------

    //get方法跳转表单
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView add() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("forpost");
        return mv;
    }

//    //表单提交后跳转到此处
//    @RequestMapping(value = "/addstudent", method = RequestMethod.POST)
//    public ModelAndView insertStudent(Student student) {
//        ss.insertStudent(student);
//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("redirect:/student/AllPage");
//        return mv;
//    }
//
//

    @RequestMapping(value = "/addstudent",method = RequestMethod.POST)

//   使用@validated注解  对student数据进行校验
//   如果有错误，将student的校验错误，传入到BindingResult里
    public ModelAndView addStudent(@Validated Student student,
                                   BindingResult error) throws Exception {
        ModelAndView mav = new ModelAndView();
        if (error.hasErrors()) {

//            error.getFieldError()获取错误信息
//            这段代码的含义是获取错误内容的  默认message的信息（message=xxx）

            String message = error.getFieldError().getDefaultMessage();
            throw new Exception(message);

        }
        studentService.insertStudent(student);
        mav.setViewName("redirect:/student");
        return mav;
    }


//----------------------------------------查询------------------------------------------------
/*
    //    //通过id查询学生
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView findid(@PathVariable(value = "id") int id) {

        System.out.println("本次查询的学员id为" + id);
        log.info(id);

        Student student = studentService.findStudentById(id);
        System.out.println("查询结果为" + student);
        log.info(student);

        ModelAndView mv = new ModelAndView("studentid");
        mv.addObject("student", student);

        System.out.println("查询成功！！");
        return mv;
    }*/
    //----------------------------------------分页的代码------------------------------------------------

/*
    @RequestMapping(value = "/AllPage",method = RequestMethod.GET)
    //传入 当前页数数据   初始（defaultValue）为1
    public String  AllPage (Model model , @RequestParam(value = "pageNow",defaultValue = "1")int pageNow){

        log.info(pageNow);

//        第1个是从0起，查询10条数据         第2个是从10起，查询10个
        List<Student> pagelist = studentService.studentPage((pageNow-1)*10,10);

        log.info(pagelist);
//        查询所有的页数
        int allRow = studentService.selectCount();

//        定义一个  上一页
        int prePage;

//        如果当前页 减去1 大于 0     上一页等于当前页-1 （防止第一页再减一）
//        否则还是当前页
        if (pageNow - 1 > 0) {
            prePage = pageNow - 1;
        } else {
            prePage = pageNow;
        }

//        定义一个  每页显示的条数 为10
        int pageSize = 10;

//        最后一页    =     所有的条数  %  10 （求余数）
//        如果余数的值为0      所有的条数/10
//        如果余数的值不为0    所有的条数/10    再+1

        int totalPages = allRow % pageSize == 0 ? allRow / pageSize : allRow / pageSize + 1;
//
//        （假设总页数为23   则运行后跳到第3页，      因为23就在第3页（每页显示10个））

//        定义一个下一页
        int nextPage;

//        如果当前页小于最终页       下一页 = 当前页+1     否则 下一页还等于当前页  （目的：到最后一页不动，返回当前页）
        if ( pageNow <totalPages) {
            nextPage = pageNow+1;
        } else {
            nextPage = pageNow ;
        }

//        当前页
        model.addAttribute("pageNow", pageNow);
        System.out.print(pageNow);
//        上一页
        model.addAttribute("prePage", prePage);
        System.out.print(prePage);
//        查询到的  x条起   查询10条学生数据
        model.addAttribute("pagelist", pagelist);
        System.out.print(pagelist);
//        下一页
        model.addAttribute("nextPage", nextPage);
        System.out.print(nextPage);
//        最后一页
        model.addAttribute("totalPages", totalPages);
        System.out.print(totalPages);

        return "allpages";
    }*/

}

