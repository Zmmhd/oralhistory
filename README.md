# oralhistory
大创项目——口述历史
# Controller说明

都返回ResponseEntity对象

## 一、NoticeController
统一开头("/notice")

### 1. addNotice() @PostMapping("/add")
新增一个notice

需要传过来一个notice实体

addNotice(@RequestBody Notice notice)


### 2.deleteNotice()  @DeleteMapping("/delete/{id}")
删除

用地址传id即可

deleteNotice(@PathVariable("id") Integer id)


### 3.getBytype()  @GetMapping("/getbytype/{type}")
通过公告类型获取公告列表

用地址传type

getBytype(@PathVariable("type") Integer type)

## 二、 ResourceController
统一开头("/resource")

### 1.getAll()  @GetMapping("/get")
获得全部资源列表

### 2.query() @GetMapping("/query")
对title模糊查询

对其他的三个参数直接查询

若String类型的参数为空串就默认不使用，int为0默认不使用。

    public  ResponseEntity query(@RequestParam String title,
                                 @RequestParam Integer type,
                                 @RequestParam String province,
                                 @RequestParam String theme)


## 三、ReviewController
统一("/review")

### 1.addReview  @PostMapping("/add")
增加一个审核对象

addReview(@RequestBody Review review)

### 2.getByStatus  @GetMapping("/getbystatus/{status}")
通过审核状态查询

getByStatus(@PathVariable Integer status)

### 3.likeTitle  @GetMapping("/titlelike/{title}")
通过标题模糊查询审核对象列表

### 4.likeUpnumber   @GetMapping("/upernumberlike/{upernumber}")
通过上传者手机号查询审核对象列表


### 5.update()  @PutMapping("/update/{id}")
通过id查询审核对象再对其修改

要用地址传id，再键值对匹配传review实体

    public ResponseEntity update(@PathVariable Integer id,
                                 @RequestBody Review review)




