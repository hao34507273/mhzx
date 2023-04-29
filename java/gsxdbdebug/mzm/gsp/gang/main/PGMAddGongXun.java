/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ 
/*    */ public class PGMAddGongXun extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long gmid;
/*    */   private final long roleid;
/*    */   private final int value;
/*    */   
/*    */   public PGMAddGongXun(long gmid, long roleid, int value)
/*    */   {
/* 13 */     this.gmid = gmid;
/* 14 */     this.roleid = roleid;
/* 15 */     this.value = value;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     if (this.value <= 0) {
/* 21 */       GmManager.getInstance().sendResultToGM(this.gmid, "增加功勋值必须为正！");
/* 22 */       return false;
/*    */     }
/*    */     
/*    */ 
/* 26 */     xbean.GangMember xMember = xtable.Role2gangmember.get(Long.valueOf(this.roleid));
/* 27 */     if (xMember == null) {
/* 28 */       GmManager.getInstance().sendResultToGM(this.gmid, "没有帮派，无法增加帮派功勋");
/* 29 */       return false;
/*    */     }
/*    */     
/* 32 */     long gangid = xMember.getGangid();
/*    */     
/* 34 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(gangid));
/*    */     
/* 36 */     GangManager.addGongXun(gangid, xGang, this.roleid, xMember, this.value);
/*    */     
/* 38 */     GmManager.getInstance().sendResultToGM(this.gmid, "新的帮派功勋：" + xMember.getGongxun());
/*    */     
/* 40 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PGMAddGongXun.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */