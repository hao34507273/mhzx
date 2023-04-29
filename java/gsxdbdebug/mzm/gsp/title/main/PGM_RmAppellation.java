/*    */ package mzm.gsp.title.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_RmAppellation extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final long targetRoleId;
/*    */   private final int appellationId;
/*    */   
/*    */   public PGM_RmAppellation(long roleId, long targetRoleId, int appellationId)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.targetRoleId = targetRoleId;
/* 16 */     this.appellationId = appellationId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 22 */     TitleOptionResult result = TitleInterface.rmAppellantion4IDIP(this.targetRoleId, this.appellationId);
/* 23 */     if (result == TitleOptionResult.SUCCESS)
/*    */     {
/* 25 */       GmManager.getInstance().sendResultToGM(this.roleId, "操作成功！");
/* 26 */       return true;
/*    */     }
/* 28 */     GmManager.getInstance().sendResultToGM(this.roleId, String.format("操作失败，错误码：", new Object[] { Integer.valueOf(result.ordinal()) }));
/* 29 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\title\main\PGM_RmAppellation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */