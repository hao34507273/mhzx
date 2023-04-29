/*     */ package mzm.gsp.worldgoal.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.DateTimeUtils;
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
/*     */ public class PCommitItemAtEntity extends mzm.gsp.util.LogicProcedure
/*     */ {
/*     */   private final String userid;
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int sectionid;
/*     */   private final int NPCid;
/*     */   private final long entityInstanceid;
/*     */   
/*     */   public PCommitItemAtEntity(String userid, long roleid, int activityCfgid, int sectionid, int NPCid, long entityInstanceid)
/*     */   {
/*  34 */     this.userid = userid;
/*  35 */     this.roleid = roleid;
/*  36 */     this.activityCfgid = activityCfgid;
/*  37 */     this.sectionid = sectionid;
/*  38 */     this.NPCid = NPCid;
/*  39 */     this.entityInstanceid = entityInstanceid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  45 */     if (!NpcInterface.checkNpcService(this.roleid, SWorldGoalCfg.get(this.activityCfgid).commit_service_id, this.NPCid, new WorldGoalNPCConditionChecker(this.roleid, this.entityInstanceid)))
/*     */     {
/*     */ 
/*     */ 
/*  49 */       onCommitItemFail(6, null);
/*  50 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  54 */     lock(Lockeys.get(User.getTable(), this.userid));
/*  55 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*     */     
/*  57 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(this.userid, this.roleid, this.activityCfgid);
/*     */     
/*  59 */     if (!activityJoinResult.isCanJoin())
/*     */     {
/*  61 */       if (activityJoinResult.isActivityJoinCountMax())
/*     */       {
/*     */ 
/*  64 */         onCommitItemFail(2, null);
/*  65 */         return false;
/*     */       }
/*     */       
/*  68 */       Map<String, Object> extraInfo = new HashMap();
/*  69 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  70 */       onCommitItemFail(1, extraInfo);
/*  71 */       return false;
/*     */     }
/*     */     
/*  74 */     long now = DateTimeUtils.getCurrTimeInMillis();
/*  75 */     int roleCanCommitNum = WorldGoalManager.getRoleCanCommitNum(this.userid, this.roleid, this.activityCfgid);
/*     */     
/*     */ 
/*  78 */     int activityCanCommitPoint = WorldGoalManager.getActivityCanCommitPoint(this.activityCfgid);
/*  79 */     int sectionCanCommitPoint = WorldGoalManager.getSectionCanCommitPoint(this.activityCfgid, this.sectionid);
/*  80 */     if (sectionCanCommitPoint <= 0)
/*     */     {
/*     */ 
/*  83 */       if (sectionCanCommitPoint == -1)
/*     */       {
/*  85 */         onCommitItemFail(8, null);
/*     */       }
/*     */       else
/*     */       {
/*  89 */         onCommitItemFail(7, null);
/*     */       }
/*  91 */       return false;
/*     */     }
/*     */     
/*  94 */     Map<Integer, Integer> itemid2Commitnum = new HashMap();
/*  95 */     int realCommitNum = WorldGoalManager.commitItemAtEntity(this.roleid, this.activityCfgid, roleCanCommitNum, itemid2Commitnum, sectionCanCommitPoint);
/*     */     
/*  97 */     if (realCommitNum <= 0)
/*     */     {
/*     */ 
/* 100 */       onCommitItemFail(4, null);
/* 101 */       return false;
/*     */     }
/*     */     
/* 104 */     if (!WorldGoalManager.sendCommitItemAward(this.userid, this.roleid, this.activityCfgid, itemid2Commitnum))
/*     */     {
/*     */ 
/* 107 */       onCommitItemFail(5, null);
/* 108 */       return false;
/*     */     }
/*     */     
/* 111 */     ActivityInterface.addActivityCount(this.userid, this.roleid, this.activityCfgid, realCommitNum);
/*     */     
/* 113 */     RoleWorldGoalInfo xRoleWorldGoalInfo = Role2worldgoalinfo.get(Long.valueOf(this.roleid));
/* 114 */     if (xRoleWorldGoalInfo == null)
/*     */     {
/* 116 */       xRoleWorldGoalInfo = Pod.newRoleWorldGoalInfo();
/* 117 */       Role2worldgoalinfo.insert(Long.valueOf(this.roleid), xRoleWorldGoalInfo);
/*     */     }
/* 119 */     WorldGoalActivityInfo xWorldGoalActivityInfo = (WorldGoalActivityInfo)xRoleWorldGoalInfo.getWorld_goal_activity_infos().get(Integer.valueOf(this.activityCfgid));
/*     */     
/* 121 */     if (xWorldGoalActivityInfo == null)
/*     */     {
/* 123 */       xWorldGoalActivityInfo = Pod.newWorldGoalActivityInfo();
/* 124 */       xRoleWorldGoalInfo.getWorld_goal_activity_infos().put(Integer.valueOf(this.activityCfgid), xWorldGoalActivityInfo);
/*     */     }
/* 126 */     xWorldGoalActivityInfo.setCommit_item_sum(xWorldGoalActivityInfo.getCommit_item_sum() + realCommitNum);
/*     */     
/* 128 */     int realCommitPoint = WorldGoalManager.getRealCommitPoint(itemid2Commitnum);
/* 129 */     if (realCommitPoint <= 0)
/*     */     {
/*     */ 
/* 132 */       return false;
/*     */     }
/* 134 */     int realCommitToActivityPoint = Math.min(realCommitPoint, activityCanCommitPoint);
/* 135 */     WorldGoalManager.updateActivityInfoAndSendMail(this.activityCfgid, realCommitToActivityPoint, now);
/* 136 */     WorldGoalManager.addCommitRole(this.activityCfgid, this.roleid);
/*     */     
/* 138 */     SCommitItemSuccess protocol = new SCommitItemSuccess();
/* 139 */     protocol.activity_cfg_id = this.activityCfgid;
/* 140 */     protocol.commit_num = realCommitNum;
/* 141 */     protocol.itemid2commit_num.putAll(itemid2Commitnum);
/* 142 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/* 144 */     WorldGoalManager.logger.info(String.format("[worldgoal]PCommitItemAtEntity.processImp@commit item at entity success|userid=%s|roleid=%d|activity_cfg_id=%d|sectionid=%d|npc_id=%d|entity_instanceid=%d|real_commit_num=%d|sum_commit_num=%d|real_commit_to_activity_point=%d", new Object[] { this.userid, Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.sectionid), Integer.valueOf(this.NPCid), Long.valueOf(this.entityInstanceid), Integer.valueOf(realCommitNum), Integer.valueOf(ActivityInterface.getActivityCount(this.userid, this.roleid, this.activityCfgid, true)), Integer.valueOf(realCommitToActivityPoint) }));
/*     */     
/*     */ 
/*     */ 
/* 148 */     return true;
/*     */   }
/*     */   
/*     */   private void onCommitItemFail(int res, Map<String, Object> extraInfo)
/*     */   {
/* 153 */     StringBuilder sb = new StringBuilder();
/* 154 */     sb.append(String.format("[worldgoal]PCommitItemAtEntity.processImp@commit item at entity fail|userid=%s|roleid=%d|activity_cfg_id=%d|sectionid=%d|npc_id=%d|entity_instanceid=%d|res=%d", new Object[] { this.userid, Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.sectionid), Integer.valueOf(this.NPCid), Long.valueOf(this.entityInstanceid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/* 157 */     if (extraInfo != null)
/*     */     {
/* 159 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/* 161 */         sb.append("|").append((String)entry.getKey());
/* 162 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/* 165 */     WorldGoalManager.logger.info(sb.toString());
/*     */     
/* 167 */     SCommitItemFail protocol = new SCommitItemFail();
/* 168 */     protocol.activity_cfg_id = this.activityCfgid;
/* 169 */     protocol.res = res;
/* 170 */     OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\main\PCommitItemAtEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */