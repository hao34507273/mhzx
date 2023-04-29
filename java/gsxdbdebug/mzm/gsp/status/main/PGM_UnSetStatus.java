/*    */ package mzm.gsp.status.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_UnSetStatus extends LogicProcedure
/*    */ {
/*    */   private long roleid;
/*    */   private int status;
/*    */   
/*    */   public PGM_UnSetStatus(long roleid, int status) {
/* 11 */     this.roleid = roleid;
/* 12 */     this.status = status;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     RoleStatusInterface.unsetStatus(this.roleid, this.status);
/* 18 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\status\main\PGM_UnSetStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */