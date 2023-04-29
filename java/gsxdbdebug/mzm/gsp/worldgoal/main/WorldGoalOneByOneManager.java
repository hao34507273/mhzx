/*    */ package mzm.gsp.worldgoal.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.util.OneByOneManager;
/*    */ import mzm.gsp.worldgoal.confbean.SWorldGoalCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldGoalOneByOneManager
/*    */   extends OneByOneManager<Integer>
/*    */ {
/* 15 */   private static final WorldGoalOneByOneManager instance = new WorldGoalOneByOneManager();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static WorldGoalOneByOneManager getInstance()
/*    */   {
/* 23 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */   public int getRecomendCacheSize()
/*    */   {
/* 29 */     return SWorldGoalCfg.getAll().size();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\main\WorldGoalOneByOneManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */