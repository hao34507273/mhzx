/*     */ package mzm.gsp.breakegg.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.breakegg.SBreakEggInviteFail;
/*     */ import mzm.gsp.breakegg.invite.InviteConfirmInterface;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.nationalholiday.confbean.SBreakEggCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PCBreakEggInviteReq
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int activityCfgId;
/*     */   
/*     */   public PCBreakEggInviteReq(long roleId, int activityCfgId)
/*     */   {
/*  33 */     this.roleId = roleId;
/*  34 */     this.activityCfgId = activityCfgId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     SBreakEggCfg sBreakEggCfg = SBreakEggCfg.get(this.activityCfgId);
/*  43 */     if (sBreakEggCfg == null)
/*     */     {
/*  45 */       onFailed(4);
/*  46 */       return false;
/*     */     }
/*     */     
/*  49 */     if (!BreakEggManager.isBreakEggSwitchOpen(this.roleId, sBreakEggCfg.openId))
/*     */     {
/*  51 */       return false;
/*     */     }
/*  53 */     String userId = RoleInterface.getUserId(this.roleId);
/*  54 */     if (userId == null)
/*     */     {
/*  56 */       onFailed(2);
/*  57 */       return false;
/*     */     }
/*     */     
/*  60 */     lock(Lockeys.get(User.getTable(), userId));
/*     */     
/*  62 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*  64 */     long gangId = GangInterface.getGangId(this.roleId);
/*  65 */     if (gangId <= 0L)
/*     */     {
/*  67 */       onFailed(7);
/*  68 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  72 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1862, true, true))
/*     */     {
/*  74 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  78 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userId, this.roleId, this.activityCfgId);
/*     */     
/*  80 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/*  83 */       Map<String, Object> extraInfo = new HashMap();
/*  84 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  85 */       onFailed(5, extraInfo);
/*  86 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  90 */     if (InviteConfirmInterface.isInInviteConfirm(this.roleId))
/*     */     {
/*  92 */       onFailed(6);
/*  93 */       return false;
/*     */     }
/*  95 */     BreakEggInviteConfirmContext context = new BreakEggInviteConfirmContext();
/*  96 */     context.activityCfgId = this.activityCfgId;
/*     */     
/*  98 */     InviteConfirmInterface.sendInviteConfirm(this.roleId, sBreakEggCfg.inviteType, context);
/*     */     
/*     */ 
/* 101 */     ActivityInterface.logActivity(this.roleId, this.activityCfgId, ActivityLogStatus.ATTEND);
/*     */     
/* 103 */     ActivityInterface.tlogActivity(this.roleId, this.activityCfgId, ActivityLogStatus.ATTEND);
/*     */     
/* 105 */     BreakEggManager.logger.info(String.format("[breakegg]PCBreakEggInviteReq.processImp@ success|userId=%s|roleId=%d|activityCfgId=%d", new Object[] { userId, Long.valueOf(this.roleId), Integer.valueOf(this.activityCfgId) }));
/*     */     
/*     */ 
/*     */ 
/* 109 */     return true;
/*     */   }
/*     */   
/*     */   private void onFailed(int errorCode)
/*     */   {
/* 114 */     onFailed(errorCode, null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFailed(int errorCode, Map<String, Object> extraParams)
/*     */   {
/* 125 */     SBreakEggInviteFail rsp = new SBreakEggInviteFail();
/* 126 */     rsp.activity_id = this.activityCfgId;
/* 127 */     rsp.error_code = errorCode;
/* 128 */     OnlineManager.getInstance().sendAtOnce(this.roleId, rsp);
/*     */     
/* 130 */     StringBuffer logBuilder = new StringBuffer();
/* 131 */     logBuilder.append("[breakegg]PCBreakEggInviteReq.onFailed@processImp() failed");
/* 132 */     logBuilder.append('|').append("roleid=").append(this.roleId);
/* 133 */     logBuilder.append('|').append("activityCfgId=").append(this.activityCfgId);
/* 134 */     logBuilder.append('|').append("error_code=").append(errorCode);
/*     */     
/* 136 */     if (extraParams != null)
/*     */     {
/* 138 */       for (Map.Entry<String, Object> entry : extraParams.entrySet())
/*     */       {
/* 140 */         logBuilder.append('|').append((String)entry.getKey()).append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*     */     
/* 144 */     GameServer.logger().error(logBuilder.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\main\PCBreakEggInviteReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */