/*     */ package mzm.gsp.storywall.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import mzm.gsp.activity.confbean.SStoryWallCfg;
/*     */ import mzm.gsp.activity.confbean.StoryWallConst;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.storywall.SReadStoryAwardRes;
/*     */ import mzm.gsp.storywall.SReadStoryRes;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*     */ import xbean.StoryInfo;
/*     */ import xbean.StoryWall;
/*     */ import xtable.Role2storyinfo;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PReadStoryReq extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   private final int storyid;
/*     */   
/*     */   public PReadStoryReq(long _roleid, int _storyid)
/*     */   {
/*  29 */     this.roleid = _roleid;
/*  30 */     this.storyid = _storyid;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  35 */     if ((!OpenInterface.getOpenStatus(163)) || (OpenInterface.isBanPlay(this.roleid, 163))) {
/*  36 */       OpenInterface.sendBanPlayMsg(this.roleid, 163);
/*  37 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  41 */     if (!StoryWallModule.isRoleStateCanJoinStorywallActivity(this.roleid))
/*     */     {
/*  43 */       StoryWallModule.logInfo("PReadStoryReq.processImp@role state can not join storywall activity|roleid=%d", new Object[] { Long.valueOf(this.roleid) });
/*  44 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  48 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(this.roleid);
/*  49 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  51 */     StoryInfo xRoleStoryInfo = Role2storyinfo.get(Long.valueOf(this.roleid));
/*  52 */     if (xRoleStoryInfo == null) {
/*  53 */       xRoleStoryInfo = xbean.Pod.newStoryInfo();
/*  54 */       Role2storyinfo.add(Long.valueOf(this.roleid), xRoleStoryInfo);
/*     */     }
/*     */     
/*  57 */     if (!ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, StoryWallConst.getInstance().activityid).isCanJoin()) {
/*  58 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  62 */     StoryWall xStoryWall = xtable.Storywall.select(Long.valueOf(mzm.gsp.GameServerInfoManager.getLocalId()));
/*  63 */     if (xStoryWall == null) {
/*  64 */       OnlineManager.getInstance().sendAtOnce(this.roleid, new SReadStoryRes(1));
/*  65 */       return false;
/*     */     }
/*     */     
/*  68 */     long nowTime = DateTimeUtils.getCurrTimeInMillis();
/*  69 */     if (!DateTimeUtils.isInSameWeek(xStoryWall.getStoryrefreshtime(), nowTime))
/*     */     {
/*  71 */       NoneRealTimeTaskManager.getInstance().addTask(new PRefreshStoryWall());
/*  72 */       OnlineManager.getInstance().sendAtOnce(this.roleid, new SReadStoryRes(2));
/*  73 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  77 */     if (!xStoryWall.getStoryids().contains(Integer.valueOf(this.storyid))) {
/*  78 */       OnlineManager.getInstance().sendAtOnce(this.roleid, new SReadStoryRes(3));
/*  79 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  83 */     if (!DateTimeUtils.isInSameWeek(xRoleStoryInfo.getReadtime(), nowTime)) {
/*  84 */       xRoleStoryInfo.getStoryids().clear();
/*     */     }
/*     */     
/*     */ 
/*  88 */     SStoryWallCfg stroyCfg = SStoryWallCfg.get(this.storyid);
/*  89 */     if (stroyCfg == null) {
/*  90 */       OnlineManager.getInstance().sendAtOnce(this.roleid, new SReadStoryRes(1));
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     boolean getAward = false;
/*  95 */     if (!xRoleStoryInfo.getStoryids().contains(Integer.valueOf(this.storyid))) {
/*  96 */       xRoleStoryInfo.getStoryids().add(Integer.valueOf(this.storyid));
/*     */       
/*  98 */       int actCount = ActivityInterface.getActivityCount(userid, this.roleid, StoryWallConst.getInstance().activityid, true);
/*  99 */       if (actCount == 0) {
/* 100 */         int readCount = xRoleStoryInfo.getStoryids().size();
/* 101 */         boolean award = readCount >= StoryWallModule.MAX_STORY_COUNT;
/* 102 */         if (!award) {
/* 103 */           award = xdb.Xdb.random().nextInt(StoryWallModule.MAX_STORY_COUNT - readCount + 1) == 1;
/*     */         }
/*     */         
/*     */ 
/* 107 */         if (award) {
/* 108 */           if (!mzm.gsp.idip.main.IdipManager.isZeroProfit(this.roleid)) {
/* 109 */             getAward = true;
/* 110 */             AwardReason reason = new AwardReason(mzm.gsp.tlog.LogReason.READ_STORY, this.storyid);
/* 111 */             mzm.gsp.award.main.AwardModel exAm = AwardInterface.award(stroyCfg.awardId, userid, this.roleid, false, false, reason);
/* 112 */             StoryWallModule.logInfo("PReadStoryReq.processImp@success|roleId=%d|storyId=%d|awardId=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.storyid), Integer.valueOf(stroyCfg.awardId) });
/*     */             
/* 114 */             if (exAm != null) {
/* 115 */               SReadStoryAwardRes awardRes = new SReadStoryAwardRes();
/* 116 */               AwardInterface.fillAwardBean(awardRes.targetawardbean, exAm);
/* 117 */               OnlineManager.getInstance().send(this.roleid, awardRes);
/*     */             }
/*     */           } else {
/* 120 */             StoryWallModule.logInfo("PReadStoryReq.processImp@fail|roleId=%d|storyId=%d|awardId=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.storyid), Integer.valueOf(stroyCfg.awardId) });
/*     */           }
/*     */           
/* 123 */           ActivityInterface.addActivityCount(userid, this.roleid, StoryWallConst.getInstance().activityid);
/*     */           
/* 125 */           xRoleStoryInfo.setAwardtime(nowTime);
/*     */         }
/*     */       }
/*     */     }
/*     */     
/* 130 */     if (getAward) {
/* 131 */       StoryWallModule.tlogStoryWall(this.roleid, this.storyid, stroyCfg.awardId);
/*     */     } else {
/* 133 */       StoryWallModule.tlogStoryWall(this.roleid, this.storyid, 0);
/*     */     }
/* 135 */     xRoleStoryInfo.setReadtime(nowTime);
/*     */     
/* 137 */     OnlineManager.getInstance().send(this.roleid, new SReadStoryRes(0));
/* 138 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\storywall\main\PReadStoryReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */