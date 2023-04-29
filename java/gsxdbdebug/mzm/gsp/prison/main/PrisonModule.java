/*    */ package mzm.gsp.prison.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.gsp.confirm.main.TeamConfirmInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PrisonModule
/*    */   implements Module
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 17 */     PrisonPageManager.getInstance().loadData();
/* 18 */     TeamConfirmInterface.registerConfirmHandler(6, new JailBreakConfirmHandler());
/* 19 */     TeamConfirmInterface.registerConfirmHandler(5, new JailDeliveryConfirmHandler());
/* 20 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 26 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 32 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 38 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\prison\main\PrisonModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */