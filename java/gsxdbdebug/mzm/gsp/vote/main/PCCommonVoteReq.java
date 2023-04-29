/*     */ package mzm.gsp.vote.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity2.confbean.STCommonVoteCfg;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.vote.SCommonVoteSuc;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.VoteData;
/*     */ import xbean.VoteDatas;
/*     */ import xbean.VoteInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2voteinfo;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCCommonVoteReq extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final int activityId;
/*     */   private final Set<Integer> voteIds;
/*     */   private STCommonVoteCfg cfg;
/*     */   private String userId;
/*     */   
/*     */   public PCCommonVoteReq(long roleId, int activityId, Set<Integer> voteIds)
/*     */   {
/*  40 */     this.roleId = roleId;
/*  41 */     this.activityId = activityId;
/*  42 */     this.voteIds = voteIds;
/*     */     
/*  44 */     this.cfg = STCommonVoteCfg.get(activityId);
/*     */   }
/*     */   
/*     */ 
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  51 */     if (!VoteManager.isVoteIdsValidInCfg(this.roleId, this.activityId, this.cfg, this.voteIds))
/*     */     {
/*  53 */       GameServer.logger().error(String.format("[vote]PCCommonVoteReq.processImp@ votes illegal!|roleId=%d|activityId=%d|voteIds=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), this.voteIds }));
/*     */       
/*     */ 
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     if (!VoteManager.isVoteOpen(this.cfg.idipSwitchId))
/*     */     {
/*  61 */       GameServer.logger().error(String.format("[vote]PCCommonVoteReq.processImp@ votes forbidden!|roleId=%d|activityId=%d|voteIds=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), this.voteIds }));
/*     */       
/*     */ 
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     this.userId = RoleInterface.getUserId(this.roleId);
/*  68 */     lock(Lockeys.get(User.getTable(), this.userId));
/*     */     
/*  70 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleId) }));
/*     */     
/*  72 */     ActivityJoinResult res = ActivityInterface.canJoinAndCheckInitActivityData(this.userId, this.roleId, this.activityId);
/*  73 */     if (!res.isCanJoin())
/*     */     {
/*  75 */       GameServer.logger().error(String.format("[vote]PCCommonVoteReq.processImp@ can not join activity!|roleId=%d|activityId=%d|voteIds=%s|res=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), this.voteIds, Integer.valueOf(res.getReasonValue()) }));
/*     */       
/*     */ 
/*     */ 
/*  79 */       return false;
/*     */     }
/*     */     
/*  82 */     VoteDatas xVoteDatas = getXVoteDatasIfAbsent();
/*  83 */     if (!canKeepOnVote(xVoteDatas))
/*     */     {
/*  85 */       GameServer.logger().error(String.format("[vote]PCCommonVoteReq.processImp@ can not keep on vote!|roleId=%d|activityId=%d|voteIds=%s", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), this.voteIds }));
/*     */       
/*     */ 
/*  88 */       return false;
/*     */     }
/*     */     
/*  91 */     if (!doAward())
/*     */     {
/*  93 */       return false;
/*     */     }
/*     */     
/*  96 */     VoteData xVoteData = Pod.newVoteData();
/*  97 */     xVoteData.getVotedids().addAll(this.voteIds);
/*  98 */     xVoteDatas.getVotedinfos().add(xVoteData);
/*     */     
/* 100 */     OnlineManager.getInstance().send(this.roleId, new SCommonVoteSuc(this.activityId, new HashSet(this.voteIds)));
/*     */     
/* 102 */     VoteManager.tlogVoteInfo(this.userId, this.roleId, this.activityId, this.voteIds, xVoteDatas);
/* 103 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private VoteDatas getXVoteDatasIfAbsent()
/*     */   {
/* 115 */     VoteInfo xVoteInfo = Role2voteinfo.get(Long.valueOf(this.roleId));
/* 116 */     if (xVoteInfo == null)
/*     */     {
/* 118 */       xVoteInfo = Pod.newVoteInfo();
/* 119 */       Role2voteinfo.insert(Long.valueOf(this.roleId), xVoteInfo);
/*     */     }
/* 121 */     VoteDatas xVoteDatas = (VoteDatas)xVoteInfo.getActivityid2votedata().get(Integer.valueOf(this.activityId));
/* 122 */     if (xVoteDatas == null)
/*     */     {
/* 124 */       xVoteDatas = Pod.newVoteDatas();
/* 125 */       xVoteInfo.getActivityid2votedata().put(Integer.valueOf(this.activityId), xVoteDatas);
/*     */     }
/* 127 */     return xVoteDatas;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private boolean canKeepOnVote(VoteDatas xVoteDatas)
/*     */   {
/* 138 */     if (xVoteDatas.getVotedinfos().size() >= this.cfg.voteCountMax)
/*     */     {
/* 140 */       GameServer.logger().error(String.format("[vote]PCCommonVoteReq.canKeepOnVote@ can not keep on vote!|roleId=%d|activityId=%d|voteIds=%s|ownVoteDatas=%s|cfg.voteCountMax=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), this.voteIds, VoteManager.getOwnVoteDataStr(xVoteDatas), Integer.valueOf(this.cfg.voteCountMax) }));
/*     */       
/*     */ 
/*     */ 
/* 144 */       return false;
/*     */     }
/* 146 */     return true;
/*     */   }
/*     */   
/*     */   private boolean doAward()
/*     */   {
/* 151 */     AwardReason awardReason = new AwardReason(LogReason.COMMON_VOTE_AWAERD, this.activityId);
/* 152 */     AwardModel awardModel = null;
/* 153 */     switch (this.cfg.awardType)
/*     */     {
/*     */ 
/*     */     case 2: 
/* 157 */       awardModel = AwardInterface.awardFixAward(this.cfg.awardId, this.userId, this.roleId, true, true, awardReason);
/* 158 */       break;
/*     */     case 1: 
/* 160 */       awardModel = AwardInterface.award(this.cfg.awardId, this.userId, this.roleId, true, true, awardReason);
/* 161 */       break;
/*     */     }
/*     */     
/*     */     
/*     */ 
/* 166 */     if (awardModel == null)
/*     */     {
/* 168 */       GameServer.logger().error(String.format("[vote]PCCommonVoteReq.doAward@ do award failed!|roleId=%d|activityId=%d|voteIds=%s|awardType=%d|awardId=%d", new Object[] { Long.valueOf(this.roleId), Integer.valueOf(this.activityId), this.voteIds, Integer.valueOf(this.cfg.awardType), Integer.valueOf(this.cfg.awardId) }));
/*     */       
/*     */ 
/*     */ 
/* 172 */       return false;
/*     */     }
/* 174 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\vote\main\PCCommonVoteReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */