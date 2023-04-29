/*     */ package mzm.gsp.question.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.NavigableMap;
/*     */ import java.util.Set;
/*     */ import java.util.TreeMap;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.event.TriggerEventsManger;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.bulletin.SBulletinInfo;
/*     */ import mzm.gsp.bulletin.main.BulletinInterface;
/*     */ import mzm.gsp.mail.main.MailInterface;
/*     */ import mzm.gsp.map.main.ControllerInterface;
/*     */ import mzm.gsp.map.main.MapInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.question.KeJuChart;
/*     */ import mzm.gsp.question.KeJuState;
/*     */ import mzm.gsp.question.SKeJuRankRes;
/*     */ import mzm.gsp.question.SSyncFinishHuiShi;
/*     */ import mzm.gsp.question.SSyncKeJuZiGeReq;
/*     */ import mzm.gsp.question.confbean.KeJuQuestionConsts;
/*     */ import mzm.gsp.question.confbean.SDianShiNewQuestionCfg;
/*     */ import mzm.gsp.question.confbean.SQuestionLv2QuestionItemId;
/*     */ import mzm.gsp.question.event.KeJuEnd;
/*     */ import mzm.gsp.question.event.KeJuEndArg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.CommonUtils;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.GlobleKeJuInfo;
/*     */ import xbean.KeJuInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Gloablekeju;
/*     */ import xtable.Role2keju;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class KeJuQuestionManager
/*     */ {
/*  59 */   private static KeJuQuestionManager instance = new KeJuQuestionManager();
/*     */   
/*     */   static final int KEJU_RIGHT_ANSWER_IDX = 0;
/*     */   
/*  63 */   static Logger logger = null;
/*     */   
/*     */   public static KeJuQuestionManager getInstance()
/*     */   {
/*  67 */     return instance;
/*     */   }
/*     */   
/*     */ 
/*     */   public void init()
/*     */   {
/*  73 */     logger = Logger.getLogger("Keju");
/*  74 */     ActivityInterface.registerActivityByLogicType(14, new KeJuQuestionActivity());
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
/*     */   public List<Integer> randomQuestionByType(int questionLv)
/*     */   {
/*  87 */     List<Integer> idList = new ArrayList();
/*  88 */     List<Integer> questionList = SQuestionLv2QuestionItemId.get(questionLv).questionIds;
/*  89 */     int num = 0;
/*  90 */     switch (questionLv)
/*     */     {
/*     */     case 1: 
/*  93 */       num = KeJuQuestionConsts.getInstance().XIANGSHI_QUESTION_NUM;
/*  94 */       CommonUtils.regionRandom(questionList, num, idList);
/*  95 */       break;
/*     */     case 3: 
/*  97 */       idList.addAll(randomDianShiQuestion(questionList));
/*  98 */       break;
/*     */     case 2: 
/* 100 */       num = KeJuQuestionConsts.getInstance().HUIGSHI_QUESTION_NUM;
/* 101 */       CommonUtils.regionRandom(questionList, num, idList);
/* 102 */       break;
/*     */     }
/*     */     
/*     */     
/*     */ 
/*     */ 
/* 108 */     return idList;
/*     */   }
/*     */   
/*     */   private static List<Integer> randomDianShiQuestion(List<Integer> allids)
/*     */   {
/* 113 */     List<Integer> oldids = new ArrayList();
/* 114 */     oldids.addAll(allids);
/* 115 */     List<Integer> result = new ArrayList();
/* 116 */     int timestamp = (int)(DateTimeUtils.getBeginTimeOfCurrDay(DateTimeUtils.getCurrTimeInMillis()) / 1000L);
/* 117 */     TreeMap<Integer, SDianShiNewQuestionCfg> treeMap = (TreeMap)SDianShiNewQuestionCfg.getAll();
/* 118 */     List<Integer> newids = new ArrayList();
/* 119 */     if (treeMap.containsKey(Integer.valueOf(timestamp)))
/*     */     {
/* 121 */       newids.addAll(((SDianShiNewQuestionCfg)treeMap.get(Integer.valueOf(timestamp))).questionIds);
/*     */     }
/* 123 */     List<Integer> exceptids = new ArrayList();
/* 124 */     for (SDianShiNewQuestionCfg cfg : treeMap.tailMap(Integer.valueOf(timestamp), false).values())
/*     */     {
/* 126 */       exceptids.addAll(cfg.questionIds);
/*     */     }
/* 128 */     oldids.removeAll(newids);
/* 129 */     oldids.removeAll(exceptids);
/* 130 */     if ((newids.isEmpty()) || (newids.size() < KeJuQuestionConsts.getInstance().DIANSHI_NEW_QUESTION_NUM))
/*     */     {
/* 132 */       CommonUtils.regionRandom(oldids, KeJuQuestionConsts.getInstance().DIANSHI_QUESTION_NUM, result);
/*     */     }
/*     */     else
/*     */     {
/* 136 */       CommonUtils.regionRandom(newids, KeJuQuestionConsts.getInstance().DIANSHI_NEW_QUESTION_NUM, result);
/* 137 */       CommonUtils.regionRandom(oldids, KeJuQuestionConsts.getInstance().DIANSHI_QUESTION_NUM - KeJuQuestionConsts.getInstance().DIANSHI_NEW_QUESTION_NUM, result);
/*     */     }
/*     */     
/* 140 */     return result;
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
/*     */   public List<Integer> randomQuestionByType(int questionLv, int num)
/*     */   {
/* 154 */     List<Integer> idList = new ArrayList();
/* 155 */     SQuestionLv2QuestionItemId questionLv2QuestionItemId = SQuestionLv2QuestionItemId.get(questionLv);
/* 156 */     if (questionLv2QuestionItemId == null)
/*     */     {
/* 158 */       return idList;
/*     */     }
/* 160 */     CommonUtils.regionRandom(questionLv2QuestionItemId.questionIds, num, idList);
/* 161 */     return idList;
/*     */   }
/*     */   
/*     */   SKeJuRankRes getKeJuRankRes()
/*     */   {
/* 166 */     int idx = 0;
/* 167 */     SKeJuRankRes res = new SKeJuRankRes();
/* 168 */     int size = Math.min(KeJuQuestionConsts.getInstance().JINSHI_MIN_MINGCI, KejuRankManager.getInstance().size());
/*     */     
/* 170 */     KejuRankManager.getInstance().getRankObjs(0, size);
/* 171 */     for (RoleKejuChart roleKejuChart : KejuRankManager.getInstance().getRankObjs(0, size))
/*     */     {
/* 173 */       long roleId = roleKejuChart.getKey().longValue();
/* 174 */       KeJuChart keJuChart = new KeJuChart();
/* 175 */       keJuChart.rolename = RoleInterface.getName(roleId);
/* 176 */       keJuChart.ranklevel = (++idx);
/* 177 */       keJuChart.usetime = roleKejuChart.getUsetime();
/* 178 */       keJuChart.roleid = roleId;
/* 179 */       res.ranklist.add(keJuChart);
/*     */     }
/*     */     
/* 182 */     return res;
/*     */   }
/*     */   
/*     */   void synRoleState(int activityStage)
/*     */   {
/* 187 */     for (Iterator i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/*     */ 
/* 190 */       NoneRealTimeTaskManager.getInstance().addTask(new SynKejuStatePro(roleid, activityStage));
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   private static class SynKejuStatePro
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     private final int activityStage;
/*     */     
/*     */     public SynKejuStatePro(long roleid, int activityStage)
/*     */     {
/* 203 */       this.roleid = roleid;
/* 204 */       this.activityStage = activityStage;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 210 */       KeJuInfo xKeJuInfo = Role2keju.select(Long.valueOf(this.roleid));
/* 211 */       if (xKeJuInfo == null)
/*     */       {
/* 213 */         return false;
/*     */       }
/* 215 */       KeJuQuestionManager.getInstance().syncKeJuState(this.roleid, xKeJuInfo, this.activityStage);
/* 216 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   void syncKeJuState(long roleId, KeJuInfo xKeJuInfo, int activityStage)
/*     */   {
/* 223 */     SSyncKeJuZiGeReq sSyncKeJuZiGeReq = new SSyncKeJuZiGeReq();
/*     */     
/* 225 */     if (activityStage < 0)
/*     */     {
/* 227 */       return;
/*     */     }
/*     */     
/* 230 */     int roleKejuState = xKeJuInfo.getState();
/* 231 */     int rightnum = xKeJuInfo.getRightnum();
/*     */     GlobleKeJuInfo xGloableKeJu;
/* 233 */     switch (activityStage)
/*     */     {
/*     */ 
/*     */     case 0: 
/* 237 */       if (roleKejuState == 1)
/*     */       {
/* 239 */         if (!xKeJuInfo.getQuestionlist().isEmpty())
/*     */         {
/*     */ 
/* 242 */           sSyncKeJuZiGeReq.kejustate.add(new KeJuState(1, 5));
/* 243 */           sSyncKeJuZiGeReq.kejustate.add(new KeJuState(2, 4));
/* 244 */           sSyncKeJuZiGeReq.kejustate.add(new KeJuState(3, 4));
/*     */         }
/*     */         else
/*     */         {
/* 248 */           sSyncKeJuZiGeReq.kejustate.add(new KeJuState(1, 6));
/* 249 */           if (rightnum >= KeJuQuestionConsts.getInstance().HUISHI_NEED_RIGHTANSWER_NUM)
/*     */           {
/* 251 */             sSyncKeJuZiGeReq.kejustate.add(new KeJuState(2, 5));
/*     */           }
/*     */           else
/*     */           {
/* 255 */             sSyncKeJuZiGeReq.kejustate.add(new KeJuState(2, 7));
/*     */           }
/* 257 */           sSyncKeJuZiGeReq.kejustate.add(new KeJuState(3, 4));
/*     */         }
/*     */       }
/* 260 */       else if (roleKejuState == 2)
/*     */       {
/*     */ 
/* 263 */         if (!xKeJuInfo.getQuestionlist().isEmpty())
/*     */         {
/* 265 */           sSyncKeJuZiGeReq.kejustate.add(new KeJuState(1, 6));
/* 266 */           sSyncKeJuZiGeReq.kejustate.add(new KeJuState(2, 5));
/* 267 */           sSyncKeJuZiGeReq.kejustate.add(new KeJuState(3, 4));
/*     */         }
/*     */         else
/*     */         {
/* 271 */           sSyncKeJuZiGeReq.kejustate.add(new KeJuState(1, 6));
/* 272 */           sSyncKeJuZiGeReq.kejustate.add(new KeJuState(2, 6));
/* 273 */           sSyncKeJuZiGeReq.kejustate.add(new KeJuState(3, 4));
/*     */         }
/*     */       }
/*     */       
/*     */       break;
/*     */     case 1: 
/* 279 */       if (roleKejuState == 1)
/*     */       {
/* 281 */         sSyncKeJuZiGeReq.kejustate.add(new KeJuState(1, 6));
/*     */         
/* 283 */         if ((xKeJuInfo.getQuestionlist().isEmpty()) && (rightnum >= KeJuQuestionConsts.getInstance().HUISHI_NEED_RIGHTANSWER_NUM))
/*     */         {
/*     */ 
/* 286 */           sSyncKeJuZiGeReq.kejustate.add(new KeJuState(2, 5));
/*     */         }
/*     */         else
/*     */         {
/* 290 */           sSyncKeJuZiGeReq.kejustate.add(new KeJuState(2, 7));
/*     */         }
/* 292 */         sSyncKeJuZiGeReq.kejustate.add(new KeJuState(3, 4));
/*     */ 
/*     */       }
/* 295 */       else if (roleKejuState == 2)
/*     */       {
/* 297 */         sSyncKeJuZiGeReq.kejustate.add(new KeJuState(1, 6));
/* 298 */         if (!xKeJuInfo.getQuestionlist().isEmpty())
/*     */         {
/* 300 */           sSyncKeJuZiGeReq.kejustate.add(new KeJuState(2, 5));
/*     */         }
/*     */         else
/*     */         {
/* 304 */           sSyncKeJuZiGeReq.kejustate.add(new KeJuState(2, 6));
/*     */         }
/* 306 */         sSyncKeJuZiGeReq.kejustate.add(new KeJuState(3, 4));
/*     */       }
/*     */       break;
/*     */     case 2: 
/* 310 */       sSyncKeJuZiGeReq.kejustate.add(new KeJuState(1, 6));
/* 311 */       sSyncKeJuZiGeReq.kejustate.add(new KeJuState(2, 6));
/* 312 */       xGloableKeJu = Gloablekeju.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 313 */       if (xGloableKeJu == null)
/*     */       {
/* 315 */         sSyncKeJuZiGeReq.kejustate.add(new KeJuState(3, 6));
/*     */ 
/*     */ 
/*     */       }
/* 319 */       else if (xKeJuInfo.getIspasshuishi())
/*     */       {
/* 321 */         sSyncKeJuZiGeReq.kejustate.add(new KeJuState(3, 4));
/*     */       }
/*     */       else
/*     */       {
/* 325 */         sSyncKeJuZiGeReq.kejustate.add(new KeJuState(3, 7));
/*     */       }
/*     */       
/*     */ 
/* 329 */       break;
/*     */     case 3: 
/* 331 */       sSyncKeJuZiGeReq.kejustate.add(new KeJuState(1, 6));
/* 332 */       sSyncKeJuZiGeReq.kejustate.add(new KeJuState(2, 6));
/* 333 */       xGloableKeJu = Gloablekeju.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 334 */       if (xGloableKeJu == null)
/*     */       {
/* 336 */         sSyncKeJuZiGeReq.kejustate.add(new KeJuState(3, 6));
/*     */ 
/*     */ 
/*     */       }
/* 340 */       else if (xKeJuInfo.getIspasshuishi())
/*     */       {
/*     */ 
/* 343 */         sSyncKeJuZiGeReq.kejustate.add(new KeJuState(3, 5));
/*     */ 
/*     */       }
/*     */       else
/*     */       {
/* 348 */         sSyncKeJuZiGeReq.kejustate.add(new KeJuState(3, 7));
/*     */       }
/*     */       
/*     */       break;
/*     */     }
/*     */     
/* 354 */     OnlineManager.getInstance().send(roleId, sSyncKeJuZiGeReq);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void initKejuActivityInfo()
/*     */   {
/* 362 */     new InitGlobleKeJuInfoPro(null).execute();
/* 363 */     new ClearKejuRankPro(null).execute();
/*     */   }
/*     */   
/*     */   private static class InitGlobleKeJuInfoPro
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 371 */       GlobleKeJuInfo keJuInfo = Gloablekeju.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 372 */       if (keJuInfo == null)
/*     */       {
/* 374 */         keJuInfo = Pod.newGlobleKeJuInfo();
/* 375 */         Gloablekeju.add(Long.valueOf(GameServerInfoManager.getLocalId()), keJuInfo);
/*     */       }
/* 377 */       keJuInfo.setWorldid(-1L);
/*     */       
/* 379 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   private static class ClearKejuRankPro
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp() throws Exception
/*     */     {
/* 388 */       KejuRankManager.getInstance().clear();
/* 389 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   long getDianshiWorldid()
/*     */   {
/* 400 */     GlobleKeJuInfo keJuInfo = Gloablekeju.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 401 */     if (keJuInfo == null)
/*     */     {
/* 403 */       return -1L;
/*     */     }
/* 405 */     return keJuInfo.getWorldid();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void filterDianShiApp()
/*     */   {
/* 416 */     int passSize = KeJuQuestionConsts.getInstance().DIANSHI_ROLE_NUM;
/* 417 */     List<RoleKejuChart> roleKejuCharts = KejuRankManager.getInstance().getRankObjs(0, passSize - 1);
/*     */     
/* 419 */     SSyncFinishHuiShi sSyncFinishHuiShi = new SSyncFinishHuiShi();
/* 420 */     sSyncFinishHuiShi.ispass = 1;
/*     */     
/* 422 */     Set<Long> roleidSet = new HashSet();
/* 423 */     for (RoleKejuChart r : roleKejuCharts)
/*     */     {
/* 425 */       roleidSet.add(r.getKey());
/* 426 */       NoneRealTimeTaskManager.getInstance().addTask(new PrepareRoleDianshiPro(r.getKey().longValue(), sSyncFinishHuiShi));
/*     */     }
/*     */     
/* 429 */     for (Iterator i$ = OnlineManager.getInstance().getAllRolesInWorld().iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*     */       
/* 431 */       if (!roleidSet.contains(Long.valueOf(roleid)))
/*     */       {
/*     */ 
/*     */ 
/* 435 */         NoneRealTimeTaskManager.getInstance().addTask(new SynKejuStatePro(roleid, 2));
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private static class PrepareRoleDianshiPro
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/* 444 */     private SSyncFinishHuiShi sSyncFinishHuiShi = null;
/*     */     
/*     */     public PrepareRoleDianshiPro(long roleid, SSyncFinishHuiShi sSyncFinishHuiShi)
/*     */     {
/* 448 */       this.roleid = roleid;
/* 449 */       this.sSyncFinishHuiShi = sSyncFinishHuiShi;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 455 */       KeJuInfo xKeJuInfo = Role2keju.get(Long.valueOf(this.roleid));
/* 456 */       if (xKeJuInfo == null)
/*     */       {
/* 458 */         return false;
/*     */       }
/* 460 */       xKeJuInfo.setIspasshuishi(true);
/* 461 */       KeJuQuestionManager.getInstance().syncKeJuState(this.roleid, xKeJuInfo, 2);
/* 462 */       OnlineManager.getInstance().send(this.roleid, this.sSyncFinishHuiShi);
/* 463 */       MailInterface.synBuildAndSendMail(this.roleid, KeJuQuestionConsts.getInstance().DIANSHI_ENTER_MAIL_ID, null, null, null);
/* 464 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   void initDianshiData()
/*     */   {
/* 473 */     new InitRoleDianshiDataPro(null).execute();
/*     */   }
/*     */   
/*     */   private static class InitRoleDianshiDataPro
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 482 */       int passSize = KeJuQuestionConsts.getInstance().DIANSHI_ROLE_NUM;
/* 483 */       List<RoleKejuChart> roleKejuCharts = KejuRankManager.getInstance().getRankObjs(0, passSize - 1);
/*     */       
/* 485 */       long begintime = DateTimeUtils.getCurrTimeInMillis();
/* 486 */       for (RoleKejuChart roleKejuChart : roleKejuCharts)
/*     */       {
/* 488 */         NoneRealTimeTaskManager.getInstance().addTask(new PStartDianShi(roleKejuChart.getKey().longValue(), begintime));
/*     */       }
/*     */       
/* 491 */       KejuRankManager.getInstance().clear();
/* 492 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   void closeNpcAndWorld()
/*     */   {
/* 498 */     ControllerInterface.collectController(KeJuQuestionConsts.getInstance().DIANSHI_NPC_CONTROLLER_ID);
/* 499 */     ControllerInterface.collectController(KeJuQuestionConsts.getInstance().XIANGSHI_NPC_CONTROLLER_ID);
/* 500 */     ControllerInterface.collectController(KeJuQuestionConsts.getInstance().HUISHI_NPC_CONTROLLER_ID);
/*     */     
/* 502 */     new DestroyDianshiWorldPro(null).execute();
/*     */   }
/*     */   
/*     */   private static class DestroyDianshiWorldPro
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 511 */       MapInterface.destroyWorld(KeJuQuestionManager.getInstance().getDianshiWorldid());
/* 512 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   void offerAwardMail()
/*     */   {
/* 518 */     int size = Math.min(KeJuQuestionConsts.getInstance().JINSHI_MIN_MINGCI, KejuRankManager.getInstance().size());
/* 519 */     int zhuangyuan = 0;
/* 520 */     int bangyan = 1;
/* 521 */     int tanhua = 2;
/* 522 */     List<Long> top3IdList = new ArrayList();
/* 523 */     for (int i = 0; i < size; i++)
/*     */     {
/*     */ 
/*     */ 
/* 527 */       long roleid = ((Long)KejuRankManager.getInstance().getKeyByRank(i)).longValue();
/* 528 */       int mailId; LogReason ir; switch (i)
/*     */       {
/*     */       case 0: 
/* 531 */         mailId = KeJuQuestionConsts.getInstance().ZHUANGYUAN_MAIL_ID;
/* 532 */         ir = LogReason.KEJU_ACTIVITY_ZHUANGYUAN_AWARD;
/* 533 */         top3IdList.add(Long.valueOf(roleid));
/* 534 */         break;
/*     */       case 1: 
/* 536 */         mailId = KeJuQuestionConsts.getInstance().BANGYAN_MAIL_ID;
/* 537 */         ir = LogReason.KEJU_ACTIVITY_BANGYAN_AWARD;
/* 538 */         top3IdList.add(Long.valueOf(roleid));
/* 539 */         break;
/*     */       case 2: 
/* 541 */         mailId = KeJuQuestionConsts.getInstance().TANHUA_MAIL_ID;
/* 542 */         ir = LogReason.KEJU_ACTIVITY_TANHUA_AWARD;
/* 543 */         top3IdList.add(Long.valueOf(roleid));
/* 544 */         break;
/*     */       default: 
/* 546 */         mailId = KeJuQuestionConsts.getInstance().JINSHI_MAIL_ID;
/* 547 */         ir = LogReason.KEJU_ACTIVITY_JINSHI_AWARD;
/*     */       }
/*     */       
/* 550 */       MailInterface.asynBuildAndSendMail(roleid, mailId, null, null, new TLogArg(ir));
/*     */       
/*     */ 
/* 553 */       addTLog(roleid, "KejuRankForServer", new Object[] { Integer.valueOf(i + 1), Integer.valueOf(mailId) });
/*     */     }
/* 555 */     if (!top3IdList.isEmpty())
/*     */     {
/*     */ 
/* 558 */       new SendKejuBulletinPro(top3IdList).execute();
/*     */     }
/*     */     
/*     */ 
/* 562 */     List<RoleKejuChart> allChartObjs = KejuRankManager.getInstance().getAllChartObjs();
/* 563 */     List<Long> rankList = new ArrayList();
/* 564 */     for (RoleKejuChart chartObj : allChartObjs)
/*     */     {
/* 566 */       rankList.add(chartObj.getKey());
/*     */     }
/* 568 */     TriggerEventsManger.getInstance().triggerEvent(new KeJuEnd(), new KeJuEndArg(rankList));
/*     */   }
/*     */   
/*     */   private static class SendKejuBulletinPro extends LogicProcedure
/*     */   {
/*     */     private List<Long> top3IdList;
/*     */     
/*     */     public SendKejuBulletinPro(List<Long> top3IdList)
/*     */     {
/* 577 */       this.top3IdList = top3IdList;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 583 */       SBulletinInfo bulletinInfo = new SBulletinInfo();
/* 584 */       bulletinInfo.bulletintype = 20;
/* 585 */       if (this.top3IdList.size() == 1)
/*     */       {
/* 587 */         bulletinInfo.params.put(Integer.valueOf(1), RoleInterface.getName(((Long)this.top3IdList.get(0)).longValue()));
/*     */       }
/* 589 */       else if (this.top3IdList.size() == 2)
/*     */       {
/* 591 */         bulletinInfo.params.put(Integer.valueOf(1), RoleInterface.getName(((Long)this.top3IdList.get(0)).longValue()));
/* 592 */         bulletinInfo.params.put(Integer.valueOf(2), RoleInterface.getName(((Long)this.top3IdList.get(1)).longValue()));
/*     */       }
/* 594 */       else if (this.top3IdList.size() == 3)
/*     */       {
/* 596 */         bulletinInfo.params.put(Integer.valueOf(1), RoleInterface.getName(((Long)this.top3IdList.get(0)).longValue()));
/* 597 */         bulletinInfo.params.put(Integer.valueOf(2), RoleInterface.getName(((Long)this.top3IdList.get(1)).longValue()));
/* 598 */         bulletinInfo.params.put(Integer.valueOf(18), RoleInterface.getName(((Long)this.top3IdList.get(2)).longValue()));
/*     */       }
/* 600 */       BulletinInterface.sendBulletin(bulletinInfo);
/* 601 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */   void createDiuanshiWorld()
/*     */   {
/* 607 */     new CreateDianshiWorldPro(null).execute();
/*     */   }
/*     */   
/*     */   private static class CreateDianshiWorldPro
/*     */     extends LogicProcedure
/*     */   {
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 616 */       long worlid = MapInterface.createWorld(Arrays.asList(new Integer[] { Integer.valueOf(KeJuQuestionConsts.getInstance().DIANSHI_MAP_ID) }));
/* 617 */       GlobleKeJuInfo keJuInfo = Gloablekeju.get(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 618 */       keJuInfo.setWorldid(worlid);
/* 619 */       return true;
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void addHuishiResult(long roleid, int totalTime)
/*     */   {
/* 631 */     KejuRankManager.getInstance().rank(new RoleKejuChart(roleid, totalTime));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   void addDianshiResult(long roleid, int usetime)
/*     */   {
/* 643 */     KejuRankManager.getInstance().rank(new RoleKejuChart(roleid, usetime));
/*     */   }
/*     */   
/*     */ 
/*     */   int getDianshiUsetime(long roleid, boolean islock)
/*     */   {
/* 649 */     KeJuInfo keJuInfo = null;
/* 650 */     if (islock)
/*     */     {
/* 652 */       keJuInfo = Role2keju.get(Long.valueOf(roleid));
/*     */     }
/*     */     else
/*     */     {
/* 656 */       keJuInfo = Role2keju.select(Long.valueOf(roleid));
/*     */     }
/* 658 */     if (keJuInfo == null)
/*     */     {
/* 660 */       return 0;
/*     */     }
/* 662 */     return (int)(TimeUnit.MILLISECONDS.toSeconds(keJuInfo.getFinishtime() - keJuInfo.getStarttime()) + keJuInfo.getPunishtime());
/*     */   }
/*     */   
/*     */ 
/*     */   boolean isKejuSwitchOpenForRole(long roleid)
/*     */   {
/* 668 */     if (!OpenInterface.getOpenStatus(33))
/*     */     {
/* 670 */       OpenInterface.sendCloseProtocol(roleid, 33, null);
/*     */       
/* 672 */       return false;
/*     */     }
/* 674 */     if (OpenInterface.isBanPlay(roleid, 33))
/*     */     {
/* 676 */       OpenInterface.sendBanPlayMsg(roleid, 33);
/* 677 */       return false;
/*     */     }
/* 679 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   void addTLog(long roleid, String logName, Object... logColumns)
/*     */   {
/* 685 */     String vGameIp = GameServerInfoManager.getHostIP();
/* 686 */     int roleLevel = RoleInterface.getLevel(roleid);
/* 687 */     String userid = RoleInterface.getUserId(roleid);
/*     */     
/* 689 */     StringBuilder logStr = new StringBuilder();
/* 690 */     logStr.append(vGameIp);
/* 691 */     logStr.append("|").append(userid);
/* 692 */     logStr.append("|").append(roleid);
/* 693 */     logStr.append("|").append(roleLevel);
/*     */     
/* 695 */     for (Object colum : logColumns)
/*     */     {
/* 697 */       logStr.append("|").append(colum);
/*     */     }
/*     */     
/* 700 */     TLogManager.getInstance().addLog(roleid, logName, logStr.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\KeJuQuestionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */