/*     */ package mzm.gsp.moneytree.main;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.award.main.AwardInterface;
/*     */ import mzm.gsp.award.main.AwardModel;
/*     */ import mzm.gsp.award.main.AwardReason;
/*     */ import mzm.gsp.moneytree.SAttendMoneyTreeFail;
/*     */ import mzm.gsp.moneytree.SAttendMoneyTreeSuccess;
/*     */ import mzm.gsp.moneytree.confbean.MoneyTreeConsts;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.role.main.RoleInterface;
/*     */ import mzm.gsp.status.main.RoleStatusInterface;
/*     */ import mzm.gsp.tlog.LogReason;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import org.apache.log4j.Logger;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ 
/*     */ 
/*     */ public class PCAttendMoneyTree
/*     */   extends LogicProcedure
/*     */ {
/*     */   private final long roleid;
/*     */   
/*     */   public PCAttendMoneyTree(long roleid)
/*     */   {
/*  33 */     this.roleid = roleid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if (!MoneyTreeManager.isMoneyTreeSwitchOpenForRole(this.roleid))
/*     */     {
/*     */ 
/*  42 */       onFail(-1, null);
/*  43 */       return false;
/*     */     }
/*  45 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 903, true))
/*     */     {
/*     */ 
/*  48 */       onFail(-2, null);
/*  49 */       return false;
/*     */     }
/*  51 */     if (!NpcInterface.checkNpcService(MoneyTreeConsts.getInstance().NPC_ID, MoneyTreeConsts.getInstance().NPC_SERVICE_ID, this.roleid))
/*     */     {
/*     */ 
/*     */ 
/*  55 */       onFail(-3, null);
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     String userid = RoleInterface.getUserId(this.roleid);
/*     */     
/*  61 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*     */     
/*  63 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*     */     
/*  65 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, MoneyTreeConsts.getInstance().ACTIVITY_CFG_ID);
/*     */     
/*  67 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*     */ 
/*  70 */       Map<String, Object> extraInfo = new HashMap();
/*  71 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  72 */       onFail(1, extraInfo);
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     AwardReason awardReason = new AwardReason(LogReason.MONEY_TREE_AWARD, MoneyTreeConsts.getInstance().ACTIVITY_CFG_ID);
/*     */     
/*  78 */     AwardModel awardModel = AwardInterface.awardPoolAward(MoneyTreeConsts.getInstance().AWARD_POOL_LIB_ID, userid, this.roleid, false, false, awardReason);
/*     */     
/*  80 */     if (awardModel == null)
/*     */     {
/*     */ 
/*  83 */       onFail(2, null);
/*  84 */       return false;
/*     */     }
/*     */     
/*  87 */     ActivityInterface.addActivityCount(userid, this.roleid, MoneyTreeConsts.getInstance().ACTIVITY_CFG_ID);
/*     */     
/*  89 */     SAttendMoneyTreeSuccess protocol = new SAttendMoneyTreeSuccess();
/*  90 */     AwardInterface.fillAwardBean(protocol.awardinfo, awardModel);
/*  91 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/*  93 */     StringBuilder sb = new StringBuilder();
/*  94 */     sb.append(String.format("[moneytree]PCAttendMoneyTree.processImp@attend money tree success|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*  95 */     MoneyTreeManager.logger.info(sb.toString());
/*  96 */     return true;
/*     */   }
/*     */   
/*     */   private void onFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 101 */     StringBuilder sb = new StringBuilder();
/* 102 */     sb.append(String.format("[moneytree]PCAttendMoneyTree.processImp@attend money tree fail|roleid=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(res) }));
/*     */     
/* 104 */     if (extraInfo != null)
/*     */     {
/* 106 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 108 */         sb.append("|").append((String)entry.getKey());
/* 109 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 112 */     MoneyTreeManager.logger.info(sb.toString());
/* 113 */     if (res > 0)
/*     */     {
/* 115 */       SAttendMoneyTreeFail protocol = new SAttendMoneyTreeFail();
/* 116 */       protocol.res = res;
/* 117 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\moneytree\main\PCAttendMoneyTree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */