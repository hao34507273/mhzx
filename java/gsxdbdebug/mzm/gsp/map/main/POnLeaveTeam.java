/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.map.main.message.MMH_LeaveTeam;
/*    */ import mzm.gsp.map.main.message.MMH_TeamLeaderChange;
/*    */ import mzm.gsp.mounts.main.MountsInterface;
/*    */ import mzm.gsp.mounts.main.MultiRoleMountsInfo;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.event.LeaveTeamArg;
/*    */ import mzm.gsp.team.event.LeaveTeamProcedure;
/*    */ import xtable.Role2properties;
/*    */ 
/*    */ public class POnLeaveTeam extends LeaveTeamProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     MultiRoleMountsInfo multiMountsInfo = MountsInterface.getMultiRoleMountsInfo(((LeaveTeamArg)this.arg).teamid, false);
/*    */     
/* 21 */     long nowLeaderid = ((LeaveTeamArg)this.arg).getNowLeaderId();
/* 22 */     lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(((LeaveTeamArg)this.arg).roleid), Long.valueOf(nowLeaderid) }));
/*    */     
/* 24 */     if (((LeaveTeamArg)this.arg).isLeaderChanged())
/*    */     {
/* 26 */       int flySpeed = 0;
/* 27 */       boolean nowFly = RoleStatusInterface.containsStatus(nowLeaderid, 2);
/* 28 */       if (nowFly)
/*    */       {
/* 30 */         flySpeed = getFlySpeed(nowLeaderid);
/* 31 */         if (flySpeed <= 0)
/*    */         {
/* 33 */           RoleStatusInterface.unsetStatus(nowLeaderid, 2);
/*    */         }
/*    */       }
/*    */       
/* 37 */       boolean oldoffline = !OnlineManager.getInstance().isOnline(((LeaveTeamArg)this.arg).roleid);
/* 38 */       if (multiMountsInfo == null)
/*    */       {
/* 40 */         new MMH_TeamLeaderChange(((LeaveTeamArg)this.arg).teamid, nowLeaderid, flySpeed, ((LeaveTeamArg)this.arg).roleid, true, oldoffline).execute();
/*    */       }
/*    */       else
/*    */       {
/* 44 */         new MMH_TeamLeaderChange(((LeaveTeamArg)this.arg).teamid, nowLeaderid, flySpeed, ((LeaveTeamArg)this.arg).roleid, true, oldoffline, multiMountsInfo.mountsCfgId, multiMountsInfo.roleIds).execute();
/*    */       }
/*    */       
/*    */     }
/*    */     else
/*    */     {
/* 50 */       int memberFlySpeed = 0;
/* 51 */       boolean isFly = RoleStatusInterface.containsStatus(((LeaveTeamArg)this.arg).roleid, 2);
/* 52 */       if (isFly)
/*    */       {
/* 54 */         memberFlySpeed = getFlySpeed(((LeaveTeamArg)this.arg).roleid);
/* 55 */         if (memberFlySpeed <= 0)
/*    */         {
/* 57 */           RoleStatusInterface.unsetStatus(((LeaveTeamArg)this.arg).roleid, 2);
/*    */         }
/*    */       }
/*    */       
/* 61 */       if (multiMountsInfo == null)
/*    */       {
/* 63 */         new MMH_LeaveTeam(((LeaveTeamArg)this.arg).roleid, ((LeaveTeamArg)this.arg).teamid, memberFlySpeed).execute();
/*    */       }
/*    */       else
/*    */       {
/* 67 */         new MMH_LeaveTeam(((LeaveTeamArg)this.arg).roleid, ((LeaveTeamArg)this.arg).teamid, memberFlySpeed, multiMountsInfo.mountsCfgId, multiMountsInfo.roleIds).execute();
/*    */       }
/*    */     }
/*    */     
/* 71 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private int getFlySpeed(long roleid)
/*    */   {
/* 82 */     return RoleInterface.getFlySpeed(roleid, true);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnLeaveTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */