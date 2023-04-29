/*     */ package mzm.gsp.worldgoal.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.worldgoal.SCommitItemFail;
/*     */ import mzm.gsp.worldgoal.SCommitItemSuccess;
/*     */ import mzm.gsp.worldgoal.confbean.SWorldGoalCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Pod;
/*     */ import xbean.RoleWorldGoalInfo;
/*     */ import xbean.WorldGoalActivityInfo;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.Role2worldgoalinfo;
/*     */ import xtable.User;
/*     */ 
/*     */ public class PCommitItemAtNPC extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final String userid;
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int NPCid;
/*     */   
/*     */   public PCommitItemAtNPC(String userid, long roleid, int activityCfgid, int NPCid)
/*     */   {
/*  30 */     this.userid = userid;
/*  31 */     this.roleid = roleid;
/*  32 */     this.activityCfgid = activityCfgid;
/*  33 */     this.NPCid = NPCid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  39 */     if (!mzm.gsp.npc.main.NpcInterface.checkNpcService(this.NPCid, SWorldGoalCfg.get(this.activityCfgid).commit_service_id, this.roleid))
/*     */     {
/*     */ 
/*  42 */       onCommitItemFail(6, null);
/*  43 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  47 */     lock(Lockeys.get(User.getTable(), this.userid));
/*  48 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*     */     
/*  50 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(this.userid, this.roleid, this.activityCfgid);
/*     */     
/*  52 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*  54 */       if (activityJoinResult.isActivityJoinCountMax())
/*     */       {
/*     */ 
/*  57 */         onCommitItemFail(2, null);
/*  58 */         return false;
/*     */       }
/*     */       
/*  61 */       Map<String, Object> extraInfo = new HashMap();
/*  62 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  63 */       onCommitItemFail(1, extraInfo);
/*  64 */       return false;
/*     */     }
/*     */     
/*  67 */     long now = mzm.gsp.util.DateTimeUtils.getCurrTimeInMillis();
/*  68 */     int roleCanCommitNum = WorldGoalManager.getRoleCanCommitNum(this.userid, this.roleid, this.activityCfgid);
/*     */     
/*     */ 
/*  71 */     int activityCanCommitPoint = WorldGoalManager.getActivityCanCommitPoint(this.activityCfgid);
/*     */     
/*  73 */     Map<Integer, Integer> itemid2Commitnum = new HashMap();
/*  74 */     int realCommitNum = WorldGoalManager.commitItemAtNPC(this.roleid, this.activityCfgid, roleCanCommitNum, itemid2Commitnum);
/*     */     
/*  76 */     if (realCommitNum <= 0)
/*     */     {
/*     */ 
/*  79 */       onCommitItemFail(4, null);
/*  80 */       return false;
/*     */     }
/*     */     
/*  83 */     if (!WorldGoalManager.sendCommitItemAward(this.userid, this.roleid, this.activityCfgid, itemid2Commitnum))
/*     */     {
/*     */ 
/*  86 */       onCommitItemFail(5, null);
/*  87 */       return false;
/*     */     }
/*     */     
/*  90 */     ActivityInterface.addActivityCount(this.userid, this.roleid, this.activityCfgid, realCommitNum);
/*     */     
/*  92 */     RoleWorldGoalInfo xRoleWorldGoalInfo = Role2worldgoalinfo.get(Long.valueOf(this.roleid));
/*  93 */     if (xRoleWorldGoalInfo == null)
/*     */     {
/*  95 */       xRoleWorldGoalInfo = Pod.newRoleWorldGoalInfo();
/*  96 */       Role2worldgoalinfo.insert(Long.valueOf(this.roleid), xRoleWorldGoalInfo);
/*     */     }
/*  98 */     WorldGoalActivityInfo xWorldGoalActivityInfo = (WorldGoalActivityInfo)xRoleWorldGoalInfo.getWorld_goal_activity_infos().get(Integer.valueOf(this.activityCfgid));
/*     */     
/* 100 */     if (xWorldGoalActivityInfo == null)
/*     */     {
/* 102 */       xWorldGoalActivityInfo = Pod.newWorldGoalActivityInfo();
/* 103 */       xRoleWorldGoalInfo.getWorld_goal_activity_infos().put(Integer.valueOf(this.activityCfgid), xWorldGoalActivityInfo);
/*     */     }
/* 105 */     xWorldGoalActivityInfo.setCommit_item_sum(xWorldGoalActivityInfo.getCommit_item_sum() + realCommitNum);
/*     */     
/* 107 */     int realCommitPoint = WorldGoalManager.getRealCommitPoint(itemid2Commitnum);
/* 108 */     if (realCommitPoint <= 0)
/*     */     {
/*     */ 
/* 111 */       return false;
/*     */     }
/* 113 */     int realCommitToActivityPoint = Math.min(realCommitPoint, activityCanCommitPoint);
/* 114 */     WorldGoalManager.updateActivityInfoAndSendMail(this.activityCfgid, realCommitToActivityPoint, now);
/* 115 */     WorldGoalManager.addCommitRole(this.activityCfgid, this.roleid);
/*     */     
/* 117 */     SCommitItemSuccess protocol = new SCommitItemSuccess();
/* 118 */     protocol.activity_cfg_id = this.activityCfgid;
/* 119 */     protocol.commit_num = realCommitNum;
/* 120 */     protocol.itemid2commit_num.putAll(itemid2Commitnum);
/* 121 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/* 123 */     WorldGoalManager.logger.info(String.format("[worldgoal]PCommitItemAtNPC.processImp@commit item at npc success|userid=%s|roleid=%d|activity_cfg_id=%d|npc_id=%d|real_commit_num=%d|sum_commit_num=%d|real_commit_to_activity_point=%d", new Object[] { this.userid, Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.NPCid), Integer.valueOf(realCommitNum), Integer.valueOf(ActivityInterface.getActivityCount(this.userid, this.roleid, this.activityCfgid, true)), Integer.valueOf(realCommitToActivityPoint) }));
/*     */     
/*     */ 
/*     */ 
/* 127 */     return true;
/*     */   }
/*     */   
/*     */   private void onCommitItemFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 132 */     StringBuilder sb = new StringBuilder();
/* 133 */     sb.append(String.format("[worldgoal]PCommitItemAtNPC.processImp@commit item at NPC fail|userid=%s|roleid=%d|activity_cfg_id=%d|npc_id=%d|res=%d", new Object[] { this.userid, Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.NPCid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 136 */     if (extraInfo != null)
/*     */     {
/* 138 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 140 */         sb.append("|").append((String)entry.getKey());
/* 141 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 144 */     WorldGoalManager.logger.info(sb.toString());
/*     */     
/* 146 */     SCommitItemFail protocol = new SCommitItemFail();
/* 147 */     protocol.activity_cfg_id = this.activityCfgid;
/* 148 */     protocol.res = res;
/* 149 */     OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\main\PCommitItemAtNPC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */