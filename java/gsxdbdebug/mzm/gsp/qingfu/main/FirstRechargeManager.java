/*     */ package mzm.gsp.qingfu.main;
/*     */ 
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.qingfu.SSyncFirstRechargeInfo;
/*     */ import mzm.gsp.qingfu.confbean.SQingfuCfgConsts;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.QingfuInfo;
/*     */ import xtable.Qingfu;
/*     */ 
/*     */ public class FirstRechargeManager
/*     */ {
/*     */   static final boolean onSaveAmtChanged(String userid)
/*     */   {
/*  19 */     return onSaveAmtChanged(userid, false);
/*     */   }
/*     */   
/*     */   static final boolean onSaveAmtChanged(String userid, boolean isLogin)
/*     */   {
/*  24 */     QingfuInfo xQingfuInfo = Qingfu.get(userid);
/*  25 */     if (xQingfuInfo == null)
/*     */     {
/*  27 */       return false;
/*     */     }
/*  29 */     return onSaveAmtChanged(userid, xQingfuInfo, isLogin);
/*     */   }
/*     */   
/*     */   static final boolean onSaveAmtChanged(String userid, QingfuInfo xQingfuInfo, boolean isLogin)
/*     */   {
/*  34 */     int status = xQingfuInfo.getFirst_recharge_status();
/*  35 */     if ((QingfuManager.getSaveAmt(xQingfuInfo) > 0L) && (status == 1))
/*     */     {
/*  37 */       xQingfuInfo.setFirst_recharge_status(2);
/*     */       
/*  39 */       SSyncFirstRechargeInfo core = new SSyncFirstRechargeInfo();
/*  40 */       core.status = 2;
/*  41 */       OnlineManager.getInstance().send(userid, core);
/*     */       
/*  43 */       GameServer.logger().info(String.format("[qingfu]FirstRechargeManager.onSaveAmtChanged@first recharge status changed|userid=%s|status=%d", new Object[] { userid, Integer.valueOf(2) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  48 */       return true;
/*     */     }
/*     */     
/*  51 */     if (isLogin)
/*     */     {
/*  53 */       SSyncFirstRechargeInfo core = new SSyncFirstRechargeInfo();
/*  54 */       core.status = status;
/*  55 */       OnlineManager.getInstance().send(userid, core);
/*     */     }
/*     */     
/*  58 */     return true;
/*     */   }
/*     */   
/*     */   static final int getAward(String userid, long roleId)
/*     */   {
/*  63 */     QingfuInfo xQingfuInfo = Qingfu.get(userid);
/*  64 */     if (xQingfuInfo == null)
/*     */     {
/*     */ 
/*  67 */       return 1;
/*     */     }
/*     */     
/*  70 */     int status = xQingfuInfo.getFirst_recharge_status();
/*  71 */     if (status == 1)
/*     */     {
/*  73 */       return -1;
/*     */     }
/*     */     
/*  76 */     if (status == 3)
/*     */     {
/*  78 */       return -3;
/*     */     }
/*     */     
/*  81 */     AwardReason firstRechargeAwardReason = new AwardReason(LogReason.FIRST_RECHARGE_AWARD_ADD, PresentType.PRESENT_BIND_FIRST_RECHAGRE);
/*     */     
/*  83 */     firstRechargeAwardReason.setAwardItemBind(true);
/*  84 */     mzm.gsp.award.main.AwardModel awardModel = mzm.gsp.award.main.AwardInterface.awardFixAward(SQingfuCfgConsts.getInstance().FIRST_RECHARGE_AWARD_ID, userid, roleId, true, true, firstRechargeAwardReason);
/*     */     
/*  86 */     if (awardModel == null)
/*     */     {
/*     */ 
/*  89 */       return 2;
/*     */     }
/*     */     
/*  92 */     xQingfuInfo.setFirst_recharge_status(3);
/*     */     
/*  94 */     GameServer.logger().info(String.format("[qingfu]FirstRechargeManager.getAward@first recharge status changed|userid=%s|status=%d", new Object[] { userid, Integer.valueOf(3) }));
/*     */     
/*     */ 
/*     */ 
/*  98 */     return 0;
/*     */   }
/*     */   
/*     */   static final boolean isGetAward(String userid)
/*     */   {
/* 103 */     QingfuInfo xQingfuInfo = Qingfu.get(userid);
/* 104 */     if (xQingfuInfo == null)
/*     */     {
/* 106 */       return false;
/*     */     }
/* 108 */     return isGetAward(userid);
/*     */   }
/*     */   
/*     */   static final boolean isGetAward(QingfuInfo xQingfuInfo)
/*     */   {
/* 113 */     return xQingfuInfo.getFirst_recharge_status() == 3;
/*     */   }
/*     */   
/*     */   static final void trySendTipMail(String userid, long roleid)
/*     */   {
/* 118 */     int mailId = SQingfuCfgConsts.getInstance().FIRST_RECHARGE_MAIL_ID;
/* 119 */     if (mailId <= 0)
/*     */     {
/* 121 */       return;
/*     */     }
/*     */     
/* 124 */     int level = SQingfuCfgConsts.getInstance().FIRST_RECHARGE_MAIL_LEVEL;
/* 125 */     if (level <= 0)
/*     */     {
/* 127 */       return;
/*     */     }
/*     */     
/* 130 */     int roleLevel = RoleInterface.getLevel(roleid);
/* 131 */     if (roleLevel < level)
/*     */     {
/* 133 */       return;
/*     */     }
/*     */     
/* 136 */     QingfuInfo xQingfuInfo = Qingfu.get(userid);
/* 137 */     if (xQingfuInfo == null)
/*     */     {
/* 139 */       return;
/*     */     }
/*     */     
/* 142 */     if (QingfuManager.getSaveAmt(xQingfuInfo) > 0L)
/*     */     {
/* 144 */       return;
/*     */     }
/*     */     
/* 147 */     if (!QingfuManager.checkAndSetSendRechargeTimesTipMailNo(roleid, 1))
/*     */     {
/* 149 */       return;
/*     */     }
/*     */     
/* 152 */     MailInterface.asynBuildAndSendMail(roleid, mailId, null, null, null);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\FirstRechargeManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */