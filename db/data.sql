-- 插入数据
insert into product_category(category_id, category_name, category_type) values (1, '热销榜', 2);

insert into product_category(category_id, category_name, category_type) values (6, '女生最爱', 3);

insert into product_category(category_id, category_name, category_type) values (8, '男生专享', 4);

insert into product_info(product_id, product_name, product_price, product_stock, product_description, product_icon, product_status, category_type) values('123456','皮蛋粥',3.2,100,'很好吃', 'image.imooc.com/1.jpg',0,2);

insert into product_info(product_id, product_name, product_price, product_stock, product_description, product_icon, product_status, category_type) values('123457','皮皮虾',3.2,100,'很好吃', 'image.imooc.com/2.jpg',0,2);

insert into order_master(order_id, buyer_name, buyer_phone, buyer_address, buyer_openid, order_amount, order_status, pay_status) values('12367', '师兄','13860138600','慕课网总部','1101110',2.5,0,0);

insert into order_detail(detail_id, order_id, product_id, product_name, product_price, product_quantity, product_icon) values('12367', '123456','157875196366160022','皮蛋粥',0.01,2,'http://xxx.com');
