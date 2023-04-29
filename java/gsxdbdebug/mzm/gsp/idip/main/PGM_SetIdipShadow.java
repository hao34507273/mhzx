/*    */ package mzm.gsp.idip.main;
/*    */ 
/*    */ import idip.core.Utils;
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_SetIdipShadow extends LogicProcedure
/*    */ {
/*    */   private final long gmRoleid;
/*    */   private final boolean shadow;
/*    */   
/*    */   public PGM_SetIdipShadow(long gmRoleid, boolean shadow)
/*    */   {
/* 14 */     this.gmRoleid = gmRoleid;
/* 15 */     this.shadow = shadow;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 21 */     Utils.setShadow(this.shadow);
/* 22 */     GmManager.getInstance().sendResultToGM(this.gmRoleid, "设置成功");
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\idip\main\PGM_SetIdipShadow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */