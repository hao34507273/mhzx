/*     */ package mzm.gsp.paraselene.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*     */ import mzm.gsp.avatar.main.AvatarInterface;
/*     */ import mzm.gsp.award.MultiRoleAwardBean;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.idip.main.IdipManager;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.paraselene.JigsawInfo;
/*     */ import mzm.gsp.paraselene.PictureQuestionInfo;
/*     */ import mzm.gsp.paraselene.SAlreadyGetRewardRes;
/*     */ import mzm.gsp.paraselene.SErrorInfo;
/*     */ import mzm.gsp.paraselene.SFinishActivityRes;
/*     */ import mzm.gsp.paraselene.SFinishLayerTaskRes;
/*     */ import mzm.gsp.paraselene.SJigsawInfoRes;
/*     */ import mzm.gsp.paraselene.SLayerTaskFailed;
/*     */ import mzm.gsp.paraselene.SLeavefubenRes;
/*     */ import mzm.gsp.paraselene.SParaseleneActivityCloseRes;
/*     */ import mzm.gsp.paraselene.SParaseleneActivityOpenRes;
/*     */ import mzm.gsp.paraselene.SPassAllLayerRes;
/*     */ import mzm.gsp.paraselene.SPictureQuestionRes;
/*     */ import mzm.gsp.paraselene.SWordQuestionRes;
/*     */ import mzm.gsp.paraselene.WordQuestionInfo;
/*     */ import mzm.gsp.paraselene.confbean.SParaseleneActivitySeq;
/*     */ import mzm.gsp.paraselene.confbean.SParaseleneCfgConsts;
/*     */ import mzm.gsp.role.main.Role;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.AllWorlds;
/*     */ import xbean.Paraselene;
/*     */ import xbean.Pod;
/*     */ import xdb.Executor;
/*     */ import xdb.Lockeys;
/*     */ import xdb.Xdb;
/*     */ import xtable.Allparaworlds;
/*     */ import xtable.Role2paraselene;
/*     */ import xtable.Role2properties;
/*     */ import xtable.Team;
/*     */ import xtable.User;
/*     */ 
/*     */ public class ParaseleneManager
/*     */ {
/*  69 */   static final Logger logger = Logger.getLogger("Paraselene");
/*     */   
/*     */ 
/*     */   static void init() {}
/*     */   
/*     */ 
/*     */   static SParaseleneActivitySeq getParaseleneActivityBylayer(int layer)
/*     */   {
/*  77 */     return SParaseleneActivitySeq.get(layer);
/*     */   }
/*     */   
/*     */   static List<Integer> getMapids()
/*     */   {
/*  82 */     List<Integer> mapids = new ArrayList();
/*  83 */     for (SParaseleneActivitySeq p : SParaseleneActivitySeq.getAll().values())
/*     */     {
/*     */ 
/*  86 */       mapids.add(Integer.valueOf(p.mapid));
/*     */     }
/*  88 */     return mapids;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static Paraselene getParaselene(long roleid, boolean islock)
/*     */   {
/* 100 */     Paraselene paraselene = null;
/* 101 */     if (islock)
/*     */     {
/* 103 */       paraselene = Role2paraselene.get(Long.valueOf(roleid));
/*     */     }
/*     */     else
/*     */     {
/* 107 */       paraselene = Role2paraselene.select(Long.valueOf(roleid));
/*     */     }
/* 109 */     return paraselene;
/*     */   }
/*     */   
/*     */   static void sendErrorInfo(long roleid, int rescode)
/*     */   {
/* 114 */     SErrorInfo errorInfo = new SErrorInfo();
/* 115 */     errorInfo.errorcode = rescode;
/* 116 */     OnlineManager.getInstance().sendAtOnce(roleid, errorInfo);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean checkTeam(long roleId, long teamid)
/*     */   {
/* 128 */     List<Long> roles = TeamInterface.getNormalRoleList(roleId);
/* 129 */     Map<Long, String> roleidToUserid = new HashMap();
/* 130 */     for (Iterator i$ = roles.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*     */       
/* 132 */       roleidToUserid.put(Long.valueOf(tmpRoleId), RoleInterface.getUserId(tmpRoleId));
/*     */     }
/*     */     
/* 135 */     Lockeys.lock(User.getTable(), roleidToUserid.values());
/* 136 */     Lockeys.lock(Role2properties.getTable(), roles);
/* 137 */     TeamInfo teamInfo = TeamInterface.getTeamInfo(teamid, true);
/* 138 */     if (teamInfo == null)
/*     */     {
/* 140 */       sendErrorInfo(roleId, 1);
/* 141 */       return false;
/*     */     }
/* 143 */     boolean r = RoleStatusInterface.checkCansetStatus(roles, 12, true);
/* 144 */     if (!r)
/*     */     {
/* 146 */       return false;
/*     */     }
/* 148 */     List<Long> roleList = teamInfo.getTeamNormalList();
/*     */     
/* 150 */     if ((roles.size() != roleList.size()) || (!roles.containsAll(roleList)))
/*     */     {
/* 152 */       return false;
/*     */     }
/*     */     
/* 155 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(roleidToUserid, roleList, SParaseleneCfgConsts.getInstance().ActivityId);
/*     */     
/* 157 */     if (!res.isCanJoin())
/*     */     {
/* 159 */       if (res.isActivityNotOpen())
/*     */       {
/* 161 */         sendErrorInfo(roleId, 4);
/*     */       }
/* 163 */       if (res.isRoleLevelWrong())
/*     */       {
/* 165 */         sendErrorInfo(roleId, 3);
/*     */       }
/* 167 */       if (res.isPerSonCountWrong())
/*     */       {
/* 169 */         sendErrorInfo(roleId, 1);
/*     */       }
/* 171 */       return false;
/*     */     }
/* 173 */     if (!isParaseleneSwitchOpenForRole(roleId, roleList))
/*     */     {
/* 175 */       return false;
/*     */     }
/* 177 */     return true;
/*     */   }
/*     */   
/*     */   static SParaseleneActivitySeq getParaseleneActivityBynpcser(int npc, int npcservice)
/*     */   {
/* 182 */     for (SParaseleneActivitySeq sp : SParaseleneActivitySeq.getAll().values())
/*     */     {
/* 184 */       if ((sp.npcid == npc) && (sp.npcservice == npcservice))
/*     */       {
/* 186 */         return sp;
/*     */       }
/*     */     }
/*     */     
/* 190 */     return null;
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
/*     */ 
/*     */ 
/*     */   static boolean offerAwardOnTaskEnd(Map<Long, String> roleidToUserid, List<Long> roleList, List<Long> allRoleList, int layer, LogReason logReason)
/*     */   {
/* 207 */     SParaseleneActivitySeq p = getParaseleneActivityBylayer(layer);
/* 208 */     if (p == null)
/*     */     {
/* 210 */       String logstr = String.format("[paraselene]ParaseleneManager.offerAwardOnTaskEnd@SParaseleneActivitySeq not exists layer=%d", new Object[] { Integer.valueOf(layer) });
/*     */       
/* 212 */       logger.error(logstr);
/* 213 */       return false;
/*     */     }
/* 215 */     boolean hasFanpai = AwardPoolInterface.isSAwardPoolLibExists(p.awardpoollibid);
/*     */     
/* 217 */     List<String> toawardUsers = new ArrayList();
/* 218 */     List<Long> toawardRoles = new ArrayList();
/* 219 */     int size = roleidToUserid.size();
/*     */     
/* 221 */     Map<Long, SPassAllLayerRes> role2SPassAllLayerRes = new HashMap();
/*     */     
/* 223 */     for (int i = 0; i < size; i++)
/*     */     {
/* 225 */       long roleid = ((Long)roleList.get(i)).longValue();
/* 226 */       Paraselene paraselene = getParaselene(roleid, true);
/* 227 */       if (paraselene == null)
/*     */       {
/* 229 */         paraselene = Pod.newParaselene();
/*     */         
/* 231 */         Role2paraselene.insert(Long.valueOf(roleid), paraselene);
/*     */       }
/* 233 */       paraselene.setRecentlayer(layer);
/* 234 */       if (paraselene.getLayers().contains(Integer.valueOf(layer)))
/*     */       {
/* 236 */         SAlreadyGetRewardRes re = new SAlreadyGetRewardRes(layer);
/* 237 */         OnlineManager.getInstance().send(roleid, re);
/*     */       }
/*     */       else {
/* 240 */         toawardUsers.add(roleidToUserid.get(Long.valueOf(roleid)));
/* 241 */         toawardRoles.add(Long.valueOf(roleid));
/* 242 */         paraselene.setIsinfuben(true);
/* 243 */         paraselene.getLayers().add(Integer.valueOf(layer));
/* 244 */         if (paraselene.getLayers().containsAll(SParaseleneActivitySeq.getAll().keySet()))
/*     */         {
/* 246 */           if (!IdipManager.isBanRank(roleid, 10))
/*     */           {
/* 248 */             paraselene.setFinishtime(DateTimeUtils.getCurrTimeInMillis());
/*     */             
/* 250 */             rankRole(roleid, (int)TimeUnit.MILLISECONDS.toSeconds(paraselene.getFinishtime() - paraselene.getStarttime()));
/*     */             
/*     */ 
/* 253 */             SPassAllLayerRes res = new SPassAllLayerRes();
/* 254 */             role2SPassAllLayerRes.put(Long.valueOf(roleid), res);
/*     */             
/* 256 */             res.seconds = ((int)TimeUnit.MILLISECONDS.toSeconds(paraselene.getFinishtime() - paraselene.getStarttime()));
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/*     */ 
/* 262 */             String logstr = String.format("[paraselene]ParaseleneManager.offerAwardOnTaskEnd@role is is ban rank state|roleid=%d|startTime=%d|normalFinsihTime=%d", new Object[] { Long.valueOf(roleid), Long.valueOf(paraselene.getStarttime()), Long.valueOf(DateTimeUtils.getCurrTimeInMillis()) });
/*     */             
/*     */ 
/*     */ 
/* 266 */             logger.info(logstr);
/*     */             
/* 268 */             paraselene.setFinishtime(paraselene.getStarttime());
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 274 */     if (toawardRoles.isEmpty())
/*     */     {
/* 276 */       hasFanpai = false;
/*     */     }
/*     */     else
/*     */     {
/* 280 */       AwardInterface.award(p.rewardid, toawardUsers, toawardRoles, allRoleList, false, true, new mzm.gsp.award.main.AwardReason(logReason, p.rewardid));
/*     */       
/*     */ 
/* 283 */       List<Long> notAwardRoles = new ArrayList();
/* 284 */       for (Iterator i$ = allRoleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */         
/* 286 */         if ((IdipManager.isZeroProfit(roleid)) || (!toawardRoles.contains(Long.valueOf(roleid))))
/*     */         {
/* 288 */           notAwardRoles.add(Long.valueOf(roleid));
/*     */         }
/*     */       }
/*     */       
/* 292 */       if (hasFanpai)
/*     */       {
/* 294 */         List<AwardPoolResultData> resultDatas = AwardPoolInterface.getAwardPoolData(p.awardpoollibid);
/* 295 */         List<MultiRoleAwardBean> multiRoleAwardBeans = new ArrayList();
/* 296 */         for (AwardPoolResultData d : resultDatas)
/*     */         {
/* 298 */           if ((d.getItemMap() != null) && (d.getItemMap().size() > 0))
/*     */           {
/* 300 */             MultiRoleAwardBean bean = new MultiRoleAwardBean();
/* 301 */             bean.id = ((Integer)d.getItemMap().keySet().iterator().next()).intValue();
/* 302 */             bean.count = ((Integer)d.getItemMap().get(Integer.valueOf(bean.id))).intValue();
/* 303 */             multiRoleAwardBeans.add(bean);
/*     */           }
/*     */         }
/*     */         
/* 307 */         if ((multiRoleAwardBeans.size() > 0) && (!notAwardRoles.containsAll(allRoleList)))
/*     */         {
/* 309 */           mzm.gsp.award.main.MultiRoleSelectAwardContext context = new ParaseleneLiheContext(layer);
/* 310 */           AwardInterface.awardMultiRoleSelectAward(allRoleList, notAwardRoles, multiRoleAwardBeans, context, new mzm.gsp.tlog.TLogArg(logReason));
/*     */           
/* 312 */           hasFanpai = true;
/*     */         }
/*     */         else
/*     */         {
/* 316 */           hasFanpai = false;
/*     */         }
/*     */         
/*     */       }
/*     */       else
/*     */       {
/* 322 */         hasFanpai = false;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 327 */     for (Iterator i$ = role2SPassAllLayerRes.keySet().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 329 */       SPassAllLayerRes res = (SPassAllLayerRes)role2SPassAllLayerRes.get(Long.valueOf(roleId));
/* 330 */       res.isfanpai = (hasFanpai ? 1 : 0);
/* 331 */       OnlineManager.getInstance().send(roleId, res);
/*     */     }
/*     */     
/* 334 */     return hasFanpai;
/*     */   }
/*     */   
/*     */ 
/*     */   static void rankRole(long roleid, int seconds)
/*     */   {
/* 340 */     ParaseleneRankObj rankObj = new ParaseleneRankObj(roleid, seconds);
/*     */     
/* 342 */     ParaseleneRankManager.getInstance().rank(rankObj);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void transferToNextLayer(List<Long> roleList, int currentLayer)
/*     */   {
/* 354 */     boolean isInParaSelene = isInParaseleneWorld(((Long)roleList.get(0)).longValue());
/* 355 */     boolean isLastlayer = isLastTask(currentLayer);
/* 356 */     if ((isLastlayer) && (isInParaSelene))
/*     */     {
/*     */ 
/* 359 */       finishActivity(roleList);
/*     */ 
/*     */     }
/* 362 */     else if ((!isLastlayer) && (isInParaSelene))
/*     */     {
/* 364 */       SParaseleneActivitySeq sp = SParaseleneActivitySeq.get(currentLayer + 1);
/* 365 */       long roleworldid = MapInterface.getRoleWorldInstanceId(((Long)roleList.get(0)).longValue());
/*     */       
/* 367 */       new TransferSession(SParaseleneCfgConsts.getInstance().Seconds_To_Leave, sp.mapid, roleworldid);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getNextLayer(int currentLayer)
/*     */   {
/* 379 */     Map<Integer, SParaseleneActivitySeq> map = SParaseleneActivitySeq.getAll();
/* 380 */     if ((map instanceof TreeMap))
/*     */     {
/* 382 */       TreeMap<Integer, SParaseleneActivitySeq> treeMap = (TreeMap)map;
/* 383 */       Map.Entry<Integer, SParaseleneActivitySeq> entry = treeMap.higherEntry(Integer.valueOf(currentLayer));
/* 384 */       if (entry == null)
/*     */       {
/* 386 */         return -1;
/*     */       }
/* 388 */       return ((Integer)entry.getKey()).intValue();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 393 */     List<Integer> laysers = new ArrayList(map.keySet());
/* 394 */     Collections.sort(laysers);
/* 395 */     int index = laysers.indexOf(Integer.valueOf(currentLayer));
/* 396 */     if ((index == -1) || (index >= laysers.size() - 1))
/*     */     {
/* 398 */       return -1;
/*     */     }
/* 400 */     return ((Integer)laysers.get(index + 1)).intValue();
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
/*     */   static boolean isLastTask(int currentLayer)
/*     */   {
/* 413 */     Map<Integer, SParaseleneActivitySeq> map = SParaseleneActivitySeq.getAll();
/* 414 */     if (map.isEmpty())
/*     */     {
/* 416 */       return false;
/*     */     }
/*     */     
/* 419 */     if ((map instanceof TreeMap))
/*     */     {
/* 421 */       TreeMap<Integer, SParaseleneActivitySeq> treeMap = (TreeMap)map;
/*     */       
/* 423 */       return ((Integer)treeMap.lastKey()).intValue() == currentLayer;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/* 428 */     List<Integer> laysers = new ArrayList(map.keySet());
/* 429 */     if (laysers.isEmpty())
/*     */     {
/* 431 */       return false;
/*     */     }
/* 433 */     int maxLayer = ((Integer)Collections.max(laysers)).intValue();
/*     */     
/* 435 */     return maxLayer == currentLayer;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void broadcastActivityOpen()
/*     */   {
/* 446 */     SParaseleneActivityOpenRes res = new SParaseleneActivityOpenRes();
/* 447 */     OnlineManager.getInstance().sendAllAtOnce(res);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void broadcastActivityClose(int minute)
/*     */   {
/* 456 */     if (GameServerInfoManager.isRoamServer())
/*     */     {
/* 458 */       return;
/*     */     }
/* 460 */     SParaseleneActivityCloseRes res = new SParaseleneActivityCloseRes(minute);
/* 461 */     OnlineManager.getInstance().sendAllAtOnce(res);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static void onActivityEnd()
/*     */   {
/* 469 */     new ParaseleneActivityEndPro(null).execute();
/*     */   }
/*     */   
/*     */   private static class ParaseleneActivityEndPro
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 478 */       AllWorlds allWorlds = Allparaworlds.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 479 */       if (allWorlds == null)
/*     */       {
/* 481 */         return false;
/*     */       }
/*     */       
/* 484 */       for (Iterator i$ = allWorlds.getTeamid2worldid().values().iterator(); i$.hasNext();) { long worldid = ((Long)i$.next()).longValue();
/*     */         
/* 486 */         List<Long> roleList = MapInterface.getRoleList(worldid);
/* 487 */         NoneRealTimeTaskManager.getInstance().addTask(new ParaseleneManager.TransferOutAllRole(roleList, worldid));
/*     */       }
/*     */       
/* 490 */       Allparaworlds.remove(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 491 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class TransferOutAllRole extends LogicProcedure
/*     */   {
/*     */     private final List<Long> roleList;
/*     */     private final long worldid;
/*     */     
/*     */     public TransferOutAllRole(List<Long> roleList, long worldid)
/*     */     {
/* 502 */       this.roleList = roleList;
/* 503 */       this.worldid = worldid;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 509 */       lock(Role2properties.getTable(), this.roleList);
/*     */       
/* 511 */       Set<Long> teamids = new java.util.HashSet();
/*     */       
/* 513 */       for (Iterator i$ = this.roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */         
/* 515 */         Long teamid = TeamInterface.getTeamidByRoleid(r, false);
/* 516 */         if (teamid != null)
/*     */         {
/* 518 */           teamids.add(teamid);
/*     */         }
/*     */       }
/*     */       
/* 522 */       if (teamids.size() == 0)
/*     */       {
/* 524 */         for (Iterator i$ = this.roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */           
/* 526 */           ParaseleneManager.transferToWorld(r);
/*     */         }
/*     */         
/* 529 */         RoleStatusInterface.unsetStatus(this.roleList, 12);
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/*     */ 
/* 535 */         lock(Team.getTable(), teamids);
/* 536 */         for (Iterator i$ = teamids.iterator(); i$.hasNext();) { long teamid = ((Long)i$.next()).longValue();
/*     */           
/* 538 */           TeamInfo teamInfo = TeamInterface.getTeamInfo(teamid, true);
/* 539 */           List<Long> normalList = teamInfo.getTeamNormalList();
/* 540 */           this.roleList.removeAll(normalList);
/* 541 */           ParaseleneManager.transferToWorld(teamInfo.getLeaderId());
/* 542 */           new PUnsetParaseleneStatue(normalList).execute();
/*     */         }
/*     */         
/*     */ 
/* 546 */         for (Iterator i$ = this.roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */           
/* 548 */           ParaseleneManager.transferToWorld(r);
/*     */         }
/* 550 */         RoleStatusInterface.unsetStatus(this.roleList, 12);
/*     */       }
/*     */       
/*     */ 
/* 554 */       Xdb.executor().execute(new ParaseleneManager.DestroyWorldRunnable(this.worldid));
/* 555 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class DestroyWorldRunnable
/*     */     extends mzm.gsp.util.LogicRunnable
/*     */   {
/*     */     private long worldid;
/*     */     
/*     */     public DestroyWorldRunnable(long worldid)
/*     */     {
/* 566 */       this.worldid = worldid;
/*     */     }
/*     */     
/*     */     public void process()
/*     */       throws Exception
/*     */     {
/* 572 */       TeamInterface.unRegisterJoinTeam(this.worldid);
/*     */       
/* 574 */       MapInterface.destroyWorld(this.worldid);
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
/*     */   static long getWorldidByteamid(long teamid)
/*     */   {
/* 587 */     AllWorlds allWorlds = Allparaworlds.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 588 */     if (allWorlds == null)
/*     */     {
/* 590 */       allWorlds = Pod.newAllWorlds();
/* 591 */       Allparaworlds.insert(Long.valueOf(GameServerInfoManager.getLocalId()), allWorlds);
/*     */     }
/* 593 */     Long worldid = (Long)allWorlds.getTeamid2worldid().get(Long.valueOf(teamid));
/* 594 */     if (worldid == null)
/*     */     {
/*     */ 
/* 597 */       worldid = Long.valueOf(MapInterface.createWorld(getMapids()));
/* 598 */       allWorlds.getTeamid2worldid().put(Long.valueOf(teamid), worldid);
/*     */       
/* 600 */       ParaseleneTeamHandler teamHandler = new ParaseleneTeamHandler();
/* 601 */       TeamInterface.registerJoinTeam(worldid.longValue(), teamHandler);
/*     */     }
/*     */     
/*     */ 
/* 605 */     return worldid.longValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void finishActivity(List<Long> roleList)
/*     */   {
/* 616 */     SFinishActivityRes re = new SFinishActivityRes();
/* 617 */     re.seconds = SParaseleneCfgConsts.getInstance().Seconds_To_Leave;
/*     */     
/* 619 */     for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/*     */ 
/* 622 */       OnlineManager.getInstance().send(roleid, re);
/*     */     }
/*     */     
/* 625 */     new LeaveFubenObserver(SParaseleneCfgConsts.getInstance().Seconds_To_Leave, roleList);
/*     */   }
/*     */   
/*     */   static void sendOnTaskFailed(int layer, List<Long> roleids)
/*     */   {
/* 630 */     SLayerTaskFailed re = new SLayerTaskFailed();
/* 631 */     re.layer = layer;
/*     */     
/* 633 */     OnlineManager.getInstance().sendMulti(re, roleids);
/*     */   }
/*     */   
/*     */ 
/*     */   static void sendOnTaskSuccess(int layer, List<Long> roleids)
/*     */   {
/* 639 */     SFinishLayerTaskRes re = new SFinishLayerTaskRes();
/* 640 */     re.layer = layer;
/*     */     
/* 642 */     OnlineManager.getInstance().sendMulti(re, roleids);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   static void transferToWorld(long roleId)
/*     */   {
/* 649 */     long w = MapInterface.getCenterWorldid();
/* 650 */     MapInterface.transferToScene(roleId, w, SParaseleneCfgConsts.getInstance().SEND_OUT_MAPID);
/*     */     
/* 652 */     SLeavefubenRes res = new SLeavefubenRes();
/* 653 */     OnlineManager.getInstance().send(roleId, res);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendWordQuestionRes(List<Long> roleids, int totalnum, Map<Long, Integer> rightNumMap, boolean issuccess)
/*     */   {
/* 663 */     SWordQuestionRes res = new SWordQuestionRes();
/* 664 */     res.seconds = SParaseleneCfgConsts.getInstance().Seconds_To_Close_Panel;
/* 665 */     res.issuccess = (issuccess ? 1 : 0);
/* 666 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */       
/* 668 */       WordQuestionInfo w = new WordQuestionInfo();
/* 669 */       Role role = RoleInterface.getRole(r, false);
/* 670 */       w.level = role.getLevel();
/* 671 */       w.name = role.getName();
/* 672 */       w.sex = role.getGender();
/* 673 */       w.occupation = role.getOccupationId();
/* 674 */       w.roleid = r;
/* 675 */       w.rightnum = (rightNumMap.get(Long.valueOf(r)) == null ? 0 : ((Integer)rightNumMap.get(Long.valueOf(r))).intValue());
/* 676 */       w.totalnum = totalnum;
/* 677 */       w.avatarid = AvatarInterface.getCurrentAvatar(r, false);
/* 678 */       w.avatarframeid = AvatarFrameInterface.getCurrentAvatarFrameId(r, false);
/* 679 */       res.wordquestionres.add(w);
/*     */     }
/* 681 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */       
/* 683 */       OnlineManager.getInstance().send(r, res);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendPictureQuestionRes(Map<Long, Integer> roleScoreMap, boolean issuccess)
/*     */   {
/* 695 */     SPictureQuestionRes res = new SPictureQuestionRes();
/* 696 */     res.seconds = SParaseleneCfgConsts.getInstance().Seconds_To_Close_Panel;
/* 697 */     res.issuccess = (issuccess ? 1 : 0);
/* 698 */     for (Iterator i$ = roleScoreMap.keySet().iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */       
/* 700 */       PictureQuestionInfo p = new PictureQuestionInfo();
/* 701 */       Role role = RoleInterface.getRole(r, false);
/* 702 */       p.level = role.getLevel();
/* 703 */       p.name = role.getName();
/* 704 */       p.sex = role.getGender();
/* 705 */       p.occupation = role.getOccupationId();
/* 706 */       p.roleid = r;
/* 707 */       p.point = ((Integer)roleScoreMap.get(Long.valueOf(r))).intValue();
/* 708 */       p.avatarid = AvatarInterface.getCurrentAvatar(r, false);
/* 709 */       p.avatarframeid = AvatarFrameInterface.getCurrentAvatarFrameId(r, false);
/* 710 */       res.picturequestionres.add(p);
/*     */     }
/* 712 */     for (Iterator i$ = roleScoreMap.keySet().iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */       
/* 714 */       OnlineManager.getInstance().send(r, res);
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
/*     */   static boolean isInParaseleneWorld(long roleid)
/*     */   {
/* 727 */     long roleworldid = MapInterface.getRoleWorldInstanceId(roleid);
/* 728 */     if (roleworldid == -1L)
/*     */     {
/* 730 */       return false;
/*     */     }
/* 732 */     AllWorlds allWorlds = Allparaworlds.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 733 */     if (allWorlds == null)
/*     */     {
/* 735 */       return false;
/*     */     }
/* 737 */     return allWorlds.getTeamid2worldid().values().contains(Long.valueOf(roleworldid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isParaseleneWorld(long worldid)
/*     */   {
/* 749 */     AllWorlds allWorlds = Allparaworlds.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 750 */     if (allWorlds == null)
/*     */     {
/* 752 */       return false;
/*     */     }
/* 754 */     return allWorlds.getTeamid2worldid().values().contains(Long.valueOf(worldid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isParaseleneMap(int mapid)
/*     */   {
/* 765 */     return getMapids().contains(Integer.valueOf(mapid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sendjigsawRes(List<Long> sucroleids, List<Long> failroleids, boolean issuccsee)
/*     */   {
/* 776 */     SJigsawInfoRes res = new SJigsawInfoRes();
/* 777 */     res.seconds = SParaseleneCfgConsts.getInstance().Seconds_To_Close_Panel;
/* 778 */     res.issuccess = (issuccsee ? 1 : 0);
/* 779 */     for (Iterator i$ = sucroleids.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */       
/* 781 */       JigsawInfo w = getJigsawInfo(r, 1);
/* 782 */       res.jigsawinfores.add(w);
/*     */     }
/* 784 */     for (Iterator i$ = failroleids.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */       
/* 786 */       JigsawInfo w = getJigsawInfo(r, 0);
/* 787 */       res.jigsawinfores.add(w);
/*     */     }
/* 789 */     for (Iterator i$ = sucroleids.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */       
/* 791 */       OnlineManager.getInstance().sendAtOnce(r, res);
/*     */     }
/* 793 */     for (Iterator i$ = failroleids.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */       
/* 795 */       OnlineManager.getInstance().sendAtOnce(r, res);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static JigsawInfo getJigsawInfo(long roleid, int ispass)
/*     */   {
/* 802 */     JigsawInfo w = new JigsawInfo();
/* 803 */     Role role = RoleInterface.getRole(roleid, false);
/* 804 */     w.level = role.getLevel();
/* 805 */     w.name = role.getName();
/* 806 */     w.sex = role.getGender();
/* 807 */     w.occupation = role.getOccupationId();
/* 808 */     w.roleid = roleid;
/* 809 */     w.ispass = ispass;
/* 810 */     w.avatarid = AvatarInterface.getCurrentAvatar(roleid, false);
/* 811 */     w.avatarframeid = AvatarFrameInterface.getCurrentAvatarFrameId(roleid, false);
/* 812 */     return w;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void logActivityAndAddCount(Map<Long, String> roleidToUserid, List<Long> rolelist)
/*     */   {
/* 822 */     for (Iterator i$ = rolelist.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */       
/* 824 */       ActivityInterface.addActivityCount((String)roleidToUserid.get(Long.valueOf(r)), r, SParaseleneCfgConsts.getInstance().ActivityId);
/* 825 */       ActivityInterface.logActivity(r, SParaseleneCfgConsts.getInstance().ActivityId, ActivityLogStatus.FINISH);
/* 826 */       ActivityInterface.tlogActivity(r, SParaseleneCfgConsts.getInstance().ActivityId, ActivityLogStatus.FINISH);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isPassedActivity(long roleid)
/*     */   {
/* 838 */     Paraselene paraselene = getParaselene(roleid, false);
/* 839 */     if (paraselene == null)
/*     */     {
/* 841 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 845 */     return paraselene.getLayers().containsAll(SParaseleneActivitySeq.getAll().keySet());
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
/*     */   static boolean canAcceptLayerTask(long roleid, int layer)
/*     */   {
/* 858 */     Paraselene paraselene = getParaselene(roleid, true);
/* 859 */     if (paraselene == null)
/*     */     {
/* 861 */       return true;
/*     */     }
/*     */     
/*     */ 
/* 865 */     if ((paraselene.getRecentlayer() == layer) && (paraselene.getLayers().contains(Integer.valueOf(layer))))
/*     */     {
/* 867 */       return false;
/*     */     }
/*     */     
/*     */ 
/* 871 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static long getActivityStartTime()
/*     */   {
/* 879 */     return ActivityInterface.getActivityStartTime(SParaseleneCfgConsts.getInstance().ActivityId);
/*     */   }
/*     */   
/*     */ 
/*     */   static void clearRankData()
/*     */   {
/* 885 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 891 */         ParaseleneRankManager.getInstance().clear();
/* 892 */         return true;
/*     */       }
/*     */     }.execute();
/*     */   }
/*     */   
/*     */   static int getRoleFinishtime(long roleid)
/*     */   {
/* 899 */     Paraselene paraselene = Role2paraselene.select(Long.valueOf(roleid));
/* 900 */     if (paraselene == null)
/*     */     {
/* 902 */       return 0;
/*     */     }
/* 904 */     return (int)TimeUnit.MILLISECONDS.toSeconds(paraselene.getFinishtime() - paraselene.getStarttime());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isParaseleneSwitchOpenForRole(long leaderRoleid, List<Long> roleids)
/*     */   {
/* 916 */     if (!OpenInterface.getOpenStatus(12))
/*     */     {
/* 918 */       return false;
/*     */     }
/* 920 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/* 922 */       if (OpenInterface.isBanPlay(roleid, 12))
/*     */       {
/* 924 */         OpenInterface.sendBanPlayMsg(leaderRoleid, roleid, RoleInterface.getName(roleid), 12);
/*     */         
/*     */ 
/* 927 */         return false;
/*     */       }
/*     */     }
/*     */     
/* 931 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\paraselene\main\ParaseleneManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */