/*    */ package mzm.gsp.worldgoal.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import mzm.gsp.worldgoal.confbean.SWorldGoalCfg;
/*    */ import org.apache.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGetActivityScheduleReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int position;
/*    */   private final int activityCfgid;
/*    */   private final int NPCid;
/*    */   private final long entityInstanceid;
/*    */   
/*    */   public PGetActivityScheduleReq(long roleid, int position, int activityCfgid, int NPCid, long entityInstanceid)
/*    */   {
/* 22 */     this.roleid = roleid;
/* 23 */     this.position = position;
/* 24 */     this.activityCfgid = activityCfgid;
/* 25 */     this.NPCid = NPCid;
/* 26 */     this.entityInstanceid = entityInstanceid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 32 */     if (!WorldGoalManager.isWorldGoalSwitchOpenForRole(this.roleid, this.activityCfgid))
/*    */     {
/*    */ 
/* 35 */       WorldGoalManager.logger.info(String.format("[worldgoal]PGetActivityScheduleReq.processImp@module close or role forbidden|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/* 37 */       return false;
/*    */     }
/* 39 */     if (!WorldGoalManager.checkRoleStatus(this.roleid))
/*    */     {
/*    */ 
/* 42 */       WorldGoalManager.logger.info(String.format("[worldgoal]PGetActivityScheduleReq.processImp@role status error|roleid=%d", new Object[] { Long.valueOf(this.roleid) }));
/*    */       
/* 44 */       return false;
/*    */     }
/* 46 */     SWorldGoalCfg cfg = SWorldGoalCfg.get(this.activityCfgid);
/* 47 */     if (!SWorldGoalCfg.getAll().containsKey(Integer.valueOf(this.activityCfgid)))
/*    */     {
/*    */ 
/* 50 */       return false;
/*    */     }
/* 52 */     if (this.position == 1)
/*    */     {
/* 54 */       if (cfg.npc_id != this.NPCid)
/*    */       {
/*    */ 
/* 57 */         return false;
/*    */       }
/* 59 */       WorldGoalOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityCfgid), new PGetActivityScheduleAtNPC(RoleInterface.getUserId(this.roleid), this.roleid, this.activityCfgid, this.NPCid));
/*    */       
/*    */ 
/*    */ 
/* 63 */       return true;
/*    */     }
/* 65 */     if (this.position == 2)
/*    */     {
/* 67 */       if ((WorldGoalMapEntityInstanceManager.getActivityCfgidByInstanceid(this.entityInstanceid) != this.activityCfgid) || (cfg.entity_npc_id != this.NPCid))
/*    */       {
/*    */ 
/*    */ 
/* 71 */         return false;
/*    */       }
/* 73 */       WorldGoalOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityCfgid), new PGetActivityScheduleAtEntity(RoleInterface.getUserId(this.roleid), this.roleid, this.activityCfgid, this.NPCid, this.entityInstanceid));
/*    */       
/*    */ 
/*    */ 
/* 77 */       return true;
/*    */     }
/* 79 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\worldgoal\main\PGetActivityScheduleReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */