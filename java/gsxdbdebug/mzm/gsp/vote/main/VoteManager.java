/*     */ package mzm.gsp.vote.main;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity2.confbean.STCommonVoteCfg;
/*     */ import mzm.gsp.open.main.OpenInterface;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.TLogManager;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.VoteData;
/*     */ import xbean.VoteDatas;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class VoteManager
/*     */ {
/*     */   static boolean isVoteIdsValidInCfg(long roleId, int activityId, STCommonVoteCfg cfg, Set<Integer> voteIds)
/*     */   {
/*  25 */     if ((voteIds == null) || (voteIds.size() == 0))
/*     */     {
/*  27 */       return false;
/*     */     }
/*  29 */     if (cfg == null)
/*     */     {
/*  31 */       GameServer.logger().error(String.format("[vote]VoteManager.isVoteIdsValidInCfg@ can not find STCommonVoteCfg by activityId!|roleId=%d|activityId=%d|voteIds=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(activityId), voteIds }));
/*     */       
/*     */ 
/*     */ 
/*  35 */       return false;
/*     */     }
/*  37 */     if (!cfg.voteSonIds.containsAll(voteIds))
/*     */     {
/*  39 */       GameServer.logger().error(String.format("[vote]VoteManager.isVoteIdsValidInCfg@ voteIds is illegal!|roleId=%d|activityId=%d|voteIds=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(activityId), voteIds }));
/*     */       
/*     */ 
/*     */ 
/*  43 */       return false;
/*     */     }
/*  45 */     if (voteIds.size() > cfg.voteNumMaxPerCount)
/*     */     {
/*  47 */       GameServer.logger().error(String.format("[vote]VoteManager.isVoteIdsValidInCfg@ voteIds' size too long!|roleId=%d|activityId=%d|voteIds=%s|cfg.voteNumMaxPerCount=%d", new Object[] { Long.valueOf(roleId), Integer.valueOf(activityId), voteIds, Integer.valueOf(cfg.voteNumMaxPerCount) }));
/*     */       
/*     */ 
/*     */ 
/*  51 */       return false;
/*     */     }
/*  53 */     if (!singleActivityCheck(roleId, activityId, cfg, voteIds))
/*     */     {
/*  55 */       GameServer.logger().error(String.format("[vote]VoteManager.isVoteIdsValidInCfg@ singleActivityCheck err!|roleId=%d|activityId=%d|voteIds=%s", new Object[] { Long.valueOf(roleId), Integer.valueOf(activityId), voteIds }));
/*     */       
/*     */ 
/*     */ 
/*  59 */       return false;
/*     */     }
/*  61 */     return true;
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
/*     */   static boolean singleActivityCheck(long roleId, int activityId, STCommonVoteCfg cfg, Set<Integer> voteIds)
/*     */   {
/*  75 */     SingleActivityHandler handler = VoteHandManager.getActivityHandler(activityId);
/*  76 */     if (handler == null)
/*     */     {
/*  78 */       return true;
/*     */     }
/*  80 */     return handler.isVoteIdsValid(roleId, cfg, voteIds);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isVoteOpen(int openId)
/*     */   {
/*  91 */     return OpenInterface.getOpenStatus(openId);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   static boolean isActivityValid(int activityId)
/*     */   {
/* 102 */     return STCommonVoteCfg.get(activityId) != null;
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
/*     */   static void tlogVoteInfo(String userId, long roleId, int activityId, Set<Integer> curVoteIds, VoteDatas xVoteDatas)
/*     */   {
/* 119 */     String vGameIP = GameServerInfoManager.getHostIP();
/* 120 */     int rolelevel = RoleInterface.getLevel(roleId);
/*     */     
/* 122 */     Object[] colums = { vGameIP, userId, Long.valueOf(roleId), Integer.valueOf(rolelevel), Integer.valueOf(activityId), curVoteIds.toString(), getOwnVoteDataStr(xVoteDatas) };
/*     */     
/*     */ 
/* 125 */     TLogManager.getInstance().addLog(roleId, "CommonVote", colums);
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
/*     */   static String getOwnVoteDataStr(VoteDatas xVoteDatas)
/*     */   {
/* 138 */     if (xVoteDatas == null)
/*     */     {
/* 140 */       return "";
/*     */     }
/* 142 */     StringBuffer sb = new StringBuffer();
/* 143 */     for (VoteData xVoteData : xVoteDatas.getVotedinfos())
/*     */     {
/* 145 */       sb.append(xVoteData.getVotedids().toString());
/*     */     }
/* 147 */     return sb.toString();
/*     */   }
/*     */   
/*     */   public static void main(String[] args)
/*     */   {
/* 152 */     List<Integer> a = new ArrayList();
/* 153 */     a.add(Integer.valueOf(1));
/* 154 */     a.add(Integer.valueOf(2));
/* 155 */     a.add(Integer.valueOf(3));
/* 156 */     a.add(Integer.valueOf(4));
/* 157 */     List<Integer> b = new ArrayList();
/* 158 */     b.add(Integer.valueOf(1));
/* 159 */     b.add(Integer.valueOf(2));
/* 160 */     b.add(Integer.valueOf(3));
/* 161 */     b.add(Integer.valueOf(4));
/*     */     
/* 163 */     List<List<Integer>> c = new ArrayList();
/* 164 */     c.add(a);
/* 165 */     c.add(b);
/*     */     
/* 167 */     StringBuffer sb = new StringBuffer();
/* 168 */     for (List<Integer> d : c)
/*     */     {
/* 170 */       sb.append(d.toString());
/*     */     }
/* 172 */     System.out.println(sb.toString());
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\vote\main\VoteManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */