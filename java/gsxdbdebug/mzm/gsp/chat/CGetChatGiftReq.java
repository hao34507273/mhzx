/*    */ package mzm.gsp.chat;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.chatgift.main.PCGetChatGiftReq;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CGetChatGiftReq
/*    */   extends __CGetChatGiftReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585260;
/*    */   public int channeltype;
/*    */   public long chatgiftid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleId = Role.getRoleId(this);
/* 20 */     if (roleId < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleId, new PCGetChatGiftReq(roleId, this.chatgiftid, this.channeltype));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12585260;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CGetChatGiftReq() {}
/*    */   
/*    */ 
/*    */   public CGetChatGiftReq(int _channeltype_, long _chatgiftid_)
/*    */   {
/* 41 */     this.channeltype = _channeltype_;
/* 42 */     this.chatgiftid = _chatgiftid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.channeltype);
/* 51 */     _os_.marshal(this.chatgiftid);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.channeltype = _os_.unmarshal_int();
/* 57 */     this.chatgiftid = _os_.unmarshal_long();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CGetChatGiftReq)) {
/* 67 */       CGetChatGiftReq _o_ = (CGetChatGiftReq)_o1_;
/* 68 */       if (this.channeltype != _o_.channeltype) return false;
/* 69 */       if (this.chatgiftid != _o_.chatgiftid) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.channeltype;
/* 78 */     _h_ += (int)this.chatgiftid;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.channeltype).append(",");
/* 86 */     _sb_.append(this.chatgiftid).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CGetChatGiftReq _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.channeltype - _o_.channeltype;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = Long.signum(this.chatgiftid - _o_.chatgiftid);
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\CGetChatGiftReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */