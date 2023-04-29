/*    */ package mzm.gsp.magicmark.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_RemoveMagicMark
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long roleId;
/*    */   private final int itemId;
/*    */   
/*    */   public PGM_RemoveMagicMark(long gmRoleId, long roleId, int itemId)
/*    */   {
/* 17 */     this.gmRoleId = gmRoleId;
/* 18 */     this.roleId = roleId;
/* 19 */     this.itemId = itemId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     int cutDuration = MagicMarkInterface.removeMagicMarkByItem(this.roleId, this.itemId);
/* 26 */     if (cutDuration < 0)
/*    */     {
/* 28 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("根据道具%d移除角色%d的法印失败, 参数错误或是角色没有该法印", new Object[] { Integer.valueOf(this.itemId), Long.valueOf(this.roleId) }));
/*    */       
/* 30 */       return false;
/*    */     }
/* 32 */     if (cutDuration == 0)
/*    */     {
/* 34 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("根据道具%d移除角色%d的法印成功", new Object[] { Integer.valueOf(this.itemId), Long.valueOf(this.roleId) }));
/*    */       
/* 36 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 40 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, String.format("根据道具%d扣除角色%d的法印使用时间成功 (%d小时)", new Object[] { Integer.valueOf(this.itemId), Long.valueOf(this.roleId), Integer.valueOf(cutDuration) }));
/*    */     
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\magicmark\main\PGM_RemoveMagicMark.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */