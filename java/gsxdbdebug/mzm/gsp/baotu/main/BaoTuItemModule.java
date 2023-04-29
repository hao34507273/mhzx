/*    */ package mzm.gsp.baotu.main;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import mzm.event.Module;
/*    */ import mzm.event.PostModuleInitListner;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activitycompensate.main.ActivityCompensateInterface;
/*    */ import mzm.gsp.awardpool.confbean.SAwardPoolMainTable;
/*    */ import mzm.gsp.awardpool.confbean.SAwardPoolSum;
/*    */ import mzm.gsp.awardpool.confbean.SControllerPoolSub;
/*    */ import mzm.gsp.item.confbean.MapID2Prop;
/*    */ import mzm.gsp.item.confbean.SItemCangBaoTuCfg;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BaoTuItemModule
/*    */   implements Module, PostModuleInitListner
/*    */ {
/* 27 */   static final Logger logger = Logger.getLogger("baotuactivity");
/*    */   
/*    */ 
/*    */   public int init(Map<String, String> envs)
/*    */   {
/*    */     try
/*    */     {
/* 34 */       ActivityInterface.registerActivityByLogicType(2, new BatotuActivityInit());
/*    */     }
/*    */     catch (Exception e)
/*    */     {
/* 38 */       throw new RuntimeException(e);
/*    */     }
/*    */     
/* 41 */     ActivityCompensateInterface.registerCompensateHandler(2, new BaoTuCompensateHandler());
/*    */     
/* 43 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int exit()
/*    */   {
/* 49 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int cleanupForMerge()
/*    */   {
/* 55 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */   public int loadconf(Map<String, String> envs, int reloadcount)
/*    */   {
/* 61 */     return 0;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void postInit()
/*    */   {
/* 68 */     for (Iterator i$ = SItemCangBaoTuCfg.getAllSelf().values().iterator(); i$.hasNext();) { cfg = (SItemCangBaoTuCfg)i$.next();
/*    */       
/* 70 */       for (MapID2Prop m2p : cfg.mapIdProp)
/*    */       {
/* 72 */         if (!MapInterface.isMapHaveRandomRegion(m2p.mapId))
/*    */         {
/* 74 */           throw new RuntimeException(String.format("baoTu item %d ref map id %d must have random area", new Object[] { Integer.valueOf(cfg.id), Integer.valueOf(m2p.mapId) }));
/*    */         }
/*    */       }
/*    */       
/*    */ 
/* 79 */       for (SAwardPoolMainTable sAwardPoolMainTable : SAwardPoolMainTable.getAll().values())
/*    */       {
/* 81 */         if (sAwardPoolMainTable.poolTypeId == cfg.awardPoolId)
/*    */         {
/* 83 */           sAwardPoolSum = SAwardPoolSum.get(sAwardPoolMainTable.awardPoolSumId);
/* 84 */           for (SControllerPoolSub sub : SControllerPoolSub.getAll().values())
/*    */           {
/* 86 */             if (sub.awardTypeId == sAwardPoolSum.awardTypeId)
/*    */             {
/*    */ 
/* 89 */               ControllerInterface.setControllerMaxCount(MapInterface.getCenterWorldid(), sub.controllerId, 1); } }
/*    */         }
/*    */       }
/*    */     }
/*    */     SItemCangBaoTuCfg cfg;
/*    */     SAwardPoolSum sAwardPoolSum;
/* 95 */     MapInterface.registerMonsterFightHandler(MapInterface.getCenterWorldid(), new BaoTuFightHandler());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baotu\main\BaoTuItemModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */