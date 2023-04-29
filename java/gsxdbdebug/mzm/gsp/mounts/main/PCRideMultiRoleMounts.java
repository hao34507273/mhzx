/*     */ package mzm.gsp.mounts.main;
/*     */ 
/*     */ import java.util.Arrays;
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
/*     */ public class PCRideMultiRoleMounts extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   
/*     */   public PCRideMultiRoleMounts(long roleId)
/*     */   {
/*  23 */     this.roleId = roleId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   protected boolean processImp()
/*     */   {
/*  30 */     if (!MountsManager.isMountsSwitchOpen(this.roleId, "PCRideMultiRoleMounts.processImp"))
/*     */     {
/*  32 */       return false;
/*     */     }
/*     */     
/*  35 */     if (!MultiRoleMountsManager.isMultiRoleMountsSwitchOpen(this.roleId, "PCRideMultiRoleMounts.processImp"))
/*     */     {
/*  37 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  41 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 1050, true))
/*     */     {
/*  43 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  47 */     Long teamId = TeamInterface.getTeamidByRoleid(this.roleId, false);
/*  48 */     if (null == teamId)
/*     */     {
/*  50 */       onFail(74, null);
/*  51 */       return false;
/*     */     }
/*  53 */     long leaderId = TeamInterface.getTeamLeaderByTeamid(teamId.longValue(), false);
/*  54 */     if (leaderId < 0L)
/*     */     {
/*  56 */       onFail(74, null);
/*  57 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  61 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId), Long.valueOf(leaderId) }));
/*     */     
/*     */ 
/*  64 */     MultiRoleMounts xMultiRoleMounts = Team2multirolemounts.get(teamId);
/*     */     
/*  66 */     if (null == xMultiRoleMounts)
/*     */     {
/*  68 */       onFail(75, null);
/*  69 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  73 */     if (!TeamInterface.isTeamMemberNormal(this.roleId))
/*     */     {
/*  75 */       onFail(85, null);
/*  76 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  80 */     MultiRoleMountsManager.AddMountRoleResult addMountRoleResult = MultiRoleMountsManager.addMountRole(xMultiRoleMounts, leaderId, this.roleId);
/*  81 */     if ((!addMountRoleResult.success) && (addMountRoleResult.failReason == MultiRoleMountsManager.AddMountRoleResult.FailReason.ALREADY_RIDE))
/*     */     {
/*  83 */       onFail(78, xMultiRoleMounts);
/*  84 */       return false;
/*     */     }
/*  86 */     if ((!addMountRoleResult.success) && (addMountRoleResult.failReason == MultiRoleMountsManager.AddMountRoleResult.FailReason.NO_POSITION))
/*     */     {
/*  88 */       onFail(77, xMultiRoleMounts);
/*  89 */       return false;
/*     */     }
/*  91 */     if ((!addMountRoleResult.success) && (addMountRoleResult.failReason == MultiRoleMountsManager.AddMountRoleResult.FailReason.LEADER_NOT_RIDE))
/*     */     {
/*  93 */       onFail(75, xMultiRoleMounts);
/*  94 */       return false;
/*     */     }
/*  96 */     if ((!addMountRoleResult.success) && (addMountRoleResult.failReason == MultiRoleMountsManager.AddMountRoleResult.FailReason.ROLE_IS_LEADER))
/*     */     {
/*  98 */       onFail(79, xMultiRoleMounts);
/*  99 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 103 */     MountsInterface.RideMountsObj rideMountsObj = MountsInterface.getRideMountsObj(leaderId, true);
/* 104 */     int mountsCfgId = rideMountsObj.getMountsCfgId();
/* 105 */     MultiRoleMountsManager.triggerMultiRoleMountsChangeViaRole(this.roleId, teamId.longValue(), mountsCfgId, xMultiRoleMounts.getRole_ids(), MultiRoleMountsChangeArg.ChangeReason.MENBER_OPERATE_MULTI_ROLE_MOUNTS);
/*     */     
/*     */ 
/* 108 */     onSuccess(xMultiRoleMounts);
/*     */     
/* 110 */     return true;
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
/* 121 */     OnlineManager.getInstance().sendAtOnce(this.roleId, new SMountsNormalFail(errorCode));
/* 122 */     GameServer.logger().info(String.format("[mounts]PCRideMultiRoleMounts.processImp@PCRideMultiRoleMounts request fail!|error code=%d,roleId=%d,MultiRoleMounts=%s", new Object[] { Integer.valueOf(errorCode), Long.valueOf(this.roleId), xMultiRoleMounts }));
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
/* 135 */     OnlineManager.getInstance().send(this.roleId, new SRideMultiRoleMountsSuccess());
/* 136 */     GameServer.logger().info(String.format("[mounts]PCRideMultiRoleMounts.processImp@PCRideMultiRoleMounts request success!|roleId=%d,After MultiRoleMounts=%s", new Object[] { Long.valueOf(this.roleId), xMultiRoleMounts }));
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\main\PCRideMultiRoleMounts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */