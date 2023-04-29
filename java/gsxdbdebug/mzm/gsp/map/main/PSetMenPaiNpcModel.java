/*    */ package mzm.gsp.map.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ class PSetMenPaiNpcModel extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   PSetMenPaiNpcModel(long roleid)
/*    */   {
/* 11 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 17 */     return MapManager.setMenPaiNpcModel(this.roleid);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\map\main\PSetMenPaiNpcModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */