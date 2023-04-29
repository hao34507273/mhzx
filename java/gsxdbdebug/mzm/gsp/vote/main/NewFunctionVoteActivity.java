/*    */ package mzm.gsp.vote.main;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.Set;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.activity2.confbean.FucntionVoteConsts;
/*    */ import mzm.gsp.activity2.confbean.STCommonVoteCfg;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ public class NewFunctionVoteActivity implements SingleActivityHandler
/*    */ {
/*    */   static volatile NewFunctionVoteActivity instance;
/*    */   
/*    */   static NewFunctionVoteActivity getInstance()
/*    */   {
/* 16 */     if (instance == null)
/*    */     {
/* 18 */       synchronized (NewFunctionVoteActivity.class)
/*    */       {
/* 20 */         if (instance == null)
/*    */         {
/* 22 */           instance = new NewFunctionVoteActivity();
/*    */         }
/*    */       }
/*    */     }
/* 26 */     return instance;
/*    */   }
/*    */   
/*    */ 
/*    */   public boolean isVoteIdsValid(long roleId, STCommonVoteCfg cfg, Set<Integer> voteIds)
/*    */   {
/* 32 */     if ((cfg == null) || (voteIds == null) || (voteIds.size() == 0))
/*    */     {
/* 34 */       return false;
/*    */     }
/* 36 */     if (cfg.activityCfgId != FucntionVoteConsts.getInstance().activityId)
/*    */     {
/* 38 */       GameServer.logger().error(String.format("[vote]NewFunctionVoteActivity.isVoteIdsValid@ activityId valid!|roleId=%d|errActivityId=%d|activityId=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(cfg.activityCfgId), Integer.valueOf(FucntionVoteConsts.getInstance().activityId) }));
/*    */       
/*    */ 
/*    */ 
/* 42 */       return false;
/*    */     }
/* 44 */     for (Iterator i$ = voteIds.iterator(); i$.hasNext();) { int voteId = ((Integer)i$.next()).intValue();
/*    */       
/* 46 */       mzm.gsp.activity2.confbean.SFucntionVoteCfg functionCfg = mzm.gsp.activity2.confbean.SFucntionVoteCfg.get(voteId);
/* 47 */       if (functionCfg == null)
/*    */       {
/* 49 */         GameServer.logger().error(String.format("[vote]NewFunctionVoteActivity.isVoteIdsValid@ voteId valid!|roleId=%d|activityId=%d|voteId=%d|voteIds=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(FucntionVoteConsts.getInstance().activityId), Integer.valueOf(voteId), voteIds }));
/*    */         
/*    */ 
/*    */ 
/* 53 */         return false;
/*    */       }
/* 55 */       if (!functionCfg.joinVote)
/*    */       {
/* 57 */         GameServer.logger().error(String.format("[vote]NewFunctionVoteActivity.isVoteIdsValid@ forbid join vote!|roleId=%d|activityId=%d|voteId=%d|voteIds=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(FucntionVoteConsts.getInstance().activityId), Integer.valueOf(voteId), voteIds }));
/*    */         
/*    */ 
/*    */ 
/* 61 */         return false;
/*    */       }
/*    */     }
/* 64 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\vote\main\NewFunctionVoteActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */