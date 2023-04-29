/*    */ package mzm.gsp.planttree.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.planttree.confbean.SPlantTreeCfg;
/*    */ import mzm.gsp.util.OneByOneManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PlantTreeOneByOneManager
/*    */   extends OneByOneManager<Integer>
/*    */ {
/* 15 */   private static final PlantTreeOneByOneManager instance = new PlantTreeOneByOneManager();
/*    */   
/*    */   public static PlantTreeOneByOneManager getInstance()
/*    */   {
/* 19 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */   public int getRecomendCacheSize()
/*    */   {
/* 25 */     return SPlantTreeCfg.getAll().size();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\main\PlantTreeOneByOneManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */