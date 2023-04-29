/*    */ package mzm.gsp.genius.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnDoubleGeniusClosed extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   public POnDoubleGeniusClosed(long roleid)
/*    */   {
/* 11 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     return GeniusManager.checkDoubleGeniusSeriesClosed(this.roleid, true);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\genius\main\POnDoubleGeniusClosed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */