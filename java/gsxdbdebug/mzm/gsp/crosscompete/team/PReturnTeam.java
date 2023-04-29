/*    */ package mzm.gsp.crosscompete.team;
/*    */ 
/*    */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ 
/*    */ public class PReturnTeam extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PReturnTeam(long roleid)
/*    */   {
/* 12 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     TeamInterface.returnTeam(this.roleid);
/*    */     
/* 19 */     CrossCompeteManager.logInfo("PReturnTeam.processImp@return team|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*    */     
/* 21 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\team\PReturnTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */