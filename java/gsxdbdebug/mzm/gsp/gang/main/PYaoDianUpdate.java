/*    */ package mzm.gsp.gang.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PYaoDianUpdate
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gangId;
/*    */   
/*    */   public PYaoDianUpdate(long gangId)
/*    */   {
/* 15 */     this.gangId = gangId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     xbean.Gang xGang = xtable.Gang.get(Long.valueOf(this.gangId));
/* 22 */     if (xGang == null) return false;
/* 23 */     YaoDian yaoDian = (YaoDian)BuildingFactory.createGangBuilding(this.gangId, xGang, 3);
/* 24 */     if (yaoDian == null) {
/* 25 */       return false;
/*    */     }
/* 27 */     yaoDian.freshYaoCai();
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gang\main\PYaoDianUpdate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */