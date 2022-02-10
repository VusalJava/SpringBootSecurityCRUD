package com.example.springbootcrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
Переименовать пакет domain в model+
Класс User equals hashcode должны использовать поля id login(только id и login?)+
Класс Role equals hashcode должен использовать id name+
При нажатии на кнопку delete не отправляется запрос на admin/{id} DELETE. Посмотри свой код на фронте, там проблема +
WebSecurityConfig используй BCryptPasswordEncoder+
Создать RoleService & RoleServiceImpl и вынести туда методы работы с ролями из UserService.+
Все урлы привести к единому типу /admin/user/edit/{userId} /admin/user/delete/{userId} /admin/user/add +
 Дополнительно прочитать про принипы SOLID и объяснить какой принцип в этом пункте ты нарушил.
Класс User связь roles использовать fetchType LAZY(почему не EAGER?)
Класс Role (опционально) связь users вообще не нужно. Зачем хранить в ролях юзеров???(я их использовал для удаления)
Если используешь JpaRepository, прочитай про его встроенные методы в частности необязательно писать @Query над методом, если это поиск по полю. Тут сам разберись.
UserController метод showUser приводи Principal сразу к User, зачем обращаться в бд???
*/

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", required = false,defaultValue = "World") String name, Model model){
        model.addAttribute("name",name);

        return "users/hello";
    }

}
