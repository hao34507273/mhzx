/*    */ package mzm.gsp.singlebattle.main;
/*    */ 
/*    */ import mzm.gsp.util.OneByOneManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BattleTaskOneByOne
/*    */   extends OneByOneManager<Long>
/*    */ {
/* 13 */   private static final BattleTaskOneByOne instance = new BattleTaskOneByOne();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static BattleTaskOneByOne getInstance()
/*    */   {
/* 21 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int getRecomendCacheSize()
/*    */   {
/* 28 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\BattleTaskOneByOne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */