/*     */ package mzm.gsp.zhenyao.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.activity.SZheyaoAwardCountToMaxRes;
/*     */ import mzm.gsp.activity.SisContinueZhenyao;
/*     */ import mzm.gsp.activity.confbean.ZhenYaoActivityCfgConsts;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.chivalry.main.ChivalryInterface;
/*     */ import mzm.gsp.guaji.main.GuajiInterface;
/*     */ import mzm.gsp.guaji.main.SwitchType;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.storageexp.main.StorageExpInterface;
/*     */ import mzm.gsp.task.event.TaskStateChangeProcedure;
/*     */ import mzm.gsp.task.main.TaskEventArg;
/*     */ import mzm.gsp.task.main.TaskInterface;
/*     */ import mzm.gsp.team.main.TeamInfo;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.zhenyao.event.ZhenyaoActivityArg;
/*     */ import mzm.gsp.zhenyao.event.ZhenyaoActivityFinished;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.ZhenyaoCount;
/*     */ import xtable.Role2properties;
/*     */ import xtable.Role2zhenyaocount;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnZhenyaoTaskChanged
/*     */   extends TaskStateChangeProcedure
/*     */ {
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  49 */     if (!isZhenyaoActivity())
/*     */     {
/*  51 */       return false;
/*     */     }
/*     */     
/*  54 */     switch (((TaskEventArg)this.arg).taskState)
/*     */     {
/*     */     case 8: 
/*  57 */       if ((((TaskEventArg)this.arg).getAllRoleList() == null) || (((TaskEventArg)this.arg).getAllRoleList().size() == 0))
/*     */       {
/*     */ 
/*  60 */         String logStr = String.format("[zhenyao]POnZhenyaoTaskChanged.processImpl@ zhenyao getAllRoleList error,empty|graphid=%d|taskid=%d|roleid=%d", new Object[] { Integer.valueOf(((TaskEventArg)this.arg).graphId), Integer.valueOf(((TaskEventArg)this.arg).taskId), Long.valueOf(((TaskEventArg)this.arg).roleId) });
/*     */         
/*     */ 
/*  63 */         ZhenyaoManager.logger.error(logStr);
/*     */         
/*  65 */         return false;
/*     */       }
/*  67 */       boolean isFiftyAwardOpen = ZhenyaoManager.isZhenyaoFiftyAwardSwitchOpen();
/*  68 */       Long teamId = TeamInterface.getTeamidByRoleid(((TaskEventArg)this.arg).roleId, false);
/*     */       
/*  70 */       if ((teamId == null) || (!TeamInterface.isTeamLeader(teamId.longValue(), ((TaskEventArg)this.arg).roleId, false)))
/*     */       {
/*  72 */         String logStr = String.format("[zhenyao]POnZhenyaoTaskChanged.processImpl@not team leader or teamID null|graphid=%d|taskid=%d|teamid=%d|teamroleid=%d", new Object[] { Integer.valueOf(((TaskEventArg)this.arg).graphId), Integer.valueOf(((TaskEventArg)this.arg).taskId), Long.valueOf(teamId == null ? 0L : teamId.longValue()), Long.valueOf(((TaskEventArg)this.arg).roleId) });
/*     */         
/*     */ 
/*  75 */         ZhenyaoManager.logger.info(logStr);
/*     */         
/*  77 */         return false;
/*     */       }
/*  79 */       TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId.longValue(), false);
/*  80 */       Set<Long> allRoleList = new HashSet(((TaskEventArg)this.arg).getAllRoleList());
/*  81 */       if (!allRoleList.containsAll(teamInfo.getTeamNormalList()))
/*     */       {
/*  83 */         allRoleList.addAll(teamInfo.getTeamNormalList());
/*     */       }
/*     */       
/*  86 */       Map<Long, String> userids = new HashMap();
/*     */       
/*  88 */       for (Long roleId : allRoleList)
/*     */       {
/*  90 */         userids.put(roleId, RoleInterface.getUserId(roleId.longValue()));
/*     */       }
/*  92 */       lock(User.getTable(), userids.values());
/*  93 */       lock(Role2properties.getTable(), allRoleList);
/*     */       
/*  95 */       if (!ZhenyaoManager.isZhenyaoSwitchOpenForRole(((TaskEventArg)this.arg).roleId, ((TaskEventArg)this.arg).getAllRoleList()))
/*     */       {
/*  97 */         String logstr = String.format("[zhenyao]POnZhenyaoTaskChanged.processImpl@some one is ban for this activity or activity switch is closed|roleid=%d|roles=%s", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId), ((TaskEventArg)this.arg).getAllRoleList().toString() });
/*     */         
/*     */ 
/* 100 */         ZhenyaoManager.logger.info(logstr);
/* 101 */         for (Iterator i$ = ((TaskEventArg)this.arg).getAllRoleList().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */           
/* 103 */           TaskInterface.closeActivityGraphWithoutEvent(roleid, ZhenYaoActivityCfgConsts.getInstance().GRAPH_ID);
/*     */         }
/* 105 */         return true;
/*     */       }
/* 107 */       if (!ZhenyaoInterface.isRoleStateCanJoinZhenyao(((TaskEventArg)this.arg).getRoleList()))
/*     */       {
/* 109 */         String logstr = String.format("[zhenyao]POnZhenyaoTaskChanged.processImp@role state can not join zhenyao|roleid=%d", new Object[] { Long.valueOf(((TaskEventArg)this.arg).roleId) });
/* 110 */         ZhenyaoManager.logger.info(logstr);
/* 111 */         return false;
/*     */       }
/* 113 */       Map<Long, String> roleidToUserid = new HashMap();
/* 114 */       for (Iterator i$ = ((TaskEventArg)this.arg).getRoleList().iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*     */         
/* 116 */         roleidToUserid.put(Long.valueOf(tmpRoleId), RoleInterface.getUserId(tmpRoleId));
/*     */       }
/*     */       
/* 119 */       ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(roleidToUserid, ((TaskEventArg)this.arg).getRoleList(), ZhenYaoActivityCfgConsts.getInstance().ACTIVITYID);
/*     */       
/* 121 */       if (!res.isCanJoin())
/*     */       {
/* 123 */         String logStr = String.format("[zhenyao]POnZhenyaoTaskChanged.processImpl@canjoin zhenyao error|graphid=%d|taskid=%d|teamid=%d|teamroleid=%d", new Object[] { Integer.valueOf(((TaskEventArg)this.arg).graphId), Integer.valueOf(((TaskEventArg)this.arg).taskId), Long.valueOf(teamId == null ? 0L : teamId.longValue()), Long.valueOf(((TaskEventArg)this.arg).roleId) });
/*     */         
/*     */ 
/* 126 */         ZhenyaoManager.logger.info(logStr);
/* 127 */         return false;
/*     */       }
/*     */       
/* 130 */       List<Long> roleList = ((TaskEventArg)this.arg).getRoleList();
/* 131 */       List<Long> toAwardRoleList = new ArrayList();
/* 132 */       int maxAwardCount = ZhenyaoManager.getZhenyaoMaxAwardCount(isFiftyAwardOpen);
/* 133 */       for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long rid = ((Long)i$.next()).longValue();
/*     */         
/* 135 */         if (canGetAward(rid, maxAwardCount))
/*     */         {
/*     */ 
/*     */ 
/* 139 */           toAwardRoleList.add(Long.valueOf(rid));
/*     */         }
/*     */       }
/* 142 */       if (!toAwardRoleList.isEmpty())
/*     */       {
/* 144 */         awardXiayi(toAwardRoleList, ZhenyaoManager.getZhenyaoAwardXiayiNum(isFiftyAwardOpen));
/* 145 */         awardZhenyaoReward(userids, toAwardRoleList, ZhenyaoManager.getZhenyaoNeedCutDoublePoint(isFiftyAwardOpen), ZhenyaoManager.getZhenyaoRewardId(isFiftyAwardOpen));
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 150 */       for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long rid = ((Long)i$.next()).longValue();
/*     */         
/* 152 */         boolean ret = ActivityInterface.addActivityCount((String)userids.get(Long.valueOf(rid)), rid, ZhenYaoActivityCfgConsts.getInstance().ACTIVITYID);
/*     */         
/* 154 */         if (!ret)
/*     */         {
/* 156 */           String logStr = String.format("[zhenyao]POnZhenyaoTaskChanged.processImpl@ Add  Zhenyao Activity Count failed|graphid=%d|taskid=%d|teamid=%d|roleid=%d", new Object[] { Integer.valueOf(((TaskEventArg)this.arg).graphId), Integer.valueOf(((TaskEventArg)this.arg).taskId), teamId, Long.valueOf(rid) });
/*     */           
/*     */ 
/* 159 */           ZhenyaoManager.logger.error(logStr);
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/* 164 */           ZhenyaoManager.addZhenyaoCount(rid, 1);
/*     */         }
/*     */       }
/*     */       
/* 168 */       TriggerEventsManger.getInstance().triggerEvent(new ZhenyaoActivityFinished(), new ZhenyaoActivityArg(roleList, ZhenYaoActivityCfgConsts.getInstance().ACTIVITYID, ((TaskEventArg)this.arg).getDiedMonsters().size()));
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 173 */       logActivity(roleList, ActivityLogStatus.FINISH);
/* 174 */       if (((TaskEventArg)this.arg).isToEnd)
/*     */       {
/* 176 */         SisContinueZhenyao isContinueZhenyao = new SisContinueZhenyao();
/* 177 */         OnlineManager.getInstance().send(((TaskEventArg)this.arg).roleId, isContinueZhenyao);
/* 178 */         return true;
/*     */       }
/*     */       
/* 181 */       return true;
/*     */     
/*     */     case 9: 
/* 184 */       boolean ret = TaskInterface.closeActivityGraphWithoutEvent(((TaskEventArg)this.arg).roleId, ((TaskEventArg)this.arg).graphId);
/* 185 */       if (!ret)
/*     */       {
/* 187 */         String logStr = String.format("[zhenyao]POnZhenyaoTaskChanged.processImpl@ give zhenyao task failed|graphid=%d|taskid=%d|roleid=%d", new Object[] { Integer.valueOf(((TaskEventArg)this.arg).graphId), Integer.valueOf(((TaskEventArg)this.arg).taskId), Long.valueOf(((TaskEventArg)this.arg).roleId) });
/*     */         
/*     */ 
/* 190 */         ZhenyaoManager.logger.error(logStr);
/*     */       }
/*     */       
/*     */ 
/* 194 */       return ret;
/*     */     case 2: 
/* 196 */       ActivityInterface.logActivity(((TaskEventArg)this.arg).roleId, ZhenYaoActivityCfgConsts.getInstance().ACTIVITYID, ActivityLogStatus.ATTEND);
/*     */       
/* 198 */       ActivityInterface.tlogActivity(((TaskEventArg)this.arg).roleId, ZhenYaoActivityCfgConsts.getInstance().ACTIVITYID, ActivityLogStatus.ATTEND);
/*     */       
/* 200 */       return true;
/*     */     }
/* 202 */     return false;
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
/*     */   private boolean canGetAward(long roleId, int maxAwardCount)
/*     */   {
/* 215 */     ZhenyaoCount xCount = Role2zhenyaocount.get(Long.valueOf(roleId));
/* 216 */     if (xCount == null)
/*     */     {
/* 218 */       xCount = Pod.newZhenyaoCount();
/* 219 */       Role2zhenyaocount.insert(Long.valueOf(roleId), xCount);
/*     */     }
/*     */     
/* 222 */     if (xCount.getDoublecount() + xCount.getSinglecount() >= maxAwardCount)
/*     */     {
/* 224 */       String logStr = String.format("[zhenyao]POnZhenyaoTaskChanged.processImpl@can not get award,count to max|roleid=%d|graphid=%d|taskid=%d|singlecount=%d|doublecount=%d|maxcount=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(((TaskEventArg)this.arg).graphId), Integer.valueOf(((TaskEventArg)this.arg).taskId), Integer.valueOf(xCount.getSinglecount()), Integer.valueOf(xCount.getDoublecount()), Integer.valueOf(maxAwardCount) });
/*     */       
/*     */ 
/* 227 */       ZhenyaoManager.logger.info(logStr);
/*     */       
/* 229 */       SZheyaoAwardCountToMaxRes res = new SZheyaoAwardCountToMaxRes(xCount.getZhenyaocount());
/* 230 */       OnlineManager.getInstance().send(roleId, res);
/* 231 */       return false;
/*     */     }
/*     */     
/* 234 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private int computeAvgLevel(List<Long> roleList)
/*     */   {
/* 245 */     int[] levels = new int[roleList.size()];
/* 246 */     for (int i = 0; i < roleList.size(); i++)
/*     */     {
/* 248 */       levels[i] = RoleInterface.getLevel(((Long)roleList.get(i)).longValue());
/*     */     }
/* 250 */     Arrays.sort(levels);
/* 251 */     int maxLevel = levels[(levels.length - 1)];
/* 252 */     int k = levels.length - 1;
/* 253 */     for (int i = levels.length - 2; i >= 0; i--)
/*     */     {
/* 255 */       if (maxLevel - levels[i] > ZhenYaoActivityCfgConsts.getInstance().MAX_LEVEL_DELTA) {
/*     */         break;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/* 261 */       k = i;
/*     */     }
/*     */     
/* 264 */     float level = 0.0F;
/* 265 */     for (int j = levels.length - 1; j >= k; j--)
/*     */     {
/* 267 */       level += levels[j];
/*     */     }
/* 269 */     return (int)(level / (levels.length - k));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void awardXiayi(List<Long> rList, int addXiaYiNum)
/*     */   {
/* 278 */     List<Long> toAwardXiayiList = new ArrayList();
/* 279 */     for (int i = 0; i < rList.size(); i++)
/*     */     {
/* 281 */       int level_i = RoleInterface.getLevel(((Long)rList.get(i)).longValue());
/* 282 */       for (int j = 0; j < rList.size(); j++)
/*     */       {
/* 284 */         if (rList.get(i) != rList.get(j))
/*     */         {
/*     */ 
/*     */ 
/* 288 */           int level_j = RoleInterface.getLevel(((Long)rList.get(j)).longValue());
/* 289 */           if (level_i - level_j >= ZhenYaoActivityCfgConsts.getInstance().MIN_LEVEL_DELTA)
/*     */           {
/* 291 */             toAwardXiayiList.add(rList.get(i));
/* 292 */             break;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/* 297 */     for (Iterator i$ = toAwardXiayiList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */       
/*     */ 
/* 300 */       ChivalryInterface.addRoleChivalry(r, addXiaYiNum, 1, new TLogArg(LogReason.ZHENYAO_ACTIVITY_ADD), true);
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
/*     */ 
/*     */   private void awardZhenyaoReward(Map<Long, String> userids, List<Long> roleids, int cutDoublePointNum, int rewardId)
/*     */   {
/* 315 */     int avgLevel = computeAvgLevel(((TaskEventArg)this.arg).getAllRoleList());
/*     */     
/* 317 */     int size = roleids.size();
/* 318 */     for (int i = 0; i < size; i++)
/*     */     {
/* 320 */       long rid = ((Long)roleids.get(i)).longValue();
/* 321 */       String userid = (String)userids.get(Long.valueOf(rid));
/*     */       
/* 323 */       ZhenyaoCount xCount = Role2zhenyaocount.get(Long.valueOf(rid));
/* 324 */       if (xCount != null)
/*     */       {
/*     */ 
/*     */ 
/* 328 */         int activityCount = ActivityInterface.getActivityCount(userid, rid, ZhenYaoActivityCfgConsts.getInstance().ACTIVITYID, true);
/*     */         
/*     */ 
/* 331 */         int levelDelta = RoleInterface.getLevel(rid) - avgLevel;
/* 332 */         boolean r = GuajiInterface.costDoublePoint(rid, SwitchType.ZhenYao, cutDoublePointNum, new TLogArg(LogReason.ZHENYAO_ACTIVITY_ADD, activityCount + 1));
/*     */         
/*     */ 
/* 335 */         addYaoCountBy(rid, xCount, r, cutDoublePointNum);
/*     */         
/* 337 */         int modifyId = ZhenyaoManager.getModifyId(((TaskEventArg)this.arg).taskNo, r, levelDelta);
/*     */         
/* 339 */         AwardReason awardReason = new AwardReason(LogReason.ZHENYAO_ACTIVITY_ADD, rewardId);
/*     */         
/* 341 */         AwardModel awardModel = AwardInterface.getRoleAwardModel(rewardId, rid, modifyId, ((TaskEventArg)this.arg).getRoleList(), ((TaskEventArg)this.arg).getAllRoleList(), awardReason);
/*     */         
/* 343 */         if (awardModel != null)
/*     */         {
/* 345 */           StorageExpInterface.award(userid, rid, awardModel, awardReason);
/* 346 */           String logStr = String.format("[zhenyao]POnZhenyaoTaskChanged.awardZhenyaoRewardl@award success|taskid=%d|roleid=%d|awardid=%d|ring=%d|modifyid=%d|isdouble=%d", new Object[] { Integer.valueOf(((TaskEventArg)this.arg).taskId), Long.valueOf(rid), Integer.valueOf(rewardId), Integer.valueOf(activityCount + 1), Integer.valueOf(modifyId), Integer.valueOf(r ? 1 : 0) });
/*     */           
/*     */ 
/* 349 */           ZhenyaoManager.logger.info(logStr);
/*     */         }
/*     */         else
/*     */         {
/* 353 */           String logStr = String.format("[zhenyao]POnZhenyaoTaskChanged.awardZhenyaoRewardl@award failed awardModel null|taskid=%d|roleid=%d|awardid=%d|ring=%d|modifyid=%d|isdouble=%d", new Object[] { Integer.valueOf(((TaskEventArg)this.arg).taskId), Long.valueOf(rid), Integer.valueOf(rewardId), Integer.valueOf(activityCount + 1), Integer.valueOf(modifyId), Integer.valueOf(r ? 1 : 0) });
/*     */           
/*     */ 
/* 356 */           ZhenyaoManager.logger.error(logStr);
/*     */         }
/*     */       }
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
/*     */   private void addYaoCountBy(long roleId, ZhenyaoCount xCount, boolean useDouble, int cutDoublePointNum)
/*     */   {
/* 372 */     if (useDouble)
/*     */     {
/* 374 */       xCount.setDoublecount(xCount.getDoublecount() + 1);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/* 379 */       String logStr = String.format("[zhenyao]POnZhenyaoTaskChanged.addYaoCountBy@ Zhenyao activity dec double point failed|graphid=%d|taskid=%d|roleid=%d|hasdoublenum=%d|cutnum=%d", new Object[] { Integer.valueOf(((TaskEventArg)this.arg).graphId), Integer.valueOf(((TaskEventArg)this.arg).taskId), Long.valueOf(roleId), Integer.valueOf(GuajiInterface.getUsableDoublePoint(roleId)), Integer.valueOf(cutDoublePointNum) });
/*     */       
/*     */ 
/* 382 */       ZhenyaoManager.logger.info(logStr);
/*     */       
/* 384 */       xCount.setSinglecount(xCount.getSinglecount() + 1);
/*     */     }
/* 386 */     ZhenyaoManager.synXYaoData2Client(roleId, xCount);
/*     */   }
/*     */   
/*     */   private boolean isZhenyaoActivity()
/*     */   {
/* 391 */     return ((TaskEventArg)this.arg).graphId == ZhenYaoActivityCfgConsts.getInstance().GRAPH_ID;
/*     */   }
/*     */   
/*     */   private void logActivity(List<Long> roleids, ActivityLogStatus status)
/*     */   {
/* 396 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/* 398 */       ActivityInterface.logActivity(roleid, ZhenYaoActivityCfgConsts.getInstance().ACTIVITYID, status);
/* 399 */       ActivityInterface.tlogActivity(roleid, ZhenYaoActivityCfgConsts.getInstance().ACTIVITYID, status);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zhenyao\main\POnZhenyaoTaskChanged.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */