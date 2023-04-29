/*    */ package mzm.gsp.firework.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.MergeMain;
/*    */ import mzm.gsp.MergeModule;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity3.confbean.SFireworkCfg;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Table;
/*    */ import xtable.Globalfirework;
/*    */ import xtable.Role2firedata;
/*    */ 
/*    */ public class FireworkModule
/*    */   implements Module, MergeModule, PostModuleInitListner
/*    */ {
/*    */   public List<Table> getHandleTables()
/*    */   {
/* 26 */     List<Table> tables = new ArrayList();
/* 27 */     tables.add(Globalfirework.getTable());
/* 28 */     tables.add(Role2firedata.getTable());
/* 29 */     return tables;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean handleMerge()
/*    */   {
/* 35 */     boolean res = true;
/* 36 */     if (!new handFireworkMerge(null).call())
/*    */     {
/* 38 */       GameServer.logger().error(String.format("[firework]FireworkModule.handleMerge@ Merge Globalfirework fail!", new Object[0]));
/* 39 */       res = false;
/*    */     }
/* 41 */     return res;
/*    */   }
/*    */   
/*    */   private class handFireworkMerge extends LogicProcedure
/*    */   {
/*    */     private handFireworkMerge() {}
/*    */     
/*    */     protected boolean processImp() throws Exception
/*    */     {
/* 50 */       long mainKey = MergeMain.getMainZoneid();
/* 51 */       long viceKey = MergeMain.getViceZoneid();
/* 52 */       lock(Globalfirework.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*    */       
/* 54 */       Globalfirework.remove(Long.valueOf(viceKey));
/* 55 */       return true;
/*    */     }
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public int init(Map<String, String> envs)
/*    */   {
/* 63 */     ActivityInterface.registerActivityByLogicType(131, new FireworkActivityHandler(), false);
/* 64 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 70 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 76 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 82 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void postInit()
/*    */   {
/* 89 */     for (SFireworkCfg cfg : SFireworkCfg.getAll().values())
/*    */     {
/* 91 */       if (!MapInterface.regisMapItemGatherHandler(cfg.checkId, new FireWorkGatherItemHandler(cfg.activityId)))
/*    */       {
/* 93 */         throw new RuntimeException(String.format("[firework]FireworkModule.postInit@regisMapItemGatherHandler err!|checkType=%d|activityId=%d", new Object[] { Integer.valueOf(cfg.checkId), Integer.valueOf(cfg.activityId) }));
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\firework\main\FireworkModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */