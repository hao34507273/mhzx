/*    */ package mzm.gsp.item.main;
/*    */ 
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.EquipMode;
/*    */ 
/*    */ public class PSetQiLinModeReq
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int mode;
/*    */   
/*    */   public PSetQiLinModeReq(long roleid, int mode)
/*    */   {
/* 14 */     this.roleid = roleid;
/* 15 */     this.mode = mode;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     if ((this.mode != 1) && (this.mode != 0))
/*    */     {
/* 23 */       return false;
/*    */     }
/* 25 */     EquipMode xEquipMode = ItemManager.getXEquipMode(this.roleid);
/* 26 */     xEquipMode.setMode(this.mode);
/* 27 */     xEquipMode.setIsset(true);
/* 28 */     ItemManager.sendSSynEquipQilinModeRes(this.roleid, this.mode);
/* 29 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\main\PSetQiLinModeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */