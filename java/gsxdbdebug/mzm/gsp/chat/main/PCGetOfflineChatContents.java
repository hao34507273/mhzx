/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import mzm.gsp.GameServerInfoManager;
/*    */ import mzm.gsp.gang.main.GangInterface;
/*    */ import mzm.gsp.util.LogicProcedure;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PCGetOfflineChatContents
/*    */   extends LogicProcedure
/*    */ {
/*    */   private final long roleid;
/*    */   private final int channelType;
/*    */   
/*    */   public PCGetOfflineChatContents(long roleid, int channelType)
/*    */   {
/* 19 */     this.roleid = roleid;
/* 20 */     this.channelType = channelType;
/*    */   }
/*    */   
/*    */   protected boolean processImp()
/*    */     throws Exception
/*    */   {
/* 26 */     if (GameServerInfoManager.isRoamServer())
/*    */     {
/* 28 */       return false;
/*    */     }
/* 30 */     switch (this.channelType)
/*    */     {
/*    */ 
/*    */     case 2: 
/* 34 */       if (!RoleChatManager.isFactionChatContentBufferOpenForRole(this.roleid))
/*    */       {
/* 36 */         return false;
/*    */       }
/*    */       
/* 39 */       long gangid = GangInterface.getGangId(this.roleid);
/* 40 */       if (gangid <= 0L)
/*    */       {
/* 42 */         return false;
/*    */       }
/* 44 */       FactionChatContentBufferManager.getInstance().sendOfflineChatContents(this.roleid, gangid);
/* 45 */       return true;
/*    */     }
/*    */     
/* 48 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\PCGetOfflineChatContents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */