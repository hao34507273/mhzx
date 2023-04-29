/*    */ package mzm.gsp.bigboss.main;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.bigboss.confbean.SBigbossRemoteChartTypeCfg;
/*    */ import mzm.gsp.bigboss.event.RoleGetBigBossRemoteChartAwardArg;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.RoleBigBossRemoteChartAwardInfo;
/*    */ import xbean.RoleBigBossRemoteChartInfo;
/*    */ 
/*    */ public class POnRoleGetBigBossRemoteChartAward extends mzm.gsp.bigboss.event.RoleGetBigBossRemoteChartAwardProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     SBigbossRemoteChartTypeCfg cfg = SBigbossRemoteChartTypeCfg.get(((RoleGetBigBossRemoteChartAwardArg)this.arg).getOccupation());
/* 19 */     if (cfg == null)
/*    */     {
/*    */ 
/* 22 */       onFail(-3, null);
/* 23 */       return false;
/*    */     }
/* 25 */     String userid = mzm.gsp.role.main.RoleInterface.getUserId(((RoleGetBigBossRemoteChartAwardArg)this.arg).getRoleid());
/*    */     
/* 27 */     lock(xtable.User.getTable(), Arrays.asList(new String[] { userid }));
/*    */     
/* 29 */     lock(xtable.Basic.getTable(), Arrays.asList(new Long[] { Long.valueOf(((RoleGetBigBossRemoteChartAwardArg)this.arg).getRoleid()) }));
/* 30 */     RoleBigBossRemoteChartInfo xRoleBigBossRemoteChartInfo = xtable.Role_big_boss_remote_chart_infos.get(Long.valueOf(((RoleGetBigBossRemoteChartAwardArg)this.arg).getRoleid()));
/* 31 */     if (xRoleBigBossRemoteChartInfo == null)
/*    */     {
/* 33 */       xRoleBigBossRemoteChartInfo = xbean.Pod.newRoleBigBossRemoteChartInfo();
/* 34 */       xtable.Role_big_boss_remote_chart_infos.insert(Long.valueOf(((RoleGetBigBossRemoteChartAwardArg)this.arg).getRoleid()), xRoleBigBossRemoteChartInfo);
/*    */     }
/* 36 */     if (xRoleBigBossRemoteChartInfo.getAward_infos().containsKey(Integer.valueOf(((RoleGetBigBossRemoteChartAwardArg)this.arg).getStartTimestamp())))
/*    */     {
/*    */ 
/* 39 */       onFail(-7, null);
/* 40 */       return false;
/*    */     }
/* 42 */     RoleBigBossRemoteChartAwardInfo xRoleBigBossRemoteChartAwardInfo = xbean.Pod.newRoleBigBossRemoteChartAwardInfo();
/* 43 */     xRoleBigBossRemoteChartAwardInfo.setOccupation(((RoleGetBigBossRemoteChartAwardArg)this.arg).getOccupation());
/* 44 */     xRoleBigBossRemoteChartAwardInfo.setRank(((RoleGetBigBossRemoteChartAwardArg)this.arg).getRank());
/* 45 */     xRoleBigBossRemoteChartInfo.getAward_infos().put(Integer.valueOf(((RoleGetBigBossRemoteChartAwardArg)this.arg).getStartTimestamp()), xRoleBigBossRemoteChartAwardInfo);
/* 46 */     boolean awarded = false;
/* 47 */     if ((BigbossManager.isBigBossSwitchOpenForRole(((RoleGetBigBossRemoteChartAwardArg)this.arg).getRoleid())) && (BigbossManager.isBigBossRemoteChartSwitchOpenForRole(((RoleGetBigBossRemoteChartAwardArg)this.arg).getRoleid())))
/*    */     {
/*    */ 
/* 50 */       mzm.gsp.chart.main.RankInterface.sendChartAward(userid, ((RoleGetBigBossRemoteChartAwardArg)this.arg).getRoleid(), cfg.remote_chart_type, ((RoleGetBigBossRemoteChartAwardArg)this.arg).getRank());
/* 51 */       awarded = true;
/*    */     }
/* 53 */     GameServer.logger().info(String.format("[bigboss]POnRoleGetBigBossRemoteChartAward.processImp@role get big boss remote chart award process success|roleid=%d|occupation=%d|start_timestamp=%s|rank=%d|awarded=%b", new Object[] { Long.valueOf(((RoleGetBigBossRemoteChartAwardArg)this.arg).getRoleid()), Integer.valueOf(((RoleGetBigBossRemoteChartAwardArg)this.arg).getOccupation()), DateTimeUtils.formatTimestamp(((RoleGetBigBossRemoteChartAwardArg)this.arg).getStartTimestamp() * 1000L), Integer.valueOf(((RoleGetBigBossRemoteChartAwardArg)this.arg).getRank()), Boolean.valueOf(awarded) }));
/*    */     
/*    */ 
/*    */ 
/*    */ 
/* 58 */     BigbossManager.addRemoteRankAwardTLog(((RoleGetBigBossRemoteChartAwardArg)this.arg).getRoleid(), DateTimeUtils.formatTimestamp(((RoleGetBigBossRemoteChartAwardArg)this.arg).getStartTimestamp() * 1000L), ((RoleGetBigBossRemoteChartAwardArg)this.arg).getOccupation(), ((RoleGetBigBossRemoteChartAwardArg)this.arg).getRank(), awarded);
/*    */     
/*    */ 
/* 61 */     return true;
/*    */   }
/*    */   
/*    */   private void onFail(int res, Map<String, Object> extraInfo)
/*    */   {
/* 66 */     StringBuilder sb = new StringBuilder();
/* 67 */     sb.append(String.format("[bigboss]POnRoleGetBigBossRemoteChartAward.processImp@role get big boss remote chart award process fail|roleid=%d|occupation=%d|start_timestamp=%s|rank=%d|res=%d", new Object[] { Long.valueOf(((RoleGetBigBossRemoteChartAwardArg)this.arg).getRoleid()), Integer.valueOf(((RoleGetBigBossRemoteChartAwardArg)this.arg).getOccupation()), DateTimeUtils.formatTimestamp(((RoleGetBigBossRemoteChartAwardArg)this.arg).getStartTimestamp() * 1000L), Integer.valueOf(((RoleGetBigBossRemoteChartAwardArg)this.arg).getRank()), Integer.valueOf(res) }));
/*    */     
/*    */ 
/*    */ 
/* 71 */     if (extraInfo != null)
/*    */     {
/* 73 */       for (Map.Entry<String, Object> entry : extraInfo.entrySet())
/*    */       {
/* 75 */         sb.append("|").append((String)entry.getKey());
/* 76 */         sb.append("=").append(entry.getValue().toString());
/*    */       }
/*    */     }
/* 79 */     GameServer.logger().info(sb.toString());
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\main\POnRoleGetBigBossRemoteChartAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */