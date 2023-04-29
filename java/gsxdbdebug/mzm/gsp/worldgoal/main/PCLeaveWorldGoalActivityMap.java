/*    */ package mzm.gsp.worldgoal.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.map.main.MapInterface;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.worldgoal.SLeaveWorldGoalActivityMapFail;
/*    */ import mzm.gsp.worldgoal.confbean.SWorldGoalCfg;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Lockeys;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ public class PCLeaveWorldGoalActivityMap
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int activityCfgid;
/*    */   
/*    */   public PCLeaveWorldGoalActivityMap(long roleid, int activityCfgid)
/*    */   {
/* 24 */     this.roleid = roleid;
/* 25 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 31 */     if (!WorldGoalManager.checkRoleStatus(this.roleid))
/*    */     {
/*    */ 
/* 34 */       WorldGoalManager.logger.info(String.format("[worldgoal]PCLeaveWorldGoalActivityMap.processImp@role status error|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     if (!SWorldGoalCfg.getAll().containsKey(Integer.valueOf(this.activityCfgid)))
/*    */     {
/*    */ 
/* 42 */       return false;
/*    */     }
/* 44 */     SWorldGoalCfg cfg = SWorldGoalCfg.get(this.activityCfgid);
/*    */     
/* 46 */     String userid = RoleInterface.getUserId(this.roleid);
/*    */     
/* 48 */     lock(Lockeys.get(User.getTable(), userid));
/*    */     
/* 50 */     lock(Lockeys.get(Basic.getTable(), Long.valueOf(this.roleid)));
/*    */     
/*    */ 
/* 53 */     if (!WorldGoalCfgManager.isRoleInWorldGoalActivityMap(this.roleid, this.activityCfgid))
/*    */     {
/*    */ 
/* 56 */       onFail(1, null);
/* 57 */       return false;
/*    */     }
/*    */     
/* 60 */     if (cfg.transfer_map_cfg_id <= 0)
/*    */     {
/*    */ 
/* 63 */       onFail(2, null);
/* 64 */       return false;
/*    */     }
/* 66 */     MapInterface.forceTransferToScene(this.roleid, MapInterface.getBigWorldid(), cfg.transfer_map_cfg_id, cfg.transfer_x, cfg.transfer_y);
/*    */     
/* 68 */     StringBuilder sb = new StringBuilder();
/* 69 */     sb.append(String.format("[worldgoal]PCLeaveWorldGoalActivityMap.processImp@leave activity map success|roleid=%d|activity_cfg_id=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid) }));
/*    */     
/*    */ 
/* 72 */     WorldGoalManager.logger.info(sb.toString());
/* 73 */     return true;
/*    */   }
/*    */   
/*    */   private void onFail(int res, Map<String, Object> extraInfo)
/*    */   {
/* 78 */     StringBuilder sb = new StringBuilder();
/* 79 */     sb.append(String.format("[worldgoal]PCLeaveWorldGoalActivityMap.processImp@leave activity map fail|roleid=%d|activity_cfg_id=%d|enter_activity_map_npc_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(res) }));
/*    */     
/*    */ 
/* 82 */     if (extraInfo != null)
/*    */     {
/* 84 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*    */       {
/* 86 */         sb.append("|").append((String)entry.getKey());
/* 87 */         sb.append("=").append(entry.getValue().toString());
/*    */       }
/*    */     }
/* 90 */     WorldGoalManager.logger.info(sb.toString());
/*    */     
/* 92 */     SLeaveWorldGoalActivityMapFail protocol = new SLeaveWorldGoalActivityMapFail();
/* 93 */     protocol.activity_cfg_id = this.activityCfgid;
/* 94 */     protocol.res = res;
/* 95 */     OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\main\PCLeaveWorldGoalActivityMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */