## SQL通配符 ##

> sql通配符必须和`like`一起使用

### 通配符 ###

- `%`: 代替一个或多个字符

- `_`: 仅代替一个字符

- `[charlist]`: 字符列中的任意单一字符

- `[^charlist]`/`[!charlist]`: 不在字符列中的任意单一字符


### 示例 ###

- `select * from student where name like 'su%';`

    查询以su开头的学生

- `select * from student where name like 's_l%';`

    查询以s,任意单字符，l开头的学生

- `select * from student where name like '[su]%';`

    查询以s或u开头的学生

- `select * from student where name like '[^su]%';`

    查询不以s开头或者不以u开头的学生



### 限制符 ###

- any: a.c>any b.c a与b中值比较，一个满足返回true

- all: a.c>all b.c a与b中值比较，必须全满足才返回true

- union: 联合两个表的记录，同时去除重复行，全返回用union all


### 关联查询 ###

- where: 无法区分关联条件和过滤条件等

- on: 可以区分关联条件和过滤等，必须写全表名

- using: 可以区分关联条件和过滤等，对于相同字段无需写出表名

> 当然where 不能用于内连接和外连接


### 注意 ###
 - 对于用户需要使用的变量跟关键字和保留字重名，需要加引号

 - 可以使用数组形式比较(a,b)=(select a,b ......)

### 高级查询 ###

- in/not in: a in (),a在后者的范围内即可,类似any;反之同理可得

- exists/not exists: 后者有返回行，执行前者，否者不执行前者；反之同理可得

- group by: 对查询结果分组

- having: 对分组进行筛选

### 连接表 ###

- inner join on/join on: 内连接，内连接自己不需要on

- left/right outer join on: 外连接，outer可省略

- join(A,B,...): 内连接多表

>limit n1,n2: n1为位置偏量,从0开始,n2为记录条数


### 对于'',""的使用 ###

- ''等价于""

- 除了关键字和保留字,函数名都可以使用''/""

- 对于需要计算的值不要加'',eg: 3+2!='3+2'



