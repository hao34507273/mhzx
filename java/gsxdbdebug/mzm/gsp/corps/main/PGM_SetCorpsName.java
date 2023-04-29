/*    */ package mzm.gsp.corps.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.CorpsMember;
/*    */ import xtable.Role2corps;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PGM_SetCorpsName
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleId;
/*    */   private final String newName;
/*    */   
/*    */   public PGM_SetCorpsName(long roleId, String newName)
/*    */   {
/* 21 */     this.roleId = roleId;
/* 22 */     this.newName = newName;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 28 */     CorpsMember xCorpsLeader = Role2corps.select(Long.valueOf(this.roleId));
/* 29 */     if (xCorpsLeader == null)
/*    */     {
/* 31 */       GmManager.getInstance().sendResultToGM(this.roleId, "没有战队~");
/* 32 */       return false;
/*    */     }
/*    */     
/* 35 */     xbean.Corps xCorps = xtable.Corps.get(Long.valueOf(xCorpsLeader.getCorpsid()));
/* 36 */     if (xCorps == null)
/*    */     {
/* 38 */       GmManager.getInstance().sendResultToGM(this.roleId, "没有战队~");
/* 39 */       return false;
/*    */     }
/* 41 */     xCorps.setCorpsname(this.newName);
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\corps\main\PGM_SetCorpsName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */