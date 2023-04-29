/*    */ package mzm.gsp.paraselene.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ParaseleneModule
/*    */   implements PostModuleInitListner, Module
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 15 */     ParaseleneManager.init();
/* 16 */     ActivityInterface.registerActivityByLogicType(16, new ParaseleneActivityInit());
/* 17 */     ParaseleneRankManager.init();
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
/*    */   public void postInit() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\ParaseleneModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */