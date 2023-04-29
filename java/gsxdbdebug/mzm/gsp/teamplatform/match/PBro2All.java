/*    */ package mzm.gsp.teamplatform.match;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.GameServer;
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.teamplatform.SSynTeamNumInfo;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import org.apache.log4j.Logger;
/*    */ import xdb.Executor;
/*    */ import xdb.Xdb;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PBro2All
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long teamId;
/*    */   private final long teamLeaderId;
/*    */   private final int activityId;
/*    */   private final int index;
/*    */   private final int levelLow;
/*    */   private final int levelHigh;
/*    */   private final boolean isCancle;
/*    */   
/*    */   public PBro2All(long teamId, long teamLeaderId, int activityId, int index, int levelLow, int levelHigh, boolean isCancle)
/*    */   {
/* 28 */     this.teamId = teamId;
/* 29 */     this.teamLeaderId = teamLeaderId;
/* 30 */     this.activityId = activityId;
/* 31 */     this.index = index;
/* 32 */     this.levelHigh = levelHigh;
/* 33 */     this.levelLow = levelLow;
/* 34 */     this.isCancle = isCancle;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 40 */     int level_high_final = this.levelHigh;
/* 41 */     int level_low_final = this.levelLow;
/* 42 */     int leaderLevel = RoleInterface.getLevel(this.teamLeaderId);
/* 43 */     List<Integer> levelArgs = TeamMatchMananger.getRealLevelGap(this.activityId, this.index, this.levelLow, this.levelHigh, leaderLevel);
/* 44 */     if ((levelArgs == null) || (levelArgs.size() != 2))
/*    */     {
/* 46 */       GameServer.logger().error(String.format("[teamMatch]PBro2All.processImp@广播队伍信息时，取等级上下限失败!|roleId=%d|level=%d|matchcfgid=%d|index=%d|levelLow=%d|levelHigh=%d", new Object[] { Long.valueOf(this.teamLeaderId), Integer.valueOf(leaderLevel), Integer.valueOf(this.activityId), Integer.valueOf(this.index), Integer.valueOf(this.levelLow), Integer.valueOf(this.levelHigh) }));
/*    */       
/*    */ 
/*    */ 
/* 50 */       return false;
/*    */     }
/* 52 */     level_high_final = ((Integer)levelArgs.get(1)).intValue();
/* 53 */     level_low_final = ((Integer)levelArgs.get(0)).intValue();
/*    */     
/* 55 */     SSynTeamNumInfo sSynTeamNumInfo = new SSynTeamNumInfo();
/* 56 */     TeamMatchMananger.fillTeamInfo(this.teamId, this.teamLeaderId, sSynTeamNumInfo.newteminfo, level_low_final, level_high_final, this.activityId, this.index, this.isCancle);
/*    */     
/*    */ 
/* 59 */     Xdb.executor().execute(new RSend2Client(level_low_final, level_high_final, sSynTeamNumInfo));
/* 60 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\match\PBro2All.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */