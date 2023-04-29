/*     */ package mzm.gsp.personal.main;
/*     */ 
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.common.confbean.STimeCommonCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.personal.SQueryPersonalInfoSuccess;
/*     */ import mzm.gsp.personal.confbean.PersonalConsts;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.PraiseInfo;
/*     */ import xbean.PraiseRecord;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2personal;
/*     */ 
/*     */ public class PCQueryPersonalInfo extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final long targetRoleId;
/*     */   
/*     */   public PCQueryPersonalInfo(long roleId, long targetRoleId)
/*     */   {
/*  24 */     this.roleId = roleId;
/*  25 */     this.targetRoleId = targetRoleId;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  31 */     if (!PersonalManager.isFunOpen(this.roleId))
/*     */     {
/*  33 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  37 */     if (!PersonalManager.checkRoleStatus(this.roleId))
/*     */     {
/*  39 */       return false;
/*     */     }
/*     */     
/*  42 */     if (!RoleInterface.isRoleExist(this.targetRoleId, false))
/*     */     {
/*  44 */       onFailed(0);
/*  45 */       return false;
/*     */     }
/*     */     
/*  48 */     String userid = RoleInterface.getUserId(this.roleId);
/*  49 */     String targetUserid = RoleInterface.getUserId(this.targetRoleId);
/*     */     
/*     */ 
/*  52 */     lock(Lockeys.get(xtable.User.getTable(), new Object[] { userid, targetUserid }));
/*  53 */     lock(Lockeys.get(xtable.Basic.getTable(), new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId) }));
/*     */     
/*  55 */     xbean.PersonalInfo xTargetPersonalInfo = Role2personal.get(Long.valueOf(this.targetRoleId));
/*  56 */     if (xTargetPersonalInfo == null)
/*     */     {
/*  58 */       xTargetPersonalInfo = xbean.Pod.newPersonalInfo();
/*  59 */       PersonalManager.initXPersonalInfo(this.targetRoleId, xTargetPersonalInfo);
/*  60 */       Role2personal.insert(Long.valueOf(this.targetRoleId), xTargetPersonalInfo);
/*     */     }
/*     */     
/*  63 */     mzm.gsp.personal.PersonalInfo info = PersonalManager.transInfo(this.targetRoleId, xTargetPersonalInfo);
/*     */     
/*  65 */     xbean.User xTargetUser = xtable.User.get(targetUserid);
/*  66 */     info.figure_url.setString(xTargetUser.getFigure_url(), "UTF-8");
/*     */     
/*     */ 
/*  69 */     if (this.roleId != this.targetRoleId)
/*     */     {
/*  71 */       xbean.PersonalInfo xMySelfPersonalInfo = Role2personal.get(Long.valueOf(this.roleId));
/*  72 */       if (xMySelfPersonalInfo != null)
/*     */       {
/*  74 */         long now = DateTimeUtils.getCurrTimeInMillis();
/*  75 */         long lastPraiseTime = xMySelfPersonalInfo.getPraise().getPraise_timestamp();
/*  76 */         STimeCommonCfg timeCommonCfg = mzm.gsp.common.TimeCommonUtil.getCommonCfg(PersonalConsts.getInstance().PRAISE_CLEAR_TIME);
/*  77 */         if (DateTimeUtils.needDailyReset(lastPraiseTime, now, timeCommonCfg.activeHour, timeCommonCfg.activeMinute))
/*     */         {
/*  79 */           xMySelfPersonalInfo.getPraise().getPraise_records().clear();
/*     */         }
/*     */         
/*  82 */         PraiseRecord xPraiseRecord = (PraiseRecord)xMySelfPersonalInfo.getPraise().getPraise_records().get(Long.valueOf(this.targetRoleId));
/*     */         
/*  84 */         if (xPraiseRecord != null)
/*     */         {
/*  86 */           info.praise = xPraiseRecord.getNum();
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*  92 */     SQueryPersonalInfoSuccess resp = new SQueryPersonalInfoSuccess();
/*  93 */     resp.roleid = this.targetRoleId;
/*  94 */     resp.personalinfo = info;
/*  95 */     OnlineManager.getInstance().send(this.roleId, resp);
/*     */     
/*  97 */     GameServer.logger().info(String.format("[personal]PCQueryPersonalInfo.processImp@query success|roleid=%d|target_roleid=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId) }));
/*     */     
/*     */ 
/* 100 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int retCode)
/*     */   {
/* 105 */     mzm.gsp.personal.SQueryPersonalInfoFailed resp = new mzm.gsp.personal.SQueryPersonalInfoFailed();
/* 106 */     resp.retcode = retCode;
/* 107 */     resp.roleid = this.targetRoleId;
/* 108 */     OnlineManager.getInstance().sendAtOnce(this.roleId, resp);
/*     */     
/* 110 */     GameServer.logger().info(String.format("[personal]PCQueryPersonalInfo.onFailed@query failed|roleid=%d|target_roleid=%d|ret=%d", new Object[] { Long.valueOf(this.roleId), Long.valueOf(this.targetRoleId), Integer.valueOf(retCode) }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\main\PCQueryPersonalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */