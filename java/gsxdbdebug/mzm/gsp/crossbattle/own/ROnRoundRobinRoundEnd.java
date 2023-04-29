/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.crossbattle.confbean.SCrossBattleOwnCfg;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.util.LogicRunnable;
/*    */ import xtable.Basic;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ROnRoundRobinRoundEnd
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final int activityCfgid;
/*    */   
/*    */   public ROnRoundRobinRoundEnd(int activityCfgid)
/*    */   {
/* 23 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 29 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(this.activityCfgid);
/* 30 */     if (cfg == null)
/*    */     {
/*    */ 
/* 33 */       return;
/*    */     }
/*    */     
/* 36 */     long worldid = RoundRobinWorldManager.getInstance().getWorldid(this.activityCfgid);
/* 37 */     if (worldid < 0L)
/*    */     {
/* 39 */       return;
/*    */     }
/*    */     
/* 42 */     List<Long> roleList = MapInterface.getRoleList(worldid);
/* 43 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */       
/* 45 */       new PLeaveRoundRobinMap(roleid, cfg.round_robin_out_map_cfg_id, cfg.round_robin_out_map_transfer_x, cfg.round_robin_out_map_transfer_y).call();
/*    */     }
/*    */     
/* 48 */     RoundRobinWorldManager.getInstance().destroyWorld(this.activityCfgid);
/*    */   }
/*    */   
/*    */   private class PLeaveRoundRobinMap extends LogicProcedure
/*    */   {
/*    */     private final long roleid;
/*    */     private final int mapCfgid;
/*    */     private final int x;
/*    */     private final int y;
/*    */     
/*    */     public PLeaveRoundRobinMap(long roleid, int mapCfgid, int x, int y)
/*    */     {
/* 60 */       this.roleid = roleid;
/* 61 */       this.mapCfgid = mapCfgid;
/* 62 */       this.x = x;
/* 63 */       this.y = y;
/*    */     }
/*    */     
/*    */ 
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 70 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/* 71 */       RoleStatusInterface.unsetStatus(this.roleid, 1305);
/* 72 */       CrossBattleOwnManager.unsetRoundRobinTitle(this.roleid);
/* 73 */       MapInterface.forceTransferToScene(this.roleid, MapInterface.getBigWorldid(), this.mapCfgid, this.x, this.y);
/* 74 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\ROnRoundRobinRoundEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */