/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGotoGangMap
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   
/*    */   public PGotoGangMap(long roleId)
/*    */   {
/* 19 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     Long teamId = TeamInterface.getTeamidByRoleid(this.roleId, false);
/*    */     
/* 27 */     if ((teamId == null) || (!TeamInterface.isTeamMemberNormal(this.roleId)))
/*    */     {
/* 29 */       if (!RoleStatusInterface.checkCanSetStatus(this.roleId, 15, true))
/*    */       {
/* 31 */         return false;
/*    */       }
/*    */       
/* 34 */       GangManager.gotoGangMap(this.roleId, true);
/* 35 */       return true;
/*    */     }
/*    */     
/* 38 */     if (TeamInterface.isTeamLeader(teamId.longValue(), this.roleId, false)) {
/* 39 */       List<Long> memberList = TeamInterface.getNormalRoleList(this.roleId);
/*    */       
/* 41 */       if (!RoleStatusInterface.checkCansetStatus(memberList, 15, true))
/*    */       {
/* 43 */         return false;
/*    */       }
/*    */       
/* 46 */       GangManager.gotoGangMap(this.roleId, true);
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PGotoGangMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */