/*     */ package mzm.gsp.redgift.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.RedgiftData;
/*     */ import mzm.gsp.activity.SGetRedgiftActivityRewardRes;
/*     */ import mzm.gsp.activity.confbean.RedGiftActivityConst;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.idip.main.IdipManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.ModMoneyResult;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import xbean.RedgiftRoleidSet;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Redgift;
/*     */ 
/*     */ public class PCGetRedgiftActivityRewardReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   
/*     */   public PCGetRedgiftActivityRewardReq(long roleId)
/*     */   {
/*  30 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  37 */     if (!RedGiftManager.isRedGiftFunOpen()) {
/*  38 */       return false;
/*     */     }
/*     */     
/*  41 */     if (!RedGiftManager.isRedGiftFunOpenWithRoleId(this.roleId)) {
/*  42 */       return false;
/*     */     }
/*     */     
/*  45 */     Lockeys.lock(Lockeys.get(xtable.Role2properties.getTable(), Long.valueOf(this.roleId)));
/*  46 */     long localId = GameServerInfoManager.getLocalId();
/*     */     
/*  48 */     RedgiftRoleidSet xRedgiftRoleidSet = Redgift.get(Long.valueOf(localId));
/*  49 */     SGetRedgiftActivityRewardRes sGetRedgiftActivityRewardRes = new SGetRedgiftActivityRewardRes();
/*  50 */     if (xRedgiftRoleidSet == null) {
/*  51 */       sGetRedgiftActivityRewardRes.result = 1;
/*  52 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sGetRedgiftActivityRewardRes);
/*     */       
/*  54 */       RedGiftManager.logError("PCGetRedgiftActivityRewardReq.processImp@redgift null|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*     */ 
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     if (!xRedgiftRoleidSet.getRoleidset().contains(Long.valueOf(this.roleId))) {
/*  61 */       sGetRedgiftActivityRewardRes.result = 1;
/*  62 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sGetRedgiftActivityRewardRes);
/*     */       
/*  64 */       RedGiftManager.logError("PCGetRedgiftActivityRewardReq.processImp@not valid|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*     */ 
/*  67 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  71 */     if (IdipManager.isZeroProfit(this.roleId)) {
/*  72 */       xRedgiftRoleidSet.getRoleidset().remove(Long.valueOf(this.roleId));
/*  73 */       IdipManager.zeroProfitMsg(this.roleId);
/*     */       
/*  75 */       RedGiftManager.logError("PCGetRedgiftActivityRewardReq.processImp@role is in zero state!|roleid=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*     */ 
/*  78 */       return true;
/*     */     }
/*     */     
/*  81 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*  82 */     if (!RedGiftManager.isLevelOnGetRedgiftRange(roleLevel)) {
/*  83 */       sGetRedgiftActivityRewardRes.result = 1;
/*  84 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sGetRedgiftActivityRewardRes);
/*  85 */       xRedgiftRoleidSet.getRoleidset().remove(Long.valueOf(this.roleId));
/*     */       
/*  87 */       RedGiftManager.logError("PCGetRedgiftActivityRewardReq.processImp@invalid level|roleid=%d|level=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(roleLevel) });
/*     */       
/*     */ 
/*     */ 
/*  91 */       return true;
/*     */     }
/*     */     
/*  94 */     int randomValue = xdb.Xdb.random().nextInt(RedGiftManager.REDGIFT_TYPE_RATE_BASE);
/*     */     
/*  96 */     if (randomValue <= RedGiftActivityConst.getInstance().nullRewardRate) {
/*  97 */       sGetRedgiftActivityRewardRes.result = 0;
/*  98 */       sGetRedgiftActivityRewardRes.cfgid = -1;
/*  99 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sGetRedgiftActivityRewardRes);
/* 100 */       xRedgiftRoleidSet.getRoleidset().remove(Long.valueOf(this.roleId));
/*     */       
/* 102 */       RedGiftManager.logInfo("PCGetRedgiftActivityRewardReq.processImp@empty award|roleid=%d|level=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(roleLevel) });
/*     */       
/*     */ 
/*     */ 
/* 106 */       return true;
/*     */     }
/*     */     
/* 109 */     int cfgId = 0;
/* 110 */     if ((randomValue > RedGiftActivityConst.getInstance().nullRewardRate) && (randomValue <= RedGiftActivityConst.getInstance().nullRewardRate + RedGiftActivityConst.getInstance().commonRewardRate)) {
/* 111 */       cfgId = RedGiftActivityConst.getInstance().commonRewardId;
/* 112 */     } else if ((randomValue > RedGiftActivityConst.getInstance().nullRewardRate + RedGiftActivityConst.getInstance().commonRewardRate) && (randomValue <= RedGiftActivityConst.getInstance().nullRewardRate + RedGiftActivityConst.getInstance().commonRewardRate + RedGiftActivityConst.getInstance().topRewardRate)) {
/* 113 */       cfgId = RedGiftActivityConst.getInstance().topRewardId;
/*     */     }
/*     */     
/* 116 */     AwardPoolResultData awardResult = AwardPoolInterface.getAwardPoolData(cfgId, this.roleId, roleLevel);
/* 117 */     if (awardResult == null)
/*     */     {
/* 119 */       sGetRedgiftActivityRewardRes.result = 1;
/* 120 */       sGetRedgiftActivityRewardRes.cfgid = cfgId;
/* 121 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sGetRedgiftActivityRewardRes);
/*     */       
/* 123 */       RedGiftManager.logError("PCGetRedgiftActivityRewardReq.processImp@award null|roleid=%d|award_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(cfgId) });
/*     */       
/*     */ 
/*     */ 
/* 127 */       return false;
/*     */     }
/*     */     
/* 130 */     ModMoneyResult addSilverResult = RoleInterface.addSilver(this.roleId, awardResult.getSilver(), new TLogArg(LogReason.REDGIFT_AWARD_ADD));
/* 131 */     ModMoneyResult addGoldResult = RoleInterface.addGold(this.roleId, awardResult.getGold(), new TLogArg(LogReason.REDGIFT_AWARD_ADD));
/*     */     
/* 133 */     if ((!addSilverResult.isSucceed()) || (!addGoldResult.isSucceed())) {
/* 134 */       sGetRedgiftActivityRewardRes.result = 10;
/* 135 */       sGetRedgiftActivityRewardRes.cfgid = cfgId;
/* 136 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sGetRedgiftActivityRewardRes);
/*     */       
/* 138 */       RedGiftManager.logError("PCGetRedgiftActivityRewardReq.processImp@currency limit|roleid=%d|award_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(cfgId) });
/*     */       
/*     */ 
/*     */ 
/* 142 */       return false;
/*     */     }
/*     */     
/* 145 */     sGetRedgiftActivityRewardRes.result = 0;
/* 146 */     sGetRedgiftActivityRewardRes.cfgid = cfgId;
/* 147 */     sGetRedgiftActivityRewardRes.rewardinfo.awardmoney.put(Integer.valueOf(0), Integer.valueOf(awardResult.getYuanbao()));
/* 148 */     sGetRedgiftActivityRewardRes.rewardinfo.awardmoney.put(Integer.valueOf(1), Integer.valueOf(awardResult.getGold()));
/* 149 */     sGetRedgiftActivityRewardRes.rewardinfo.awardmoney.put(Integer.valueOf(2), Integer.valueOf(awardResult.getSilver()));
/* 150 */     OnlineManager.getInstance().send(this.roleId, sGetRedgiftActivityRewardRes);
/*     */     
/* 152 */     xRedgiftRoleidSet.getRoleidset().remove(Long.valueOf(this.roleId));
/*     */     
/* 154 */     int itemId1 = 0;
/* 155 */     int itemId2 = 0;
/* 156 */     Iterator i$; if ((awardResult.getItemMap() != null) && (awardResult.getItemMap().size() > 0)) {
/* 157 */       for (i$ = awardResult.getItemMap().keySet().iterator(); i$.hasNext();) { int itemId = ((Integer)i$.next()).intValue();
/* 158 */         if (itemId1 == 0) {
/* 159 */           itemId1 = itemId;
/*     */         } else {
/* 161 */           itemId2 = itemId;
/*     */         }
/*     */       }
/*     */     }
/* 165 */     RedGiftManager.addRedGiftTlog(RoleInterface.getUserId(this.roleId), this.roleId, roleLevel, awardResult.getYuanbao(), awardResult.getGold(), awardResult.getSilver(), itemId1, itemId2);
/*     */     
/* 167 */     RedGiftManager.logInfo("PCGetRedgiftActivityRewardReq.processImp@get award succeed|roleid=%d|level=%d|award_cfgid=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(roleLevel), Integer.valueOf(cfgId) });
/*     */     
/*     */ 
/*     */ 
/* 171 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\redgift\main\PCGetRedgiftActivityRewardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */