/*    */ package mzm.gsp.children.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.children.SAgreeOrRefusePregnantBelong;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.timer.main.Session;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class SelectPregnantBelongSession
/*    */   extends Session
/*    */ {
/*    */   private final long teamMemberRoleId;
/*    */   private final long belongRoleId;
/*    */   
/*    */   public SelectPregnantBelongSession(long intervalSeconds, long teamLeaderRoleId, long teamMemberRoleId, long belongRoleId)
/*    */   {
/* 18 */     super(intervalSeconds, teamLeaderRoleId);
/* 19 */     this.teamMemberRoleId = teamMemberRoleId;
/* 20 */     this.belongRoleId = belongRoleId;
/*    */   }
/*    */   
/*    */   public long getTeamMemberRoleId()
/*    */   {
/* 25 */     return this.teamMemberRoleId;
/*    */   }
/*    */   
/*    */   public long getBelongRoleId()
/*    */   {
/* 30 */     return this.belongRoleId;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void onTimeOut()
/*    */   {
/* 36 */     new PSelectPregnantBelongSessionTimeOut(super.getOwerId(), this.teamMemberRoleId).execute();
/*    */   }
/*    */   
/*    */   private static class PSelectPregnantBelongSessionTimeOut extends LogicProcedure
/*    */   {
/*    */     private final long teamLeaderRoleId;
/*    */     private final long teamMemberRoleId;
/*    */     
/*    */     public PSelectPregnantBelongSessionTimeOut(long teamLeaderRoleId, long teamMemberRoleId)
/*    */     {
/* 46 */       this.teamLeaderRoleId = teamLeaderRoleId;
/* 47 */       this.teamMemberRoleId = teamMemberRoleId;
/*    */     }
/*    */     
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 53 */       SAgreeOrRefusePregnantBelong sAgreeOrRefusePregnantBelong = new SAgreeOrRefusePregnantBelong();
/* 54 */       sAgreeOrRefusePregnantBelong.operator = 0;
/*    */       
/* 56 */       OnlineManager.getInstance().send(this.teamLeaderRoleId, sAgreeOrRefusePregnantBelong);
/*    */       
/* 58 */       GameServer.logger().info(String.format("[children]PSelectPregnantBelongSession.PSelectPregnantBelongSessionTimeOut.processImp@session time out|team_leader_role_id=%d|team_leader_member_role_id=%d", new Object[] { Long.valueOf(this.teamLeaderRoleId), Long.valueOf(this.teamMemberRoleId) }));
/*    */       
/*    */ 
/*    */ 
/* 62 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\children\main\SelectPregnantBelongSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */