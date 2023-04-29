/*    */ package mzm.gsp.grow.daytarget;
/*    */ 
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnDayTargetChange
/*    */   extends OpenChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 16 */     if (((OpenChangeComplexArg)this.arg).getType() != 134)
/*    */     {
/* 18 */       return false;
/*    */     }
/* 20 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\daytarget\POnDayTargetChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */