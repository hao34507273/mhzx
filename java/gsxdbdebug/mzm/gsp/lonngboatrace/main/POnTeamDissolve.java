/*    */ package mzm.gsp.lonngboatrace.main;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.team.event.TeamDissolveArg;
/*    */ import mzm.gsp.team.event.TeamDissolveProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class POnTeamDissolve extends TeamDissolveProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 13 */     java.util.List<Long> members = ((TeamDissolveArg)this.arg).members;
/*    */     
/*    */ 
/* 16 */     lock(Basic.getTable(), members);
/*    */     
/* 18 */     GameServer.logger().info(String.format("[lonngboatrace]POnTeamDissolve.processImp@lonngboatrace team dissolved|teamid=%d", new Object[] { Long.valueOf(((TeamDissolveArg)this.arg).teamid) }));
/*    */     
/*    */ 
/*    */ 
/* 22 */     LonngBoatRaceManager.deleteMatchRecordAndStatus(members);
/*    */     
/* 24 */     GameServer.logger().info(String.format("[lonngboatrace]POnTeamDissolve.processImp@lonngboatrace match record deleted|teamid=%d", new Object[] { Long.valueOf(((TeamDissolveArg)this.arg).teamid) }));
/*    */     
/*    */ 
/*    */ 
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\lonngboatrace\main\POnTeamDissolve.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */