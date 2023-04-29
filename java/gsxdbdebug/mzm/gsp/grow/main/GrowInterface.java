/*    */ package mzm.gsp.grow.main;
/*    */ 
/*    */ import mzm.gsp.grow.hand.TargetHandle;
/*    */ import mzm.gsp.grow.hand.TargetRegManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GrowInterface
/*    */ {
/*    */   public static void registerTarget(int moduleType, TargetHandle targetHandler)
/*    */   {
/* 16 */     TargetRegManager.registerTarget(moduleType, targetHandler);
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static void unRegisterTarget(int moduleType)
/*    */   {
/* 26 */     TargetRegManager.unRegisterTarget(moduleType);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grow\main\GrowInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */