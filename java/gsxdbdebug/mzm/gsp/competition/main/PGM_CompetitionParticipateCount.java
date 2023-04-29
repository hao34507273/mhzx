/*    */ package mzm.gsp.competition.main;
/*    */ 
/*    */ import mzm.gsp.gang.main.Gang;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.FactionCompetition;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_CompetitionParticipateCount
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmid;
/*    */   private final long roleid;
/*    */   private final int count;
/*    */   
/*    */   public PGM_CompetitionParticipateCount(long gmid, long roleid, int count)
/*    */   {
/* 20 */     this.gmid = gmid;
/* 21 */     this.roleid = roleid;
/* 22 */     this.count = count;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 27 */     if (this.count < 0) {
/* 28 */       GmManager.getInstance().sendResultToGM(this.gmid, "参加帮战人数不能为负数！");
/* 29 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 33 */     Gang faction = GangInterface.getGangByRoleId(this.roleid, true);
/* 34 */     if (faction == null) {
/* 35 */       GmManager.getInstance().sendResultToGM(this.gmid, "无效角色，没有所属帮派！");
/* 36 */       return false;
/*    */     }
/*    */     
/* 39 */     FactionCompetition xFactionCompetition = CompetitionManager.getXFactionCompetitionIfNotExist(faction.getGangId());
/* 40 */     xFactionCompetition.setPaticipate_count(this.count);
/*    */     
/* 42 */     GmManager.getInstance().sendResultToGM(this.gmid, "设置帮派本次参加帮战人数为" + this.count);
/*    */     
/* 44 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\competition\main\PGM_CompetitionParticipateCount.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */