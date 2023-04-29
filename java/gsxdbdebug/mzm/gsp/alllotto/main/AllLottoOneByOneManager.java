/*    */ package mzm.gsp.alllotto.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.alllotto.confbean.SAllLottoCfg;
/*    */ import mzm.gsp.util.OneByOneManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AllLottoOneByOneManager
/*    */   extends OneByOneManager<Integer>
/*    */ {
/* 14 */   private static final AllLottoOneByOneManager instance = new AllLottoOneByOneManager();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static AllLottoOneByOneManager getInstance()
/*    */   {
/* 22 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */   public int getRecomendCacheSize()
/*    */   {
/* 28 */     return SAllLottoCfg.getAll().size();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\alllotto\main\AllLottoOneByOneManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */