/*    */ package mzm.gsp.worldgoal.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.npc.main.NpcInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.worldgoal.SGetActivityScheduleFail;
/*    */ import mzm.gsp.worldgoal.SGetActivityScheduleSuccess;
/*    */ import mzm.gsp.worldgoal.confbean.SWorldGoalCfg;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.Section;
/*    */ import xbean.WorldGoal;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ import xtable.Worldgoals;
/*    */ 
/*    */ public class PGetActivityScheduleAtNPC extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final String userid;
/*    */   private final long roleid;
/*    */   private final int activityCfgid;
/*    */   private final int NPCid;
/*    */   
/*    */   public PGetActivityScheduleAtNPC(String userid, long roleid, int activityCfgid, int NPCid)
/*    */   {
/* 31 */     this.userid = userid;
/* 32 */     this.roleid = roleid;
/* 33 */     this.activityCfgid = activityCfgid;
/* 34 */     this.NPCid = NPCid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 40 */     if (!NpcInterface.checkNpcService(this.NPCid, SWorldGoalCfg.get(this.activityCfgid).get_activity_schedule_service_id, this.roleid))
/*    */     {
/*    */ 
/*    */ 
/* 44 */       onGetActivityScheduleFail(2, null);
/* 45 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 49 */     lock(Lockeys.get(User.getTable(), this.userid));
/* 50 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*    */     
/* 52 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(this.userid, this.roleid, this.activityCfgid);
/*    */     
/* 54 */     if ((!activityJoinResult.isCanJoin()) && (!activityJoinResult.isActivityJoinCountMax()))
/*    */     {
/*    */ 
/* 57 */       Map<String, Object> extraInfo = new HashMap();
/* 58 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/* 59 */       onGetActivityScheduleFail(1, extraInfo);
/* 60 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 64 */     long globalActivityCfgid = GameServerInfoManager.toGlobalId(this.activityCfgid);
/* 65 */     WorldGoal xWorldGoal = Worldgoals.get(Long.valueOf(globalActivityCfgid));
/* 66 */     SGetActivityScheduleSuccess protocol = new SGetActivityScheduleSuccess();
/* 67 */     protocol.activity_cfg_id = this.activityCfgid;
/* 68 */     protocol.current_section_id = xWorldGoal.getCurrent_section_id();
/* 69 */     protocol.current_section_point = ((Section)xWorldGoal.getSections().get(Integer.valueOf(xWorldGoal.getCurrent_section_id()))).getPoint();
/* 70 */     protocol.timestamp = ((int)(((Section)xWorldGoal.getSections().get(Integer.valueOf(xWorldGoal.getCurrent_section_id()))).getTimestamp() / 1000L));
/* 71 */     OnlineManager.getInstance().send(this.roleid, protocol);
/*    */     
/* 73 */     WorldGoalManager.logger.info(String.format("[worldgoal]PGetActivityScheduleAtNPC.processImp@get activity schedule at npc success|userid=%s|roleid=%d|activity_cfg_id=%d|npc_id=%d|current_sectionid=%d|current_section_point=%d|timestamp=%d", new Object[] { this.userid, Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.NPCid), Integer.valueOf(protocol.current_section_id), Integer.valueOf(protocol.current_section_point), Long.valueOf(((Section)xWorldGoal.getSections().get(Integer.valueOf(xWorldGoal.getCurrent_section_id()))).getTimestamp()) }));
/*    */     
/*    */ 
/*    */ 
/* 77 */     return true;
/*    */   }
/*    */   
/*    */   private void onGetActivityScheduleFail(int res, Map<String, Object> extraInfo)
/*    */   {
/* 82 */     StringBuilder sb = new StringBuilder();
/* 83 */     sb.append(String.format("[worldgoal]PGetActivityScheduleAtNPC.processImp@get activity schedule at NPC fail|userid=%s|roleid=%d|activity_cfg_id=%d|npc_id=%d|res=%d", new Object[] { this.userid, Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(this.NPCid), Integer.valueOf(res) }));
/*    */     
/*    */ 
/* 86 */     if (extraInfo != null)
/*    */     {
/* 88 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*    */       {
/* 90 */         sb.append("|").append((String)entry.getKey());
/* 91 */         sb.append("=").append(entry.getValue().toString());
/*    */       }
/*    */     }
/* 94 */     WorldGoalManager.logger.info(sb.toString());
/*    */     
/* 96 */     SGetActivityScheduleFail protocol = new SGetActivityScheduleFail();
/* 97 */     protocol.activity_cfg_id = this.activityCfgid;
/* 98 */     protocol.res = res;
/* 99 */     OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\main\PGetActivityScheduleAtNPC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */