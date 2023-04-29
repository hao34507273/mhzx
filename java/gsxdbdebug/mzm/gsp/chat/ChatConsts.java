/*    */ package mzm.gsp.chat;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChatConsts
/*    */   implements Marshal, Comparable<ChatConsts>
/*    */ {
/*    */   public static final int CHANNEL_NEWER = 1;
/*    */   public static final int CHANNEL_FACTION = 2;
/*    */   public static final int CHANNEL_TEAM = 3;
/*    */   public static final int CHANNEL_CURRENT = 4;
/*    */   public static final int CHANNEL_WORLD = 5;
/*    */   public static final int CHANNEL_ACTIVITY = 6;
/*    */   public static final int CHANNEL_SOMEONE = 7;
/*    */   public static final int CHANNEL_ANCHOR = 8;
/*    */   public static final int CHANNEL_CHAT_ROOM = 9;
/*    */   public static final int CHANNEL_GROUP = 10;
/*    */   public static final int CHANNEL_ALL_GROUP = 11;
/*    */   public static final int CHANNEL_TRUMPRT = 12;
/*    */   public static final int CHANNEL_SINGLE_BATTLE__CAMP = 13;
/*    */   public static final int CHANNEL_FRIEND = 14;
/*    */   public static final int CONTENT_YY = 1;
/*    */   public static final int CONTENT_NORMAL = 2;
/*    */   public static final int CONTENT_NULL = 3;
/*    */   public static final int CONTENT_CHATGIFT = 4;
/*    */   public static final int CONTENT_BULLET = 5;
/*    */   public static final int CONTENT_PACKET_BAG = 1;
/*    */   public static final int CONTENT_PACKET_PET = 2;
/*    */   public static final int CONTENT_PACKET_TASK = 3;
/*    */   public static final int CONTENT_PACKET_WING = 4;
/*    */   public static final int CONTENT_PACKET_MOUNTS = 5;
/*    */   public static final int CONTENT_PACKET_AIRCRAFT = 6;
/*    */   public static final int CHAT__NO_RECIPIENT = 20;
/*    */   public static final int CHAT__SENDER_MUTED = 21;
/*    */   public static final int CHAT__NOT_AT_TIME = 22;
/*    */   public static final int CHAT__LACK_OF_ENERGY = 23;
/*    */   public static final int CHAT__STRANGER_OFFLINE = 24;
/*    */   public static final int CHAT__NOT_OVER_LEVEL = 25;
/*    */   public static final int BANGZHU = 1;
/*    */   public static final int TANGZHU = 2;
/*    */   public static final int DUOZHU = 3;
/*    */   public static final int JINGYING = 4;
/*    */   public static final int BANGZHONG = 5;
/*    */   public static final int TEAMLEADER = 1;
/*    */   public static final int TEAMMEMBER = 2;
/*    */   public static final int CFG__AUTOPLAYVOICE_MAP = 1;
/*    */   public static final int CFG__AUTOPLAYVOICE_WORLD = 2;
/*    */   public static final int CFG__AUTOPLAYVOICE_TEAM = 3;
/*    */   public static final int CFG__AUTOPLAYVOICE_GANG = 4;
/*    */   public static final int CFG__SHIELDMESSAGE_MAP = 5;
/*    */   public static final int CFG__SHIELDMESSAGE_WORLD = 6;
/*    */   public static final int CFG__SHIELDMESSAGE_TEAM = 7;
/*    */   public static final int CFG__SHIELDMESSAGE_GANG = 8;
/*    */   
/*    */   public final boolean _validator_()
/*    */   {
/* 61 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 65 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 69 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 73 */     if (_o1_ == this) return true;
/* 74 */     if ((_o1_ instanceof ChatConsts)) {
/* 75 */       return true;
/*    */     }
/* 77 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 81 */     int _h_ = 0;
/* 82 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuilder _sb_ = new StringBuilder();
/* 87 */     _sb_.append("(");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ChatConsts _o_) {
/* 93 */     if (_o_ == this) return 0;
/* 94 */     int _c_ = 0;
/* 95 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\ChatConsts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */