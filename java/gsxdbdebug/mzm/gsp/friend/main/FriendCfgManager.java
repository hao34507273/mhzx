/*   */ package mzm.gsp.friend.main;
/*   */ 
/*   */ import mzm.gsp.friend.confbean.SFriendValueLimitCfg;
/*   */ 
/*   */ class FriendCfgManager
/*   */ {
/*   */   static SFriendValueLimitCfg getFriendValueLimitCfg(int friendLimitType) {
/* 8 */     return SFriendValueLimitCfg.get(friendLimitType);
/*   */   }
/*   */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\friend\main\FriendCfgManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */