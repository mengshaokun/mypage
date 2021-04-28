/*
Navicat MySQL Data Transfer

Source Server         : myserver
Source Server Version : 50568
Source Host           : 106.53.230.76:3369
Source Database       : mypage_qa

Target Server Type    : MYSQL
Target Server Version : 50568
File Encoding         : 65001

Date: 2021-04-28 10:22:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL COMMENT '标题',
  `describe` varchar(400) DEFAULT NULL COMMENT '描述',
  `content` text COMMENT '内容',
  `author` int(10) DEFAULT NULL COMMENT '作者',
  `insert_time` datetime DEFAULT NULL COMMENT '插入时间',
  `update_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='文章表';

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '1', '1', '1', '1', '0000-00-00 00:00:00', '0000-00-00 00:00:00');
INSERT INTO `article` VALUES ('3', '测试', '测测恶恶', '<p>123123</p>', '7', '2019-10-12 15:40:29', null);
INSERT INTO `article` VALUES ('4', 'cccccc', '测试所说的发的是发发发的', '<p>手动阀十分大方撒是暗室逢灯否a</p>', '7', '2019-10-12 16:49:53', null);
INSERT INTO `article` VALUES ('5', '用最浅的命运爱你', '用最浅的命运爱你用最浅的命运爱你用最浅的命运爱你用最浅的命运爱你用最浅的命运爱你', '<p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; color: rgb(85, 85, 85); font-family: &quot;Microsoft Yahei&quot;, sans-serif; letter-spacing: 0.5px; text-align: justify; white-space: normal; background-color: rgb(253, 254, 248);\">&nbsp; &nbsp; &nbsp; &nbsp;所有人都说，最美丽的四月日，我最希望，无论以后如何生活，我都希望即使在旧的开花期，旧的Face，遥不可及，岁月的表情依旧是原始的温度。等待桃子落在化妆品上，等待雨结冰，等待您写给我的信。我的微笑仍挂在我的脸上。当我来阅读您的内容时，请阅读您在眼睛中看到的外观，并偶然地看到您的嘴巴。从那时起，微抬的角度让您望而却步，我的浅笑，乍一看，春天的花朵，宁静而安全。</p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; color: rgb(85, 85, 85); font-family: &quot;Microsoft Yahei&quot;, sans-serif; letter-spacing: 0.5px; text-align: justify; white-space: normal; background-color: rgb(253, 254, 248);\"><br/></p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; color: rgb(85, 85, 85); font-family: &quot;Microsoft Yahei&quot;, sans-serif; letter-spacing: 0.5px; text-align: justify; white-space: normal; background-color: rgb(253, 254, 248);\">&nbsp; &nbsp; &nbsp; 在某个时候，我会责怪时间走得太快，这么多年了，杏花下雨的时间，偶然地变成了梦。打开记忆的章节，仍然停留在特定的章节中，那些叹息是半光滑的，红色的，充满了土地，仿佛宣誓结束的那头，沿着记忆的阴影，一层又一层，然后是一个英寸和一英寸的凉爽，直到变得微弱的悲伤。</p><p style=\"margin-top: 0px; margin-bottom: 0px; padding: 0px; color: rgb(85, 85, 85); font-family: &quot;Microsoft Yahei&quot;, sans-serif; letter-spacing: 0.5px; text-align: justify; white-space: normal; background-color: rgb(253, 254, 248);\">当我厌倦一切时，我会想起你，以为你生活在世界的某个地方，在那里，我愿意忍受一切。你的存在对我很重要。对我来说，最简单的事情是，即使您拒绝我，我也不会抱怨您，但是我不会再与您接近。如果您要我，我会继续努力。从现在开始，我将尽力将其隐藏起来，希望您也是如此。</p><p><br/></p>', '7', '2019-10-12 18:06:32', null);
INSERT INTO `article` VALUES ('10', '阿凡达发放', '爱上发生发射点发顺丰', '<p>案发时放大范德萨发达</p>', '6', '2019-10-14 17:23:12', null);
INSERT INTO `article` VALUES ('11', '11111', '11111111111', '<p>111111111111111111</p>', '6', '2019-10-14 17:23:22', null);
INSERT INTO `article` VALUES ('12', '11111111', '11111111', '<p>1111</p>', '6', '2019-10-14 17:23:59', null);
INSERT INTO `article` VALUES ('13', '2222', '222222', '<p>22222</p>', '6', '2019-10-14 17:24:10', null);
INSERT INTO `article` VALUES ('14', '3333', '33333', '<p>33333333333</p>', '6', '2019-10-14 17:24:24', null);
INSERT INTO `article` VALUES ('16', '123132', '123123', '<p>1231321231wqdadsad</p>', '2', '2020-01-09 17:10:57', null);

-- ----------------------------
-- Table structure for code_library
-- ----------------------------
DROP TABLE IF EXISTS `code_library`;
CREATE TABLE `code_library` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `code_no` varchar(20) NOT NULL,
  `item_no` varchar(20) NOT NULL,
  `item_name` varchar(50) NOT NULL,
  `sort_no` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_codeNo_itemNo` (`code_no`,`item_no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='字典表\r\n';

-- ----------------------------
-- Records of code_library
-- ----------------------------
INSERT INTO `code_library` VALUES ('1', 'status', '1', '可用', '1');
INSERT INTO `code_library` VALUES ('2', 'status', '2', '失效', '2');

-- ----------------------------
-- Table structure for joke
-- ----------------------------
DROP TABLE IF EXISTS `joke`;
CREATE TABLE `joke` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(500) NOT NULL COMMENT '内容',
  `source` tinyint(1) NOT NULL DEFAULT '1' COMMENT '来源 1-糗事百科',
  `created_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=204 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of joke
-- ----------------------------
INSERT INTO `joke` VALUES ('181', '周末饭后无聊。。被老婆拉着一起逛街。路过女士服装 店，老婆非拉我进去看看。卖女士内  衣的小丫头，很卖力的给老婆介绍着新款罩罩，说是戴了这个，不管你是走在路上，还是上班，能让上止八十三，下止手里搀的都能被你吸引的。老婆偷偷的瞄了一眼：妹子你戴了吗？小丫头把胸一挺道：当然戴的，阿姨你没有看到你老公看我那色  迷  迷的眼神吗？？哈哈哈哈，学着点吧，兄弟们！咱一个眼神又省二百多。。。', '1', '2020-07-14 13:21:14');
INSERT INTO `joke` VALUES ('182', '那年，我和同桌林小六逃课去上 网。我爸和林叔去逮我们，他们都怒不可遏却舍不得打，毕竟亲生的呀！他们在网吧门口抽了根烟，很快达成共识:我爸打小六，林叔打楼主！打完后，俩爹相视一笑，皆感叹道:儿子终于不是自己亲生的了，爽 啊……', '1', '2020-07-14 13:21:14');
INSERT INTO `joke` VALUES ('183', '去   .办 .. 正 ！工. 作. 人员是位美女！人很多，排了半天 队，终于到我了，美女却有事出去了！好一会才  回 来 ，然后又 烧 水泡 茶！我闲着没事，拿起手机，打开前置摄像头，玩起了自  .拍！没一会，美女凤 眼圆睁，勃 然大怒的望着我吼:这位大哥，我不就是去了趟 厕 所，回来烧 了 壶水，泡 杯茶 喝 嘛，你就 要给我拍 照，怎么心 眼这么小呢！来来来，手 机 给我把照 片删掉，马上给你.  办，！我……', '1', '2020-07-14 13:21:14');
INSERT INTO `joke` VALUES ('184', '做了个梦，梦见自己想要小魔仙变身器。老爸不答应，说女孩子才玩这个！于是，我求老天爷把我变成女孩，再赐我一个变身器！老天爷答应了…我变成小魔仙，手拿变身器路上遇见老爸。经过他身边时，他抢走了变身器，说道:这个，我儿子喜欢！然后又一棒槌将我打晕拖走，说道:这个，我儿子也喜欢……', '1', '2020-07-14 13:21:14');
INSERT INTO `joke` VALUES ('185', '前天掉了颗牙！说话有点跑风！今天上班时，一位体态丰 满 略胖的美女来送货，我问:你多少 件？美女脸红的说:大哥啊，你是问我多少斤呀？这个怎么好意思说呢？胖点旺 夫！我……!', '1', '2020-07-14 13:21:14');
INSERT INTO `joke` VALUES ('186', '我女儿，总是趁我要吃饭了，她就要窝粑粑了，她啥意思啊？', '1', '2020-07-14 13:21:14');
INSERT INTO `joke` VALUES ('187', '没有零花钱了，跟我老婆去要。咯咯咯……老婆指着地面说:一个俯卧撑一块钱，做多少给多少。我趴下去，断断续续做了半小时，做了600多个！累得满头大汗！在我还想继续做的时候，老婆上来Duang……给我一脚，然后走了……钱还没给我呢……', '1', '2020-07-14 13:21:14');
INSERT INTO `joke` VALUES ('188', '现在流行摆地摊，和媳妇去地摊上淘点便宜货，人山人海呀。我和媳妇手挽着手的，怕走失。媳妇松开手蹲下来挑了一个发夹，起来时竟然顺手挽住了旁边一个大爷的手。我正蒙圈，后面一个大妈咬牙切齿的说道：死老头子，你做初一，别怪我做十五。然后一把挽住我胳膊……', '1', '2020-07-14 13:21:14');
INSERT INTO `joke` VALUES ('189', '儿子的同学问他老师都留啥作业了，作业其实挺多的，三言两语说不清，而且老师已经把作业内容发到家长群里了，所以儿子就跟同学说:问你妈。俩人差点打起来', '1', '2020-07-14 13:21:14');
INSERT INTO `joke` VALUES ('190', '前段时间去见一个糗友婷婷，要脸蛋有脸蛋，要身材有身材。聊着聊着她问我办信.用.卡不？身为房.屋.销.售的我下意识问她买.房不？经过一阵交心的谈话，我办了她的信.用.卡，她买了我的房。现在好了我俩住在了一起，她拿着我办的信.用.卡。还着买.房的房.贷。等等好像哪里不对………', '1', '2020-07-14 13:21:14');
INSERT INTO `joke` VALUES ('191', '早上上班正干活呢，老板过来了，关了我的车床，递支烟给我：你文笔不错，也在报纸上发过文章，能不能写一篇纪实类的，帮厂里宣传一下？我为难的说：我刚来厂里两个月，很多事情都不知道，怕写不好！老板说：没问题！材料我提供给你，写好后交给我，我请朋友帮你送去发表！我答应了。老板又说：不过不能写得太好啊，不然人家都来参观，招待费都出不起！！我拉长了声音说：这种文章我不会写！！老板笑了，压低声音说：厂里准备招一个宣传干事，你看谁合适呢？我的心不争气的狂跳起来，拍着胸脯说：老板放心！保证完成任务！！', '1', '2020-07-14 13:21:14');
INSERT INTO `joke` VALUES ('192', '家里安排相亲，我感觉男孩还行，男孩却一直盯着我看。把我看毛了，刚要开口问，他先说话：你有没有什么生理疾病？我说：没有。他说：骗谁呢？你一直歪着脖子……我说：昨夜我睡落枕了。他不信，非要拉我去他妈妈医院检查。两个小时后，检查结果一切正常！我说：现在你相信我没病了吧？他说：这次相信了，祝你幸福！再见！走了？我检查费就花了好几千块，是不是被他套路了？', '1', '2020-07-14 13:21:14');
INSERT INTO `joke` VALUES ('193', '刚来的同事小张，高大帅气，是我喜欢的类型，因为不在同一部门，所以我也不好意思主动打招呼。那天小张，过来跟我说，手头有点紧，想我支援一下，等发工资就还我！这么好的机会，我怎么会放过？发工资的日子都过了几天了，也不见小张来还钱！正犹豫着呢，只见小张主动过来跟我说，月月，我……我……我喜欢你，的可爱！！我一听害羞的说，小张，我也喜欢你！小张马上摆摆手说，你别误会！我刚给女朋友买了生日礼物，所以只能下次再还你了！', '1', '2020-07-14 13:21:14');
INSERT INTO `joke` VALUES ('194', '在公园散步，累了去凉亭休息下，我看凉亭没人就用外放听歌。一大叔也过来乘凉，听了一会，大叔问我是什么歌，还挺好听的。我告诉大叔这是一首英文歌曲，并用蹩脚的伦敦郊区口音说出了歌名《Yesterday Once More》。大叔复述了我说的歌名：耶稣他爹玩什么？', '1', '2020-07-14 13:21:14');
INSERT INTO `joke` VALUES ('195', '昨晚有个酒局喝到凌晨三点才回来，今天早晨不停的在洗手间干呕，老婆站在门口阴阳怪气的说：哟，这刚出去一晚就怀上别人的种了！  这时候睡眼朦胧的儿子走过来说：爸爸你不要生二胎！听说生二胎屁屁会好疼好疼的！我：我嘞个……………………', '1', '2020-07-14 13:21:14');
INSERT INTO `joke` VALUES ('196', '老婆说他要与我离.  婚，再嫁的话彩礼最少得20W!问我同意吗？心想:这婆娘吓唬谁呢？于是我赌气道:20  W给我明天就去办 手 续！老婆狠狠的说:好， 这 你说的啊！给你！我说的！突然头上被这母 老 虎“啪 ，啪”狠 狠 打 了两下，头懵懵的，母老虎怒吼:给你两 巴 掌！我……', '1', '2020-07-14 13:21:14');
INSERT INTO `joke` VALUES ('197', '一个星期前，帐子里进来几只蚊子，看着吸得圆鼓鼓的肚子，火冒三丈，决定困死蚊子。放下蚊帐，每天检查，看着肚子渐渐干瘪，飞行无力，一种大仇将报的感觉。可就今天，蚊子没了，应该是瘦小了，从窟窿眼跑了。[惊讶][惊讶][惊讶]', '1', '2020-07-14 13:21:14');
INSERT INTO `joke` VALUES ('198', '和媳妇谈恋爱时，她就说喜欢男孩子，以后要生个儿 子。婚后，我们生了个女儿，我是满心欢喜，媳妇却有点不高兴。我安慰道：儿女都一样，再说现在不是开放二 胎了嘛。这不昨天，媳妇又生了，而且是一对双胞胎女儿，站在门外的我乐坏了。怕媳妇不开 心，想安慰她，没想到我还没开口，媳妇撕心裂肺的指着我吼道：你特么上辈子就是个花心渣男！！', '1', '2020-07-14 13:21:14');
INSERT INTO `joke` VALUES ('199', '因病住院了几天，无聊期间开黑玩游戏，队友都比较熟悉，经常开玩笑，他们问我同病房的什么人，我美滋滋的说是一个帅气的小哥哥，偷瞄了小哥哥一眼，他也在偷笑，三个虎队友就开始炸锅了，一致说，睡了他睡了他。。。。我赶紧闭麦打字：\"大哥们我没带耳机啊\"我尴尬的看了小哥哥一眼，他笑了笑说：\"没事的\"  ，那个笑脸瞬间暖化我了[色色的]避免再有这样的事，下午出去买了个耳机，再回来。。。小哥哥神速的出院了[捂脸][捂脸][捂脸]', '1', '2020-07-14 13:21:14');
INSERT INTO `joke` VALUES ('200', '给老公零花钱，为了显示多，换成硬币，从二楼丢给一楼的老公，老公接到两百个硬币都感动哭了，手都接骨折了，疼哭了。。。。', '1', '2020-07-14 13:21:14');
INSERT INTO `joke` VALUES ('201', '老公发视频来，问我洗衣机不是坏了吗，维修师傅来修了没，我说修好了，而且来的是个帅哥呦，挺帅的。老公问，哦？多帅？我想了一下说剑眉星目，猿臂蜂腰的，跟武侠小说里的男主角一样的。然后我把老公拉黑了。我给他唱完“老鼠爱大米”，“月亮代表我的心”“爱你一万年”，嗓子都唱哑了，他还不停的说我是花痴，说我嫌弃他长得丑！特么的！', '1', '2020-07-14 13:21:14');
INSERT INTO `joke` VALUES ('202', '刚灵光一现突然想出了绝好的段子，自己站在哪傻乐，老婆一记耳光上问我：你又想哪个狐狸精呢？ 我声音颤抖的说：没  没有啊！ 老婆：没有就好！就见不得你哪色咪咪的傻笑！等老子反应过来特么我的绝世好段子被一巴掌扇忘了！老婆你等等 ！你回来再抽我一大嘴巴子看看我还能想起点不！', '1', '2020-07-14 13:21:14');
INSERT INTO `joke` VALUES ('203', '哥们是个马大哈.大众被他开的像台拉土车，走在路上才发现挡风玻璃上龟裂的像个蜘蛛网似的哥们：要不，咱下午去钓鱼？先把玻璃换上：你的车子，你做主呗！哥们盯着维修师傅换新玻璃，我闲的无聊走到折下来的那块玻璃面前用手去摸了一下那个裂纹的位置我擦！那个裂得像蜘蛛网似的地方它真的是个蜘蛛网[捂脸]', '1', '2020-07-14 13:21:14');

-- ----------------------------
-- Table structure for link_category
-- ----------------------------
DROP TABLE IF EXISTS `link_category`;
CREATE TABLE `link_category` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) NOT NULL COMMENT '链接分类名称',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COMMENT='链接分类表';

-- ----------------------------
-- Records of link_category
-- ----------------------------
INSERT INTO `link_category` VALUES ('1', '学习', '1');
INSERT INTO `link_category` VALUES ('2', '生活', '1');
INSERT INTO `link_category` VALUES ('3', '测试', '1');
INSERT INTO `link_category` VALUES ('4', 'IT', '1');
INSERT INTO `link_category` VALUES ('5', 'ces', '1');

-- ----------------------------
-- Table structure for link_info
-- ----------------------------
DROP TABLE IF EXISTS `link_info`;
CREATE TABLE `link_info` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(50) NOT NULL COMMENT '链接名称',
  `url` varchar(500) CHARACTER SET utf8mb4 NOT NULL COMMENT '链接地址',
  `user_link_category_id` int(20) NOT NULL COMMENT 'user_link_category表id',
  `status` tinyint(1) DEFAULT NULL COMMENT '状态',
  `sort_no` int(10) DEFAULT NULL COMMENT '排序号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8 COMMENT='链接信息表';

-- ----------------------------
-- Records of link_info
-- ----------------------------
INSERT INTO `link_info` VALUES ('35', '百度', 'https://www.baidu.com/', '13', '1', null);
INSERT INTO `link_info` VALUES ('36', '百度1', 'https://www.baidu.com/', '14', '1', '1');
INSERT INTO `link_info` VALUES ('37', '百度2', 'https://www.baidu.com/', '14', '1', '2');
INSERT INTO `link_info` VALUES ('38', '百度3', 'https://www.baidu.com/', '14', '1', '3');
INSERT INTO `link_info` VALUES ('39', '百度4', 'https://www.baidu.com/', '14', '1', '4');
INSERT INTO `link_info` VALUES ('40', '百度5', 'https://www.baidu.com/', '14', '1', '5');
INSERT INTO `link_info` VALUES ('41', '百度6', 'https://www.baidu.com/', '14', '1', '6');
INSERT INTO `link_info` VALUES ('42', '百度7', 'https://www.baidu.com/', '14', '1', '7');
INSERT INTO `link_info` VALUES ('43', '百度8', 'https://www.baidu.com/', '14', '1', '8');
INSERT INTO `link_info` VALUES ('44', '百度9', 'https://www.baidu.com/', '14', '1', '9');
INSERT INTO `link_info` VALUES ('45', '百度10', 'https://www.baidu.com/', '14', '1', '10');
INSERT INTO `link_info` VALUES ('46', '百度11', 'https://www.baidu.com/', '14', '1', '11');
INSERT INTO `link_info` VALUES ('47', '百度12', 'https://www.baidu.com/', '14', '1', '12');
INSERT INTO `link_info` VALUES ('48', '百度13', 'https://www.baidu.com/', '14', '1', '13');
INSERT INTO `link_info` VALUES ('49', '百度14', 'https://www.baidu.com/', '14', '1', '14');
INSERT INTO `link_info` VALUES ('50', '百度15', 'https://www.baidu.com/', '14', '1', '15');
INSERT INTO `link_info` VALUES ('51', '百度16', 'https://www.baidu.com/', '14', '1', '16');
INSERT INTO `link_info` VALUES ('52', '百度17', 'https://www.baidu.com/', '14', '1', '17');
INSERT INTO `link_info` VALUES ('53', '百度18', 'https://www.baidu.com/', '14', '1', '18');
INSERT INTO `link_info` VALUES ('54', '淘宝', 'https://ai.taobao.com/', '14', '1', '54');
INSERT INTO `link_info` VALUES ('55', '百度19', 'https://www.baidu.com/	', '14', '1', '55');
INSERT INTO `link_info` VALUES ('56', '20', 'https://www.baidu.com/	', '14', '1', '56');
INSERT INTO `link_info` VALUES ('58', '淘宝', 'https://ai.taobao.com/?pid=mm_50814843_6614255_24270041', '15', '1', '1');
INSERT INTO `link_info` VALUES ('59', '12306', 'https://www.12306.cn/index/index.html', '16', '1', '4');
INSERT INTO `link_info` VALUES ('60', '163', 'https://ai.taobao.com/', '16', '1', null);
INSERT INTO `link_info` VALUES ('61', '12306', 'https://www.12306.cn/index/index.html', '16', '1', null);
INSERT INTO `link_info` VALUES ('62', '程序员DD', 'https://www.baidu.com/	', '14', '1', '1');
INSERT INTO `link_info` VALUES ('63', '张三', 'http://www.8080s.net/1', '24', '1', '121');
INSERT INTO `link_info` VALUES ('64', 'JSON在线', 'https://www.sojson.com/', '22', '1', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户姓名',
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户昵称',
  `password` varchar(28) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户密码',
  `status` tinyint(1) DEFAULT NULL COMMENT '用户状态',
  `remark` varchar(50) DEFAULT NULL COMMENT '用户信息备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'public', 'public', '123456', '1', '公共用户，游客身份登录时使用');
INSERT INTO `user` VALUES ('2', '孟少昆', 'admin1', '123456', '1', null);
INSERT INTO `user` VALUES ('6', '123', 'admin', '123456', '1', null);
INSERT INTO `user` VALUES ('7', null, 'admin2', '123123', '1', null);
INSERT INTO `user` VALUES ('8', '', 'aaaa', '123456', '1', null);
INSERT INTO `user` VALUES ('9', '', 'aaaaa', '123456', '1', null);

-- ----------------------------
-- Table structure for user_link_category
-- ----------------------------
DROP TABLE IF EXISTS `user_link_category`;
CREATE TABLE `user_link_category` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(20) NOT NULL,
  `link_category_id` int(20) NOT NULL,
  `sort_no` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COMMENT='用户/链接分类表';

-- ----------------------------
-- Records of user_link_category
-- ----------------------------
INSERT INTO `user_link_category` VALUES ('13', '1', '1', '999');
INSERT INTO `user_link_category` VALUES ('14', '2', '1', '999');
INSERT INTO `user_link_category` VALUES ('15', '6', '2', '999');
INSERT INTO `user_link_category` VALUES ('16', '6', '1', '999');
INSERT INTO `user_link_category` VALUES ('22', '6', '3', '999');
INSERT INTO `user_link_category` VALUES ('23', '6', '4', '999');
INSERT INTO `user_link_category` VALUES ('24', '6', '5', '999');

-- ----------------------------
-- Function structure for getCategoryName
-- ----------------------------
DROP FUNCTION IF EXISTS `getCategoryName`;
DELIMITER ;;
CREATE DEFINER=`mengsk`@`%` FUNCTION `getCategoryName`(userLinkCategoryId INT) RETURNS varchar(20) CHARSET utf8
RETURN (
	SELECT
		lc. NAME
	FROM
		link_info li
	LEFT JOIN user_link_category ulc ON li.user_link_category_id = ulc.id
	LEFT JOIN link_category lc ON ulc.link_category_id = lc.id
	WHERE
		li.user_link_category_id = userLinkCategoryId
	LIMIT 0,
	1
)
;;
DELIMITER ;
