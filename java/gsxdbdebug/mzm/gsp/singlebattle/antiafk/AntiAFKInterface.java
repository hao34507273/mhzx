/*    */ package mzm.gsp.singlebattle.antiafk;
/*    */ 
/*    */ import mzm.gsp.singlebattle.main.SingleBattleInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AntiAFKInterface
/*    */ {
/*    */   public static void init()
/*    */   {
/* 13 */     SingleBattleInterface.registerPlayHandler(6, new AntiAFKPlayTypeHandler());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\antiafk\AntiAFKInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */