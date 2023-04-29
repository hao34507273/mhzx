/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PReturnTeam extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PReturnTeam(long roleid)
/*    */   {
/* 13 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 19 */     int status = TeamInterface.getTeamMemberStatus(this.roleid);
/* 20 */     if ((status == 2) || (status == 1))
/*    */     {
/* 22 */       TeamInterface.returnTeam(this.roleid);
/*    */     }
/*    */     
/* 25 */     GameServer.logger().info(String.format("[crossbattlepoint]PReturnTeam.processImp@handle return team|roleid=%d|status=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(status) }));
/*    */     
/*    */ 
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\PReturnTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */