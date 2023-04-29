/*    */ package mzm.gsp.online.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.MergeModule;
/*    */ import mzm.gsp.pet.main.RememberSkillManager;
/*    */ import xdb.Table;
/*    */ import xtable.Roleforbid;
/*    */ import xtable.Roletalkforbid;
/*    */ import xtable.Userforbid;
/*    */ 
/*    */ public class OnlineModule implements mzm.event.Module, PostModuleInitListner, MergeModule
/*    */ {
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 18 */     LoginArgs.init();
/* 19 */     OnlineInfoArgs.init();
/* 20 */     OnlineInfoFlusher.init();
/* 21 */     OnlineManager.getInstance().setOfflineProtectTime(((String)envs.get("offlineProtectTime")).trim());
/* 22 */     OnlineManager.getInstance().setUserMaxRoleNum(((String)envs.get("USER_MAX_ROLE_NUM")).trim());
/* 23 */     OnlineManager.getInstance().setMaxTaskPerRole(LoginArgs.getInstance().maxTaskPerRole);
/* 24 */     if (System.getProperty("OnlineRoleNumInfo") == null) {
/* 25 */       return 0;
/*    */     }
/* 27 */     new OnlineRoleNumInfoObserver(30L);
/* 28 */     return 0;
/*    */   }
/*    */   
/*    */   public int cleanupForMerge()
/*    */   {
/* 33 */     return 0;
/*    */   }
/*    */   
/*    */   public int exit()
/*    */   {
/* 38 */     OnlineInfoFlusher.exit();
/* 39 */     return 0;
/*    */   }
/*    */   
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 44 */     return 0;
/*    */   }
/*    */   
/*    */   public void postInit()
/*    */   {
/* 49 */     if (OnlineInfoArgs.getInstance().mode.equals("zulong")) {
/* 50 */       new OnlineLogObserver();
/*    */     } else {
/* 52 */       new OnlineInfoObserver();
/*    */     }
/* 54 */     RememberSkillManager.init();
/* 55 */     LoginManager.getInstance().init();
/* 56 */     LoginAssistManager.getInstance().initObserver(LoginArgs.getInstance().checkLoginProtectSec);
/*    */   }
/*    */   
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 61 */     List<Table> tables = new ArrayList();
/* 62 */     tables.add(Roleforbid.getTable());
/* 63 */     tables.add(Userforbid.getTable());
/* 64 */     tables.add(Roletalkforbid.getTable());
/* 65 */     return tables;
/*    */   }
/*    */   
/*    */   public boolean handleMerge()
/*    */   {
/* 70 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\online\main\OnlineModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */