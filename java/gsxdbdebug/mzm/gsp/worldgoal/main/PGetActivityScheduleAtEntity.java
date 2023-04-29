/*     */ package mzm.gsp.worldgoal.main;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.GameServerInfoManager;
/*     */ import mzm.gsp.activity.main.ActivityInterface;
/*     */ import mzm.gsp.activity.main.ActivityJoinResult;
/*     */ import mzm.gsp.npc.main.NpcInterface;
/*     */ import mzm.gsp.online.main.OnlineManager;
/*     */ import mzm.gsp.util.LogicProcedure;
/*     */ import mzm.gsp.worldgoal.SGetActivityScheduleFail;
/*     */ import mzm.gsp.worldgoal.SGetActivityScheduleSuccess;
/*     */ import mzm.gsp.worldgoal.confbean.SWorldGoalCfg;
/*     */ import org.apache.log4j.Logger;
/*     */ import xbean.Section;
/*     */ import xbean.WorldGoal;
/*     */ import xdb.Lockeys;
/*     */ import xtable.Basic;
/*     */ import xtable.User;
/*     */ import xtable.Worldgoals;
/*     */ 
/*     */ public class PGetActivityScheduleAtEntity extends LogicProcedure
/*     */ {
/*     */   private final String userid;
/*     */   private final long roleid;
/*     */   private final int activityCfgid;
/*     */   private final int NPCid;
/*     */   private final long entityInstanceid;
/*     */   
/*     */   public PGetActivityScheduleAtEntity(String userid, long roleid, int activityCfgid, int NPCid, long entityInstanceid)
/*     */   {
/*  33 */     this.userid = userid;
/*  34 */     this.roleid = roleid;
/*  35 */     this.activityCfgid = activityCfgid;
/*  36 */     this.NPCid = NPCid;
/*  37 */     this.entityInstanceid = entityInstanceid;
/*     */   }
/*     */   
/*     */   protected boolean processImp()
/*     */     throws Exception
/*     */   {
/*  43 */     if (!NpcInterface.checkNpcService(this.roleid, SWorldGoalCfg.get(this.activityCfgid).get_activity_schedule_service_id, this.NPCid, new WorldGoalNPCConditionChecker(this.roleid, this.entityInstanceid)))
/*     */     {
/*     */ 
/*     */ 
/*  47 */       onGetActivityScheduleFail(2, null);
/*  48 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  52 */     lock(Lockeys.get(User.getTable(), this.userid));
/*  53 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*     */     
/*  55 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(this.userid, this.roleid, this.activityCfgid);
/*     */     
/*  57 */     if ((!activityJoinResult.isCanJoin()) && (!activityJoinResult.isActivityJoinCountMax()))
/*     */     {
/*     */ 
/*  60 */       Map<String, Object> extraInfo = new HashMap();
/*  61 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/*  62 */       onGetActivityScheduleFail(1, extraInfo);
/*  63 */       return false;
/*     */     }
/*     */     
/*     */ 
/*  67 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/*  68 */     WorldGoal xWorldGoal = Worldgoals.get(Long.valueOf(globalActivityCfgid));
/*  69 */     SGetActivityScheduleSuccess protocol = new SGetActivityScheduleSuccess();
/*  70 */     protocol.activity_cfg_id = this.activityCfgid;
/*  71 */     protocol.current_section_id = xWorldGoal.getCurrent_section_id();
/*  72 */     protocol.current_section_point = ((Section)xWorldGoal.getSections().get(Integer.valueOf(xWorldGoal.getCurrent_section_id()))).getPoint();
/*  73 */     protocol.timestamp = ((int)(((Section)xWorldGoal.getSections().get(Integer.valueOf(xWorldGoal.getCurrent_section_id()))).getTimestamp() / 1000L));
/*  74 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*     */     
/*  76 */     WorldGoalManager.logger.info(String.format("[worldgoal]PGetActivityScheduleAtNPC.processImp@get activity schedule at entity success|userid=%s|roleid=%d|activity_cfg_id=%d|npc_id=%d|entity_instanceid=%d|current_sectionid=%d|current_section_point=%d|timestamp=%d", new Object[] { this.userid, Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.NPCid), Long.valueOf(this.entityInstanceid), Integer.valueOf(protocol.current_section_id), Integer.valueOf(protocol.current_section_point), Long.valueOf(((Section)xWorldGoal.getSections().get(Integer.valueOf(xWorldGoal.getCurrent_section_id()))).getTimestamp()) }));
/*     */     
/*     */ 
/*     */ 
/*  80 */     return true;
/*     */   }
/*     */   
/*     */   private void onGetActivityScheduleFail(int res, Map<String, Object> extraInfo)
/*     */   {
/*  85 */     StringBuilder sb = new StringBuilder();
/*  86 */     sb.append(String.format("[worldgoal]PGetActivityScheduleAtEntity.processImp@get activity schedule at entity fail|userid=%s|roleid=%d|activity_cfg_id=%d|npc_id=%d|entity_instanceid=%d|res=%d", new Object[] { this.userid, Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.NPCid), Long.valueOf(this.entityInstanceid), Integer.valueOf(res) }));
/*     */     
/*     */ 
/*  89 */     if (extraInfo != null)
/*     */     {
/*  91 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*     */       {
/*  93 */         sb.append("|").append((String)entry.getKey());
/*  94 */         sb.append("=").append(entry.getValue().toString());
/*     */       }
/*     */     }
/*  97 */     WorldGoalManager.logger.info(sb.toString());
/*     */     
/*  99 */     SGetActivityScheduleFail protocol = new SGetActivityScheduleFail();
/* 100 */     protocol.activity_cfg_id = this.activityCfgid;
/* 101 */     protocol.res = res;
/* 102 */     OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\main\PGetActivityScheduleAtEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */