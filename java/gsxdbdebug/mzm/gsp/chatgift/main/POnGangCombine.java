/*    */ package mzm.gsp.chatgift.main;
/*    */ 
/*    */ import java.util.List;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ import xbean.ChatGiftIdList;
/*    */ import xtable.Gang2chatgiftlist;
/*    */ 
/*    */ public class POnGangCombine
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long gangId;
/*    */   
/*    */   POnGangCombine(long gangId)
/*    */   {
/* 15 */     this.gangId = gangId;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception
/*    */   {
/* 20 */     ChatGiftIdList xChatGiftIdList = Gang2chatgiftlist.get(Long.valueOf(this.gangId));
/* 21 */     if (xChatGiftIdList != null) {
/* 22 */       xChatGiftIdList.getChatgiftlist().clear();
/*    */     }
/* 24 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatgift\main\POnGangCombine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */