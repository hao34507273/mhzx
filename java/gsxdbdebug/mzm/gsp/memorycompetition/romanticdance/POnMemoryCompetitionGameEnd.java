/*     */ package mzm.gsp.memorycompetition.romanticdance;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServer;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity2.confbean.SMemoryCompetitionCfg;
/*     */ import mzm.gsp.activity2.confbean.SRomanticDanceConsts;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.awardpool.main.AwardPoolInterface;
/*     */ import mzm.gsp.awardpool.main.AwardPoolResultData;
/*     */ import mzm.gsp.friend.main.FriendInterface;
/*     */ import mzm.gsp.item.main.LotteryManager;
/*     */ import mzm.gsp.memorycompetition.SRomanticDanceEndBigAward;
/*     */ import mzm.gsp.memorycompetition.SRomanticDanceFriendValueAdd;
/*     */ import mzm.gsp.memorycompetition.event.MemoryCompetitionGameEndArg;
/*     */ import mzm.gsp.memorycompetition.event.MemoryCompetitionGameEndArg.MemoryQuestionInfo;
/*     */ import mzm.gsp.memorycompetition.event.MemoryCompetitionGameEndEventProcedure;
/*     */ import mzm.gsp.memorycompetition.main.MemoryCompetitionManager;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.team.main.TeamInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.User;
/*     */ 
/*     */ public class POnMemoryCompetitionGameEnd extends MemoryCompetitionGameEndEventProcedure
/*     */ {
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  37 */     if (((MemoryCompetitionGameEndArg)this.arg).activityCfgId != SRomanticDanceConsts.getInstance().activity_cfg_id)
/*     */     {
/*  39 */       return false;
/*     */     }
/*     */     
/*  42 */     List<Long> roleIdList = ((MemoryCompetitionGameEndArg)this.arg).roleIdList;
/*     */     
/*  44 */     Map<Long, String> roleId2userIdMap = new HashMap();
/*  45 */     for (Iterator i$ = roleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*  47 */       String userId = RoleInterface.getUserId(roleId);
/*  48 */       roleId2userIdMap.put(Long.valueOf(roleId), userId);
/*     */     }
/*     */     
/*  51 */     lock(User.getTable(), roleId2userIdMap.values());
/*  52 */     lock(xtable.Role2properties.getTable(), roleIdList);
/*     */     
/*     */ 
/*  55 */     mzm.gsp.status.main.RoleStatusInterface.unsetStatus(roleIdList, 921);
/*     */     
/*  57 */     if (roleIdList.size() != 2)
/*     */     {
/*  59 */       return true;
/*     */     }
/*     */     
/*  62 */     long roleIdA = ((Long)roleIdList.get(0)).longValue();
/*  63 */     long roleIdB = ((Long)roleIdList.get(1)).longValue();
/*     */     
/*  65 */     Long teamId = TeamInterface.getTeamidByRoleid(roleIdA, true);
/*  66 */     if (teamId == null)
/*     */     {
/*  68 */       GameServer.logger().info(String.format("[romanticdance]POnMemoryCompetitionGameEnd.processImp@team id is null|role_id_list=%s", new Object[] { roleIdList.toString() }));
/*     */       
/*     */ 
/*  71 */       return true;
/*     */     }
/*     */     
/*  74 */     List<Long> teamRoleIdList = TeamInterface.getTeamMemberList(teamId.longValue(), true);
/*  75 */     if (teamRoleIdList.size() != roleIdList.size())
/*     */     {
/*  77 */       GameServer.logger().info(String.format("[romanticdance]POnMemoryCompetitionGameEnd.processImp@team changes|role_id_list=%s|team_role_id_list=%s", new Object[] { roleIdList.toString(), teamRoleIdList.toString() }));
/*     */       
/*     */ 
/*     */ 
/*  81 */       return true;
/*     */     }
/*     */     
/*  84 */     for (Iterator i$ = teamRoleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/*  86 */       if (!roleIdList.contains(Long.valueOf(roleId)))
/*     */       {
/*  88 */         GameServer.logger().info(String.format("[romanticdance]POnMemoryCompetitionGameEnd.processImp@team changes|role_id_list=%s|team_role_id_list=%s", new Object[] { roleIdList.toString(), teamRoleIdList.toString() }));
/*     */         
/*     */ 
/*     */ 
/*  92 */         return true;
/*     */       }
/*     */     }
/*  95 */     SMemoryCompetitionCfg competitionCfg = SMemoryCompetitionCfg.get(((MemoryCompetitionGameEndArg)this.arg).memoryCompetitionCfgId);
/*  96 */     if (competitionCfg == null)
/*     */     {
/*  98 */       return true;
/*     */     }
/*     */     
/* 101 */     Map<Long, List<MemoryCompetitionGameEndArg.MemoryQuestionInfo>> questionInfoMap = ((MemoryCompetitionGameEndArg)this.arg).questionInfoMap;
/* 102 */     Map<Long, Integer> aleardyActivityCountMap = new HashMap();
/*     */     
/* 104 */     boolean isBigGiftAward = true;
/* 105 */     boolean isNeedAddFriendValue = true;
/*     */     
/* 107 */     for (Iterator i$ = roleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */       
/* 109 */       String userId = (String)roleId2userIdMap.get(Long.valueOf(roleId));
/*     */       
/* 111 */       int aleardyActivityCount = ActivityInterface.getActivityCount(userId, roleId, ((MemoryCompetitionGameEndArg)this.arg).activityCfgId, true);
/* 112 */       aleardyActivityCountMap.put(Long.valueOf(roleId), Integer.valueOf(aleardyActivityCount));
/*     */       
/* 114 */       ActivityInterface.addActivityCount(userId, roleId, ((MemoryCompetitionGameEndArg)this.arg).activityCfgId, 1);
/* 115 */       List<MemoryCompetitionGameEndArg.MemoryQuestionInfo> questionInfoList = (List)questionInfoMap.get(Long.valueOf(roleId));
/* 116 */       List<Integer> awardIdList = new ArrayList();
/* 117 */       for (MemoryCompetitionGameEndArg.MemoryQuestionInfo memoryQuestionInfo : questionInfoList)
/*     */       {
/* 119 */         if (memoryQuestionInfo.isAnswerRight)
/*     */         {
/* 121 */           awardIdList.add(Integer.valueOf(competitionCfg.right_answer_award));
/*     */         }
/*     */         else
/*     */         {
/* 125 */           isBigGiftAward = false;
/* 126 */           awardIdList.add(Integer.valueOf(competitionCfg.wrong_answer_award));
/*     */         }
/*     */       }
/*     */       
/* 130 */       if (aleardyActivityCount >= SRomanticDanceConsts.getInstance().every_day_award_times)
/*     */       {
/* 132 */         isNeedAddFriendValue = false;
/*     */       }
/*     */       else
/*     */       {
/* 136 */         AwardInterface.award(awardIdList, null, (String)roleId2userIdMap.get(Long.valueOf(roleId)), roleId, false, true, new AwardReason(LogReason.ROMANTIC_DANCE_QUESTION_NORMAL_AWARD));
/*     */       }
/*     */     }
/*     */     
/* 140 */     if (isNeedAddFriendValue)
/*     */     {
/* 142 */       int addValue = FriendInterface.addFriendValue(roleIdA, roleIdB, SRomanticDanceConsts.getInstance().award_friend_relation_num, 4);
/*     */       
/* 144 */       if (addValue > 0)
/*     */       {
/* 146 */         SRomanticDanceFriendValueAdd friendValueAdd = new SRomanticDanceFriendValueAdd();
/* 147 */         friendValueAdd.add_value = addValue;
/*     */         
/* 149 */         OnlineManager.getInstance().sendMulti(friendValueAdd, roleIdList);
/*     */       }
/*     */     }
/*     */     
/* 153 */     int roleIdAGender = RoleInterface.getGender(roleIdA);
/* 154 */     int roleIdBGender = RoleInterface.getGender(roleIdB);
/* 155 */     Iterator i$; if (roleIdAGender != roleIdBGender)
/*     */     {
/* 157 */       for (i$ = roleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */         
/* 159 */         if (((Integer)aleardyActivityCountMap.get(Long.valueOf(roleId))).intValue() < SRomanticDanceConsts.getInstance().every_day_award_times)
/*     */         {
/*     */ 
/*     */ 
/* 163 */           AwardInterface.award(SRomanticDanceConsts.getInstance().male_and_femal_extra_award, (String)roleId2userIdMap.get(Long.valueOf(roleId)), roleId, false, true, new AwardReason(LogReason.ROMANTIC_DANCE_MALE_FEMALE_AWARD));
/*     */         }
/*     */       }
/*     */     }
/*     */     
/*     */ 
/* 169 */     MemoryCompetitionManager.tlogRomantciDanceScore(roleIdA, roleIdB, ((MemoryCompetitionGameEndArg)this.arg).score);
/*     */     
/*     */     Iterator i$;
/* 172 */     if (isBigGiftAward)
/*     */     {
/* 174 */       for (i$ = roleIdList.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*     */         
/* 176 */         if (((Integer)aleardyActivityCountMap.get(Long.valueOf(roleId))).intValue() < SRomanticDanceConsts.getInstance().every_day_award_times)
/*     */         {
/*     */ 
/*     */ 
/*     */ 
/* 181 */           SRomanticDanceEndBigAward endBigAward = new SRomanticDanceEndBigAward();
/* 182 */           AwardPoolResultData awardPoolResultData = AwardPoolInterface.getAwardPoolData(competitionCfg.extra_award, roleId, RoleInterface.getLevel(roleId));
/*     */           
/*     */ 
/* 185 */           for (Map.Entry<Integer, Integer> entry : awardPoolResultData.getItemMap().entrySet())
/*     */           {
/* 187 */             endBigAward.award_item_map.put(entry.getKey(), entry.getValue());
/*     */           }
/*     */           
/* 190 */           LotteryManager.addLottery(roleId, 8, 0, awardPoolResultData, new TLogArg(LogReason.ROMANTIC_DANCE_QUESTION_END_AWARD), SRomanticDanceConsts.getInstance().delay_award_seconds);
/*     */           
/*     */ 
/*     */ 
/* 194 */           OnlineManager.getInstance().send(roleId, endBigAward);
/*     */         }
/*     */       }
/*     */     }
/* 198 */     GameServer.logger().info(String.format("[romanticdance]POnMemoryCompetitionGameEnd.processImp@success|role_id_list=%s|is_big_gift_award=%b", new Object[] { roleIdList.toString(), Boolean.valueOf(isBigGiftAward) }));
/*     */     
/*     */ 
/*     */ 
/* 202 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\memorycompetition\romanticdance\POnMemoryCompetitionGameEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */