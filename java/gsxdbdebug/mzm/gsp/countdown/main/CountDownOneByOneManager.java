/*    */ package mzm.gsp.countdown.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.countdown.confbean.SCountDownCfg;
/*    */ import mzm.gsp.util.OneByOneManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CountDownOneByOneManager
/*    */   extends OneByOneManager<Integer>
/*    */ {
/* 15 */   private static final CountDownOneByOneManager instance = new CountDownOneByOneManager();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static CountDownOneByOneManager getInstance()
/*    */   {
/* 23 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */   public int getRecomendCacheSize()
/*    */   {
/* 29 */     return SCountDownCfg.getAll().size();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\countdown\main\CountDownOneByOneManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */