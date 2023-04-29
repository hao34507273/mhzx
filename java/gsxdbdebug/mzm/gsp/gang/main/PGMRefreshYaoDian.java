/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.GangMember;
/*    */ import xtable.Role2gangmember;
/*    */ 
/*    */ public class PGMRefreshYaoDian
/*    */   extends LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private int isTrigger;
/*    */   
/*    */   public PGMRefreshYaoDian(long roleId, int isTrigger)
/*    */   {
/* 15 */     this.roleId = roleId;
/* 16 */     this.isTrigger = isTrigger;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     GangMember xGangMember = Role2gangmember.get(Long.valueOf(this.roleId));
/* 23 */     if (xGangMember == null) {
/* 24 */       return false;
/*    */     }
/*    */     
/* 27 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(xGangMember.getGangid()));
/* 28 */     if ((xGang == null) || (!GangManager.isInGang(xGang, this.roleId))) {
/* 29 */       return false;
/*    */     }
/* 31 */     YaoDian yaoDian = (YaoDian)BuildingFactory.createGangBuilding(xGangMember.getGangid(), xGang, 3);
/* 32 */     yaoDian.freshYaoCai();
/* 33 */     if (this.isTrigger == 1) {
/* 34 */       yaoDian.doInitMiYao();
/*    */     }
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PGMRefreshYaoDian.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */