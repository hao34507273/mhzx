/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGMClearSay extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleId;
/*    */   private final long roleId;
/*    */   
/*    */   public PGMClearSay(long gmRoleId, long roleId)
/*    */   {
/* 13 */     this.gmRoleId = gmRoleId;
/* 14 */     this.roleId = roleId;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     IdipManager.sendClearSayToAll(this.roleId);
/* 21 */     GmManager.getInstance().sendResultToGM(this.gmRoleId, "操作成功");
/* 22 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PGMClearSay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */