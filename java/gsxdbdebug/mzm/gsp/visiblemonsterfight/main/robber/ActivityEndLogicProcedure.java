/*    */ package mzm.gsp.visiblemonsterfight.main.robber;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.SSyncGangRobberEvent;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.GangRobber;
/*    */ import xtable.Gangrobber;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ActivityEndLogicProcedure
/*    */   extends LogicProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 23 */     GangRobber xGangRobber = Gangrobber.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 24 */     if (xGangRobber == null) {
/* 25 */       return false;
/*    */     }
/* 27 */     for (Long gangId : xGangRobber.getGangrobberdatas().keySet()) {
/* 28 */       int sceneId = GangInterface.getGangMapId(gangId.longValue());
/* 29 */       if (MapInterface.getMonsterCountInMap(sceneId) > 0) {
/* 30 */         SSyncGangRobberEvent sSyncGangRobberEvent = new SSyncGangRobberEvent();
/* 31 */         sSyncGangRobberEvent.result = 1;
/* 32 */         Set<Long> memberList = GangInterface.getGangMemberList(gangId.longValue());
/* 33 */         OnlineManager.getInstance().sendMulti(sSyncGangRobberEvent, memberList);
/*    */       }
/*    */     }
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\robber\ActivityEndLogicProcedure.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */