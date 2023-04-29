/*    */ package mzm.gsp.hula.main;
/*    */ 
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeProcedure;
/*    */ 
/*    */ public class POnHulaSwitchChange
/*    */   extends OpenChangeProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 11 */     if (((OpenChangeComplexArg)this.arg).getType() != 200)
/*    */     {
/* 13 */       return false;
/*    */     }
/* 15 */     if (!((OpenChangeComplexArg)this.arg).isOpen())
/*    */     {
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/* 21 */       HulaWorldManager.getInstance().destroyWorld();
/*    */     }
/*    */     
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\main\POnHulaSwitchChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */