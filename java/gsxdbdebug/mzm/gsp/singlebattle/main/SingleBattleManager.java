/*     */ package mzm.gsp.singlebattle.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.map.main.MapCallback;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.map.main.scene.Position;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.singlebattle.RolePosition;
/*     */ import mzm.gsp.singlebattle.SSinglePositionBro;
/*     */ import mzm.gsp.singlebattle.SSynAllPositionInfo;
/*     */ import mzm.gsp.singlebattle.SyncSingleBattalAppellation;
/*     */ import mzm.gsp.singlebattle.confbean.SSingleBattleCfg;
/*     */ import mzm.gsp.singlebattle.confbean.STSingleBattlePlayLibCfg;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.LogicRunnable;
/*     */ import mzm.gsp.util.TaskOneByOne;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.RoleSingleBattle;
/*     */ import xtable.Role2singlebattle;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SingleBattleManager
/*     */ {
/*     */   static final String ENCODING = "UTF-8";
/*     */   
/*     */   static SingleBattleGlobalInfo getBattleGlobalInfo(long battleId, boolean remainSingleBattleLock)
/*     */   {
/*  43 */     SingleBattleGlobalInfo info = new SingleBattleGlobalInfo(battleId, remainSingleBattleLock);
/*  44 */     return info.getxBattleData() == null ? null : info;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onRoleJoinBattle(SingleBattleGlobalInfo globalInfo, long roleId, final int campId)
/*     */   {
/*  58 */     long battleId = globalInfo.getBattleId();
/*     */     
/*  60 */     globalInfo.synBattleInfo(roleId);
/*     */     
/*  62 */     globalInfo.roleTotalInfoBro(roleId, campId);
/*     */     
/*  64 */     globalInfo.roleJoinBattleBro(roleId);
/*     */     
/*  66 */     globalInfo.setRoleState(roleId, campId, 1);
/*     */     
/*  68 */     if (MapInterface.getRoleWorldInstanceId(roleId) != globalInfo.getBattleWorldId())
/*     */     {
/*  70 */       globalInfo.transferToBattle(roleId, campId, new MapCallback()
/*     */       {
/*     */ 
/*     */         public boolean onResult(Boolean result)
/*     */         {
/*     */ 
/*  76 */           if (result.booleanValue())
/*     */           {
/*  78 */             GameServer.logger().info(String.format("[singlebattle]SingleBattleManager.onRoleJoinBattle@ transfer to battle suc! |battleId=%d|roleId=%d|campId=%d", new Object[] { Long.valueOf(this.val$battleId), Long.valueOf(campId), Integer.valueOf(this.val$campId) }));
/*     */             
/*     */ 
/*     */ 
/*  82 */             SingleBattleManager.initRoleBattleMapData(campId, this.val$battleId);
/*     */           }
/*  84 */           return true;
/*     */         }
/*     */         
/*     */ 
/*     */         public boolean isCallInProcedure()
/*     */         {
/*  90 */           return true;
/*     */         }
/*     */       });
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void initRoleBattleMapData(long roleId, long battleId)
/*     */   {
/* 105 */     setBattleTitle(roleId);
/*     */     
/* 107 */     synBattlePositionInfo(roleId, battleId);
/*     */     
/* 109 */     MapInterface.setBroadcastPosInSceneStatus(roleId, true, null);
/*     */     
/* 111 */     setRoleMoveLimitState(roleId, battleId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void clearRoleMapData(long roleId)
/*     */   {
/* 122 */     MapInterface.setBroadcastPosInSceneStatus(roleId, false, null);
/*     */     
/* 124 */     MapInterface.setLimitPolygonMovementStatus(roleId, false, null);
/*     */   }
/*     */   
/*     */ 
/*     */   static void synBattlePositionInfo(long roleId, long battleId)
/*     */   {
/* 130 */     synRolesPosition(battleId, roleId);
/*     */     
/* 132 */     broRolePosition(battleId, roleId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void synRolesPosition(long battleId, long roleId)
/*     */   {
/* 143 */     SingleBattleGlobalInfo globalInfo = getBattleGlobalInfo(battleId, true);
/* 144 */     if (globalInfo == null)
/*     */     {
/* 146 */       return;
/*     */     }
/* 148 */     MapInterface.getRolesPosition(globalInfo.getAllMembers(), new MapCallback()
/*     */     {
/*     */ 
/*     */       public boolean isCallInProcedure()
/*     */       {
/*     */ 
/* 154 */         return true;
/*     */       }
/*     */       
/*     */ 
/*     */       public boolean onResult(Map<Long, Position> result)
/*     */       {
/* 160 */         if ((result == null) || (result.isEmpty()))
/*     */         {
/* 162 */           return false;
/*     */         }
/* 164 */         SingleBattleGlobalInfo globalInfo = SingleBattleManager.getBattleGlobalInfo(this.val$battleId, true);
/* 165 */         if (globalInfo == null)
/*     */         {
/* 167 */           return false;
/*     */         }
/* 169 */         Set<Long> members = globalInfo.getAllMembers();
/* 170 */         if ((members == null) || (members.size() == 0))
/*     */         {
/* 172 */           return false;
/*     */         }
/* 174 */         SSynAllPositionInfo syn = new SSynAllPositionInfo();
/* 175 */         for (Map.Entry<Long, Position> entry : result.entrySet())
/*     */         {
/* 177 */           if (members.contains(entry.getKey()))
/*     */           {
/*     */ 
/*     */ 
/* 181 */             Position position = (Position)entry.getValue();
/* 182 */             syn.positioninfos.put(entry.getKey(), new RolePosition(position.getX(), position.getY()));
/*     */           }
/*     */         }
/* 185 */         OnlineManager.getInstance().send(this.val$roleId, syn);
/* 186 */         return true;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */   static void broRolePosition(long battleId, long roleId)
/*     */   {
/* 194 */     SingleBattleGlobalInfo globalInfo = getBattleGlobalInfo(battleId, true);
/* 195 */     if (globalInfo == null)
/*     */     {
/* 197 */       return;
/*     */     }
/* 199 */     MapInterface.getRolePosition(roleId, new MapCallback()
/*     */     {
/*     */ 
/*     */       public boolean isCallInProcedure()
/*     */       {
/*     */ 
/* 205 */         return true;
/*     */       }
/*     */       
/*     */ 
/*     */       public boolean onResult(Map<Long, Position> result)
/*     */       {
/* 211 */         Position position = (Position)result.get(Long.valueOf(this.val$roleId));
/* 212 */         if (position == null)
/*     */         {
/* 214 */           return false;
/*     */         }
/* 216 */         SingleBattleGlobalInfo globalInfo = SingleBattleManager.getBattleGlobalInfo(this.val$battleId, true);
/* 217 */         if (globalInfo == null)
/*     */         {
/* 219 */           return false;
/*     */         }
/* 221 */         Set<Long> members = globalInfo.getAllMembers();
/* 222 */         if ((members == null) || (members.size() == 0))
/*     */         {
/* 224 */           return false;
/*     */         }
/* 226 */         if (!members.contains(Long.valueOf(this.val$roleId)))
/*     */         {
/* 228 */           return false;
/*     */         }
/* 230 */         globalInfo.battleBro(new SSinglePositionBro(this.val$roleId, new RolePosition(position.getX(), position.getY())), false);
/* 231 */         return true;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void setRoleMoveLimitState(long roleId, long battleId)
/*     */   {
/* 246 */     if (SingleBattleInterface.getStage(battleId, false) != 1)
/*     */     {
/* 248 */       return;
/*     */     }
/*     */     
/* 251 */     MapInterface.setLimitPolygonMovementStatus(roleId, true, new MapCallback()
/*     */     {
/*     */ 
/*     */       public boolean onResult(Boolean result)
/*     */       {
/*     */ 
/* 257 */         if (!result.booleanValue())
/*     */         {
/* 259 */           GameServer.logger().error(String.format("[singlebattle]SingleBattleManager.setRoleMoveLimitState@ setLimitPolygonMovementStatus failed! |battleId=%d|roleId=%d", new Object[] { Long.valueOf(this.val$battleId), Long.valueOf(this.val$roleId) }));
/*     */           
/*     */ 
/*     */ 
/* 263 */           return false;
/*     */         }
/*     */         
/* 266 */         if (SingleBattleInterface.getStage(this.val$battleId, true) != 1)
/*     */         {
/*     */ 
/* 269 */           MapInterface.setLimitPolygonMovementStatus(this.val$roleId, false, null);
/*     */         }
/* 271 */         return true;
/*     */       }
/*     */       
/*     */ 
/*     */       public boolean isCallInProcedure()
/*     */       {
/* 277 */         return true;
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getPrepareInterval(SSingleBattleCfg _battleCfg)
/*     */   {
/* 290 */     return _battleCfg.prepareDuration;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getBattleEndInterval(SSingleBattleCfg _battleCfg)
/*     */   {
/* 301 */     return getPrepareInterval(_battleCfg) + _battleCfg.matchDuration;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getAfterMatchInterval(SSingleBattleCfg _battleCfg)
/*     */   {
/* 312 */     return _battleCfg.waitCleanDuration + _battleCfg.cleanDuration;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getBattleWaitCleanInterval(SSingleBattleCfg _battleCfg)
/*     */   {
/* 323 */     return _battleCfg.waitCleanDuration;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getBattleCleanInterval(SSingleBattleCfg _battleCfg)
/*     */   {
/* 334 */     return _battleCfg.cleanDuration;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getBattleOverInterval(SSingleBattleCfg _battleCfg)
/*     */   {
/* 345 */     return getBattleEndInterval(_battleCfg) + getBattleWaitCleanInterval(_battleCfg) + getBattleCleanInterval(_battleCfg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getBattleSynInfoInterval(SSingleBattleCfg _battleCfg)
/*     */   {
/* 356 */     return _battleCfg.synchroInterval;
/*     */   }
/*     */   
/*     */   static void setBattleTitle(long roleId)
/*     */   {
/* 361 */     SyncSingleBattalAppellation title = new SyncSingleBattalAppellation();
/* 362 */     MapInterface.setModelProtocol(roleId, title);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean removeSingleBattleAllStatus(long roleId)
/*     */   {
/* 376 */     return RoleStatusInterface.unsetStatus(roleId, getAllSingleBattleStatus());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean addCampSource(long battleId, int campId, int value)
/*     */   {
/* 388 */     Map<Integer, Integer> campId2AddValue = new HashMap();
/* 389 */     campId2AddValue.put(Integer.valueOf(campId), Integer.valueOf(value));
/* 390 */     return addCampSource(battleId, campId2AddValue);
/*     */   }
/*     */   
/*     */   static boolean addCampSource(long battleId, Map<Integer, Integer> campId2AddValue)
/*     */   {
/* 395 */     if ((campId2AddValue == null) || (campId2AddValue.size() == 0))
/*     */     {
/* 397 */       return false;
/*     */     }
/*     */     
/* 400 */     SingleBattleGlobalInfo globalInfo = getBattleGlobalInfo(battleId, true);
/* 401 */     if (globalInfo == null)
/*     */     {
/* 403 */       GameServer.logger().error(String.format("[singlebattle]SingleBattleManager.addCampSource@ no xGlobalInfo! |battleId=%d|campId2AddValue=%s", new Object[] { Long.valueOf(battleId), campId2AddValue.toString() }));
/*     */       
/*     */ 
/*     */ 
/* 407 */       return false;
/*     */     }
/* 409 */     if (globalInfo.getStage() == 4)
/*     */     {
/* 411 */       GameServer.logger().error(String.format("[singlebattle]SingleBattleManager.addCampSource@ clean up! |battleId=%d|campId2AddValue=%s", new Object[] { Long.valueOf(battleId), campId2AddValue.toString() }));
/*     */       
/*     */ 
/* 414 */       return false;
/*     */     }
/* 416 */     for (Map.Entry<Integer, Integer> entry : campId2AddValue.entrySet())
/*     */     {
/* 418 */       if (!globalInfo.addCampSource(((Integer)entry.getKey()).intValue(), ((Integer)entry.getValue()).intValue()))
/*     */       {
/* 420 */         GameServer.logger().error(String.format("[singlebattle]SingleBattleManager.addCampSource@ add each source err! |battleId=%d|campId=%d|value=%d|campId2AddValue=%s", new Object[] { Long.valueOf(battleId), entry.getKey(), entry.getValue(), campId2AddValue.toString() }));
/*     */         
/*     */ 
/*     */ 
/* 424 */         return false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 429 */     if (globalInfo.needAdvanceEndMatch())
/*     */     {
/* 431 */       GameServer.logger().info(String.format("[singlebattle]SingleBattleManager.addCampSource@ advance end match for diff score!|battleId=%d", new Object[] { Long.valueOf(battleId) }));
/*     */       
/*     */ 
/*     */ 
/* 435 */       advanceEndMatch(battleId, globalInfo.getBattleCfg(), 2);
/*     */     }
/*     */     
/* 438 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean handRolePoint(long battleId, int campId, long roleId, int value, boolean add)
/*     */   {
/* 452 */     SingleBattleGlobalInfo globalInfo = getBattleGlobalInfo(battleId, true);
/* 453 */     if (globalInfo == null)
/*     */     {
/* 455 */       GameServer.logger().error(String.format("[singlebattle]SingleBattleManager.handRolePoint@ no xGlobalInfo! |battleId=%d|campId=%d|roleId=%d|value=%d|", new Object[] { Long.valueOf(battleId), Integer.valueOf(campId), Long.valueOf(roleId), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*     */ 
/* 459 */       return false;
/*     */     }
/* 461 */     if (globalInfo.getStage() == 4)
/*     */     {
/* 463 */       GameServer.logger().info(String.format("[singlebattle]SingleBattleManager.handRolePoint@ clean up! |battleId=%d|campId=%d|roleId=%d|value=%d|", new Object[] { Long.valueOf(battleId), Integer.valueOf(campId), Long.valueOf(roleId), Integer.valueOf(value) }));
/*     */       
/*     */ 
/*     */ 
/* 467 */       return false;
/*     */     }
/* 469 */     boolean res = true;
/*     */     
/* 471 */     if (add)
/*     */     {
/* 473 */       res = globalInfo.addRolePoint(campId, roleId, value);
/*     */     }
/*     */     else
/*     */     {
/* 477 */       res = globalInfo.cutRolePoint(campId, roleId, value);
/*     */     }
/* 479 */     if (!res)
/*     */     {
/* 481 */       GameServer.logger().error(String.format("[singlebattle]SingleBattleManager.handRolePoint@ add source err! |battleId=%d|campId=%d|roleId=%d|value=%d|add=%s", new Object[] { Long.valueOf(battleId), Integer.valueOf(campId), Long.valueOf(roleId), Integer.valueOf(value), String.valueOf(add) }));
/*     */       
/*     */ 
/*     */ 
/* 485 */       return false;
/*     */     }
/* 487 */     return true;
/*     */   }
/*     */   
/*     */   static void onStageChange(final long battleId, SSingleBattleCfg cfg, final int stage)
/*     */   {
/* 492 */     STSingleBattlePlayLibCfg playLibCfg = STSingleBattlePlayLibCfg.get(cfg.playLibId);
/* 493 */     if (playLibCfg == null)
/*     */     {
/* 495 */       GameServer.logger().error(String.format("[singleBattle]PCTryFight.onStageChange@ STSingleBattlePlayLibCfg is null!|battleCfgId=%d|playLibId=%d", new Object[] { Integer.valueOf(cfg.id), Integer.valueOf(cfg.playLibId) }));
/*     */       
/*     */ 
/*     */ 
/* 499 */       return;
/*     */     }
/* 501 */     for (Map.Entry<Integer, Integer> entry : playLibCfg.type2cfgId.entrySet())
/*     */     {
/* 503 */       final EachPlayTypeHandler handler = SingleBattleRegisterManager.getEachPlayTypeHandler(((Integer)entry.getKey()).intValue());
/* 504 */       if (handler == null)
/*     */       {
/* 506 */         GameServer.logger().error(String.format("[singleBattle]PCTryFight.onStageChange@ EachPlayTypeHandler is null!|battleCfgId=%d|playLibId=%d|playType=%d", new Object[] { Integer.valueOf(cfg.id), Integer.valueOf(cfg.playLibId), entry.getKey() }));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 512 */         BattleTaskOneByOne.getInstance().getTaskOneByOne(Long.valueOf(battleId)).add(new LogicProcedure()
/*     */         {
/*     */ 
/*     */           protected boolean processImp()
/*     */             throws Exception
/*     */           {
/* 518 */             int playCfgId = ((Integer)this.val$entry.getValue()).intValue();
/* 519 */             switch (stage)
/*     */             {
/*     */             case 2: 
/* 522 */               handler.onMatchStart(battleId, playCfgId);
/* 523 */               break;
/*     */             case 3: 
/* 525 */               handler.onMatchEnd(battleId, playCfgId);
/* 526 */               break;
/*     */             
/*     */             case 4: 
/* 529 */               handler.onStartClean(battleId, playCfgId);
/* 530 */               break;
/*     */             
/*     */             default: 
/* 533 */               return false;
/*     */             }
/* 535 */             return true;
/*     */           }
/*     */         });
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   static void onPlayJoinBattle(final long battleId, SSingleBattleCfg cfg, final long roleId) {
/* 543 */     STSingleBattlePlayLibCfg playLibCfg = STSingleBattlePlayLibCfg.get(cfg.playLibId);
/* 544 */     if (playLibCfg == null)
/*     */     {
/* 546 */       GameServer.logger().error(String.format("[singleBattle]PCTryFight.onStageChange@ STSingleBattlePlayLibCfg is null!|battleCfgId=%d|playLibId=%d", new Object[] { Integer.valueOf(cfg.id), Integer.valueOf(cfg.playLibId) }));
/*     */       
/*     */ 
/*     */ 
/* 550 */       return;
/*     */     }
/* 552 */     for (Map.Entry<Integer, Integer> entry : playLibCfg.type2cfgId.entrySet())
/*     */     {
/* 554 */       EachPlayTypeHandler handler = SingleBattleRegisterManager.getEachPlayTypeHandler(((Integer)entry.getKey()).intValue());
/* 555 */       if (handler == null)
/*     */       {
/* 557 */         GameServer.logger().error(String.format("[singleBattle]PCTryFight.onStageChange@ EachPlayTypeHandler is null!|battleCfgId=%d|playLibId=%d|playType=%d", new Object[] { Integer.valueOf(cfg.id), Integer.valueOf(cfg.playLibId), entry.getKey() }));
/*     */ 
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 564 */         new LogicProcedure()
/*     */         {
/*     */ 
/*     */           protected boolean processImp()
/*     */             throws Exception
/*     */           {
/* 570 */             this.val$handler.onRoleJoinBattle(battleId, ((Integer)roleId.getValue()).intValue(), this.val$roleId);
/* 571 */             return true;
/*     */           }
/*     */         }.call();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void advanceEndMatch(long _battleId, final SSingleBattleCfg _battleCfg, int reason)
/*     */   {
/* 585 */     BattleTaskOneByOne.getInstance().addLogicRunnable(Long.valueOf(_battleId), new LogicRunnable()
/*     */     {
/*     */ 
/*     */       public void process()
/*     */         throws Exception
/*     */       {
/* 591 */         if (new PBattleWaitClean(this.val$_battleId, _battleCfg).call())
/*     */         {
/*     */ 
/* 594 */           new SingleBattleManager.ResetSessions(this.val$_battleId, this.val$_battleCfg).call();
/*     */         }
/*     */       }
/*     */     });
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void activeLevelBattle(long roleId)
/*     */   {
/* 610 */     RoleSingleBattle xRoleBattle = Role2singlebattle.select(Long.valueOf(roleId));
/* 611 */     if (xRoleBattle == null)
/*     */     {
/* 613 */       GameServer.logger().error(String.format("[singlebattle]SingleBattleManager.levelBattle@ no RoleSingleBattle! |roleId=%d", new Object[] { Long.valueOf(roleId) }));
/*     */       
/* 615 */       return;
/*     */     }
/* 617 */     BattleTaskOneByOne.getInstance().addLogicRunnable(Long.valueOf(xRoleBattle.getBattleid()), new RCTryLeaveBattle(roleId, xRoleBattle.getBattleid(), xRoleBattle.getBattlecfgid()));
/*     */   }
/*     */   
/*     */   private static class ResetSessions
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long _battleId;
/*     */     private final SSingleBattleCfg _battleCfg;
/*     */     
/*     */     ResetSessions(long _battleId, SSingleBattleCfg _battleCfg)
/*     */     {
/* 628 */       this._battleId = _battleId;
/* 629 */       this._battleCfg = _battleCfg;
/*     */     }
/*     */     
/*     */ 
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 636 */       SingleBattleGlobalInfo globalInfo = SingleBattleManager.getBattleGlobalInfo(this._battleId, true);
/* 637 */       if (globalInfo == null)
/*     */       {
/* 639 */         GameServer.logger().error(String.format("[singlebattle]ResetSessions.processImp@ no xGlobalInfo! |battleId=%d", new Object[] { Long.valueOf(this._battleId) }));
/*     */         
/* 641 */         return false;
/*     */       }
/*     */       
/* 644 */       globalInfo.removeAllBattleSesssion();
/*     */       
/* 646 */       globalInfo.addSessionBattleEnd(new SessionBettleRealEnd(this._battleId, SingleBattleManager.getAfterMatchInterval(this._battleCfg)).getSessionId());
/* 647 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static Set<Integer> getAllSingleBattleStatus()
/*     */   {
/* 659 */     Set<Integer> allStatus = new HashSet();
/* 660 */     allStatus.add(Integer.valueOf(1511));
/* 661 */     allStatus.add(Integer.valueOf(1512));
/* 662 */     allStatus.add(Integer.valueOf(1513));
/* 663 */     allStatus.add(Integer.valueOf(1514));
/* 664 */     allStatus.add(Integer.valueOf(1516));
/* 665 */     return allStatus;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\SingleBattleManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */