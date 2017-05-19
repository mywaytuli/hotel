-- �������ݿ�
CREATE DATABASE hotel CHARACTER SET utf8;
USE hotel;


drop table if exists admin;
drop table if exists dinnerTable;
drop table if exists foodType;
drop table if exists food;
drop table if exists orders;
drop table if exists orderDetail;

-- 1.�û���
CREATE TABLE users(
	id VARCHAR(32) PRIMARY KEY NOT NULL, -- ����
	userName VARCHAR(20) NOT NULL,    -- ����
	account VARCHAR(20) NOT NULL,	--�˺�
	role VARCHAR(20) NOT NULL,	--��ɫ
	mobile VARCHAR(20) NOT NULL,	--�绰
	pwd VARCHAR(100) NOT NULL,      -- ����
	address	VARCHAR(20) NOT NULL	--��ַ
);



-- 2. ������
CREATE TABLE dinnerTable(
   id varchar(32) PRIMARY KEY NOT NULL,  -- ��������
   tableName VARCHAR(20) NOT NULL	  -- ������
 
);


-- 3. ������ϸ��
CREATE TABLE tableDetail(
   id VARCHAR(32) PRIMARY KEY NOT NULL,  -- ����
   table_id VARCHAR(32) NOT NULL,	 -- �������
   eatDate VARCHAR(40)   NOT NULL        -- �Ͳ�ʱ��
);


-- 4. ������
CREATE TABLE foodType(
    id varchar(32) PRIMARY KEY NOT NULL,  -- �������
    typeName VARCHAR(20) NOT NULL	-- �������
);


-- 5. ��Ʒ�ֱ�
CREATE TABLE food(
  id varchar(32) PRIMARY KEY NOT NULL,  -- ����
  foodName VARCHAR(20) NOT NULL,	 -- ������
  foodType_id VARCHAR(32) NOT NULL, 	 -- ������ϵ, ����ֶ�
  price DOUBLE NOT NULL,		 -- �۸�
  mprice DOUBLE NOT NULL,		 -- ��Ա�۸�
  remark VARCHAR(200) NOT NULL,		 -- ���
  img VARCHAR(100) NOT NULL		 -- ͼƬ
);


-- 6. ������      (����������Ϣ)
CREATE TABLE orders(
   id varchar(32) PRIMARY KEY NOT NULL,  -- ����
   table_id VARCHAR(32) NOT NULL,	-- ����� �������
   eatDate  VARCHAR(40) NOT NULL,	--�Ͳ�ʱ��
   orderDate DATETIME,		       -- �µ�����
   totalPrice DOUBLE,		       -- �������в���Ҫ���ܽ��
   orderStatus INT DEFAULT 0,           -- ����״̬�� 0,δ���ˣ� 1,�ѽ���
   user_id VARCHAR(32)	               -- ����� �û����
);

-- 7. ������ϸ��  (��Ҫ�ǲ�Ʒ��)
CREATE TABLE orderDetail(
   id varchar(32) PRIMARY KEY NOT NULL,  -- ����
   orderId VARCHAR(32) NOT NULL,	-- �����������Ƕ����������
   food_id VARCHAR(32) NOT NULL,	-- ��������õ��ǲ���Ϣ�������
   foodCount INT NOT NULL               -- �˵�����
   
);

-- ������ϸ�� �������Ĺ�ϵ
ALTER TABLE tableDetail ADD CONSTRAINT fk_tableDetail_table_id FOREIGN KEY(table_id) REFERENCES dinnertable(id) on delete restrict on update restrict;
-- ��Ӳ�Ʒ������Ĺ�ϵԼ��
ALTER TABLE food ADD CONSTRAINT fk_food_foodType_id FOREIGN KEY(foodType_id) REFERENCES foodType(id) on delete restrict on update restrict;
-- ������ �������Ĺ�ϵ
ALTER TABLE orders ADD CONSTRAINT fk_order_table_id FOREIGN KEY(table_id) REFERENCES dinnertable(id) on delete restrict on update restrict;
-- ������ ���û���Ĺ�ϵ
ALTER TABLE orders ADD CONSTRAINT fk_order_users_id FOREIGN KEY(user_id) REFERENCES users(id) on delete restrict on update restrict;
-- ������ϸ�� �붩����Ĺ�ϵ
ALTER TABLE orderDetail ADD CONSTRAINT fk_orderDetail_order_id FOREIGN KEY(orderId) REFERENCES orders(id) on delete restrict on update restrict;
-- ������ϸ�� �����Ϣ�Ĺ�ϵ
ALTER TABLE orderDetail ADD CONSTRAINT fk_orderDetail_food_id FOREIGN KEY(food_id) REFERENCES food(id) on delete restrict on update restrict;
