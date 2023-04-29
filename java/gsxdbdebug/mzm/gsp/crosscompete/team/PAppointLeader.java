/*    */ package mzm.gsp.crosscompete.team;
/*    */ 
/*    */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ 
/*    */ public class PAppointLeader extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long teamid;
/*    */   private final long roleid;
/*    */   
/*    */   public PAppointLeader(long teamid, long roleid)
/*    */   {
/* 13 */     this.teamid = teamid;
/* 14 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     TeamInterface.appointLeader(this.teamid, this.roleid);
/*    */     
/* 21 */     CrossCompeteManager.logInfo("PAppointLeader.processImp@appoint leader|teamid=%d|roleid=%d", new Object[] { Long.valueOf(this.teamid), Long.valueOf(this.roleid) });
/*    */     
/*    */ 
/*    */ 
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\team\PAppointLeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */