/*    */ package mzm.gsp.feisheng.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.feisheng.confbean.FeiShengModuleidCfg;
/*    */ import mzm.gsp.feisheng.confbean.SFeiShengCfg;
/*    */ import mzm.gsp.map.main.ControllerInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.open.event.OpenChangeComplexArg;
/*    */ import mzm.gsp.open.event.OpenChangeProcedure;
/*    */ import mzm.gsp.server.main.ServerInterface;
/*    */ 
/*    */ public class POnOpenChange
/*    */   extends OpenChangeProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     if (!FeiShengManager.postInitFlag)
/*    */     {
/* 24 */       return false;
/*    */     }
/* 26 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 28 */       return false;
/*    */     }
/* 30 */     boolean isOpen = ((OpenChangeComplexArg)this.arg).isOpen();
/* 31 */     int type = ((OpenChangeComplexArg)this.arg).getType();
/* 32 */     if (FeiShengModuleidCfg.get(type) == null)
/*    */     {
/* 34 */       return false;
/*    */     }
/*    */     
/* 37 */     SFeiShengCfg cfg = SFeiShengCfg.get(FeiShengModuleidCfg.get(type).activity_cfg_id);
/* 38 */     if (cfg == null)
/*    */     {
/* 40 */       return false; }
/*    */     Iterator i$;
/* 42 */     Iterator i$; if (isOpen)
/*    */     {
/* 44 */       if (ServerInterface.getCurrentServerLevel() < cfg.serverlevel)
/*    */       {
/* 46 */         return false;
/*    */       }
/* 48 */       if (!ActivityInterface.isActivityOpen(cfg.activity_cfg_id))
/*    */       {
/* 50 */         return false;
/*    */       }
/* 52 */       ControllerInterface.triggerOrReSpawn(MapInterface.getBigWorldid(), cfg.npc_controller_id);
/* 53 */       for (i$ = OnlineManager.getInstance().getOnlineRoleidList(cfg.level, cfg.level).iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */         
/* 55 */         FeiShengOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(cfg.activity_cfg_id), new PActiveTaskGraph(roleid, cfg.activity_cfg_id));
/*    */       }
/*    */       
/*    */     }
/*    */     else
/*    */     {
/* 61 */       if (ServerInterface.getCurrentServerLevel() < cfg.serverlevel)
/*    */       {
/* 63 */         return false;
/*    */       }
/* 65 */       if (!ActivityInterface.isActivityOpen(cfg.activity_cfg_id))
/*    */       {
/* 67 */         return false;
/*    */       }
/* 69 */       ControllerInterface.collectController(cfg.npc_controller_id);
/* 70 */       for (i$ = OnlineManager.getInstance().getOnlineRoleidList(cfg.level, cfg.level).iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */         
/* 72 */         FeiShengOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(cfg.activity_cfg_id), new PCloseTaskGraph(roleid, cfg.activity_cfg_id));
/*    */       }
/*    */     }
/*    */     
/* 76 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\main\POnOpenChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */