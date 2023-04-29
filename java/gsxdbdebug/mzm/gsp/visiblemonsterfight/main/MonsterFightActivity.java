/*     */ package mzm.gsp.visiblemonsterfight.main;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.activity.SSyncVisibleMonsterFightTip;
/*     */ import mzm.gsp.activity.SSyncVisibleMonsterReward;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.activity.main.ActivityLogStatus;
/*     */ import mzm.gsp.activity.main.ActivityStage;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.monster.main.MonsterInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class MonsterFightActivity
/*     */   implements IMonsterDeadHandle
/*     */ {
/*     */   protected AwardReason reason;
/*  27 */   protected int activityType = 0;
/*     */   
/*     */ 
/*     */   public void init() {}
/*     */   
/*     */ 
/*     */   public abstract int getModifyId(Collection<Long> paramCollection, long paramLong);
/*     */   
/*     */   public final int getTeamAverageLevel(Collection<Long> roleIdSet)
/*     */   {
/*  37 */     int totalLv = 0;
/*  38 */     for (Iterator i$ = roleIdSet.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/*  39 */       totalLv += RoleInterface.getLevel(roleId);
/*     */     }
/*  41 */     return totalLv / roleIdSet.size();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void initData(String userid, long roleId, int turn, int activityid) {}
/*     */   
/*     */ 
/*     */   public List<ActivityStage> getActivityStages()
/*     */   {
/*  51 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void onActivityStageStart(int stage, boolean startAgain, int activityid) {}
/*     */   
/*     */ 
/*     */   public AwardReason getRecommendAwardReason()
/*     */   {
/*  61 */     return this.reason;
/*     */   }
/*     */   
/*     */   public abstract int getRewardLimit();
/*     */   
/*     */   public abstract int getActivity();
/*     */   
/*     */   public boolean handleMonsterDead(VisibleMonsterFightContext context)
/*     */   {
/*  70 */     boolean check1 = checkMonster1(context.monsterIdList);
/*  71 */     boolean check2 = checkMonster2(context.monsterIdList);
/*  72 */     if ((!check1) && (!check2)) {
/*  73 */       return false;
/*     */     }
/*  75 */     int activityId = getActivity();
/*  76 */     Map<Long, String> role2user = new HashMap();
/*  77 */     for (Iterator i$ = context.roleList.iterator(); i$.hasNext();) { long roleid = ((Long)i$.next()).longValue();
/*  78 */       role2user.put(Long.valueOf(roleid), context.allUsers.get(Long.valueOf(roleid)));
/*     */     }
/*  80 */     ActivityJoinResult result = ActivityInterface.canJoinAndCheckInitActivityData(role2user, context.roleList, activityId);
/*     */     
/*  82 */     if (!result.isCanJoin()) {
/*  83 */       return false;
/*     */     }
/*  85 */     Iterator<Long> it = context.roleList.iterator();
/*  86 */     while (it.hasNext()) {
/*  87 */       Long roleId = (Long)it.next();
/*  88 */       int count = ActivityInterface.getActivityCount((String)role2user.get(roleId), roleId.longValue(), activityId, true);
/*  89 */       if (count >= getRewardLimit()) {
/*  90 */         SSyncVisibleMonsterFightTip tips = new SSyncVisibleMonsterFightTip();
/*  91 */         tips.activityid = activityId;
/*  92 */         OnlineManager.getInstance().sendAtOnce(roleId.longValue(), tips);
/*  93 */         it.remove();
/*     */ 
/*     */       }
/*  96 */       else if (count == getRewardLimit() - 1) {
/*  97 */         SSyncVisibleMonsterFightTip tips = new SSyncVisibleMonsterFightTip();
/*  98 */         tips.activityid = activityId;
/*  99 */         OnlineManager.getInstance().sendAtOnce(roleId.longValue(), tips);
/*     */       }
/*     */     }
/* 102 */     if (context.roleList.isEmpty()) {
/* 103 */       return false;
/*     */     }
/* 105 */     boolean isFightOk = false;
/* 106 */     if (check1) {
/* 107 */       award(getAwardId1(context), context);
/* 108 */       isFightOk = true;
/*     */     }
/* 110 */     if (check2) {
/* 111 */       award(getAwardId2(context), context);
/* 112 */       isFightOk = true;
/*     */     }
/* 114 */     if (isFightOk) {
/* 115 */       addCounter(role2user, context.roleList);
/*     */     }
/* 117 */     return isFightOk;
/*     */   }
/*     */   
/*     */   public abstract int getAwardId1(VisibleMonsterFightContext paramVisibleMonsterFightContext);
/*     */   
/*     */   public abstract int getAwardId2(VisibleMonsterFightContext paramVisibleMonsterFightContext);
/*     */   
/*     */   public void addCounter(Map<Long, String> role2user, List<Long> roleList) {
/* 125 */     for (Long roleId : roleList) {
/* 126 */       String userid = (String)role2user.get(roleId);
/* 127 */       ActivityInterface.addActivityCount(userid, roleId.longValue(), getActivity());
/* 128 */       int count = ActivityInterface.getActivityCount(userid, roleId.longValue(), getActivity(), false);
/* 129 */       if (count >= getRewardLimit()) {
/* 130 */         ActivityInterface.tlogActivity(roleId.longValue(), getActivity(), ActivityLogStatus.FINISH);
/* 131 */         ActivityInterface.logActivity(roleId.longValue(), getActivity(), ActivityLogStatus.FINISH);
/*     */       } else {
/* 133 */         ActivityInterface.logActivity(roleId.longValue(), getActivity(), ActivityLogStatus.FINISH);
/* 134 */         ActivityInterface.tlogActivity(roleId.longValue(), getActivity(), ActivityLogStatus.ATTEND);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public void award(int awardId, VisibleMonsterFightContext context) {
/* 140 */     boolean isSend = this.activityType == 0;
/* 141 */     for (Long roleId : context.roleList) {
/* 142 */       int modifyId = getModifyId(context.roleList, roleId.longValue());
/* 143 */       AwardModel awardModel = AwardInterface.award(awardId, (String)context.allUsers.get(roleId), roleId.longValue(), modifyId, context.roleList, context.allRoles, false, isSend, this.reason);
/*     */       
/* 145 */       if (!isSend) {
/* 146 */         sendReward(roleId.longValue(), awardModel, this.activityType);
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean handleMonsterWin(VisibleMonsterFightContext context) {
/* 152 */     if ((checkMonster2(context.monsterIdList)) || (checkMonster1(context.monsterIdList))) {
/* 153 */       return true;
/*     */     }
/* 155 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getVisibleMonsterId1()
/*     */   {
/* 164 */     return Integer.MIN_VALUE;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getVisibleMonsterId2()
/*     */   {
/* 173 */     return Integer.MIN_VALUE;
/*     */   }
/*     */   
/*     */   public boolean checkMonster1(List<Integer> monsterIdList) {
/* 177 */     for (Integer mid : monsterIdList) {
/* 178 */       if (MonsterInterface.getMonsterCategoryId(mid.intValue()) == getVisibleMonsterId1()) {
/* 179 */         return true;
/*     */       }
/*     */     }
/* 182 */     return false;
/*     */   }
/*     */   
/*     */   public boolean checkMonster2(List<Integer> monsterIdList) {
/* 186 */     for (Integer mid : monsterIdList) {
/* 187 */       if (MonsterInterface.getMonsterCategoryId(mid.intValue()) == getVisibleMonsterId2()) {
/* 188 */         return true;
/*     */       }
/*     */     }
/* 191 */     return false;
/*     */   }
/*     */   
/*     */   public void sendReward(long roleId, AwardModel awardModel, int activityType) {
/* 195 */     if (awardModel == null)
/* 196 */       return;
/* 197 */     SSyncVisibleMonsterReward sSyncVisibleMonsterReward = new SSyncVisibleMonsterReward();
/* 198 */     sSyncVisibleMonsterReward.activitytype = activityType;
/* 199 */     AwardInterface.fillAwardBean(sSyncVisibleMonsterReward.awardbean, awardModel);
/* 200 */     OnlineManager.getInstance().send(roleId, sSyncVisibleMonsterReward);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\visiblemonsterfight\main\MonsterFightActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */