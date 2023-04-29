/*    */ package mzm.gsp.chat;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class GetChatGiftSimpleInfo
/*    */   implements Marshal
/*    */ {
/*    */   public long chatgiftid;
/*    */   public String rolename;
/*    */   public String chatgiftstr;
/*    */   public int iscanget;
/*    */   
/*    */   public GetChatGiftSimpleInfo()
/*    */   {
/* 17 */     this.rolename = "";
/* 18 */     this.chatgiftstr = "";
/*    */   }
/*    */   
/*    */   public GetChatGiftSimpleInfo(long _chatgiftid_, String _rolename_, String _chatgiftstr_, int _iscanget_) {
/* 22 */     this.chatgiftid = _chatgiftid_;
/* 23 */     this.rolename = _rolename_;
/* 24 */     this.chatgiftstr = _chatgiftstr_;
/* 25 */     this.iscanget = _iscanget_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.chatgiftid);
/* 34 */     _os_.marshal(this.rolename, "UTF-16LE");
/* 35 */     _os_.marshal(this.chatgiftstr, "UTF-16LE");
/* 36 */     _os_.marshal(this.iscanget);
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 41 */     this.chatgiftid = _os_.unmarshal_long();
/* 42 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/* 43 */     this.chatgiftstr = _os_.unmarshal_String("UTF-16LE");
/* 44 */     this.iscanget = _os_.unmarshal_int();
/* 45 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 49 */     if (_o1_ == this) return true;
/* 50 */     if ((_o1_ instanceof GetChatGiftSimpleInfo)) {
/* 51 */       GetChatGiftSimpleInfo _o_ = (GetChatGiftSimpleInfo)_o1_;
/* 52 */       if (this.chatgiftid != _o_.chatgiftid) return false;
/* 53 */       if (!this.rolename.equals(_o_.rolename)) return false;
/* 54 */       if (!this.chatgiftstr.equals(_o_.chatgiftstr)) return false;
/* 55 */       if (this.iscanget != _o_.iscanget) return false;
/* 56 */       return true;
/*    */     }
/* 58 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 62 */     int _h_ = 0;
/* 63 */     _h_ += (int)this.chatgiftid;
/* 64 */     _h_ += this.rolename.hashCode();
/* 65 */     _h_ += this.chatgiftstr.hashCode();
/* 66 */     _h_ += this.iscanget;
/* 67 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 71 */     StringBuilder _sb_ = new StringBuilder();
/* 72 */     _sb_.append("(");
/* 73 */     _sb_.append(this.chatgiftid).append(",");
/* 74 */     _sb_.append("T").append(this.rolename.length()).append(",");
/* 75 */     _sb_.append("T").append(this.chatgiftstr.length()).append(",");
/* 76 */     _sb_.append(this.iscanget).append(",");
/* 77 */     _sb_.append(")");
/* 78 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\GetChatGiftSimpleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */