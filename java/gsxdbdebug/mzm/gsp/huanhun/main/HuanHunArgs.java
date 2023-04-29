/*    */ package mzm.gsp.huanhun.main;
/*    */ 
/*    */ import mzm.gsp.confConverter.ConfManager;
/*    */ 
/*    */ public class HuanHunArgs {
/*    */   private static volatile HuanHunArgs instance;
/*    */   int cookType;
/*    */   int lianyaoType;
/*    */   
/*    */   static HuanHunArgs getInstance() {
/* 11 */     if (instance == null)
/*    */     {
/* 13 */       synchronized (HuanHunArgs.class)
/*    */       {
/* 15 */         if (instance == null)
/*    */         {
/* 17 */           init();
/*    */         }
/*    */       }
/*    */     }
/* 21 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   static void init()
/*    */   {
/* 30 */     instance = (HuanHunArgs)ConfManager.getInstance().getconf("mzm.gsp.huanhun.main.HuanHunArgs");
/* 31 */     if (instance == null)
/*    */     {
/* 33 */       throw new RuntimeException("HuanHunArgs文件不存在！");
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\huanhun\main\HuanHunArgs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */