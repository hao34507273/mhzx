/*      */ package mzm.gsp.mail.main;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.Role;
/*      */ import mzm.gsp.common.TimeCommonUtil;
/*      */ import mzm.gsp.common.confbean.STimeLimitCommonCfg;
/*      */ import mzm.gsp.idip.main.IdipManager;
/*      */ import mzm.gsp.item.ItemInfo;
/*      */ import mzm.gsp.item.confbean.SItemCfg;
/*      */ import mzm.gsp.item.main.ItemInterface;
/*      */ import mzm.gsp.item.main.ItemOperateResult;
/*      */ import mzm.gsp.mail.MailData;
/*      */ import mzm.gsp.mail.SAutoDeleteMailRes;
/*      */ import mzm.gsp.mail.SAutoGetMailRes;
/*      */ import mzm.gsp.mail.SDelMailRes;
/*      */ import mzm.gsp.mail.SGetThingRes;
/*      */ import mzm.gsp.mail.SMailInitData;
/*      */ import mzm.gsp.mail.SNewMailRes;
/*      */ import mzm.gsp.mail.SNormalResult;
/*      */ import mzm.gsp.mail.SReadMailRes;
/*      */ import mzm.gsp.mail.confbean.SMailCfg;
/*      */ import mzm.gsp.mail.confbean.SMailCfgConsts;
/*      */ import mzm.gsp.mall.main.JifenOperateResult;
/*      */ import mzm.gsp.mall.main.MallInterface;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.pet.main.Pet;
/*      */ import mzm.gsp.pet.main.PetInterface;
/*      */ import mzm.gsp.qingfu.main.PresentResult;
/*      */ import mzm.gsp.qingfu.main.PresentType;
/*      */ import mzm.gsp.qingfu.main.QingfuInterface;
/*      */ import mzm.gsp.role.main.ModMoneyResult;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.role.main.VigorOperResult;
/*      */ import mzm.gsp.storageexp.main.StorageExpInterface;
/*      */ import mzm.gsp.tlog.LogReason;
/*      */ import mzm.gsp.tlog.SNSTYPE;
/*      */ import mzm.gsp.tlog.SnsFlowArg;
/*      */ import mzm.gsp.tlog.TLogArg;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.tlog.TlogUtil;
/*      */ import mzm.gsp.util.DateTimeUtils;
/*      */ import mzm.gsp.util.LogicProcedure;
/*      */ import mzm.gsp.util.LogicRunnable;
/*      */ import mzm.gsp.xiulian.main.XiuLianSkillInterface;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.Item;
/*      */ import xbean.MailInfo;
/*      */ import xbean.MailMapBean;
/*      */ import xbean.Pod;
/*      */ import xbean.Properties;
/*      */ import xdb.Lockeys;
/*      */ import xtable.Role2mail;
/*      */ import xtable.Role2properties;
/*      */ import xtable.User;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class RoleMailManager
/*      */ {
/*   72 */   private static final Logger logger = Logger.getLogger(RoleMailManager.class);
/*      */   
/*      */ 
/*      */   private static final int LOG_MAIL_ADD = 1;
/*      */   
/*      */ 
/*      */   private static final int LOG_MAIL_DEL = 2;
/*      */   
/*      */ 
/*      */   static void onRoleLogin(RoleMail roleMail)
/*      */   {
/*   83 */     if (roleMail.getMailMap().size() <= 0) {
/*   84 */       return;
/*      */     }
/*   86 */     long roleid = roleMail.getRoleid();
/*   87 */     SMailInitData sMailInitData = new SMailInitData();
/*   88 */     Iterator<Map.Entry<Integer, MailInfo>> iterator = roleMail.getMailMap().entrySet().iterator();
/*   89 */     while (iterator.hasNext()) {
/*   90 */       Map.Entry<Integer, MailInfo> entry = (Map.Entry)iterator.next();
/*   91 */       MailInfo xMailInfo = (MailInfo)entry.getValue();
/*   92 */       if (!isMailAvailable(xMailInfo)) {
/*   93 */         onDelLog(roleid, ((Integer)entry.getKey()).intValue(), xMailInfo);
/*   94 */         iterator.remove();
/*      */       }
/*      */       else {
/*   97 */         MailData mailData = new MailData();
/*      */         
/*   99 */         fillInMailData(mailData, xMailInfo, ((Integer)entry.getKey()).intValue());
/*  100 */         sMailInitData.maildatas.add(mailData);
/*      */       }
/*      */     }
/*  103 */     OnlineManager.getInstance().send(roleMail.getRoleid(), sMailInitData);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getMailType(MailInfo xMailInfo)
/*      */   {
/*  113 */     xbean.MailContent mailContent = xMailInfo.getMailcontent();
/*  114 */     int mailContentType = mailContent.getMailcontenttype();
/*  115 */     if (mailContentType == 2) {
/*  116 */       String mailType = (String)mailContent.getContentmap().get(Integer.valueOf(53));
/*      */       try
/*      */       {
/*  119 */         return Integer.parseInt(mailType.trim());
/*      */       } catch (Exception e) {
/*  121 */         GameServer.logger().error("邮件存储类型转换出错!!!mailtype" + (mailType == null ? "" : mailType));
/*  122 */         mailContent.getContentmap().put(Integer.valueOf(53), "1");
/*  123 */         return 1;
/*      */       }
/*      */     }
/*  126 */     if ((mailContentType == 3) || (mailContentType == 1)) {
/*  127 */       String mailCfgidStr = (String)mailContent.getContentmap().get(Integer.valueOf(51));
/*      */       try
/*      */       {
/*  130 */         int cfgid = Integer.parseInt(mailCfgidStr);
/*  131 */         return SMailCfg.get(cfgid).mailType;
/*      */       } catch (Exception e) {
/*  133 */         GameServer.logger().error("邮件配置类型不存在出错 !!");
/*  134 */         mailContent.setMailcontenttype(2);
/*  135 */         mailContent.getContentmap().put(Integer.valueOf(53), "1");
/*  136 */         mailContent.getContentmap().put(Integer.valueOf(52), "system mail");
/*  137 */         return 1;
/*      */       }
/*      */     }
/*  140 */     return 1;
/*      */   }
/*      */   
/*      */   private static void fillInMailData(MailData mailData, MailInfo xMailInfo, int mailIndex) {
/*  144 */     mailData.mailindex = mailIndex;
/*  145 */     mailData.createtime = ((int)(xMailInfo.getCreatetime() / 1000L));
/*  146 */     boolean hasThing = false;
/*  147 */     hasThing = mailHasThing(xMailInfo);
/*      */     
/*  149 */     mailData.mailcontent.mailcontenttype = xMailInfo.getMailcontent().getMailcontenttype();
/*  150 */     mailData.mailcontent.contentmap.putAll(xMailInfo.getMailcontent().getContentmap());
/*  151 */     for (Map.Entry<Integer, xbean.FormatArgs> entry : xMailInfo.getMailcontent().getFormatargsmap().entrySet()) {
/*  152 */       mzm.gsp.mail.FormatArgs formatArgs = new mzm.gsp.mail.FormatArgs();
/*  153 */       formatArgs.args.addAll(((xbean.FormatArgs)entry.getValue()).getArgs());
/*  154 */       mailData.mailcontent.formatargsmap.put(entry.getKey(), formatArgs);
/*      */     }
/*  156 */     mailData.hasthing = (hasThing ? 1 : 0);
/*  157 */     mailData.readstate = xMailInfo.getState();
/*  158 */     Integer delMailSec = (Integer)xMailInfo.getExtradatamap().get(Integer.valueOf(4));
/*  159 */     if (delMailSec != null) {
/*  160 */       mailData.extraparam.put(Integer.valueOf(1), delMailSec);
/*      */     }
/*  162 */     Integer zeroProfit = (Integer)xMailInfo.getExtradatamap().get(Integer.valueOf(5));
/*  163 */     if (zeroProfit != null) {
/*  164 */       mailData.extraparam.put(Integer.valueOf(2), zeroProfit);
/*      */     }
/*      */   }
/*      */   
/*      */   private static boolean mailHasThing(MailInfo xMailInfo) {
/*  169 */     boolean hasThing = false;
/*  170 */     if (!xMailInfo.getExtradatamap().containsKey(Integer.valueOf(3))) {
/*  171 */       if ((xMailInfo.getNotitemlist().size() > 0) || (xMailInfo.getItemlist().size() > 0)) {
/*  172 */         return true;
/*      */       }
/*  174 */       if (xMailInfo.getMailcontent().getMailcontenttype() == 1) {
/*  175 */         String mailCfgidStr = (String)xMailInfo.getMailcontent().getContentmap().get(Integer.valueOf(51));
/*      */         try {
/*  177 */           int cfgid = Integer.parseInt(mailCfgidStr);
/*  178 */           SMailCfg mailCfg = SMailCfg.get(cfgid);
/*  179 */           if ((mailCfg.gold > 0) || (mailCfg.goldIngot > 0) || (mailCfg.yuanbao > 0) || (mailCfg.silver > 0) || (mailCfg.itemMap.size() > 0) || (mailCfg.tokenMap.size() > 0))
/*      */           {
/*  181 */             return true;
/*      */           }
/*      */         }
/*      */         catch (Exception e) {}
/*      */       }
/*      */     }
/*  187 */     return hasThing;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void reqReadMail(long roleId, MailMapBean xMailMapBean, int mailIndex)
/*      */   {
/*  197 */     if (xMailMapBean == null) {
/*  198 */       return;
/*      */     }
/*  200 */     if (!xMailMapBean.getMailinfomap().containsKey(Integer.valueOf(mailIndex))) {
/*  201 */       return;
/*      */     }
/*  203 */     MailInfo xMailInfo = (MailInfo)xMailMapBean.getMailinfomap().get(Integer.valueOf(mailIndex));
/*      */     
/*  205 */     if (!isMailAvailable(xMailInfo))
/*      */     {
/*  207 */       xMailMapBean.getMailinfomap().remove(Integer.valueOf(mailIndex));
/*      */       
/*  209 */       SDelMailRes sDelMailRes = new SDelMailRes();
/*  210 */       sDelMailRes.mailindex = mailIndex;
/*  211 */       OnlineManager.getInstance().send(roleId, sDelMailRes);
/*      */       
/*  213 */       SNormalResult sNormalResult = new SNormalResult();
/*  214 */       sNormalResult.ret = 10;
/*  215 */       OnlineManager.getInstance().send(roleId, sNormalResult);
/*  216 */       onDelLog(roleId, mailIndex, xMailInfo);
/*  217 */       return;
/*      */     }
/*      */     
/*  220 */     xMailInfo.setState(1);
/*  221 */     if (!isMailFullCfg(xMailInfo)) {
/*  222 */       SReadMailRes readMailRes = new SReadMailRes();
/*  223 */       readMailRes.mailindex = mailIndex;
/*  224 */       for (xbean.ThingBean xThingBean : xMailInfo.getNotitemlist()) {
/*  225 */         mzm.gsp.mail.ThingBean thingBean = new mzm.gsp.mail.ThingBean();
/*  226 */         thingBean.count = xThingBean.getCount();
/*  227 */         thingBean.id = xThingBean.getId();
/*  228 */         thingBean.thingtype = xThingBean.getThingtype();
/*  229 */         readMailRes.notitemlist.add(thingBean);
/*      */       }
/*  231 */       for (Item xitem : xMailInfo.getItemlist()) {
/*  232 */         ItemInfo iteminfo = new ItemInfo();
/*  233 */         if (!ItemInterface.fillInItemInfoBean(iteminfo, xitem)) {
/*  234 */           String logStr = String.format("RoleMailManager.reqReadMail@not find item uuid|roleid=%d|itemid=%d|mail_index=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(xitem.getCfgid()), Integer.valueOf(mailIndex) });
/*      */           
/*      */ 
/*  237 */           GameServer.logger().error(logStr);
/*      */         }
/*      */         else {
/*  240 */           readMailRes.itemlist.add(iteminfo);
/*      */         } }
/*  242 */       OnlineManager.getInstance().send(roleId, readMailRes);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isMailAvailable(MailInfo xMailInfo)
/*      */   {
/*  252 */     int mailType = getMailType(xMailInfo);
/*  253 */     long currentSec = DateTimeUtils.getCurrTimeInMillis() / 1000L;
/*  254 */     Integer autoDelTime = (Integer)xMailInfo.getExtradatamap().get(Integer.valueOf(4));
/*  255 */     if (autoDelTime != null) {
/*  256 */       return autoDelTime.intValue() >= currentSec;
/*      */     }
/*  258 */     int storeTime = MailManager.getInstance().getStoreTimeByType(mailType);
/*  259 */     if (storeTime > 0) {
/*  260 */       long delSec = TimeUnit.HOURS.toSeconds(storeTime) + xMailInfo.getCreatetime() / 1000L;
/*  261 */       if (delSec <= currentSec) {
/*  262 */         return false;
/*      */       }
/*  264 */       return true;
/*      */     }
/*      */     
/*  267 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean reqDelMail(long roleId, MailMapBean xMailMapBean, int mailIndex)
/*      */   {
/*  279 */     if (xMailMapBean == null) {
/*  280 */       return false;
/*      */     }
/*  282 */     if (!xMailMapBean.getMailinfomap().containsKey(Integer.valueOf(mailIndex))) {
/*  283 */       return false;
/*      */     }
/*  285 */     MailInfo xmaiInfo = (MailInfo)xMailMapBean.getMailinfomap().remove(Integer.valueOf(mailIndex));
/*  286 */     onDelLog(roleId, mailIndex, xmaiInfo);
/*  287 */     SDelMailRes sDelMailRes = new SDelMailRes();
/*  288 */     sDelMailRes.mailindex = mailIndex;
/*  289 */     OnlineManager.getInstance().send(roleId, sDelMailRes);
/*      */     
/*  291 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean reqAutoDelMail(long roleId, MailMapBean xMailMapBean)
/*      */   {
/*  302 */     if (xMailMapBean == null) {
/*  303 */       return false;
/*      */     }
/*      */     
/*  306 */     SAutoDeleteMailRes autoDeleteMailRes = new SAutoDeleteMailRes();
/*      */     
/*  308 */     Iterator<Map.Entry<Integer, MailInfo>> iterator = xMailMapBean.getMailinfomap().entrySet().iterator();
/*  309 */     while (iterator.hasNext()) {
/*  310 */       Map.Entry<Integer, MailInfo> entry = (Map.Entry)iterator.next();
/*  311 */       MailInfo xMailInfo = (MailInfo)entry.getValue();
/*  312 */       int mailIndex = ((Integer)entry.getKey()).intValue();
/*  313 */       if (mailHasThing(xMailInfo))
/*      */       {
/*  315 */         return false;
/*      */       }
/*      */       
/*  318 */       autoDeleteMailRes.mailindexs.add(Integer.valueOf(mailIndex));
/*  319 */       iterator.remove();
/*  320 */       onDelLog(roleId, mailIndex, xMailInfo);
/*      */     }
/*      */     
/*  323 */     OnlineManager.getInstance().send(roleId, autoDeleteMailRes);
/*  324 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean reqGetThing(String userId, long roleId, MailMapBean xMailMapBean, int mailIndex)
/*      */   {
/*  337 */     if (xMailMapBean == null) {
/*  338 */       return false;
/*      */     }
/*  340 */     if (!xMailMapBean.getMailinfomap().containsKey(Integer.valueOf(mailIndex))) {
/*  341 */       return false;
/*      */     }
/*      */     
/*  344 */     MailInfo xMailInfo = (MailInfo)xMailMapBean.getMailinfomap().get(Integer.valueOf(mailIndex));
/*      */     
/*      */ 
/*      */ 
/*  348 */     if (!isMailAvailable(xMailInfo))
/*      */     {
/*  350 */       xMailMapBean.getMailinfomap().remove(Integer.valueOf(mailIndex));
/*      */       
/*  352 */       SDelMailRes sDelMailRes = new SDelMailRes();
/*  353 */       sDelMailRes.mailindex = mailIndex;
/*  354 */       OnlineManager.getInstance().send(roleId, sDelMailRes);
/*      */       
/*  356 */       SNormalResult sNormalResult = new SNormalResult();
/*  357 */       sNormalResult.ret = 10;
/*  358 */       OnlineManager.getInstance().send(roleId, sNormalResult);
/*  359 */       onDelLog(roleId, mailIndex, xMailInfo);
/*  360 */       return true;
/*      */     }
/*  362 */     boolean suc = getThing(userId, roleId, mailIndex, xMailInfo);
/*  363 */     SGetThingRes sGetThingRes = new SGetThingRes();
/*  364 */     sGetThingRes.mailindex = mailIndex;
/*  365 */     if (suc) {
/*  366 */       OnlineManager.getInstance().send(roleId, sGetThingRes);
/*      */     }
/*  368 */     return suc;
/*      */   }
/*      */   
/*      */   private static MailAttachment getMailAttachment(MailInfo xMailInfo) {
/*  372 */     if (xMailInfo == null) {
/*  373 */       return new MailAttachment();
/*      */     }
/*      */     
/*  376 */     MailAttachment mailAttachment = new MailAttachment();
/*  377 */     if (xMailInfo.getMailcontent().getMailcontenttype() == 1) {
/*  378 */       String mailcfgid = (String)xMailInfo.getMailcontent().getContentmap().get(Integer.valueOf(51));
/*      */       
/*  380 */       int mailCfgid = Integer.parseInt(mailcfgid);
/*  381 */       SMailCfg mailCfg = SMailCfg.get(mailCfgid);
/*  382 */       mailAttachment.setBindYuanBao(mailAttachment.getBindYuanBao() + mailCfg.yuanbao);
/*  383 */       mailAttachment.setGold(mailAttachment.getGold() + mailCfg.gold);
/*  384 */       mailAttachment.setGoldIngot(mailAttachment.getGoldIngot() + mailCfg.goldIngot);
/*  385 */       mailAttachment.setSilver(mailAttachment.getSilver() + mailCfg.silver);
/*  386 */       mailAttachment.addItemMap(mailCfg.itemMap);
/*  387 */       mailAttachment.addTokeMap(mailCfg.tokenMap);
/*      */     }
/*  389 */     List<Item> list = new ArrayList();
/*  390 */     for (Item item : xMailInfo.getItemlist()) {
/*  391 */       list.add(item.toBean());
/*      */     }
/*  393 */     mailAttachment.addXItem(list);
/*  394 */     List<xbean.ThingBean> xthingBeans = xMailInfo.getNotitemlist();
/*  395 */     for (xbean.ThingBean xThingBean : xthingBeans) {
/*  396 */       switch (xThingBean.getThingtype()) {
/*      */       case 1: 
/*  398 */         switch (xThingBean.getId()) {
/*      */         case 1: 
/*  400 */           if (xThingBean.getSign() == 1) {
/*  401 */             mailAttachment.setBindYuanBao(mailAttachment.getBindYuanBao() + xThingBean.getCount());
/*      */           } else {
/*  403 */             mailAttachment.setYuanBao(mailAttachment.getYuanBao() + xThingBean.getCount());
/*      */           }
/*  405 */           break;
/*      */         case 2: 
/*  407 */           mailAttachment.setGold(mailAttachment.getGold() + xThingBean.getCount());
/*      */           
/*  409 */           break;
/*      */         case 5: 
/*  411 */           mailAttachment.setGoldIngot(mailAttachment.getGoldIngot() + xThingBean.getCount());
/*  412 */           break;
/*      */         case 3: 
/*  414 */           mailAttachment.setSilver(mailAttachment.getSilver() + xThingBean.getCount());
/*  415 */           break;
/*      */         case 4: default: 
/*  417 */           logger.error("不存在的金钱类型!type:" + xThingBean.getId());
/*      */         }
/*  419 */         break;
/*      */       case 2: 
/*  421 */         mailAttachment.addToken(xThingBean.getId(), xThingBean.getCount());
/*  422 */         break;
/*      */       case 3: 
/*  424 */         switch (xThingBean.getId()) {
/*      */         case 1: 
/*  426 */           mailAttachment.setRoleExp(mailAttachment.getRoleExp() + xThingBean.getCount());
/*  427 */           break;
/*      */         case 2: 
/*  429 */           mailAttachment.setPetExp(mailAttachment.getPetExp() + xThingBean.getCount());
/*  430 */           break;
/*      */         case 3: 
/*  432 */           mailAttachment.setXiuLianExp(mailAttachment.getXiuLianExp() + xThingBean.getCount());
/*  433 */           break;
/*      */         default: 
/*  435 */           logger.error("不存在的经验类型!type:" + xThingBean.getId());
/*      */         }
/*  437 */         break;
/*      */       case 4: 
/*  439 */         mailAttachment.setVigor(mailAttachment.getVigor() + xThingBean.getCount());
/*  440 */         break;
/*      */       case 5: 
/*  442 */         mailAttachment.setStoreExp(mailAttachment.getStoreExp() + xThingBean.getCount());
/*  443 */         break;
/*      */       default: 
/*  445 */         logger.error("不存在的附件类型!type:" + xThingBean.getThingtype());
/*      */       }
/*      */       
/*      */     }
/*  449 */     return mailAttachment;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static boolean getThing(String userId, long roleId, int mailIndex, MailInfo xMailInfo)
/*      */   {
/*  462 */     if (xMailInfo == null) {
/*  463 */       return false;
/*      */     }
/*  465 */     xMailInfo.setState(1);
/*      */     
/*  467 */     if (!mailHasThing(xMailInfo)) {
/*  468 */       return true;
/*      */     }
/*      */     
/*  471 */     MailAttachment mailAttachment = getMailAttachment(xMailInfo);
/*  472 */     xMailInfo.getNotitemlist().clear();
/*  473 */     xMailInfo.getExtradatamap().put(Integer.valueOf(3), Integer.valueOf(1));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  487 */     if (xMailInfo.getExtradatamap().containsKey(Integer.valueOf(5)))
/*      */     {
/*  489 */       return true;
/*      */     }
/*  491 */     TLogArg tLogArg = new TLogArg(LogReason.MAIL_ADD, mailIndex);
/*  492 */     int bindYuanBao = mailAttachment.getBindYuanBao();
/*  493 */     if ((bindYuanBao > 0) && 
/*  494 */       (QingfuInterface.presentYuanbao(userId, roleId, bindYuanBao, PresentType.PRSENT_BIND_MAIL_ADD, tLogArg) != PresentResult.Success)) {
/*  495 */       sendNormalResult(roleId, 1, new String[] { "1" });
/*  496 */       return false;
/*      */     }
/*      */     
/*  499 */     int yuanBao = mailAttachment.getYuanBao();
/*  500 */     if ((yuanBao > 0) && 
/*  501 */       (QingfuInterface.presentYuanbao(userId, roleId, yuanBao, PresentType.PRSENT_UN_BIND_MAIL_ADD, tLogArg) != PresentResult.Success)) {
/*  502 */       sendNormalResult(roleId, 1, new String[] { "1" });
/*  503 */       return false;
/*      */     }
/*      */     
/*  506 */     int gold = mailAttachment.getGold();
/*  507 */     if ((gold > 0) && 
/*  508 */       (!RoleInterface.addGold(roleId, gold, tLogArg).isSucceed())) {
/*  509 */       sendNormalResult(roleId, 1, new String[] { "2" });
/*  510 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  514 */     int goldIngot = mailAttachment.getGoldIngot();
/*  515 */     if ((goldIngot > 0) && 
/*  516 */       (!RoleInterface.addGoldIngotInAll(roleId, goldIngot, tLogArg, true).isSucceed())) {
/*  517 */       sendNormalResult(roleId, 1, new String[] { "5" });
/*  518 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  522 */     int silver = mailAttachment.getSilver();
/*  523 */     if ((silver > 0) && 
/*  524 */       (!RoleInterface.addSilver(roleId, silver, tLogArg).isSucceed())) {
/*  525 */       sendNormalResult(roleId, 1, new String[] { "3" });
/*  526 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  530 */     int vigor = mailAttachment.getVigor();
/*  531 */     if ((vigor > 0) && 
/*  532 */       (RoleInterface.addVigor(roleId, vigor, tLogArg) != VigorOperResult.SUCCESS)) {
/*  533 */       sendNormalResult(roleId, 3, new String[] { "3" });
/*  534 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  538 */     int roleExp = mailAttachment.getRoleExp();
/*  539 */     if (roleExp > 0) {
/*  540 */       RoleInterface.addExp(userId, roleId, roleExp, tLogArg);
/*      */     }
/*      */     
/*  543 */     int petExp = mailAttachment.getPetExp();
/*  544 */     if (petExp > 0) {
/*  545 */       Pet pet = PetInterface.getFightPet(roleId, true);
/*  546 */       if (pet != null) {
/*  547 */         pet.addExp(petExp);
/*      */       }
/*      */     }
/*      */     
/*  551 */     int xiulianExp = mailAttachment.getXiuLianExp();
/*  552 */     if (xiulianExp > 0) {
/*  553 */       XiuLianSkillInterface.addXiuLianExp(roleId, xiulianExp, tLogArg);
/*      */     }
/*      */     
/*  556 */     int storageExp = mailAttachment.getStoreExp();
/*  557 */     if (storageExp > 0) {
/*  558 */       StorageExpInterface.addCanUseStorageExp(roleId, storageExp, true);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  565 */     if (mailAttachment.getXitems().size() > 0) {
/*  566 */       ItemOperateResult itemOperateResult = ItemInterface.addItemActive(roleId, mailAttachment.getXitems(), true, true, tLogArg);
/*      */       
/*  568 */       if (itemOperateResult.success()) {
/*  569 */         xMailInfo.getItemlist().clear();
/*      */       }
/*      */       else {
/*  572 */         return false;
/*      */       }
/*      */     }
/*  575 */     if (mailAttachment.getItemMap().size() > 0) {
/*  576 */       ItemOperateResult ret = ItemInterface.addItemActive(roleId, mailAttachment.getItemMap(), false, true, new TLogArg(LogReason.MAIL_ADD, mailIndex));
/*      */       
/*      */ 
/*  579 */       if (!ret.success())
/*      */       {
/*  581 */         return false;
/*      */       }
/*      */     }
/*  584 */     if (mailAttachment.getTokenMap().size() > 0) {
/*  585 */       for (Map.Entry<Integer, Integer> entry : mailAttachment.getTokenMap().entrySet()) {
/*  586 */         JifenOperateResult jifenOperateResult = MallInterface.addJifen(roleId, ((Integer)entry.getValue()).intValue(), ((Integer)entry.getKey()).intValue(), false, tLogArg);
/*      */         
/*  588 */         if (!jifenOperateResult.isSuccess()) {
/*  589 */           sendNormalResult(roleId, 2, new String[0]);
/*  590 */           return false;
/*      */         }
/*      */       }
/*      */     }
/*  594 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean reqAutoGetThing(final long roleId, MailMapBean xMailMapBean)
/*      */   {
/*  606 */     if (xMailMapBean == null) {
/*  607 */       return false;
/*      */     }
/*  609 */     if (xMailMapBean.getMailinfomap().size() <= 0) {
/*  610 */       return false;
/*      */     }
/*  612 */     List<Integer> mailIndexs = new ArrayList();
/*  613 */     for (Map.Entry<Integer, MailInfo> entry : xMailMapBean.getMailinfomap().entrySet()) {
/*  614 */       mailIndexs.add(entry.getKey());
/*      */     }
/*      */     
/*      */ 
/*  618 */     Role.addRoleRunnable(roleId, new LogicRunnable()
/*      */     {
/*      */       public void process() throws Exception
/*      */       {
/*  622 */         SAutoGetMailRes autoGetMailRes = new SAutoGetMailRes();
/*  623 */         for (Iterator i$ = this.val$mailIndexs.iterator(); i$.hasNext();) { final int mailIndex = ((Integer)i$.next()).intValue();
/*      */           
/*  625 */           boolean ret = new LogicProcedure()
/*      */           {
/*      */             protected boolean processImp()
/*      */               throws Exception
/*      */             {
/*  630 */               String userId = RoleInterface.getUserId(RoleMailManager.1.this.val$roleId);
/*  631 */               lock(Lockeys.get(User.getTable(), userId));
/*      */               
/*      */ 
/*  634 */               MailMapBean xMailMapBean = Role2mail.get(Long.valueOf(RoleMailManager.1.this.val$roleId));
/*  635 */               if (xMailMapBean.getMailinfomap().containsKey(Integer.valueOf(mailIndex))) {
/*  636 */                 MailInfo xMailInfo = (MailInfo)xMailMapBean.getMailinfomap().get(Integer.valueOf(mailIndex));
/*  637 */                 if (!RoleMailManager.isMailAvailable(xMailInfo))
/*      */                 {
/*  639 */                   xMailMapBean.getMailinfomap().remove(Integer.valueOf(mailIndex));
/*      */                   
/*      */ 
/*  642 */                   SDelMailRes sDelMailRes = new SDelMailRes();
/*  643 */                   sDelMailRes.mailindex = mailIndex;
/*  644 */                   OnlineManager.getInstance().send(RoleMailManager.1.this.val$roleId, sDelMailRes);
/*  645 */                   RoleMailManager.onDelLog(RoleMailManager.1.this.val$roleId, mailIndex, xMailInfo);
/*  646 */                   return true;
/*      */                 }
/*  648 */                 return RoleMailManager.getThing(userId, RoleMailManager.1.this.val$roleId, mailIndex, xMailInfo);
/*      */               }
/*  650 */               return true;
/*      */             }
/*      */           }.call();
/*      */           
/*  654 */           if (!ret) break;
/*  655 */           autoGetMailRes.mailindexs.add(Integer.valueOf(mailIndex));
/*      */         }
/*      */         
/*      */ 
/*      */ 
/*      */ 
/*  661 */         if (autoGetMailRes.mailindexs.size() > 0) {
/*  662 */           OnlineManager.getInstance().sendAtOnce(roleId, autoGetMailRes);
/*      */         }
/*      */         
/*      */       }
/*  666 */     });
/*  667 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static SendMailRet buildAndSendAutoMail(long roleId, int mailType, String title, String content, MailAttachment sendAttachment, TLogArg tLogArg, long delTimeMil, String tagid)
/*      */   {
/*  684 */     if (GameServerInfoManager.isRoamServer()) {
/*  685 */       GameServer.logger().info(String.format("[Mail]send mail error!!|roleid=%d|mailtype=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(mailType) }));
/*  686 */       return new SendMailRet(SendMailRet.RetEnum.SEND_MAIL_ROAM_SERVER, false);
/*      */     }
/*  688 */     MailAttachment mailAttachment = new MailAttachment(sendAttachment);
/*  689 */     SendMailRet sendMailRet = canSendMail(roleId, mailAttachment, tLogArg);
/*  690 */     if (!sendMailRet.isOK()) {
/*  691 */       if (sendMailRet.isRoleNotExist()) {
/*  692 */         GameServer.logger().error("发送邮件失败,不存在的玩家roleid:" + roleId + ",title:" + title + "," + "content:" + content);
/*      */       }
/*  694 */       else if (sendMailRet.isMailTLogArgNull()) {
/*  695 */         GameServer.logger().error("发送邮件失败,日志原因为null roleid:" + roleId + ",title:" + title + "," + "content:" + content);
/*      */       }
/*      */       else {
/*  698 */         GameServer.logger().error("发送邮件失败roleid:" + roleId + ",title:" + title + "," + "content:" + content);
/*      */       }
/*  700 */       return sendMailRet;
/*      */     }
/*  702 */     RoleMail roleMail = new RoleMail(roleId, true);
/*  703 */     if (roleMail.isNull()) {
/*  704 */       MailMapBean xMailMapBean = Pod.newMailMapBean();
/*  705 */       Role2mail.insert(Long.valueOf(roleId), xMailMapBean);
/*  706 */       roleMail.setMailMapBean(xMailMapBean);
/*      */     }
/*  708 */     boolean isZeroProfit = IdipManager.isZeroProfit(roleId);
/*  709 */     long currentTime = DateTimeUtils.getCurrTimeInMillis();
/*  710 */     Map<Integer, MailInfo> newMails = new HashMap();
/*  711 */     MailInfo xMailInfo = createAutoMailInfo(currentTime, mailType, title, content, delTimeMil, isZeroProfit, tagid);
/*  712 */     newMails.put(Integer.valueOf(roleMail.getNextIndex()), xMailInfo);
/*  713 */     int thingCount = 0;
/*  714 */     int thingLimit = SMailCfgConsts.getInstance().THING_MAX;
/*      */     
/*      */ 
/*  717 */     for (Map.Entry<Integer, Integer> itemEntry : mailAttachment.getItemMap().entrySet()) {
/*  718 */       int itemId = ((Integer)itemEntry.getKey()).intValue();
/*  719 */       int itemCount = ((Integer)itemEntry.getValue()).intValue();
/*  720 */       SItemCfg itemCfg = ItemInterface.getSItemCfg(itemId);
/*  721 */       if (itemCfg == null) {
/*  722 */         GameServer.logger().error("邮件中不能发送不存在的道具!itemid:" + itemId);
/*  723 */         return new SendMailRet(SendMailRet.RetEnum.SEND_ITEM_NOT_EXIST, false);
/*      */       }
/*  725 */       List<Item> xItems = null;
/*  726 */       if (mailAttachment.getBindItems().contains(Integer.valueOf(itemId))) {
/*  727 */         xItems = ItemInterface.createXItem(itemId, itemCount, null, true);
/*      */       } else {
/*  729 */         xItems = ItemInterface.createXItem(itemId, itemCount, null, false);
/*      */       }
/*  731 */       mailAttachment.addXItem(xItems);
/*      */     }
/*  733 */     for (Item xItem : mailAttachment.getXitems()) {
/*  734 */       if (thingCount >= thingLimit) {
/*  735 */         xMailInfo = createAutoMailInfo(currentTime, mailType, title, content, delTimeMil, isZeroProfit, tagid);
/*  736 */         newMails.put(Integer.valueOf(roleMail.getNextIndex()), xMailInfo);
/*  737 */         thingCount = 0;
/*      */       }
/*  739 */       xMailInfo.getItemlist().add(xItem.toBean());
/*  740 */       thingCount++;
/*      */     }
/*      */     
/*      */ 
/*  744 */     for (Map.Entry<Integer, Integer> tokenEntry : mailAttachment.getTokenMap().entrySet()) {
/*  745 */       if (thingCount >= thingLimit) {
/*  746 */         xMailInfo = createAutoMailInfo(currentTime, mailType, title, content, delTimeMil, isZeroProfit, tagid);
/*  747 */         newMails.put(Integer.valueOf(roleMail.getNextIndex()), xMailInfo);
/*  748 */         thingCount = 0;
/*      */       }
/*  750 */       xbean.ThingBean xthingBean = Pod.newThingBean();
/*  751 */       fillDataInXThingBean(((Integer)tokenEntry.getKey()).intValue(), ((Integer)tokenEntry.getValue()).intValue(), 2, xthingBean);
/*      */       
/*  753 */       xMailInfo.getNotitemlist().add(xthingBean);
/*  754 */       thingCount++;
/*      */     }
/*      */     
/*  757 */     if (mailAttachment.getBindYuanBao() > 0) {
/*  758 */       if (thingCount >= thingLimit) {
/*  759 */         xMailInfo = createAutoMailInfo(currentTime, mailType, title, content, delTimeMil, isZeroProfit, tagid);
/*  760 */         newMails.put(Integer.valueOf(roleMail.getNextIndex()), xMailInfo);
/*  761 */         thingCount = 0;
/*      */       }
/*  763 */       xbean.ThingBean xthingBean = Pod.newThingBean();
/*  764 */       xthingBean.setSign(1);
/*  765 */       fillDataInXThingBean(1, mailAttachment.getBindYuanBao(), 1, xthingBean);
/*      */       
/*  767 */       xMailInfo.getNotitemlist().add(xthingBean);
/*  768 */       thingCount++;
/*      */     }
/*  770 */     if (mailAttachment.getYuanBao() > 0) {
/*  771 */       if (thingCount >= thingLimit) {
/*  772 */         xMailInfo = createAutoMailInfo(currentTime, mailType, title, content, delTimeMil, isZeroProfit, tagid);
/*  773 */         newMails.put(Integer.valueOf(roleMail.getNextIndex()), xMailInfo);
/*  774 */         thingCount = 0;
/*      */       }
/*  776 */       xbean.ThingBean xthingBean = Pod.newThingBean();
/*  777 */       xthingBean.setSign(0);
/*  778 */       fillDataInXThingBean(1, mailAttachment.getYuanBao(), 1, xthingBean);
/*      */       
/*  780 */       xMailInfo.getNotitemlist().add(xthingBean);
/*  781 */       thingCount++;
/*      */     }
/*      */     
/*  784 */     if (mailAttachment.getGold() > 0) {
/*  785 */       if (thingCount >= thingLimit) {
/*  786 */         xMailInfo = createAutoMailInfo(currentTime, mailType, title, content, delTimeMil, isZeroProfit, tagid);
/*  787 */         newMails.put(Integer.valueOf(roleMail.getNextIndex()), xMailInfo);
/*  788 */         thingCount = 0;
/*      */       }
/*  790 */       xbean.ThingBean xthingBean = Pod.newThingBean();
/*  791 */       fillDataInXThingBean(2, mailAttachment.getGold(), 1, xthingBean);
/*      */       
/*  793 */       xMailInfo.getNotitemlist().add(xthingBean);
/*  794 */       thingCount++;
/*      */     }
/*      */     
/*  797 */     if (mailAttachment.getGoldIngot() > 0) {
/*  798 */       if (thingCount >= thingLimit) {
/*  799 */         xMailInfo = createAutoMailInfo(currentTime, mailType, title, content, delTimeMil, isZeroProfit, tagid);
/*  800 */         newMails.put(Integer.valueOf(roleMail.getNextIndex()), xMailInfo);
/*  801 */         thingCount = 0;
/*      */       }
/*  803 */       xbean.ThingBean xthingBean = Pod.newThingBean();
/*  804 */       fillDataInXThingBean(5, mailAttachment.getGoldIngot(), 1, xthingBean);
/*      */       
/*  806 */       xMailInfo.getNotitemlist().add(xthingBean);
/*  807 */       thingCount++;
/*      */     }
/*      */     
/*  810 */     if (mailAttachment.getSilver() > 0) {
/*  811 */       if (thingCount >= thingLimit) {
/*  812 */         xMailInfo = createAutoMailInfo(currentTime, mailType, title, content, delTimeMil, isZeroProfit, tagid);
/*  813 */         newMails.put(Integer.valueOf(roleMail.getNextIndex()), xMailInfo);
/*  814 */         thingCount = 0;
/*      */       }
/*  816 */       xbean.ThingBean xthingBean = Pod.newThingBean();
/*  817 */       fillDataInXThingBean(3, mailAttachment.getSilver(), 1, xthingBean);
/*      */       
/*  819 */       xMailInfo.getNotitemlist().add(xthingBean);
/*  820 */       thingCount++;
/*      */     }
/*      */     
/*  823 */     if (mailAttachment.getVigor() > 0) {
/*  824 */       if (thingCount >= thingLimit) {
/*  825 */         xMailInfo = createAutoMailInfo(currentTime, mailType, title, content, delTimeMil, isZeroProfit, tagid);
/*  826 */         newMails.put(Integer.valueOf(roleMail.getNextIndex()), xMailInfo);
/*  827 */         thingCount = 0;
/*      */       }
/*  829 */       xbean.ThingBean xthingBean = Pod.newThingBean();
/*  830 */       fillDataInXThingBean(0, mailAttachment.getVigor(), 4, xthingBean);
/*  831 */       xMailInfo.getNotitemlist().add(xthingBean);
/*  832 */       thingCount++;
/*      */     }
/*      */     
/*  835 */     if (mailAttachment.getRoleExp() > 0) {
/*  836 */       if (thingCount >= thingLimit) {
/*  837 */         xMailInfo = createAutoMailInfo(currentTime, mailType, title, content, delTimeMil, isZeroProfit, tagid);
/*  838 */         newMails.put(Integer.valueOf(roleMail.getNextIndex()), xMailInfo);
/*  839 */         thingCount = 0;
/*      */       }
/*  841 */       xbean.ThingBean xthingBean = Pod.newThingBean();
/*  842 */       fillDataInXThingBean(1, mailAttachment.getRoleExp(), 3, xthingBean);
/*      */       
/*  844 */       xMailInfo.getNotitemlist().add(xthingBean);
/*  845 */       thingCount++;
/*      */     }
/*      */     
/*  848 */     if (mailAttachment.getPetExp() > 0) {
/*  849 */       if (thingCount >= thingLimit) {
/*  850 */         xMailInfo = createAutoMailInfo(currentTime, mailType, title, content, delTimeMil, isZeroProfit, tagid);
/*  851 */         newMails.put(Integer.valueOf(roleMail.getNextIndex()), xMailInfo);
/*  852 */         thingCount = 0;
/*      */       }
/*  854 */       xbean.ThingBean xthingBean = Pod.newThingBean();
/*  855 */       fillDataInXThingBean(2, mailAttachment.getPetExp(), 3, xthingBean);
/*      */       
/*  857 */       xMailInfo.getNotitemlist().add(xthingBean);
/*  858 */       thingCount++;
/*      */     }
/*      */     
/*      */ 
/*  862 */     if (mailAttachment.getXiuLianExp() > 0) {
/*  863 */       if (thingCount >= thingLimit) {
/*  864 */         xMailInfo = createAutoMailInfo(currentTime, mailType, title, content, delTimeMil, isZeroProfit, tagid);
/*  865 */         newMails.put(Integer.valueOf(roleMail.getNextIndex()), xMailInfo);
/*  866 */         thingCount = 0;
/*      */       }
/*  868 */       xbean.ThingBean xthingBean = Pod.newThingBean();
/*  869 */       fillDataInXThingBean(3, mailAttachment.getXiuLianExp(), 3, xthingBean);
/*      */       
/*  871 */       xMailInfo.getNotitemlist().add(xthingBean);
/*  872 */       thingCount++;
/*      */     }
/*      */     
/*      */ 
/*  876 */     if (mailAttachment.getStoreExp() > 0) {
/*  877 */       if (thingCount >= thingLimit) {
/*  878 */         xMailInfo = createAutoMailInfo(currentTime, mailType, title, content, delTimeMil, isZeroProfit, tagid);
/*  879 */         newMails.put(Integer.valueOf(roleMail.getNextIndex()), xMailInfo);
/*  880 */         thingCount = 0;
/*      */       }
/*  882 */       xbean.ThingBean xthingBean = Pod.newThingBean();
/*  883 */       fillDataInXThingBean(0, mailAttachment.getStoreExp(), 5, xthingBean);
/*      */       
/*  885 */       xMailInfo.getNotitemlist().add(xthingBean);
/*  886 */       thingCount++;
/*      */     }
/*      */     
/*  889 */     int mailCountLimit = SMailCfgConsts.getInstance().STORE_MAX;
/*      */     
/*  891 */     for (Map.Entry<Integer, MailInfo> entry : newMails.entrySet()) {
/*  892 */       if (roleMail.size() >= mailCountLimit) {
/*  893 */         delMailByRule(roleId, roleMail.getMailMap());
/*      */       }
/*  895 */       roleMail.add(((Integer)entry.getKey()).intValue(), (MailInfo)entry.getValue());
/*  896 */       int storeTime = MailManager.getInstance().getStoreTimeByType(mailType);
/*  897 */       if (storeTime <= 0) {}
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  904 */     if (OnlineManager.getInstance().isOnline(roleId)) {
/*  905 */       for (Map.Entry<Integer, MailInfo> entry : newMails.entrySet()) {
/*  906 */         SNewMailRes newMailRes = new SNewMailRes();
/*  907 */         fillInMailData(newMailRes.maildata, (MailInfo)entry.getValue(), ((Integer)entry.getKey()).intValue());
/*  908 */         OnlineManager.getInstance().send(roleId, newMailRes);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*  914 */     for (Map.Entry<Integer, MailInfo> entry : newMails.entrySet()) {
/*  915 */       onaddTLog(roleId, ((Integer)entry.getKey()).intValue(), (MailInfo)entry.getValue(), tLogArg);
/*      */     }
/*  917 */     return sendMailRet;
/*      */   }
/*      */   
/*      */   private static void onaddTLog(long roleid, int mailIndex, MailInfo xMailInfo, TLogArg tLogArg)
/*      */   {
/*  922 */     SnsFlowArg snsFlowArg = new SnsFlowArg(SNSTYPE.SNSTYPE_RECEIVEEMAIL, mailIndex);
/*  923 */     TlogUtil.tlogSnsFlow(roleid, 1, 1, snsFlowArg);
/*      */     
/*  925 */     int mainReason = -1;
/*  926 */     int subReason = -1;
/*      */     
/*  928 */     if (tLogArg != null) {
/*  929 */       mainReason = tLogArg.logReason.value;
/*  930 */       subReason = tLogArg.subReason;
/*      */     }
/*      */     
/*  933 */     tlogMail(roleid, mailIndex, xMailInfo, mainReason, subReason, 1);
/*      */   }
/*      */   
/*      */ 
/*      */   private static void tlogMail(long roleid, int mailIndex, MailInfo xMailInfo, int mainReason, int subReason, int opTye)
/*      */   {
/*  939 */     String userid = RoleInterface.getUserId(roleid);
/*  940 */     int roleLevel = RoleInterface.getLevel(roleid);
/*  941 */     int mailCfgid = getMailCfgid(xMailInfo);
/*  942 */     String mailTitle = getMailTitle(xMailInfo);
/*  943 */     String itemStr = getMailItemStr(xMailInfo);
/*  944 */     String notItemStr = getMailNotItemStr(xMailInfo);
/*  945 */     String logStr = String.format("%s|%d|%d|%d|%d|%d|%d|%s|%s|%s|%d", new Object[] { userid, Long.valueOf(roleid), Integer.valueOf(roleLevel), Integer.valueOf(mailIndex), Integer.valueOf(mainReason), Integer.valueOf(subReason), Integer.valueOf(mailCfgid), mailTitle, itemStr, notItemStr, Integer.valueOf(opTye) });
/*      */     
/*  947 */     TLogManager.getInstance().addLog(roleid, "Mail", logStr);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static int getMailCfgid(MailInfo xMailInfo)
/*      */   {
/*  956 */     String mailcfgid = (String)xMailInfo.getMailcontent().getContentmap().get(Integer.valueOf(51));
/*  957 */     if (mailcfgid == null) {
/*  958 */       return 0;
/*      */     }
/*  960 */     return Integer.parseInt(mailcfgid);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static String getMailTitle(MailInfo xMailInfo)
/*      */   {
/*  971 */     String mailTitle = (String)xMailInfo.getMailcontent().getContentmap().get(Integer.valueOf(52));
/*  972 */     if (mailTitle == null) {
/*  973 */       return "";
/*      */     }
/*  975 */     return mailTitle;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static String getMailItemStr(MailInfo xMailInfo)
/*      */   {
/*  986 */     List<Item> xItemsList = xMailInfo.getItemlist();
/*  987 */     if (xItemsList.size() <= 0) {
/*  988 */       return "";
/*      */     }
/*  990 */     StringBuilder stringBuilder = new StringBuilder();
/*  991 */     String splitString = ",";
/*  992 */     boolean first = true;
/*  993 */     for (Item xItem : xItemsList) {
/*  994 */       if (!first) {
/*  995 */         stringBuilder.append(splitString);
/*      */       } else {
/*  997 */         first = false;
/*      */       }
/*  999 */       stringBuilder.append(xItem.getCfgid()).append(",").append(xItem.getNumber());
/*      */     }
/* 1001 */     return stringBuilder.toString();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static String getMailNotItemStr(MailInfo xMailInfo)
/*      */   {
/* 1011 */     List<xbean.ThingBean> xNotItemsList = xMailInfo.getNotitemlist();
/* 1012 */     if (xNotItemsList.size() <= 0) {
/* 1013 */       return "";
/*      */     }
/* 1015 */     StringBuilder stringBuilder = new StringBuilder();
/* 1016 */     String splitString = ",";
/* 1017 */     boolean first = true;
/* 1018 */     for (xbean.ThingBean xThingBean : xNotItemsList) {
/* 1019 */       if (!first) {
/* 1020 */         stringBuilder.append(splitString);
/*      */       } else {
/* 1022 */         first = false;
/*      */       }
/* 1024 */       stringBuilder.append(xThingBean.getThingtype()).append(",").append(xThingBean.getId()).append(",").append(xThingBean.getCount());
/*      */     }
/*      */     
/* 1027 */     return stringBuilder.toString();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static SendMailRet canSendMail(long roleid, MailAttachment mailAttachment, TLogArg tLogArg)
/*      */   {
/* 1039 */     if ((tLogArg == null) && (mailAttachment.isHasItem())) {
/* 1040 */       return new SendMailRet(SendMailRet.RetEnum.SEND_MAIL_TLOG_NULL, false);
/*      */     }
/* 1042 */     if ((tLogArg == null) && (mailAttachment.isHasCurrency())) {
/* 1043 */       return new SendMailRet(SendMailRet.RetEnum.SEND_MAIL_TLOG_NULL, false);
/*      */     }
/* 1045 */     Properties properties = Role2properties.select(Long.valueOf(roleid));
/* 1046 */     if (properties == null) {
/* 1047 */       return new SendMailRet(SendMailRet.RetEnum.SEND_MAIL_ROLE_NOT_EXIST, false);
/*      */     }
/* 1049 */     return new SendMailRet(SendMailRet.RetEnum.SEND_MAIL_OK, false);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static SendMailRet buildAndSendCfgContentMail(long roleId, int mailCfgId, List<String> titleArgs, List<String> contentArgs, MailAttachment sendAttachment, TLogArg tLogArg, long delTimeMil, String tagid)
/*      */   {
/* 1065 */     if (GameServerInfoManager.isRoamServer()) {
/* 1066 */       GameServer.logger().info(String.format("[Mail]send mail error!!|roleid=%d|mailCfgid=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(mailCfgId) }));
/*      */       
/* 1068 */       return new SendMailRet(SendMailRet.RetEnum.SEND_MAIL_ROAM_SERVER, false);
/*      */     }
/* 1070 */     SMailCfg sMailCfg = SMailCfg.get(mailCfgId);
/* 1071 */     if (sMailCfg == null) {
/* 1072 */       GameServer.logger().error("发送邮件失败,mailCfgid:" + mailCfgId + "roleid:" + roleId);
/* 1073 */       return new SendMailRet(SendMailRet.RetEnum.SEND_MAIL_CFG_NOT_EXIST, false);
/*      */     }
/* 1075 */     MailAttachment mailAttachment = new MailAttachment(sendAttachment);
/* 1076 */     SendMailRet sendMailRet = canSendMail(roleId, mailAttachment, tLogArg);
/* 1077 */     if (!sendMailRet.isOK()) {
/* 1078 */       if (sendMailRet.isRoleNotExist()) {
/* 1079 */         GameServer.logger().error("发送邮件失败,不存在的玩家roleid:" + roleId + ",mailCfgid:" + mailCfgId);
/* 1080 */       } else if (sendMailRet.isMailTLogArgNull()) {
/* 1081 */         GameServer.logger().error("发送邮件失败,日志原因为null mailCfgid:" + mailCfgId + ",roleid:" + roleId);
/*      */       } else
/* 1083 */         GameServer.logger().error("发送邮件失败,mailCfgid:" + mailCfgId + ",roleid:" + roleId);
/* 1084 */       return sendMailRet;
/*      */     }
/* 1086 */     SendMailRet sendLimitRet = checkCfgLimit(roleId, sMailCfg);
/* 1087 */     if ((sendLimitRet.isOK()) && (sendLimitRet.isLimit())) {
/* 1088 */       GameServer.logger().info(String.format("[Mail]send mail error,limit!!|roleid=%d|mailCfgid=%d|desc=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(sMailCfg.id), mailAttachment.toString() }));
/*      */       
/*      */ 
/* 1091 */       return sendLimitRet; }
/* 1092 */     if (!sendLimitRet.isOK()) {
/* 1093 */       GameServer.logger().info(String.format("[Mail]send mail error,limit!!|roleid=%d|mailCfgid=%d|desc=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(sMailCfg.id), mailAttachment.toString() }));
/*      */       
/*      */ 
/* 1096 */       return sendLimitRet;
/*      */     }
/* 1098 */     RoleMail roleMail = new RoleMail(roleId, true);
/* 1099 */     if (roleMail.isNull()) {
/* 1100 */       MailMapBean xMailMapBean = Pod.newMailMapBean();
/* 1101 */       Role2mail.insert(Long.valueOf(roleId), xMailMapBean);
/* 1102 */       roleMail.setMailMapBean(xMailMapBean);
/*      */     }
/* 1104 */     boolean isZeroProfit = IdipManager.isZeroProfit(roleId);
/* 1105 */     long currentTime = DateTimeUtils.getCurrTimeInMillis();
/* 1106 */     Map<Integer, MailInfo> newMails = new HashMap();
/* 1107 */     MailInfo xMailInfo = createCfgMailInfo(currentTime, mailCfgId, titleArgs, contentArgs, 3, delTimeMil, isZeroProfit, tagid);
/*      */     
/* 1109 */     newMails.put(Integer.valueOf(roleMail.getNextIndex()), xMailInfo);
/* 1110 */     int thingCount = 0;
/* 1111 */     int thingLimit = SMailCfgConsts.getInstance().THING_MAX;
/*      */     
/*      */ 
/* 1114 */     for (Map.Entry<Integer, Integer> itemEntry : mailAttachment.getItemMap().entrySet()) {
/* 1115 */       int itemId = ((Integer)itemEntry.getKey()).intValue();
/* 1116 */       int itemCount = ((Integer)itemEntry.getValue()).intValue();
/* 1117 */       SItemCfg itemCfg = ItemInterface.getSItemCfg(itemId);
/* 1118 */       if (itemCfg == null) {
/* 1119 */         GameServer.logger().error("邮件中不能发送不存在的道具!itemid:" + itemId);
/* 1120 */         return new SendMailRet(SendMailRet.RetEnum.SEND_ITEM_NOT_EXIST, false);
/*      */       }
/* 1122 */       List<Item> xItems = null;
/* 1123 */       if (mailAttachment.getBindItems().contains(Integer.valueOf(itemId))) {
/* 1124 */         xItems = ItemInterface.createXItem(itemId, itemCount, null, true);
/*      */       } else {
/* 1126 */         xItems = ItemInterface.createXItem(itemId, itemCount, null, false);
/*      */       }
/* 1128 */       mailAttachment.addXItem(xItems);
/*      */     }
/* 1130 */     for (Item xItem : mailAttachment.getXitems()) {
/* 1131 */       if (thingCount >= thingLimit) {
/* 1132 */         xMailInfo = createCfgMailInfo(currentTime, mailCfgId, titleArgs, contentArgs, 3, delTimeMil, isZeroProfit, tagid);
/*      */         
/* 1134 */         newMails.put(Integer.valueOf(roleMail.getNextIndex()), xMailInfo);
/* 1135 */         thingCount = 0;
/*      */       }
/* 1137 */       xMailInfo.getItemlist().add(xItem.toBean());
/* 1138 */       thingCount++;
/*      */     }
/*      */     
/*      */ 
/* 1142 */     for (Map.Entry<Integer, Integer> tokenEntry : mailAttachment.getTokenMap().entrySet()) {
/* 1143 */       if (thingCount >= thingLimit) {
/* 1144 */         xMailInfo = createCfgMailInfo(currentTime, mailCfgId, titleArgs, contentArgs, 3, delTimeMil, isZeroProfit, tagid);
/*      */         
/* 1146 */         newMails.put(Integer.valueOf(roleMail.getNextIndex()), xMailInfo);
/* 1147 */         thingCount = 0;
/*      */       }
/* 1149 */       xbean.ThingBean xthingBean = Pod.newThingBean();
/* 1150 */       fillDataInXThingBean(((Integer)tokenEntry.getKey()).intValue(), ((Integer)tokenEntry.getValue()).intValue(), 2, xthingBean);
/*      */       
/* 1152 */       xMailInfo.getNotitemlist().add(xthingBean);
/* 1153 */       thingCount++;
/*      */     }
/*      */     
/* 1156 */     if (mailAttachment.getBindYuanBao() > 0) {
/* 1157 */       if (thingCount >= thingLimit) {
/* 1158 */         xMailInfo = createCfgMailInfo(currentTime, mailCfgId, titleArgs, contentArgs, 3, delTimeMil, isZeroProfit, tagid);
/*      */         
/* 1160 */         newMails.put(Integer.valueOf(roleMail.getNextIndex()), xMailInfo);
/* 1161 */         thingCount = 0;
/*      */       }
/* 1163 */       xbean.ThingBean xthingBean = Pod.newThingBean();
/* 1164 */       xthingBean.setSign(1);
/* 1165 */       fillDataInXThingBean(1, mailAttachment.getBindYuanBao(), 1, xthingBean);
/*      */       
/* 1167 */       xMailInfo.getNotitemlist().add(xthingBean);
/* 1168 */       thingCount++;
/*      */     }
/*      */     
/* 1171 */     if (mailAttachment.getYuanBao() > 0) {
/* 1172 */       if (thingCount >= thingLimit) {
/* 1173 */         xMailInfo = createCfgMailInfo(currentTime, mailCfgId, titleArgs, contentArgs, 3, delTimeMil, isZeroProfit, tagid);
/*      */         
/* 1175 */         newMails.put(Integer.valueOf(roleMail.getNextIndex()), xMailInfo);
/* 1176 */         thingCount = 0;
/*      */       }
/* 1178 */       xbean.ThingBean xthingBean = Pod.newThingBean();
/* 1179 */       xthingBean.setSign(0);
/* 1180 */       fillDataInXThingBean(1, mailAttachment.getYuanBao(), 1, xthingBean);
/*      */       
/* 1182 */       xMailInfo.getNotitemlist().add(xthingBean);
/* 1183 */       thingCount++;
/*      */     }
/*      */     
/* 1186 */     if (mailAttachment.getGold() > 0) {
/* 1187 */       if (thingCount >= thingLimit) {
/* 1188 */         xMailInfo = createCfgMailInfo(currentTime, mailCfgId, titleArgs, contentArgs, 3, delTimeMil, isZeroProfit, tagid);
/*      */         
/* 1190 */         newMails.put(Integer.valueOf(roleMail.getNextIndex()), xMailInfo);
/* 1191 */         thingCount = 0;
/*      */       }
/* 1193 */       xbean.ThingBean xthingBean = Pod.newThingBean();
/* 1194 */       fillDataInXThingBean(2, mailAttachment.getGold(), 1, xthingBean);
/*      */       
/* 1196 */       xMailInfo.getNotitemlist().add(xthingBean);
/* 1197 */       thingCount++;
/*      */     }
/*      */     
/* 1200 */     if (mailAttachment.getGoldIngot() > 0) {
/* 1201 */       if (thingCount >= thingLimit) {
/* 1202 */         xMailInfo = createCfgMailInfo(currentTime, mailCfgId, titleArgs, contentArgs, 3, delTimeMil, isZeroProfit, tagid);
/*      */         
/* 1204 */         newMails.put(Integer.valueOf(roleMail.getNextIndex()), xMailInfo);
/* 1205 */         thingCount = 0;
/*      */       }
/* 1207 */       xbean.ThingBean xthingBean = Pod.newThingBean();
/* 1208 */       fillDataInXThingBean(5, mailAttachment.getGoldIngot(), 1, xthingBean);
/*      */       
/* 1210 */       xMailInfo.getNotitemlist().add(xthingBean);
/* 1211 */       thingCount++;
/*      */     }
/*      */     
/* 1214 */     if (mailAttachment.getSilver() > 0) {
/* 1215 */       if (thingCount >= thingLimit) {
/* 1216 */         xMailInfo = createCfgMailInfo(currentTime, mailCfgId, titleArgs, contentArgs, 3, delTimeMil, isZeroProfit, tagid);
/*      */         
/* 1218 */         newMails.put(Integer.valueOf(roleMail.getNextIndex()), xMailInfo);
/* 1219 */         thingCount = 0;
/*      */       }
/* 1221 */       xbean.ThingBean xthingBean = Pod.newThingBean();
/* 1222 */       fillDataInXThingBean(3, mailAttachment.getSilver(), 1, xthingBean);
/*      */       
/* 1224 */       xMailInfo.getNotitemlist().add(xthingBean);
/* 1225 */       thingCount++;
/*      */     }
/*      */     
/*      */ 
/* 1229 */     if (mailAttachment.getVigor() > 0) {
/* 1230 */       if (thingCount >= thingLimit) {
/* 1231 */         xMailInfo = createCfgMailInfo(currentTime, mailCfgId, titleArgs, contentArgs, 3, delTimeMil, isZeroProfit, tagid);
/*      */         
/* 1233 */         newMails.put(Integer.valueOf(roleMail.getNextIndex()), xMailInfo);
/* 1234 */         thingCount = 0;
/*      */       }
/* 1236 */       xbean.ThingBean xthingBean = Pod.newThingBean();
/* 1237 */       fillDataInXThingBean(0, mailAttachment.getVigor(), 4, xthingBean);
/* 1238 */       xMailInfo.getNotitemlist().add(xthingBean);
/* 1239 */       thingCount++;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1244 */     if (mailAttachment.getRoleExp() > 0) {
/* 1245 */       if (thingCount >= thingLimit) {
/* 1246 */         xMailInfo = createCfgMailInfo(currentTime, mailCfgId, titleArgs, contentArgs, 3, delTimeMil, isZeroProfit, tagid);
/*      */         
/* 1248 */         newMails.put(Integer.valueOf(roleMail.getNextIndex()), xMailInfo);
/* 1249 */         thingCount = 0;
/*      */       }
/* 1251 */       xbean.ThingBean xthingBean = Pod.newThingBean();
/* 1252 */       fillDataInXThingBean(1, mailAttachment.getRoleExp(), 3, xthingBean);
/*      */       
/* 1254 */       xMailInfo.getNotitemlist().add(xthingBean);
/* 1255 */       thingCount++;
/*      */     }
/*      */     
/* 1258 */     if (mailAttachment.getPetExp() > 0) {
/* 1259 */       if (thingCount >= thingLimit) {
/* 1260 */         xMailInfo = createCfgMailInfo(currentTime, mailCfgId, titleArgs, contentArgs, 3, delTimeMil, isZeroProfit, tagid);
/*      */         
/* 1262 */         newMails.put(Integer.valueOf(roleMail.getNextIndex()), xMailInfo);
/* 1263 */         thingCount = 0;
/*      */       }
/* 1265 */       xbean.ThingBean xthingBean = Pod.newThingBean();
/* 1266 */       fillDataInXThingBean(2, mailAttachment.getPetExp(), 3, xthingBean);
/*      */       
/* 1268 */       xMailInfo.getNotitemlist().add(xthingBean);
/* 1269 */       thingCount++;
/*      */     }
/*      */     
/*      */ 
/* 1273 */     if (mailAttachment.getXiuLianExp() > 0) {
/* 1274 */       if (thingCount >= thingLimit) {
/* 1275 */         xMailInfo = createCfgMailInfo(currentTime, mailCfgId, titleArgs, contentArgs, 3, delTimeMil, isZeroProfit, tagid);
/*      */         
/* 1277 */         newMails.put(Integer.valueOf(roleMail.getNextIndex()), xMailInfo);
/* 1278 */         thingCount = 0;
/*      */       }
/* 1280 */       xbean.ThingBean xthingBean = Pod.newThingBean();
/* 1281 */       fillDataInXThingBean(3, mailAttachment.getXiuLianExp(), 3, xthingBean);
/*      */       
/* 1283 */       xMailInfo.getNotitemlist().add(xthingBean);
/* 1284 */       thingCount++;
/*      */     }
/*      */     
/*      */ 
/* 1288 */     if (mailAttachment.getStoreExp() > 0) {
/* 1289 */       if (thingCount >= thingLimit) {
/* 1290 */         xMailInfo = createCfgMailInfo(currentTime, mailCfgId, titleArgs, contentArgs, 3, delTimeMil, isZeroProfit, tagid);
/*      */         
/* 1292 */         newMails.put(Integer.valueOf(roleMail.getNextIndex()), xMailInfo);
/* 1293 */         thingCount = 0;
/*      */       }
/* 1295 */       xbean.ThingBean xthingBean = Pod.newThingBean();
/* 1296 */       fillDataInXThingBean(0, mailAttachment.getStoreExp(), 5, xthingBean);
/*      */       
/* 1298 */       xMailInfo.getNotitemlist().add(xthingBean);
/* 1299 */       thingCount++;
/*      */     }
/*      */     
/* 1302 */     int mailCountLimit = SMailCfgConsts.getInstance().STORE_MAX;
/* 1303 */     int mailType = SMailCfg.get(mailCfgId).mailType;
/*      */     
/* 1305 */     for (Map.Entry<Integer, MailInfo> entry : newMails.entrySet()) {
/* 1306 */       if (roleMail.size() >= mailCountLimit) {
/* 1307 */         delMailByRule(roleId, roleMail.getMailMap());
/*      */       }
/* 1309 */       roleMail.add(((Integer)entry.getKey()).intValue(), (MailInfo)entry.getValue());
/* 1310 */       int storeTime = MailManager.getInstance().getStoreTimeByType(mailType);
/* 1311 */       if (storeTime <= 0) {}
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1318 */     if (OnlineManager.getInstance().isOnline(roleId)) {
/* 1319 */       for (Map.Entry<Integer, MailInfo> entry : newMails.entrySet()) {
/* 1320 */         SNewMailRes newMailRes = new SNewMailRes();
/* 1321 */         fillInMailData(newMailRes.maildata, (MailInfo)entry.getValue(), ((Integer)entry.getKey()).intValue());
/* 1322 */         OnlineManager.getInstance().send(roleId, newMailRes);
/*      */       }
/*      */     }
/*      */     
/*      */ 
/*      */ 
/* 1328 */     for (Map.Entry<Integer, MailInfo> entry : newMails.entrySet()) {
/* 1329 */       onaddTLog(roleId, ((Integer)entry.getKey()).intValue(), (MailInfo)entry.getValue(), tLogArg);
/*      */     }
/* 1331 */     return sendMailRet;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static SendMailRet buildAndSendCfgMail(long roleid, int mailCfgId, List<String> titleArgs, List<String> contentArgs, TLogArg logArg, long delTimeMil, String tagid)
/*      */   {
/* 1345 */     if (GameServerInfoManager.isRoamServer()) {
/* 1346 */       GameServer.logger().info(String.format("[Mail]send mail error!!|roleid=%d|mailCfgid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(mailCfgId) }));
/*      */       
/* 1348 */       return new SendMailRet(SendMailRet.RetEnum.SEND_MAIL_ROAM_SERVER, false);
/*      */     }
/* 1350 */     SMailCfg sMailCfg = SMailCfg.get(mailCfgId);
/* 1351 */     if (sMailCfg == null) {
/* 1352 */       GameServer.logger().error("发送邮件失败,mailCfgid:" + mailCfgId + "roleid:" + roleid);
/* 1353 */       return new SendMailRet(SendMailRet.RetEnum.SEND_MAIL_CFG_NOT_EXIST, false);
/*      */     }
/* 1355 */     MailAttachment mailAttachment = new MailAttachment();
/* 1356 */     mailAttachment.setGold(sMailCfg.gold);
/* 1357 */     mailAttachment.setGoldIngot(sMailCfg.goldIngot);
/* 1358 */     mailAttachment.setItemMap(sMailCfg.itemMap);
/* 1359 */     mailAttachment.setSilver(sMailCfg.silver);
/* 1360 */     mailAttachment.setTokenMap(sMailCfg.tokenMap);
/* 1361 */     mailAttachment.setBindYuanBao(sMailCfg.yuanbao);
/* 1362 */     SendMailRet sendMailRet = canSendMail(roleid, mailAttachment, logArg);
/* 1363 */     if (!sendMailRet.isOK()) {
/* 1364 */       if (sendMailRet.isRoleNotExist()) {
/* 1365 */         GameServer.logger().error("发送邮件失败,不存在的玩家roleid:" + roleid + ",mailCfgid:" + mailCfgId);
/* 1366 */       } else if (sendMailRet.isMailTLogArgNull()) {
/* 1367 */         GameServer.logger().error("发送邮件失败,日志原因为null mailCfgid:" + mailCfgId + ",roleid:" + roleid);
/*      */       } else {
/* 1369 */         GameServer.logger().error("发送邮件失败,mailCfgid:" + mailCfgId + ",roleid:" + roleid);
/*      */       }
/* 1371 */       return sendMailRet;
/*      */     }
/* 1373 */     SendMailRet sendLimitRet = checkCfgLimit(roleid, sMailCfg);
/* 1374 */     if ((sendLimitRet.isOK()) && (sendLimitRet.isLimit())) {
/* 1375 */       GameServer.logger().info(String.format("[Mail]send mail error,limit!!|roleid=%d|mailCfgid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(sMailCfg.id) }));
/*      */       
/* 1377 */       return sendLimitRet; }
/* 1378 */     if (!sendLimitRet.isOK()) {
/* 1379 */       GameServer.logger().info(String.format("[Mail]send mail error|roleid=%d|mailCfgid=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(sMailCfg.id) }));
/*      */       
/* 1381 */       return sendLimitRet;
/*      */     }
/* 1383 */     RoleMail roleMail = new RoleMail(roleid, true);
/* 1384 */     if (roleMail.isNull()) {
/* 1385 */       MailMapBean xMailMapBean = Pod.newMailMapBean();
/* 1386 */       Role2mail.insert(Long.valueOf(roleid), xMailMapBean);
/* 1387 */       roleMail.setMailMapBean(xMailMapBean);
/*      */     }
/* 1389 */     boolean isZeroProfit = IdipManager.isZeroProfit(roleid);
/* 1390 */     long currentTime = DateTimeUtils.getCurrTimeInMillis();
/* 1391 */     Map<Integer, MailInfo> newMails = new HashMap();
/* 1392 */     MailInfo xMailInfo = createCfgMailInfo(currentTime, mailCfgId, titleArgs, contentArgs, 1, delTimeMil, isZeroProfit, tagid);
/*      */     
/* 1394 */     int index = roleMail.getNextIndex();
/* 1395 */     newMails.put(Integer.valueOf(index), xMailInfo);
/* 1396 */     if (roleMail.size() >= SMailCfgConsts.getInstance().STORE_MAX) {
/* 1397 */       delMailByRule(roleid, roleMail.getMailMap());
/*      */     }
/* 1399 */     roleMail.add(index, xMailInfo);
/* 1400 */     int storeTime = MailManager.getInstance().getStoreTimeByType(sMailCfg.mailType);
/* 1401 */     if ((storeTime <= 0) || 
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1406 */       (OnlineManager.getInstance().isOnline(roleid))) {
/* 1407 */       SNewMailRes newMailRes = new SNewMailRes();
/* 1408 */       fillInMailData(newMailRes.maildata, xMailInfo, index);
/* 1409 */       OnlineManager.getInstance().send(roleid, newMailRes);
/*      */     }
/*      */     
/*      */ 
/* 1413 */     for (Map.Entry<Integer, MailInfo> entry : newMails.entrySet()) {
/* 1414 */       onaddTLog(roleid, ((Integer)entry.getKey()).intValue(), (MailInfo)entry.getValue(), logArg);
/*      */     }
/* 1416 */     return sendMailRet;
/*      */   }
/*      */   
/*      */   private static SendMailRet checkCfgLimit(long roleid, SMailCfg sMailCfg) {
/* 1420 */     int level = RoleInterface.getLevel(roleid);
/* 1421 */     if ((sMailCfg.minLevel >= 0) && 
/* 1422 */       (level < sMailCfg.minLevel)) {
/* 1423 */       GameServer.logger().info(String.format("[Mail]send mail error,level limit!!|roleid=%d|mailCfgid=%d|level=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(sMailCfg.id), Integer.valueOf(level) }));
/*      */       
/*      */ 
/* 1426 */       return new SendMailRet(SendMailRet.RetEnum.SEND_MAIL_OK, true);
/*      */     }
/*      */     
/* 1429 */     if ((sMailCfg.maxLevel >= 0) && 
/* 1430 */       (level > sMailCfg.maxLevel)) {
/* 1431 */       GameServer.logger().info(String.format("[Mail]send mail error,level limit!!|roleid=%d|mailCfgid=%d|level=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(sMailCfg.id), Integer.valueOf(level) }));
/*      */       
/*      */ 
/* 1434 */       return new SendMailRet(SendMailRet.RetEnum.SEND_MAIL_OK, true);
/*      */     }
/*      */     
/* 1437 */     STimeLimitCommonCfg timeLimitCommonCfg = STimeLimitCommonCfg.get(sMailCfg.timeLimitid);
/* 1438 */     if (timeLimitCommonCfg != null) {
/* 1439 */       long curTime = DateTimeUtils.getCurrTimeInMillis();
/* 1440 */       long beginTime = TimeCommonUtil.getLimitTimeBegin(timeLimitCommonCfg);
/* 1441 */       long endTime = TimeCommonUtil.getLimitTimeEnd(timeLimitCommonCfg);
/* 1442 */       if ((curTime < beginTime) || (curTime > endTime)) {
/* 1443 */         GameServer.logger().info(String.format("[Mail]send mail error,time limit!!|roleid=%d|mailCfgid=%d|curTime=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(sMailCfg.id), Long.valueOf(curTime) }));
/*      */         
/*      */ 
/* 1446 */         return new SendMailRet(SendMailRet.RetEnum.SEND_MAIL_OK, true);
/*      */       }
/*      */     }
/* 1449 */     return new SendMailRet(SendMailRet.RetEnum.SEND_MAIL_OK, false);
/*      */   }
/*      */   
/*      */   private static void fillDataInXThingBean(int id, int count, int type, xbean.ThingBean xthingBean) {
/* 1453 */     xthingBean.setId(id);
/* 1454 */     xthingBean.setCount(count);
/* 1455 */     xthingBean.setThingtype(type);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static void delMailByRule(long roleId, Map<Integer, MailInfo> mailmap)
/*      */   {
/* 1464 */     Iterator<Map.Entry<Integer, MailInfo>> iterator = mailmap.entrySet().iterator();
/* 1465 */     Map.Entry<Integer, MailInfo> delEntry = null;
/* 1466 */     if (iterator.hasNext()) {
/* 1467 */       delEntry = (Map.Entry)iterator.next();
/*      */     }
/* 1469 */     while (iterator.hasNext()) {
/* 1470 */       Map.Entry<Integer, MailInfo> entry = (Map.Entry)iterator.next();
/* 1471 */       MailInfo xOldMailInfo = (MailInfo)delEntry.getValue();
/* 1472 */       MailInfo xNewMailInfo = (MailInfo)entry.getValue();
/* 1473 */       boolean oldHasAttach = mailHasThing(xOldMailInfo);
/* 1474 */       boolean newHasAttach = mailHasThing(xNewMailInfo);
/*      */       
/* 1476 */       if ((oldHasAttach) && (!newHasAttach)) {
/* 1477 */         delEntry = entry;
/*      */ 
/*      */ 
/*      */       }
/* 1481 */       else if ((!(oldHasAttach ^ newHasAttach)) && (((MailInfo)entry.getValue()).getCreatetime() < ((MailInfo)delEntry.getValue()).getCreatetime()))
/*      */       {
/* 1483 */         delEntry = entry;
/*      */       }
/*      */     }
/*      */     
/* 1487 */     if (delEntry != null) {
/* 1488 */       int mailIndexid = ((Integer)delEntry.getKey()).intValue();
/* 1489 */       MailInfo xMailInfo = (MailInfo)mailmap.remove(Integer.valueOf(mailIndexid));
/* 1490 */       onDelLog(roleId, mailIndexid, xMailInfo);
/* 1491 */       if (OnlineManager.getInstance().isOnline(roleId)) {
/* 1492 */         SDelMailRes sDelMailRes = new SDelMailRes();
/* 1493 */         sDelMailRes.mailindex = mailIndexid;
/* 1494 */         OnlineManager.getInstance().send(roleId, sDelMailRes);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isMailFullCfg(MailInfo xMailInfo)
/*      */   {
/* 1506 */     return xMailInfo.getMailcontent().getMailcontenttype() == 1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void sendNormalResult(long roleId, int ret, String... args)
/*      */   {
/* 1517 */     SNormalResult sNormalResult = new SNormalResult();
/* 1518 */     sNormalResult.ret = ret;
/* 1519 */     for (String s : args) {
/* 1520 */       sNormalResult.args.add(s);
/*      */     }
/* 1522 */     OnlineManager.getInstance().sendAtOnce(roleId, sNormalResult);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static MailInfo createAutoMailInfo(long createTime, int mailType, String title, String content, long delMailMil, boolean isZeroProfit, String tagid)
/*      */   {
/* 1536 */     MailInfo xMailInfo = Pod.newMailInfo();
/* 1537 */     xMailInfo.setCreatetime(createTime);
/* 1538 */     xMailInfo.setState(0);
/* 1539 */     xMailInfo.setTagid(tagid);
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1548 */     xMailInfo.getMailcontent().setMailcontenttype(2);
/* 1549 */     xMailInfo.getMailcontent().getContentmap().put(Integer.valueOf(53), mailType + "");
/* 1550 */     xMailInfo.getMailcontent().getContentmap().put(Integer.valueOf(52), title);
/* 1551 */     xMailInfo.getMailcontent().getContentmap().put(Integer.valueOf(54), content);
/* 1552 */     if (delMailMil > 0L) {
/* 1553 */       xMailInfo.getExtradatamap().put(Integer.valueOf(4), Integer.valueOf((int)(delMailMil / 1000L)));
/*      */     }
/* 1555 */     if (isZeroProfit) {
/* 1556 */       xMailInfo.getExtradatamap().put(Integer.valueOf(5), Integer.valueOf(0));
/*      */     }
/* 1558 */     return xMailInfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private static MailInfo createCfgMailInfo(long createTime, int cfgid, List<String> titleArgs, List<String> contentArgs, int contentType, long delMailMil, boolean isZeroProfit, String tagid)
/*      */   {
/* 1576 */     MailInfo xMailInfo = Pod.newMailInfo();
/* 1577 */     xMailInfo.setCreatetime(createTime);
/* 1578 */     xMailInfo.setState(0);
/* 1579 */     xMailInfo.setTagid(tagid);
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1588 */     xMailInfo.getMailcontent().setMailcontenttype(contentType);
/* 1589 */     xMailInfo.getMailcontent().getContentmap().put(Integer.valueOf(51), cfgid + "");
/* 1590 */     if ((titleArgs != null) && (titleArgs.size() > 0)) {
/* 1591 */       xbean.FormatArgs formatArgs = Pod.newFormatArgs();
/* 1592 */       formatArgs.getArgs().addAll(titleArgs);
/* 1593 */       xMailInfo.getMailcontent().getFormatargsmap().put(Integer.valueOf(201), formatArgs);
/*      */     }
/* 1595 */     if ((contentArgs != null) && (contentArgs.size() > 0)) {
/* 1596 */       xbean.FormatArgs formatArgs = Pod.newFormatArgs();
/* 1597 */       formatArgs.getArgs().addAll(contentArgs);
/* 1598 */       xMailInfo.getMailcontent().getFormatargsmap().put(Integer.valueOf(202), formatArgs);
/*      */     }
/*      */     
/* 1601 */     if (delMailMil > 0L) {
/* 1602 */       xMailInfo.getExtradatamap().put(Integer.valueOf(4), Integer.valueOf((int)(delMailMil / 1000L)));
/*      */     }
/* 1604 */     if (isZeroProfit) {
/* 1605 */       xMailInfo.getExtradatamap().put(Integer.valueOf(5), Integer.valueOf(1));
/*      */     }
/* 1607 */     return xMailInfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onRoleLogOff(long roleId) {}
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void onDelLog(long roleid, int mailIndex, MailInfo xMailInfo)
/*      */   {
/* 1620 */     tlogMail(roleid, mailIndex, xMailInfo, 0, 0, 2);
/*      */   }
/*      */   
/*      */   static void sendDelMailMsg(long roleid, int mailid) {
/* 1624 */     SDelMailRes delMailRes = new SDelMailRes();
/* 1625 */     delMailRes.mailindex = mailid;
/* 1626 */     OnlineManager.getInstance().send(roleid, delMailRes);
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mail\main\RoleMailManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */