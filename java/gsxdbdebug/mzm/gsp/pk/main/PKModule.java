/*    */ package mzm.gsp.pk.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.confirm.main.TeamConfirmInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PKModule
/*    */   implements Module
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 19 */     TeamConfirmInterface.registerConfirmHandler(3, new PKTeamConfirmHandler());
/* 20 */     ActivityInterface.registerActivityByLogicType(112);
/* 21 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 27 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 33 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 39 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pk\main\PKModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */