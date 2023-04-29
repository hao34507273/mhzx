/*    */ package mzm.gsp.vote.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import java.util.HashSet;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.online.event.PlayerLoginProcedure;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.vote.SSynCommonVoteInfo;
/*    */ import xbean.VoteInfo;
/*    */ import xtable.Role2voteinfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnRoleLogin
/*    */   extends PlayerLoginProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     long roleId = ((Long)this.arg).longValue();
/* 30 */     VoteInfo xVoteInfo = Role2voteinfo.get(Long.valueOf(roleId));
/* 31 */     if (xVoteInfo == null)
/*    */     {
/* 33 */       return false;
/*    */     }
/* 35 */     Map<Integer, xbean.VoteDatas> xActivityId2VoteData = xVoteInfo.getActivityid2votedata();
/* 36 */     if ((xActivityId2VoteData == null) || (xActivityId2VoteData.size() == 0))
/*    */     {
/* 38 */       return false;
/*    */     }
/* 40 */     SSynCommonVoteInfo pro = new SSynCommonVoteInfo();
/* 41 */     fillSynVotePro(xActivityId2VoteData, pro.activityid2votedata);
/* 42 */     if (pro.activityid2votedata.size() == 0)
/*    */     {
/* 44 */       return false;
/*    */     }
/* 46 */     OnlineManager.getInstance().send(roleId, pro);
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   private void fillSynVotePro(Map<Integer, xbean.VoteDatas> xActivityId2VoteData, Map<Integer, mzm.gsp.vote.VoteDatas> pActivityid2votedata)
/*    */   {
/* 52 */     Iterator<Map.Entry<Integer, xbean.VoteDatas>> it = xActivityId2VoteData.entrySet().iterator();
/* 53 */     while (it.hasNext())
/*    */     {
/* 55 */       Map.Entry<Integer, xbean.VoteDatas> entry = (Map.Entry)it.next();
/* 56 */       int activityId = ((Integer)entry.getKey()).intValue();
/* 57 */       if (ActivityInterface.isActivityOpen(activityId))
/*    */       {
/*    */ 
/*    */ 
/*    */ 
/* 62 */         List<mzm.gsp.vote.VoteData> pVoteInfos = new ArrayList();
/* 63 */         xbean.VoteDatas xVoteDatas = (xbean.VoteDatas)entry.getValue();
/* 64 */         for (xbean.VoteData xVoteData : xVoteDatas.getVotedinfos())
/*    */         {
/* 66 */           Set<Integer> ownVoteIds = xVoteData.getVotedids();
/* 67 */           if (ownVoteIds.size() != 0)
/*    */           {
/*    */ 
/*    */ 
/* 71 */             pVoteInfos.add(new mzm.gsp.vote.VoteData(new HashSet(ownVoteIds))); }
/*    */         }
/* 73 */         if (pVoteInfos.size() != 0)
/*    */         {
/*    */ 
/*    */ 
/*    */ 
/* 78 */           mzm.gsp.vote.VoteDatas pVoteDatas = new mzm.gsp.vote.VoteDatas();
/* 79 */           pVoteDatas.votedinfos.addAll(pVoteInfos);
/* 80 */           pActivityid2votedata.put(Integer.valueOf(activityId), pVoteDatas);
/*    */         }
/*    */       }
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\vote\main\POnRoleLogin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */