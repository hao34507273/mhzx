/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ public class PGMAddGangMoney extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int money;
/*    */   
/*    */   public PGMAddGangMoney(long roleId, int money)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.money = money;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(this.roleId));
/* 22 */     if (xGangMember == null) {
/* 23 */       return false;
/*    */     }
/*    */     
/* 26 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(xGangMember.getGangid()));
/* 27 */     if (xGang == null) {
/* 28 */       return false;
/*    */     }
/* 30 */     if (!GangManager.isInGang(xGang, this.roleId)) {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     GangManager.addGangMoney(xGang, this.money);
/*    */     
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PGMAddGangMoney.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */