/*     */ package mzm.gsp.qingfu.main;
/*     */ 
/*     */ import java.util.Calendar;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.SGetGiftActivityAwardRes;
/*     */ import mzm.gsp.qingfu.SGetTimeLimitGiftFailedRes;
/*     */ import mzm.gsp.qingfu.confbean.STimeLimitGiftBagCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.yuanbao.main.CurrencyType;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Giftid2count;
/*     */ import xbean.Pod;
/*     */ import xbean.TimeLimitGift;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2timelimitgift;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PGetTimeLimitGiftReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int activity_id;
/*     */   private final int gift_bag_id;
/*     */   private final int remain_buy_count;
/*     */   private final int buy_num;
/*     */   private String userid;
/*     */   
/*     */   public PGetTimeLimitGiftReq(long roleId, int activity_id, int gift_bag_id, int remain_buy_count, int buy_num)
/*     */   {
/*  41 */     this.roleId = roleId;
/*  42 */     this.activity_id = activity_id;
/*  43 */     this.gift_bag_id = gift_bag_id;
/*  44 */     this.remain_buy_count = remain_buy_count;
/*  45 */     this.buy_num = buy_num;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  52 */     if (!isRoleStateCanGetAward(this.roleId))
/*     */     {
/*  54 */       String logStr = String.format("[qingfu]PGetTimeLimitGiftReq.processImp@role state can not get award|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  56 */       GameServer.logger().info(logStr);
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     this.userid = RoleInterface.getUserId(this.roleId);
/*  61 */     if (this.userid == null)
/*     */     {
/*  63 */       return false;
/*     */     }
/*  65 */     lock(Lockeys.get(User.getTable(), this.userid));
/*  66 */     lock(Lockeys.get(Role2timelimitgift.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*  68 */     ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(this.userid, this.roleId, this.activity_id);
/*     */     
/*  70 */     if (result.isActivityNotOpen())
/*     */     {
/*  72 */       doFail(-1);
/*  73 */       return false;
/*     */     }
/*  75 */     if (!result.isCanJoin())
/*     */     {
/*  77 */       GameServer.logger().error(String.format("[qingfu]PGetTimeLimitGiftReq.processImp@can join activity error|roleid=%d|userid=%s|gift_bag_id=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), this.userid, Integer.valueOf(this.gift_bag_id), Integer.valueOf(this.activity_id) }));
/*     */       
/*     */ 
/*     */ 
/*  81 */       return false;
/*     */     }
/*     */     
/*  84 */     TimeLimitGift xTimeLimitGift = Role2timelimitgift.get(Long.valueOf(this.roleId));
/*  85 */     if (xTimeLimitGift == null)
/*     */     {
/*  87 */       xTimeLimitGift = Pod.newTimeLimitGift();
/*  88 */       Role2timelimitgift.insert(Long.valueOf(this.roleId), xTimeLimitGift);
/*     */     }
/*  90 */     STimeLimitGiftBagCfg sTimeLimitGiftBagCfg = STimeLimitGiftBagCfg.get(this.gift_bag_id);
/*  91 */     if (sTimeLimitGiftBagCfg == null)
/*     */     {
/*  93 */       GameServer.logger().error(String.format("[qingfu]PGetTimeLimitGiftReq.processImp@STimeLimitGiftBagCfg null|roleid=%d|userid=%s|gift_bag_id=%d", new Object[] { Long.valueOf(this.roleId), this.userid, Integer.valueOf(this.gift_bag_id) }));
/*     */       
/*     */ 
/*     */ 
/*  97 */       return false;
/*     */     }
/*  99 */     if (sTimeLimitGiftBagCfg.activityId != this.activity_id)
/*     */     {
/* 101 */       GameServer.logger().error(String.format("[qingfu]PGetTimeLimitGiftReq.processImp@STimeLimitGiftBagCfg activityId error |roleid=%d|userid=%s|gift_bag_id=%d|activityId=%d|cfgActivityId=%d", new Object[] { Long.valueOf(this.roleId), this.userid, Integer.valueOf(this.gift_bag_id), Integer.valueOf(this.activity_id), Integer.valueOf(sTimeLimitGiftBagCfg.activityId) }));
/*     */       
/*     */ 
/*     */ 
/* 105 */       return false;
/*     */     }
/* 107 */     if (sTimeLimitGiftBagCfg.buyWeekDay != 0)
/*     */     {
/* 109 */       long now = DateTimeUtils.getCurrTimeInMillis();
/*     */       
/* 111 */       Calendar calendar = DateTimeUtils.getCalendar();
/* 112 */       calendar.setTimeInMillis(now);
/* 113 */       int weekDayNow = calendar.get(7);
/*     */       
/* 115 */       if (weekDayNow != sTimeLimitGiftBagCfg.buyWeekDay)
/*     */       {
/* 117 */         doFail(-4);
/* 118 */         GameServer.logger().error(String.format("[qingfu]PGetTimeLimitGiftReq.processImp@can buy week day error |roleid=%d|userid=%s|gift_bag_id=%d|activityId=%d|nowWeekDay=%d|buyWeekDay=%d", new Object[] { Long.valueOf(this.roleId), this.userid, Integer.valueOf(this.gift_bag_id), Integer.valueOf(this.activity_id), Integer.valueOf(weekDayNow), Integer.valueOf(sTimeLimitGiftBagCfg.buyWeekDay) }));
/*     */         
/*     */ 
/*     */ 
/* 122 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 127 */     Giftid2count xGiftid2count = (Giftid2count)xTimeLimitGift.getActivityid2giftids().get(Integer.valueOf(this.activity_id));
/* 128 */     if (xGiftid2count == null)
/*     */     {
/* 130 */       xGiftid2count = Pod.newGiftid2count();
/* 131 */       xTimeLimitGift.getActivityid2giftids().put(Integer.valueOf(this.activity_id), xGiftid2count);
/*     */     }
/*     */     
/* 134 */     int alreadyBuyCount = 0;
/* 135 */     if ((xGiftid2count == null) || (xGiftid2count.getGiftid2count().get(Integer.valueOf(this.gift_bag_id)) == null))
/*     */     {
/* 137 */       alreadyBuyCount = 0;
/*     */     }
/*     */     else
/*     */     {
/* 141 */       alreadyBuyCount = ((Integer)xGiftid2count.getGiftid2count().get(Integer.valueOf(this.gift_bag_id))).intValue();
/*     */     }
/* 143 */     if (alreadyBuyCount >= sTimeLimitGiftBagCfg.maxCount)
/*     */     {
/* 145 */       GameServer.logger().error(String.format("[qingfu]PGetTimeLimitGiftReq.processImp@buy count error |roleid=%d|userid=%s|gift_bag_id=%d|activityId=%d|alreadyBuyCount=%d|maxBuyCount=%d", new Object[] { Long.valueOf(this.roleId), this.userid, Integer.valueOf(this.gift_bag_id), Integer.valueOf(this.activity_id), Integer.valueOf(alreadyBuyCount), Integer.valueOf(sTimeLimitGiftBagCfg.maxCount) }));
/*     */       
/*     */ 
/*     */ 
/* 149 */       doFail(-3);
/* 150 */       return false;
/*     */     }
/* 152 */     if (sTimeLimitGiftBagCfg.maxCount - alreadyBuyCount != this.remain_buy_count)
/*     */     {
/* 154 */       GameServer.logger().info(String.format("[qingfu]PGetTimeLimitGiftReq.processImp@client remain buy count error |roleid=%d|userid=%s|gift_bag_id=%d|activityId=%d|alreadyBuyCount=%d|remain_buy_count=%d", new Object[] { Long.valueOf(this.roleId), this.userid, Integer.valueOf(this.gift_bag_id), Integer.valueOf(this.activity_id), Integer.valueOf(alreadyBuyCount), Integer.valueOf(this.remain_buy_count) }));
/*     */       
/*     */ 
/*     */ 
/* 158 */       return false;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 163 */     if ((this.buy_num <= 0) || (alreadyBuyCount + this.buy_num > sTimeLimitGiftBagCfg.maxCount))
/*     */     {
/* 165 */       GameServer.logger().error(String.format("[qingfu]PGetTimeLimitGiftReq.processImp@buy count error |roleid=%d|userid=%s|gift_bag_id=%d|activityId=%d|alreadyBuyCount=%d|maxBuyCount=%d|buyNum=%d", new Object[] { Long.valueOf(this.roleId), this.userid, Integer.valueOf(this.gift_bag_id), Integer.valueOf(this.activity_id), Integer.valueOf(alreadyBuyCount), Integer.valueOf(sTimeLimitGiftBagCfg.maxCount), Integer.valueOf(this.buy_num) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 170 */       doFail(-5);
/* 171 */       return false;
/*     */     }
/* 173 */     xGiftid2count.getGiftid2count().put(Integer.valueOf(this.gift_bag_id), Integer.valueOf(alreadyBuyCount + this.buy_num));
/* 174 */     boolean ret = false;
/* 175 */     switch (sTimeLimitGiftBagCfg.giftBagType)
/*     */     {
/*     */ 
/*     */     case 1: 
/* 179 */       ret = dealGetTimeLimit(sTimeLimitGiftBagCfg, alreadyBuyCount);
/*     */       
/* 181 */       break;
/*     */     
/*     */     case 3: 
/* 184 */       if (this.buy_num > 1)
/*     */       {
/* 186 */         GameServer.logger().error(String.format("[qingfu]PGetTimeLimitGiftReq.processImp@buy count error |roleid=%d|userid=%s|gift_bag_id=%d|activityId=%d|alreadyBuyCount=%d|maxBuyCount=%d|buyNum=%d", new Object[] { Long.valueOf(this.roleId), this.userid, Integer.valueOf(this.gift_bag_id), Integer.valueOf(this.activity_id), Integer.valueOf(alreadyBuyCount), Integer.valueOf(sTimeLimitGiftBagCfg.maxCount), Integer.valueOf(this.buy_num) }));
/*     */         
/*     */ 
/*     */ 
/*     */ 
/* 191 */         doFail(-5);
/* 192 */         return false;
/*     */       }
/* 194 */       WeeklyTimeLimitGetAwardHandler weeklyTimeLimitGetAwardHandler = TimeLimitGiftActivityManager.getAwardHandler(this.activity_id);
/* 195 */       if (weeklyTimeLimitGetAwardHandler == null)
/*     */       {
/* 197 */         GameServer.logger().info(String.format("[qingfu]PGetTimeLimitGiftReq.processImp@weeklyTimeLimitGetAwardHandler is null|roleid=%d|userid=%s|gift_bag_id=%d|activityId=%d|alreadyBuyCount=%d|remain_buy_count=%d", new Object[] { Long.valueOf(this.roleId), this.userid, Integer.valueOf(this.gift_bag_id), Integer.valueOf(this.activity_id), Integer.valueOf(alreadyBuyCount), Integer.valueOf(this.remain_buy_count) }));
/*     */         
/*     */ 
/*     */ 
/* 201 */         return false;
/*     */       }
/* 203 */       ret = weeklyTimeLimitGetAwardHandler.doAward(this.userid, this.roleId, sTimeLimitGiftBagCfg);
/* 204 */       break;
/*     */     }
/*     */     
/*     */     
/*     */ 
/* 209 */     if (!ret)
/*     */     {
/* 211 */       return false;
/*     */     }
/*     */     
/* 214 */     SGetGiftActivityAwardRes resp = new SGetGiftActivityAwardRes();
/* 215 */     resp.activity_id = this.activity_id;
/* 216 */     resp.gift_bag_id = this.gift_bag_id;
/* 217 */     resp.remain_count = (sTimeLimitGiftBagCfg.maxCount - (alreadyBuyCount + this.buy_num));
/* 218 */     resp.buy_num = this.buy_num;
/* 219 */     OnlineManager.getInstance().send(this.roleId, resp);
/*     */     
/* 221 */     return true;
/*     */   }
/*     */   
/*     */   private boolean doAward(LogReason logReason, STimeLimitGiftBagCfg sTimeLimitGiftBagCfg, int num)
/*     */   {
/* 226 */     mzm.gsp.award.main.AwardModel awardModel = AwardInterface.awardFixAwardNTime(sTimeLimitGiftBagCfg.rewardId, num, this.userid, this.roleId, true, true, new AwardReason(logReason, this.gift_bag_id));
/*     */     
/* 228 */     if (awardModel == null)
/*     */     {
/* 230 */       GameServer.logger().error(String.format("[qingfu]PGetTimeLimitGiftReq.doAward@awardModel error |roleid=%d|userid=%s|gift_bag_id=%d|activityId=%d|rewardId=%d", new Object[] { Long.valueOf(this.roleId), this.userid, Integer.valueOf(this.gift_bag_id), Integer.valueOf(this.activity_id), Integer.valueOf(sTimeLimitGiftBagCfg.rewardId) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 235 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 239 */     GameServer.logger().info(String.format("[qingfu]PGetTimeLimitGiftReq.doAward@ buy time limit gift success |roleid=%d|userid=%s|gift_bag_id=%d|activityId=%d|rewardId=%d", new Object[] { Long.valueOf(this.roleId), this.userid, Integer.valueOf(this.gift_bag_id), Integer.valueOf(this.activity_id), Integer.valueOf(sTimeLimitGiftBagCfg.rewardId) }));
/*     */     
/*     */ 
/*     */ 
/* 243 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   private void doFail(int retCode)
/*     */   {
/* 249 */     SGetTimeLimitGiftFailedRes resp = new SGetTimeLimitGiftFailedRes();
/* 250 */     resp.activity_id = this.activity_id;
/* 251 */     resp.gift_bag_id = this.gift_bag_id;
/* 252 */     resp.retcode = retCode;
/* 253 */     OnlineManager.getInstance().sendAtOnce(this.roleId, resp);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   private void tlogBuyTimeLimitGift(int remainBuyCount, CurrencyType currencyType, int cutNum)
/*     */   {
/* 260 */     String vGameIP = GameServerInfoManager.getHostIP();
/*     */     
/* 262 */     int rolelevel = RoleInterface.getLevel(this.roleId);
/*     */     
/* 264 */     Object[] columns = { vGameIP, this.userid, Long.valueOf(this.roleId), Integer.valueOf(rolelevel), Integer.valueOf(this.activity_id), Integer.valueOf(this.gift_bag_id), Integer.valueOf(remainBuyCount), Integer.valueOf(currencyType.value), Integer.valueOf(cutNum) };
/*     */     
/* 266 */     TLogManager.getInstance().addLog(this.userid, this.roleId, "Buytimelimitgift", columns);
/*     */   }
/*     */   
/*     */   private boolean dealGetTimeLimit(STimeLimitGiftBagCfg sTimeLimitGiftBagCfg, int alreadyBuyCount)
/*     */   {
/* 271 */     if (!TimeLimitGiftActivityManager.isTimeLimitGiftSwitchOpenForRole(this.roleId))
/*     */     {
/* 273 */       GameServer.logger().error(String.format("[qingfu]PGetTimeLimitGiftReq.dealGetTimeLimit@activity switch closed for role |roleid=%d|userid=%s|gift_bag_id=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), this.userid, Integer.valueOf(this.gift_bag_id), Integer.valueOf(this.activity_id) }));
/*     */       
/*     */ 
/*     */ 
/* 277 */       return false;
/*     */     }
/* 279 */     if (sTimeLimitGiftBagCfg.discountPrice <= 0)
/*     */     {
/* 281 */       if (!TimeLimitGiftActivityManager.isFreeGiftSwitchOpenForRole(this.roleId))
/*     */       {
/* 283 */         GameServer.logger().error(String.format("[qingfu]PGetTimeLimitGiftReq.dealGetTimeLimit@free gift award activity switch closed for role |roleid=%d|userid=%s|gift_bag_id=%d|activityId=%d", new Object[] { Long.valueOf(this.roleId), this.userid, Integer.valueOf(this.gift_bag_id), Integer.valueOf(this.activity_id) }));
/*     */         
/*     */ 
/*     */ 
/* 287 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 293 */     long discountPrice = sTimeLimitGiftBagCfg.discountPrice * this.buy_num;
/* 294 */     if ((discountPrice > 2147483647L) || ((sTimeLimitGiftBagCfg.discountPrice > 0) && (discountPrice <= 0L)))
/*     */     {
/* 296 */       GameServer.logger().error(String.format("[qingfu]PGetTimeLimitGiftReq.processImp@buy count error |roleid=%d|userid=%s|gift_bag_id=%d|activityId=%d|alreadyBuyCount=%d|maxBuyCount=%d|discountPrice=%d", new Object[] { Long.valueOf(this.roleId), this.userid, Integer.valueOf(this.gift_bag_id), Integer.valueOf(this.activity_id), Integer.valueOf(alreadyBuyCount), Integer.valueOf(sTimeLimitGiftBagCfg.maxCount), Long.valueOf(discountPrice) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 301 */       doFail(-5);
/* 302 */       return false;
/*     */     }
/* 304 */     CurrencyType currencyType = CurrencyType.CURRENCY_YUANBAO;
/* 305 */     if (discountPrice > 0L)
/*     */     {
/*     */ 
/* 308 */       TLogArg logArg = new TLogArg(LogReason.TIME_LIMIT_GIFT_ACTIVITY_AWARD_ADD, this.gift_bag_id);
/* 309 */       switch (sTimeLimitGiftBagCfg.moneytype)
/*     */       {
/*     */       case 3: 
/* 312 */         currencyType = CurrencyType.CURRENCY_SILVE;
/* 313 */         if (!RoleInterface.cutSilver(this.roleId, discountPrice, logArg))
/*     */         {
/* 315 */           doFail(-2);
/* 316 */           return false;
/*     */         }
/*     */         break;
/*     */       case 2: 
/* 320 */         currencyType = CurrencyType.CURRENCY_GOLD;
/* 321 */         if (!RoleInterface.cutGold(this.roleId, discountPrice, logArg))
/*     */         {
/* 323 */           doFail(-2);
/* 324 */           return false;
/*     */         }
/*     */         break;
/*     */       case 5: 
/* 328 */         currencyType = CurrencyType.CURRENCY_GOLD_INGOT;
/* 329 */         if (!RoleInterface.cutGoldIngot(this.roleId, discountPrice, logArg))
/*     */         {
/* 331 */           doFail(-2);
/* 332 */           return false;
/*     */         }
/*     */         break;
/*     */       case 1: 
/* 336 */         currencyType = CurrencyType.CURRENCY_YUANBAO;
/* 337 */         CostResult costResult = QingfuInterface.costYuanbao(this.userid, this.roleId, (int)discountPrice, CostType.COST_BIND_FIRST_TIME_LIMIT_GIFT, logArg);
/*     */         
/* 339 */         if (costResult != CostResult.Success)
/*     */         {
/* 341 */           doFail(-2);
/* 342 */           return false;
/*     */         }
/*     */         break;
/*     */       case 4: default: 
/* 346 */         return false;
/*     */       }
/*     */       
/*     */     }
/*     */     
/* 351 */     boolean ret = doAward(LogReason.TIME_LIMIT_GIFT_ACTIVITY_AWARD_ADD, sTimeLimitGiftBagCfg, this.buy_num);
/* 352 */     if (ret)
/*     */     {
/* 354 */       tlogBuyTimeLimitGift(sTimeLimitGiftBagCfg.maxCount - (alreadyBuyCount + this.buy_num), currencyType, (int)discountPrice);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 359 */     return ret;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean isRoleStateCanGetAward(long roleid)
/*     */   {
/* 371 */     return mzm.gsp.status.main.RoleStatusInterface.checkCanSetStatus(roleid, 137, true);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\PGetTimeLimitGiftReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */