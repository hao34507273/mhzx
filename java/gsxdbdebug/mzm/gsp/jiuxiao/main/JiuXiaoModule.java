/*    */ package mzm.gsp.jiuxiao.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class JiuXiaoModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 13 */     JiuXiaoCfgManager.init();
/* 14 */     JiuXiaoRankManager.init();
/* 15 */     return 0;
/*    */   }
/*    */   
/*    */   public int exit()
/*    */   {
/* 20 */     new LogicProcedure()
/*    */     {
/*    */       protected boolean processImp() throws Exception
/*    */       {
/* 24 */         JiuXiaoRankManager.getInstance().saveToDB();
/* 25 */         return true;
/*    */       }
/* 27 */     }.call();
/* 28 */     return 0;
/*    */   }
/*    */   
/*    */   public int cleanupForMerge()
/*    */   {
/* 33 */     return 0;
/*    */   }
/*    */   
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 38 */     return 0;
/*    */   }
/*    */   
/*    */   public void postInit() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\jiuxiao\main\JiuXiaoModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */