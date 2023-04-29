/*    */ package mzm.gsp.countdown.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.countdown.confbean.SCountDownCfg;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CountDownModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int cleanupForMerge()
/*    */   {
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
/*    */   public int init(Map<String, String> envs)
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
/*    */ 
/*    */   public void postInit()
/*    */   {
/* 44 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 46 */       return;
/*    */     }
/* 48 */     for (Iterator i$ = SCountDownCfg.getAll().keySet().iterator(); i$.hasNext();) { int cfgid = ((Integer)i$.next()).intValue();
/*    */       
/* 50 */       new PInitOnGameServerStart(cfgid).call();
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\countdown\main\CountDownModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */