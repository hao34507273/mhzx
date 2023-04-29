/*    */ package mzm.gsp.item.main.sift;
/*    */ 
/*    */ import mzm.gsp.confConverter.ConfManager;
/*    */ 
/*    */ public class SiftItemArgs
/*    */ {
/*    */   int subNodeMax;
/*    */   private static SiftItemArgs instance;
/*    */   
/*    */   public static SiftItemArgs getInstance()
/*    */   {
/* 12 */     return instance;
/*    */   }
/*    */   
/*    */   static void init() {
/* 16 */     instance = (SiftItemArgs)ConfManager.getInstance().getconf("mzm.gsp.item.main.sift.SiftItemArgs");
/* 17 */     if (instance == null) {
/* 18 */       throw new RuntimeException("不存在筛选道具的参数配置");
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\sift\SiftItemArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */