/*     */ package mzm.gsp.breakegg.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import java.util.Set;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.nationalholiday.confbean.SRewardWeightCfg;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.BreakEggGameInfo;
/*     */ import xbean.BreakEggInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Role2drawandguess_info;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PGameFinished
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final List<Long> memberIds;
/*     */   
/*     */   public PGameFinished(List<Long> memberIds)
/*     */   {
/*  30 */     this.memberIds = memberIds;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  36 */     Map<Long, String> roleidToUserid = new HashMap();
/*  37 */     for (Long roleid : this.memberIds)
/*     */     {
/*  39 */       String userid = RoleInterface.getUserId(roleid.longValue());
/*  40 */       roleidToUserid.put(roleid, userid);
/*     */     }
/*     */     
/*  43 */     lock(User.getTable(), roleidToUserid.values());
/*  44 */     Lockeys.lock(Role2drawandguess_info.getTable(), this.memberIds);
/*     */     
/*  46 */     long inviterId = ((Long)this.memberIds.get(0)).longValue();
/*  47 */     String inviterUserId = (String)roleidToUserid.get(this.memberIds.get(0));
/*     */     
/*  49 */     BreakEggGameInfo xBreakegg_info = BreakEggManager.destroyBreakEggGameInfo(inviterId);
/*  50 */     if (xBreakegg_info != null)
/*     */     {
/*     */ 
/*  53 */       long gangId = GangInterface.getGangId(inviterId);
/*  54 */       Set<Long> gangMemberSet = null;
/*  55 */       if (gangId > 0L)
/*     */       {
/*  57 */         gangMemberSet = GangInterface.getGangMemberList(gangId);
/*     */       }
/*     */       
/*  60 */       List<Long> rewardRoleIds = BreakEggManager.getRewardRoleIdsAndAddTimes(roleidToUserid, inviterId, xBreakegg_info.getActivity_id());
/*     */       
/*     */ 
/*  63 */       ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(inviterUserId, inviterId, xBreakegg_info.getActivity_id());
/*     */       
/*     */ 
/*  66 */       if ((activityJoinResult.isCanJoin()) || (activityJoinResult.isActivityNotOpen()))
/*     */       {
/*     */ 
/*  69 */         ActivityInterface.addActivityCount(inviterUserId, inviterId, xBreakegg_info.getActivity_id());
/*     */         
/*  71 */         ActivityInterface.logActivity(inviterId, xBreakegg_info.getActivity_id(), ActivityLogStatus.FINISH);
/*     */         
/*  73 */         ActivityInterface.tlogActivity(inviterId, xBreakegg_info.getActivity_id(), ActivityLogStatus.FINISH);
/*     */       }
/*     */       
/*     */ 
/*  77 */       BreakEggManager.checkAndAutoBreak(xBreakegg_info);
/*     */       
/*     */ 
/*  80 */       for (Map.Entry<Integer, BreakEggInfo> entry : xBreakegg_info.getIndex2break_egg_info().entrySet())
/*     */       {
/*  82 */         BreakEggInfo xBreakEggInfo = (BreakEggInfo)entry.getValue();
/*     */         
/*  84 */         if (xBreakEggInfo.getRole_id() > 0L)
/*     */         {
/*     */ 
/*     */ 
/*  88 */           SRewardWeightCfg sRewardWeightCfg = SRewardWeightCfg.get(((Integer)xBreakegg_info.getReward_info_id().get(((Integer)entry.getKey()).intValue())).intValue());
/*  89 */           if (sRewardWeightCfg != null)
/*     */           {
/*     */ 
/*     */ 
/*     */ 
/*  94 */             if ((activityJoinResult.isCanJoin()) || (activityJoinResult.isActivityNotOpen()))
/*     */             {
/*  96 */               BreakEggManager.sendReward(inviterId, (BreakEggInfo)entry.getValue(), LogReason.BREAK_EGG_INVITER_REWARD);
/*     */             }
/*     */             
/*  99 */             if (rewardRoleIds.contains(Long.valueOf(xBreakEggInfo.getRole_id())))
/*     */             {
/* 101 */               BreakEggManager.sendReward(xBreakEggInfo.getRole_id(), (BreakEggInfo)entry.getValue(), LogReason.BREAK_EGG_INVITEE_REWARD); }
/*     */           }
/*     */         }
/*     */       }
/* 105 */       BreakEggManager.sBroadcastBreakEggReward(gangMemberSet, xBreakegg_info);
/*     */       
/* 107 */       BreakEggTLogManager.tlogBreakEgg(xBreakegg_info, rewardRoleIds);
/*     */       
/* 109 */       BreakEggManager.logger.info(String.format("[breakegg]PGameFinished.processImp@ success|activityCfgId=%d|memberIds=%s", new Object[] { Integer.valueOf(xBreakegg_info.getActivity_id()), this.memberIds }));
/*     */     }
/*     */     
/*     */ 
/* 113 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\breakegg\main\PGameFinished.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */