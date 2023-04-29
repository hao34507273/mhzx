/*    */ package mzm.gsp.singlebattle.main;
/*    */ 
/*    */ import xbean.RoleSingleBattle;
/*    */ 
/*    */ public class RoleBattleBaseInfo {
/*    */   private final RoleSingleBattle xRoleSingleBattle;
/*    */   
/*    */   RoleBattleBaseInfo(long roleId, boolean remainRoleLock) {
/*  9 */     if (remainRoleLock)
/*    */     {
/* 11 */       this.xRoleSingleBattle = xtable.Role2singlebattle.get(Long.valueOf(roleId));
/*    */     }
/*    */     else
/*    */     {
/* 15 */       this.xRoleSingleBattle = xtable.Role2singlebattle.select(Long.valueOf(roleId));
/*    */     }
/*    */   }
/*    */   
/*    */   RoleSingleBattle getxRoleSingleBattle()
/*    */   {
/* 21 */     return this.xRoleSingleBattle;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public long getBattleId()
/*    */   {
/* 31 */     return this.xRoleSingleBattle.getBattleid();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getBattleCfgId()
/*    */   {
/* 41 */     return this.xRoleSingleBattle.getBattlecfgid();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getCampId()
/*    */   {
/* 51 */     return this.xRoleSingleBattle.getCampid();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\singlebattle\main\RoleBattleBaseInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */