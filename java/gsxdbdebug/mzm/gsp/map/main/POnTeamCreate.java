/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import mzm.gsp.map.main.message.MMH_CreateTeam;
/*    */ import mzm.gsp.mounts.main.MountsInterface;
/*    */ import mzm.gsp.mounts.main.MultiRoleMountsInfo;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.event.TeamCreateArg;
/*    */ import mzm.gsp.team.event.TeamCreateProcedure;
/*    */ import mzm.gsp.team.event.TeamMember;
/*    */ import xtable.Role2properties;
/*    */ 
/*    */ public class POnTeamCreate extends TeamCreateProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     MultiRoleMountsInfo multiMountsInfo = MountsInterface.getMultiRoleMountsInfo(((TeamCreateArg)this.arg).teamid, false);
/*    */     
/* 21 */     List<Long> roles = new ArrayList();
/*    */     
/* 23 */     List<Long> normalMemberRoles = new ArrayList();
/* 24 */     long leaderRoleid = ((TeamCreateArg)this.arg).getLeader();
/* 25 */     for (TeamMember tm : ((TeamCreateArg)this.arg).members)
/*    */     {
/* 27 */       roles.add(Long.valueOf(tm.roleid));
/*    */       
/* 29 */       if (tm.status == 0)
/*    */       {
/* 31 */         if (tm.roleid != leaderRoleid)
/*    */         {
/* 33 */           normalMemberRoles.add(Long.valueOf(tm.roleid));
/*    */         }
/*    */       }
/*    */     }
/* 37 */     lock(Role2properties.getTable(), roles);
/*    */     
/* 39 */     int flySpeed = 0;
/* 40 */     boolean isFly = RoleStatusInterface.containsStatus(leaderRoleid, 2);
/* 41 */     if (isFly)
/*    */     {
/* 43 */       flySpeed = RoleInterface.getFlySpeed(leaderRoleid, true);
/* 44 */       if (flySpeed <= 0)
/*    */       {
/* 46 */         RoleStatusInterface.unsetStatus(normalMemberRoles, 2);
/*    */       }
/*    */       else
/*    */       {
/* 50 */         boolean ret = RoleStatusInterface.setStatus(normalMemberRoles, 2, false);
/* 51 */         if (!ret)
/*    */         {
/* 53 */           flySpeed = 0;
/* 54 */           RoleStatusInterface.unsetStatus(normalMemberRoles, 2);
/*    */         }
/*    */       }
/*    */     }
/*    */     
/* 59 */     if (multiMountsInfo == null)
/*    */     {
/* 61 */       new MMH_CreateTeam(((TeamCreateArg)this.arg).getLeader(), ((TeamCreateArg)this.arg).teamid, normalMemberRoles, flySpeed).execute();
/*    */     }
/*    */     else
/*    */     {
/* 65 */       new MMH_CreateTeam(((TeamCreateArg)this.arg).getLeader(), ((TeamCreateArg)this.arg).teamid, normalMemberRoles, flySpeed, multiMountsInfo.mountsCfgId, multiMountsInfo.roleIds).execute();
/*    */     }
/*    */     
/*    */ 
/* 69 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\POnTeamCreate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */