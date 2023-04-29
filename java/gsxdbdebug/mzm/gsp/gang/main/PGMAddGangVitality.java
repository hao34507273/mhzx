/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.Gang;
/*    */ 
/*    */ public class PGMAddGangVitality
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int vitality;
/*    */   
/*    */   public PGMAddGangVitality(long roleId, int vitality)
/*    */   {
/* 15 */     this.roleId = roleId;
/* 16 */     this.vitality = vitality;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     Long gangid = GangManager.getGangidByRole(this.roleId);
/* 23 */     if (gangid == null) {
/* 24 */       GmManager.getInstance().sendResultToGM(this.roleId, "没有帮派，无法增加帮派活跃度");
/* 25 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 29 */     Gang xGang = GangManager.getXGang(gangid.longValue(), true);
/* 30 */     if (xGang == null) {
/* 31 */       GmManager.getInstance().sendResultToGM(this.roleId, "没有帮派，无法增加帮派活跃度");
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     int newVitality = GangManager.addVitality(gangid.longValue(), xGang, this.vitality);
/* 36 */     GmManager.getInstance().sendResultToGM(this.roleId, "修改帮派活跃度成功，新值" + newVitality);
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PGMAddGangVitality.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */