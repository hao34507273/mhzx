/*     */ package mzm.gsp.drawandguess.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.TreeMap;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.drawandguess.RoleGetJifenInfo;
/*     */ import mzm.gsp.drawandguess.SSynRoleGetJifenInfoList;
/*     */ import mzm.gsp.drawandguess.confbean.SDrawAndGuessActivityCfg;
/*     */ import mzm.gsp.drawandguess.confbean.SDrawAndGuessRuleCfg;
/*     */ import mzm.gsp.drawandguess.confbean.SLibid2JifenRewardsCfg;
/*     */ import mzm.gsp.drawandguess.event.DrawAndGuessFinishArg;
/*     */ import mzm.gsp.drawandguess.event.DrawAndGuessFinishProcedure;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Role2drawandguess_info;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnDrawAndGuessFinished extends DrawAndGuessFinishProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  34 */     if ((((DrawAndGuessFinishArg)this.arg).getContext() == null) || (!(((DrawAndGuessFinishArg)this.arg).getContext() instanceof DrawAndGuessContext)))
/*     */     {
/*  36 */       return false;
/*     */     }
/*  38 */     DrawAndGuessContext drawAndGuessContext = (DrawAndGuessContext)((DrawAndGuessFinishArg)this.arg).getContext();
/*     */     
/*  40 */     boolean isActivityOpen = ActivityInterface.isActivityOpen(drawAndGuessContext.activityCfgId);
/*     */     
/*  42 */     if ((((DrawAndGuessFinishArg)this.arg).getAll_roleids() == null) || (((DrawAndGuessFinishArg)this.arg).getAll_roleids().size() == 0))
/*     */     {
/*  44 */       return false;
/*     */     }
/*     */     
/*  47 */     int turn = ((DrawAndGuessFinishArg)this.arg).getAll_roleids().indexOf(Long.valueOf(((DrawAndGuessFinishArg)this.arg).getDrawer_id()));
/*  48 */     if (turn < 0)
/*     */     {
/*  50 */       return false;
/*     */     }
/*  52 */     SDrawAndGuessActivityCfg sDrawAndGuessActivityCfg = SDrawAndGuessActivityCfg.get(drawAndGuessContext.activityCfgId);
/*  53 */     if (sDrawAndGuessActivityCfg == null)
/*     */     {
/*  55 */       return false;
/*     */     }
/*  57 */     SDrawAndGuessRuleCfg sDrawAndGuessRuleCfg = SDrawAndGuessRuleCfg.get(sDrawAndGuessActivityCfg.ruleId);
/*  58 */     if (sDrawAndGuessRuleCfg == null)
/*     */     {
/*  60 */       return false; }
/*     */     Map<Long, String> roleidToUserid;
/*     */     Integer awardId;
/*  63 */     Map<Integer, Integer> jifenRewardMap; if ((isActivityOpen) && (turn + 1 < ((DrawAndGuessFinishArg)this.arg).getAll_roleids().size()))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*  68 */       Long drawerId = (Long)((DrawAndGuessFinishArg)this.arg).getAll_roleids().get(turn + 1);
/*  69 */       DrawAndGuessContext context = new DrawAndGuessContext(drawAndGuessContext.activityCfgId, drawAndGuessContext.qusetionQueue, drawAndGuessContext.jifenInfo);
/*     */       
/*     */ 
/*  72 */       new DrawAndGuessBegainSession(sDrawAndGuessRuleCfg.resultShowTime, drawerId.longValue(), ((DrawAndGuessFinishArg)this.arg).getAll_roleids(), sDrawAndGuessActivityCfg.ruleId, context);
/*     */ 
/*     */     }
/*     */     else
/*     */     {
/*  77 */       roleidToUserid = new HashMap();
/*  78 */       List<Long> allRoles = ((DrawAndGuessFinishArg)this.arg).getAll_roleids();
/*  79 */       for (Long roleid : allRoles)
/*     */       {
/*  81 */         String userid = RoleInterface.getUserId(roleid.longValue());
/*  82 */         roleidToUserid.put(roleid, userid);
/*     */       }
/*  84 */       lock(User.getTable(), roleidToUserid.values());
/*  85 */       lock(Role2drawandguess_info.getTable(), allRoles);
/*     */       
/*     */ 
/*  88 */       SSynRoleGetJifenInfoList res = new SSynRoleGetJifenInfoList();
/*  89 */       for (Map.Entry<Long, Integer> entry : drawAndGuessContext.jifenInfo.entrySet())
/*     */       {
/*  91 */         res.jifen_list.add(new RoleGetJifenInfo(((Long)entry.getKey()).longValue(), ((Integer)entry.getValue()).intValue()));
/*     */       }
/*  93 */       OnlineManager.getInstance().sendMulti(res, allRoles);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 100 */       ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(roleidToUserid, allRoles, drawAndGuessContext.activityCfgId);
/*     */       
/*     */ 
/* 103 */       if (!result.isCanJoin())
/*     */       {
/* 105 */         return false;
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 111 */       DrawAndGuessManager.filterJinFenMap(sDrawAndGuessActivityCfg, drawAndGuessContext.jifenInfo);
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 116 */       for (Long roleid : allRoles)
/*     */       {
/* 118 */         ActivityInterface.addActivityCount((String)roleidToUserid.get(roleid), roleid.longValue(), drawAndGuessContext.activityCfgId);
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/* 124 */       List<Integer> jifenList = new ArrayList(drawAndGuessContext.jifenInfo.values());
/* 125 */       Collections.sort(jifenList);
/* 126 */       Collections.reverse(jifenList);
/* 127 */       awardId = null;
/*     */       
/* 129 */       for (Map.Entry<Long, Integer> entry : drawAndGuessContext.jifenInfo.entrySet())
/*     */       {
/* 131 */         Long roleId = (Long)entry.getKey();
/* 132 */         Integer jifen = (Integer)entry.getValue();
/*     */         
/* 134 */         if (jifen.intValue() > 0)
/*     */         {
/*     */ 
/*     */ 
/* 138 */           Integer rankIndex = Integer.valueOf(jifenList.indexOf(jifen));
/* 139 */           awardId = (Integer)sDrawAndGuessActivityCfg.awardCfgidList.get(rankIndex.intValue());
/* 140 */           if (awardId == null)
/*     */           {
/* 142 */             GameServer.logger().error(String.format("[drawandguess]PDrawAndGuessFinished.processImp@ awardId illegal!|roleId=%d|rankIndex=%d|awardId=%d", new Object[] { roleId, rankIndex, awardId }));
/*     */ 
/*     */           }
/*     */           else
/*     */           {
/*     */ 
/* 148 */             AwardReason reason = new AwardReason(LogReason.DRAW_AND_GUESS_RANK_AWARD);
/* 149 */             AwardModel awardModel = AwardInterface.awardFixAward(awardId.intValue(), (String)roleidToUserid.get(roleId), roleId.longValue(), false, true, reason);
/*     */             
/* 151 */             if (awardModel == null)
/*     */             {
/* 153 */               GameServer.logger().error(String.format("[drawandguess]PDrawAndGuessFinished.processImp@get rank award failed|roleId=%d|awardId=%d", new Object[] { roleId, awardId }));
/*     */             }
/*     */           }
/*     */         }
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 164 */       SLibid2JifenRewardsCfg sLibid2JifenRewardsCfg = SLibid2JifenRewardsCfg.get(sDrawAndGuessActivityCfg.jifenLibId);
/* 165 */       jifenRewardMap = sLibid2JifenRewardsCfg.jifen2Award.descendingMap();
/*     */       
/* 167 */       for (Map.Entry<Long, Integer> jifen_entry : drawAndGuessContext.jifenInfo.entrySet())
/*     */       {
/* 169 */         Long roleId = (Long)jifen_entry.getKey();
/* 170 */         Integer jifen = (Integer)jifen_entry.getValue();
/*     */         
/* 172 */         for (Map.Entry<Integer, Integer> reward_entry : jifenRewardMap.entrySet())
/*     */         {
/* 174 */           if (jifen.intValue() >= ((Integer)reward_entry.getKey()).intValue())
/*     */           {
/* 176 */             awardId = (Integer)reward_entry.getValue();
/* 177 */             break;
/*     */           }
/*     */         }
/* 180 */         if (awardId == null)
/*     */         {
/* 182 */           GameServer.logger().error(String.format("[drawandguess]PDrawAndGuessFinished.processImp@ awardId illegal!|roleId=%d|jifen=%d|awardId=%d", new Object[] { roleId, jifen, awardId }));
/*     */ 
/*     */         }
/*     */         else
/*     */         {
/*     */ 
/* 188 */           AwardReason reason = new AwardReason(LogReason.DRAW_AND_GUESS_JIFEN_AWARD);
/* 189 */           AwardModel awardModel = AwardInterface.award(awardId.intValue(), (String)roleidToUserid.get(roleId), roleId.longValue(), false, true, reason);
/*     */           
/* 191 */           if (awardModel == null)
/*     */           {
/* 193 */             GameServer.logger().error(String.format("[drawandguess]PDrawAndGuessFinished.processImp@get jifen award failed|roleId=%d|awardId=%d", new Object[] { roleId, awardId }));
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 202 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\main\POnDrawAndGuessFinished.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */