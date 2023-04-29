/*    */ package mzm.gsp.gm.main;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Cmd_rmchatbubble extends CmdBase
/*    */ {
/*    */   private long roleId;
/*    */   private int chatBubbleCfgId;
/*  9 */   private long seconds = -1L;
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean parse()
/*    */   {
/* 20 */     this.roleId = this.m_gmRole.getRoleid();
/*    */     
/* 22 */     if (this.m_arguments == null) {
/* 23 */       return false;
/*    */     }
/* 25 */     int index = 0;
/*    */     
/* 27 */     if (index >= this.m_arguments.size()) {
/* 28 */       return false;
/*    */     }
/* 30 */     Long targetId = null;
/* 31 */     targetId = xtable.Name2roleid.select((String)this.m_arguments.get(index));
/*    */     
/* 33 */     if (targetId != null)
/*    */     {
/* 35 */       this.roleId = targetId.longValue();
/* 36 */       index++;
/*    */     }
/*    */     
/* 39 */     if (index >= this.m_arguments.size()) {
/* 40 */       return false;
/*    */     }
/* 42 */     Integer I_chatBubbleCfgId = parseInt((String)this.m_arguments.get(index++));
/* 43 */     if (I_chatBubbleCfgId == null) {
/* 44 */       return false;
/*    */     }
/* 46 */     this.chatBubbleCfgId = I_chatBubbleCfgId.intValue();
/*    */     
/* 48 */     if (index >= this.m_arguments.size()) {
/* 49 */       return true;
/*    */     }
/* 51 */     Long L_seconds = parseLong((String)this.m_arguments.get(index++));
/* 52 */     if (L_seconds == null)
/* 53 */       return false;
/* 54 */     this.seconds = L_seconds.longValue();
/*    */     
/* 56 */     if (index != this.m_arguments.size()) {
/* 57 */       return false;
/*    */     }
/* 59 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   protected boolean fillData()
/*    */   {
/* 68 */     return true;
/*    */   }
/*    */   
/*    */ 
/*    */   protected void run()
/*    */   {
/* 74 */     new mzm.gsp.chatbubble.main.PGM_RemoveChatBubble(this.roleId, this.m_gmRole.getRoleid(), this.chatBubbleCfgId, this.seconds).execute();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\gm\main\Cmd_rmchatbubble.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */