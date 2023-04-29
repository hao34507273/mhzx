/*    */ package mzm.gsp.question.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QuestionModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 14 */     KeJuQuestionManager.getInstance().init();
/* 15 */     EveryDayQuestionManager.getInstance().init();
/* 16 */     PictureQuestionManager.getInstance().init();
/* 17 */     WordQuestionManager.getInstance().init();
/* 18 */     KejuRankManager.init();
/* 19 */     QYXTQuestionActivity.init();
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
/*    */   
/*    */   public void postInit() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\QuestionModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */