/*    */ package mzm.gsp.server.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.confConverter.ConfManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class AvailableStringArgs
/*    */ {
/*    */   List<Scope> usableScopeList;
/*    */   private static AvailableStringArgs instance;
/*    */   
/*    */   public boolean isCharUsable(char c)
/*    */   {
/* 15 */     int cValue = c;
/* 16 */     for (Scope scope : this.usableScopeList) {
/* 17 */       if ((cValue >= scope.lowerLimit) && (cValue <= scope.upperLimit))
/* 18 */         return true;
/*    */     }
/* 20 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public boolean isStringUsable(String str)
/*    */   {
/* 31 */     for (int i = 0; i < str.length(); i++) {
/* 32 */       if (!getInstance().isCharUsable(str.charAt(i)))
/* 33 */         return false;
/*    */     }
/* 35 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public static AvailableStringArgs getInstance()
/*    */   {
/* 42 */     return instance;
/*    */   }
/*    */   
/*    */   static int init()
/*    */   {
/* 47 */     instance = (AvailableStringArgs)ConfManager.getInstance().getconf("mzm.gsp.server.main.AvailableStringArgs");
/*    */     
/* 49 */     if (instance == null) {
/* 50 */       return -1;
/*    */     }
/* 52 */     return 0;
/*    */   }
/*    */   
/*    */   public static class Scope
/*    */   {
/*    */     int lowerLimit;
/*    */     int upperLimit;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\server\main\AvailableStringArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */