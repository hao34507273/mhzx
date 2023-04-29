/*    */ package mzm.gsp.chat;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.chat.main.PCChatInRoomReq;
/*    */ 
/*    */ 
/*    */ public class CChatInRoomReq
/*    */   extends __CChatInRoomReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585248;
/*    */   public int contenttype;
/*    */   public Octets content;
/*    */   
/*    */   protected void process()
/*    */   {
/* 19 */     long roleid = Role.getRoleId(this);
/* 20 */     if (roleid < 0L) {
/* 21 */       return;
/*    */     }
/* 23 */     Role.addRoleProcedure(roleid, new PCChatInRoomReq(roleid, this.contenttype, this.content));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 31 */     return 12585248;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CChatInRoomReq()
/*    */   {
/* 38 */     this.content = new Octets();
/*    */   }
/*    */   
/*    */   public CChatInRoomReq(int _contenttype_, Octets _content_) {
/* 42 */     this.contenttype = _contenttype_;
/* 43 */     this.content = _content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.contenttype);
/* 52 */     _os_.marshal(this.content);
/* 53 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 57 */     this.contenttype = _os_.unmarshal_int();
/* 58 */     this.content = _os_.unmarshal_Octets();
/* 59 */     if (!_validator_()) {
/* 60 */       throw new VerifyError("validator failed");
/*    */     }
/* 62 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 66 */     if (_o1_ == this) return true;
/* 67 */     if ((_o1_ instanceof CChatInRoomReq)) {
/* 68 */       CChatInRoomReq _o_ = (CChatInRoomReq)_o1_;
/* 69 */       if (this.contenttype != _o_.contenttype) return false;
/* 70 */       if (!this.content.equals(_o_.content)) return false;
/* 71 */       return true;
/*    */     }
/* 73 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 77 */     int _h_ = 0;
/* 78 */     _h_ += this.contenttype;
/* 79 */     _h_ += this.content.hashCode();
/* 80 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 84 */     StringBuilder _sb_ = new StringBuilder();
/* 85 */     _sb_.append("(");
/* 86 */     _sb_.append(this.contenttype).append(",");
/* 87 */     _sb_.append("B").append(this.content.size()).append(",");
/* 88 */     _sb_.append(")");
/* 89 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\CChatInRoomReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */