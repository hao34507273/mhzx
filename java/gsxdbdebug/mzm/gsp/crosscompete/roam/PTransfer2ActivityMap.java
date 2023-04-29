/*    */ package mzm.gsp.crosscompete.roam;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import mzm.gsp.crosscompete.main.CrossCompeteManager;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.RoamCrossCompeteFactionTmp;
/*    */ import xtable.Basic;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PTransfer2ActivityMap
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final long factionid;
/*    */   
/*    */   public PTransfer2ActivityMap(long roleid, long factionid)
/*    */   {
/* 21 */     this.roleid = roleid;
/* 22 */     this.factionid = factionid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*    */     
/*    */ 
/* 31 */     RoamCrossCompeteFactionTmp xFactionTmp = CrossCompeteRoamManager.getXRoamCrossCompeteFactionTmp(this.factionid, true);
/*    */     
/*    */ 
/* 34 */     if (xFactionTmp == null) {
/* 35 */       CrossCompeteManager.logError("PTransfer2ActivityMap.processImp@no roam faction tmp|roleid=%d|factionid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.factionid) });
/*    */       
/*    */ 
/* 38 */       return false;
/*    */     }
/*    */     
/* 41 */     long world = xFactionTmp.getWorld();
/* 42 */     int mapid = xFactionTmp.getMapid();
/*    */     
/* 44 */     if ((world < 0L) || (mapid <= 0)) {
/* 45 */       CrossCompeteManager.logError("PTransfer2ActivityMap.processImp@invalid world or mapid|roleid=%d|factionid=%d|world=%d|mapid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.factionid), Long.valueOf(world), Integer.valueOf(mapid) });
/*    */       
/*    */ 
/* 48 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 52 */     RoleStatusInterface.setStatus(this.roleid, 1502, false);
/*    */     
/*    */ 
/*    */ 
/* 56 */     MapInterface.forceTransferToScene(this.roleid, world, mapid);
/*    */     
/* 58 */     CrossCompeteManager.logInfo("PTransfer2ActivityMap.processImp@transfer|roleid=%d|factionid=%d|world=%d|mapid=%d", new Object[] { Long.valueOf(this.roleid), Long.valueOf(this.factionid), Long.valueOf(world), Integer.valueOf(mapid) });
/*    */     
/*    */ 
/*    */ 
/* 62 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crosscompete\roam\PTransfer2ActivityMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */