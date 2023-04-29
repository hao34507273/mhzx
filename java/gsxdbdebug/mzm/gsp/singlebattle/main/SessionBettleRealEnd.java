/*     */ package mzm.gsp.singlebattle.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.singlebattle.confbean.SSingleBattleCfg;
/*     */ import mzm.gsp.singlebattle.confbean.STSingleBattlePlayLibCfg;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Singlebattle;
/*     */ 
/*     */ class SessionBettleRealEnd
/*     */   extends Session
/*     */ {
/*     */   private final long _battleId;
/*     */   private int _battleCfgId;
/*     */   private SSingleBattleCfg _battleCfg;
/*     */   
/*     */   SessionBettleRealEnd(long battleId, int second)
/*     */   {
/*  26 */     super(second, battleId);
/*  27 */     this._battleId = battleId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/*  36 */     BattleTaskOneByOne.getInstance().addLogicRunnable(Long.valueOf(this._battleId), new RBattleRealEnd(null));
/*     */   }
/*     */   
/*     */   private class RBattleRealEnd extends LogicRunnable
/*     */   {
/*     */     private RBattleRealEnd() {}
/*     */     
/*     */     public void process() throws Exception
/*     */     {
/*  45 */       SingleBattleGlobalInfo globalInfo = SingleBattleManager.getBattleGlobalInfo(SessionBettleRealEnd.this._battleId, false);
/*  46 */       if (globalInfo == null)
/*     */       {
/*     */ 
/*  49 */         return;
/*     */       }
/*  51 */       SessionBettleRealEnd.this._battleCfgId = globalInfo.getBattleCfgId();
/*  52 */       SessionBettleRealEnd.this._battleCfg = globalInfo.getBattleCfg();
/*     */       
/*     */ 
/*  55 */       kickOutAll();
/*     */       
/*  57 */       allPlayClearBattle();
/*     */       
/*  59 */       globalClearBattle();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     private void globalClearBattle()
/*     */     {
/*  67 */       BattleTaskOneByOne.getInstance().addLogicProcedure(Long.valueOf(SessionBettleRealEnd.this._battleId), new SessionBettleRealEnd.PBattleRealEnd(SessionBettleRealEnd.this, null));
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     private void kickOutAll()
/*     */     {
/*  75 */       new SessionBettleRealEnd.PKickOutAll(SessionBettleRealEnd.this, null).call();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     private void allPlayClearBattle()
/*     */     {
/*  83 */       BattleTaskOneByOne.getInstance().addLogicRunnable(Long.valueOf(SessionBettleRealEnd.this._battleId), new LogicRunnable()
/*     */       {
/*     */ 
/*     */         public void process()
/*     */           throws Exception
/*     */         {
/*  89 */           SessionBettleRealEnd.this.onBattleRealEnd();
/*     */         }
/*     */       });
/*     */     }
/*     */   }
/*     */   
/*     */   private class PKickOutAll
/*     */     extends LogicProcedure
/*     */   {
/*     */     private PKickOutAll() {}
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 103 */       SingleBattleGlobalInfo globalInfo = SingleBattleManager.getBattleGlobalInfo(SessionBettleRealEnd.this._battleId, true);
/* 104 */       if (globalInfo == null)
/*     */       {
/* 106 */         GameServer.logger().error(String.format("[singlebattle]PBattleRealEnd.processImp@ no xGlobalInfo! |battleId=%d", new Object[] { Long.valueOf(SessionBettleRealEnd.this._battleId) }));
/*     */         
/* 108 */         return false;
/*     */       }
/*     */       
/* 111 */       for (Iterator i$ = globalInfo.getAllMembers().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */         
/* 113 */         BattleTaskOneByOne.getInstance().addLogicRunnable(Long.valueOf(SessionBettleRealEnd.this._battleId), new RCTryLeaveBattle(roleId, SessionBettleRealEnd.this._battleId, SessionBettleRealEnd.this._battleCfgId));
/*     */       }
/*     */       
/* 116 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private class PBattleRealEnd
/*     */     extends LogicProcedure
/*     */   {
/*     */     private PBattleRealEnd() {}
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 130 */       SingleBattleGlobalInfo globalInfo = SingleBattleManager.getBattleGlobalInfo(SessionBettleRealEnd.this._battleId, true);
/* 131 */       if (globalInfo == null)
/*     */       {
/* 133 */         GameServer.logger().error(String.format("[singlebattle]PBattleRealEnd.processImp@ no xGlobalInfo! |battleId=%d", new Object[] { Long.valueOf(SessionBettleRealEnd.this._battleId) }));
/*     */         
/* 135 */         return false;
/*     */       }
/*     */       
/* 138 */       MapInterface.destroyWorld(globalInfo.getBattleWorldId());
/*     */       
/* 140 */       Singlebattle.delete(Long.valueOf(SessionBettleRealEnd.this._battleId));
/*     */       
/* 142 */       BattleTaskOneByOne.getInstance().remTaskOneByOne(Long.valueOf(SessionBettleRealEnd.this._battleId));
/*     */       
/*     */ 
/*     */ 
/* 146 */       globalInfo.clearBattleContext();
/*     */       
/* 148 */       SingleBattleMemberManager.getInstance().removeBattleData(globalInfo.getBattleCfg().battleType, SessionBettleRealEnd.this._battleId);
/*     */       
/*     */ 
/* 151 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private void onBattleRealEnd()
/*     */   {
/* 158 */     STSingleBattlePlayLibCfg playLibCfg = STSingleBattlePlayLibCfg.get(this._battleCfg.playLibId);
/* 159 */     if (playLibCfg == null)
/*     */     {
/* 161 */       GameServer.logger().error(String.format("[singleBattle]PStartSingleBattle.initPlays@ STSingleBattlePlayLibCfg is null!|battleCfgId=%d|playLibId=%d", new Object[] { Integer.valueOf(this._battleCfgId), Integer.valueOf(this._battleCfg.playLibId) }));
/*     */       
/*     */ 
/*     */ 
/* 165 */       return;
/*     */     }
/* 167 */     for (Map.Entry<Integer, Integer> entry : playLibCfg.type2cfgId.entrySet())
/*     */     {
/* 169 */       EachPlayTypeHandler handler = SingleBattleRegisterManager.getEachPlayTypeHandler(((Integer)entry.getKey()).intValue());
/* 170 */       if (handler == null)
/*     */       {
/* 172 */         GameServer.logger().error(String.format("[singleBattle]PStartSingleBattle.initPlays@ EachPlayTypeHandler is null!|battleCfgId=%d|playLibId=%d|playType=%d", new Object[] { Integer.valueOf(this._battleCfgId), Integer.valueOf(this._battleCfg.playLibId), entry.getKey() }));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 178 */         endAllPlay(this._battleId, ((Integer)entry.getValue()).intValue(), handler);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private void endAllPlay(final long battleId, int playCfgId, final EachPlayTypeHandler handler) {
/* 184 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 190 */         handler.onBattleEnd(battleId, this.val$playCfgId);
/* 191 */         return true;
/*     */       }
/*     */     }.call();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\SessionBettleRealEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */