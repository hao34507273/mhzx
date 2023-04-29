/*    */ package mzm.gsp.superequipment.wushi.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.WuShiAwardInfo;
/*    */ import xtable.Role2wushiawardinfo;
/*    */ 
/*    */ public class PGM_ClearWuShiAward
/*    */   extends LogicProcedure
/*    */ {
/*    */   final long roleId;
/*    */   
/*    */   public PGM_ClearWuShiAward(long roleId)
/*    */   {
/* 15 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     WuShiAwardInfo xWuShiAwardInfo = Role2wushiawardinfo.get(Long.valueOf(this.roleId));
/* 22 */     if (xWuShiAwardInfo == null)
/*    */     {
/* 24 */       return false;
/*    */     }
/* 26 */     Role2wushiawardinfo.delete(Long.valueOf(this.roleId));
/* 27 */     GmManager.getInstance().sendResultToGM(this.roleId, "清除武饰奖励成功");
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\wushi\main\PGM_ClearWuShiAward.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */