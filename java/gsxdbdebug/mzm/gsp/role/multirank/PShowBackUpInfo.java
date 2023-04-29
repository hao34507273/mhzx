/*    */ package mzm.gsp.role.multirank;
/*    */ 
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import xbean.NoneRealRoleFightValueBean;
/*    */ import xbean.NoneRealRoleMultiFightValueBean;
/*    */ 
/*    */ public class PShowBackUpInfo extends mzm.gsp.util.LogicRunnable
/*    */ {
/*    */   private final long roleId;
/*    */   
/*    */   public PShowBackUpInfo(long roleId)
/*    */   {
/* 15 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   public void process()
/*    */     throws Exception
/*    */   {
/* 21 */     xbean.NoneRealTimeFightValueRankBackUp xNRTRoleFVBackUp = xtable.Nonerealtimefightvaluerankbackup.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 22 */     if (xNRTRoleFVBackUp != null)
/*    */     {
/* 24 */       StringBuffer sb = new StringBuffer();
/* 25 */       sb.append("战斗力:");
/* 26 */       for (NoneRealRoleFightValueBean xEach : xNRTRoleFVBackUp.getRankdatas())
/*    */       {
/* 28 */         sb.append("@").append(getName(xEach.getRoleid())).append("|").append(xEach.getFightvalue());
/*    */       }
/* 30 */       GameServer.logger().info(sb.toString());
/* 31 */       GmManager.getInstance().sendResultToGM(this.roleId, sb.toString());
/*    */     }
/*    */     
/* 34 */     xbean.NoneRealTimeMultiFightValueRankBackUp xNRTRoleMFVBackUp = xtable.Nonerealtimemultifightvaluerankbackup.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 35 */     if (xNRTRoleMFVBackUp != null)
/*    */     {
/* 37 */       StringBuffer sb = new StringBuffer();
/* 38 */       sb.append("综合战斗力:");
/* 39 */       for (NoneRealRoleMultiFightValueBean xEach : xNRTRoleMFVBackUp.getRankdatas())
/*    */       {
/* 41 */         sb.append("@").append(getName(xEach.getRoleid())).append("|").append(xEach.getMultifightvalue());
/*    */       }
/* 43 */       GameServer.logger().info(sb.toString());
/* 44 */       GmManager.getInstance().sendResultToGM(this.roleId, sb.toString());
/*    */     }
/*    */     
/* 47 */     xbean.NoneRealTimeRoleLevelRankBackUp xNRTRoleLevelRankBackUp = xtable.Nonerealtimerolelevelrankbackup.select(Long.valueOf(GameServerInfoManager.getLocalId()));
/* 48 */     if (xNRTRoleLevelRankBackUp != null)
/*    */     {
/* 50 */       StringBuffer sb = new StringBuffer();
/* 51 */       sb.append("等级:");
/* 52 */       for (xbean.NoneRealRoleLevelBean xEach : xNRTRoleLevelRankBackUp.getRankdatas())
/*    */       {
/* 54 */         sb.append("@").append(getName(xEach.getRoleid())).append("|").append(xEach.getLevel());
/*    */       }
/* 56 */       GameServer.logger().info(sb.toString());
/* 57 */       GmManager.getInstance().sendResultToGM(this.roleId, sb.toString());
/*    */     }
/*    */   }
/*    */   
/*    */   private String getName(long roleId)
/*    */   {
/* 63 */     return mzm.gsp.role.main.RoleInterface.getName(roleId);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\multirank\PShowBackUpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */