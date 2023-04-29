/*     */ package mzm.gsp.bandstand.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity4.confbean.SBandstandActivityCfg;
/*     */ import mzm.gsp.activity4.confbean.SBandstandFragmentInfo;
/*     */ import mzm.gsp.activity4.confbean.SBandstandMusicCfg;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.bandstand.SBandstandAnswerFail;
/*     */ import mzm.gsp.bandstand.SBandstandAnswerSuccess;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BandstandInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2bandstandsessionid;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCBandstandAnswerReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int musicCfgId;
/*     */   private final int fragmentIndex;
/*     */   private final int answerIndex;
/*     */   
/*     */   public PCBandstandAnswerReq(long roleId, int musicCfgId, int fragmentIndex, int answerIndex)
/*     */   {
/*  32 */     this.roleId = roleId;
/*  33 */     this.musicCfgId = musicCfgId;
/*  34 */     this.fragmentIndex = fragmentIndex;
/*  35 */     this.answerIndex = answerIndex;
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  42 */     if (!OpenInterface.getOpenStatus(548))
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  48 */     String userId = mzm.gsp.role.main.RoleInterface.getUserId(this.roleId);
/*  49 */     if (null == userId)
/*     */     {
/*  51 */       String logstr = String.format("[bandstand]PCBandstandAnswerReq.processImp@user not exsist|roleId=%d", new Object[] { Long.valueOf(this.roleId) });
/*     */       
/*  53 */       GameServer.logger().error(logstr);
/*  54 */       return false;
/*     */     }
/*  56 */     Lockeys.lock(Lockeys.get(User.getTable(), userId));
/*  57 */     Lockeys.lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleId)));
/*     */     
/*     */ 
/*  60 */     Long sessionId = Role2bandstandsessionid.get(Long.valueOf(this.roleId));
/*  61 */     if (null == sessionId)
/*     */     {
/*  63 */       onFail(1);
/*  64 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  68 */     BandstandSession session = (BandstandSession)BandstandSession.getSession(sessionId.longValue());
/*  69 */     int sessionMusicCfgId = session.getMusicCfgId();
/*  70 */     int sessionFragmentIndex = session.getCurrentFragmentIndex();
/*  71 */     if ((this.musicCfgId != sessionMusicCfgId) || (this.fragmentIndex != sessionFragmentIndex))
/*     */     {
/*  73 */       onFail(2);
/*  74 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  78 */     if (session.isAnswered(sessionFragmentIndex))
/*     */     {
/*  80 */       onFail(3);
/*  81 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  85 */     SBandstandMusicCfg sMusicCfg = SBandstandMusicCfg.get(this.musicCfgId);
/*  86 */     SBandstandFragmentInfo sFragmentCfg = (SBandstandFragmentInfo)sMusicCfg.fragments.get(this.fragmentIndex - 1);
/*  87 */     if (sFragmentCfg.fragmentType == 2)
/*     */     {
/*  89 */       onFail(4);
/*  90 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  94 */     boolean answerRight = session.isRightAnswer(sessionFragmentIndex, this.answerIndex);
/*  95 */     int activityId = session.getActivityId();
/*  96 */     SBandstandActivityCfg sBandstandActivityCfg = SBandstandActivityCfg.get(activityId);
/*  97 */     BandstandInfo xBandstandInfo = BandstandManager.getBandstandInfo(this.roleId);
/*  98 */     Map<Integer, Integer> activityId2AwardCount = xBandstandInfo.getActivityid2todayawardcount();
/*  99 */     int currentAwardCount = null == activityId2AwardCount.get(Integer.valueOf(activityId)) ? 0 : ((Integer)activityId2AwardCount.get(Integer.valueOf(activityId))).intValue();
/*     */     
/* 101 */     int newAwardCount = currentAwardCount;
/* 102 */     if ((answerRight) && (currentAwardCount < sBandstandActivityCfg.dailyAwardCount))
/*     */     {
/*     */ 
/* 105 */       int fixAwardId = sBandstandActivityCfg.awardId;
/* 106 */       if (null == AwardInterface.awardFixAward(fixAwardId, userId, this.roleId, false, true, new AwardReason(LogReason.BANDSTAND_ANSWER_AWARD)))
/*     */       {
/*     */ 
/* 109 */         return false;
/*     */       }
/*     */       
/*     */ 
/* 113 */       newAwardCount++;
/* 114 */       activityId2AwardCount.put(Integer.valueOf(activityId), Integer.valueOf(newAwardCount));
/*     */     }
/*     */     
/*     */ 
/* 118 */     onSuccess(answerRight, currentAwardCount, newAwardCount, activityId);
/*     */     
/* 120 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onSuccess(boolean answerRight, int oldAwardCount, int newAwardCount, int activityId)
/*     */   {
/* 129 */     String logstr = String.format("[bandstand]PCBandstandAnswerReq.onSuccess@answer bandstand success!|roleId=%d,musicCfgId=%d,fragmentIndex=%d,answerIndex=%d,result=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.musicCfgId), Integer.valueOf(this.fragmentIndex), Integer.valueOf(this.answerIndex), Boolean.valueOf(answerRight) });
/*     */     
/*     */ 
/* 132 */     GameServer.logger().info(logstr);
/*     */     
/*     */ 
/* 135 */     SBandstandAnswerSuccess proto = new SBandstandAnswerSuccess();
/* 136 */     proto.result = ((byte)(answerRight ? 1 : 0));
/* 137 */     proto.answer_index = this.answerIndex;
/* 138 */     proto.get_reward = ((byte)(newAwardCount > oldAwardCount ? 1 : 0));
/* 139 */     OnlineManager.getInstance().send(this.roleId, proto);
/*     */     
/*     */ 
/* 142 */     BandstandManager.addAnswerBandstandTlog(this.roleId, activityId, this.musicCfgId, this.fragmentIndex, answerRight, oldAwardCount, newAwardCount);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void onFail(int errorCode)
/*     */   {
/* 154 */     String logstr = String.format("[bandstand]PCBandstandAnswerReq.onSuccess@answer bandstand fail!|roleId=%d, errorCode=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(errorCode) });
/*     */     
/*     */ 
/* 157 */     GameServer.logger().info(logstr);
/*     */     
/*     */ 
/* 160 */     SBandstandAnswerFail proto = new SBandstandAnswerFail();
/* 161 */     proto.error_code = errorCode;
/* 162 */     OnlineManager.getInstance().sendAtOnce(this.roleId, proto);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bandstand\main\PCBandstandAnswerReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */