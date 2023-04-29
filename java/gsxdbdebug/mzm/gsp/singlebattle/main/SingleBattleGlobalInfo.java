/*      */ package mzm.gsp.singlebattle.main;
/*      */ 
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import mzm.gsp.GameServer;
/*      */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*      */ import mzm.gsp.map.main.MapCallback;
/*      */ import mzm.gsp.map.main.MapInterface;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.role.main.Role;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.singlebattle.CampGlobalInfo;
/*      */ import mzm.gsp.singlebattle.FightRecord;
/*      */ import mzm.gsp.singlebattle.RoleBaseInfo;
/*      */ import mzm.gsp.singlebattle.RoleTotalInfo;
/*      */ import mzm.gsp.singlebattle.SLogoutBro;
/*      */ import mzm.gsp.singlebattle.SNewGuyTotalInfoBro;
/*      */ import mzm.gsp.singlebattle.SSynBattleGlobalInfo;
/*      */ import mzm.gsp.singlebattle.SSynBattleTotalInfo;
/*      */ import mzm.gsp.singlebattle.confbean.SCampCfg;
/*      */ import mzm.gsp.singlebattle.confbean.SSingleBattleCfg;
/*      */ import mzm.gsp.singlebattle.confbean.SSingleBattleDieDuration;
/*      */ import mzm.gsp.singlebattle.confbean.STSingleBattlePlayLibCfg;
/*      */ import mzm.gsp.util.Pair;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.BattleFightRecord;
/*      */ import xbean.GlobalSingleBattleData;
/*      */ import xbean.Pod;
/*      */ import xbean.SingleBattleSessions;
/*      */ import xbean.SingleRecord;
/*      */ import xbean.roleBattleData;
/*      */ import xio.Protocol;
/*      */ import xtable.Singlebattle;
/*      */ 
/*      */ public class SingleBattleGlobalInfo
/*      */ {
/*      */   private final long _battleId;
/*      */   private final GlobalSingleBattleData _xBattleData;
/*      */   
/*      */   public SingleBattleGlobalInfo(long battleId, boolean remainBattleLock)
/*      */   {
/*   52 */     this._battleId = battleId;
/*   53 */     if (remainBattleLock)
/*      */     {
/*   55 */       this._xBattleData = Singlebattle.get(Long.valueOf(battleId));
/*      */     }
/*      */     else
/*      */     {
/*   59 */       this._xBattleData = Singlebattle.select(Long.valueOf(battleId));
/*      */     }
/*      */   }
/*      */   
/*      */   GlobalSingleBattleData getxBattleData()
/*      */   {
/*   65 */     return this._xBattleData;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getBattleCfgId()
/*      */   {
/*   75 */     return this._xBattleData.getBattlecfgid();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Set<Integer> getAllCampIds()
/*      */   {
/*   85 */     return this._xBattleData.getCampinfos().keySet();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public long getStartTime()
/*      */   {
/*   95 */     return this._xBattleData.getStarttime();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public long getBattleId()
/*      */   {
/*  105 */     return this._battleId;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public long getBattleWorldId()
/*      */   {
/*  115 */     return this._xBattleData.getWorld();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public SingleBattleContext getBattleContext()
/*      */   {
/*  125 */     return SingleBattleContextContainer.getInstance().getContext(this._xBattleData.getContextid());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getReviveInterval(long roleId, int campId)
/*      */   {
/*  139 */     SSingleBattleDieDuration cfg = SSingleBattleDieDuration.get(getRoleDeadCount(roleId));
/*  140 */     if (cfg == null)
/*      */     {
/*      */ 
/*  143 */       return getBattleCfg().defaultRevivalTime;
/*      */     }
/*  145 */     return cfg.duration;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private int getRoleDeadCount(long roleId)
/*      */   {
/*  157 */     SingleRecord xRoleRecord = (SingleRecord)this._xBattleData.getFightrecord().getRoleids().get(Long.valueOf(roleId));
/*  158 */     if (xRoleRecord == null)
/*      */     {
/*  160 */       return 0;
/*      */     }
/*  162 */     int totalDeadCount = 0;
/*  163 */     Map<Long, Integer> deadInfos = xRoleRecord.getKiller2count();
/*  164 */     for (Iterator i$ = deadInfos.values().iterator(); i$.hasNext();) { int deadCount = ((Integer)i$.next()).intValue();
/*      */       
/*  166 */       totalDeadCount += deadCount;
/*      */     }
/*  168 */     return totalDeadCount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getCampSource(int campId)
/*      */   {
/*  180 */     xbean.CampInfo xCampData = (xbean.CampInfo)this._xBattleData.getCampinfos().get(Integer.valueOf(campId));
/*  181 */     if (xCampData == null)
/*      */     {
/*  183 */       return 0;
/*      */     }
/*  185 */     return xCampData.getSource();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Map<Long, roleBattleData> getCampMemers(int campId)
/*      */   {
/*  197 */     xbean.CampInfo xCampData = (xbean.CampInfo)this._xBattleData.getCampinfos().get(Integer.valueOf(campId));
/*  198 */     if (xCampData == null)
/*      */     {
/*  200 */       return null;
/*      */     }
/*  202 */     return xCampData.getRolebattledatas();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Set<Long> getCampNormalMembers(int campId)
/*      */   {
/*  214 */     return getStateMembers(campId, 1);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Set<Long> getCampOutlineMembers(int campId)
/*      */   {
/*  226 */     return getStateMembers(campId, 2);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Set<Long> getCampLeavedMembers(int campId)
/*      */   {
/*  238 */     return getStateMembers(campId, 3);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public SSingleBattleCfg getBattleCfg()
/*      */   {
/*  248 */     return SSingleBattleCfg.get(getBattleCfgId());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getBattleMapId()
/*      */   {
/*  258 */     return getBattleCfg().fightMap;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void battleBro(Protocol p, boolean atOnce)
/*      */   {
/*  270 */     if (atOnce)
/*      */     {
/*  272 */       OnlineManager.getInstance().sendMultiAtOnce(p, getBattleNormalMembers());
/*      */     }
/*      */     else
/*      */     {
/*  276 */       OnlineManager.getInstance().sendMulti(p, getBattleNormalMembers());
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Set<Long> getBattleNormalMembers()
/*      */   {
/*  287 */     Set<Long> members = new HashSet();
/*  288 */     for (Map.Entry<Integer, xbean.CampInfo> entry : this._xBattleData.getCampinfos().entrySet())
/*      */     {
/*  290 */       members.addAll(getStateMembers(((Integer)entry.getKey()).intValue(), Arrays.asList(new Integer[] { Integer.valueOf(1) })));
/*      */     }
/*      */     
/*  293 */     return members;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Set<Long> getAllMembers()
/*      */   {
/*  303 */     Set<Long> allMembers = new HashSet();
/*  304 */     for (Map.Entry<Integer, xbean.CampInfo> entry : this._xBattleData.getCampinfos().entrySet())
/*      */     {
/*  306 */       allMembers.addAll(getStateMembers(((Integer)entry.getKey()).intValue(), Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) })));
/*      */     }
/*      */     
/*  309 */     return allMembers;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Set<Long> getCampAllMembers(int campId)
/*      */   {
/*  321 */     return getStateMembers(campId, Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(2) }));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public void campBro(int campId, Protocol p, boolean atOnce)
/*      */   {
/*  333 */     Set<Long> normalMembers = getStateMembers(campId, 1);
/*      */     
/*  335 */     if ((normalMembers == null) || (normalMembers.size() == 0))
/*      */     {
/*  337 */       return;
/*      */     }
/*  339 */     if (atOnce)
/*      */     {
/*  341 */       OnlineManager.getInstance().sendMultiAtOnce(p, normalMembers);
/*      */     }
/*      */     else
/*      */     {
/*  345 */       OnlineManager.getInstance().sendMulti(p, normalMembers);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getRoleState(long roleId, int campId)
/*      */   {
/*  361 */     xbean.CampInfo xCampInfo = (xbean.CampInfo)this._xBattleData.getCampinfos().get(Integer.valueOf(campId));
/*  362 */     if (xCampInfo == null)
/*      */     {
/*  364 */       return -1;
/*      */     }
/*  366 */     Integer state = Integer.valueOf(((roleBattleData)xCampInfo.getRolebattledatas().get(Long.valueOf(roleId))).getState());
/*  367 */     return state == null ? -1 : state.intValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getWinnerCampId()
/*      */   {
/*  377 */     int winner = -1;
/*  378 */     int source = 0;
/*  379 */     for (Map.Entry<Integer, xbean.CampInfo> entry : this._xBattleData.getCampinfos().entrySet())
/*      */     {
/*  381 */       if (!((xbean.CampInfo)entry.getValue()).getSurrender())
/*      */       {
/*      */ 
/*      */ 
/*  385 */         if ((winner == -1) || (source < ((xbean.CampInfo)entry.getValue()).getSource()))
/*      */         {
/*  387 */           winner = ((Integer)entry.getKey()).intValue();
/*  388 */           source = ((xbean.CampInfo)entry.getValue()).getSource();
/*      */ 
/*      */         }
/*  391 */         else if (source <= ((xbean.CampInfo)entry.getValue()).getSource())
/*      */         {
/*      */ 
/*      */ 
/*  395 */           if (source == ((xbean.CampInfo)entry.getValue()).getSource())
/*      */           {
/*      */ 
/*  398 */             winner = 0;
/*  399 */             break;
/*      */           }
/*      */         } } }
/*  402 */     return winner;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean isInMatch()
/*      */   {
/*  412 */     return getStage() == 2;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public boolean isInClean()
/*      */   {
/*  422 */     return getStage() == 4;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getStage()
/*      */   {
/*  431 */     return this._xBattleData.getStage();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public Map<Integer, Integer> getPlayType2CfgId()
/*      */   {
/*  442 */     STSingleBattlePlayLibCfg playLibCfg = STSingleBattlePlayLibCfg.get(getBattleCfg().playLibId);
/*  443 */     if (playLibCfg == null)
/*      */     {
/*  445 */       return Collections.emptyMap();
/*      */     }
/*  447 */     return playLibCfg.type2cfgId;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getPlayCfgId(int playType)
/*      */   {
/*  459 */     Map<Integer, Integer> play2cfgId = getPlayType2CfgId();
/*  460 */     if ((play2cfgId == null) || (play2cfgId.size() == 0))
/*      */     {
/*  462 */       return -1;
/*      */     }
/*  464 */     Integer cfgId = (Integer)play2cfgId.get(Integer.valueOf(playType));
/*  465 */     return cfgId == null ? -1 : cfgId.intValue();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   public int getRoleCampId(long roleId)
/*      */   {
/*  476 */     for (Map.Entry<Integer, xbean.CampInfo> entry : this._xBattleData.getCampinfos().entrySet())
/*      */     {
/*  478 */       int campId = ((Integer)entry.getKey()).intValue();
/*  479 */       xbean.CampInfo xCampInfo = (xbean.CampInfo)entry.getValue();
/*      */       
/*  481 */       roleBattleData xRoleBattleData = (roleBattleData)xCampInfo.getRolebattledatas().get(Long.valueOf(roleId));
/*  482 */       if (xRoleBattleData != null)
/*      */       {
/*      */ 
/*      */ 
/*  486 */         if (xRoleBattleData.getState() == 3)
/*      */         {
/*  488 */           return -1;
/*      */         }
/*  490 */         return campId;
/*      */       } }
/*  492 */     return -1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   boolean needAdvanceEndMatch()
/*      */   {
/*  502 */     List<Integer> allSource = new ArrayList();
/*  503 */     for (Map.Entry<Integer, xbean.CampInfo> entry : this._xBattleData.getCampinfos().entrySet())
/*      */     {
/*  505 */       allSource.add(Integer.valueOf(((xbean.CampInfo)entry.getValue()).getSource()));
/*      */     }
/*  507 */     int size = allSource.size();
/*  508 */     if (size <= 1)
/*      */     {
/*  510 */       return false;
/*      */     }
/*  512 */     Collections.sort(allSource);
/*  513 */     int diff = ((Integer)allSource.get(size - 1)).intValue() - ((Integer)allSource.get(size - 2)).intValue();
/*  514 */     return diff >= getBattleCfg().diffScores;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void setStage(int stage)
/*      */   {
/*  524 */     this._xBattleData.setStage(stage);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   void clearBattleContext()
/*      */   {
/*  532 */     SingleBattleContextContainer.getInstance().removeContext(this._xBattleData.getContextid());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void recordFight(long winner, long loser, long reviveTime)
/*      */   {
/*  544 */     addKillCount(winner, loser);
/*  545 */     addDeadCount(winner, loser, reviveTime);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void addFightId(long fightId)
/*      */   {
/*  555 */     this._xBattleData.getAllfightids().add(Long.valueOf(fightId));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void removeFightId(long fightId)
/*      */   {
/*  565 */     this._xBattleData.getAllfightids().remove(Long.valueOf(fightId));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   Set<Long> getAllFightIds()
/*      */   {
/*  575 */     return this._xBattleData.getAllfightids();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void addDeadCount(long winner, long loser, long reviveTime)
/*      */   {
/*  587 */     SingleRecord xLoserData = (SingleRecord)this._xBattleData.getFightrecord().getRoleids().get(Long.valueOf(loser));
/*  588 */     if (xLoserData == null)
/*      */     {
/*  590 */       this._xBattleData.getFightrecord().getRoleids().put(Long.valueOf(loser), xLoserData = Pod.newSingleRecord());
/*      */     }
/*  592 */     Map<Long, Integer> xDeadInfo = xLoserData.getKiller2count();
/*  593 */     Integer deadCount = (Integer)xDeadInfo.get(Long.valueOf(winner));
/*  594 */     if (deadCount == null)
/*      */     {
/*  596 */       deadCount = Integer.valueOf(0);
/*      */     }
/*  598 */     xDeadInfo.put(Long.valueOf(winner), Integer.valueOf(deadCount.intValue() + 1));
/*      */     
/*  600 */     xLoserData.setRevivetime(reviveTime);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void addKillCount(long winner, long loser)
/*      */   {
/*  611 */     SingleRecord xWinnerData = (SingleRecord)this._xBattleData.getFightrecord().getRoleids().get(Long.valueOf(winner));
/*  612 */     if (xWinnerData == null)
/*      */     {
/*  614 */       this._xBattleData.getFightrecord().getRoleids().put(Long.valueOf(winner), xWinnerData = Pod.newSingleRecord());
/*      */     }
/*  616 */     Map<Long, Integer> xKillInfo = xWinnerData.getDead2count();
/*  617 */     Integer killCount = (Integer)xKillInfo.get(Long.valueOf(loser));
/*  618 */     if (killCount == null)
/*      */     {
/*  620 */       killCount = Integer.valueOf(0);
/*      */     }
/*  622 */     xKillInfo.put(Long.valueOf(loser), Integer.valueOf(killCount.intValue() + 1));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void setResult(int winCampId, Map<Integer, Long> campMvps)
/*      */   {
/*  633 */     this._xBattleData.getResult().setWinnercampid(winCampId);
/*  634 */     this._xBattleData.getResult().getCampmvps().clear();
/*  635 */     this._xBattleData.getResult().getCampmvps().putAll(campMvps);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   int getWinMvpAddPoint()
/*      */   {
/*  645 */     return (int)getBattleCfg().winCampMvpAddPoint;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   int getLoseMvpAddPoint()
/*      */   {
/*  655 */     return (int)getBattleCfg().loseCampMvpAddPoint;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   int getDrawMvpAddPoint()
/*      */   {
/*  665 */     return (int)getBattleCfg().drawCampMvpAddPoint;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   int getWinnerAddPoint()
/*      */   {
/*  675 */     return (int)getBattleCfg().winnerAddPoint;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   int getLoserAddPoint()
/*      */   {
/*  685 */     return (int)getBattleCfg().loserAddPoint;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   int getDrawAddPoint()
/*      */   {
/*  695 */     return (int)getBattleCfg().drawAddPoint;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void setRoleState(long roleId, int campId, int state)
/*      */   {
/*  710 */     xbean.CampInfo xCampInfo = (xbean.CampInfo)this._xBattleData.getCampinfos().get(Integer.valueOf(campId));
/*  711 */     if (xCampInfo == null)
/*      */     {
/*  713 */       return;
/*      */     }
/*  715 */     roleBattleData xRoleBattleData = (roleBattleData)xCampInfo.getRolebattledatas().get(Long.valueOf(roleId));
/*  716 */     if (xRoleBattleData == null)
/*      */     {
/*  718 */       return;
/*      */     }
/*  720 */     xRoleBattleData.setState(state);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   boolean checkAndSetSurrender(int campId)
/*      */   {
/*  731 */     xbean.CampInfo xCampInfo = (xbean.CampInfo)this._xBattleData.getCampinfos().get(Integer.valueOf(campId));
/*  732 */     if (xCampInfo == null)
/*      */     {
/*  734 */       return false;
/*      */     }
/*  736 */     if (xCampInfo.getSurrender())
/*      */     {
/*  738 */       return true;
/*      */     }
/*  740 */     for (Map.Entry<Long, roleBattleData> entry : xCampInfo.getRolebattledatas().entrySet())
/*      */     {
/*  742 */       roleBattleData xRoleBattleData = (roleBattleData)entry.getValue();
/*  743 */       if (xRoleBattleData.getState() == 1)
/*      */       {
/*  745 */         return false;
/*      */       }
/*      */     }
/*      */     
/*  749 */     xCampInfo.setSurrender(true);
/*  750 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   boolean isSurrender(int campId)
/*      */   {
/*  761 */     xbean.CampInfo xCampInfo = (xbean.CampInfo)this._xBattleData.getCampinfos().get(Integer.valueOf(campId));
/*  762 */     if (xCampInfo == null)
/*      */     {
/*  764 */       return false;
/*      */     }
/*  766 */     return xCampInfo.getSurrender();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   boolean addCampSource(int campId, int value)
/*      */   {
/*  778 */     if (value == 0)
/*      */     {
/*  780 */       return true;
/*      */     }
/*  782 */     if (value < 0)
/*      */     {
/*  784 */       GameServer.logger().error(String.format("[singlebattle]SingleBattleGlobalInfo.addToCampTotalSource@ value illegal!|campId=%d|value=%d", new Object[] { Integer.valueOf(campId), Integer.valueOf(value) }));
/*      */       
/*      */ 
/*      */ 
/*  788 */       return false;
/*      */     }
/*  790 */     xbean.CampInfo xCampInfo = (xbean.CampInfo)this._xBattleData.getCampinfos().get(Integer.valueOf(campId));
/*  791 */     if (xCampInfo == null)
/*      */     {
/*  793 */       GameServer.logger().error(String.format("[singlebattle]SingleBattleGlobalInfo.addToCampTotalSource@ no camp!|campId=%d|value=%d", new Object[] { Integer.valueOf(campId), Integer.valueOf(value) }));
/*      */       
/*      */ 
/*  796 */       return false;
/*      */     }
/*  798 */     xCampInfo.setSource(xCampInfo.getSource() + value);
/*  799 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   boolean addRolePoint(int campId, long roleId, int value)
/*      */   {
/*  812 */     if (value == 0)
/*      */     {
/*  814 */       return true;
/*      */     }
/*  816 */     if (value < 0)
/*      */     {
/*  818 */       GameServer.logger().error(String.format("[singlebattle]SingleBattleGlobalInfo.addRolePoint@ value illegal!|campId=%d|roleId=%d|value=%d", new Object[] { Integer.valueOf(campId), Long.valueOf(roleId), Integer.valueOf(value) }));
/*      */       
/*      */ 
/*      */ 
/*  822 */       return false;
/*      */     }
/*  824 */     roleBattleData xRoleBattleData = getXRoleBattleData(campId, roleId);
/*  825 */     if (xRoleBattleData == null)
/*      */     {
/*  827 */       GameServer.logger().error(String.format("[singlebattle]SingleBattleGlobalInfo.addRolePoint@ no this member!|campId=%d|roleId=%d", new Object[] { Integer.valueOf(campId), Long.valueOf(roleId) }));
/*      */       
/*      */ 
/*  830 */       return false;
/*      */     }
/*  832 */     xRoleBattleData.setPoint(xRoleBattleData.getPoint() + value);
/*  833 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   boolean cutRolePoint(int campId, long roleId, int value)
/*      */   {
/*  846 */     if (value == 0)
/*      */     {
/*  848 */       return true;
/*      */     }
/*  850 */     if (value < 0)
/*      */     {
/*  852 */       GameServer.logger().error(String.format("[singlebattle]SingleBattleGlobalInfo.addRolePoint@ value illegal!|campId=%d|roleId=%d|value=%d", new Object[] { Integer.valueOf(campId), Long.valueOf(roleId), Integer.valueOf(value) }));
/*      */       
/*      */ 
/*      */ 
/*  856 */       return false;
/*      */     }
/*  858 */     roleBattleData xRoleBattleData = getXRoleBattleData(campId, roleId);
/*  859 */     if (xRoleBattleData == null)
/*      */     {
/*  861 */       GameServer.logger().error(String.format("[singlebattle]SingleBattleGlobalInfo.addRolePoint@ no this member!|campId=%d|roleId=%d", new Object[] { Integer.valueOf(campId), Long.valueOf(roleId) }));
/*      */       
/*      */ 
/*  864 */       return false;
/*      */     }
/*  866 */     int finalPoint = xRoleBattleData.getPoint() - value;
/*  867 */     if (finalPoint <= 0)
/*      */     {
/*  869 */       finalPoint = 0;
/*      */     }
/*  871 */     xRoleBattleData.setPoint(finalPoint);
/*  872 */     return true;
/*      */   }
/*      */   
/*      */   private roleBattleData getXRoleBattleData(int campId, long roleId)
/*      */   {
/*  877 */     xbean.CampInfo xCampInfo = (xbean.CampInfo)this._xBattleData.getCampinfos().get(Integer.valueOf(campId));
/*  878 */     if (xCampInfo == null)
/*      */     {
/*  880 */       GameServer.logger().error(String.format("[singlebattle]SingleBattleGlobalInfo.addRolePoint@ no camp!|campId=%d|roleId=%d", new Object[] { Integer.valueOf(campId), Long.valueOf(roleId) }));
/*      */       
/*      */ 
/*  883 */       return null;
/*      */     }
/*  885 */     return (roleBattleData)xCampInfo.getRolebattledatas().get(Long.valueOf(roleId));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   int getRolePoint(long roleId, int campId)
/*      */   {
/*  897 */     xbean.CampInfo xCampInfo = (xbean.CampInfo)this._xBattleData.getCampinfos().get(Integer.valueOf(campId));
/*  898 */     if (xCampInfo == null)
/*      */     {
/*  900 */       return 0;
/*      */     }
/*  902 */     roleBattleData xRoleBattleData = (roleBattleData)xCampInfo.getRolebattledatas().get(Long.valueOf(roleId));
/*  903 */     if (xRoleBattleData == null)
/*      */     {
/*  905 */       return 0;
/*      */     }
/*  907 */     return xRoleBattleData.getPoint();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   SingleRecord getRoleSingleRecord(long roleId)
/*      */   {
/*  919 */     return (SingleRecord)this._xBattleData.getFightrecord().getRoleids().get(Long.valueOf(roleId));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   Pair<Integer, Integer> getCampEnter(int campId)
/*      */   {
/*  930 */     SCampCfg cfg = SCampCfg.get(campId);
/*  931 */     return new Pair(Integer.valueOf(cfg.enterX), Integer.valueOf(cfg.enterY));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void transferToBattle(long roleId, int campId, MapCallback<Boolean> callback)
/*      */   {
/*  944 */     Pair<Integer, Integer> location = getCampEnter(campId);
/*  945 */     MapInterface.transferToScene(roleId, getBattleWorldId(), getBattleMapId(), ((Integer)location.first).intValue(), ((Integer)location.second).intValue(), callback);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void transferToBattle(long roleId, int campId)
/*      */   {
/*  958 */     Pair<Integer, Integer> location = getCampEnter(campId);
/*  959 */     MapInterface.transferToScene(roleId, getBattleWorldId(), getBattleMapId(), ((Integer)location.first).intValue(), ((Integer)location.second).intValue());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void synBattleInfo(long roleId)
/*      */   {
/*  971 */     SSynBattleTotalInfo syn = new SSynBattleTotalInfo();
/*      */     
/*  973 */     syn.battlecfgid = getBattleCfgId();
/*  974 */     syn.starttime = ((int)(getStartTime() / 1000L));
/*  975 */     syn.stage = getStage();
/*      */     
/*  977 */     for (Map.Entry<Integer, xbean.CampInfo> entry : this._xBattleData.getCampinfos().entrySet())
/*      */     {
/*  979 */       syn.campinfos.put(entry.getKey(), getCampGlobalInfo(((Integer)entry.getKey()).intValue(), (xbean.CampInfo)entry.getValue()));
/*      */     }
/*      */     
/*  982 */     OnlineManager.getInstance().send(roleId, syn);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   void battleSourceInfoBro()
/*      */   {
/*  990 */     SSynBattleGlobalInfo bro = new SSynBattleGlobalInfo();
/*  991 */     for (Map.Entry<Integer, xbean.CampInfo> entry : this._xBattleData.getCampinfos().entrySet())
/*      */     {
/*  993 */       bro.campinfos.put(entry.getKey(), getCampInfo((xbean.CampInfo)entry.getValue()));
/*      */     }
/*  995 */     battleBro(bro, false);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   CampGlobalInfo getCampGlobalInfo(int campId, xbean.CampInfo xCampInfo)
/*      */   {
/* 1009 */     CampGlobalInfo info = new CampGlobalInfo();
/* 1010 */     info.campinfo = getCampInfo(xCampInfo);
/* 1011 */     for (Iterator i$ = getCampAllMembers(campId).iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*      */       
/* 1013 */       if (RoleInterface.isRoleExit(roleId))
/*      */       {
/*      */ 
/*      */ 
/*      */ 
/* 1018 */         info.roleinfos.put(Long.valueOf(roleId), getRoleTotalInfo(roleId, campId)); }
/*      */     }
/* 1020 */     return info;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   mzm.gsp.singlebattle.CampInfo getCampInfo(xbean.CampInfo xCampInfo)
/*      */   {
/* 1032 */     mzm.gsp.singlebattle.CampInfo campInfo = new mzm.gsp.singlebattle.CampInfo();
/* 1033 */     campInfo.totalsource = xCampInfo.getSource();
/*      */     
/* 1035 */     return campInfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   RoleTotalInfo getRoleTotalInfo(long roleId, int campId)
/*      */   {
/* 1048 */     RoleTotalInfo roleTotalInfo = new RoleTotalInfo();
/* 1049 */     roleTotalInfo.baseinfo = getRoleBaseInfo(roleId, campId);
/* 1050 */     roleTotalInfo.fightrecord = getFightRecord(roleId);
/* 1051 */     return roleTotalInfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   RoleBaseInfo getRoleBaseInfo(long roleId, int campId)
/*      */   {
/* 1064 */     RoleBaseInfo roleBaseInfo = new RoleBaseInfo();
/* 1065 */     Role role = RoleInterface.getRole(roleId, false);
/* 1066 */     roleBaseInfo.gender = role.getGender();
/* 1067 */     roleBaseInfo.level = role.getLevel();
/* 1068 */     roleBaseInfo.occupation = role.getOccupationId();
/* 1069 */     roleBaseInfo.state = getRoleState(roleId, campId);
/* 1070 */     roleBaseInfo.avatarid = mzm.gsp.avatar.main.AvatarInterface.getCurrentAvatar(roleId);
/* 1071 */     roleBaseInfo.avatarframeid = AvatarFrameInterface.getCurrentAvatarFrameId(roleId, false);
/*      */     try
/*      */     {
/* 1074 */       roleBaseInfo.name.setString(role.getName(), "UTF-8");
/*      */     }
/*      */     catch (UnsupportedEncodingException e) {}
/*      */     
/*      */ 
/*      */ 
/* 1080 */     roleBaseInfo.num = SingleBattleInterface.getRoleNumber(roleId);
/* 1081 */     roleBaseInfo.zoneid = mzm.gsp.GameServerInfoManager.getZoneidFromRoleid(roleId);
/* 1082 */     return roleBaseInfo;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   FightRecord getFightRecord(long roleId)
/*      */   {
/* 1094 */     FightRecord fightRecord = new FightRecord();
/* 1095 */     SingleRecord xSingleRecord = getRoleSingleRecord(roleId);
/* 1096 */     if (xSingleRecord != null)
/*      */     {
/* 1098 */       int totalKillCount = 0;
/* 1099 */       for (Iterator i$ = xSingleRecord.getDead2count().values().iterator(); i$.hasNext();) { int killCount = ((Integer)i$.next()).intValue();
/*      */         
/* 1101 */         totalKillCount += killCount;
/*      */       }
/* 1103 */       int totalDeadCount = 0;
/* 1104 */       for (Iterator i$ = xSingleRecord.getKiller2count().values().iterator(); i$.hasNext();) { int deadCount = ((Integer)i$.next()).intValue();
/*      */         
/* 1106 */         totalDeadCount += deadCount;
/*      */       }
/*      */       
/* 1109 */       fightRecord.killcount = totalKillCount;
/* 1110 */       fightRecord.diecount = totalDeadCount;
/* 1111 */       fightRecord.revivetime = ((int)(xSingleRecord.getRevivetime() / 1000L));
/*      */     }
/* 1113 */     return fightRecord;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void roleTotalInfoBro(long roleId, int campId)
/*      */   {
/* 1124 */     xbean.CampInfo xCampInfo = (xbean.CampInfo)this._xBattleData.getCampinfos().get(Integer.valueOf(campId));
/* 1125 */     if (xCampInfo == null)
/*      */     {
/* 1127 */       return;
/*      */     }
/* 1129 */     SNewGuyTotalInfoBro bro = new SNewGuyTotalInfoBro();
/* 1130 */     bro.roleid = roleId;
/* 1131 */     bro.campid = campId;
/* 1132 */     bro.roletotalinfo = getRoleTotalInfo(roleId, campId);
/* 1133 */     battleBro(bro, false);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void roleJoinBattleBro(long roleId)
/*      */   {
/* 1143 */     battleBro(new mzm.gsp.singlebattle.SJoinBattleBro(roleId), false);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void roleOutLineBattleBro(long roleId)
/*      */   {
/* 1153 */     battleBro(new SLogoutBro(roleId), false);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   xbean.SingleBattleResult getXSingleBattleResult()
/*      */   {
/* 1163 */     return this._xBattleData.getResult();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   SingleBattleResult getSingleBattleResult()
/*      */   {
/* 1173 */     xbean.SingleBattleResult xResult = getXSingleBattleResult();
/* 1174 */     SingleBattleResult res = new SingleBattleResult(getBattleCfgId(), getBattleId(), xResult.getWinnercampid(), xResult.getCampmvps(), getBattleContext());
/*      */     
/* 1176 */     for (Map.Entry<Integer, xbean.CampInfo> campEntry : this._xBattleData.getCampinfos().entrySet())
/*      */     {
/* 1178 */       campId = ((Integer)campEntry.getKey()).intValue();
/* 1179 */       xbean.CampInfo xCampInfo = (xbean.CampInfo)campEntry.getValue();
/*      */       
/* 1181 */       for (Map.Entry<Long, roleBattleData> entry : xCampInfo.getRolebattledatas().entrySet())
/*      */       {
/* 1183 */         long roleId = ((Long)entry.getKey()).longValue();
/* 1184 */         int point = ((roleBattleData)entry.getValue()).getPoint();
/*      */         
/* 1186 */         res.addRoleInfo(roleId, campId, point + getExtroAddPoint(roleId, campId, xResult));
/*      */       } }
/*      */     int campId;
/* 1189 */     return res;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void addSessionPrepare(long sessionId)
/*      */   {
/* 1199 */     this._xBattleData.getSessions().setSessionprepareid(sessionId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   void removeSessionPrepare()
/*      */   {
/* 1207 */     removeSession(this._xBattleData.getSessions().getSessionprepareid());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void addSessionPlayEnd(long sessionId)
/*      */   {
/* 1217 */     this._xBattleData.getSessions().setSessionbattleplayendid(sessionId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   void removeSessionPlayEnd()
/*      */   {
/* 1225 */     removeSession(this._xBattleData.getSessions().getSessionbattleplayendid());
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   void addSessionBattleEnd(long sessionId)
/*      */   {
/* 1235 */     this._xBattleData.getSessions().setSessionbettlerealendid(sessionId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   void removeSessionBattleEnd()
/*      */   {
/* 1243 */     removeSession(this._xBattleData.getSessions().getSessionbettlerealendid());
/*      */   }
/*      */   
/*      */   private void removeSession(long sessionId)
/*      */   {
/* 1248 */     mzm.gsp.timer.main.Session.removeSession(sessionId);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   void removeAllBattleSesssion()
/*      */   {
/* 1256 */     removeSessionPrepare();
/* 1257 */     removeSessionPlayEnd();
/* 1258 */     removeSessionBattleEnd();
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private int getExtroAddPoint(long roleId, int campId, xbean.SingleBattleResult xResult)
/*      */   {
/* 1271 */     int addPoint = 0;
/* 1272 */     int winnerCampId = xResult.getWinnercampid();
/* 1273 */     Long mvp = (Long)xResult.getCampmvps().get(Integer.valueOf(campId));
/* 1274 */     if (mvp == null)
/*      */     {
/*      */ 
/* 1277 */       return 0;
/*      */     }
/* 1279 */     if (winnerCampId == 0)
/*      */     {
/*      */ 
/* 1282 */       addPoint += getDrawAddPoint();
/* 1283 */       if (mvp.longValue() == roleId)
/*      */       {
/* 1285 */         addPoint += getDrawMvpAddPoint();
/*      */       }
/*      */       
/*      */ 
/*      */     }
/* 1290 */     else if (campId == winnerCampId)
/*      */     {
/*      */ 
/* 1293 */       addPoint += getWinnerAddPoint();
/* 1294 */       if (mvp.longValue() == roleId)
/*      */       {
/* 1296 */         addPoint += getWinMvpAddPoint();
/*      */       }
/*      */       
/*      */     }
/*      */     else
/*      */     {
/* 1302 */       addPoint += getLoserAddPoint();
/* 1303 */       if (mvp.longValue() == roleId)
/*      */       {
/* 1305 */         addPoint += getLoseMvpAddPoint();
/*      */       }
/*      */     }
/*      */     
/* 1309 */     return addPoint;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private Set<Long> getStateMembers(int campId, int state)
/*      */   {
/* 1323 */     return getStateMembers(campId, Arrays.asList(new Integer[] { Integer.valueOf(state) }));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private Set<Long> getStateMembers(int campId, List<Integer> states)
/*      */   {
/* 1337 */     Map<Long, roleBattleData> allMemebrs = getCampMemers(campId);
/* 1338 */     if ((allMemebrs == null) || (allMemebrs.size() == 0))
/*      */     {
/* 1340 */       return Collections.emptySet();
/*      */     }
/* 1342 */     Set<Long> members = new HashSet();
/* 1343 */     for (Map.Entry<Long, roleBattleData> entry : allMemebrs.entrySet())
/*      */     {
/* 1345 */       if (states.contains(Integer.valueOf(((roleBattleData)entry.getValue()).getState())))
/*      */       {
/*      */ 
/*      */ 
/* 1349 */         members.add(entry.getKey()); }
/*      */     }
/* 1351 */     return members;
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\SingleBattleGlobalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */