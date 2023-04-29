/*    */ package mzm.gsp.singlebattle.resourcepoint;
/*    */ 
/*    */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ResourcePointInterface
/*    */ {
/*    */   public static void init()
/*    */   {
/* 17 */     SingleBattleInterface.registerPlayHandler(3, new ResourcePointPlayTypeHandler());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\resourcepoint\ResourcePointInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */