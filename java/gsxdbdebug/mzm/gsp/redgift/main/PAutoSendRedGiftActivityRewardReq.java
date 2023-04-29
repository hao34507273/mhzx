/*     */ package mzm.gsp.redgift.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.RedgiftData;
/*     */ import mzm.gsp.activity.SGetRedgiftActivityRewardRes;
/*     */ import mzm.gsp.activity.confbean.RedGiftActivityConst;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.idip.main.IdipManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ 
/*     */ public class PAutoSendRedGiftActivityRewardReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   
/*     */   public PAutoSendRedGiftActivityRewardReq(long roleId)
/*     */   {
/*  28 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  35 */     if (!RedGiftManager.isRedGiftFunOpen()) {
/*  36 */       return false;
/*     */     }
/*     */     
/*  39 */     if (!RedGiftManager.isRedGiftFunOpenWithRoleId(this.roleId)) {
/*  40 */       return false;
/*     */     }
/*     */     
/*  43 */     Lockeys.lock(Lockeys.get(xtable.Role2properties.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*  45 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*  46 */     if (!RedGiftManager.isLevelOnGetRedgiftRange(roleLevel)) {
/*  47 */       if (RedGiftManager.LOGGER.isDebugEnabled()) {
/*  48 */         RedGiftManager.LOGGER.debug("等级没打开红包活动领取等级 roleid=" + this.roleId);
/*     */       }
/*  50 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  54 */     if (IdipManager.isZeroProfit(this.roleId)) {
/*  55 */       GameServer.logger().info(String.format("PAutoSendRedGiftActivityRewardReq.processImp@ role is in zero state!|roleId=%d", new Object[] { Long.valueOf(this.roleId) }));
/*  56 */       IdipManager.zeroProfitMsg(this.roleId);
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     int randomValue = xdb.Xdb.random().nextInt(RedGiftManager.REDGIFT_TYPE_RATE_BASE);
/*     */     
/*  62 */     if (randomValue <= RedGiftActivityConst.getInstance().nullRewardRate) {
/*  63 */       return false;
/*     */     }
/*     */     
/*  66 */     int cfgId = 0;
/*  67 */     if ((randomValue > RedGiftActivityConst.getInstance().nullRewardRate) && (randomValue <= RedGiftActivityConst.getInstance().nullRewardRate + RedGiftActivityConst.getInstance().commonRewardRate)) {
/*  68 */       cfgId = RedGiftActivityConst.getInstance().commonRewardId;
/*  69 */     } else if ((randomValue > RedGiftActivityConst.getInstance().nullRewardRate + RedGiftActivityConst.getInstance().commonRewardRate) && (randomValue <= RedGiftActivityConst.getInstance().nullRewardRate + RedGiftActivityConst.getInstance().commonRewardRate + RedGiftActivityConst.getInstance().topRewardRate)) {
/*  70 */       cfgId = RedGiftActivityConst.getInstance().topRewardId;
/*     */     }
/*     */     
/*  73 */     AwardPoolResultData awardResult = AwardPoolInterface.getAwardPoolData(cfgId, this.roleId, roleLevel);
/*  74 */     if (awardResult == null)
/*     */     {
/*  76 */       if (RedGiftManager.LOGGER.isDebugEnabled()) {
/*  77 */         RedGiftManager.LOGGER.debug("红包发奖失败 AwardModel为null，奖励类id=" + cfgId + " roleid=" + this.roleId);
/*     */       }
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     RoleInterface.addSilverWithinMax(this.roleId, awardResult.getSilver(), new TLogArg(LogReason.REDGIFT_AWARD_ADD));
/*  83 */     RoleInterface.addGoldWithinMax(this.roleId, awardResult.getGold(), new TLogArg(LogReason.REDGIFT_AWARD_ADD));
/*     */     
/*     */ 
/*  86 */     if (OnlineManager.getInstance().isOnline(this.roleId)) {
/*  87 */       SGetRedgiftActivityRewardRes sGetRedgiftActivityRewardRes = new SGetRedgiftActivityRewardRes();
/*  88 */       sGetRedgiftActivityRewardRes.result = 0;
/*  89 */       sGetRedgiftActivityRewardRes.cfgid = cfgId;
/*  90 */       sGetRedgiftActivityRewardRes.rewardinfo.awardmoney.put(Integer.valueOf(1), Integer.valueOf(awardResult.getGold()));
/*  91 */       sGetRedgiftActivityRewardRes.rewardinfo.awardmoney.put(Integer.valueOf(2), Integer.valueOf(awardResult.getSilver()));
/*     */     }
/*     */     
/*     */ 
/*  95 */     int itemId1 = 0;
/*  96 */     int itemId2 = 0;
/*  97 */     Iterator i$; if ((awardResult.getItemMap() != null) && (awardResult.getItemMap().size() > 0)) {
/*  98 */       for (i$ = awardResult.getItemMap().keySet().iterator(); i$.hasNext();) { int itemId = ((Integer)i$.next()).intValue();
/*  99 */         if (itemId1 == 0) {
/* 100 */           itemId1 = itemId;
/*     */         } else {
/* 102 */           itemId2 = itemId;
/*     */         }
/*     */       }
/*     */     }
/* 106 */     RedGiftManager.addRedGiftTlog(RoleInterface.getUserId(this.roleId), this.roleId, roleLevel, awardResult.getYuanbao(), awardResult.getGold(), awardResult.getSilver(), itemId1, itemId2);
/*     */     
/* 108 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\redgift\main\PAutoSendRedGiftActivityRewardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */