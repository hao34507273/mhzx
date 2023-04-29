/*    */ package mzm.gsp.teamplatform.match;
/*    */ 
/*    */ import mzm.gsp.confConverter.ConfManager;
/*    */ 
/*    */ 
/*    */ public class MatchArgs
/*    */ {
/*    */   public int dealSize;
/*    */   public int intervalMil;
/*    */   public int cacheSize;
/*    */   private static MatchArgs instance;
/*    */   
/*    */   public static MatchArgs getInstance()
/*    */   {
/* 15 */     return instance;
/*    */   }
/*    */   
/*    */   static void init()
/*    */   {
/* 20 */     instance = (MatchArgs)ConfManager.getInstance().getconf("mzm.gsp.teamplatform.match.MatchArgs");
/* 21 */     if (instance == null)
/*    */     {
/* 23 */       throw new RuntimeException("MatchArgs文件不存在！");
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\MatchArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */