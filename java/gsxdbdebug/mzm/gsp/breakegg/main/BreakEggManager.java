/*     */ package mzm.gsp.breakegg.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.avatar.frame.AvatarFrameInterface;
/*     */ import mzm.gsp.avatar.main.AvatarInterface;
/*     */ import mzm.gsp.award.AwardBean;
/*     */ import mzm.gsp.award.SSendDefaultAwardInfo;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.breakegg.RoleInfo;
/*     */ import mzm.gsp.breakegg.SBroadcastBreakEggRewardInfo;
/*     */ import mzm.gsp.breakegg.SSynBreakEggJoinInfo;
/*     */ import mzm.gsp.breakegg.SSynBreakEggRewardInfo;
/*     */ import mzm.gsp.breakegg.SSynRoleBreakEggInfo;
/*     */ import mzm.gsp.breakegg.randomreward.AbstractRandomPolicy;
/*     */ import mzm.gsp.breakegg.randomreward.RandomRewardInterface;
/*     */ import mzm.gsp.item.main.ItemInterface;
/*     */ import mzm.gsp.nationalholiday.confbean.SBreakEggCfg;
/*     */ import mzm.gsp.nationalholiday.confbean.SRewardWeightCfg;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BreakEggGameInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleCounterInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Breakegg_info;
/*     */ import xtable.Role2breakegg_info;
/*     */ import xtable.Role2counter;
/*     */ import xtable.Role2drawandguess_info;
/*     */ 
/*     */ public class BreakEggManager
/*     */ {
/*  49 */   static final Logger logger = Logger.getLogger("breakegg");
/*     */   
/*     */   static boolean isBreakEggSwitchOpen(int openId)
/*     */   {
/*  53 */     if (!OpenInterface.getOpenStatus(openId))
/*     */     {
/*  55 */       return false;
/*     */     }
/*  57 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isBreakEggSwitchOpen(long roleid, int openId)
/*     */   {
/*  68 */     if (!OpenInterface.getOpenStatus(openId))
/*     */     {
/*  70 */       return false;
/*     */     }
/*  72 */     if (OpenInterface.isBanPlay(roleid, openId))
/*     */     {
/*  74 */       OpenInterface.sendBanPlayMsg(roleid, openId);
/*  75 */       return false;
/*     */     }
/*  77 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isInBreakEgg(long roleId)
/*     */   {
/*  89 */     return Role2breakegg_info.select(Long.valueOf(roleId)) != null;
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
/*     */   static int addRoleCounterTimes(long roleId, int index, int changeTimes)
/*     */   {
/* 106 */     RoleCounterInfo xRoleCounterInfo = Role2counter.get(Long.valueOf(roleId));
/* 107 */     if (xRoleCounterInfo == null)
/*     */     {
/* 109 */       xRoleCounterInfo = Pod.newRoleCounterInfo();
/* 110 */       Role2counter.insert(Long.valueOf(roleId), xRoleCounterInfo);
/*     */     }
/* 112 */     Integer oldTimes = (Integer)xRoleCounterInfo.getCounter_info().get(Integer.valueOf(index));
/* 113 */     int nowTimes = (oldTimes == null ? 0 : oldTimes.intValue()) + changeTimes;
/* 114 */     xRoleCounterInfo.getCounter_info().put(Integer.valueOf(index), Integer.valueOf(nowTimes));
/* 115 */     return nowTimes;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getRoleCounter(long roleId, int index, boolean retainLock)
/*     */   {
/*     */     RoleCounterInfo xRoleCounterInfo;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */     RoleCounterInfo xRoleCounterInfo;
/*     */     
/*     */ 
/*     */ 
/* 133 */     if (retainLock)
/*     */     {
/* 135 */       xRoleCounterInfo = Role2counter.get(Long.valueOf(roleId));
/*     */     }
/*     */     else
/*     */     {
/* 139 */       xRoleCounterInfo = Role2counter.select(Long.valueOf(roleId));
/*     */     }
/* 141 */     if (xRoleCounterInfo == null)
/*     */     {
/* 143 */       return 0;
/*     */     }
/* 145 */     Integer nowTimes = (Integer)xRoleCounterInfo.getCounter_info().get(Integer.valueOf(index));
/* 146 */     return nowTimes == null ? 0 : nowTimes.intValue();
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
/*     */   static void clearRoleCounterTimes(long roleId, int index)
/*     */   {
/* 163 */     RoleCounterInfo xRoleCounterInfo = Role2counter.get(Long.valueOf(roleId));
/* 164 */     if (xRoleCounterInfo == null)
/*     */     {
/* 166 */       return;
/*     */     }
/* 168 */     Integer oldTimes = (Integer)xRoleCounterInfo.getCounter_info().get(Integer.valueOf(index));
/* 169 */     if (oldTimes == null)
/*     */     {
/* 171 */       return;
/*     */     }
/* 173 */     xRoleCounterInfo.getCounter_info().put(Integer.valueOf(index), Integer.valueOf(0));
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
/*     */   private static RoleInfo getRoleInfo(long roleId)
/*     */   {
/* 186 */     RoleInfo roleInfo = new RoleInfo();
/* 187 */     roleInfo.gender = RoleInterface.getGender(roleId);
/* 188 */     roleInfo.roleid = roleId;
/* 189 */     roleInfo.occupationid = RoleInterface.getOccupationId(roleId);
/* 190 */     roleInfo.rolename = RoleInterface.getName(roleId);
/* 191 */     roleInfo.avatarid = AvatarInterface.getCurrentAvatar(roleId, false);
/* 192 */     roleInfo.avatarframeid = AvatarFrameInterface.getCurrentAvatarFrameId(roleId, false);
/* 193 */     roleInfo.rolelevel = RoleInterface.getLevel(roleId);
/* 194 */     return roleInfo;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sSynBreakEggJoinInfo(final List<Long> receiveRoleIds, BreakEggGameInfo xBreakEggGameInfo)
/*     */   {
/* 205 */     final SSynBreakEggJoinInfo syn = new SSynBreakEggJoinInfo();
/* 206 */     syn.activity_id = xBreakEggGameInfo.getActivity_id();
/* 207 */     syn.inviter_id = ((Long)xBreakEggGameInfo.getRoleid_list().get(0)).longValue();
/* 208 */     syn.session_id = xBreakEggGameInfo.getSession_id();
/* 209 */     Session session = Session.getSession(xBreakEggGameInfo.getSession_id());
/* 210 */     if (session != null)
/*     */     {
/* 212 */       syn.end_time = TimeUnit.MILLISECONDS.toSeconds(session.getTimeoutTimestamp());
/*     */     }
/*     */     else
/*     */     {
/* 216 */       syn.end_time = TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis());
/*     */     }
/* 218 */     List<Long> allRoles = new ArrayList(xBreakEggGameInfo.getRoleid_list());
/* 219 */     new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 224 */         for (Iterator i$ = this.val$allRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */           
/* 226 */           syn.role_info_list.add(BreakEggManager.getRoleInfo(roleId));
/*     */         }
/* 228 */         OnlineManager.getInstance().sendMulti(syn, receiveRoleIds);
/* 229 */         return true;
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
/*     */   static void sSynBreakEggRewardInfo(List<Long> receiveRoleIds, BreakEggGameInfo xBreakEggGameInfo)
/*     */   {
/* 243 */     SSynBreakEggRewardInfo syn = new SSynBreakEggRewardInfo();
/* 244 */     syn.activity_id = xBreakEggGameInfo.getActivity_id();
/*     */     
/* 246 */     for (Map.Entry<Integer, xbean.BreakEggInfo> entry : xBreakEggGameInfo.getIndex2break_egg_info().entrySet())
/*     */     {
/* 248 */       mzm.gsp.breakegg.BreakEggInfo breakEggInfo = new mzm.gsp.breakegg.BreakEggInfo();
/* 249 */       breakEggInfo.role_id = ((xbean.BreakEggInfo)entry.getValue()).getRole_id();
/* 250 */       breakEggInfo.itemid2num.putAll(((xbean.BreakEggInfo)entry.getValue()).getItemid2num());
/* 251 */       syn.index2break_egg_info.put(entry.getKey(), breakEggInfo);
/*     */     }
/* 253 */     OnlineManager.getInstance().sendMulti(syn, receiveRoleIds);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sSynBreakEggRewardIndex(List<Integer> indexList, BreakEggGameInfo xBreakEggGameInfo)
/*     */   {
/* 265 */     SSynBreakEggRewardInfo syn = new SSynBreakEggRewardInfo();
/* 266 */     syn.activity_id = xBreakEggGameInfo.getActivity_id();
/*     */     
/*     */ 
/* 269 */     for (Integer index : indexList)
/*     */     {
/* 271 */       xbean.BreakEggInfo xBreakEggInfo = (xbean.BreakEggInfo)xBreakEggGameInfo.getIndex2break_egg_info().get(index);
/* 272 */       mzm.gsp.breakegg.BreakEggInfo breakEggInfo = new mzm.gsp.breakegg.BreakEggInfo();
/* 273 */       breakEggInfo.role_id = xBreakEggInfo.getRole_id();
/* 274 */       breakEggInfo.itemid2num.putAll(xBreakEggInfo.getItemid2num());
/* 275 */       syn.index2break_egg_info.put(index, breakEggInfo);
/*     */     }
/* 277 */     OnlineManager.getInstance().sendMulti(syn, xBreakEggGameInfo.getRoleid_list());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void sBroadcastBreakEggReward(Set<Long> receiveRoleIds, BreakEggGameInfo xBreakEggGameInfo)
/*     */   {
/* 289 */     if ((receiveRoleIds == null) || (receiveRoleIds.size() <= 0))
/*     */     {
/* 291 */       return;
/*     */     }
/* 293 */     SBroadcastBreakEggRewardInfo syn = new SBroadcastBreakEggRewardInfo();
/* 294 */     syn.activity_id = xBreakEggGameInfo.getActivity_id();
/* 295 */     syn.inviter_id = xBreakEggGameInfo.getInviter_id();
/* 296 */     syn.inviter_name = RoleInterface.getName(xBreakEggGameInfo.getInviter_id());
/*     */     
/*     */ 
/* 299 */     for (Map.Entry<Integer, xbean.BreakEggInfo> entry : xBreakEggGameInfo.getIndex2break_egg_info().entrySet())
/*     */     {
/* 301 */       xbean.BreakEggInfo xBreakEggInfo = (xbean.BreakEggInfo)entry.getValue();
/* 302 */       if (xBreakEggInfo.getRole_id() > 0L)
/*     */       {
/*     */ 
/*     */ 
/* 306 */         mzm.gsp.breakegg.BreakEggInfo breakEggInfo = new mzm.gsp.breakegg.BreakEggInfo();
/* 307 */         breakEggInfo.role_id = xBreakEggInfo.getRole_id();
/* 308 */         breakEggInfo.role_name = RoleInterface.getName(xBreakEggInfo.getRole_id());
/* 309 */         breakEggInfo.itemid2num.putAll(xBreakEggInfo.getItemid2num());
/* 310 */         syn.break_egg_info.add(breakEggInfo);
/*     */       } }
/* 312 */     OnlineManager.getInstance().sendMulti(syn, receiveRoleIds);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void checkAndAutoBreak(BreakEggGameInfo xBreakEggGameInfo)
/*     */   {
/* 323 */     SBreakEggCfg sBreakEggCfg = SBreakEggCfg.get(xBreakEggGameInfo.getActivity_id());
/*     */     
/* 325 */     List<Integer> lessIndex = new ArrayList();
/* 326 */     for (int i = 0; i < sBreakEggCfg.totalEggNum; i++)
/*     */     {
/* 328 */       if (!xBreakEggGameInfo.getIndex2break_egg_info().containsKey(Integer.valueOf(i)))
/*     */       {
/* 330 */         lessIndex.add(Integer.valueOf(i));
/*     */       }
/*     */     }
/*     */     
/* 334 */     List<Long> autoBreakRoles = new ArrayList();
/* 335 */     for (Iterator i$ = xBreakEggGameInfo.getRoleid_list().iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*     */ 
/* 338 */       int maxBreakNum = getMaxBreakNum(roleId, xBreakEggGameInfo, sBreakEggCfg);
/*     */       
/* 340 */       int nowBreakNum = getNowBreakNum(roleId, xBreakEggGameInfo);
/* 341 */       for (int i = 0; i < maxBreakNum - nowBreakNum; i++)
/*     */       {
/* 343 */         autoBreakRoles.add(Long.valueOf(roleId));
/*     */       }
/*     */     }
/*     */     
/* 347 */     if (lessIndex.size() < autoBreakRoles.size())
/*     */     {
/* 349 */       logger.info(String.format("[breakegg]BreakEggManager.checkAndAutoBreak@ fail totalEggNum error |lessIndex=%d|autoBreakRoles=%d", new Object[] { Integer.valueOf(lessIndex.size()), Integer.valueOf(autoBreakRoles.size()) }));
/*     */       
/*     */ 
/* 352 */       return;
/*     */     }
/*     */     
/* 355 */     int InviterLevel = RoleInterface.getLevel(xBreakEggGameInfo.getInviter_id());
/*     */     
/*     */ 
/* 358 */     if (autoBreakRoles.size() > 0)
/*     */     {
/* 360 */       Collections.shuffle(lessIndex);
/* 361 */       for (int i = 0; i < autoBreakRoles.size(); i++)
/*     */       {
/*     */ 
/* 364 */         xbean.BreakEggInfo xBreakEggInfo = Pod.newBreakEggInfo();
/* 365 */         xBreakEggInfo.setRole_id(((Long)autoBreakRoles.get(i)).longValue());
/* 366 */         xBreakEggInfo.getItemid2num().putAll(getItemRewardInfo(xBreakEggGameInfo.getInviter_id(), InviterLevel, ((Integer)xBreakEggGameInfo.getReward_info_id().get(((Integer)lessIndex.get(i)).intValue())).intValue()));
/*     */         
/*     */ 
/* 369 */         xBreakEggGameInfo.getIndex2break_egg_info().put(lessIndex.get(i), xBreakEggInfo);
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 374 */     List<Integer> randomRewardResult = null;
/* 375 */     AbstractRandomPolicy<?> randomPolicy = RandomRewardInterface.getRandomPolicy(sBreakEggCfg.rewardRandomGroupId, null);
/*     */     
/* 377 */     if (randomPolicy != null)
/*     */     {
/* 379 */       randomRewardResult = randomPolicy.getRewardInfoIds(lessIndex.size() - autoBreakRoles.size(), true);
/*     */     }
/*     */     
/* 382 */     if ((randomRewardResult == null) || (randomRewardResult.size() < lessIndex.size() - autoBreakRoles.size()))
/*     */     {
/* 384 */       for (int i = autoBreakRoles.size(); i < lessIndex.size(); i++)
/*     */       {
/*     */ 
/* 387 */         xbean.BreakEggInfo xBreakEggInfo = Pod.newBreakEggInfo();
/* 388 */         xBreakEggInfo.setRole_id(-1L);
/* 389 */         xBreakEggInfo.getItemid2num().putAll(getItemRewardInfo(xBreakEggGameInfo.getInviter_id(), InviterLevel, ((Integer)xBreakEggGameInfo.getReward_info_id().get(((Integer)lessIndex.get(i)).intValue())).intValue()));
/*     */         
/*     */ 
/* 392 */         xBreakEggGameInfo.getIndex2break_egg_info().put(lessIndex.get(i), xBreakEggInfo);
/*     */       }
/*     */       
/*     */     }
/*     */     else
/*     */     {
/* 398 */       for (int i = 0; i < lessIndex.size() - autoBreakRoles.size(); i++)
/*     */       {
/*     */ 
/* 401 */         xbean.BreakEggInfo xBreakEggInfo = Pod.newBreakEggInfo();
/* 402 */         xBreakEggInfo.setRole_id(-1L);
/* 403 */         xBreakEggInfo.getItemid2num().putAll(getItemRewardInfo(xBreakEggGameInfo.getInviter_id(), InviterLevel, ((Integer)randomRewardResult.get(i)).intValue()));
/*     */         
/* 405 */         xBreakEggGameInfo.getIndex2break_egg_info().put(lessIndex.get(i + autoBreakRoles.size()), xBreakEggInfo);
/*     */       }
/*     */     }
/*     */     
/* 409 */     sSynBreakEggRewardIndex(lessIndex, xBreakEggGameInfo);
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
/*     */   static void sendReward(long roleId, xbean.BreakEggInfo xBreakEggInfo, LogReason logReason)
/*     */   {
/* 422 */     ItemInterface.addItem(roleId, xBreakEggInfo.getItemid2num(), false, new mzm.gsp.tlog.TLogArg(logReason));
/*     */     
/* 424 */     SSendDefaultAwardInfo protocol = new SSendDefaultAwardInfo();
/* 425 */     protocol.awardinfo.itemmap.putAll(xBreakEggInfo.getItemid2num());
/* 426 */     OnlineManager.getInstance().send(roleId, protocol);
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
/*     */   static Map<Integer, Integer> getItemRewardInfo(long roleId, int roleLevel, int sRewardWeightCfgId)
/*     */   {
/* 439 */     SRewardWeightCfg sRewardWeightCfg = SRewardWeightCfg.get(sRewardWeightCfgId);
/* 440 */     AwardPoolResultData awardPoolResultData = AwardPoolInterface.getAwardPoolData(sRewardWeightCfg.awardPoolId, roleId, roleLevel);
/*     */     
/* 442 */     return awardPoolResultData.getItemMap();
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
/*     */   static List<Long> getRewardRoleIdsAndAddTimes(Map<Long, String> roleidToUserid, long excludeId, int activityCfgId)
/*     */   {
/* 456 */     SBreakEggCfg sBreakEggCfg = SBreakEggCfg.get(activityCfgId);
/* 457 */     List<Long> rewardRoleIds = new ArrayList();
/*     */     
/* 459 */     for (Map.Entry<Long, String> entry : roleidToUserid.entrySet())
/*     */     {
/* 461 */       long roleId = ((Long)entry.getKey()).longValue();
/* 462 */       if (roleId != excludeId)
/*     */       {
/*     */ 
/*     */ 
/* 466 */         ActivityInterface.canJoinAndCheckInitActivityData((String)roleidToUserid.get(Long.valueOf(roleId)), roleId, activityCfgId);
/* 467 */         int roleCounter = BreakEggInterface.getRoleCounter(roleId, activityCfgId, true);
/* 468 */         if (roleCounter < sBreakEggCfg.inviteeRewardTimes)
/*     */         {
/* 470 */           rewardRoleIds.add(Long.valueOf(roleId));
/* 471 */           roleCounter = BreakEggInterface.addRoleCounterTimes(roleId, activityCfgId, 1);
/*     */         }
/*     */         
/* 474 */         SSynRoleBreakEggInfo sSynRoleBreakEggInfo = new SSynRoleBreakEggInfo();
/* 475 */         sSynRoleBreakEggInfo.activity_id = activityCfgId;
/* 476 */         sSynRoleBreakEggInfo.reward_times = roleCounter;
/* 477 */         OnlineManager.getInstance().send(roleId, sSynRoleBreakEggInfo);
/*     */       } }
/* 479 */     return rewardRoleIds;
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
/*     */   static void startBreakEgg(int activityCfgId, List<Long> memberIds)
/*     */   {
/* 493 */     SBreakEggCfg sBreakEggCfg = SBreakEggCfg.get(activityCfgId);
/* 494 */     if (sBreakEggCfg == null)
/*     */     {
/* 496 */       return;
/*     */     }
/*     */     
/* 499 */     if (!isBreakEggSwitchOpen(sBreakEggCfg.openId))
/*     */     {
/* 501 */       return;
/*     */     }
/*     */     
/* 504 */     AbstractRandomPolicy<?> randomPolicy = RandomRewardInterface.getRandomPolicy(sBreakEggCfg.rewardRandomGroupId, null);
/*     */     
/* 506 */     if (randomPolicy == null)
/*     */     {
/* 508 */       return;
/*     */     }
/*     */     
/* 511 */     List<Integer> randomRewardResult = randomPolicy.getRewardInfoIds(sBreakEggCfg.totalEggNum, false);
/* 512 */     if ((randomRewardResult == null) || (randomRewardResult.size() < sBreakEggCfg.totalEggNum))
/*     */     {
/* 514 */       return;
/*     */     }
/*     */     
/* 517 */     Lockeys.lock(Role2drawandguess_info.getTable(), memberIds);
/* 518 */     if ((memberIds == null) || (memberIds.size() == 0))
/*     */     {
/* 520 */       return;
/*     */     }
/* 522 */     for (Iterator i$ = memberIds.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/*     */ 
/* 525 */       if (isInBreakEgg(roleid))
/*     */       {
/* 527 */         String logstr = String.format("[breakegg]BreakEggManager.startBreakEgg@role already in break egg state!|activityCfgId=%d|roleid=%d", new Object[] { Integer.valueOf(activityCfgId), Long.valueOf(roleid) });
/*     */         
/*     */ 
/* 530 */         logger.info(logstr);
/* 531 */         return;
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 536 */     BreakEggGameInfo xBreakEggGameInfo = Pod.newBreakEggGameInfo();
/* 537 */     xBreakEggGameInfo.setActivity_id(activityCfgId);
/* 538 */     xBreakEggGameInfo.setInviter_id(((Long)memberIds.get(0)).longValue());
/* 539 */     xBreakEggGameInfo.getRoleid_list().addAll(memberIds);
/* 540 */     xBreakEggGameInfo.getReward_info_id().addAll(randomRewardResult);
/*     */     
/* 542 */     long breakEggId = Breakegg_info.insert(xBreakEggGameInfo).longValue();
/*     */     
/* 544 */     long sessionId = new BreakEggSession(sBreakEggCfg.breakCountdownTime, memberIds).getSessionId();
/* 545 */     xBreakEggGameInfo.setSession_id(sessionId);
/*     */     
/* 547 */     for (Iterator i$ = memberIds.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/* 549 */       Role2breakegg_info.insert(Long.valueOf(roleid), Long.valueOf(breakEggId));
/*     */     }
/*     */     
/* 552 */     RoleStatusInterface.setStatus(memberIds, 1864, false);
/*     */     
/* 554 */     sSynBreakEggJoinInfo(memberIds, xBreakEggGameInfo);
/*     */     
/* 556 */     String logstr = String.format("[breakegg]BreakEggManager.startBreakEgg@ success!!!!!|activityCfgId=%d|roleids=%s", new Object[] { Integer.valueOf(activityCfgId), memberIds });
/*     */     
/* 558 */     logger.info(logstr);
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
/*     */   static BreakEggGameInfo destroyBreakEggGameInfo(long roleId)
/*     */   {
/* 571 */     Long breakEggId = Role2breakegg_info.get(Long.valueOf(roleId));
/* 572 */     if (breakEggId == null)
/*     */     {
/* 574 */       return null;
/*     */     }
/*     */     
/* 577 */     BreakEggGameInfo xBreakEggGameInfo = Breakegg_info.get(breakEggId);
/*     */     
/* 579 */     if (xBreakEggGameInfo == null)
/*     */     {
/* 581 */       Role2breakegg_info.remove(Long.valueOf(roleId));
/* 582 */       return null;
/*     */     }
/*     */     
/* 585 */     Breakegg_info.remove(breakEggId);
/* 586 */     List<Long> allRoles = new ArrayList(xBreakEggGameInfo.getRoleid_list());
/*     */     
/* 588 */     new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 593 */         Lockeys.lock(Role2breakegg_info.getTable(), this.val$allRoles);
/* 594 */         for (Iterator i$ = this.val$allRoles.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */           
/* 596 */           Role2breakegg_info.remove(Long.valueOf(roleId));
/*     */           
/* 598 */           RoleStatusInterface.unsetStatus(roleId, 1864);
/*     */         }
/* 600 */         return true;
/*     */       }
/* 602 */     }.execute();
/* 603 */     return xBreakEggGameInfo;
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
/*     */   static int getMaxBreakNum(long roleId, BreakEggGameInfo xBreakEggGameInfo, SBreakEggCfg sBreakEggCfg)
/*     */   {
/* 616 */     return xBreakEggGameInfo.getInviter_id() == roleId ? sBreakEggCfg.inviterBreakNum : sBreakEggCfg.inviteeBreakNum;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getNowBreakNum(long roleId, BreakEggGameInfo xBreakEggGameInfo)
/*     */   {
/* 628 */     Integer nowBreakNum = (Integer)xBreakEggGameInfo.getRole_id2break_num().get(Long.valueOf(roleId));
/* 629 */     return nowBreakNum == null ? 0 : nowBreakNum.intValue();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\main\BreakEggManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */