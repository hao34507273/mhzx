/*    */ package mzm.gsp.homeland.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.homeland.confbean.SCourtyardCfg;
/*    */ import mzm.gsp.homeland.confbean.SHomelandCfg;
/*    */ import mzm.gsp.homeland.confbean.SHomelandCfgConsts;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HomelandModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/*    */   public int cleanupForMerge()
/*    */   {
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
/*    */ 
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 31 */     HomelandRankManager.init();
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
/* 44 */     MapInterface.regisTransferZoneProxyHandler(SHomelandCfg.get(SHomelandCfgConsts.getInstance().INIT_HOMELAND_LEVEL).mapId, new RoomTransferZoneProxyHandler());
/*    */     
/*    */ 
/* 47 */     MapInterface.regisTransferZoneProxyHandler(SCourtyardCfg.get(SHomelandCfgConsts.getInstance().INIT_COURTYARD_LEVEL).mapId, new YardTransferZoneProxyHandler());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\main\HomelandModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */