package com.franc1s.springbootswagger3.controller;

import com.franc1s.springbootswagger3.model.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
public class HelloController {

    @GetMapping("/hello")
    @ApiIgnore//忽略文档
    public String hello() {
        return "hello";
    }

    @GetMapping("/user/{id}")
    //@ApiOperation(value = "查询用户",notes = "根据id查询用户")  swagger2 api
    @ApiResponses({
            @ApiResponse(responseCode = "200",description = "请求成功"),
            @ApiResponse(responseCode = "500",description = "请求失败")
    })
    @Operation(summary = "查询用户",description = "根据id查询用户")
    @ApiImplicitParam(paramType = "path",name = "id",value = "用户 id",required = true) //多个参数用ApiImplicitParams
    public String getUserById(@PathVariable Integer id) {
        return "user :" + id;
    }

    @PostMapping("/user")
    public String addUser(@RequestBody User user){
        return user.toString();
    }
}
