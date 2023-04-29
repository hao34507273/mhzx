/*     */ package mzm.gsp.bandstand.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity4.confbean.BandstandConsts;
/*     */ import mzm.gsp.activity4.confbean.SBandstandFragmentInfo;
/*     */ import mzm.gsp.activity4.confbean.SBandstandMusicCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.timer.main.MilliSession;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2bandstandsessionid;
/*     */ import xtable.User;
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
/*     */ class BandstandSession
/*     */   extends MilliSession
/*     */ {
/*     */   private final long roleId;
/*     */   private final int activityId;
/*     */   private final int musicCfgId;
/*     */   private final long startTime;
/*     */   private final Map<Integer, List<Integer>> fragmentIndex2answerSequence;
/*     */   private final List<Integer> answeredFragmentIndexes;
/*     */   private int loopCount;
/*     */   private int lastAnswerLoop;
/*     */   
/*     */   BandstandSession(long roleId, int activityId, int musicCfgId, int startIndex)
/*     */   {
/*  66 */     super(BandstandManager.getMusicDuration(musicCfgId, startIndex), roleId);
/*  67 */     SBandstandMusicCfg sMusicCfg = SBandstandMusicCfg.get(musicCfgId);
/*  68 */     this.roleId = roleId;
/*  69 */     this.activityId = activityId;
/*  70 */     this.musicCfgId = musicCfgId;
/*  71 */     this.startTime = getMusicStartTime(sMusicCfg, startIndex);
/*  72 */     this.answeredFragmentIndexes = new ArrayList(sMusicCfg.fragmentIndexesWithLyric.size());
/*  73 */     this.fragmentIndex2answerSequence = new HashMap();
/*  74 */     this.loopCount = 1;
/*  75 */     this.lastAnswerLoop = 0;
/*  76 */     shuffleAnswers(sMusicCfg);
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
/*     */   BandstandSession(long roleId, int activityId, int musicCfgId, int startIndex, Map<Integer, List<Integer>> fragmentIndex2answerSequence, int oldLoopCount, int lastAnswerLoop)
/*     */   {
/*  94 */     super(BandstandManager.getMusicDuration(musicCfgId, startIndex), roleId);
/*  95 */     SBandstandMusicCfg sMusicCfg = SBandstandMusicCfg.get(musicCfgId);
/*  96 */     this.roleId = roleId;
/*  97 */     this.activityId = activityId;
/*  98 */     this.musicCfgId = musicCfgId;
/*  99 */     this.startTime = getMusicStartTime(sMusicCfg, startIndex);
/* 100 */     this.answeredFragmentIndexes = new ArrayList(sMusicCfg.fragmentIndexesWithLyric.size());
/* 101 */     this.fragmentIndex2answerSequence = fragmentIndex2answerSequence;
/* 102 */     this.loopCount = (oldLoopCount + 1);
/* 103 */     this.lastAnswerLoop = lastAnswerLoop;
/*     */   }
/*     */   
/*     */ 
/*     */   protected void onTimeOut()
/*     */   {
/* 109 */     new LogicProcedure()
/*     */     {
/*     */ 
/*     */       protected boolean processImp()
/*     */         throws Exception
/*     */       {
/* 115 */         String userId = RoleInterface.getUserId(BandstandSession.this.roleId);
/* 116 */         Lockeys.lock(Lockeys.get(User.getTable(), userId));
/* 117 */         Lockeys.lock(Lockeys.get(Basic.getTable(), Long.valueOf(BandstandSession.this.roleId)));
/*     */         
/* 119 */         Long roleSessionId = Role2bandstandsessionid.get(Long.valueOf(BandstandSession.this.roleId));
/* 120 */         if ((null == roleSessionId) || (roleSessionId.longValue() != BandstandSession.this.getSessionId()))
/*     */         {
/*     */ 
/* 123 */           String logstr = String.format("[bandstand]BandstandSession.onTimeOut@session and Role2bandstandsessionid not match!|roleId=%d", new Object[] { Long.valueOf(BandstandSession.this.roleId) });
/*     */           
/*     */ 
/* 126 */           GameServer.logger().info(logstr);
/* 127 */           return false;
/*     */         }
/*     */         
/* 130 */         int exitLoopNum = BandstandConsts.getInstance().EXIT_LOOP_NUM;
/* 131 */         if (BandstandSession.this.loopCount - BandstandSession.this.lastAnswerLoop >= exitLoopNum)
/*     */         {
/*     */ 
/* 134 */           BandstandManager.stopBandstand(userId, BandstandSession.this.roleId, BandstandSession.this.getSessionId());
/*     */           
/* 136 */           BandstandManager.addEndBandstandTlog(BandstandSession.this.roleId, BandstandSession.this.activityId, BandstandSession.this.musicCfgId, BandstandSession.this.loopCount, BandstandManager.BandstandEndReason.MAX_LOOP_COUNT);
/*     */           
/*     */ 
/* 139 */           return true;
/*     */         }
/*     */         
/*     */ 
/* 143 */         BandstandManager.addBandstandLoopTlog(BandstandSession.this.roleId, BandstandSession.this.activityId, BandstandSession.this.musicCfgId, BandstandSession.this.loopCount);
/*     */         
/*     */ 
/* 146 */         BandstandManager.loopMusic(BandstandSession.this.roleId, BandstandSession.this.activityId, BandstandSession.this.musicCfgId, 1, BandstandSession.this.fragmentIndex2answerSequence, BandstandSession.this.loopCount, BandstandSession.this.lastAnswerLoop);
/*     */         
/*     */ 
/* 149 */         return true;
/*     */       }
/*     */     }.execute();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private long getMusicStartTime(SBandstandMusicCfg sMusicCfg, int startIndex)
/*     */   {
/* 161 */     long startTime = DateTimeUtils.getCurrTimeInMillis();
/* 162 */     for (int index = 1; index < startIndex; index++)
/*     */     {
/* 164 */       startTime -= ((SBandstandFragmentInfo)sMusicCfg.fragments.get(index - 1)).musicTime;
/*     */     }
/* 166 */     return startTime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   private void shuffleAnswers(SBandstandMusicCfg sMusicCfg)
/*     */   {
/* 174 */     for (SBandstandFragmentInfo sFragmentInfo : sMusicCfg.fragments)
/*     */     {
/* 176 */       List<Integer> answerSequence = new ArrayList(sFragmentInfo.answerNum);
/* 177 */       for (int i = 1; i <= sFragmentInfo.answerNum; i++)
/*     */       {
/* 179 */         answerSequence.add(Integer.valueOf(i));
/*     */       }
/* 181 */       Collections.shuffle(answerSequence);
/* 182 */       this.fragmentIndex2answerSequence.put(Integer.valueOf(sFragmentInfo.index), answerSequence);
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getCurrentFragmentIndex()
/*     */   {
/* 193 */     long currentTime = DateTimeUtils.getCurrTimeInMillis();
/* 194 */     SBandstandMusicCfg sMusicCfg = SBandstandMusicCfg.get(this.musicCfgId);
/* 195 */     long duration = currentTime - this.startTime;
/* 196 */     int fragmentIndex = 1;
/* 197 */     for (SBandstandFragmentInfo sFragmentInfo : sMusicCfg.fragments)
/*     */     {
/* 199 */       fragmentIndex = sFragmentInfo.index;
/* 200 */       duration -= sFragmentInfo.musicTime;
/* 201 */       if (duration <= 0L) {
/*     */         break;
/*     */       }
/*     */     }
/*     */     
/* 206 */     return fragmentIndex;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getActivityId()
/*     */   {
/* 214 */     return this.activityId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getMusicCfgId()
/*     */   {
/* 222 */     return this.musicCfgId;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setAnswered(int fragmentIndex)
/*     */   {
/* 231 */     this.answeredFragmentIndexes.add(Integer.valueOf(fragmentIndex));
/* 232 */     this.lastAnswerLoop = this.loopCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isAnswered(int fragmentIndex)
/*     */   {
/* 240 */     return this.answeredFragmentIndexes.contains(Integer.valueOf(fragmentIndex));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getLoopCount()
/*     */   {
/* 248 */     return this.loopCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public void setLoopCount(int loopCount)
/*     */   {
/* 258 */     this.loopCount = loopCount;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isRightAnswer(int fragmentIndex, int answerIndex)
/*     */   {
/* 269 */     List<Integer> answerSequence = (List)this.fragmentIndex2answerSequence.get(Integer.valueOf(fragmentIndex));
/* 270 */     if (null == answerSequence)
/*     */     {
/* 272 */       return false;
/*     */     }
/* 274 */     return ((Integer)answerSequence.get(answerIndex - 1)).intValue() == 1;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Map<Integer, List<Integer>> getAnswerSequenceMap()
/*     */   {
/* 284 */     return this.fragmentIndex2answerSequence;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bandstand\main\BandstandSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */