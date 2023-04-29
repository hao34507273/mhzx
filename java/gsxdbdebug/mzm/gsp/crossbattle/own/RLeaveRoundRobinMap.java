/*    */ package mzm.gsp.crossbattle.own;
/*    */ 
/*    */ import java.util.ArrayList;
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
/*    */ public class RLeaveRoundRobinMap
/*    */   extends LogicRunnable
/*    */ {
/*    */   private final int activityCfgid;
/* 21 */   private final List<Long> roleList = new ArrayList();
/*    */   
/*    */   public RLeaveRoundRobinMap(int activityCfgid, List<Long> roleList)
/*    */   {
/* 25 */     this.activityCfgid = activityCfgid;
/* 26 */     this.roleList.addAll(roleList);
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 32 */     SCrossBattleOwnCfg cfg = SCrossBattleOwnCfg.get(this.activityCfgid);
/* 33 */     if (cfg == null)
/*    */     {
/*    */ 
/* 36 */       return;
/*    */     }
/* 38 */     for (Iterator i$ = this.roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*    */       
/* 40 */       new PLeaveRoundRobinMap(roleid, cfg.round_robin_out_map_cfg_id, cfg.round_robin_out_map_transfer_x, cfg.round_robin_out_map_transfer_y).call();
/*    */     }
/*    */   }
/*    */   
/*    */   private class PLeaveRoundRobinMap
/*    */     extends LogicProcedure
/*    */   {
/*    */     private final long roleid;
/*    */     private final int mapCfgid;
/*    */     private final int x;
/*    */     private final int y;
/*    */     
/*    */     public PLeaveRoundRobinMap(long roleid, int mapCfgid, int x, int y)
/*    */     {
/* 54 */       this.roleid = roleid;
/* 55 */       this.mapCfgid = mapCfgid;
/* 56 */       this.x = x;
/* 57 */       this.y = y;
/*    */     }
/*    */     
/*    */ 
/*    */     protected boolean processImp()
/*    */       throws Exception
/*    */     {
/* 64 */       lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/* 65 */       RoleStatusInterface.unsetStatus(this.roleid, 1305);
/* 66 */       CrossBattleOwnManager.unsetRoundRobinTitle(this.roleid);
/* 67 */       MapInterface.forceTransferToScene(this.roleid, MapInterface.getBigWorldid(), this.mapCfgid, this.x, this.y);
/* 68 */       return true;
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\own\RLeaveRoundRobinMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */