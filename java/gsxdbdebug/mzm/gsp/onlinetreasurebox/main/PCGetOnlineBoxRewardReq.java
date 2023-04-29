/*     */ package mzm.gsp.onlinetreasurebox.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.SSendAwardPoolRes;
/*     */ import mzm.gsp.activity.confbean.OnlineTreasureBoxActivityConst;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.bulletin.SBulletinInfo;
/*     */ import mzm.gsp.bulletin.main.BulletinInterface;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.TreasureBoxAwardInfo;
/*     */ import xtable.Basic;
/*     */ import xtable.Treasureboxaward;
/*     */ 
/*     */ public class PCGetOnlineBoxRewardReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private long roleId;
/*     */   
/*     */   public PCGetOnlineBoxRewardReq(long roleId)
/*     */   {
/*  33 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if (!OnlineTreasureBoxManager.isOnlineTreasureBoxSwitchOpenForRole(this.roleId)) {
/*  40 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  44 */     if (OnlineTreasureBoxManager.onlineTreasureBoxActionEnum == OnlineTreasureBoxActionEnum.CLOSE_STAGE) {
/*  45 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  49 */     if (OnlineTreasureBoxManager.onlineTreasureBoxActionEnum != OnlineTreasureBoxActionEnum.START_STAGE) {
/*  50 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  54 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*  55 */     long localId = mzm.gsp.GameServerInfoManager.getLocalId();
/*     */     
/*     */ 
/*  58 */     int level = RoleInterface.getLevel(this.roleId);
/*  59 */     if (!OnlineTreasureBoxManager.canJoinOnlineTreasureBoxWithLevel(level)) {
/*  60 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  64 */     TreasureBoxAwardInfo xTreasureBoxAwardInfo = Treasureboxaward.get(Long.valueOf(localId));
/*  65 */     if (xTreasureBoxAwardInfo == null) {
/*  66 */       return false;
/*     */     }
/*  68 */     if ((xTreasureBoxAwardInfo.getRoleidset().size() == 0) || (!xTreasureBoxAwardInfo.getRoleidset().contains(Long.valueOf(this.roleId))))
/*     */     {
/*  70 */       if (OnlineTreasureBoxManager.LOGGER.isDebugEnabled()) {
/*  71 */         OnlineTreasureBoxManager.LOGGER.debug("PCGetOnlineBoxRewardReq.processImp@ get award fail + time not enough" + OnlineTreasureBoxActivityConst.getInstance().boxAwardId + " roleid=" + this.roleId);
/*     */       }
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     int roleLevel = RoleInterface.getLevel(this.roleId);
/*  77 */     String userid = RoleInterface.getUserId(this.roleId);
/*     */     
/*  79 */     AwardPoolResultData awardResult = AwardPoolInterface.getAwardPoolData(OnlineTreasureBoxActivityConst.getInstance().boxAwardId, this.roleId, roleLevel);
/*  80 */     if (awardResult == null)
/*     */     {
/*  82 */       if (OnlineTreasureBoxManager.LOGGER.isDebugEnabled()) {
/*  83 */         OnlineTreasureBoxManager.LOGGER.debug("PCGetOnlineBoxRewardReq.processImp@ get award fail" + OnlineTreasureBoxActivityConst.getInstance().boxAwardId + " roleid=" + this.roleId);
/*     */       }
/*  85 */       return false;
/*     */     }
/*     */     
/*  88 */     if (OnlineManager.getInstance().isOnline(this.roleId)) {
/*  89 */       AwardPoolInterface.doAward(userid, this.roleId, awardResult, new TLogArg(LogReason.ONLINE_TREASURE_AWARD_ADD_BOX));
/*     */       
/*  91 */       SSendAwardPoolRes sSendAwardPoolRes = new SSendAwardPoolRes();
/*  92 */       sSendAwardPoolRes.awardmoney.put(Integer.valueOf(1), Integer.valueOf(awardResult.getGold()));
/*  93 */       sSendAwardPoolRes.awardmoney.put(Integer.valueOf(0), Integer.valueOf(awardResult.getYuanbao()));
/*  94 */       sSendAwardPoolRes.awardmoney.put(Integer.valueOf(2), Integer.valueOf(awardResult.getSilver()));
/*  95 */       sSendAwardPoolRes.awarditems.putAll(awardResult.getItemMap());
/*  96 */       OnlineManager.getInstance().sendAtOnce(this.roleId, sSendAwardPoolRes);
/*     */     }
/*     */     else {
/*  99 */       MailAttachment mailAttachment = MailInterface.createMailAttachment();
/*     */       
/* 101 */       mailAttachment.setGold(awardResult.getGold());
/* 102 */       mailAttachment.setSilver(awardResult.getSilver());
/* 103 */       if (awardResult.getItemMap().size() > 0) {
/* 104 */         for (Map.Entry<Integer, Integer> itemEntry : awardResult.getItemMap().entrySet()) {
/* 105 */           mailAttachment.addItem(((Integer)itemEntry.getKey()).intValue(), ((Integer)itemEntry.getValue()).intValue());
/*     */         }
/*     */       }
/* 108 */       MailInterface.synBuildAndSendMail(this.roleId, OnlineTreasureBoxActivityConst.getInstance().AwardMailId, new ArrayList(), new ArrayList(), mailAttachment, new TLogArg(LogReason.ONLINE_TREASURE_AWARD_ADD_BOX));
/*     */     }
/*     */     
/*     */ 
/* 112 */     if (awardResult.getItemMap().size() > 0) {
/* 113 */       for (Integer itemId : awardResult.getItemMap().keySet()) {
/* 114 */         if (mzm.gsp.itembulletin.main.ItemBulletinInterface.needBulletin(itemId.intValue())) {
/* 115 */           SBulletinInfo bulletinInfo = new SBulletinInfo();
/* 116 */           bulletinInfo.bulletintype = 31;
/* 117 */           bulletinInfo.params.put(Integer.valueOf(1), RoleInterface.getName(this.roleId));
/* 118 */           bulletinInfo.params.put(Integer.valueOf(4), String.valueOf(itemId));
/* 119 */           BulletinInterface.sendBulletin(bulletinInfo);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 124 */     xTreasureBoxAwardInfo.getRoleidset().remove(Long.valueOf(this.roleId));
/*     */     
/* 126 */     OnlineTreasureBoxManager.LOGGER.info("PCGetOnlineBoxRewardReq.processImp@ get box award success" + OnlineTreasureBoxActivityConst.getInstance().boxAwardId + " roleid=" + this.roleId);
/*     */     
/*     */ 
/* 129 */     int itemId1 = 0;
/* 130 */     int itemId2 = 0;
/* 131 */     Iterator i$; if ((awardResult.getItemMap() != null) && (awardResult.getItemMap().size() > 0)) {
/* 132 */       for (i$ = awardResult.getItemMap().keySet().iterator(); i$.hasNext();) { int itemId = ((Integer)i$.next()).intValue();
/* 133 */         if (itemId1 == 0) {
/* 134 */           itemId1 = itemId;
/*     */         } else {
/* 136 */           itemId2 = itemId;
/*     */         }
/*     */       }
/*     */     }
/* 140 */     OnlineTreasureBoxManager.addOnlineTreasureBoxTlog(userid, this.roleId, roleLevel, awardResult.getYuanbao(), awardResult.getGold(), awardResult.getSilver(), itemId1, itemId2);
/*     */     
/* 142 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\onlinetreasurebox\main\PCGetOnlineBoxRewardReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */