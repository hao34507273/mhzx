/*    */ package mzm.gsp.visiblemonsterfight.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.SSyncGangRobberEvent;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.visiblemonsterfight.confbean.SGangRobberConst;
/*    */ import mzm.gsp.visiblemonsterfight.main.robber.RobberEnterFightHandler;
/*    */ import xbean.GangMonsterRobber;
/*    */ import xbean.GangRobber;
/*    */ 
/*    */ public class PGangRobberActivityEnd extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gangid;
/*    */   private final RobberEnterFightHandler handlder;
/*    */   private List<Integer> controllers;
/*    */   
/*    */   public PGangRobberActivityEnd(long gangid, RobberEnterFightHandler handler, List<Integer> controllers)
/*    */   {
/* 23 */     this.gangid = gangid;
/* 24 */     this.handlder = handler;
/* 25 */     this.controllers = controllers;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     lock(xtable.Gang.getTable(), java.util.Arrays.asList(new Long[] { Long.valueOf(this.gangid) }));
/*    */     
/* 33 */     long worldId = GangInterface.getGangWorldId(this.gangid);
/* 34 */     if (worldId == -1L) {
/* 35 */       return false;
/*    */     }
/* 37 */     MapInterface.unregisterMonsterFightHandler(worldId, this.handlder);
/*    */     
/*    */ 
/* 40 */     GangRobber xGangRobber = xtable.Gangrobber.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 41 */     GangMonsterRobber xGangMonsterRobber = (GangMonsterRobber)xGangRobber.getGangrobberdatas().get(Long.valueOf(this.gangid));
/* 42 */     if (xGangMonsterRobber != null) {
/* 43 */       int round = GangRobberActivity.getRound(xGangRobber.getStage());
/* 44 */       int leftNum = GangRobberActivity.getLeftMonsterNum(xGangMonsterRobber, round);
/* 45 */       if (leftNum > 0) {
/* 46 */         SSyncGangRobberEvent sSyncGangRobberEvent = new SSyncGangRobberEvent();
/* 47 */         sSyncGangRobberEvent.result = 1;
/* 48 */         OnlineManager.getInstance().sendMulti(sSyncGangRobberEvent, GangInterface.getGangMemberList(this.gangid));
/*    */         
/* 50 */         int canDeduct = SGangRobberConst.getInstance().deductLimit;
/* 51 */         if (canDeduct > 0) {
/* 52 */           int needDeduct = SGangRobberConst.getInstance().deductPerMonster * leftNum;
/* 53 */           needDeduct = Math.min(needDeduct, canDeduct);
/* 54 */           int money = GangInterface.getGangMoney(this.gangid);
/* 55 */           needDeduct = Math.min(needDeduct, money);
/* 56 */           if (needDeduct > 0) {
/* 57 */             GangInterface.costGangMoney(this.gangid, needDeduct);
/*    */           }
/*    */         }
/*    */       }
/*    */     }
/*    */     
/*    */ 
/*    */ 
/* 65 */     for (Iterator i$ = this.controllers.iterator(); i$.hasNext();) { int controllerId = ((Integer)i$.next()).intValue();
/* 66 */       mzm.gsp.map.main.ControllerInterface.collectWorldController(worldId, controllerId);
/*    */     }
/* 68 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\PGangRobberActivityEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */