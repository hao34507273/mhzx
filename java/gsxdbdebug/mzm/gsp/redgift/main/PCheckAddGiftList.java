/*    */ package mzm.gsp.redgift.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import xbean.RedgiftRoleidSet;
/*    */ 
/*    */ class PCheckAddGiftList extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   
/*    */   PCheckAddGiftList(long roleid)
/*    */   {
/* 12 */     this.roleid = roleid;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 17 */     long localId = GameServerInfoManager.getLocalId();
/*    */     
/* 19 */     int roleLevel = mzm.gsp.role.main.RoleInterface.getLevel(this.roleid);
/*    */     
/* 21 */     RedgiftRoleidSet xrRedgiftRoleidSet = xtable.Redgift.get(Long.valueOf(localId));
/* 22 */     if (RedGiftManager.isLevelOnGetRedgiftRange(roleLevel)) {
/* 23 */       xrRedgiftRoleidSet.getRoleidset().add(Long.valueOf(this.roleid));
/* 24 */       return true;
/*    */     }
/*    */     
/*    */ 
/* 28 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\redgift\main\PCheckAddGiftList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */