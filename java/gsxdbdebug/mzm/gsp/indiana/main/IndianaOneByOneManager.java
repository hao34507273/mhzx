/*    */ package mzm.gsp.indiana.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.indiana.confbean.SIndianaCfg;
/*    */ import mzm.gsp.util.OneByOneManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IndianaOneByOneManager
/*    */   extends OneByOneManager<Integer>
/*    */ {
/* 14 */   private static final IndianaOneByOneManager instance = new IndianaOneByOneManager();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static IndianaOneByOneManager getInstance()
/*    */   {
/* 22 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */   public int getRecomendCacheSize()
/*    */   {
/* 28 */     return SIndianaCfg.getAll().size();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\main\IndianaOneByOneManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */