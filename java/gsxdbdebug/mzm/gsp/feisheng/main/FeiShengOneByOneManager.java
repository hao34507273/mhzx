/*    */ package mzm.gsp.feisheng.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.feisheng.confbean.SFeiShengCfg;
/*    */ import mzm.gsp.util.OneByOneManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FeiShengOneByOneManager
/*    */   extends OneByOneManager<Integer>
/*    */ {
/* 14 */   private static final FeiShengOneByOneManager instance = new FeiShengOneByOneManager();
/*    */   
/*    */   public static FeiShengOneByOneManager getInstance()
/*    */   {
/* 18 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */   public int getRecomendCacheSize()
/*    */   {
/* 24 */     return SFeiShengCfg.getAll().size();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\main\FeiShengOneByOneManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */