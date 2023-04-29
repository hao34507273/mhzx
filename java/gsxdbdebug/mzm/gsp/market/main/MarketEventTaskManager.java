/*    */ package mzm.gsp.market.main;
/*    */ 
/*    */ import mzm.gsp.util.TaskOneByOne;
/*    */ 
/*    */ public class MarketEventTaskManager extends TaskOneByOne
/*    */ {
/*  7 */   private static final MarketEventTaskManager instance = new MarketEventTaskManager();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static MarketEventTaskManager getInstance()
/*    */   {
/* 15 */     return instance;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\main\MarketEventTaskManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */