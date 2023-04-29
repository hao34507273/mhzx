/*    */ package mzm.gsp.chatbubble.main;
/*    */ 
/*    */ import mzm.gsp.gm.main.GmManager;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ public class PGM_RemoveChatBubble
/*    */   extends LogicProcedure
/*    */ {
/*    */   final long targetRoleId;
/*    */   final long gmRoleId;
/*    */   final int chatBubbleCfgId;
/*    */   final long seconds;
/*    */   
/*    */   public PGM_RemoveChatBubble(long targetRoleId, long gmRoleId, int chatBubbleCfgId, long seconds)
/*    */   {
/* 16 */     this.targetRoleId = targetRoleId;
/* 17 */     this.gmRoleId = gmRoleId;
/* 18 */     this.chatBubbleCfgId = chatBubbleCfgId;
/* 19 */     this.seconds = seconds;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 25 */     int ret = ChatBubbleInterface.removeChatBubbleForIDIP(this.targetRoleId, this.chatBubbleCfgId, this.seconds);
/* 26 */     if (ret == 0)
/*    */     {
/* 28 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "操作成功");
/* 29 */       return true;
/*    */     }
/*    */     
/* 32 */     if (ret == 64026)
/*    */     {
/* 34 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "参数错误");
/* 35 */       return false;
/*    */     }
/*    */     
/* 38 */     if (ret == 64025)
/*    */     {
/* 40 */       GmManager.getInstance().sendResultToGM(this.gmRoleId, "聊天泡泡不存在");
/* 41 */       return false;
/*    */     }
/* 43 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatbubble\main\PGM_RemoveChatBubble.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */