/*     */ package mzm.gsp.bandstand.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.activity4.confbean.SBandstandFragmentInfo;
/*     */ import mzm.gsp.activity4.confbean.SBandstandMusicCfg;
/*     */ import mzm.gsp.bandstand.SNotifyBandstandEnd;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import xbean.BandstandInfo;
/*     */ import xbean.Pod;
/*     */ import xtable.Role2bandstandinfo;
/*     */ import xtable.Role2bandstandsessionid;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class BandstandManager
/*     */ {
/*     */   static BandstandInfo getBandstandInfo(long roleId)
/*     */   {
/*  27 */     BandstandInfo xBandstandInfo = Role2bandstandinfo.get(Long.valueOf(roleId));
/*  28 */     if (null == xBandstandInfo)
/*     */     {
/*  30 */       xBandstandInfo = Pod.newBandstandInfo();
/*  31 */       Role2bandstandinfo.add(Long.valueOf(roleId), xBandstandInfo);
/*     */     }
/*  33 */     return xBandstandInfo;
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
/*     */   static BandstandSession startMusic(long roleId, int activityId, int musicCfgId, int fragmentIndex)
/*     */   {
/*  50 */     BandstandSession session = new BandstandSession(roleId, activityId, musicCfgId, fragmentIndex);
/*  51 */     long sessionId = session.getSessionId();
/*  52 */     Role2bandstandsessionid.remove(Long.valueOf(roleId));
/*  53 */     Role2bandstandsessionid.add(Long.valueOf(roleId), Long.valueOf(sessionId));
/*  54 */     return session;
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
/*     */   static BandstandSession loopMusic(long roleId, int activityId, int musicCfgId, int fragmentIndex, Map<Integer, List<Integer>> fragmentIndex2answerSequence, int oldLoopCount, int lastAnswerLoop)
/*     */   {
/*  74 */     BandstandSession session = new BandstandSession(roleId, activityId, musicCfgId, fragmentIndex, fragmentIndex2answerSequence, oldLoopCount, lastAnswerLoop);
/*     */     
/*  76 */     long sessionId = session.getSessionId();
/*  77 */     Role2bandstandsessionid.remove(Long.valueOf(roleId));
/*  78 */     Role2bandstandsessionid.add(Long.valueOf(roleId), Long.valueOf(sessionId));
/*  79 */     return session;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static int getMusicDuration(int musicCfgId, int startFragmentIndex)
/*     */   {
/*  91 */     SBandstandMusicCfg sMusicCfg = SBandstandMusicCfg.get(musicCfgId);
/*  92 */     int totalTime = 0;
/*  93 */     for (int index = startFragmentIndex; index <= sMusicCfg.fragments.size(); index++)
/*     */     {
/*  95 */       totalTime += ((SBandstandFragmentInfo)sMusicCfg.fragments.get(index - 1)).musicTime;
/*     */     }
/*  97 */     return totalTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static void stopBandstand(String userId, long roleId, long sessionId)
/*     */   {
/* 108 */     BandstandSession session = (BandstandSession)BandstandSession.getSession(sessionId);
/* 109 */     if (null != session)
/*     */     {
/* 111 */       int activityId = session.getActivityId();
/*     */       
/* 113 */       ActivityInterface.addActivityCount(userId, roleId, activityId);
/*     */       
/* 115 */       ActivityInterface.logActivity(roleId, activityId, ActivityLogStatus.FINISH);
/*     */       
/* 117 */       ActivityInterface.tlogActivity(roleId, activityId, ActivityLogStatus.FINISH);
/*     */     }
/*     */     
/*     */ 
/* 121 */     BandstandSession.removeSession(sessionId);
/*     */     
/*     */ 
/* 124 */     Role2bandstandsessionid.remove(Long.valueOf(roleId));
/*     */     
/*     */ 
/* 127 */     SNotifyBandstandEnd proto = new SNotifyBandstandEnd();
/* 128 */     OnlineManager.getInstance().send(roleId, proto);
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
/*     */   static void addStartBandstandTlog(long roleId, int activityId, int musicCfgId, int fragmentIndex)
/*     */   {
/* 143 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 144 */     String userid = RoleInterface.getUserId(roleId);
/* 145 */     int rolelevel = RoleInterface.getLevel(roleId);
/* 146 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(activityId), Integer.valueOf(musicCfgId), Integer.valueOf(fragmentIndex) });
/*     */     
/* 148 */     TLogManager.getInstance().addLog(roleId, "BandstandStart", logStr);
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
/*     */   static void addBandstandLoopTlog(long roleId, int activityId, int musicCfgId, int loopCount)
/*     */   {
/* 161 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 162 */     String userid = RoleInterface.getUserId(roleId);
/* 163 */     int rolelevel = RoleInterface.getLevel(roleId);
/* 164 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(activityId), Integer.valueOf(musicCfgId), Integer.valueOf(loopCount) });
/*     */     
/* 166 */     TLogManager.getInstance().addLog(roleId, "BandstandLoop", logStr);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   static enum BandstandEndReason
/*     */   {
/* 174 */     ACTIVE_STOP(1),  OFFLINE(2),  MAX_LOOP_COUNT(3);
/*     */     
/*     */     public final int value;
/*     */     
/*     */     private BandstandEndReason(int value)
/*     */     {
/* 180 */       this.value = value;
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
/*     */ 
/*     */   static void addEndBandstandTlog(long roleId, int activityId, int musicCfgId, int loopCount, BandstandEndReason reason)
/*     */   {
/* 196 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 197 */     String userid = RoleInterface.getUserId(roleId);
/* 198 */     int rolelevel = RoleInterface.getLevel(roleId);
/* 199 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(activityId), Integer.valueOf(musicCfgId), Integer.valueOf(loopCount), Integer.valueOf(reason.value) });
/*     */     
/* 201 */     TLogManager.getInstance().addLog(roleId, "BandstandEnd", logStr);
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
/*     */   static void addAnswerBandstandTlog(long roleId, int activityId, int musicCfgId, int fragmentIndex, boolean result, int oldAwardCount, int newAwardCount)
/*     */   {
/* 218 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 219 */     String userid = RoleInterface.getUserId(roleId);
/* 220 */     int rolelevel = RoleInterface.getLevel(roleId);
/* 221 */     String logStr = String.format("%s|%s|%d|%d|%d|%d|%d|%d|%d|%d", new Object[] { vGameIP, userid, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(activityId), Integer.valueOf(musicCfgId), Integer.valueOf(fragmentIndex), Integer.valueOf(result ? 1 : 0), Integer.valueOf(oldAwardCount), Integer.valueOf(newAwardCount) });
/*     */     
/* 223 */     TLogManager.getInstance().addLog(roleId, "BandstandAnswer", logStr);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bandstand\main\BandstandManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */