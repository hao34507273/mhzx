/*    */ package mzm.gsp.chat.main;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import xbean.RoleChatInfo;
/*    */ 
/*    */ public class PChangeChannelInfo extends mzm.gsp.util.LogicProcedure
/*    */ {
/*    */   private long roleId;
/*    */   private HashMap<Integer, Integer> chatcfginfo;
/*    */   
/*    */   public PChangeChannelInfo(long roleId, HashMap<Integer, Integer> chatcfginfo)
/*    */   {
/* 14 */     this.roleId = roleId;
/* 15 */     this.chatcfginfo = chatcfginfo;
/*    */   }
/*    */   
/*    */   protected boolean processImp() throws Exception {
/* 19 */     RoleChatInfo roleChatInfo = xtable.Role2chat.get(Long.valueOf(this.roleId));
/* 20 */     if (roleChatInfo == null) {
/* 21 */       return false;
/*    */     }
/*    */     
/* 24 */     roleChatInfo.getChatcfg().clear();
/* 25 */     roleChatInfo.getChatcfg().putAll(this.chatcfginfo);
/*    */     
/* 27 */     ChatStorageManager.sendInitMsg(this.roleId, roleChatInfo);
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\main\PChangeChannelInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */