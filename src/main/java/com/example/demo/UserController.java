package com.example.demo;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users", produces = "application/json;charset=UTF-8")
public class UserController {
    @Autowired
    IUserService userService;

    /**
     * 支持分页参数 pageNo，pageSize。例如：/users?pageNo=1,pageSize=50
     * 如果不传则有默认值pageNo=1，pageSize=20
     *
     * @return
     */
    @GetMapping
    public ResponseData<Page<User>> page(@RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
                             @RequestParam(value = "pageSize", defaultValue = "20") int pageSize) {
        Page<User> userPage = userService.page(new Page<User>(pageNo, pageSize), new QueryWrapper<User>());
        return new ResponseData<>(userPage,0,"");
    }

    @GetMapping("/{id}")
    public ResponseData<User> getOne(@PathVariable long id) {
        User user = userService.getById(id);
        return new ResponseData<>(user,0,"");
    }

    @PostMapping
    public ResponseData<User> insertOne(@RequestBody User user) {
        boolean flag = userService.save(user);
        if (!flag) {
            return new ResponseData<>(-1,"插入失败");
        }
        return new ResponseData<>(user,0,"");
    }

    @PostMapping("/batch")
    public ResponseData<List<User>> insertOrUpdate(@RequestBody List<User> userList) {
        boolean flag = userService.saveOrUpdateBatch(userList);
        if (!flag) {
            return new ResponseData<>(-1,"插入失败");
        }
        return new ResponseData<>(userList,0,"");
    }

    @PutMapping("/{id}")
    public ResponseData<User> updateOne(@PathVariable Long id,
                                  @RequestBody User user) {
        user.setId(id);
        boolean flag = userService.updateById(user);
        if (!flag) {
            return new ResponseData<>(-1,"更新失败");
        }
        return new ResponseData<>(user,0,"");
    }

    @DeleteMapping("/{id}")
    public ResponseData<String> deleteOne(@PathVariable Long id) {
        boolean flag = userService.removeById(id);
        if (!flag) {
            return new ResponseData<>(-1,"删除失败");
        }
        return new ResponseData<>("",0,"");
    }
}
