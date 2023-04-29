/*     */ package mzm.gsp.mergecompensation.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.mail.main.MailAttachment;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.mail.main.SendMailRet;
/*     */ import mzm.gsp.mergecompensation.confbean.SMergeCompensationConsts;
/*     */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleMergeCompensationInfo;
/*     */ import xtable.Role_merge_compensation_infos;
/*     */ 
/*     */ public class POnRoleLogin
/*     */   extends PlayerLoginProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  24 */     long roleid = ((Long)this.arg).longValue();
/*  25 */     if (!MergeCompensationInfoManager.getInstance().getIsDataAvailable())
/*     */     {
/*     */ 
/*  28 */       MergeCompensationManager.logger.info(String.format("[merge_compensation]POnRoleLogin.processImp@merge compensation info is not available|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*     */       
/*  30 */       return false;
/*     */     }
/*  32 */     if (!MergeCompensationManager.isMergeCompensationSwitchOpenForRole(roleid))
/*     */     {
/*     */ 
/*  35 */       MergeCompensationManager.logger.info(String.format("[merge_compensation]POnRoleLogin.processImp@module close or role forbidden|roleid=%d", new Object[] { Long.valueOf(roleid) }));
/*     */       
/*  37 */       return false;
/*     */     }
/*  39 */     RoleMergeCompensationInfo xRoleMergeCompensationInfo = Role_merge_compensation_infos.get(Long.valueOf(roleid));
/*  40 */     if (xRoleMergeCompensationInfo == null)
/*     */     {
/*  42 */       xRoleMergeCompensationInfo = Pod.newRoleMergeCompensationInfo();
/*  43 */       Role_merge_compensation_infos.insert(Long.valueOf(roleid), xRoleMergeCompensationInfo);
/*     */     }
/*  45 */     if (xRoleMergeCompensationInfo.getHave_got_compensation_merge_system_timestamps().contains(Long.valueOf(MergeCompensationInfoManager.getInstance().getMergeSystemTimestamp())))
/*     */     {
/*     */ 
/*     */ 
/*  49 */       MergeCompensationManager.logger.info(String.format("[merge_compensation]POnRoleLogin.processImp@role has got compensation|roleid=%d|merge_system_timestamp=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(MergeCompensationInfoManager.getInstance().getMergeSystemTimestamp()) }));
/*     */       
/*     */ 
/*  52 */       return false;
/*     */     }
/*  54 */     if (RoleInterface.getRoleCreateTime(roleid) > MergeCompensationInfoManager.getInstance().getMergeSystemTimestamp() + MergeCompensationInfoManager.getInstance().getMergeTimeOffset())
/*     */     {
/*     */ 
/*     */ 
/*  58 */       MergeCompensationManager.logger.info(String.format("[merge_compensation]POnRoleLogin.processImp@create role time is later than merge time|roleid=%d|create_time=%d|merge_system_timestamp=%d|merge_time_offset=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(RoleInterface.getRoleCreateTime(roleid)), Long.valueOf(MergeCompensationInfoManager.getInstance().getMergeSystemTimestamp()), Long.valueOf(MergeCompensationInfoManager.getInstance().getMergeTimeOffset()) }));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*  63 */       return false;
/*     */     }
/*  65 */     Integer deltaDay = MergeCompensationInfoManager.getInstance().getServerDeltaDayInfo(GameServerInfoManager.getZoneidFromRoleid(roleid));
/*     */     
/*  67 */     if (deltaDay == null)
/*     */     {
/*     */ 
/*  70 */       MergeCompensationManager.logger.info(String.format("[merge_compensation]POnRoleLogin.processImp@get server level delta day fail|roleid=%d|merge_system_timestamp=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(MergeCompensationInfoManager.getInstance().getMergeSystemTimestamp()) }));
/*     */       
/*     */ 
/*  73 */       return false;
/*     */     }
/*  75 */     if (deltaDay.intValue() == 0)
/*     */     {
/*     */ 
/*  78 */       TLogArg tLogArg = new TLogArg(LogReason.MERGE_COMPENSATION_MAIN);
/*  79 */       SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(roleid, SMergeCompensationConsts.getInstance().A_MAIL_CFG_ID, new ArrayList(), new ArrayList(), tLogArg);
/*     */       
/*     */ 
/*  82 */       if (!sendMailRet.isOK())
/*     */       {
/*  84 */         MergeCompensationManager.logger.info(String.format("[merge_compensation]POnRoleLogin.processImp@send mail fail|roleid=%d|merge_system_timestamp=%d|delta_day=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(MergeCompensationInfoManager.getInstance().getMergeSystemTimestamp()), deltaDay }));
/*     */         
/*     */ 
/*  87 */         return false;
/*     */       }
/*  89 */       MergeCompensationManager.logger.info(String.format("[merge_compensation]POnRoleLogin.processImp@send compensation success|roleid=%d|merge_system_timestamp=%d|delta_day=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(MergeCompensationInfoManager.getInstance().getMergeSystemTimestamp()), deltaDay }));
/*     */ 
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*     */ 
/*  96 */       int itemCfgid = MergeCompensationManager.getExpBottleItemCfgid(deltaDay.intValue());
/*  97 */       if (itemCfgid <= 0)
/*     */       {
/*     */ 
/* 100 */         MergeCompensationManager.logger.info(String.format("[merge_compensation]POnRoleLogin.processImp@get item cfg id fail|roleid=%d|merge_system_timestamp=%d|delta_day=%d|reason=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(MergeCompensationInfoManager.getInstance().getMergeSystemTimestamp()), deltaDay, Integer.valueOf(itemCfgid) }));
/*     */         
/*     */ 
/* 103 */         return false;
/*     */       }
/* 105 */       TLogArg tLogArg = new TLogArg(LogReason.MERGE_COMPENSATION_VICE);
/* 106 */       MailAttachment mailAttachment = MailInterface.createMailAttachment();
/* 107 */       mailAttachment.addItem(itemCfgid, 1, true);
/* 108 */       SendMailRet sendMailRet = MailInterface.synBuildAndSendMail(roleid, SMergeCompensationConsts.getInstance().B_MAIL_CFG_ID, new ArrayList(), new ArrayList(), mailAttachment, tLogArg);
/*     */       
/*     */ 
/* 111 */       if (!sendMailRet.isOK())
/*     */       {
/* 113 */         MergeCompensationManager.logger.info(String.format("[merge_compensation]POnRoleLogin.processImp@get mail fail|roleid=%d|merge_system_timestamp=%d|delta_day=%d|item_cfg_id=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(MergeCompensationInfoManager.getInstance().getMergeSystemTimestamp()), deltaDay, Integer.valueOf(itemCfgid) }));
/*     */         
/*     */ 
/* 116 */         return false;
/*     */       }
/* 118 */       MergeCompensationManager.logger.info(String.format("[merge_compensation]POnRoleLogin.processImp@send compensation success|roleid=%d|merge_system_timestamp=%d|delta_day=%d|item_cfg_id=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(MergeCompensationInfoManager.getInstance().getMergeSystemTimestamp()), deltaDay, Integer.valueOf(itemCfgid) }));
/*     */     }
/*     */     
/*     */ 
/* 122 */     xRoleMergeCompensationInfo.getHave_got_compensation_merge_system_timestamps().add(Long.valueOf(MergeCompensationInfoManager.getInstance().getMergeSystemTimestamp()));
/*     */     
/* 124 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mergecompensation\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */