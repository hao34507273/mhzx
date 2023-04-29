/*    */ package com.goldhuman.service.mzminterfaces;
/*    */ 
/*    */ import mzm.gsp.item.main.ItemInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ class GameControl$1
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final GameControl this$0;
/*    */   private final String val$title;
/*    */   private final String val$content;
/*    */   private final int val$itemid;
/*    */   private final int val$count;
/*    */   
/*    */   GameControl$1(GameControl var1, String var2, String var3, int var4, int var5)
/*    */   {
/* 19 */     this.this$0 = var1;
/* 20 */     this.val$title = var2;
/* 21 */     this.val$content = var3;
/* 22 */     this.val$itemid = var4;
/* 23 */     this.val$count = var5;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception {
/* 27 */     return ItemInterface.addSystemAward(this.val$title, this.val$content, this.val$itemid, this.val$count);
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\com\goldhuman\service\mzminterfaces\GameControl$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */