/*      */ package mzm.gsp.hula.main;
/*      */ 
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import java.util.TreeMap;
/*      */ import mzm.gsp.GameServerInfoManager;
/*      */ import mzm.gsp.activity.main.ActivityHandler.ActivityStartType;
/*      */ import mzm.gsp.activity.main.ActivityInterface;
/*      */ import mzm.gsp.activity.main.ActivityJoinResult;
/*      */ import mzm.gsp.award.main.AwardModel;
/*      */ import mzm.gsp.award.main.AwardReason;
/*      */ import mzm.gsp.hula.MonsterInfo;
/*      */ import mzm.gsp.hula.SErrorInfo;
/*      */ import mzm.gsp.hula.SFightEndRes;
/*      */ import mzm.gsp.hula.SMarkMonsterRes;
/*      */ import mzm.gsp.hula.SSynActivityResultRes;
/*      */ import mzm.gsp.hula.SSynDeleteStageRes;
/*      */ import mzm.gsp.hula.SSynDoudouComeoutStagetRes;
/*      */ import mzm.gsp.hula.SSynMonsterListRes;
/*      */ import mzm.gsp.hula.SSynMonsterStateRes;
/*      */ import mzm.gsp.hula.confbean.SDoudouCfg;
/*      */ import mzm.gsp.hula.confbean.SHulaCfgConsts;
/*      */ import mzm.gsp.hula.confbean.SPointAwardCfg;
/*      */ import mzm.gsp.map.main.ControllerInterface;
/*      */ import mzm.gsp.map.main.MapInterface;
/*      */ import mzm.gsp.online.main.OnlineManager;
/*      */ import mzm.gsp.open.main.OpenInterface;
/*      */ import mzm.gsp.role.main.RoleInterface;
/*      */ import mzm.gsp.status.main.RoleStatusInterface;
/*      */ import mzm.gsp.team.main.TeamInfo;
/*      */ import mzm.gsp.team.main.TeamInterface;
/*      */ import mzm.gsp.tlog.LogReason;
/*      */ import mzm.gsp.tlog.TLogManager;
/*      */ import mzm.gsp.util.LinerCongruentialGenerator;
/*      */ import mzm.gsp.util.LogicProcedure;
/*      */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*      */ import org.apache.log4j.Logger;
/*      */ import xbean.HulaInfo;
/*      */ import xbean.HulaMonsterInfo;
/*      */ import xbean.HulaWorldInfo;
/*      */ import xbean.Pod;
/*      */ import xdb.Lockeys;
/*      */ import xdb.Xdb;
/*      */ import xtable.Hulaworld;
/*      */ import xtable.Role2hula;
/*      */ import xtable.Role2properties;
/*      */ import xtable.Team;
/*      */ import xtable.User;
/*      */ 
/*      */ public class HulaManager
/*      */ {
/*      */   static final int WAN = 10000;
/*      */   static final int MAX_TLOG_STRING_SIZE = 1000;
/*      */   static final String ENCODING = "UTF-8";
/*   66 */   static Logger logger = Logger.getLogger("Hula");
/*      */   
/*      */   static void init()
/*      */   {
/*   70 */     logger = Logger.getLogger("Hula");
/*      */   }
/*      */   
/*      */ 
/*      */   static int getPhaseNumEveryTurn()
/*      */   {
/*   76 */     return 2;
/*      */   }
/*      */   
/*      */   static boolean isThisStage(int currentActivityStage, int targetStage)
/*      */   {
/*   81 */     if (currentActivityStage == targetStage)
/*      */     {
/*   83 */       return true;
/*      */     }
/*      */     
/*      */ 
/*   87 */     if (targetStage == 0)
/*      */     {
/*   89 */       return currentActivityStage == 0;
/*      */     }
/*      */     
/*      */ 
/*   93 */     int turn = getTurn(currentActivityStage);
/*   94 */     return currentActivityStage - turn * getPhaseNumEveryTurn() == targetStage;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static int getStageEnum(int currentActivityStage)
/*      */   {
/*  102 */     if (currentActivityStage == 0)
/*      */     {
/*  104 */       return 0;
/*      */     }
/*      */     
/*      */ 
/*  108 */     int turn = getTurn(currentActivityStage);
/*  109 */     return currentActivityStage - turn * getPhaseNumEveryTurn();
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
/*      */   static int getTurn(int stage)
/*      */   {
/*  122 */     if (stage <= 0)
/*      */     {
/*  124 */       return -1;
/*      */     }
/*  126 */     return (stage - 1) / getPhaseNumEveryTurn();
/*      */   }
/*      */   
/*      */ 
/*      */   static int getMonsterCapacity()
/*      */   {
/*  132 */     return SHulaCfgConsts.getInstance().DOUDOU_CAPACITY;
/*      */   }
/*      */   
/*      */   static void initRoleData(long roleid, long worldid)
/*      */   {
/*  137 */     HulaInfo xHulaInfo = Role2hula.get(Long.valueOf(roleid));
/*  138 */     if (xHulaInfo == null)
/*      */     {
/*  140 */       xHulaInfo = Pod.newHulaInfo();
/*  141 */       Role2hula.insert(Long.valueOf(roleid), xHulaInfo);
/*      */     }
/*  143 */     xHulaInfo.setPoint(0);
/*  144 */     xHulaInfo.setWorldid(worldid);
/*  145 */     xHulaInfo.getKill_monsterid_2_count().clear();
/*  146 */     xHulaInfo.getDelete_type_2_count().clear();
/*  147 */     xHulaInfo.getDelete_monsterid_2_count().clear();
/*  148 */     xHulaInfo.setTurnpoint(0);
/*      */   }
/*      */   
/*      */   static void onActivityStart(ActivityHandler.ActivityStartType activityStartType, int activityid)
/*      */   {
/*  153 */     clearRank();
/*  154 */     new HulaAwardObserver(SHulaCfgConsts.getInstance().EXP_RAIN_INTERVAL_SECONDS);
/*  155 */     ControllerInterface.triggerController(SHulaCfgConsts.getInstance().NPC_CONTROLLER);
/*  156 */     createPrepareWorld();
/*      */   }
/*      */   
/*      */   static void onActivityEnd(int activityid)
/*      */   {
/*  161 */     HulaWorldManager.getInstance().destroyWorld();
/*  162 */     HulaFightManager.getInstance().clear();
/*  163 */     ControllerInterface.collectController(SHulaCfgConsts.getInstance().NPC_CONTROLLER);
/*  164 */     offerRankAward();
/*      */   }
/*      */   
/*      */   static void onActivityStageStart(int stage, boolean startAgain, int activityid)
/*      */   {
/*  169 */     logger.info(String.format("[hula]HulaManager.onActivityStageStart@now stage|stage=%d|startAgain=%b|activityid=%d", new Object[] { Integer.valueOf(stage), Boolean.valueOf(startAgain), Integer.valueOf(activityid) }));
/*      */     
/*  171 */     if (!startAgain)
/*      */     {
/*  173 */       int turn = getTurn(stage);
/*      */       
/*  175 */       if (!isThisStage(stage, 0))
/*      */       {
/*      */ 
/*      */ 
/*  179 */         if (isThisStage(stage, 1))
/*      */         {
/*  181 */           if (stage == 1)
/*      */           {
/*  183 */             transferRoleToHulaWorld();
/*      */           }
/*      */           else
/*      */           {
/*  187 */             HulaWorldManager.getInstance().generateDoudou(turn);
/*      */           }
/*  189 */           String log = String.format("[hula]HulaManager.onActivityStageStart@activity doudou come cout stage open success|activityid=%d|turn=%d|stage=%d", new Object[] { Integer.valueOf(activityid), Integer.valueOf(turn), Integer.valueOf(stage) });
/*      */           
/*      */ 
/*  192 */           logger.info(log);
/*      */         }
/*  194 */         else if (isThisStage(stage, 2))
/*      */         {
/*  196 */           HulaFightManager.getInstance().closeFight();
/*  197 */           HulaWorldManager.getInstance().deleteDoudou(turn);
/*  198 */           String log = String.format("[hula]HulaManager.onActivityStageStart@activity doudou delete stage open success|activityid=%d|turn=%d|stage=%d", new Object[] { Integer.valueOf(activityid), Integer.valueOf(turn), Integer.valueOf(stage) });
/*      */           
/*      */ 
/*  201 */           logger.info(log);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void createPrepareWorld()
/*      */   {
/*  213 */     long worldid = MapInterface.createWorld(Arrays.asList(new Integer[] { Integer.valueOf(SHulaCfgConsts.getInstance().PREPARE_MAP_ID) }));
/*  214 */     HulaWorldManager.getInstance().setPrepareWorldId(worldid);
/*  215 */     HulaPrepareTeamHandler prepareTeamHandler = new HulaPrepareTeamHandler();
/*  216 */     TeamInterface.registerJoinTeam(worldid, prepareTeamHandler);
/*  217 */     TeamInterface.registerActivityTeam(worldid, prepareTeamHandler);
/*  218 */     String log = String.format("[hula]HulaManager.createPrepareWorld@create prepare world success|worldid=%d|mapid=%d", new Object[] { Long.valueOf(worldid), Integer.valueOf(SHulaCfgConsts.getInstance().PREPARE_MAP_ID) });
/*      */     
/*  220 */     logger.info(log);
/*      */   }
/*      */   
/*      */ 
/*      */   static int generateDouboeSeq(int turn, HulaWorldInfo xHulaWorldInfo, Map<Long, HulaInfo> roleid2XHulaInfo)
/*      */   {
/*  226 */     int capacity = getMonsterCapacity();
/*  227 */     int addNum = SHulaCfgConsts.getInstance().MONSTER_COUNT_EVERY_TURN;
/*  228 */     xHulaWorldInfo.setMaxseq((turn + 1) * addNum);
/*  229 */     String oldMonsterids = getMonsterString(xHulaWorldInfo);
/*  230 */     List<HulaMonsterInfo> xList = xHulaWorldInfo.getMonsters();
/*  231 */     int toDelSize = xList.size() + addNum - capacity;
/*  232 */     if (toDelSize > 0)
/*      */     {
/*  234 */       xList.subList(0, toDelSize).clear();
/*      */     }
/*      */     else
/*      */     {
/*  238 */       toDelSize = 0;
/*      */     }
/*  240 */     String teamMateString = getTeammateString(xHulaWorldInfo.getRoleids());
/*  241 */     checkState(teamMateString, turn, xList);
/*  242 */     List<Integer> srcRandomModelIds = getSrcRandomModelIds();
/*      */     
/*  244 */     int exceptModelId = dealRandomModelSource(xList);
/*  245 */     int totalWeight = getTotalWeight(srcRandomModelIds, exceptModelId);
/*      */     
/*  247 */     int startNo = turn * addNum + 1;
/*  248 */     int endNo = startNo + addNum;
/*  249 */     int seed = getRandomSeed();
/*  250 */     LinerCongruentialGenerator random = getRandom(seed);
/*      */     
/*  252 */     for (int i = startNo; i < endNo; i++)
/*      */     {
/*  254 */       int id = randomNextModelId(random, srcRandomModelIds, totalWeight, exceptModelId);
/*  255 */       HulaMonsterInfo xHulaMonsterInfo = Pod.newHulaMonsterInfo();
/*  256 */       xHulaMonsterInfo.setMonsterid(id);
/*  257 */       xHulaMonsterInfo.setSeq(i);
/*  258 */       xHulaMonsterInfo.setState(1);
/*  259 */       xList.add(xHulaMonsterInfo);
/*      */       
/*  261 */       exceptModelId = dealRandomModelSource(xList);
/*  262 */       totalWeight = getTotalWeight(srcRandomModelIds, exceptModelId);
/*      */     }
/*      */     
/*  265 */     String addMonsterids = getNewAddMonsterString(xHulaWorldInfo, addNum);
/*  266 */     int cutPoint = toDelSize * SHulaCfgConsts.getInstance().CUT_POINT;
/*  267 */     for (Iterator i$ = xHulaWorldInfo.getRoleids().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */       
/*  269 */       int totalPoint = 0;
/*  270 */       HulaInfo xHulaInfo = (HulaInfo)roleid2XHulaInfo.get(Long.valueOf(roleid));
/*  271 */       if (xHulaInfo != null)
/*      */       {
/*  273 */         totalPoint = xHulaInfo.getPoint();
/*      */       }
/*  275 */       tlogHulaturnbegin(roleid, teamMateString, turn, oldMonsterids, addMonsterids, totalPoint - cutPoint, cutPoint);
/*      */     }
/*  277 */     broadCastSSynDoudouComeoutStagetRes(seed, turn, xHulaWorldInfo.getRoleids());
/*  278 */     String log = String.format("[hula]HulaManager.generateDouboeSeq@generate monster seq|roleids=%s|turn=%d|oldseq=%s|newseq=%s", new Object[] { teamMateString, Integer.valueOf(turn), oldMonsterids, addMonsterids });
/*      */     
/*      */ 
/*  281 */     logger.info(log);
/*  282 */     return toDelSize;
/*      */   }
/*      */   
/*      */ 
/*      */   private static void checkState(String teamMateString, int turn, List<HulaMonsterInfo> xList)
/*      */   {
/*  288 */     if ((xList == null) || (xList.isEmpty()))
/*      */     {
/*  290 */       return;
/*      */     }
/*  292 */     for (HulaMonsterInfo xHulaMonsterInfo : xList)
/*      */     {
/*  294 */       if (xHulaMonsterInfo.getState() == 4)
/*      */       {
/*  296 */         xHulaMonsterInfo.setState(1);
/*      */         
/*  298 */         String log = String.format("[hula]HulaManager.checkState@set monster state from fighting to alive|roleids=%s|turn=%d|seq=%d|monster_id=%d", new Object[] { teamMateString, Integer.valueOf(turn), Integer.valueOf(xHulaMonsterInfo.getSeq()), Integer.valueOf(xHulaMonsterInfo.getMonsterid()) });
/*      */         
/*      */ 
/*  301 */         logger.info(log);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   static LinerCongruentialGenerator getRandom(int seed)
/*      */   {
/*  308 */     LinerCongruentialGenerator random = new LinerCongruentialGenerator(seed);
/*  309 */     random.setSeed(seed);
/*  310 */     return random;
/*      */   }
/*      */   
/*      */ 
/*      */   static int randomNextModelId(LinerCongruentialGenerator random, List<Integer> srcRandomModelIds, int totalWeight, int exceptModelId)
/*      */   {
/*  316 */     int result = random.nextInt(totalWeight);
/*  317 */     int sum = 0;
/*  318 */     for (Iterator i$ = srcRandomModelIds.iterator(); i$.hasNext();) { int modelid = ((Integer)i$.next()).intValue();
/*      */       
/*  320 */       if (modelid != exceptModelId)
/*      */       {
/*      */ 
/*      */ 
/*  324 */         sum += SDoudouCfg.get(modelid).weight;
/*  325 */         if (result < sum)
/*      */         {
/*  327 */           return modelid;
/*      */         }
/*      */       }
/*      */     }
/*  331 */     return -1;
/*      */   }
/*      */   
/*      */   static int dealRandomModelSource(List<HulaMonsterInfo> xList)
/*      */   {
/*  336 */     boolean isPreNSame = isPreNIsSame(xList, SHulaCfgConsts.getInstance().MIN_DELETE_NUM - 1, xList.size() - 1);
/*      */     
/*  338 */     if (isPreNSame)
/*      */     {
/*  340 */       int lastMonsterId = ((HulaMonsterInfo)xList.get(xList.size() - 1)).getMonsterid();
/*  341 */       return lastMonsterId;
/*      */     }
/*  343 */     return -1;
/*      */   }
/*      */   
/*      */   static int getTotalWeight(List<Integer> srcRandomModelIds, int exceptModelId)
/*      */   {
/*  348 */     int s = 0;
/*  349 */     for (Iterator i$ = srcRandomModelIds.iterator(); i$.hasNext();) { int modelid = ((Integer)i$.next()).intValue();
/*      */       
/*  351 */       if (exceptModelId != modelid)
/*      */       {
/*      */ 
/*      */ 
/*  355 */         s += SDoudouCfg.get(modelid).weight; }
/*      */     }
/*  357 */     return s;
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
/*      */   static boolean isPreNIsSame(List<HulaMonsterInfo> xList, int n, int endPos)
/*      */   {
/*  370 */     if (endPos + 1 < n)
/*      */     {
/*  372 */       return false;
/*      */     }
/*      */     
/*      */ 
/*  376 */     int end = endPos;
/*  377 */     int start = end - n + 1;
/*  378 */     int brefore = ((HulaMonsterInfo)xList.get(end)).getMonsterid();
/*  379 */     for (int i = end - 1; i >= start; i--)
/*      */     {
/*  381 */       if (brefore != ((HulaMonsterInfo)xList.get(i)).getMonsterid())
/*      */       {
/*  383 */         return false;
/*      */       }
/*      */     }
/*  386 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   static int getRandomSeed()
/*      */   {
/*  392 */     return Xdb.random().nextInt(10000);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean checkTeam(long roleId, List<Long> roles)
/*      */   {
/*  404 */     Map<Long, String> roleidToUserid = new HashMap();
/*  405 */     for (Iterator i$ = roles.iterator(); i$.hasNext();) { long tmpRoleId = ((Long)i$.next()).longValue();
/*      */       
/*  407 */       roleidToUserid.put(Long.valueOf(tmpRoleId), RoleInterface.getUserId(tmpRoleId));
/*      */     }
/*      */     
/*  410 */     Lockeys.lock(User.getTable(), roleidToUserid.values());
/*  411 */     Lockeys.lock(Role2properties.getTable(), roles);
/*  412 */     Long teamId = TeamInterface.getTeamidByRoleid(roleId, true);
/*  413 */     if (teamId != null)
/*      */     {
/*  415 */       TeamInfo teamInfo = TeamInterface.getTeamInfo(teamId.longValue(), true);
/*  416 */       if (teamInfo != null)
/*      */       {
/*  418 */         if (teamInfo.getLeaderId() != roleId)
/*      */         {
/*  420 */           return false;
/*      */         }
/*  422 */         List<Long> roleList = teamInfo.getTeamNormalList();
/*  423 */         if ((roles.size() != roleList.size()) || (!roles.containsAll(roleList)))
/*      */         {
/*  425 */           return false;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  430 */     boolean r = RoleStatusInterface.checkCansetStatus(roles, 450, true);
/*  431 */     if (!r)
/*      */     {
/*  433 */       return false;
/*      */     }
/*      */     
/*  436 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(roleidToUserid, roles, SHulaCfgConsts.getInstance().ACTIVITY_ID);
/*      */     
/*  438 */     if (!res.isCanJoin())
/*      */     {
/*  440 */       if ((!res.isActivityNotOpen()) || (
/*      */       
/*      */ 
/*      */ 
/*  444 */         (!res.isRoleLevelWrong()) || 
/*      */         
/*      */ 
/*      */ 
/*  448 */         (res.isPerSonCountWrong()))) {}
/*      */       
/*      */ 
/*      */ 
/*  452 */       return false;
/*      */     }
/*  454 */     if (!isHulaSwitchOpenForRole(roleId, roles))
/*      */     {
/*  456 */       return false;
/*      */     }
/*  458 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static boolean isHulaSwitchOpenForRole(long leaderRoleid, List<Long> roleids)
/*      */   {
/*  470 */     int moduleid = 200;
/*  471 */     if (!OpenInterface.getOpenStatus(moduleid))
/*      */     {
/*  473 */       return false;
/*      */     }
/*  475 */     for (Iterator i$ = roleids.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */       
/*  477 */       if (OpenInterface.isBanPlay(roleid, moduleid))
/*      */       {
/*  479 */         OpenInterface.sendBanPlayMsg(leaderRoleid, roleid, RoleInterface.getName(roleid), moduleid);
/*      */         
/*  481 */         return false;
/*      */       }
/*      */     }
/*  484 */     return true;
/*      */   }
/*      */   
/*      */   static boolean isHulaSwitchOpenForRole(long roleid)
/*      */   {
/*  489 */     int moduleid = 200;
/*  490 */     if (!OpenInterface.getOpenStatus(moduleid))
/*      */     {
/*  492 */       return false;
/*      */     }
/*  494 */     if (OpenInterface.isBanPlay(roleid, moduleid))
/*      */     {
/*  496 */       OpenInterface.sendBanPlayMsg(roleid, moduleid);
/*  497 */       return false;
/*      */     }
/*      */     
/*  500 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   static void sendErrorInfo(long roleid, int rescode)
/*      */   {
/*  506 */     SErrorInfo errorInfo = new SErrorInfo();
/*  507 */     errorInfo.errorcode = rescode;
/*  508 */     OnlineManager.getInstance().sendAtOnce(roleid, errorInfo);
/*      */   }
/*      */   
/*      */   static long createHulaWorld(List<Long> roleList)
/*      */   {
/*  513 */     long worldid = MapInterface.createWorld(Arrays.asList(new Integer[] { Integer.valueOf(SHulaCfgConsts.getInstance().MAP_ID) }));
/*  514 */     HulaTeamHandler hulaTeamHandler = new HulaTeamHandler();
/*  515 */     TeamInterface.registerJoinTeam(worldid, hulaTeamHandler);
/*      */     
/*  517 */     long key = GameServerInfoManager.toGlobalId(worldid);
/*  518 */     HulaWorldInfo xHulaWorldInfo = Hulaworld.get(Long.valueOf(key));
/*  519 */     if (xHulaWorldInfo == null)
/*      */     {
/*  521 */       xHulaWorldInfo = Pod.newHulaWorldInfo();
/*  522 */       Hulaworld.insert(Long.valueOf(key), xHulaWorldInfo);
/*      */     }
/*  524 */     xHulaWorldInfo.getRoleids().addAll(roleList);
/*  525 */     xHulaWorldInfo.getMonsters().clear();
/*  526 */     Map<Long, HulaInfo> roleix2XhulaMap = getXRoleid2HulaInfo(roleList);
/*  527 */     for (Iterator i$ = roleix2XhulaMap.keySet().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */       
/*  529 */       HulaInfo xHulaInfo = (HulaInfo)roleix2XhulaMap.get(Long.valueOf(roleid));
/*  530 */       xHulaInfo.setWorldid(worldid);
/*      */     }
/*  532 */     HulaWorldManager.getInstance().addWorldId(worldid);
/*  533 */     generateDouboeSeq(0, xHulaWorldInfo, roleix2XhulaMap);
/*  534 */     return worldid;
/*      */   }
/*      */   
/*      */   static void transferRoleToHulaWorld()
/*      */   {
/*  539 */     long prepareWorldId = HulaWorldManager.getInstance().getPrepareWorldId();
/*  540 */     List<Long> roles = MapInterface.getAllSingleRoleAndTeamLeaderInWorld(prepareWorldId);
/*  541 */     for (Iterator i$ = roles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */       
/*  543 */       HulaOneByOne.getInstance().excute(new CreateHulaWorldPro(roleid));
/*      */     }
/*  545 */     HulaOneByOne.getInstance().excute(new DestoryPrepareWorldPro(null));
/*      */   }
/*      */   
/*      */   private static class DestoryPrepareWorldPro
/*      */     extends LogicProcedure
/*      */   {
/*      */     protected boolean processImp() throws Exception
/*      */     {
/*  553 */       HulaWorldManager.getInstance().destroyPrepareWorld();
/*  554 */       return true;
/*      */     }
/*      */   }
/*      */   
/*      */   private static class CreateHulaWorldPro
/*      */     extends LogicProcedure
/*      */   {
/*      */     private final long roleid;
/*      */     
/*      */     public CreateHulaWorldPro(long roleid)
/*      */     {
/*  565 */       this.roleid = roleid;
/*      */     }
/*      */     
/*      */ 
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/*  572 */       List<Long> roleList = new ArrayList();
/*  573 */       TeamInfo teamInfo = TeamInterface.getTeamInfoByRoleId(this.roleid);
/*  574 */       if (teamInfo == null)
/*      */       {
/*  576 */         roleList.add(Long.valueOf(this.roleid));
/*      */       }
/*      */       else
/*      */       {
/*  580 */         if (teamInfo.getLeaderId() != this.roleid)
/*      */         {
/*  582 */           return false;
/*      */         }
/*  584 */         roleList.addAll(teamInfo.getTeamMemberList());
/*      */       }
/*  586 */       Map<Long, String> roleid2userids = new HashMap();
/*  587 */       for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */         
/*  589 */         roleid2userids.put(Long.valueOf(roleid), RoleInterface.getUserId(roleid));
/*      */       }
/*  591 */       Lockeys.lock(User.getTable(), roleid2userids.values());
/*  592 */       Lockeys.lock(Role2properties.getTable(), roleList);
/*  593 */       if (teamInfo != null)
/*      */       {
/*  595 */         Lockeys.lock(Team.getTable(), Arrays.asList(new Long[] { Long.valueOf(teamInfo.getTeamId()) }));
/*      */       }
/*  597 */       List<Long> toRemoveRoleList = new ArrayList();
/*  598 */       for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */         
/*  600 */         if (!RoleStatusInterface.containsStatus(roleid, 450))
/*      */         {
/*  602 */           toRemoveRoleList.add(Long.valueOf(roleid));
/*      */         }
/*      */       }
/*  605 */       roleList.removeAll(toRemoveRoleList);
/*  606 */       for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */         
/*  608 */         TeamInterface.forceTmpLeaveTeam(roleid);
/*      */       }
/*      */       
/*  611 */       ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(roleid2userids, roleList, SHulaCfgConsts.getInstance().ACTIVITY_ID);
/*      */       
/*  613 */       if (!res.isCanJoin())
/*      */       {
/*  615 */         String log = String.format("[hula]CreateHulaWorldPro.processImp@role can not join activity|roleids=%s", new Object[] { roleList.toString() });
/*      */         
/*  617 */         HulaManager.logger.error(log);
/*  618 */         return false;
/*      */       }
/*  620 */       if (!RoleStatusInterface.setStatus(roleList, 450, false))
/*      */       {
/*  622 */         String log = String.format("[hula]CreateHulaWorldPro.processImp@role can not set hula state|roleids=%s", new Object[] { roleList.toString() });
/*      */         
/*  624 */         HulaManager.logger.error(log);
/*  625 */         return false;
/*      */       }
/*  627 */       long worldid = HulaManager.createHulaWorld(roleList);
/*  628 */       MapInterface.transferAllRole(roleList, worldid, SHulaCfgConsts.getInstance().MAP_ID);
/*  629 */       String log = String.format("[hula]CreateHulaWorldPro.processImp@transfer role to hula world success|roleids=%s", new Object[] { roleList.toString() });
/*      */       
/*  631 */       HulaManager.logger.info(log);
/*  632 */       return true;
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   static DeleteDoudouResult deleteDoudou(HulaWorldInfo xHulaWorldInfo)
/*      */   {
/*  639 */     DeleteDoudouResult result = new DeleteDoudouResult();
/*  640 */     Map<Integer, Integer> delete_type_2_count = new HashMap();
/*  641 */     Map<Integer, Integer> delete_monsterid_2_count = new HashMap();
/*      */     
/*  643 */     if ((xHulaWorldInfo == null) || (xHulaWorldInfo.getMonsters().size() < SHulaCfgConsts.getInstance().MIN_DELETE_NUM))
/*      */     {
/*  645 */       return result;
/*      */     }
/*  647 */     int point = 0;
/*  648 */     List<HulaMonsterInfo> xList = xHulaWorldInfo.getMonsters();
/*  649 */     int monsterSize = xList.size();
/*  650 */     boolean nextLoop = false;
/*      */     
/*  652 */     int deleteLevel = 1;
/*      */     
/*      */     do
/*      */     {
/*  656 */       List<List<Integer>> monsterPosListAll = new ArrayList();
/*      */       
/*  658 */       List<Integer> monsterPosList = null;
/*      */       
/*  660 */       int MonsterBeginType = -1;
/*  661 */       for (int i = 0; i < monsterSize; i++)
/*      */       {
/*  663 */         HulaMonsterInfo xMonsterInfo = (HulaMonsterInfo)xList.get(i);
/*  664 */         if (xMonsterInfo.getState() != 2)
/*      */         {
/*      */ 
/*      */ 
/*      */ 
/*  669 */           if ((!canDelete(xMonsterInfo.getMonsterid())) || (MonsterBeginType != xMonsterInfo.getMonsterid()))
/*      */           {
/*      */ 
/*  672 */             if ((monsterPosList != null) && (monsterPosList.size() >= SHulaCfgConsts.getInstance().MIN_DELETE_NUM))
/*      */             {
/*  674 */               monsterPosListAll.add(new ArrayList(monsterPosList));
/*      */             }
/*  676 */             if (monsterPosList != null)
/*      */             {
/*  678 */               monsterPosList.clear();
/*      */             }
/*      */           }
/*      */           
/*      */ 
/*  683 */           if (monsterPosList == null)
/*      */           {
/*  685 */             monsterPosList = new ArrayList();
/*      */           }
/*  687 */           MonsterBeginType = xMonsterInfo.getMonsterid();
/*  688 */           monsterPosList.add(Integer.valueOf(i));
/*      */         }
/*      */       }
/*  691 */       if ((monsterPosList != null) && (monsterPosList.size() >= SHulaCfgConsts.getInstance().MIN_DELETE_NUM))
/*      */       {
/*  693 */         monsterPosListAll.add(new ArrayList(monsterPosList));
/*      */       }
/*      */       
/*      */ 
/*  697 */       if (monsterPosListAll.size() > 0)
/*      */       {
/*  699 */         for (List<Integer> monsterGroup : monsterPosListAll)
/*      */         {
/*  701 */           int size = monsterGroup.size();
/*      */           
/*  703 */           for (Integer pos : monsterGroup)
/*      */           {
/*  705 */             ((HulaMonsterInfo)xList.get(pos.intValue())).setState(2);
/*      */           }
/*      */           
/*  708 */           int groupPoint = getPoint(deleteLevel, size);
/*  709 */           point += groupPoint;
/*      */           
/*  711 */           Integer nDelete = (Integer)delete_type_2_count.get(Integer.valueOf(deleteLevel));
/*  712 */           if (nDelete == null)
/*      */           {
/*  714 */             nDelete = Integer.valueOf(0);
/*      */           }
/*  716 */           delete_type_2_count.put(Integer.valueOf(deleteLevel), Integer.valueOf(nDelete.intValue() + 1));
/*      */           
/*      */ 
/*  719 */           int monsterType = ((HulaMonsterInfo)xList.get(((Integer)monsterGroup.get(0)).intValue())).getMonsterid();
/*  720 */           Integer monsterCount = (Integer)delete_monsterid_2_count.get(Integer.valueOf(monsterType));
/*  721 */           if (monsterCount == null)
/*      */           {
/*  723 */             monsterCount = Integer.valueOf(0);
/*      */           }
/*  725 */           delete_monsterid_2_count.put(Integer.valueOf(monsterType), Integer.valueOf(size + monsterCount.intValue()));
/*      */         }
/*      */         
/*  728 */         nextLoop = true;
/*      */       }
/*      */       else
/*      */       {
/*  732 */         nextLoop = false;
/*      */       }
/*      */       
/*  735 */       deleteLevel++;
/*      */     }
/*  737 */     while (nextLoop);
/*      */     
/*  739 */     Iterator<HulaMonsterInfo> xIterator = xHulaWorldInfo.getMonsters().iterator();
/*  740 */     while (xIterator.hasNext())
/*      */     {
/*  742 */       HulaMonsterInfo xHulaMonsterInfo = (HulaMonsterInfo)xIterator.next();
/*  743 */       if (xHulaMonsterInfo.getState() == 2)
/*      */       {
/*  745 */         xIterator.remove();
/*      */       }
/*      */     }
/*      */     
/*  749 */     result.setDelete_type_2_count(delete_type_2_count);
/*  750 */     result.setPoint(point);
/*  751 */     result.setDelete_monsterid_2_count(delete_monsterid_2_count);
/*      */     
/*  753 */     return result;
/*      */   }
/*      */   
/*      */   static int getPoint(int times, int count)
/*      */   {
/*  758 */     int newTimes = 1;
/*  759 */     if (times <= 1)
/*      */     {
/*  761 */       newTimes = 1;
/*      */     }
/*  763 */     else if (times == 2)
/*      */     {
/*  765 */       newTimes = 2;
/*      */     }
/*      */     else
/*      */     {
/*  769 */       newTimes = 3;
/*      */     }
/*  771 */     return newTimes * count * SHulaCfgConsts.getInstance().KILL_POINT;
/*      */   }
/*      */   
/*      */   static int getPoint(RangeIndex r)
/*      */   {
/*  776 */     int times = 1;
/*      */     
/*  778 */     if (r.getTimes() <= 1)
/*      */     {
/*  780 */       times = 1;
/*      */     }
/*  782 */     else if (r.getTimes() == 2)
/*      */     {
/*  784 */       times = 2;
/*      */     }
/*      */     else
/*      */     {
/*  788 */       times = 3;
/*      */     }
/*  790 */     return times * r.getCount() * SHulaCfgConsts.getInstance().KILL_POINT;
/*      */   }
/*      */   
/*      */   static List<RangeIndex> findSameSeq2(List<HulaMonsterInfo> xList)
/*      */   {
/*  795 */     List<RangeIndex> rangeIndexs = new ArrayList();
/*  796 */     if ((xList == null) || (xList.isEmpty()))
/*      */     {
/*  798 */       return rangeIndexs;
/*      */     }
/*  800 */     int st = -1;
/*  801 */     int end = -1;
/*  802 */     int count = 0;
/*  803 */     int preId = -1;
/*  804 */     for (int i = 0; i < xList.size(); i++)
/*      */     {
/*  806 */       if (((HulaMonsterInfo)xList.get(i)).getState() != 2)
/*      */       {
/*      */ 
/*      */ 
/*  810 */         if ((!canDelete(((HulaMonsterInfo)xList.get(i)).getMonsterid())) || (preId != ((HulaMonsterInfo)xList.get(i)).getMonsterid()))
/*      */         {
/*  812 */           if (count >= SHulaCfgConsts.getInstance().MIN_DELETE_NUM)
/*      */           {
/*  814 */             rangeIndexs.add(new RangeIndex(st, end, count, 1));
/*      */           }
/*  816 */           preId = ((HulaMonsterInfo)xList.get(i)).getMonsterid();
/*  817 */           st = i;
/*  818 */           end = i;
/*  819 */           count = 1;
/*      */         }
/*      */         else
/*      */         {
/*  823 */           count++;
/*  824 */           end = i;
/*      */         }
/*      */       }
/*      */     }
/*      */     
/*  829 */     if (count >= SHulaCfgConsts.getInstance().MIN_DELETE_NUM)
/*      */     {
/*  831 */       rangeIndexs.add(new RangeIndex(st, end, count, 1));
/*      */     }
/*  833 */     return rangeIndexs;
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean canDelete(int monsterId)
/*      */   {
/*  839 */     SDoudouCfg doudouCfg = SDoudouCfg.get(monsterId);
/*  840 */     if (doudouCfg == null)
/*      */     {
/*  842 */       return false;
/*      */     }
/*  844 */     return doudouCfg.canDelete;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static void mergeRangeIndex(List<RangeIndex> srcRangeIndexs, List<RangeIndex> targetRangeIndexs, Map<Integer, Integer> delete_type_2_count)
/*      */   {
/*  851 */     if ((targetRangeIndexs == null) || (targetRangeIndexs.isEmpty()))
/*      */     {
/*  853 */       return;
/*      */     }
/*  855 */     for (Iterator i$ = targetRangeIndexs.iterator(); i$.hasNext();) { t = (RangeIndex)i$.next();
/*      */       
/*  857 */       for (RangeIndex s : srcRangeIndexs)
/*      */       {
/*  859 */         if ((t.getStart() <= s.getStart()) && (t.getEnd() >= s.getStart()))
/*      */         {
/*  861 */           t.setTimes(Math.max(t.getTimes(), s.getTimes() + 1));
/*  862 */           Integer c = (Integer)delete_type_2_count.get(Integer.valueOf(t.getTimes() - 1));
/*  863 */           if (c != null)
/*      */           {
/*  865 */             delete_type_2_count.put(Integer.valueOf(t.getTimes() - 1), Integer.valueOf(c.intValue() - 1));
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */     RangeIndex t;
/*      */   }
/*      */   
/*      */   static void broadCastSSynDoudouComeoutStagetRes(int randomSeed, int turn, Collection<Long> roleList)
/*      */   {
/*  875 */     SSynDoudouComeoutStagetRes res = new SSynDoudouComeoutStagetRes();
/*  876 */     res.seed = randomSeed;
/*  877 */     res.turn = (turn + 1);
/*  878 */     OnlineManager.getInstance().sendMulti(res, roleList);
/*      */   }
/*      */   
/*      */   static void broadCastSSynDeleteStageRes(int turn, Collection<Long> roleList)
/*      */   {
/*  883 */     SSynDeleteStageRes res = new SSynDeleteStageRes();
/*  884 */     res.turn = (turn + 1);
/*  885 */     OnlineManager.getInstance().sendMulti(res, roleList);
/*      */   }
/*      */   
/*      */   static void broadCastSFightEndRes(int seq, int state, Collection<Long> roleList)
/*      */   {
/*  890 */     SFightEndRes res = new SFightEndRes();
/*  891 */     res.seq = seq;
/*  892 */     res.result = state;
/*  893 */     OnlineManager.getInstance().sendMulti(res, roleList);
/*      */   }
/*      */   
/*      */   static void broadCastSMarkMonsterRes(int seq, Octets octets, Collection<Long> roleList)
/*      */   {
/*  898 */     SMarkMonsterRes res = new SMarkMonsterRes();
/*  899 */     res.seq = seq;
/*  900 */     res.content = octets;
/*  901 */     OnlineManager.getInstance().sendMulti(res, roleList);
/*      */   }
/*      */   
/*      */   static void trnsferToWorld(long roleid)
/*      */   {
/*  906 */     long w = MapInterface.getCenterWorldid();
/*  907 */     MapInterface.transferToScene(roleid, w, SHulaCfgConsts.getInstance().EXIT_MAP_ID);
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
/*      */   static void addPoint(Map<Long, HulaInfo> roleid2HualaInfo, int addpoint, int killmosterid, Map<Integer, Integer> delete_type_2_count, Map<Integer, Integer> delete_monsterid_2_count, boolean isTurnBegin)
/*      */   {
/*  920 */     for (Iterator i$ = roleid2HualaInfo.keySet().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */       
/*  922 */       HulaInfo xHulaInfo = (HulaInfo)roleid2HualaInfo.get(Long.valueOf(roleid));
/*  923 */       if (xHulaInfo != null)
/*      */       {
/*  925 */         xHulaInfo.setPoint(xHulaInfo.getPoint() + addpoint);
/*  926 */         if (isTurnBegin)
/*      */         {
/*  928 */           xHulaInfo.setTurnpoint(addpoint);
/*      */         }
/*      */         else
/*      */         {
/*  932 */           xHulaInfo.setTurnpoint(xHulaInfo.getTurnpoint() + addpoint);
/*      */         }
/*  934 */         if (killmosterid != -1)
/*      */         {
/*  936 */           Integer killcount = (Integer)xHulaInfo.getKill_monsterid_2_count().get(Integer.valueOf(killmosterid));
/*  937 */           if (killcount == null)
/*      */           {
/*  939 */             killcount = Integer.valueOf(0);
/*      */           }
/*  941 */           xHulaInfo.getKill_monsterid_2_count().put(Integer.valueOf(killmosterid), Integer.valueOf(killcount.intValue() + 1)); }
/*      */         Iterator i$;
/*  943 */         if (delete_type_2_count != null)
/*      */         {
/*  945 */           for (i$ = delete_type_2_count.keySet().iterator(); i$.hasNext();) { int type = ((Integer)i$.next()).intValue();
/*      */             
/*  947 */             Integer c = (Integer)xHulaInfo.getDelete_type_2_count().get(Integer.valueOf(type));
/*  948 */             if (c == null)
/*      */             {
/*  950 */               c = Integer.valueOf(0);
/*      */             }
/*  952 */             xHulaInfo.getDelete_type_2_count().put(Integer.valueOf(type), Integer.valueOf(c.intValue() + ((Integer)delete_type_2_count.get(Integer.valueOf(type))).intValue()));
/*      */           } }
/*      */         Iterator i$;
/*  955 */         if (delete_monsterid_2_count != null)
/*      */         {
/*  957 */           for (i$ = delete_monsterid_2_count.keySet().iterator(); i$.hasNext();) { int monsterid = ((Integer)i$.next()).intValue();
/*      */             
/*  959 */             Integer c = (Integer)xHulaInfo.getDelete_monsterid_2_count().get(Integer.valueOf(monsterid));
/*  960 */             if (c == null)
/*      */             {
/*  962 */               c = Integer.valueOf(0);
/*      */             }
/*  964 */             xHulaInfo.getDelete_monsterid_2_count().put(Integer.valueOf(monsterid), Integer.valueOf(c.intValue() + ((Integer)delete_monsterid_2_count.get(Integer.valueOf(monsterid))).intValue()));
/*      */           }
/*      */         }
/*      */         
/*  968 */         rankRole(roleid, xHulaInfo);
/*      */       }
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
/*      */   static void offerTurnAward(Map<Long, HulaInfo> roleid2XHulaInfo, int turn)
/*      */   {
/*  982 */     TreeMap<Integer, SPointAwardCfg> point2AwardMap = (TreeMap)SPointAwardCfg.getAll();
/*  983 */     for (Iterator i$ = roleid2XHulaInfo.keySet().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */       
/*  985 */       int turnPoint = ((HulaInfo)roleid2XHulaInfo.get(Long.valueOf(roleid))).getTurnpoint();
/*  986 */       Map.Entry<Integer, SPointAwardCfg> entry = point2AwardMap.floorEntry(Integer.valueOf(turnPoint));
/*  987 */       if (entry == null)
/*      */       {
/*  989 */         String log = String.format("[hula]HulaManager.offerTurnAward@off turn award to role failed,no award cfg find|roles=%s|rewardid=%d|turnpoint=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(turn), Integer.valueOf(turnPoint) });
/*      */         
/*      */ 
/*  992 */         logger.info(log);
/*      */       }
/*      */       else {
/*  995 */         int rewardid = ((SPointAwardCfg)entry.getValue()).rewardid;
/*  996 */         AwardReason awardReason = new AwardReason(LogReason.HULA_ACTIVITY_TURN_AWARD, rewardid);
/*  997 */         AwardModel awardModel = mzm.gsp.award.main.AwardInterface.award(rewardid, RoleInterface.getUserId(roleid), roleid, false, true, awardReason);
/*      */         
/*  999 */         if (awardModel != null)
/*      */         {
/* 1001 */           String log = String.format("[hula]HulaManager.offerTurnAward@off turn award to role success|roleid=%d|rewardid=%d|turn=%d|turnpoint=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(rewardid), Integer.valueOf(turn), Integer.valueOf(turnPoint) });
/*      */           
/*      */ 
/* 1004 */           logger.info(log);
/*      */         }
/*      */         else
/*      */         {
/* 1008 */           String log = String.format("[hula]HulaManager.offerTurnAward@off turn award to role failed|roleid=%d|rewardid=%d|turn=%d|turnpoint=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(rewardid), Integer.valueOf(turn), Integer.valueOf(turnPoint) });
/*      */           
/*      */ 
/* 1011 */           logger.error(log);
/*      */         }
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean isLastTurn(int turn)
/*      */   {
/* 1020 */     return turn + 1 >= SHulaCfgConsts.getInstance().TOTAL_TURNS;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   static void brodcastSSynActivityResultRes(Collection<Long> roleList, HulaInfo xHulaInfo)
/*      */   {
/* 1032 */     if (xHulaInfo != null)
/*      */     {
/* 1034 */       SSynActivityResultRes res = new SSynActivityResultRes();
/* 1035 */       res.delete_type_2_count.putAll(xHulaInfo.getDelete_type_2_count());
/* 1036 */       res.kill_monsterid_2_count.putAll(xHulaInfo.getKill_monsterid_2_count());
/* 1037 */       res.delete_monsterid_2_count.putAll(xHulaInfo.getDelete_monsterid_2_count());
/* 1038 */       res.point = xHulaInfo.getPoint();
/* 1039 */       OnlineManager.getInstance().sendMulti(res, roleList);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   static Map<Long, HulaInfo> getXRoleid2HulaInfo(Collection<Long> roleSet)
/*      */   {
/* 1046 */     Map<Long, HulaInfo> map = new HashMap();
/* 1047 */     for (Iterator i$ = roleSet.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */       
/* 1049 */       HulaInfo xHulaInfo = Role2hula.get(Long.valueOf(roleid));
/* 1050 */       if (xHulaInfo == null)
/*      */       {
/* 1052 */         xHulaInfo = Pod.newHulaInfo();
/* 1053 */         Role2hula.insert(Long.valueOf(roleid), xHulaInfo);
/*      */       }
/*      */       
/* 1056 */       map.put(Long.valueOf(roleid), xHulaInfo);
/*      */     }
/* 1058 */     return map;
/*      */   }
/*      */   
/*      */   static boolean isHulaMap(int mapid)
/*      */   {
/* 1063 */     return (mapid == SHulaCfgConsts.getInstance().MAP_ID) || (mapid == SHulaCfgConsts.getInstance().PREPARE_MAP_ID);
/*      */   }
/*      */   
/*      */   static void synSSynMonsterStateRes(int seq, int state, Collection<Long> roles)
/*      */   {
/* 1068 */     SSynMonsterStateRes res = new SSynMonsterStateRes();
/* 1069 */     res.seq = seq;
/* 1070 */     res.state = state;
/* 1071 */     OnlineManager.getInstance().sendMulti(res, roles);
/*      */   }
/*      */   
/*      */   static void synSSynMonsterListRes(long roleid, int stage, HulaInfo xHulaInfo, HulaWorldInfo xHulaWorldInfo)
/*      */     throws UnsupportedEncodingException
/*      */   {
/* 1077 */     SSynMonsterListRes res = new SSynMonsterListRes();
/* 1078 */     res.maxseq = xHulaWorldInfo.getMaxseq();
/* 1079 */     res.turn = (getTurn(stage) + 1);
/* 1080 */     res.stage = getStageEnum(stage);
/* 1081 */     res.point = xHulaInfo.getPoint();
/* 1082 */     for (HulaMonsterInfo xHulaMonsterInfo : xHulaWorldInfo.getMonsters())
/*      */     {
/* 1084 */       MonsterInfo monsterInfo = new MonsterInfo();
/* 1085 */       monsterInfo.content.setString(xHulaMonsterInfo.getMark_content(), "UTF-8");
/* 1086 */       monsterInfo.seq = xHulaMonsterInfo.getSeq();
/* 1087 */       monsterInfo.state = xHulaMonsterInfo.getState();
/* 1088 */       monsterInfo.monsterid = xHulaMonsterInfo.getMonsterid();
/* 1089 */       res.monsterlist.add(monsterInfo);
/*      */     }
/* 1091 */     OnlineManager.getInstance().send(roleid, res);
/*      */   }
/*      */   
/*      */   static void clearRank()
/*      */   {
/* 1096 */     HulaChart.getInstance().clear();
/*      */   }
/*      */   
/*      */   static void offerRankAward()
/*      */   {
/* 1101 */     List<HulaChartObj> hulaChartObjs = HulaChart.getInstance().getAllChartObjs();
/*      */     
/* 1103 */     for (int i = 0; i < hulaChartObjs.size(); i++)
/*      */     {
/* 1105 */       long roleid = ((HulaChartObj)hulaChartObjs.get(i)).getRoleid();
/* 1106 */       int point = ((HulaChartObj)hulaChartObjs.get(i)).getScore();
/*      */       
/* 1108 */       if (isHulaSwitchOpenForRole(roleid))
/*      */       {
/* 1110 */         NoneRealTimeTaskManager.getInstance().addTask(new AwardProcedure(roleid, i, 25, point));
/*      */       }
/*      */       else
/*      */       {
/* 1114 */         String logstr = String.format("[hula]HulaManager.offerRankAward@hula switch is closed for role|roleid=%d|rank=%d|point=%d", new Object[] { Long.valueOf(roleid), Integer.valueOf(i), Integer.valueOf(point) });
/*      */         
/*      */ 
/* 1117 */         logger.info(logstr);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   private static class AwardProcedure
/*      */     extends LogicProcedure
/*      */   {
/*      */     private final long roleid;
/*      */     private final int rank;
/*      */     private final int chartType;
/*      */     private final int point;
/*      */     
/*      */     public AwardProcedure(long roleid, int rank, int chartType, int point)
/*      */     {
/* 1132 */       this.roleid = roleid;
/* 1133 */       this.rank = rank;
/* 1134 */       this.chartType = chartType;
/* 1135 */       this.point = point;
/*      */     }
/*      */     
/*      */ 
/*      */     protected boolean processImp()
/*      */       throws Exception
/*      */     {
/* 1142 */       String userid = RoleInterface.getUserId(this.roleid);
/* 1143 */       lock(User.getTable(), Arrays.asList(new String[] { userid }));
/* 1144 */       lock(Role2properties.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/* 1145 */       mzm.gsp.chart.main.RankInterface.sendChartAward(userid, this.roleid, this.chartType, this.rank);
/*      */       
/* 1147 */       String logstr = String.format("[hula]AwardProcedure.processImp@send hula rank award to role|roleid=%d|chart_type=%d|rank=%d|point=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.chartType), Integer.valueOf(this.rank), Integer.valueOf(this.point) });
/*      */       
/*      */ 
/* 1150 */       HulaManager.logger.info(logstr);
/*      */       
/* 1152 */       return true;
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
/*      */   static int getRolePoint(long roleid)
/*      */   {
/* 1165 */     Integer point = Role2hula.selectPoint(Long.valueOf(roleid));
/* 1166 */     if (point == null)
/*      */     {
/* 1168 */       return 0;
/*      */     }
/* 1170 */     return point.intValue();
/*      */   }
/*      */   
/*      */   static Map<Integer, Integer> getRoleAllDeleteTypes(long roleId)
/*      */   {
/* 1175 */     Map<Integer, Integer> types = Role2hula.selectDelete_type_2_count(Long.valueOf(roleId));
/* 1176 */     return types;
/*      */   }
/*      */   
/*      */   static boolean isInHulaPrepareWorld(long roleid)
/*      */   {
/* 1181 */     long roleWorldId = MapInterface.getRoleWorldInstanceId(roleid);
/* 1182 */     return HulaWorldManager.getInstance().isHulaPrepareWorld(roleWorldId);
/*      */   }
/*      */   
/*      */ 
/*      */   static boolean isInHulaFubenWorld(long roleid)
/*      */   {
/* 1188 */     long roleWorldId = MapInterface.getRoleWorldInstanceId(roleid);
/* 1189 */     return HulaWorldManager.getInstance().isHulaFubenWorld(roleWorldId);
/*      */   }
/*      */   
/*      */ 
/*      */   static String getMonsterString(HulaWorldInfo xHulaWorldInfo)
/*      */   {
/* 1195 */     if (xHulaWorldInfo == null)
/*      */     {
/* 1197 */       return "";
/*      */     }
/* 1199 */     int offset = getFirstMonsterId();
/* 1200 */     StringBuffer sb = new StringBuffer();
/* 1201 */     for (HulaMonsterInfo xHulaMonsterInfo : xHulaWorldInfo.getMonsters())
/*      */     {
/* 1203 */       sb.append(xHulaMonsterInfo.getSeq()).append("=").append(xHulaMonsterInfo.getMonsterid() - offset).append(",");
/*      */     }
/* 1205 */     if (sb.length() == 0)
/*      */     {
/* 1207 */       return "";
/*      */     }
/*      */     
/*      */ 
/* 1211 */     return sb.substring(0, sb.length() - 1);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static String getNewAddMonsterString(HulaWorldInfo xHulaWorldInfo, int addNum)
/*      */   {
/* 1218 */     if ((xHulaWorldInfo == null) || (xHulaWorldInfo.getMonsters().isEmpty()))
/*      */     {
/* 1220 */       return "";
/*      */     }
/* 1222 */     int offset = getFirstMonsterId();
/* 1223 */     StringBuffer sb = new StringBuffer();
/* 1224 */     for (int i = xHulaWorldInfo.getMonsters().size() - 1; i >= Math.max(0, xHulaWorldInfo.getMonsters().size() - addNum); i--)
/*      */     {
/* 1226 */       HulaMonsterInfo xHulaMonsterInfo = (HulaMonsterInfo)xHulaWorldInfo.getMonsters().get(i);
/* 1227 */       sb.append(xHulaMonsterInfo.getSeq()).append("=").append(xHulaMonsterInfo.getMonsterid() - offset).append(",");
/*      */     }
/* 1229 */     if (sb.length() == 0)
/*      */     {
/* 1231 */       return "";
/*      */     }
/*      */     
/*      */ 
/* 1235 */     return sb.substring(0, sb.length() - 1);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   static int getFirstMonsterId()
/*      */   {
/* 1242 */     Map<Integer, SDoudouCfg> map = SDoudouCfg.getAll();
/* 1243 */     if ((map instanceof TreeMap))
/*      */     {
/* 1245 */       return ((Integer)((TreeMap)SDoudouCfg.getAll()).firstKey()).intValue();
/*      */     }
/*      */     
/*      */ 
/* 1249 */     return ((Integer)Collections.min(SDoudouCfg.getAll().keySet())).intValue();
/*      */   }
/*      */   
/*      */ 
/*      */   static List<Integer> getSrcRandomModelIds()
/*      */   {
/* 1255 */     Map<Integer, SDoudouCfg> map = SDoudouCfg.getAll();
/* 1256 */     if ((map instanceof TreeMap))
/*      */     {
/* 1258 */       return new ArrayList(map.keySet());
/*      */     }
/*      */     
/*      */ 
/* 1262 */     List<Integer> srcRandomModelIds = new ArrayList(map.keySet());
/* 1263 */     Collections.sort(srcRandomModelIds);
/* 1264 */     return srcRandomModelIds;
/*      */   }
/*      */   
/*      */ 
/*      */   static String getTeammateString(Collection<Long> roles)
/*      */   {
/* 1270 */     if ((roles == null) || (roles.isEmpty()))
/*      */     {
/* 1272 */       return "";
/*      */     }
/* 1274 */     StringBuffer sb = new StringBuffer();
/* 1275 */     for (Iterator i$ = roles.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*      */       
/* 1277 */       sb.append(roleid).append(",");
/*      */     }
/* 1279 */     return sb.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   static void tlogHulaturnbegin(long roleid, String teamMateString, int turn, String oldMonsterids, String addMonsterids, int totalPoint, int cutPoint)
/*      */   {
/* 1285 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 1286 */     String userid = RoleInterface.getUserId(roleid);
/* 1287 */     int roleLevel = RoleInterface.getLevel(roleid);
/*      */     
/* 1289 */     Object[] columnns = { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(roleLevel), teamMateString, Integer.valueOf(turn), oldMonsterids.substring(0, Math.min(oldMonsterids.length(), 1000)), addMonsterids.substring(0, Math.min(addMonsterids.length(), 1000)), Integer.valueOf(totalPoint), Integer.valueOf(cutPoint) };
/*      */     
/*      */ 
/* 1292 */     TLogManager.getInstance().addLog(userid, roleid, "Hulaturnbegin", columnns);
/*      */   }
/*      */   
/*      */   static String getDeleteTypeString(Map<Integer, Integer> deleMap)
/*      */   {
/* 1297 */     if (deleMap == null)
/*      */     {
/* 1299 */       return "";
/*      */     }
/* 1301 */     StringBuffer sb = new StringBuffer();
/* 1302 */     for (Iterator i$ = deleMap.keySet().iterator(); i$.hasNext();) { int key = ((Integer)i$.next()).intValue();
/*      */       
/* 1304 */       sb.append(key).append("=").append(deleMap.get(Integer.valueOf(key))).append(",");
/*      */     }
/* 1306 */     if (sb.length() == 0)
/*      */     {
/* 1308 */       return "";
/*      */     }
/*      */     
/*      */ 
/* 1312 */     return sb.substring(0, sb.length() - 1);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */   static void tlogHulaturnend(long roleid, String teamMateString, int turn, String beforeMonsterids, String afterMonsterids, int totalPoint, String deleteTypeString, int turnPoint)
/*      */   {
/* 1320 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 1321 */     String userid = RoleInterface.getUserId(roleid);
/* 1322 */     int roleLevel = RoleInterface.getLevel(roleid);
/*      */     
/* 1324 */     Object[] columnns = { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(roleLevel), teamMateString, Integer.valueOf(turn), beforeMonsterids.substring(0, Math.min(beforeMonsterids.length(), 1000)), afterMonsterids.substring(0, Math.min(afterMonsterids.length(), 1000)), Integer.valueOf(totalPoint), deleteTypeString, Integer.valueOf(turnPoint) };
/*      */     
/*      */ 
/*      */ 
/* 1328 */     TLogManager.getInstance().addLog(userid, roleid, "Hulaturnend", columnns);
/*      */   }
/*      */   
/*      */ 
/*      */   static void tlogHulafight(long roleid, int turn, HulaWorldInfo xHulaWorldInfo, int totalPoint, int killMonsterid, int killMonsterseq, int killResult)
/*      */   {
/* 1334 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 1335 */     String userid = RoleInterface.getUserId(roleid);
/* 1336 */     int roleLevel = RoleInterface.getLevel(roleid);
/* 1337 */     String monsterIds = getMonsterString(xHulaWorldInfo);
/* 1338 */     String teamMateString = getTeammateString(xHulaWorldInfo.getRoleids());
/*      */     
/* 1340 */     Object[] columnns = { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(roleLevel), teamMateString, Integer.valueOf(turn), monsterIds.substring(0, Math.min(monsterIds.length(), 1000)), Integer.valueOf(totalPoint), Integer.valueOf(killMonsterid), Integer.valueOf(killMonsterseq), Integer.valueOf(killResult) };
/*      */     
/*      */ 
/* 1343 */     TLogManager.getInstance().addLog(userid, roleid, "Hulafight", columnns);
/*      */   }
/*      */   
/*      */ 
/*      */   static void tlogHulamark(long roleid, int turn, HulaWorldInfo xHulaWorldInfo, int totalPoint, int markmonsterId, int markmonsterSeq, String markString)
/*      */   {
/* 1349 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 1350 */     String userid = RoleInterface.getUserId(roleid);
/* 1351 */     int roleLevel = RoleInterface.getLevel(roleid);
/* 1352 */     String monsterIds = getMonsterString(xHulaWorldInfo);
/* 1353 */     String teamMateString = getTeammateString(xHulaWorldInfo.getRoleids());
/* 1354 */     Object[] columnns = { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(roleLevel), teamMateString, Integer.valueOf(turn), monsterIds.substring(0, Math.min(monsterIds.length(), 1000)), Integer.valueOf(totalPoint), Integer.valueOf(markmonsterId), Integer.valueOf(markmonsterSeq), markString };
/*      */     
/*      */ 
/*      */ 
/* 1358 */     TLogManager.getInstance().addLog(userid, roleid, "Hulamark", columnns);
/*      */   }
/*      */   
/*      */ 
/*      */   static void rankRole(long roleid, HulaInfo xHulaInfo)
/*      */   {
/* 1364 */     int totalpoint = xHulaInfo.getPoint();
/* 1365 */     if (totalpoint <= 0)
/*      */     {
/* 1367 */       HulaChart.getInstance().delete(Long.valueOf(roleid));
/*      */     }
/*      */     else
/*      */     {
/* 1371 */       Map<Integer, Integer> deleteTypes = getRoleAllDeleteTypes(roleid);
/* 1372 */       HulaChart.getInstance().rank(new HulaChartObj(roleid, totalpoint, deleteTypes));
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\main\HulaManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */