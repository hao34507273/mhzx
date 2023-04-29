/*    */ package mzm.gsp.chat;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.chat.main.PPacketFaBaoInChat;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CPacketFaBaoInChat
/*    */   extends __CPacketFaBaoInChat__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585244;
/*    */   public long checkedroleid;
/*    */   public long uuid;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleid = Role.getRoleId(this);
/* 21 */     Role.addRoleProcedure(roleid, new PPacketFaBaoInChat(roleid, this.checkedroleid, this.uuid));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12585244;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CPacketFaBaoInChat() {}
/*    */   
/*    */ 
/*    */   public CPacketFaBaoInChat(long _checkedroleid_, long _uuid_)
/*    */   {
/* 39 */     this.checkedroleid = _checkedroleid_;
/* 40 */     this.uuid = _uuid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.checkedroleid);
/* 49 */     _os_.marshal(this.uuid);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.checkedroleid = _os_.unmarshal_long();
/* 55 */     this.uuid = _os_.unmarshal_long();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CPacketFaBaoInChat)) {
/* 65 */       CPacketFaBaoInChat _o_ = (CPacketFaBaoInChat)_o1_;
/* 66 */       if (this.checkedroleid != _o_.checkedroleid) return false;
/* 67 */       if (this.uuid != _o_.uuid) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.checkedroleid;
/* 76 */     _h_ += (int)this.uuid;
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.checkedroleid).append(",");
/* 84 */     _sb_.append(this.uuid).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(CPacketFaBaoInChat _o_) {
/* 90 */     if (_o_ == this) return 0;
/* 91 */     int _c_ = 0;
/* 92 */     _c_ = Long.signum(this.checkedroleid - _o_.checkedroleid);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     _c_ = Long.signum(this.uuid - _o_.uuid);
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\CPacketFaBaoInChat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */