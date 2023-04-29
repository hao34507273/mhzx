/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.team.main.TeamInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ class PForceTmpLeaveTeam extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public PForceTmpLeaveTeam(long roleid)
/*    */   {
/* 12 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     TeamInterface.forceTmpLeaveTeam(this.roleid);
/*    */     
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\PForceTmpLeaveTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */