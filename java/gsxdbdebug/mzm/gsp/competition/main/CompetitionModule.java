/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activitycompensate.main.ActivityCompensateInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CompetitionModule
/*    */   implements Module
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 19 */     CompetitionConfigManager.getInstance().init();
/* 20 */     CompetitionActivityHandler handler = new CompetitionActivityHandler();
/*    */     
/* 22 */     ActivityInterface.registerActivityByLogicType(20, handler);
/*    */     
/* 24 */     ActivityCompensateInterface.registerCompensateHandler(20, handler);
/* 25 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 31 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 37 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 43 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\CompetitionModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */