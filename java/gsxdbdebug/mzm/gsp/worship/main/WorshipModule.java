/*    */ package mzm.gsp.worship.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.activity.confbean.WorShipConst;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorshipModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 24 */     ActivityInterface.registerActivityByLogicType(80, new WorshipActivityInit());
/* 25 */     new RefreshNPCObserve(WorShipConst.getInstance().refreshNpcCommontimeId);
/* 26 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 32 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 38 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 44 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public void postInit()
/*    */   {
/* 50 */     new LogicRunnable()
/*    */     {
/*    */       public void process()
/*    */         throws Exception
/*    */       {}
/*    */     }.execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worship\main\WorshipModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */