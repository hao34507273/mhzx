/*    */ package com.goldhuman.service.mzminterfaces;
/*    */ 
/*    */ import mzm.gsp.role.main.RoleInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ class GameControl$2
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final GameControl this$0;
/*    */   private final Integer[] val$ret;
/*    */   private final long val$roleid;
/*    */   private String val$newName;
/*    */   
/*    */   GameControl$2(GameControl var1, Integer[] var2, long var3)
/*    */   {
/* 18 */     this.this$0 = var1;
/* 19 */     this.val$ret = var2;
/* 20 */     this.val$roleid = var3;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception {
/* 24 */     this.val$ret[0] = Integer.valueOf(RoleInterface.changeRoleName(this.val$roleid, this.val$newName));
/* 25 */     return this.val$ret[0].intValue() == 0;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\com\goldhuman\service\mzminterfaces\GameControl$2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */