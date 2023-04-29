/*    */ package mzm.gsp.feisheng.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.feisheng.commititem.CommitItemActivityManager;
/*    */ import mzm.gsp.feisheng.commitpet.CommitPetActivityManager;
/*    */ import mzm.gsp.feisheng.developitem.DevelopItemActivityManager;
/*    */ import mzm.gsp.feisheng.fight.FightActivityManager;
/*    */ import mzm.gsp.feisheng.qingyunzhi.QingYunZhiActivityManager;
/*    */ import mzm.gsp.feisheng.task.TaskActivityManager;
/*    */ import mzm.gsp.feisheng.zhuxianjianzhen.ZhuXianJianZhenActivityManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FeiShengModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int cleanupForMerge()
/*    */   {
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
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 37 */     FeiShengManager.init();
/* 38 */     CommitItemActivityManager.init();
/* 39 */     DevelopItemActivityManager.init();
/* 40 */     TaskActivityManager.init();
/* 41 */     QingYunZhiActivityManager.init();
/* 42 */     CommitPetActivityManager.init();
/* 43 */     FightActivityManager.init();
/* 44 */     ZhuXianJianZhenActivityManager.init();
/* 45 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 51 */     return 0;
/*    */   }
/*    */   
/*    */   public void postInit() {}
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\main\FeiShengModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */