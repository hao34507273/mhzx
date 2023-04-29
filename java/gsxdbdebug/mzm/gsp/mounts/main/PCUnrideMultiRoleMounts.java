/*     */ package mzm.gsp.mounts.main;
/*     */ 
/*     */ import java.util.Collections;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.mounts.SMountsNormalFail;
/*     */ import mzm.gsp.mounts.SRideMultiRoleMountsSuccess;
/*     */ import mzm.gsp.mounts.event.MultiRoleMountsChangeArg.ChangeReason;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.MultiRoleMounts;
/*     */ import xtable.Basic;
/*     */ import xtable.Team2multirolemounts;
/*     */ 
/*     */ public class PCUnrideMultiRoleMounts extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PCUnrideMultiRoleMounts(long roleId)
/*     */   {
/*  23 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */   {
/*  30 */     if (!MountsManager.isMountsSwitchOpen(this.roleId, "PCUnrideMultiRoleMounts.processImp"))
/*     */     {
/*  32 */       return false;
/*     */     }
/*     */     
/*  35 */     if (!MultiRoleMountsManager.isMultiRoleMountsSwitchOpen(this.roleId, "PCUnrideMultiRoleMounts.processImp"))
/*     */     {
/*  37 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  41 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1051, true))
/*     */     {
/*  43 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  47 */     Long teamId = TeamInterface.getTeamidByRoleid(this.roleId, false);
/*  48 */     if (null == teamId)
/*     */     {
/*  50 */       onFail(80, null);
/*  51 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  55 */     long leaderId = TeamInterface.getTeamLeaderByTeamid(teamId.longValue(), false);
/*  56 */     if (leaderId < 0L)
/*     */     {
/*  58 */       onFail(80, null);
/*  59 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  63 */     lock(Basic.getTable(), Collections.singletonList(Long.valueOf(leaderId)));
/*     */     
/*     */ 
/*  66 */     MountsInterface.RideMountsObj rideMountsObj = MountsInterface.getRideMountsObj(leaderId, true);
/*  67 */     int mountsCfgId = rideMountsObj.getMountsCfgId();
/*  68 */     if (mountsCfgId == 0)
/*     */     {
/*  70 */       onFail(82, null);
/*  71 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  75 */     MultiRoleMounts xMultiRoleMounts = Team2multirolemounts.get(teamId);
/*     */     
/*  77 */     if (null == xMultiRoleMounts)
/*     */     {
/*  79 */       onFail(81, null);
/*  80 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  84 */     if (this.roleId == leaderId)
/*     */     {
/*  86 */       onFail(84, xMultiRoleMounts);
/*  87 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  91 */     if (!MultiRoleMountsManager.removeUnmountRole(xMultiRoleMounts, this.roleId))
/*     */     {
/*  93 */       onFail(83, xMultiRoleMounts);
/*  94 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  98 */     MultiRoleMountsManager.triggerMultiRoleMountsChangeViaRole(this.roleId, teamId.longValue(), mountsCfgId, xMultiRoleMounts.getRole_ids(), MultiRoleMountsChangeArg.ChangeReason.MENBER_OPERATE_MULTI_ROLE_MOUNTS);
/*     */     
/*     */ 
/* 101 */     onSuccess(xMultiRoleMounts);
/*     */     
/* 103 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFail(int errorCode, MultiRoleMounts xMultiRoleMounts)
/*     */   {
/* 114 */     OnlineManager.getInstance().sendAtOnce(this.roleId, new SMountsNormalFail(errorCode));
/* 115 */     GameServer.logger().info(String.format("[mounts]PCUnrideMultiRoleMounts.processImp@PCUnrideMultiRoleMounts request fail!|error code=%d,roleId=%d,MultiRoleMounts=%s", new Object[] { Integer.valueOf(errorCode), Long.valueOf(this.roleId), xMultiRoleMounts }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onSuccess(MultiRoleMounts xMultiRoleMounts)
/*     */   {
/* 128 */     OnlineManager.getInstance().send(this.roleId, new SRideMultiRoleMountsSuccess());
/* 129 */     GameServer.logger().info(String.format("[mounts]PCUnrideMultiRoleMounts.processImp@PCUnrideMultiRoleMounts request success!|roleId=%d,After MultiRoleMounts=%s", new Object[] { Long.valueOf(this.roleId), xMultiRoleMounts }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\PCUnrideMultiRoleMounts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */