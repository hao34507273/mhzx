/*    */ package mzm.gsp.timeflow.main;
/*    */ 
/*    */ import mzm.gsp.util.OneByOneManager;
/*    */ 
/*    */ public class TimeFlowEventOneByOneManager extends OneByOneManager<Long>
/*    */ {
/*  7 */   private static final TimeFlowEventOneByOneManager instance = new TimeFlowEventOneByOneManager();
/*    */   
/*    */   public static TimeFlowEventOneByOneManager getInstance()
/*    */   {
/* 11 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getRecomendCacheSize()
/*    */   {
/* 21 */     return 256;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\timeflow\main\TimeFlowEventOneByOneManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */