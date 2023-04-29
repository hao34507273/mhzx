/*    */ package mzm.gsp.relatedboss.main;
/*    */ 
/*    */ import mzm.gsp.map.event.WorldDestroyEventProcedure;
/*    */ import xtable.Relatedboss;
/*    */ 
/*    */ 
/*    */ public class POnWorldDestroy
/*    */   extends WorldDestroyEventProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 13 */     Relatedboss.remove((Long)this.arg);
/*    */     
/* 15 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\relatedboss\main\POnWorldDestroy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */