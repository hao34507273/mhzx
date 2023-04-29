/*    */ package mzm.gsp.feisheng.main;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import java.util.Iterator;
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.feisheng.confbean.SFeiShengCfg;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.server.event.ServerLevelArg;
/*    */ 
/*    */ public class POnServerLevelUp extends mzm.gsp.server.event.ServerLevelUpProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 16 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 18 */       return false;
/*    */     }
/* 20 */     int currentServerLevel = ((ServerLevelArg)this.arg).currentLevel;
/* 21 */     for (Iterator i$ = SFeiShengCfg.getAll().values().iterator(); i$.hasNext();) { cfg = (SFeiShengCfg)i$.next();
/*    */       
/* 23 */       if ((FeiShengManager.isFeiShengActivitySwitchOpen(cfg.activity_cfg_id)) && 
/*    */       
/*    */ 
/*    */ 
/* 27 */         (mzm.gsp.activity.main.ActivityInterface.isActivityOpen(cfg.activity_cfg_id)) && 
/*    */         
/*    */ 
/*    */ 
/* 31 */         (currentServerLevel >= cfg.serverlevel))
/*    */       {
/*    */ 
/*    */ 
/* 35 */         mzm.gsp.map.main.ControllerInterface.triggerOrReSpawn(MapInterface.getBigWorldid(), cfg.npc_controller_id);
/* 36 */         for (i$ = OnlineManager.getInstance().getOnlineRoleidList(cfg.level, cfg.level).iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */           
/* 38 */           FeiShengOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(cfg.activity_cfg_id), new PActiveTaskGraph(roleid, cfg.activity_cfg_id));
/*    */         }
/*    */       } }
/*    */     SFeiShengCfg cfg;
/*    */     Iterator i$;
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\feisheng\main\POnServerLevelUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */