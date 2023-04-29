/*    */ package mzm.gsp.chatbubble;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class ChatBubbleInfo
/*    */   implements Marshal, Comparable<ChatBubbleInfo>
/*    */ {
/*    */   public static final int ON = 1;
/*    */   public static final int OFF = 2;
/*    */   public int ison;
/*    */   public int chatbubblecfgid;
/*    */   public long expiretimestamp;
/*    */   
/*    */   public ChatBubbleInfo() {}
/*    */   
/*    */   public ChatBubbleInfo(int _ison_, int _chatbubblecfgid_, long _expiretimestamp_)
/*    */   {
/* 20 */     this.ison = _ison_;
/* 21 */     this.chatbubblecfgid = _chatbubblecfgid_;
/* 22 */     this.expiretimestamp = _expiretimestamp_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.marshal(this.ison);
/* 31 */     _os_.marshal(this.chatbubblecfgid);
/* 32 */     _os_.marshal(this.expiretimestamp);
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 37 */     this.ison = _os_.unmarshal_int();
/* 38 */     this.chatbubblecfgid = _os_.unmarshal_int();
/* 39 */     this.expiretimestamp = _os_.unmarshal_long();
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 44 */     if (_o1_ == this) return true;
/* 45 */     if ((_o1_ instanceof ChatBubbleInfo)) {
/* 46 */       ChatBubbleInfo _o_ = (ChatBubbleInfo)_o1_;
/* 47 */       if (this.ison != _o_.ison) return false;
/* 48 */       if (this.chatbubblecfgid != _o_.chatbubblecfgid) return false;
/* 49 */       if (this.expiretimestamp != _o_.expiretimestamp) return false;
/* 50 */       return true;
/*    */     }
/* 52 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 56 */     int _h_ = 0;
/* 57 */     _h_ += this.ison;
/* 58 */     _h_ += this.chatbubblecfgid;
/* 59 */     _h_ += (int)this.expiretimestamp;
/* 60 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 64 */     StringBuilder _sb_ = new StringBuilder();
/* 65 */     _sb_.append("(");
/* 66 */     _sb_.append(this.ison).append(",");
/* 67 */     _sb_.append(this.chatbubblecfgid).append(",");
/* 68 */     _sb_.append(this.expiretimestamp).append(",");
/* 69 */     _sb_.append(")");
/* 70 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ChatBubbleInfo _o_) {
/* 74 */     if (_o_ == this) return 0;
/* 75 */     int _c_ = 0;
/* 76 */     _c_ = this.ison - _o_.ison;
/* 77 */     if (0 != _c_) return _c_;
/* 78 */     _c_ = this.chatbubblecfgid - _o_.chatbubblecfgid;
/* 79 */     if (0 != _c_) return _c_;
/* 80 */     _c_ = Long.signum(this.expiretimestamp - _o_.expiretimestamp);
/* 81 */     if (0 != _c_) return _c_;
/* 82 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chatbubble\ChatBubbleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */