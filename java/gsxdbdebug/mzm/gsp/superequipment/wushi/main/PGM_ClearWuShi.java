/*    */ package mzm.gsp.superequipment.wushi.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.WuShiInfoMap;
/*    */ import xtable.Role2wushiinfo;
/*    */ 
/*    */ public class PGM_ClearWuShi
/*    */   extends LogicProcedure
/*    */ {
/*    */   final long roleId;
/*    */   
/*    */   public PGM_ClearWuShi(long roleId)
/*    */   {
/* 15 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     WuShiInfoMap xWuShiInfoMap = Role2wushiinfo.get(Long.valueOf(this.roleId));
/* 22 */     if (xWuShiInfoMap == null)
/*    */     {
/* 24 */       return false;
/*    */     }
/* 26 */     Role2wushiinfo.delete(Long.valueOf(this.roleId));
/* 27 */     GmManager.getInstance().sendResultToGM(this.roleId, "清除武饰成功");
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\wushi\main\PGM_ClearWuShi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */