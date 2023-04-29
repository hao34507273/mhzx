/*     */ package mzm.gsp.circletask.main;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.chivalry.main.ChivalryInterface;
/*     */ import mzm.gsp.circletask.confbean.CircleTaskConsts;
/*     */ import mzm.gsp.gang.main.GangInterface;
/*     */ import mzm.gsp.gang.main.ModBangGongResult;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.tlog.TLogArg;
/*     */ import mzm.gsp.util.DateTimeUtils;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import xbean.CircleTask;
/*     */ import xbean.Pod;
/*     */ import xtable.Basic;
/*     */ import xtable.Gang;
/*     */ import xtable.Role2circletask;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ public class PTeamAward
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleId;
/*     */   private final List<Long> members;
/*     */   
/*     */   public PTeamAward(long roleId, List<Long> members)
/*     */   {
/*  35 */     this.roleId = roleId;
/*  36 */     this.members = members;
/*     */   }
/*     */   
/*     */   protected boolean processImp() throws Exception
/*     */   {
/*  41 */     if (!this.members.contains(Long.valueOf(this.roleId))) {
/*  42 */       this.members.add(Long.valueOf(this.roleId));
/*     */     }
/*  44 */     List<Long> sameFactionMembers = new ArrayList();
/*  45 */     lockAllUser(this.members);
/*  46 */     lock(Basic.getTable(), this.members);
/*  47 */     getSameFactionMembers(sameFactionMembers);
/*  48 */     for (Iterator i$ = this.members.iterator(); i$.hasNext();) { long member = ((Long)i$.next()).longValue();
/*  49 */       doAward(sameFactionMembers, member);
/*     */     }
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   private void getSameFactionMembers(List<Long> sameFactionMembers) {
/*  55 */     long factionId = GangInterface.getGangId(this.roleId);
/*  56 */     if (factionId <= 0L) {
/*  57 */       return;
/*     */     }
/*  59 */     getSameFactionMembers(factionId, this.members, sameFactionMembers);
/*  60 */     lock(Gang.getTable(), Arrays.asList(new Long[] { Long.valueOf(factionId) }));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void doAward(List<Long> sameFactionMembers, long member)
/*     */   {
/*  70 */     if (member == this.roleId) {
/*  71 */       return;
/*     */     }
/*  73 */     ChivalryInterface.addRoleChivalry(member, awardChivalryValue(), 2, new TLogArg(LogReason.CIRCLE_AWARD_CHIVALRY), true);
/*     */     
/*  75 */     if (!sameFactionMembers.contains(Long.valueOf(member))) {
/*  76 */       return;
/*     */     }
/*  78 */     CircleTask xCircleTask = Role2circletask.get(Long.valueOf(member));
/*  79 */     if (xCircleTask == null) {
/*  80 */       Role2circletask.insert(Long.valueOf(member), xCircleTask = Pod.newCircleTask());
/*     */     }
/*  82 */     long currTime = DateTimeUtils.getCurrTimeInMillis();
/*  83 */     if (DateTimeUtils.needWeeklyReset(xCircleTask.getFactioncontributionupdatetime(), currTime, 2, 0)) {
/*  84 */       xCircleTask.setFactioncontribution(0);
/*  85 */       xCircleTask.setFactioncontributionupdatetime(currTime);
/*     */     }
/*  87 */     if (xCircleTask.getFactioncontribution() >= CircleTaskConsts.getInstance().AWARD_BANGGONG_MAX)
/*     */     {
/*  89 */       CircleTaskManager.sendCircleNotice(member, false, 1, new String[0]);
/*  90 */       return;
/*     */     }
/*  92 */     ModBangGongResult res = GangInterface.addBangGong(member, awardBangGongValue(), new TLogArg(LogReason.CIRCLE_AWARD_BANGGONG));
/*  93 */     if ((res.isSucceed()) && (res.getModValue() > 0L)) {
/*  94 */       xCircleTask.setFactioncontribution(xCircleTask.getFactioncontribution() + (int)res.getModValue());
/*  95 */       AwardInterface.awardCurrencyNotice(member, 1, 4, (int)res.getModValue());
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private List<Long> getSameFactionMembers(long factionId, List<Long> members, List<Long> sameFactionMembers)
/*     */   {
/* 107 */     if (factionId <= 0L) {
/* 108 */       return sameFactionMembers;
/*     */     }
/* 110 */     for (Iterator i$ = members.iterator(); i$.hasNext();) { long member = ((Long)i$.next()).longValue();
/* 111 */       if ((member != this.roleId) && 
/*     */       
/*     */ 
/* 114 */         (GangInterface.getGangId(member) == factionId))
/*     */       {
/*     */ 
/* 117 */         sameFactionMembers.add(Long.valueOf(member)); }
/*     */     }
/* 119 */     return sameFactionMembers;
/*     */   }
/*     */   
/*     */   private int awardChivalryValue() {
/* 123 */     return CircleTaskConsts.getInstance().AWARD_XIAYIZHI;
/*     */   }
/*     */   
/*     */   private int awardBangGongValue() {
/* 127 */     return CircleTaskConsts.getInstance().AWARD_BANGGONG;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private Map<Long, String> lockAllUser(List<Long> members)
/*     */   {
/* 136 */     if ((members == null) || (members.size() == 0)) {
/* 137 */       return null;
/*     */     }
/* 139 */     Map<Long, String> roleId2userId = new HashMap();
/* 140 */     for (Iterator i$ = members.iterator(); i$.hasNext();) { long roleId = ((Long)i$.next()).longValue();
/* 141 */       String userid = RoleInterface.getUserId(roleId);
/* 142 */       roleId2userId.put(Long.valueOf(roleId), userid);
/*     */     }
/* 144 */     if (roleId2userId.size() == 0) {
/* 145 */       return null;
/*     */     }
/*     */     
/* 148 */     lock(User.getTable(), roleId2userId.values());
/* 149 */     return roleId2userId;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\circletask\main\PTeamAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */