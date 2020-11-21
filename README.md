# MonsterAuth
## 设计思路
````
1. 用户实体类定义，dto vo定义
2. 用户服务类 dao接口定义
3. 暂时使用bizhi2的数据库
4. WebSecurityConfigurerAdapter类配置，作用在于密码解码器配置以及配置权限的验证逻辑
5. 自定义UserDetailsService， 重写loadUserByName方法，到数据库查询对于的用户列表
6. 自定义登录校验接口：
   * 构造好AuthenticationToken给AuthenticationManagerBuilder
   * AuthenticationManagerBuilder调用authenticate方法进行认证，这时候重写的loadUserByName方法起到作用了
   * 委托ProviderManager进行认证-》找到一个具体的Provider实现类-》DaoAuthenticationProvider->retrieveUser()->UserDetails loadedUser = this.getUserDetailsService().loadUserByUsername(username);
