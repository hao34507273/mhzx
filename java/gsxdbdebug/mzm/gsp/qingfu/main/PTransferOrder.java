/*     */ package mzm.gsp.qingfu.main;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.SSyncCashInfo;
/*     */ import mzm.gsp.qingfu.confbean.SQingfuCfg;
/*     */ import mzm.gsp.qingfu.event.SaveAmtChanged;
/*     */ import mzm.gsp.qingfu.event.SaveAmtChangedArg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.role.main.UserOneByOneManager;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.yuanbao.main.CurrencyType;
/*     */ import openau.TransferOrderArg;
/*     */ import openau.TransferOrderRes;
/*     */ import org.apache.log4j.Logger;
/*     */ import org.json.JSONArray;
/*     */ import org.json.JSONObject;
/*     */ import xbean.Pod;
/*     */ import xbean.QingfuInfo;
/*     */ import xtable.Qingfu;
/*     */ 
/*     */ public class PTransferOrder extends LogicProcedure
/*     */ {
/*     */   private final TransferOrderArg arg;
/*     */   private final TransferOrderRes res;
/*     */   
/*     */   public PTransferOrder(TransferOrderArg arg, TransferOrderRes res)
/*     */   {
/*  43 */     this.arg = arg;
/*  44 */     this.res = res;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*     */     try
/*     */     {
/*  52 */       String userId = this.arg.account.getString("UTF-8");
/*  53 */       long roleId = this.arg.roleid <= 0L ? QingfuManager.getSuitableRoleId(userId).longValue() : this.arg.roleid;
/*  54 */       long createOrderTime = this.arg.createtime;
/*  55 */       String gameOrderId = this.arg.gameorderid.getString("UTF-8");
/*  56 */       String gameProductId = this.arg.gameproductid.getString("UTF-8");
/*  57 */       int gameProductAmount = this.arg.gameproductamount;
/*  58 */       String platId = this.arg.platid.getString("UTF-8");
/*  59 */       String payPlatId = this.arg.payplatid.getString("UTF-8");
/*  60 */       String deviceCategory = this.arg.devicecategory.getString("UTF-8");
/*  61 */       long platCallbackOrderTime = this.arg.platcallbacktime;
/*  62 */       String platOrderId = this.arg.platorderid.getString("UTF-8");
/*  63 */       String platProductId = this.arg.platproductid.getString("UTF-8");
/*  64 */       int platProductAmount = this.arg.platproductamount;
/*  65 */       String platCurrency = this.arg.platcurrency.getString("UTF-8");
/*  66 */       int rawAmount = this.arg.rawamount;
/*  67 */       String rawCurrency = this.arg.rawcurrency.getString("UTF-8");
/*  68 */       int flags = this.arg.flags;
/*  69 */       int gameCurrencyType = this.arg.cashtype;
/*  70 */       int gameCurrencyNum = this.arg.cashamount;
/*  71 */       int extraGameCurrencyNum = this.arg.extracashamount;
/*     */       
/*  73 */       OctetsStream os = new OctetsStream(this.arg.gameserverext);
/*  74 */       int bookCfgId = os.unmarshal_int();
/*  75 */       int realCfgId = QingfuManager.getCfgIdByProductId(payPlatId, platProductId);
/*  76 */       int cfgId = realCfgId > 0 ? realCfgId : bookCfgId;
/*  77 */       SQingfuCfg cfg = SQingfuCfg.get(cfgId);
/*     */       
/*  79 */       int sn = this.arg.sn;
/*     */       
/*  81 */       xbean.User xUser = xtable.User.get(userId);
/*  82 */       if (xUser == null)
/*     */       {
/*  84 */         xUser = Pod.newUser();
/*  85 */         xtable.User.add(userId, xUser);
/*     */       }
/*  87 */       int lastSN = xUser.getSn();
/*  88 */       int nextSN = lastSN + 1;
/*  89 */       if (nextSN != sn)
/*     */       {
/*  91 */         this.res.retcode = 20;
/*  92 */         this.res.finalsucceedorderid = Octets.wrap(xUser.getFinal_success_order_id(), "UTF-8");
/*  93 */         this.res.sn = lastSN;
/*  94 */         GameServer.logger().warn(String.format("PTransferOrder.processImp@transfer order failed, due to sn not match|roleid=%d|userid=%s|cfgid=%d|create_time=%d|game_order_id=%s|game_product_id=%s|game_product_amount=%d|platid=%s|pay_platid=%s|device_category=%s|plat_callback_time=%d|plat_order_id=%s|plat_product_id=%s|plat_product_amount=%d|plat_currency=%s|raw_amount=%d|raw_currency=%s|flags=%d|game_currency_type=%d|game_currency_num=%d|extra_game_currency_num=%d|syn_sn=%d|need_sn=%d", new Object[] { Long.valueOf(roleId), userId, Integer.valueOf(cfgId), Long.valueOf(createOrderTime), gameOrderId, gameProductId, Integer.valueOf(gameProductAmount), platId, payPlatId, deviceCategory, Long.valueOf(platCallbackOrderTime), platOrderId, platProductId, Integer.valueOf(platProductAmount), platCurrency, Integer.valueOf(rawAmount), rawCurrency, Integer.valueOf(flags), Integer.valueOf(gameCurrencyType), Integer.valueOf(gameCurrencyNum), Integer.valueOf(extraGameCurrencyNum), Integer.valueOf(sn), Integer.valueOf(nextSN) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 101 */         return true;
/*     */       }
/*     */       
/* 104 */       AddedCashInfo addedCashInfo = new AddedCashInfo();
/* 105 */       if (gameCurrencyNum > 0)
/*     */       {
/* 107 */         addedCashInfo.addedYuanbao = gameCurrencyNum;
/* 108 */         addedCashInfo.addedVipExp = gameCurrencyNum;
/*     */       }
/*     */       else
/*     */       {
/* 112 */         getAddedCash(platProductAmount, cfg, addedCashInfo);
/*     */       }
/* 114 */       if (extraGameCurrencyNum > 0)
/*     */       {
/* 116 */         addedCashInfo.addedBindYuanbao += extraGameCurrencyNum;
/*     */       }
/* 118 */       if ((flags & 0x4) != 0)
/*     */       {
/* 120 */         addedCashInfo.addedVipExp = 0;
/*     */       }
/*     */       
/*     */ 
/* 124 */       xUser.setSn(nextSN);
/* 125 */       xUser.setFinal_success_order_id(gameOrderId);
/*     */       
/*     */ 
/* 128 */       SSyncCashInfo core = new SSyncCashInfo();
/*     */       
/*     */ 
/* 131 */       QingfuInfo xQingfuInfo = Qingfu.get(userId);
/* 132 */       if (xQingfuInfo == null)
/*     */       {
/* 134 */         xQingfuInfo = Pod.newQingfuInfo();
/* 135 */         Qingfu.add(userId, xQingfuInfo);
/*     */       }
/*     */       
/* 138 */       if ((cfg.productServiceId > 0) && (cfg.productServiceDurationDays > 0))
/*     */       {
/* 140 */         if (!convertTSSInfo(userId, cfg, xQingfuInfo))
/*     */         {
/* 142 */           this.res.retcode = 4;
/*     */           
/* 144 */           GameServer.logger().error(String.format("PTransferOrder.processImp@convert tss info failed|roleid=%d|userid=%s|cfgid=%d|create_time=%d|game_order_id=%s|game_product_id=%s|game_product_amount=%d|platid=%s|pay_platid=%s|device_category=%s|plat_callback_time=%d|plat_order_id=%s|plat_product_id=%s|plat_product_amount=%d|plat_currency=%s|raw_amount=%d|raw_currency=%s|flags=%d|game_currency_type=%d|game_currency_num=%d|extra_game_currency_num=%d|sync_sn=%d|ack_sn=%d|added_yuanbao=%d|added_vip_exp=%d", new Object[] { Long.valueOf(roleId), userId, Integer.valueOf(cfgId), Long.valueOf(createOrderTime), gameOrderId, gameProductId, Integer.valueOf(gameProductAmount), platId, payPlatId, deviceCategory, Long.valueOf(platCallbackOrderTime), platOrderId, platProductId, Integer.valueOf(platProductAmount), platCurrency, Integer.valueOf(rawAmount), rawCurrency, Integer.valueOf(flags), Integer.valueOf(gameCurrencyType), Integer.valueOf(gameCurrencyNum), Integer.valueOf(extraGameCurrencyNum), Integer.valueOf(sn), Integer.valueOf(nextSN), Integer.valueOf(addedCashInfo.addedYuanbao), Integer.valueOf(addedCashInfo.addedVipExp) }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 153 */           return false;
/*     */         }
/*     */       }
/*     */       
/* 157 */       if (addedCashInfo.addedYuanbao > 0)
/*     */       {
/* 159 */         long totalCash = xQingfuInfo.getTotal_cash() + addedCashInfo.addedYuanbao;
/* 160 */         xQingfuInfo.setTotal_cash(totalCash);
/*     */         
/* 162 */         core.infos.put(Integer.valueOf(2), Long.valueOf(totalCash));
/*     */         
/*     */ 
/* 165 */         QingfuManager.addCurrencyLog(userId, roleId, CurrencyType.CURRENCY_BUYYUANBAO, addedCashInfo.addedYuanbao, QingfuManager.getYuanbao(xQingfuInfo), new TLogArg(LogReason.RECHARGE_ADD, cfgId));
/*     */       }
/*     */       
/*     */ 
/* 169 */       if (addedCashInfo.addedBindYuanbao > 0)
/*     */       {
/* 171 */         long totalPresentBind = xQingfuInfo.getTotal_present_bind() + addedCashInfo.addedBindYuanbao;
/* 172 */         xQingfuInfo.setTotal_present_bind(totalPresentBind);
/*     */         
/* 174 */         core.infos.put(Integer.valueOf(6), Long.valueOf(totalPresentBind));
/*     */         
/* 176 */         QingfuManager.addCurrencyLog(userId, roleId, CurrencyType.CURRENCY_AWARDYUANBAO, addedCashInfo.addedBindYuanbao, QingfuManager.getYuanbao(xQingfuInfo), new TLogArg(LogReason.RECHARGE_ADD, cfgId));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 181 */       if (addedCashInfo.addedVipExp > 0)
/*     */       {
/* 183 */         long oldSaveAmt = xQingfuInfo.getSave_amt();
/* 184 */         long saveAmt = oldSaveAmt + addedCashInfo.addedVipExp;
/* 185 */         xQingfuInfo.setSave_amt(saveAmt);
/*     */         
/* 187 */         xQingfuInfo.setRecharge_times(xQingfuInfo.getRecharge_times() + 1);
/*     */         
/*     */ 
/* 190 */         xQingfuInfo.setStatis_recharge_first_consume_status(0);
/*     */         
/* 192 */         long totalSaveAmt = QingfuManager.getSaveAmt(xQingfuInfo);
/* 193 */         core.infos.put(Integer.valueOf(1), Long.valueOf(totalSaveAmt));
/*     */         
/* 195 */         long oldTotalSaveAmt = oldSaveAmt + xQingfuInfo.getInner_save_amt();
/* 196 */         SaveAmtChangedArg arg = new SaveAmtChangedArg(userId, oldTotalSaveAmt, totalSaveAmt);
/* 197 */         SaveAmtChanged event = new SaveAmtChanged();
/* 198 */         TriggerEventsManger.getInstance().triggerEvent(event, arg, UserOneByOneManager.getInstance().getTaskOneByOne(userId));
/*     */       }
/*     */       
/*     */ 
/* 202 */       if (addedCashInfo.addedVipExp > 0)
/*     */       {
/* 204 */         xQingfuInfo.setTotal_cash_amt(xQingfuInfo.getTotal_cash_amt() + platProductAmount);
/*     */       }
/*     */       
/*     */ 
/* 208 */       if ((cfg.productServiceType == 6) && (cfg.productServiceId > 0))
/*     */       {
/* 210 */         int awardCfgid = cfg.productServiceId;
/* 211 */         AwardReason buyItemsAwardReason = new AwardReason(LogReason.DIRECTLY_BUY_ITEMS_AWARD, awardCfgid);
/* 212 */         AwardModel awardModel = AwardInterface.awardFixAward(awardCfgid, userId, roleId, false, true, buyItemsAwardReason);
/*     */         
/* 214 */         if (awardModel == null)
/*     */         {
/* 216 */           GameServer.logger().error(String.format("PTransferOrder.processImp@directly buy items failed|roleid=%d|userid=%s|cfgid=%d|create_time=%d|game_order_id=%s|game_product_id=%s|game_product_amount=%d|platid=%s|pay_platid=%s|device_category=%s|plat_callback_time=%d|plat_order_id=%s|plat_product_id=%s|plat_product_amount=%d|plat_currency=%s|raw_amount=%d|raw_currency=%s|flags=%d|game_currency_type=%d|game_currency_num=%d|extra_game_currency_num=%d|sync_sn=%d|ack_sn=%d|added_yuanbao=%d|added_vip_exp=%d|cfgid=%d|award_cfgid=%d", new Object[] { Long.valueOf(roleId), userId, Integer.valueOf(cfgId), Long.valueOf(createOrderTime), gameOrderId, gameProductId, Integer.valueOf(gameProductAmount), platId, payPlatId, deviceCategory, Long.valueOf(platCallbackOrderTime), platOrderId, platProductId, Integer.valueOf(platProductAmount), platCurrency, Integer.valueOf(rawAmount), rawCurrency, Integer.valueOf(flags), Integer.valueOf(gameCurrencyType), Integer.valueOf(gameCurrencyNum), Integer.valueOf(extraGameCurrencyNum), Integer.valueOf(sn), Integer.valueOf(nextSN), Integer.valueOf(addedCashInfo.addedYuanbao), Integer.valueOf(addedCashInfo.addedVipExp), Integer.valueOf(cfg.id), Integer.valueOf(awardCfgid) }));
/*     */           
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 224 */           return false;
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 230 */       long totalCashAmt = xQingfuInfo.getTotal_cash_amt();
/* 231 */       long addedYuanbao = addedCashInfo.addedYuanbao;
/* 232 */       int firstRechargeFlag = xQingfuInfo.getRecharge_times() == 1 ? 1 : 0;
/* 233 */       addCashLog(userId, totalCashAmt, platProductAmount, addedYuanbao, firstRechargeFlag, flags, gameOrderId, platOrderId, createOrderTime, platProductId, extraGameCurrencyNum);
/*     */       
/*     */ 
/*     */ 
/* 237 */       GameServer.logger().info(String.format("PTransferOrder.processImp@transfer order success|roleid=%d|userid=%s|cfgid=%d|create_time=%d|game_order_id=%s|game_product_id=%s|game_product_amount=%d|platid=%s|pay_platid=%s|device_category=%s|plat_callback_time=%d|plat_order_id=%s|plat_product_id=%s|plat_product_amount=%d|plat_currency=%s|raw_amount=%d|raw_currency=%s|flags=%d|game_currency_type=%d|game_currency_num=%d|extra_game_currency_num=%d|sync_sn=%d|ack_sn=%d|added_yuanbao=%d|added_vip_exp=%d", new Object[] { Long.valueOf(roleId), userId, Integer.valueOf(cfgId), Long.valueOf(createOrderTime), gameOrderId, gameProductId, Integer.valueOf(gameProductAmount), platId, payPlatId, deviceCategory, Long.valueOf(platCallbackOrderTime), platOrderId, platProductId, Integer.valueOf(platProductAmount), platCurrency, Integer.valueOf(rawAmount), rawCurrency, Integer.valueOf(flags), Integer.valueOf(gameCurrencyType), Integer.valueOf(gameCurrencyNum), Integer.valueOf(extraGameCurrencyNum), Integer.valueOf(sn), Integer.valueOf(nextSN), Integer.valueOf(addedCashInfo.addedYuanbao), Integer.valueOf(addedCashInfo.addedVipExp) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 245 */       OnlineManager.getInstance().send(userId, core);
/*     */       
/* 247 */       this.res.finalsucceedorderid = this.arg.gameorderid;
/* 248 */       this.res.sn = xUser.getSn();
/* 249 */       this.res.retcode = 0;
/*     */       
/* 251 */       return true;
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 255 */       this.res.retcode = 4;
/*     */       
/* 257 */       throw e;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static class AddedCashInfo
/*     */   {
/*     */     int addedYuanbao;
/*     */     
/*     */ 
/*     */ 
/*     */     int addedBindYuanbao;
/*     */     
/*     */ 
/*     */ 
/*     */     int addedVipExp;
/*     */     
/*     */ 
/*     */ 
/*     */     AddedCashInfo()
/*     */     {
/* 280 */       this.addedYuanbao = 0;
/* 281 */       this.addedBindYuanbao = 0;
/* 282 */       this.addedVipExp = 0;
/*     */     }
/*     */   }
/*     */   
/*     */   int getAddedCash(int platAmount, SQingfuCfg cfg, AddedCashInfo addedCashInfo)
/*     */   {
/* 288 */     int delta = platAmount - cfg.buyAmount;
/* 289 */     if (delta == 0)
/*     */     {
/* 291 */       addedCashInfo.addedYuanbao = cfg.gainYuanbao;
/* 292 */       addedCashInfo.addedVipExp = cfg.gainVipExp;
/*     */     }
/* 294 */     else if (delta > 0)
/*     */     {
/* 296 */       addedCashInfo.addedYuanbao = (cfg.gainYuanbao + (int)Math.ceil(delta * cfg.gainYuanbao / cfg.buyAmount));
/* 297 */       addedCashInfo.addedVipExp = (cfg.gainVipExp + (int)Math.ceil(delta * cfg.gainVipExp / cfg.buyAmount));
/*     */     }
/*     */     else
/*     */     {
/* 301 */       addedCashInfo.addedYuanbao = (cfg.gainYuanbao + (int)Math.floor(delta * cfg.gainYuanbao / cfg.buyAmount));
/*     */       
/* 303 */       addedCashInfo.addedVipExp = (cfg.gainVipExp + (int)Math.floor(delta * cfg.gainVipExp / cfg.buyAmount));
/*     */     }
/*     */     
/* 306 */     return 0;
/*     */   }
/*     */   
/*     */   static boolean convertTSSInfo(String userid, SQingfuCfg qingfuCfg, QingfuInfo xQingfuInfo)
/*     */     throws Exception
/*     */   {
/* 312 */     boolean purchased = false;
/*     */     
/* 314 */     long currTime = DateTimeUtils.getCurrTimeInMillis();
/* 315 */     SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 316 */     int productServiceId = qingfuCfg.productServiceId;
/*     */     
/* 318 */     String oldTSSList = xQingfuInfo.getTss_list();
/* 319 */     JSONArray tssList = oldTSSList.isEmpty() ? new JSONArray() : new JSONArray(oldTSSList);
/* 320 */     int tssListSize = tssList.length();
/* 321 */     for (int i = 0; i < tssListSize; i++)
/*     */     {
/* 323 */       JSONObject jsonTssInfo = tssList.getJSONObject(i);
/* 324 */       String serviceid = jsonTssInfo.getString("inner_productid");
/* 325 */       if (productServiceId == Integer.parseInt(serviceid))
/*     */       {
/* 327 */         purchased = true;
/*     */         
/* 329 */         long beginTime = sdf.parse(jsonTssInfo.getString("begintime")).getTime();
/* 330 */         long endTime = sdf.parse(jsonTssInfo.getString("endtime")).getTime();
/*     */         
/* 332 */         if (endTime < currTime)
/*     */         {
/* 334 */           String sdfBeginTime = sdf.format(new Date(currTime));
/* 335 */           String sdfEndTime = sdf.format(new Date(currTime + qingfuCfg.productServiceDurationDays * 86400000L));
/*     */           
/*     */ 
/* 338 */           jsonTssInfo.put("begintime", sdfBeginTime);
/* 339 */           jsonTssInfo.put("endtime", sdfEndTime);
/*     */         }
/* 341 */         else if (beginTime <= currTime)
/*     */         {
/* 343 */           String sdfEndTime = sdf.format(new Date(endTime + qingfuCfg.productServiceDurationDays * 86400000L));
/*     */           
/*     */ 
/* 346 */           jsonTssInfo.put("endtime", sdfEndTime);
/*     */         }
/*     */         else
/*     */         {
/* 350 */           GameServer.logger().error(String.format("PTransferOrder.convertTSSInfo@begin-time and end-time invalid|userid=%s|serviceid=%d|tss_info=%s", new Object[] { userid, Integer.valueOf(productServiceId), jsonTssInfo.toString() }));
/*     */           
/*     */ 
/*     */ 
/* 354 */           return false;
/*     */         }
/*     */         
/* 357 */         long grandTotalOpenDays = jsonTssInfo.getLong("grandtotal_opendays");
/* 358 */         jsonTssInfo.put("grandtotal_opendays", grandTotalOpenDays + qingfuCfg.productServiceDurationDays);
/*     */         
/* 360 */         break;
/*     */       }
/*     */     }
/*     */     
/* 364 */     if (!purchased)
/*     */     {
/* 366 */       String sdfBeginTime = sdf.format(new Date(currTime));
/* 367 */       String sdfEndTime = sdf.format(new Date(currTime + qingfuCfg.productServiceDurationDays * 86400000L));
/*     */       
/*     */ 
/* 370 */       JSONObject jsonTssInfo = new JSONObject();
/* 371 */       jsonTssInfo.put("inner_productid", String.valueOf(productServiceId));
/* 372 */       jsonTssInfo.put("first_buy_time", sdfBeginTime);
/* 373 */       jsonTssInfo.put("begintime", sdfBeginTime);
/* 374 */       jsonTssInfo.put("endtime", sdfEndTime);
/* 375 */       jsonTssInfo.put("paychan", "efun");
/* 376 */       jsonTssInfo.put("paysubchan", 1);
/* 377 */       jsonTssInfo.put("autopaychan", "lcl");
/* 378 */       jsonTssInfo.put("autopaysubchan", 0);
/*     */       
/* 380 */       jsonTssInfo.put("grandtotal_opendays", qingfuCfg.productServiceDurationDays);
/* 381 */       jsonTssInfo.put("grandtotal_presentdays", 0);
/* 382 */       jsonTssInfo.put("extend", "");
/*     */       
/* 384 */       tssList.put(jsonTssInfo);
/*     */     }
/*     */     
/* 387 */     GameServer.logger().info(String.format("PTransferOrder.convertTSSInfo@dump tss list|userid=%s|tss_list=%s", new Object[] { userid, tssList.toString() }));
/*     */     
/*     */ 
/* 390 */     QingfuManager.calcTSS(userid, tssList, xQingfuInfo);
/*     */     
/* 392 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void addCashLog(String userid, long totalCash, long cashAdded, long yuanbaoAdded, int flag, int addType, String innerOrderid, String outerOrderid, long createTime, String productid, long addtionMount)
/*     */   {
/* 399 */     int platform = OnlineManager.getInstance().getPlatform(userid);
/* 400 */     String channel = OnlineManager.getInstance().getChannel(userid);
/* 401 */     String mac = OnlineManager.getInstance().getMac(userid);
/* 402 */     int subChannel = 0;
/* 403 */     Long roleid = QingfuManager.getSuitableRoleId(userid);
/* 404 */     int rolelevel = (roleid != null) && (roleid.longValue() > 0L) ? RoleInterface.getLevel(roleid.longValue()) : 0;
/* 405 */     int viplevel = 0;
/* 406 */     String ip = CommonUtils.convertIpBigEndianIntToStr(OnlineManager.getInstance().getIp(userid));
/* 407 */     SimpleDateFormat sdf = DateTimeUtils.getSimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/* 408 */     Object[] columnns = { Integer.valueOf(platform), channel, Integer.valueOf(0), mac, userid, roleid, Integer.valueOf(rolelevel), Long.valueOf(totalCash), Long.valueOf(cashAdded), Long.valueOf(yuanbaoAdded), Integer.valueOf(flag), Integer.valueOf(0), Integer.valueOf(addType), innerOrderid, outerOrderid, sdf.format(new Date(createTime)), productid, Long.valueOf(addtionMount), ip };
/*     */     
/*     */ 
/*     */ 
/* 412 */     LogManager.getInstance().addLog("addcash", columnns);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\PTransferOrder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */