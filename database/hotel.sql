DROP TABLE IF EXISTS admin;
DROP TABLE IF EXISTS dinnerTable;
DROP TABLE IF EXISTS foodType;
DROP TABLE IF EXISTS food;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS orderDetail;
DROP TABLE IF EXISTS tableDetail;

-- 1.用户表
CREATE TABLE users(
	id VARCHAR(32) PRIMARY KEY NOT NULL, -- 主键
	userName VARCHAR(20),    -- 姓名
	account VARCHAR(20),	-- 账号
	role VARCHAR(20),	-- 角色
	mobile VARCHAR(20),	-- 电话
	pwd VARCHAR(100),      -- 密码
	address	VARCHAR(20)	-- 地址
);



-- 2. 餐桌表
CREATE TABLE dinnerTable(
   id VARCHAR(32) PRIMARY KEY NOT NULL,  -- 餐桌主键
   tableName VARCHAR(20) NOT NULL	  -- 餐桌名
 
);


-- 3. 餐桌明细表
CREATE TABLE tableDetail(
   id VARCHAR(32) PRIMARY KEY NOT NULL,  -- 主键
   table_id VARCHAR(32) NOT NULL,	 -- 餐桌编号
   eatDate VARCHAR(40)   NOT NULL        -- 就餐时间
);


-- 4. 菜类别表
CREATE TABLE foodType(
    id VARCHAR(32) PRIMARY KEY NOT NULL,  -- 类别主键
    typeName VARCHAR(20) NOT NULL	-- 类别名称
);


-- 5. 菜品种表
CREATE TABLE food(
  id VARCHAR(32) PRIMARY KEY NOT NULL,  -- 主键
  foodName VARCHAR(20) NOT NULL,	 -- 菜名称
  foodType_id VARCHAR(32) NOT NULL, 	 -- 所属菜系, 外键字段
  price DOUBLE NOT NULL,		 -- 价格
  mprice DOUBLE NOT NULL,		 -- 会员价格
  remark VARCHAR(200) NOT NULL,		 -- 简介
  img VARCHAR(100) NOT NULL		 -- 图片
);


-- 6. 订单表      (订单基本信息)
CREATE TABLE orders(
   id VARCHAR(32) PRIMARY KEY NOT NULL,  -- 主键
   table_id VARCHAR(32) NOT NULL,	-- 外键： 餐桌编号
   eatDate  VARCHAR(40) NOT NULL,	-- 就餐时间
   orderDate DATETIME,		       -- 下单日期
   totalPrice DOUBLE,		       -- 订单所有菜需要的总金额
   orderStatus INT DEFAULT 0,           -- 订单状态： 0,未结账； 1,已结账
   user_id VARCHAR(32)	               -- 外键： 用户编号
);

-- 7. 订单明细表  (主要是菜品种)
CREATE TABLE orderDetail(
   id VARCHAR(32) PRIMARY KEY NOT NULL,  -- 主键
   orderId VARCHAR(32) NOT NULL,	-- 外键：引入的是订单表的主键
   food_id VARCHAR(32) NOT NULL,	-- 外键：引用的是菜信息表的主键
   foodCount INT NOT NULL               -- 菜的数量
   
);

-- 餐桌明细表： 与餐桌表的关系
ALTER TABLE tableDetail ADD CONSTRAINT fk_tableDetail_table_id FOREIGN KEY(table_id) REFERENCES dinnertable(id) ON DELETE RESTRICT ON UPDATE RESTRICT;
-- 添加菜品与菜类别的关系约束
ALTER TABLE food ADD CONSTRAINT fk_food_foodType_id FOREIGN KEY(foodType_id) REFERENCES foodType(id) ON DELETE RESTRICT ON UPDATE RESTRICT;
-- 订单表： 与餐桌表的关系
ALTER TABLE orders ADD CONSTRAINT fk_order_table_id FOREIGN KEY(table_id) REFERENCES dinnertable(id) ON DELETE RESTRICT ON UPDATE RESTRICT;
-- 订单表： 与用户表的关系
ALTER TABLE orders ADD CONSTRAINT fk_order_users_id FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE RESTRICT ON UPDATE RESTRICT;
-- 订单明细： 与订单表的关系
ALTER TABLE orderDetail ADD CONSTRAINT fk_orderDetail_order_id FOREIGN KEY(orderId) REFERENCES orders(id) ON DELETE RESTRICT ON UPDATE RESTRICT;
-- 订单明细： 与菜信息的关系
ALTER TABLE orderDetail ADD CONSTRAINT fk_orderDetail_food_id FOREIGN KEY(food_id) REFERENCES food(id) ON DELETE RESTRICT ON UPDATE RESTRICT;
