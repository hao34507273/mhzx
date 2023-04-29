/*    */ package mzm.gsp.huanhun.main;
/*    */ 
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnOpenChange
/*    */   extends OpenChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     if (((OpenChangeComplexArg)this.arg).getType() != 9)
/*    */     {
/* 19 */       return false;
/*    */     }
/*    */     
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\POnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */