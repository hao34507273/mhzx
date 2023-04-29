/*    */ package mzm.gsp.bigboss.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.bigboss.RemoveRoleBigBossRemoteRankInfoContext;
/*    */ import mzm.gsp.bigboss.confbean.SBigbossCfgConsts;
/*    */ import mzm.gsp.crossserver.event.RemoveRoleBigBossRankInfoDoneArg;
/*    */ import mzm.gsp.crossserver.event.RemoveRoleBigBossRankInfoDoneProcedure;
/*    */ import mzm.gsp.util.CommonUtils;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.BigBoss;
/*    */ 
/*    */ public class POnRemoveRoleBigBossRankInfoDone extends RemoveRoleBigBossRankInfoDoneProcedure
/*    */ {
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 18 */     int occupation = CommonUtils.getLongHigh(((RemoveRoleBigBossRankInfoDoneArg)this.arg).getRankid());
/* 19 */     long startTimestamp = CommonUtils.getLongLow(((RemoveRoleBigBossRankInfoDoneArg)this.arg).getRankid()) * 1000L;
/* 20 */     RemoveRoleBigBossRemoteRankInfoContext context = new RemoveRoleBigBossRemoteRankInfoContext();
/* 21 */     context.unmarshal(com.goldhuman.Common.Marshal.OctetsStream.wrap(((RemoveRoleBigBossRankInfoDoneArg)this.arg).getContext()));
/* 22 */     if (((RemoveRoleBigBossRankInfoDoneArg)this.arg).isSucceed())
/*    */     {
/* 24 */       GameServer.logger().info(String.format("[bigboss]POnRemoveRoleBigBossRankInfoDone.processImp@remove role big boss remote rank info success|count=%d|occupation=%d|start_timestamp=%s|roleid=%d", new Object[] { Byte.valueOf(context.count), Integer.valueOf(occupation), DateTimeUtils.formatTimestamp(startTimestamp), Long.valueOf(((RemoveRoleBigBossRankInfoDoneArg)this.arg).getRoleid()) }));
/*    */       
/*    */ 
/*    */ 
/* 28 */       return true;
/*    */     }
/*    */     
/* 31 */     if (!((RemoveRoleBigBossRankInfoDoneArg)this.arg).isTimeout())
/*    */     {
/* 33 */       GameServer.logger().error(String.format("[bigboss]POnRemoveRoleBigBossRankInfoDone.processImp@remove role big boss remote rank info fail|count=%d|occupation=%d|start_timestamp=%s|roleid=%d", new Object[] { Byte.valueOf(context.count), Integer.valueOf(occupation), DateTimeUtils.formatTimestamp(startTimestamp), Long.valueOf(((RemoveRoleBigBossRankInfoDoneArg)this.arg).getRoleid()) }));
/*    */       
/*    */ 
/*    */ 
/* 37 */       return false;
/*    */     }
/* 39 */     GameServer.logger().error(String.format("[bigboss]POnRemoveRoleBigBossRankInfoDone.processImp@remove role big boss remote info timeout|count=%d|occupation=%d|start_timestamp=%s|roleid=%d", new Object[] { Byte.valueOf(context.count), Integer.valueOf(occupation), DateTimeUtils.formatTimestamp(startTimestamp), Long.valueOf(((RemoveRoleBigBossRankInfoDoneArg)this.arg).getRoleid()) }));
/*    */     
/*    */ 
/*    */ 
/* 43 */     if (context.count < BigbossManager.GRC_MAX_TRY_TIMES)
/*    */     {
/* 45 */       if (!mzm.gsp.activity.main.ActivityInterface.isActivityOpen(SBigbossCfgConsts.getInstance().ACTIVITYID))
/*    */       {
/* 47 */         return false;
/*    */       }
/* 49 */       if (startTimestamp != BigbossManager.getActivityStarttime())
/*    */       {
/* 51 */         return false;
/*    */       }
/*    */       
/* 54 */       BigBoss xBigBoss = xtable.Role2bigboss.get(Long.valueOf(((RemoveRoleBigBossRankInfoDoneArg)this.arg).getRoleid()));
/* 55 */       if ((xBigBoss != null) && (xBigBoss.getOcp2damagepoint().containsKey(Integer.valueOf(occupation))))
/*    */       {
/* 57 */         return false;
/*    */       }
/* 59 */       BigbossManager.removeRoleBigBossRankInfo(((RemoveRoleBigBossRankInfoDoneArg)this.arg).getRankid(), ((RemoveRoleBigBossRankInfoDoneArg)this.arg).getRoleid(), context.count + 1);
/*    */     }
/* 61 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\bigboss\main\POnRemoveRoleBigBossRankInfoDone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */