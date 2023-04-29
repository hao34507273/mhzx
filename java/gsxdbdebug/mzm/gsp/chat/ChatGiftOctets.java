/*    */ package mzm.gsp.chat;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class ChatGiftOctets implements Marshal
/*    */ {
/*    */   public long chatgiftid;
/*    */   public String chatgiftstr;
/*    */   
/*    */   public ChatGiftOctets()
/*    */   {
/* 13 */     this.chatgiftstr = "";
/*    */   }
/*    */   
/*    */   public ChatGiftOctets(long _chatgiftid_, String _chatgiftstr_) {
/* 17 */     this.chatgiftid = _chatgiftid_;
/* 18 */     this.chatgiftstr = _chatgiftstr_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 26 */     _os_.marshal(this.chatgiftid);
/* 27 */     _os_.marshal(this.chatgiftstr, "UTF-16LE");
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 32 */     this.chatgiftid = _os_.unmarshal_long();
/* 33 */     this.chatgiftstr = _os_.unmarshal_String("UTF-16LE");
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 38 */     if (_o1_ == this) return true;
/* 39 */     if ((_o1_ instanceof ChatGiftOctets)) {
/* 40 */       ChatGiftOctets _o_ = (ChatGiftOctets)_o1_;
/* 41 */       if (this.chatgiftid != _o_.chatgiftid) return false;
/* 42 */       if (!this.chatgiftstr.equals(_o_.chatgiftstr)) return false;
/* 43 */       return true;
/*    */     }
/* 45 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 49 */     int _h_ = 0;
/* 50 */     _h_ += (int)this.chatgiftid;
/* 51 */     _h_ += this.chatgiftstr.hashCode();
/* 52 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 56 */     StringBuilder _sb_ = new StringBuilder();
/* 57 */     _sb_.append("(");
/* 58 */     _sb_.append(this.chatgiftid).append(",");
/* 59 */     _sb_.append("T").append(this.chatgiftstr.length()).append(",");
/* 60 */     _sb_.append(")");
/* 61 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\ChatGiftOctets.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */