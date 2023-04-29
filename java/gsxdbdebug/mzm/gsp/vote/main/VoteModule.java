/*    */ package mzm.gsp.vote.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity2.confbean.FucntionVoteConsts;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class VoteModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public void postInit() {}
/*    */   
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 24 */     ActivityInterface.registerActivityByLogicType(77, new PVoteActivityInit());
/*    */     
/*    */ 
/* 27 */     VoteHandManager.registerSingleActivityHandler(FucntionVoteConsts.getInstance().activityId, NewFunctionVoteActivity.getInstance());
/*    */     
/*    */ 
/* 30 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int exit()
/*    */   {
/* 37 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 44 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 51 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\vote\main\VoteModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */