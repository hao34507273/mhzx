/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class TransferChatContentReq implements Marshal
/*    */ {
/*    */   public long roleid;
/*    */   public int channel;
/*    */   public long org_key;
/*    */   public Octets chat_content;
/*    */   
/*    */   public TransferChatContentReq()
/*    */   {
/* 17 */     this.chat_content = new Octets();
/*    */   }
/*    */   
/*    */   public TransferChatContentReq(long _roleid_, int _channel_, long _org_key_, Octets _chat_content_) {
/* 21 */     this.roleid = _roleid_;
/* 22 */     this.channel = _channel_;
/* 23 */     this.org_key = _org_key_;
/* 24 */     this.chat_content = _chat_content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.roleid);
/* 33 */     _os_.marshal(this.channel);
/* 34 */     _os_.marshal(this.org_key);
/* 35 */     _os_.marshal(this.chat_content);
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 40 */     this.roleid = _os_.unmarshal_long();
/* 41 */     this.channel = _os_.unmarshal_int();
/* 42 */     this.org_key = _os_.unmarshal_long();
/* 43 */     this.chat_content = _os_.unmarshal_Octets();
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 48 */     if (_o1_ == this) return true;
/* 49 */     if ((_o1_ instanceof TransferChatContentReq)) {
/* 50 */       TransferChatContentReq _o_ = (TransferChatContentReq)_o1_;
/* 51 */       if (this.roleid != _o_.roleid) return false;
/* 52 */       if (this.channel != _o_.channel) return false;
/* 53 */       if (this.org_key != _o_.org_key) return false;
/* 54 */       if (!this.chat_content.equals(_o_.chat_content)) return false;
/* 55 */       return true;
/*    */     }
/* 57 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 61 */     int _h_ = 0;
/* 62 */     _h_ += (int)this.roleid;
/* 63 */     _h_ += this.channel;
/* 64 */     _h_ += (int)this.org_key;
/* 65 */     _h_ += this.chat_content.hashCode();
/* 66 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 70 */     StringBuilder _sb_ = new StringBuilder();
/* 71 */     _sb_.append("(");
/* 72 */     _sb_.append(this.roleid).append(",");
/* 73 */     _sb_.append(this.channel).append(",");
/* 74 */     _sb_.append(this.org_key).append(",");
/* 75 */     _sb_.append("B").append(this.chat_content.size()).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\TransferChatContentReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */