/*    */ package mzm.gsp.petarena.main;
/*    */ 
/*    */ import java.util.Map;
/*    */ import java.util.Map.Entry;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.common.confbean.STimeCommonCfg;
/*    */ import mzm.gsp.petarena.confbean.SPetArenaConst;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.NoneRealTimeTaskManager;
/*    */ import org.apache.log4j.Logger;
/*    */ import xbean.PetArenaRankBackup;
/*    */ import xtable.Petarenarankbackup;
/*    */ 
/*    */ public class PCheckRankAndBackUp extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final Map<Long, Integer> roles;
/*    */   private final long time;
/*    */   
/*    */   public PCheckRankAndBackUp(Map<Long, Integer> roles, long time)
/*    */   {
/* 22 */     this.roles = roles;
/* 23 */     this.time = time;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 29 */     long key = GameServerInfoManager.getLocalId();
/* 30 */     PetArenaRankBackup xPetArenaRankBackup = Petarenarankbackup.get(Long.valueOf(key));
/* 31 */     if (xPetArenaRankBackup == null)
/*    */     {
/* 33 */       GameServer.logger().error(String.format("[petarena]PCheckRankAndBackUp.processImp@xbean is null|time=%d", new Object[] { Long.valueOf(this.time) }));
/*    */       
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     STimeCommonCfg timeCommonCfg = mzm.gsp.common.TimeCommonUtil.getCommonCfg(SPetArenaConst.getInstance().AWARD_TIME_CFG_ID);
/* 39 */     long resetTime = DateTimeUtils.getDailyResetTime(this.time, timeCommonCfg.activeHour, timeCommonCfg.activeMinute);
/* 40 */     long lastAwardTime = xPetArenaRankBackup.getAward_time();
/* 41 */     long lastResetTime = DateTimeUtils.getDailyResetTime(lastAwardTime, timeCommonCfg.activeHour, timeCommonCfg.activeMinute);
/*    */     
/* 43 */     if (resetTime == lastResetTime)
/*    */     {
/* 45 */       GameServer.logger().error(String.format("[petarena]PCheckRankAndBackUp.processImp@awarded|time=%d|last_time=%d", new Object[] { Long.valueOf(this.time), Long.valueOf(lastAwardTime) }));
/*    */       
/*    */ 
/* 48 */       return false;
/*    */     }
/*    */     
/* 51 */     xPetArenaRankBackup.getRole_ranks().clear();
/* 52 */     xPetArenaRankBackup.getRole_ranks().putAll(this.roles);
/* 53 */     xPetArenaRankBackup.getAwards().putAll(this.roles);
/* 54 */     xPetArenaRankBackup.setAward_time(this.time);
/*    */     
/*    */ 
/* 57 */     for (Map.Entry<Long, Integer> xEntry : xPetArenaRankBackup.getAwards().entrySet())
/*    */     {
/* 59 */       long roleid = ((Long)xEntry.getKey()).longValue();
/* 60 */       int rank = ((Integer)xEntry.getValue()).intValue();
/* 61 */       NoneRealTimeTaskManager.getInstance().addTask(new PDailyRankAward(roleid, rank));
/*    */     }
/*    */     
/* 64 */     GameServer.logger().info(String.format("[petarena]PCheckRankAndBackUp.processImp@backup done|time=%d|last_time=%d", new Object[] { Long.valueOf(this.time), Long.valueOf(lastAwardTime) }));
/*    */     
/*    */ 
/* 67 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\main\PCheckRankAndBackUp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */