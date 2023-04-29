/*     */ package mzm.gsp.map.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import mzm.gsp.map.main.message.MMH_TeamLeaderChange;
/*     */ import mzm.gsp.map.main.message.MMH_TeamMemberStateChange;
/*     */ import mzm.gsp.mounts.main.MountsInterface;
/*     */ import mzm.gsp.mounts.main.MultiRoleMountsInfo;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.event.TeamMemberStatusChangedArg;
/*     */ import mzm.gsp.team.event.TeamMemberStatusChangedProcedure;
/*     */ import xtable.Role2properties;
/*     */ 
/*     */ public class POnTeamMemberStatusChanged extends TeamMemberStatusChangedProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  19 */     MultiRoleMountsInfo multiMountsInfo = MountsInterface.getMultiRoleMountsInfo(((TeamMemberStatusChangedArg)this.arg).teamid, false);
/*     */     
/*  21 */     long nowLeader = ((TeamMemberStatusChangedArg)this.arg).getNowLeaderId();
/*  22 */     lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(nowLeader), Long.valueOf(((TeamMemberStatusChangedArg)this.arg).roleid) }));
/*     */     
/*  24 */     if (((TeamMemberStatusChangedArg)this.arg).status == 0)
/*     */     {
/*     */ 
/*  27 */       if (RoleStatusInterface.containsStatus(nowLeader, 2))
/*     */       {
/*     */ 
/*  30 */         RoleStatusInterface.setStatus(((TeamMemberStatusChangedArg)this.arg).roleid, 2, false);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*  35 */         RoleStatusInterface.unsetStatus(((TeamMemberStatusChangedArg)this.arg).roleid, 2);
/*     */       }
/*     */       
/*  38 */       if (multiMountsInfo == null)
/*     */       {
/*  40 */         new MMH_TeamMemberStateChange(((TeamMemberStatusChangedArg)this.arg).teamid, ((TeamMemberStatusChangedArg)this.arg).roleid, ((TeamMemberStatusChangedArg)this.arg).status, 0).execute();
/*     */       }
/*     */       else
/*     */       {
/*  44 */         new MMH_TeamMemberStateChange(((TeamMemberStatusChangedArg)this.arg).teamid, ((TeamMemberStatusChangedArg)this.arg).roleid, ((TeamMemberStatusChangedArg)this.arg).status, 0, multiMountsInfo.mountsCfgId, multiMountsInfo.roleIds).execute();
/*     */       }
/*     */       
/*     */ 
/*  48 */       return true;
/*     */     }
/*     */     
/*     */ 
/*  52 */     if (((TeamMemberStatusChangedArg)this.arg).isLeaderChanged())
/*     */     {
/*     */ 
/*  55 */       int flySpeed = 0;
/*  56 */       if (RoleStatusInterface.containsStatus(nowLeader, 2))
/*     */       {
/*  58 */         flySpeed = RoleInterface.getFlySpeed(nowLeader, true);
/*  59 */         if (flySpeed <= 0)
/*     */         {
/*  61 */           RoleStatusInterface.unsetStatus(nowLeader, 2);
/*     */         }
/*     */       }
/*     */       
/*  65 */       boolean oldOffline = !OnlineManager.getInstance().isOnline(((TeamMemberStatusChangedArg)this.arg).roleid);
/*  66 */       if (multiMountsInfo == null)
/*     */       {
/*  68 */         new MMH_TeamLeaderChange(((TeamMemberStatusChangedArg)this.arg).teamid, nowLeader, flySpeed, ((TeamMemberStatusChangedArg)this.arg).roleid, true, oldOffline).execute();
/*     */       }
/*     */       else
/*     */       {
/*  72 */         new MMH_TeamLeaderChange(((TeamMemberStatusChangedArg)this.arg).teamid, nowLeader, flySpeed, ((TeamMemberStatusChangedArg)this.arg).roleid, true, oldOffline, multiMountsInfo.mountsCfgId, multiMountsInfo.roleIds).execute();
/*     */       }
/*     */       
/*     */ 
/*  76 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*  81 */     int flySpeed = 0;
/*  82 */     boolean isFly = RoleStatusInterface.containsStatus(((TeamMemberStatusChangedArg)this.arg).roleid, 2);
/*  83 */     if (isFly)
/*     */     {
/*  85 */       flySpeed = RoleInterface.getFlySpeed(((TeamMemberStatusChangedArg)this.arg).roleid, true);
/*  86 */       if (flySpeed <= 0)
/*     */       {
/*  88 */         RoleStatusInterface.unsetStatus(((TeamMemberStatusChangedArg)this.arg).roleid, 2);
/*     */       }
/*     */     }
/*     */     
/*  92 */     if (multiMountsInfo == null)
/*     */     {
/*  94 */       new MMH_TeamMemberStateChange(((TeamMemberStatusChangedArg)this.arg).teamid, ((TeamMemberStatusChangedArg)this.arg).roleid, ((TeamMemberStatusChangedArg)this.arg).status, flySpeed).execute();
/*     */     }
/*     */     else
/*     */     {
/*  98 */       new MMH_TeamMemberStateChange(((TeamMemberStatusChangedArg)this.arg).teamid, ((TeamMemberStatusChangedArg)this.arg).roleid, ((TeamMemberStatusChangedArg)this.arg).status, flySpeed, multiMountsInfo.mountsCfgId, multiMountsInfo.roleIds).execute();
/*     */     }
/*     */     
/*     */ 
/* 102 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnTeamMemberStatusChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */