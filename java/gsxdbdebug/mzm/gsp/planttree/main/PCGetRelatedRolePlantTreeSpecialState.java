/*    */ package mzm.gsp.planttree.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.activity.main.ActivityInterface;
/*    */ import mzm.gsp.activity.main.ActivityJoinResult;
/*    */ import mzm.gsp.online.main.OnlineManager;
/*    */ import mzm.gsp.planttree.SGetRelatedRolePlantTreeSpecialStateFail;
/*    */ import mzm.gsp.planttree.confbean.SPlantTreeCfg;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.status.main.RoleStatusInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xtable.Basic;
/*    */ import xtable.User;
/*    */ 
/*    */ 
/*    */ public class PCGetRelatedRolePlantTreeSpecialState
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int activityCfgid;
/*    */   
/*    */   public PCGetRelatedRolePlantTreeSpecialState(long roleid, int activityCfgid)
/*    */   {
/* 28 */     this.roleid = roleid;
/* 29 */     this.activityCfgid = activityCfgid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 35 */     if (!PlantTreeManager.isPlantTreeSwitchOpenForRole(this.roleid, this.activityCfgid))
/*    */     {
/*    */ 
/* 38 */       onFail(-1, null);
/* 39 */       return false;
/*    */     }
/* 41 */     if (!RoleStatusInterface.checkCanSetStatus(this.roleid, 918, true))
/*    */     {
/*    */ 
/*    */ 
/* 45 */       onFail(-2, null);
/* 46 */       return false;
/*    */     }
/* 48 */     SPlantTreeCfg cfg = SPlantTreeCfg.get(this.activityCfgid);
/* 49 */     if (cfg == null)
/*    */     {
/*    */ 
/* 52 */       onFail(-3, null);
/* 53 */       return false;
/*    */     }
/*    */     
/* 56 */     String userid = RoleInterface.getUserId(this.roleid);
/*    */     
/* 58 */     lock(User.getTable(), Arrays.asList(new String[] { userid }));
/*    */     
/* 60 */     lock(Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(this.roleid) }));
/*    */     
/* 62 */     ActivityJoinResult activityJoinResult = ActivityInterface.canJoinAndCheckInitActivityData(userid, this.roleid, this.activityCfgid);
/*    */     
/* 64 */     if (!activityJoinResult.isCanJoin())
/*    */     {
/*    */ 
/* 67 */       Map<String, Object> extraInfo = new HashMap();
/* 68 */       extraInfo.put("reason", Integer.valueOf(activityJoinResult.getReasonValue()));
/* 69 */       onFail(1, extraInfo);
/* 70 */       return false;
/*    */     }
/* 72 */     PlantTreeOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(this.activityCfgid), new PNotifyRelatedRolePlantTreeSpecialState(this.roleid, this.activityCfgid));
/*    */     
/* 74 */     return true;
/*    */   }
/*    */   
/*    */   private void onFail(int res, Map<String, Object> extraInfo)
/*    */   {
/* 79 */     StringBuilder sb = new StringBuilder();
/* 80 */     sb.append(String.format("[planttree]PCGetRelatedRolePlantTreeSpecialState.processImp@get related role special state fail|roleid=%d|activity_cfg_id=%d|res=%d", new Object[] { Long.valueOf(this.roleid), Integer.valueOf(this.activityCfgid), Integer.valueOf(res) }));
/*    */     
/*    */ 
/* 83 */     if (extraInfo != null)
/*    */     {
/* 85 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*    */       {
/* 87 */         sb.append("|").append((String)entry.getKey());
/* 88 */         sb.append("=").append(entry.getValue().toString());
/*    */       }
/*    */     }
/* 91 */     PlantTreeManager.logger.info(sb.toString());
/* 92 */     if (res > 0)
/*    */     {
/* 94 */       SGetRelatedRolePlantTreeSpecialStateFail protocol = new SGetRelatedRolePlantTreeSpecialStateFail();
/* 95 */       protocol.res = res;
/* 96 */       OnlineManager.getInstance().sendAtOnce(this.roleid, protocol);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\main\PCGetRelatedRolePlantTreeSpecialState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */