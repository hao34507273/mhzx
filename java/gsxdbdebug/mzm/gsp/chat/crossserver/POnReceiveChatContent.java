/*    */ package mzm.gsp.chat.crossserver;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.chat.SChatInFaction;
/*    */ import mzm.gsp.chat.main.ChatInterface;
/*    */ import mzm.gsp.crossserver.event.ReceiveChatContentArg;
/*    */ import mzm.gsp.crossserver.event.ReceiveChatContentProcedure;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class POnReceiveChatContent
/*    */   extends ReceiveChatContentProcedure
/*    */ {
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 20 */     switch (((ReceiveChatContentArg)this.arg).getChannel())
/*    */     {
/*    */ 
/*    */     case 2: 
/* 24 */       final SChatInFaction protocol = new SChatInFaction();
/* 25 */       protocol.unmarshal(OctetsStream.wrap(((ReceiveChatContentArg)this.arg).getChatContent()));
/* 26 */       CrossServerChatOneByOneManager.getInstance().addLogicProcedure(Integer.valueOf(2), new LogicProcedure()
/*    */       {
/*    */         protected boolean processImp()
/*    */           throws Exception
/*    */         {
/* 31 */           return ChatInterface.onReceiveFactionChatContent(((ReceiveChatContentArg)POnReceiveChatContent.this.arg).getRoleid(), ((ReceiveChatContentArg)POnReceiveChatContent.this.arg).getOrgKey(), protocol);
/*    */         }
/*    */       });
/*    */     }
/*    */     
/*    */     
/*    */ 
/*    */ 
/* 39 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\crossserver\POnReceiveChatContent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */