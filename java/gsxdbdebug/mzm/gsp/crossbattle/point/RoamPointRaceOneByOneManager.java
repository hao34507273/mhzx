/*    */ package mzm.gsp.crossbattle.point;
/*    */ 
/*    */ import mzm.gsp.util.OneByOneManager;
/*    */ 
/*    */ public class RoamPointRaceOneByOneManager
/*    */   extends OneByOneManager<Long>
/*    */ {
/*  8 */   private static final RoamPointRaceOneByOneManager instance = new RoamPointRaceOneByOneManager();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static RoamPointRaceOneByOneManager getInstance()
/*    */   {
/* 16 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */   public int getRecomendCacheSize()
/*    */   {
/* 22 */     return 10;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\point\RoamPointRaceOneByOneManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */