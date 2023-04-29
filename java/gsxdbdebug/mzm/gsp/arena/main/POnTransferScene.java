/*    */ package mzm.gsp.arena.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.arena.SArenaTitle;
/*    */ import mzm.gsp.arena.confbean.SArenaConsts;
/*    */ import mzm.gsp.map.event.MapTransferArg;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.ArenaScore;
/*    */ import xbean.ArenaTmp;
/*    */ import xtable.Basic;
/*    */ 
/*    */ public class POnTransferScene extends mzm.gsp.map.event.PlayerTransferSceneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 19 */     ArenaTmp xArenaTmp = ArenaManager.getXArenaTmp(false);
/* 20 */     if (xArenaTmp == null) {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     long activityWorld = xArenaTmp.getWorld();
/* 25 */     if (activityWorld < 0L) {
/* 26 */       return false;
/*    */     }
/*    */     
/* 29 */     if ((((MapTransferArg)this.arg).oldWorldId != activityWorld) && (((MapTransferArg)this.arg).newWorldId == activityWorld))
/*    */     {
/*    */ 
/* 32 */       lock(Basic.getTable(), ((MapTransferArg)this.arg).roleList);
/*    */       
/* 34 */       if (!RoleStatusInterface.setStatus(((MapTransferArg)this.arg).roleList, 8, false))
/*    */       {
/* 36 */         MapInterface.transferToScene(((Long)((MapTransferArg)this.arg).roleList.get(0)).longValue(), SArenaConsts.getInstance().LeaveMap);
/* 37 */         return false;
/*    */       }
/*    */       
/*    */ 
/* 41 */       ArenaManager.broadcastStage(((MapTransferArg)this.arg).roleList);
/*    */       
/* 43 */       for (Iterator i$ = ((MapTransferArg)this.arg).roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 44 */         ArenaScore xScore = xtable.Arenascore.select(Long.valueOf(r));
/*    */         
/* 46 */         ArenaManager.syncRoleScore(r, xScore);
/*    */         
/* 48 */         ArenaManager.syncGetWinTimesAward(r, xScore);
/*    */         
/* 50 */         SArenaTitle mapTitle = new SArenaTitle(xScore.getCamp());
/*    */         
/*    */ 
/* 53 */         MapInterface.setModelProtocol(r, mapTitle);
/*    */       }
/*    */       
/*    */ 
/* 57 */       ArenaManager.broadcastMatchCountDown(((MapTransferArg)this.arg).roleList);
/*    */       
/* 59 */       if (ArenaManager.logger.isDebugEnabled()) {
/* 60 */         ArenaManager.logger.debug(((MapTransferArg)this.arg).roleList + "进入天下会武地图！");
/*    */       }
/*    */     }
/* 63 */     else if ((((MapTransferArg)this.arg).oldWorldId == activityWorld) && (((MapTransferArg)this.arg).newWorldId != activityWorld))
/*    */     {
/*    */ 
/* 66 */       lock(Basic.getTable(), ((MapTransferArg)this.arg).roleList);
/*    */       
/* 68 */       RoleStatusInterface.unsetStatus(((MapTransferArg)this.arg).roleList, 8);
/*    */       
/*    */ 
/* 71 */       for (Iterator i$ = ((MapTransferArg)this.arg).roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/* 72 */         MapInterface.unSetModelProtocol(r, 12596752);
/*    */       }
/*    */       
/* 75 */       if (ArenaManager.logger.isDebugEnabled()) {
/* 76 */         ArenaManager.logger.debug(((MapTransferArg)this.arg).roleList + "离开天下会武活动地图！");
/*    */       }
/*    */     }
/*    */     
/* 80 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\arena\main\POnTransferScene.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */