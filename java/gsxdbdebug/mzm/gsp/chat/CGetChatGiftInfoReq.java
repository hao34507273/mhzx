/*    */ package mzm.gsp.chat;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.chatgift.main.PCGetChatGiftInfoReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetChatGiftInfoReq
/*    */   extends __CGetChatGiftInfoReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585255;
/*    */   public long chatgiftid;
/*    */   public int channeltype;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PCGetChatGiftInfoReq(roleId, this.chatgiftid, this.channeltype));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12585255;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGetChatGiftInfoReq() {}
/*    */   
/*    */ 
/*    */   public CGetChatGiftInfoReq(long _chatgiftid_, int _channeltype_)
/*    */   {
/* 41 */     this.chatgiftid = _chatgiftid_;
/* 42 */     this.channeltype = _channeltype_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.chatgiftid);
/* 51 */     _os_.marshal(this.channeltype);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.chatgiftid = _os_.unmarshal_long();
/* 57 */     this.channeltype = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CGetChatGiftInfoReq)) {
/* 67 */       CGetChatGiftInfoReq _o_ = (CGetChatGiftInfoReq)_o1_;
/* 68 */       if (this.chatgiftid != _o_.chatgiftid) return false;
/* 69 */       if (this.channeltype != _o_.channeltype) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += (int)this.chatgiftid;
/* 78 */     _h_ += this.channeltype;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.chatgiftid).append(",");
/* 86 */     _sb_.append(this.channeltype).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetChatGiftInfoReq _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = Long.signum(this.chatgiftid - _o_.chatgiftid);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.channeltype - _o_.channeltype;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\CGetChatGiftInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */