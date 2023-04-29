/*     */ package mzm.gsp.question.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.question.AnswerInfo;
/*     */ import mzm.gsp.question.SAnswerPictureQuestionRes;
/*     */ import mzm.gsp.question.SSyncPictureQuestionInfo;
/*     */ import mzm.gsp.question.confbean.SPictureQuestionLevelCfg;
/*     */ import mzm.gsp.question.confbean.SWordQuestionLevelCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.timer.main.Session;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.KeJuInfo;
/*     */ import xbean.PictureInfo;
/*     */ import xbean.PictureQuestionInfo;
/*     */ import xbean.Pod;
/*     */ import xbean.RolePictureQuestionInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Picturequestion;
/*     */ import xtable.Role2keju;
/*     */ import xtable.Role2picturequestion;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class QuestionInterface
/*     */ {
/*     */   public static void startPictureQuestion(long questionid)
/*     */   {
/*  43 */     PictureQuestionManager.getInstance().startPictureQuestion(questionid);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void preparePictureQuestion(List<Long> roleIdList, int levelCfgId, Object attachObject)
/*     */   {
/*  55 */     PictureQuestionManager.getInstance().preparePictureQuestion(roleIdList, levelCfgId, attachObject);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void stopPictureQuestion(long roleId, boolean issuccess)
/*     */   {
/*  66 */     NoneRealTimeTaskManager.getInstance().addTask(new LogicProcedure()
/*     */     {
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/*  71 */         RolePictureQuestionInfo xRoleInfo = Role2picturequestion.select(Long.valueOf(this.val$roleId));
/*  72 */         if (xRoleInfo == null)
/*     */         {
/*  74 */           return false;
/*     */         }
/*     */         
/*  77 */         final List<Long> roleList = Picturequestion.selectRoleidlist(Long.valueOf(xRoleInfo.getPicinfoid()));
/*  78 */         long sessionid = Picturequestion.selectSessionid(Long.valueOf(xRoleInfo.getPicinfoid())).longValue();
/*  79 */         Lockeys.lock(Role2picturequestion.getTable(), roleList);
/*     */         
/*  81 */         PictureInfo pictureInfo = Picturequestion.get(Long.valueOf(xRoleInfo.getPicinfoid()));
/*  82 */         SSyncPictureQuestionInfo sSyncPictureQuestionInfo = new SSyncPictureQuestionInfo();
/*     */         
/*  84 */         SPictureQuestionLevelCfg cfg = SPictureQuestionLevelCfg.get(pictureInfo.getQuestionlevelcfgid());
/*  85 */         sSyncPictureQuestionInfo.answerroleid = ((Long)roleList.get(0)).longValue();
/*  86 */         sSyncPictureQuestionInfo.remainhelpercount = cfg.helpCount;
/*  87 */         for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */           
/*  89 */           AnswerInfo answerInfo = new AnswerInfo();
/*  90 */           PictureQuestionManager.getInstance().fillMember(roleId, answerInfo);
/*  91 */           sSyncPictureQuestionInfo.answerlist.add(answerInfo);
/*     */         }
/*  93 */         sSyncPictureQuestionInfo.difficultylevelid = pictureInfo.getQuestionlevelcfgid();
/*  94 */         sSyncPictureQuestionInfo.endtime = ((int)(TimeUnit.MILLISECONDS.toSeconds(DateTimeUtils.getCurrTimeInMillis()) + cfg.everyQuestionPersistTime));
/*  95 */         PictureQuestionManager.getInstance().fillPictureQuestionInfo(sSyncPictureQuestionInfo.info, (PictureQuestionInfo)pictureInfo.getQuestionlist().get(0));
/*     */         
/*     */ 
/*  98 */         OnlineManager.getInstance().sendMulti(sSyncPictureQuestionInfo, roleList);
/*     */         
/* 100 */         for (Iterator i$ = roleList.iterator(); i$.hasNext();) { long r = ((Long)i$.next()).longValue();
/*     */           
/*     */ 
/* 103 */           RolePictureQuestionInfo rInfo = Role2picturequestion.get(Long.valueOf(r));
/* 104 */           if (rInfo != null)
/*     */           {
/*     */ 
/*     */ 
/* 108 */             if (this.val$issuccess)
/*     */             {
/* 110 */               rInfo.setRightnum(10000);
/* 111 */               rInfo.setTotalnum(1);
/*     */             }
/*     */             else
/*     */             {
/* 115 */               rInfo.setRightnum(0);
/* 116 */               rInfo.setTotalnum(1);
/*     */             }
/*     */           }
/*     */         }
/* 120 */         Session session = Session.getSession(sessionid);
/* 121 */         if (session != null)
/*     */         {
/* 123 */           session.stopTimer();
/*     */         }
/*     */         
/* 126 */         PictureQuestionManager.getInstance().end(xRoleInfo.getPicinfoid(), roleList);
/*     */         
/* 128 */         new LogicProcedure()
/*     */         {
/*     */ 
/*     */           protected boolean processImp()
/*     */             throws Exception
/*     */           {
/* 134 */             SAnswerPictureQuestionRes res = new SAnswerPictureQuestionRes();
/* 135 */             res.nextanswerroleid = -1L;
/* 136 */             OnlineManager.getInstance().sendMulti(res, roleList);
/* 137 */             return true;
/*     */           }
/*     */           
/* 140 */         }.execute();
/* 141 */         return true;
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
/*     */   public static void startHuanYueDongFuWordQuestion(List<Long> roleIdList, int levelCfgId, Object attachObject)
/*     */   {
/* 156 */     WordQuestionManager.getInstance().startQuestion(roleIdList, levelCfgId, 4, attachObject);
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
/*     */   public static void startTaskQuestion(List<Long> roleIdList, int levelCfgId, int questionType, Object attachObject)
/*     */   {
/* 169 */     WordQuestionManager.getInstance().startQuestion(roleIdList, levelCfgId, questionType, attachObject);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isWordQuestionLevelCfgExist(int wordCfgId)
/*     */   {
/* 181 */     return SWordQuestionLevelCfg.get(wordCfgId) != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static boolean isPictureQuestionLevelCfgExist(int picCfgId)
/*     */   {
/* 193 */     return SPictureQuestionLevelCfg.get(picCfgId) != null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getZhuXianQiYuanActivityId()
/*     */   {
/* 203 */     return EveryDayQuestionManager.getInstance().getActivityId();
/*     */   }
/*     */   
/*     */   public static void tlogQuestion(long roleid, int questiontype, int questionid, boolean isright, int activityid)
/*     */   {
/* 208 */     String logname = "QuestionActivity";
/* 209 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 210 */     String userid = RoleInterface.getUserId(roleid);
/* 211 */     int rolelevel = RoleInterface.getLevel(roleid);
/* 212 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleid), Integer.valueOf(rolelevel), Integer.valueOf(activityid), Integer.valueOf(questiontype), Integer.valueOf(questionid), Integer.valueOf(isright ? 1 : 0) });
/*     */     
/* 214 */     TLogManager.getInstance().addLog(userid, logname, logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void tlogAskQuestionHelp(long roleId, int questionid)
/*     */   {
/* 225 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 226 */     String userid = RoleInterface.getUserId(roleId);
/* 227 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 229 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%s|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(questionid), "", Integer.valueOf(0) });
/* 230 */     TLogManager.getInstance().addLog(roleId, "Questionhelp", logStr);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void tlogHelpAnswerQuestion(long activeHelpRoleId, String beHelpUserId, long beHelpRoleId, int beHelpLevel, int questionCfgId)
/*     */   {
/* 250 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 251 */     String activeHelpUserId = RoleInterface.getUserId(activeHelpRoleId);
/*     */     
/* 253 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%s|%d", new Object[] { vGameIP, beHelpUserId, Long.valueOf(beHelpRoleId), Integer.valueOf(beHelpLevel), Integer.valueOf(0), Integer.valueOf(2), Integer.valueOf(questionCfgId), activeHelpUserId, Long.valueOf(activeHelpRoleId) });
/*     */     
/* 255 */     TLogManager.getInstance().addLog(activeHelpRoleId, "Questionhelp", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getDianshiUsetime(long roleid)
/*     */   {
/* 267 */     return KeJuQuestionManager.getInstance().getDianshiUsetime(roleid, false);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static void insertIntoRankForIdip(long roleid, int seconds)
/*     */   {
/* 279 */     new InsertIntoRankPro(roleid, seconds).execute();
/*     */   }
/*     */   
/*     */ 
/*     */   private static class InsertIntoRankPro
/*     */     extends LogicProcedure
/*     */   {
/*     */     private final long roleid;
/*     */     private final int seconds;
/*     */     
/*     */     public InsertIntoRankPro(long roleid, int seconds)
/*     */     {
/* 291 */       this.roleid = roleid;
/* 292 */       this.seconds = seconds;
/*     */     }
/*     */     
/*     */     protected boolean processImp()
/*     */       throws Exception
/*     */     {
/* 298 */       KeJuInfo xKeJuInfo = Role2keju.get(Long.valueOf(this.roleid));
/* 299 */       if (xKeJuInfo == null)
/*     */       {
/* 301 */         xKeJuInfo = Pod.newKeJuInfo();
/* 302 */         Role2keju.insert(Long.valueOf(this.roleid), xKeJuInfo);
/*     */       }
/* 304 */       xKeJuInfo.setStarttime(DateTimeUtils.getCurrTimeInMillis());
/* 305 */       xKeJuInfo.setFinishtime(xKeJuInfo.getStarttime() + TimeUnit.SECONDS.toMillis(this.seconds));
/* 306 */       xKeJuInfo.setState(3);
/*     */       
/* 308 */       KejuRankManager.getInstance().rank(new RoleKejuChart(this.roleid, this.seconds));
/* 309 */       return true;
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
/*     */   static boolean isRoleStateCanAnswerQuestion(long roleid)
/*     */   {
/* 322 */     return RoleStatusInterface.checkCanSetStatus(roleid, 144, true);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public static int getCanGetStorageExp(long roleid, int finishCount)
/*     */   {
/* 334 */     return (int)(EveryDayQuestionManager.getInstance().getRestExp(roleid, finishCount) * EveryDayQuestionManager.getInstance().getRate());
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
/*     */   public static int getExpByRing(long roleid, boolean isRight)
/*     */   {
/* 347 */     return (int)(EveryDayQuestionManager.getInstance().getExpByRing(roleid, isRight) * EveryDayQuestionManager.getInstance().getRate());
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
/*     */   public static int getZhuxianQiyuanFinifshCount(String userId, long roleId, boolean isLock)
/*     */   {
/* 361 */     return ActivityInterface.getActivityCount(userId, roleId, EveryDayQuestionManager.getInstance().getActivityId(), isLock);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\question\main\QuestionInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */