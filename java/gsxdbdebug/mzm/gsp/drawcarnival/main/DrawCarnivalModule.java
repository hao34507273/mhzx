/*    */ package mzm.gsp.drawcarnival.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.drawcarnival.confbean.SDrawCarnivalConsts;
/*    */ import mzm.gsp.open.main.OpenInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DrawCarnivalModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 16 */     DrawCarnivalManager.init();
/*    */     
/* 18 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 24 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 30 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 36 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void postInit()
/*    */   {
/* 43 */     if (!OpenInterface.getOpenStatus(592))
/*    */     {
/* 45 */       return;
/*    */     }
/*    */     
/* 48 */     DrawCarnivalOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(SDrawCarnivalConsts.getInstance().ACTIVITY_ID), new PTriggerOrCollectChests(true));
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\main\DrawCarnivalModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */