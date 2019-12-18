# 食堂外卖App
Canteen Takeaway App: Leveraging Spring Boot and Redis

- [项目设计](#项目设计)
    - [技术栈](#技术栈)
    - [模块设计](#模块设计)
    - [数据库设计](#数据库设计)
- [模块化开发](#模块化开发)
    - [买家端：类目](#买家端：类目)
    - [买家端：商品](#买家端：商品)
    - [买家端：订单](#买家端：订单)
    - [卖家端：订单](#卖家端：订单)
    - [卖家端：通用功能和上下架](#卖家端：通用功能和上下架)
    - [卖家端：新增商品和类目](#卖家端：新增商品和类目)
    - [买家端和卖家端联通](#买家端和卖家端联通)
- [联调与部署](#联调与部署)


## 项目设计
### 技术栈
- 前后端分离
    - 前端：Vue -> WebApp
    - 后端：Spring boot -> Bootstrap+Freemarker+JQuery
    - 通信：RESTful
- 技术
    - 数据库：Spring Boot+JPA、Spring Boot+MyBatis
    - 缓存：Spring Boot+Redis（分布式Session、分布式锁）
    - 消息推送：WebSocket
    - 微信：授权登陆、模板消息、微信支付和退款
- 实现：dao+service+controller
- 软件版本：`springboot1.5.2`、centos7.3、IDEA2017.1.2、JDK1.8.0_111、maven3.3.9、mysql5.7.17、nginx1.11.7、Redis3.2.8
- 部署架构
    - 买家、卖家请求Nginx服务器，tomcat服务器，redis+mysql

### 模块设计
- 角色划分
    - 买家（手机端）
    - 卖家（PC端）
- 功能模块划分
    - 商品（商品列表）
    - 订单（创建、查询、取消）
    - 类目（订单管理、商品管理、类目管理）


### 数据库设计
- sql：https://github.com/louisgry/wechat-ordering-system/blob/master/db/table.sql
- 类目表：product_category
- 商品表：product_info
- 订单详情表：order_detail
- 订单主表：order_master
- 卖家信息表：seller_info 

## 模块化开发
### 买家端：类目
- dao
    - dataobject：ProductCategory类目实体类
    - repository：ProductCategoryRepository接口（extends JpaRepository）
        - 根据类目type列表查询类目：`List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);`
- service
    - service：CategoryService接口、CategoryServiceImpl实现类（@Service）
        - 根据categoryId查找类目：`ProductCategory findOne(Integer categoryId);`
        - 查找所有类目：`List<ProductCategory> findAll();`
        - 根据categoryTypeList查找类目：`List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);`
        - 类目插入和修改：`ProductCategory save(ProductCategory productCategory);`

### 买家端：商品
- dao
    - dataobject：ProductInfo商品实体类
    - repository：ProductInfoRepository接口
        - 根据商品状态查询商品信息：`List<ProductInfo> findByProductStatus(Integer productStatus);`
- service
    - service：ProductService接口、ProductServiceImpl类
        - 根据商品id查询商品信息：`ProductInfo findOne(String productId);`
        - 查询所有在架的商品列表：`List<ProductInfo> findUpAll();`
        - 查询所有商品并分页：`Page<ProductInfo> findAll(Pageable pageable);`
        - 修改或新增商品信息：`ProductInfo save(ProductInfo productInfo);`
    - enums：ProductStatusEnum枚举类（给findByProductStatus使用）
        - `UP(0, "在架"), DOWN(1, "下架");`
- controller
    - controller：BuyerProductController类
        - 商品列表（/sell/buyer/product/list）：`public ResultVO list()`
    - vo：ResultVO、ProductVO、ProductInfoVO类
        - ResultVO：code、msg、data
        - ProductVO：name、type、foods（@JsonProperty）
        - ProductInfoVO：id、name、price、description、icon（@JsonProperty）
    - utils：ResultVOUtil类
        - 成功，并返回数据：`public static ResultVO success(Object object)`
        - 成功，返回null：`public static ResultVO success()`
        - 失败，返回错误信息：`public static ResultVO error(Integer code, String msg)`


### 买家端：订单
- dao
    - dataobject：OrderMaster实体类、OrderDetail实体类
    - enums：OrderStatusEnum枚举类、PayStatusEnum枚举类
        - OrderStatusEnum：`NEW(0, "新订单"), FINISHED(1, "完结"), CANCEL(2, "已取消");`
        - PayStatusEnum：`WAIT(0, "等待支付"), SUCCESS(1, "支付成功");`
    - repository：OrderMasterRepository接口、OrderDetailRepository接口
        - OrderMasterRepository：根据买家openid查询订单：`Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);`
        - OrderDetailRepository：根据订单id查询订单详情：`List<OrderDetail> findByOrderId(String orderId);`
- service
    - service：OrderService接口、OrderServiceImpl实现类
        - 创建订单：`OrderDTO create(OrderDTO orderDTO);`
        - 查询单个订单：`OrderDTO findOne(String orderId);`
        - 查询订单列表：`Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);`
        - 查询订单列表：`Page<OrderDTO> findList(Pageable pageable);`
        - 取消订单：`OrderDTO cancel(OrderDTO orderDTO);`
        - 完结订单：`OrderDTO finish(OrderDTO orderDTO);`
        - 支付订单：`OrderDTO paid(OrderDTO orderDTO);`
    - 修改ProductService接口、ProductServiceImpl
        - 加库存：`void increaseStock(List<CartDTO> cartDTOList);`
        - 扣库存：`void decreaseStock(List<CartDTO> cartDTOList);`
    - dto：OrderDTO类（OrderSevice使用）、CartDTO类（加减库存时使用）
    - exception：SellException类
    - enums：ResultEnum枚举类（商品不存在）
    - utils：KeyUtil工具类（生成订单id）
    - converter：OrderMaster2OrderDTOConverter转换器类
    - **service**：BuyerService接口
        - 查询一个订单：`OrderDTO findOrderOne(String openid, String orderId);`
        - 取消订单：`OrderDTO cancelOrder(String openid, String orderId);`
- controller
    - controller：BuyerOrderController类
        - 创建订单（/sell/buyer/order/create）：`public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult)`
        - 订单列表（/sell/buyer/order/list）：`public ResultVO<List<OrderDTO>> list(@RequestParam("openid") String openid, @RequestParam(value = "page", defaultValue = "0") Integer page, @RequestParam(value = "size", defaultValue = "10") Integer size) `
        - 订单详情（/sell/buyer/order/detail）：`public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid, @RequestParam("orderId") String orderId)`
        - 取消订单（/sell/buyer/order/cancel）：`public ResultVO cancel(@RequestParam("openid") String openid, @RequestParam("orderId") String orderId)`
    - form：OrderForm（表单验证）
    - converter：OrderForm2OrderDTOConverter（添加Gson依赖）
    - serializer：Date2LongSerializer
    - dto：修改OrderDTO增加@JsonSerialize（去除时间戳后面多了3个零）、@JsonInclude（detailList为null不返回）