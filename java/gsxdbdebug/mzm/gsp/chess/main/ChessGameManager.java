/*     */ package mzm.gsp.chess.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Random;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.activity3.confbean.SChessCfg;
/*     */ import mzm.gsp.chess.ChessPieceInfo;
/*     */ import mzm.gsp.chess.SChessGameOver;
/*     */ import mzm.gsp.chess.SNotifyCurrentPlayerChange;
/*     */ import mzm.gsp.chess.SNotifyRoundChange;
/*     */ import mzm.gsp.chess.SNotifyRoundTimeOut;
/*     */ import mzm.gsp.chess.SSynChessInfo;
/*     */ import mzm.gsp.chess.event.ChessGameBegin;
/*     */ import mzm.gsp.chess.event.ChessGameBeginArg;
/*     */ import mzm.gsp.chess.event.ChessGameFinish;
/*     */ import mzm.gsp.chess.event.ChessGameFinishArg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.util.CommonContextManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.ChessGameInfo;
/*     */ import xbean.ChessPiece;
/*     */ import xbean.Pod;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Xdb;
/*     */ import xtable.Chessgameinfo;
/*     */ import xtable.Role2chessgameinfo;
/*     */ 
/*     */ class ChessGameManager
/*     */ {
/*  41 */   static final Logger logger = Logger.getLogger(ChessGameManager.class);
/*  42 */   static final CommonContextManager<IChessGameContext> contextManager = new CommonContextManager();
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static final int PLAYER_COUNT = 2;
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static enum OperationType
/*     */   {
/*  54 */     MOVE(1), 
/*  55 */     MOVE_AND_ATTACK(2), 
/*  56 */     TURN_AND_ATTACK(3), 
/*  57 */     TURN_AND_BE_ATTACKED(4), 
/*  58 */     OTHER(5);
/*     */     
/*     */     final int value;
/*     */     
/*     */     private OperationType(int value)
/*     */     {
/*  64 */       this.value = value;
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
/*     */ 
/*     */   static void startChessGame(List<Long> roleIds, final int chessGameCfgId, final IChessGameContext context)
/*     */   {
/*  78 */     if (roleIds.size() != 2)
/*     */     {
/*  80 */       String logstr = String.format("[chess]ChessGameManager.startChessGame@player count error|CfgId=%d|roleids=%s", new Object[] { Integer.valueOf(chessGameCfgId), roleIds.toString() });
/*     */       
/*     */ 
/*  83 */       logger.error(logstr);
/*  84 */       return;
/*     */     }
/*     */     
/*  87 */     final SChessCfg sChessCfg = SChessCfg.get(chessGameCfgId);
/*  88 */     if (null == sChessCfg)
/*     */     {
/*  90 */       String logstr = String.format("[chess]ChessGameManager.startChessGame@chessGameCfg id not exist|CfgId=%d|roleids=%s", new Object[] { Integer.valueOf(chessGameCfgId), roleIds.toString() });
/*     */       
/*     */ 
/*  93 */       logger.error(logstr);
/*  94 */       return;
/*     */     }
/*     */     
/*  97 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */       {
/*     */ 
/* 103 */         Lockeys.lock(Role2chessgameinfo.getTable(), this.val$roleIds);
/*     */         
/* 105 */         for (Iterator i$ = this.val$roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */           
/*     */ 
/* 108 */           if (!RoleStatusInterface.setStatus(roleId, 1561, true))
/*     */           {
/* 110 */             String logstr = String.format("[chess]ChessGameManager.startChessGame@player status error|roleid=%d", new Object[] { Long.valueOf(roleId) });
/*     */             
/* 112 */             ChessGameManager.logger.error(logstr);
/* 113 */             return false;
/*     */           }
/*     */           
/* 116 */           if (null != Role2chessgameinfo.get(Long.valueOf(roleId)))
/*     */           {
/* 118 */             String logstr = String.format("[chess]ChessGameManager.startChessGame@player chessgameinfo already exsists|roleid=%d", new Object[] { Long.valueOf(roleId) });
/*     */             
/* 120 */             ChessGameManager.logger.error(logstr);
/* 121 */             return false;
/*     */           }
/*     */         }
/*     */         
/* 125 */         long currentTime = DateTimeUtils.getCurrTimeInMillis();
/* 126 */         ChessGameInfo xChessGameInfo = Pod.newChessGameInfo();
/*     */         
/* 128 */         Map<Integer, ChessPiece> index2ChessPiece = xChessGameInfo.getChess_board_index2chess_piece();
/* 129 */         List<ChessPiece> chessPieceInfos = new LinkedList();
/* 130 */         for (Map.Entry<Integer, Integer> chessPieceIndex2countEntry : sChessCfg.chessPieceIndex2count.entrySet())
/*     */         {
/* 132 */           for (int i = 0; i < ((Integer)chessPieceIndex2countEntry.getValue()).intValue(); i++)
/*     */           {
/* 134 */             int chessPieceIndex = ((Integer)chessPieceIndex2countEntry.getKey()).intValue();
/* 135 */             ChessPiece xChessPiece1 = Pod.newChessPiece();
/* 136 */             xChessPiece1.setChess_piece_index(chessPieceIndex);
/* 137 */             xChessPiece1.setOwn_by_a(true);
/* 138 */             xChessPiece1.setVisible(false);
/* 139 */             chessPieceInfos.add(xChessPiece1);
/* 140 */             ChessPiece xChessPiece2 = Pod.newChessPiece();
/* 141 */             xChessPiece2.setChess_piece_index(chessPieceIndex);
/* 142 */             xChessPiece2.setOwn_by_a(false);
/* 143 */             xChessPiece2.setVisible(false);
/* 144 */             chessPieceInfos.add(xChessPiece2);
/*     */           }
/*     */         }
/*     */         
/* 148 */         int chessCellCount = sChessCfg.maxRow * sChessCfg.maxColumn;
/* 149 */         if (chessCellCount < chessPieceInfos.size())
/*     */         {
/* 151 */           String logstr = String.format("[chess]ChessGameManager.startChessGame@chess board can't contain so much chess piece|chessGameCfgId=%d", new Object[] { Integer.valueOf(chessGameCfgId) });
/*     */           
/*     */ 
/* 154 */           ChessGameManager.logger.error(logstr);
/* 155 */           return false;
/*     */         }
/* 157 */         int chessCellIndex = 1;
/* 158 */         java.util.Collections.shuffle(chessPieceInfos);
/* 159 */         for (ChessPiece xChessPiece : chessPieceInfos)
/*     */         {
/* 161 */           index2ChessPiece.put(Integer.valueOf(chessCellIndex++), xChessPiece);
/*     */         }
/*     */         
/* 164 */         long chessGameId = Chessgameinfo.insert(xChessGameInfo).longValue();
/* 165 */         for (Iterator i$ = this.val$roleIds.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */           
/* 167 */           Role2chessgameinfo.add(Long.valueOf(roleId), Long.valueOf(chessGameId));
/*     */         }
/*     */         
/* 170 */         long sessionId = new ChessGameRoundSession(sChessCfg.roundTimeLimit, chessGameId).getSessionId();
/* 171 */         xChessGameInfo.setSession_id(sessionId);
/*     */         
/* 173 */         boolean isFirstRolePlayerA = Xdb.random().nextBoolean();
/* 174 */         xChessGameInfo.setCfg_id(chessGameCfgId);
/* 175 */         xChessGameInfo.setCurrent_player_is_a(true);
/* 176 */         xChessGameInfo.setRound(1);
/* 177 */         xChessGameInfo.setStart_time(currentTime);
/* 178 */         xChessGameInfo.setRound_start_time(currentTime);
/* 179 */         xChessGameInfo.setPlayer_a((isFirstRolePlayerA ? (Long)this.val$roleIds.get(0) : (Long)this.val$roleIds.get(1)).longValue());
/* 180 */         xChessGameInfo.setPlayer_b((!isFirstRolePlayerA ? (Long)this.val$roleIds.get(0) : (Long)this.val$roleIds.get(1)).longValue());
/* 181 */         long contextId = ChessGameManager.contextManager.addContext(context);
/* 182 */         xChessGameInfo.setContext_id(contextId);
/*     */         
/* 184 */         ChessGameManager.triggerGameStartEvent(xChessGameInfo.getPlayer_a(), xChessGameInfo.getPlayer_b());
/*     */         
/* 186 */         ChessGameManager.synChessGameInfoToClient(xChessGameInfo.getPlayer_a(), xChessGameInfo.getPlayer_b(), xChessGameInfo);
/* 187 */         ChessGameManager.synChessGameInfoToClient(xChessGameInfo.getPlayer_b(), xChessGameInfo.getPlayer_a(), xChessGameInfo);
/*     */         
/* 189 */         ChessGameTLogManager.tlogChessGameStart(xChessGameInfo.getPlayer_a(), this.val$roleIds, chessGameCfgId);
/* 190 */         ChessGameTLogManager.tlogChessGameStart(xChessGameInfo.getPlayer_b(), this.val$roleIds, chessGameCfgId);
/* 191 */         return true;
/*     */       }
/*     */     }.execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void synChessGameInfoToClient(long roleId, long enemyRoleId, ChessGameInfo xChessGameInfo)
/*     */   {
/* 205 */     SSynChessInfo sSynChessInfo = new SSynChessInfo();
/* 206 */     Role role = mzm.gsp.role.main.RoleInterface.getRole(enemyRoleId, true);
/* 207 */     sSynChessInfo.enemy_id = enemyRoleId;
/* 208 */     sSynChessInfo.enemy_name = role.getName();
/* 209 */     sSynChessInfo.enemy_occupation = role.getOccupationId();
/* 210 */     sSynChessInfo.enemy_gender = role.getGender();
/* 211 */     sSynChessInfo.enemy_level = role.getLevel();
/* 212 */     sSynChessInfo.enemy_avatar = mzm.gsp.avatar.main.AvatarInterface.getCurrentAvatar(enemyRoleId, true);
/* 213 */     sSynChessInfo.cfg_id = xChessGameInfo.getCfg_id();
/* 214 */     sSynChessInfo.current_player = getCurrentPlayerBlueOrRed(xChessGameInfo);
/* 215 */     sSynChessInfo.self_side = getSelfSideBlueOrRed(roleId, xChessGameInfo);
/* 216 */     sSynChessInfo.round = xChessGameInfo.getRound();
/* 217 */     sSynChessInfo.round_start_time = xChessGameInfo.getRound_start_time();
/* 218 */     for (Map.Entry<Integer, ChessPiece> chessPieceEntry : xChessGameInfo.getChess_board_index2chess_piece().entrySet())
/*     */     {
/* 220 */       ChessPiece xChessPiece = (ChessPiece)chessPieceEntry.getValue();
/* 221 */       int chessCellIndex = ((Integer)chessPieceEntry.getKey()).intValue();
/* 222 */       ChessPieceInfo chessPieceInfo = new ChessPieceInfo();
/* 223 */       chessPieceInfo.chess_cell_index = chessCellIndex;
/*     */       
/* 225 */       if (xChessPiece.getVisible())
/*     */       {
/* 227 */         chessPieceInfo.chess_piece_index = xChessPiece.getChess_piece_index();
/* 228 */         chessPieceInfo.owner = getChessPieceBlueOrRed(xChessPiece);
/*     */       }
/*     */       else
/*     */       {
/* 232 */         chessPieceInfo.chess_piece_index = 0;
/* 233 */         chessPieceInfo.owner = 0;
/*     */       }
/* 235 */       sSynChessInfo.chess_piece_infos.add(chessPieceInfo);
/*     */     }
/* 237 */     OnlineManager.getInstance().send(roleId, sSynChessInfo);
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
/*     */   private static int getCurrentPlayerBlueOrRed(ChessGameInfo xChessGameInfo)
/*     */   {
/* 250 */     return xChessGameInfo.getCurrent_player_is_a() ? 2 : 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int getSelfSideBlueOrRed(long roleId, ChessGameInfo xChessGameInfo)
/*     */   {
/* 262 */     return xChessGameInfo.getPlayer_a() == roleId ? 2 : 1;
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
/*     */   static boolean isCurrentPlayerSelf(long selfRoleId, ChessGameInfo xChessGameInfo)
/*     */   {
/* 275 */     if ((selfRoleId == xChessGameInfo.getPlayer_a()) && (xChessGameInfo.getCurrent_player_is_a()))
/*     */     {
/* 277 */       return true;
/*     */     }
/* 279 */     if ((selfRoleId == xChessGameInfo.getPlayer_b()) && (!xChessGameInfo.getCurrent_player_is_a()))
/*     */     {
/* 281 */       return true;
/*     */     }
/*     */     
/* 284 */     return false;
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
/*     */   static int getChessPieceBlueOrRed(ChessPiece xChessPiece)
/*     */   {
/* 298 */     return xChessPiece.getOwn_by_a() ? 2 : 1;
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
/*     */ 
/*     */   static boolean isChessPieceSelf(long selfRoleId, ChessPiece xChessPiece, ChessGameInfo xChessGameInfo)
/*     */   {
/* 313 */     return !(selfRoleId == xChessGameInfo.getPlayer_a() ^ xChessPiece.getOwn_by_a());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static void triggerGameStartEvent(long roleIdA, long roleIdB)
/*     */   {
/* 324 */     ChessGameBegin chessGameBegin = new ChessGameBegin();
/* 325 */     ChessGameBeginArg arg = new ChessGameBeginArg(roleIdA, roleIdB);
/* 326 */     TriggerEventsManger.getInstance().triggerEvent(chessGameBegin, arg);
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
/*     */ 
/*     */   private static void triggerGameFinishEvent(int result, int reason, long roleIdA, long roleIdB, IChessGameContext context)
/*     */   {
/* 341 */     ChessGameFinish chessGameFinish = new ChessGameFinish();
/* 342 */     ChessGameFinishArg arg = new ChessGameFinishArg(result, reason, roleIdA, roleIdB, context);
/* 343 */     TriggerEventsManger.getInstance().triggerEvent(chessGameFinish, arg);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void recordPlayerOperateRound(long roleId, ChessGameInfo xChessGameInfo)
/*     */   {
/* 354 */     if (roleId == xChessGameInfo.getPlayer_a())
/*     */     {
/* 356 */       xChessGameInfo.setPlayer_a_last_operate_round(xChessGameInfo.getRound());
/*     */     }
/* 358 */     else if (roleId == xChessGameInfo.getPlayer_b())
/*     */     {
/* 360 */       xChessGameInfo.setPlayer_b_last_operate_round(xChessGameInfo.getRound());
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
/*     */   static void onGameRoundEnd(long chessGameId, boolean haveKill, OperationType operationType)
/*     */   {
/* 373 */     ChessGameInfo xChessGameInfo = Chessgameinfo.get(Long.valueOf(chessGameId));
/* 374 */     if (null == xChessGameInfo)
/*     */     {
/* 376 */       String logstr = String.format("[chess]ChessGameManager.onGameRoundEnd@xChessGameInfo not exsists|chessGameId=%d", new Object[] { Long.valueOf(chessGameId) });
/*     */       
/* 378 */       logger.error(logstr);
/* 379 */       return;
/*     */     }
/*     */     
/* 382 */     SChessCfg sChessCfg = SChessCfg.get(xChessGameInfo.getCfg_id());
/* 383 */     Session oldSession = ChessGameRoundSession.getSession(xChessGameInfo.getSession_id());
/* 384 */     if (null != oldSession)
/*     */     {
/* 386 */       oldSession.stopTimer();
/*     */     }
/*     */     
/* 389 */     if (checkAndDoChessGameFinish(chessGameId, xChessGameInfo))
/*     */     {
/* 391 */       return;
/*     */     }
/*     */     
/* 394 */     long currentTime = DateTimeUtils.getCurrTimeInMillis();
/* 395 */     xChessGameInfo.setRound_start_time(currentTime);
/*     */     
/* 397 */     if (haveKill)
/*     */     {
/* 399 */       xChessGameInfo.setLast_kill_round(xChessGameInfo.getRound());
/*     */     }
/*     */     
/* 402 */     if (isWholeRoundOver(xChessGameInfo))
/*     */     {
/* 404 */       xChessGameInfo.setRound(xChessGameInfo.getRound() + 1);
/* 405 */       sendRoundChangeToClient(xChessGameInfo);
/*     */     }
/*     */     
/* 408 */     xChessGameInfo.setCurrent_player_is_a(!xChessGameInfo.getCurrent_player_is_a());
/* 409 */     sendCurrentPlayerChangeToClient(xChessGameInfo);
/*     */     
/* 411 */     xChessGameInfo.setNext_operate_time(getNextOperationTime(operationType, sChessCfg));
/*     */     
/* 413 */     long newSessionId = new ChessGameRoundSession(sChessCfg.roundTimeLimit, chessGameId).getSessionId();
/* 414 */     xChessGameInfo.setSession_id(newSessionId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static long getNextOperationTime(OperationType operationType, SChessCfg sChessCfg)
/*     */   {
/*     */     double durationSec;
/*     */     
/*     */ 
/*     */ 
/* 427 */     switch (operationType)
/*     */     {
/*     */     case MOVE: 
/* 430 */       durationSec = sChessCfg.durationAfterMove;
/* 431 */       break;
/*     */     case MOVE_AND_ATTACK: 
/* 433 */       durationSec = sChessCfg.durationAfterMoveAttack;
/* 434 */       break;
/*     */     case TURN_AND_ATTACK: 
/* 436 */       durationSec = sChessCfg.durationAfterTurnAttack;
/* 437 */       break;
/*     */     case TURN_AND_BE_ATTACKED: 
/* 439 */       durationSec = sChessCfg.durationAfterTurnBeAttacked;
/* 440 */       break;
/*     */     default: 
/* 442 */       durationSec = 0.0D;
/*     */     }
/* 444 */     long durationMilliSec = Math.floor(durationSec * 1000.0D);
/* 445 */     return DateTimeUtils.getCurrTimeInMillis() + durationMilliSec;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean isWholeRoundOver(ChessGameInfo xChessGameInfo)
/*     */   {
/* 456 */     return !xChessGameInfo.getCurrent_player_is_a();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendRoundChangeToClient(ChessGameInfo xChessGameInfo)
/*     */   {
/* 467 */     SNotifyRoundChange sNotifyRoundChange = new SNotifyRoundChange(xChessGameInfo.getRound());
/* 468 */     OnlineManager.getInstance().send(xChessGameInfo.getPlayer_a(), sNotifyRoundChange);
/* 469 */     OnlineManager.getInstance().send(xChessGameInfo.getPlayer_b(), sNotifyRoundChange);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendCurrentPlayerChangeToClient(ChessGameInfo xChessGameInfo)
/*     */   {
/* 480 */     int currentPlayer = getCurrentPlayerBlueOrRed(xChessGameInfo);
/* 481 */     SNotifyCurrentPlayerChange sNotifyCurrentPlayerChangeA = new SNotifyCurrentPlayerChange();
/* 482 */     sNotifyCurrentPlayerChangeA.current_player = currentPlayer;
/* 483 */     OnlineManager.getInstance().send(xChessGameInfo.getPlayer_a(), sNotifyCurrentPlayerChangeA);
/* 484 */     SNotifyCurrentPlayerChange sNotifyCurrentPlayerChangeB = new SNotifyCurrentPlayerChange();
/* 485 */     sNotifyCurrentPlayerChangeB.current_player = currentPlayer;
/* 486 */     OnlineManager.getInstance().send(xChessGameInfo.getPlayer_b(), sNotifyCurrentPlayerChangeB);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static boolean checkAndDoChessGameFinish(long chessGameId, ChessGameInfo xChessGameInfo)
/*     */   {
/* 498 */     SChessCfg sChessCfg = SChessCfg.get(xChessGameInfo.getCfg_id());
/* 499 */     int result = -1;
/* 500 */     result = checkChessGameFinishByWipeOutAll(xChessGameInfo);
/* 501 */     if (result > 0)
/*     */     {
/* 503 */       onChessGameFinish(result, 1, chessGameId, xChessGameInfo);
/* 504 */       return true;
/*     */     }
/* 506 */     result = checkChessGameFinishByQuantityCompare(xChessGameInfo, sChessCfg);
/* 507 */     if (result > 0)
/*     */     {
/* 509 */       onChessGameFinish(result, 4, chessGameId, xChessGameInfo);
/* 510 */       return true;
/*     */     }
/* 512 */     result = checkChessGameFinishByTimeUpDraw(xChessGameInfo, sChessCfg);
/* 513 */     if (result > 0)
/*     */     {
/* 515 */       onChessGameFinish(result, 3, chessGameId, xChessGameInfo);
/* 516 */       return true;
/*     */     }
/* 518 */     result = checkChessGameFinishByNoOperateLose(xChessGameInfo, sChessCfg);
/* 519 */     if (result > 0)
/*     */     {
/* 521 */       onChessGameFinish(result, 5, chessGameId, xChessGameInfo);
/* 522 */       return true;
/*     */     }
/*     */     
/* 525 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int checkChessGameFinishByWipeOutAll(ChessGameInfo xChessGameInfo)
/*     */   {
/* 536 */     int playerAChessPieceCount = 0;
/* 537 */     int playerBChessPieceCount = 0;
/* 538 */     for (ChessPiece xChessPiece : xChessGameInfo.getChess_board_index2chess_piece().values())
/*     */     {
/* 540 */       if (xChessPiece.getOwn_by_a())
/*     */       {
/* 542 */         playerAChessPieceCount++;
/*     */       }
/*     */       else
/*     */       {
/* 546 */         playerBChessPieceCount++; }
/*     */     }
/*     */     int res;
/*     */     int res;
/* 550 */     if (playerAChessPieceCount == 0)
/*     */     {
/* 552 */       res = 2;
/*     */     } else { int res;
/* 554 */       if (playerBChessPieceCount == 0)
/*     */       {
/* 556 */         res = 1;
/*     */       }
/*     */       else
/*     */       {
/* 560 */         res = -1; }
/*     */     }
/* 562 */     return res;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int checkChessGameFinishByQuantityCompare(ChessGameInfo xChessGameInfo, SChessCfg sChessCfg)
/*     */   {
/* 574 */     int res = -1;
/* 575 */     if ((xChessGameInfo.getRound() >= sChessCfg.maxRoundCount) && (isWholeRoundOver(xChessGameInfo)))
/*     */     {
/* 577 */       int playerAAdvantageCount = 0;
/* 578 */       for (ChessPiece xChessPiece : xChessGameInfo.getChess_board_index2chess_piece().values())
/*     */       {
/* 580 */         if (xChessPiece.getOwn_by_a())
/*     */         {
/* 582 */           playerAAdvantageCount++;
/*     */         }
/*     */         else
/*     */         {
/* 586 */           playerAAdvantageCount--;
/*     */         }
/*     */       }
/*     */       
/* 590 */       if (playerAAdvantageCount > 0)
/*     */       {
/* 592 */         res = 1;
/*     */ 
/*     */       }
/* 595 */       else if (playerAAdvantageCount < 0)
/*     */       {
/* 597 */         res = 2;
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 602 */         res = 3;
/*     */       }
/*     */     }
/* 605 */     return res;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int checkChessGameFinishByTimeUpDraw(ChessGameInfo xChessGameInfo, SChessCfg sChessCfg)
/*     */   {
/* 617 */     int res = -1;
/* 618 */     if ((xChessGameInfo.getRound() - xChessGameInfo.getLast_kill_round() >= sChessCfg.drawRoundCount) && (isWholeRoundOver(xChessGameInfo)))
/*     */     {
/*     */ 
/* 621 */       res = 3;
/*     */     }
/* 623 */     return res;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private static int checkChessGameFinishByNoOperateLose(ChessGameInfo xChessGameInfo, SChessCfg sChessCfg)
/*     */   {
/* 635 */     int noOperateLoseRoundCount = sChessCfg.noOperateLoseRoundCount;
/* 636 */     int res = -1;
/*     */     
/* 638 */     if (xChessGameInfo.getRound() - xChessGameInfo.getPlayer_a_last_operate_round() >= noOperateLoseRoundCount)
/*     */     {
/* 640 */       res = 2;
/*     */     }
/*     */     
/* 643 */     if ((xChessGameInfo.getRound() - xChessGameInfo.getPlayer_b_last_operate_round() >= noOperateLoseRoundCount) && (isWholeRoundOver(xChessGameInfo)))
/*     */     {
/*     */ 
/* 646 */       res = 1;
/*     */     }
/* 648 */     return res;
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
/*     */ 
/*     */   private static void onChessGameFinish(int result, final int reason, final long chessGameId, ChessGameInfo xChessGameInfo)
/*     */   {
/* 663 */     long RoleIdA = xChessGameInfo.getPlayer_a();
/* 664 */     final long RoleIdB = xChessGameInfo.getPlayer_b();
/* 665 */     List<Long> roleIds = new LinkedList();
/* 666 */     roleIds.add(Long.valueOf(RoleIdA));
/* 667 */     roleIds.add(Long.valueOf(RoleIdB));
/* 668 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */       {
/*     */         try
/*     */         {
/* 675 */           Lockeys.lock(Role2chessgameinfo.getTable(), this.val$roleIds);
/* 676 */           ChessGameInfo xChessGameInfo = Chessgameinfo.get(Long.valueOf(chessGameId));
/* 677 */           if (null == xChessGameInfo)
/*     */           {
/* 679 */             String logstr = String.format("[chess]ChessGameManager.onChessGameFinish@xChessGameInfo not exsists|chessGameId=%d", new Object[] { Long.valueOf(chessGameId) });
/*     */             
/*     */ 
/* 682 */             ChessGameManager.logger.error(logstr);
/* 683 */             return false;
/*     */           }
/*     */           
/* 686 */           RoleStatusInterface.unsetStatus(RoleIdB, 1561);
/* 687 */           RoleStatusInterface.unsetStatus(reason, 1561);
/*     */           
/* 689 */           ChessGameManager.sendChessGameOverToClient(RoleIdB, reason, this.val$result, this.val$reason);
/*     */           
/* 691 */           IChessGameContext context = (IChessGameContext)ChessGameManager.contextManager.getContext(xChessGameInfo.getContext_id());
/* 692 */           if (null == context)
/*     */           {
/* 694 */             String logstr = String.format("[chess]ChessGameManager.onChessGameFinish@context not exsists!!!|chessGameId=%d", new Object[] { Long.valueOf(chessGameId) });
/*     */             
/* 696 */             ChessGameManager.logger.error(logstr);
/*     */           }
/*     */           else
/*     */           {
/* 700 */             ChessGameManager.triggerGameFinishEvent(this.val$result, this.val$reason, RoleIdB, reason, context);
/*     */           }
/*     */           
/* 703 */           Session oldSession = ChessGameRoundSession.getSession(xChessGameInfo.getSession_id());
/* 704 */           if (null != oldSession)
/*     */           {
/* 706 */             oldSession.stopTimer();
/*     */           }
/*     */           
/* 709 */           int chessGameCfgId = xChessGameInfo.getCfg_id();
/* 710 */           int finalRound = xChessGameInfo.getRound();
/* 711 */           ChessGameTLogManager.tlogChessGameFinished(RoleIdB, this.val$roleIds, chessGameCfgId, finalRound, this.val$result, this.val$reason);
/* 712 */           ChessGameTLogManager.tlogChessGameFinished(reason, this.val$roleIds, chessGameCfgId, finalRound, ChessGameManager.getEnemyGameResultBySelfResult(this.val$result), this.val$reason);
/*     */ 
/*     */         }
/*     */         finally
/*     */         {
/*     */ 
/* 718 */           ChessGameManager.contextManager.removeContext(this.val$xChessGameInfo.getContext_id());
/*     */           
/* 720 */           Role2chessgameinfo.remove(Long.valueOf(this.val$xChessGameInfo.getPlayer_a()));
/* 721 */           Role2chessgameinfo.remove(Long.valueOf(this.val$xChessGameInfo.getPlayer_b()));
/* 722 */           Chessgameinfo.remove(Long.valueOf(chessGameId));
/*     */         }
/* 724 */         return true;
/*     */       }
/*     */     }.execute();
/*     */   }
/*     */   
/*     */   private static void sendChessGameOverToClient(long roleIdA, long roleIdB, int resultForA, int reason)
/*     */   {
/* 731 */     OnlineManager.getInstance().send(roleIdA, new SChessGameOver(resultForA, reason));
/* 732 */     OnlineManager.getInstance().send(roleIdB, new SChessGameOver(getEnemyGameResultBySelfResult(resultForA), reason));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getEnemyGameResultBySelfResult(int selfResult)
/*     */   {
/* 743 */     switch (selfResult)
/*     */     {
/*     */     case 1: 
/* 746 */       return 2;
/*     */     case 2: 
/* 748 */       return 1;
/*     */     }
/* 750 */     return 3;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void chessGameFinishBySurrender(long roleId, long chessGameId, ChessGameInfo xChessGameInfo)
/*     */   {
/*     */     int playerAResult;
/*     */     
/*     */ 
/*     */     int playerAResult;
/*     */     
/*     */ 
/* 764 */     if (roleId == xChessGameInfo.getPlayer_a())
/*     */     {
/* 766 */       playerAResult = 2;
/*     */     }
/*     */     else
/*     */     {
/* 770 */       playerAResult = 1;
/*     */     }
/*     */     
/* 773 */     onChessGameFinish(playerAResult, 2, chessGameId, xChessGameInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void chessGameFinishByGM(long roleId, long chessGameId)
/*     */   {
/* 784 */     ChessGameInfo xChessGameInfo = Chessgameinfo.get(Long.valueOf(chessGameId));
/* 785 */     if (null == xChessGameInfo)
/*     */     {
/* 787 */       String logstr = String.format("[chess]ChessGameManager.chessGameFinishByGM@xChessGameInfo not exsists|chessGameId=%d", new Object[] { Long.valueOf(chessGameId) });
/*     */       
/* 789 */       logger.error(logstr); return;
/*     */     }
/*     */     
/*     */     int playerAResult;
/*     */     int playerAResult;
/* 794 */     if (roleId == xChessGameInfo.getPlayer_a())
/*     */     {
/* 796 */       playerAResult = 2;
/*     */     }
/*     */     else
/*     */     {
/* 800 */       playerAResult = 1;
/*     */     }
/* 802 */     onChessGameFinish(playerAResult, 4, chessGameId, xChessGameInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendNotifyRoundTimeOutToClient(long chessGameId)
/*     */   {
/* 812 */     ChessGameInfo xChessGameInfo = Chessgameinfo.get(Long.valueOf(chessGameId));
/* 813 */     if (null == xChessGameInfo)
/*     */     {
/* 815 */       String logstr = String.format("[chess]ChessGameManager.sendNotifyRoundTimeOutToClient@xChessGameInfo not exsists|chessGameId=%d", new Object[] { Long.valueOf(chessGameId) });
/*     */       
/*     */ 
/* 818 */       logger.error(logstr);
/* 819 */       return;
/*     */     }
/* 821 */     SNotifyRoundTimeOut sNotifyRoundTimeOut = new SNotifyRoundTimeOut();
/* 822 */     OnlineManager.getInstance().send(xChessGameInfo.getPlayer_a(), sNotifyRoundTimeOut);
/* 823 */     OnlineManager.getInstance().send(xChessGameInfo.getPlayer_b(), sNotifyRoundTimeOut);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isChessCellIndexValid(int chessCellIndex, SChessCfg sChessCfg)
/*     */   {
/* 835 */     int maxIndex = sChessCfg.maxRow * sChessCfg.maxColumn;
/* 836 */     return (chessCellIndex > 0) && (chessCellIndex <= maxIndex);
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
/*     */   static boolean isChessCellsAdjoin(int rawFromCellIndex, int rawToCellIndex, SChessCfg sChessCfg)
/*     */   {
/* 850 */     int fromCellIndex = rawFromCellIndex - 1;
/* 851 */     int toCellIndex = rawToCellIndex - 1;
/* 852 */     int fromCellRow = fromCellIndex / sChessCfg.maxColumn;
/* 853 */     int toCellRow = toCellIndex / sChessCfg.maxColumn;
/* 854 */     int fromCellColumn = fromCellIndex % sChessCfg.maxColumn;
/* 855 */     int toCellColumn = toCellIndex % sChessCfg.maxColumn;
/* 856 */     return Math.abs(fromCellRow - toCellRow) + Math.abs(fromCellColumn - toCellColumn) == 1;
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
/*     */   static boolean canChessAKillChessB(int chessPieceIndexA, int chessPieceIndexB, SChessCfg sChessCfg)
/*     */   {
/* 870 */     if ((chessPieceIndexA == 1) && (chessPieceIndexB == sChessCfg.chessPieceIndex2count.size()))
/*     */     {
/* 872 */       return false;
/*     */     }
/*     */     
/* 875 */     if ((chessPieceIndexA == sChessCfg.chessPieceIndex2count.size()) && (chessPieceIndexB == 1))
/*     */     {
/* 877 */       return true;
/*     */     }
/*     */     
/* 880 */     if (chessPieceIndexA <= chessPieceIndexB)
/*     */     {
/* 882 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 886 */     return false;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chess\main\ChessGameManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */