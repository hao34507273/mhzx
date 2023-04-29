/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.DateTimeUtils;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.FactionCompetition;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_CompetitionActiveCount
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmid;
/*    */   private final long roleid;
/*    */   private final int count;
/*    */   
/*    */   public PGM_CompetitionActiveCount(long gmid, long roleid, int count)
/*    */   {
/* 21 */     this.gmid = gmid;
/* 22 */     this.roleid = roleid;
/* 23 */     this.count = count;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 28 */     if (this.count < 0) {
/* 29 */       GmManager.getInstance().sendResultToGM(this.gmid, "活跃人数不能为负数！");
/* 30 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 34 */     Gang faction = GangInterface.getGangByRoleId(this.roleid, true);
/* 35 */     if (faction == null) {
/* 36 */       GmManager.getInstance().sendResultToGM(this.gmid, "无效角色，没有所属帮派！");
/* 37 */       return false;
/*    */     }
/*    */     
/* 40 */     FactionCompetition xFactionCompetition = CompetitionManager.getXFactionCompetitionIfNotExist(faction.getGangId());
/* 41 */     long now = DateTimeUtils.getCurrTimeInMillis();
/* 42 */     xFactionCompetition.setActive_number(this.count);
/* 43 */     xFactionCompetition.setActive_timestamp(now);
/*    */     
/* 45 */     GmManager.getInstance().sendResultToGM(this.gmid, "设置帮派当天活跃人数为" + this.count);
/*    */     
/* 47 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\PGM_CompetitionActiveCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */