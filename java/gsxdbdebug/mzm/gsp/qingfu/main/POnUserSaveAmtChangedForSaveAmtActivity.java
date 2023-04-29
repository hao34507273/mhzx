/*    */ package mzm.gsp.qingfu.main;
/*    */ 
/*    */ import mzm.gsp.qingfu.event.SaveAmtChangedArg;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class POnUserSaveAmtChangedForSaveAmtActivity extends LogicProcedure
/*    */ {
/*    */   private final SaveAmtChangedArg arg;
/*    */   
/*    */   public POnUserSaveAmtChangedForSaveAmtActivity(SaveAmtChangedArg arg)
/*    */   {
/* 12 */     this.arg = arg;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 18 */     return SaveAmtActivityManager.onSaveAmtChanged(this.arg);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\main\POnUserSaveAmtChangedForSaveAmtActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */