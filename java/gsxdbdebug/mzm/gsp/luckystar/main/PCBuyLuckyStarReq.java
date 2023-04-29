/*     */ package mzm.gsp.luckystar.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.active.main.ActiveInterface;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.luckystar.SBuyLuckyStarReqSuccess;
/*     */ import mzm.gsp.luckystar.SLuckyStarNormalFail;
/*     */ import mzm.gsp.luckystar.confbean.SLuckyStarConsts;
/*     */ import mzm.gsp.luckystar.confbean.SLuckyStarGiftOriginalCfg;
/*     */ import mzm.gsp.luckystar.confbean.SLuckyStarUserGroupCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.main.QingfuInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BuyGiftInfo;
/*     */ import xbean.LuckyStarInfo;
/*     */ import xbean.Role2LuckyStarInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2luckystar;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCBuyLuckyStarReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int activityCfgId;
/*     */   private final int luckyStarGiftCfgId;
/*     */   private final long clientCurrencyValue;
/*     */   private final int buyTimesReq;
/*     */   
/*     */   public PCBuyLuckyStarReq(long roleId, int activityCfgId, int luckyStarGiftCfgId, long clientCurrencyValue, int buyTimesReq)
/*     */   {
/*  46 */     this.roleId = roleId;
/*  47 */     this.activityCfgId = activityCfgId;
/*  48 */     this.luckyStarGiftCfgId = luckyStarGiftCfgId;
/*  49 */     this.clientCurrencyValue = clientCurrencyValue;
/*  50 */     this.buyTimesReq = buyTimesReq;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  56 */     if (this.buyTimesReq <= 0)
/*     */     {
/*  58 */       onBuyLuckyStarReqFailed(13);
/*  59 */       return false;
/*     */     }
/*     */     
/*  62 */     if (!LuckyStarManager.isLuckyStarSwitchOpen(this.roleId, true))
/*     */     {
/*  64 */       onBuyLuckyStarReqFailed(12);
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     String userId = RoleInterface.getUserId(this.roleId);
/*  69 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  71 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, this.activityCfgId);
/*     */     
/*  73 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*  75 */       Map<String, Object> extraMap = new HashMap();
/*  76 */       extraMap.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*     */       
/*  78 */       onBuyLuckyStarReqFailed(1, extraMap);
/*     */       
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     int roleActiveValue = ActiveInterface.getTotalActiveValue(this.roleId);
/*  84 */     if (roleActiveValue < SLuckyStarConsts.getInstance().LUCKY_STAR_BUY_NEED_ACTIVE_VALUE)
/*     */     {
/*  86 */       Map<String, Object> extraMap = new HashMap();
/*  87 */       extraMap.put("role_now_active_value", Integer.valueOf(roleActiveValue));
/*  88 */       extraMap.put("nee_active_value", Integer.valueOf(SLuckyStarConsts.getInstance().LUCKY_STAR_BUY_NEED_ACTIVE_VALUE));
/*     */       
/*  90 */       onBuyLuckyStarReqFailed(11, extraMap);
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     if (SLuckyStarUserGroupCfg.get(this.activityCfgId) == null)
/*     */     {
/*  96 */       onBuyLuckyStarReqFailed(2);
/*  97 */       return false;
/*     */     }
/*     */     
/* 100 */     Role2LuckyStarInfo xRole2LuckyStarInfo = Role2luckystar.get(Long.valueOf(this.roleId));
/* 101 */     if (xRole2LuckyStarInfo == null)
/*     */     {
/* 103 */       onBuyLuckyStarReqFailed(4);
/* 104 */       return false;
/*     */     }
/*     */     
/* 107 */     Map<Integer, LuckyStarInfo> xLuckyStarInfoMap = xRole2LuckyStarInfo.getLucky_star_info_map();
/* 108 */     LuckyStarInfo xLuckyStarInfo = (LuckyStarInfo)xLuckyStarInfoMap.get(Integer.valueOf(this.activityCfgId));
/* 109 */     if (xLuckyStarInfo == null)
/*     */     {
/* 111 */       onBuyLuckyStarReqFailed(3);
/* 112 */       return false;
/*     */     }
/*     */     
/* 115 */     BuyGiftInfo xBuyGiftInfo = null;
/* 116 */     for (BuyGiftInfo xTempBuyGiftInfo : xLuckyStarInfo.getBuy_gift_info_list())
/*     */     {
/* 118 */       if (xTempBuyGiftInfo.getGift_cfg_id() == this.luckyStarGiftCfgId)
/*     */       {
/* 120 */         xBuyGiftInfo = xTempBuyGiftInfo;
/* 121 */         break;
/*     */       }
/*     */     }
/*     */     
/* 125 */     if (xBuyGiftInfo == null)
/*     */     {
/* 127 */       onBuyLuckyStarReqFailed(5);
/* 128 */       return false;
/*     */     }
/*     */     
/* 131 */     SLuckyStarGiftOriginalCfg sLuckyStarGiftOriginalCfg = SLuckyStarGiftOriginalCfg.get(this.luckyStarGiftCfgId);
/* 132 */     if (sLuckyStarGiftOriginalCfg == null)
/*     */     {
/* 134 */       onBuyLuckyStarReqFailed(6);
/* 135 */       return false;
/*     */     }
/*     */     
/* 138 */     int xAleardyBuyTimes = xBuyGiftInfo.getAleardy_buy_times();
/* 139 */     int newAleardyBuyTimes = xAleardyBuyTimes + this.buyTimesReq;
/* 140 */     if (newAleardyBuyTimes > sLuckyStarGiftOriginalCfg.buy_top_limit)
/*     */     {
/* 142 */       onBuyLuckyStarReqFailed(7);
/* 143 */       return false;
/*     */     }
/*     */     
/* 146 */     int costCurrencyType = sLuckyStarGiftOriginalCfg.cost_currency_type;
/* 147 */     long bindYuanBao = 0L;
/* 148 */     if (costCurrencyType == 1)
/*     */     {
/* 150 */       bindYuanBao = QingfuInterface.getBindYuanbao(userId, true);
/*     */     }
/* 152 */     long nowCurrencyValue = LuckyStarManager.getLeftCurrencyValue(this.roleId, costCurrencyType);
/* 153 */     if (nowCurrencyValue != this.clientCurrencyValue)
/*     */     {
/* 155 */       return false;
/*     */     }
/* 157 */     int needCuccencyValue = this.buyTimesReq * (int)(sLuckyStarGiftOriginalCfg.base_price * 1.0D * sLuckyStarGiftOriginalCfg.sale_rate / 10000.0D);
/*     */     
/* 159 */     if (needCuccencyValue > nowCurrencyValue)
/*     */     {
/* 161 */       Map<String, Object> extraMap = new HashMap();
/* 162 */       extraMap.put("need_currency_value", Integer.valueOf(needCuccencyValue));
/* 163 */       extraMap.put("now_currency_value", Long.valueOf(nowCurrencyValue));
/*     */       
/* 165 */       onBuyLuckyStarReqFailed(8);
/*     */       
/* 167 */       return false;
/*     */     }
/*     */     
/* 170 */     boolean cutCurrencyResult = LuckyStarManager.costCurrencyValue(this.roleId, needCuccencyValue, costCurrencyType);
/* 171 */     if (!cutCurrencyResult)
/*     */     {
/* 173 */       onBuyLuckyStarReqFailed(9);
/* 174 */       return false;
/*     */     }
/*     */     
/* 177 */     long costBindYuanBao = 0L;
/* 178 */     long costUnBindYuanBao = 0L;
/* 179 */     if (costCurrencyType == 1)
/*     */     {
/* 181 */       costBindYuanBao = needCuccencyValue - bindYuanBao < 0L ? needCuccencyValue : bindYuanBao;
/* 182 */       costUnBindYuanBao = needCuccencyValue - bindYuanBao < 0L ? 0L : needCuccencyValue - bindYuanBao;
/*     */     }
/*     */     
/* 185 */     xBuyGiftInfo.setAleardy_buy_times(newAleardyBuyTimes);
/*     */     
/* 187 */     AwardReason awardReason = new AwardReason(LogReason.LUCKY_STAR_AWARD);
/* 188 */     AwardModel awardModel = AwardInterface.awardFixAwardNTime(sLuckyStarGiftOriginalCfg.fix_award_Id, this.buyTimesReq, userId, this.roleId, true, true, awardReason);
/*     */     
/* 190 */     if (awardModel == null)
/*     */     {
/* 192 */       onBuyLuckyStarReqFailed(10);
/* 193 */       return false;
/*     */     }
/*     */     
/* 196 */     LuckyStarManager.tlogLuckyStarBuyStatis(userId, this.roleId, this.luckyStarGiftCfgId, costCurrencyType, needCuccencyValue, (int)costBindYuanBao, (int)costUnBindYuanBao, this.buyTimesReq);
/*     */     
/*     */ 
/* 199 */     SBuyLuckyStarReqSuccess sBuyLuckyStarReqSuccess = new SBuyLuckyStarReqSuccess();
/* 200 */     sBuyLuckyStarReqSuccess.activity_cfg_id = this.activityCfgId;
/* 201 */     sBuyLuckyStarReqSuccess.lucky_star_gift_cfg_id = this.luckyStarGiftCfgId;
/* 202 */     sBuyLuckyStarReqSuccess.has_buy_times = newAleardyBuyTimes;
/*     */     
/* 204 */     OnlineManager.getInstance().send(this.roleId, sBuyLuckyStarReqSuccess);
/*     */     
/* 206 */     GameServer.logger().info(String.format("[luckystar]PCBuyLuckyStarReq.processImp@handle buy lucky star success|role_id=%d|activity_cfg_id=%d|lucky_star_gift_cfg_id=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgId), Integer.valueOf(this.luckyStarGiftCfgId) }));
/*     */     
/*     */ 
/*     */ 
/* 210 */     return true;
/*     */   }
/*     */   
/*     */   private void onBuyLuckyStarReqFailed(int ret)
/*     */   {
/* 215 */     onBuyLuckyStarReqFailed(ret, null);
/*     */   }
/*     */   
/*     */   private void onBuyLuckyStarReqFailed(int ret, Map<String, Object> extraMap)
/*     */   {
/* 220 */     SLuckyStarNormalFail sLuckyStarNormalFail = new SLuckyStarNormalFail();
/* 221 */     sLuckyStarNormalFail.result = ret;
/*     */     
/* 223 */     StringBuilder sbLog = new StringBuilder();
/* 224 */     sbLog.append("[luckystar]PCBuyLuckyStarReq.processImp@buy lucky star failed");
/* 225 */     sbLog.append("|ret=").append(ret);
/* 226 */     sbLog.append("|role_id=").append(this.roleId);
/* 227 */     sbLog.append("|activity_cfg_id=").append(this.activityCfgId);
/* 228 */     sbLog.append("|buy_gift_cfg_id=").append(this.luckyStarGiftCfgId);
/*     */     
/* 230 */     if ((extraMap != null) && (!extraMap.isEmpty()))
/*     */     {
/* 232 */       for (Map.Entry<String, ?> entry : extraMap.entrySet())
/*     */       {
/* 234 */         sbLog.append('|').append((String)entry.getKey()).append('=').append(entry.getValue());
/*     */       }
/*     */     }
/* 237 */     GameServer.logger().error(sbLog.toString());
/*     */     
/* 239 */     OnlineManager.getInstance().sendAtOnce(this.roleId, sLuckyStarNormalFail);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\main\PCBuyLuckyStarReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */