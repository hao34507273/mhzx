/*    */ package mzm.gsp.crossbattle.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*    */ import mzm.gsp.util.OneByOneManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CrossBattleOneByOneManager
/*    */   extends OneByOneManager<Integer>
/*    */ {
/* 14 */   private static final CrossBattleOneByOneManager instance = new CrossBattleOneByOneManager();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static CrossBattleOneByOneManager getInstance()
/*    */   {
/* 22 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */   public int getRecomendCacheSize()
/*    */   {
/* 28 */     return SCrossBattleOwnCfg.getAll().size();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\main\CrossBattleOneByOneManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */