/*     */ package mzm.gsp.cake.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.event.Module;
/*     */ import mzm.event.PostModuleInitListner;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.MergeMain;
/*     */ import mzm.gsp.MergeModule;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity4.confbean.SCakeActivityCfg;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Table;
/*     */ import xtable.Factioncake;
/*     */ import xtable.Globalcake;
/*     */ import xtable.Role2cakeinfo;
/*     */ 
/*     */ public class CakeModule
/*     */   implements Module, MergeModule, PostModuleInitListner
/*     */ {
/*     */   public void postInit()
/*     */   {
/*  28 */     for (SCakeActivityCfg cfg : SCakeActivityCfg.getAll().values())
/*     */     {
/*  30 */       final int activityId = cfg.activityId;
/*  31 */       if (!MapInterface.regisMapItemGatherHandler(cfg.collectionCheckId, new CakeGatherItemHandler(cfg.activityId)))
/*     */       {
/*  33 */         throw new RuntimeException(String.format("[cake]CakeModule.postInit@regisMapItemGatherHandler err!|checkType=%d|activityId=%d", new Object[] { Integer.valueOf(cfg.collectionCheckId), Integer.valueOf(cfg.activityId) }));
/*     */       }
/*     */       
/*     */ 
/*  37 */       new LogicProcedure()
/*     */       {
/*     */ 
/*     */         protected boolean processImp()
/*     */           throws Exception
/*     */         {
/*  43 */           if (DateTimeUtils.getCurrTimeInMillis() < ActivityInterface.getActivityEndTime(activityId))
/*     */           {
/*  45 */             return false;
/*     */           }
/*  47 */           CakeManager.globalOnActivityEnd(activityId);
/*  48 */           return true;
/*     */         }
/*     */       }.execute();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Table> getHandleTables()
/*     */   {
/*  58 */     List<Table> tables = new ArrayList();
/*  59 */     tables.add(Role2cakeinfo.getTable());
/*  60 */     tables.add(Factioncake.getTable());
/*  61 */     tables.add(Globalcake.getTable());
/*  62 */     return tables;
/*     */   }
/*     */   
/*     */ 
/*     */   public boolean handleMerge()
/*     */   {
/*  68 */     boolean res = true;
/*  69 */     if (!new handFireworkMerge(null).call())
/*     */     {
/*  71 */       GameServer.logger().error(String.format("[cake]CakeModule.handleMerge@ Merge Globalcake fail!", new Object[0]));
/*  72 */       res = false;
/*     */     }
/*  74 */     return res;
/*     */   }
/*     */   
/*     */   private class handFireworkMerge extends LogicProcedure
/*     */   {
/*     */     private handFireworkMerge() {}
/*     */     
/*     */     protected boolean processImp() throws Exception
/*     */     {
/*  83 */       long mainKey = MergeMain.getMainZoneid();
/*  84 */       long viceKey = MergeMain.getViceZoneid();
/*  85 */       lock(Globalcake.getTable(), Arrays.asList(new Long[] { Long.valueOf(mainKey), Long.valueOf(viceKey) }));
/*     */       
/*  87 */       Globalcake.remove(Long.valueOf(viceKey));
/*  88 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int init(Map<String, String> envs)
/*     */   {
/*  96 */     ActivityInterface.registerActivityByLogicType(137, new CakeActivityHandler(), false);
/*     */     
/*  98 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int exit()
/*     */   {
/* 105 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int cleanupForMerge()
/*     */   {
/* 112 */     return 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int loadconf(Map<String, String> envs, int reloadcount)
/*     */   {
/* 119 */     return 0;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\main\CakeModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */