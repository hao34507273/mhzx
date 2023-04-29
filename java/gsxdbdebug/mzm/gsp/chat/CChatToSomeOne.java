/*    */ package mzm.gsp.chat;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ 
/*    */ public class CChatToSomeOne extends __CChatToSomeOne__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585220;
/*    */   public long roleid;
/*    */   public int contenttype;
/*    */   public Octets content;
/*    */   
/*    */   protected void process()
/*    */   {
/* 17 */     long roleId = Role.getRoleId(this);
/* 18 */     if (roleId < 0L) {
/* 19 */       return;
/*    */     }
/* 21 */     Role.addRoleProcedure(roleId, new mzm.gsp.chat.main.PCChatToSomeOne(roleId, this.roleid, this.contenttype, this.content));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12585220;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public CChatToSomeOne()
/*    */   {
/* 37 */     this.content = new Octets();
/*    */   }
/*    */   
/*    */   public CChatToSomeOne(long _roleid_, int _contenttype_, Octets _content_) {
/* 41 */     this.roleid = _roleid_;
/* 42 */     this.contenttype = _contenttype_;
/* 43 */     this.content = _content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.roleid);
/* 52 */     _os_.marshal(this.contenttype);
/* 53 */     _os_.marshal(this.content);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.roleid = _os_.unmarshal_long();
/* 59 */     this.contenttype = _os_.unmarshal_int();
/* 60 */     this.content = _os_.unmarshal_Octets();
/* 61 */     if (!_validator_()) {
/* 62 */       throw new VerifyError("validator failed");
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 68 */     if (_o1_ == this) return true;
/* 69 */     if ((_o1_ instanceof CChatToSomeOne)) {
/* 70 */       CChatToSomeOne _o_ = (CChatToSomeOne)_o1_;
/* 71 */       if (this.roleid != _o_.roleid) return false;
/* 72 */       if (this.contenttype != _o_.contenttype) return false;
/* 73 */       if (!this.content.equals(_o_.content)) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += (int)this.roleid;
/* 82 */     _h_ += this.contenttype;
/* 83 */     _h_ += this.content.hashCode();
/* 84 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 88 */     StringBuilder _sb_ = new StringBuilder();
/* 89 */     _sb_.append("(");
/* 90 */     _sb_.append(this.roleid).append(",");
/* 91 */     _sb_.append(this.contenttype).append(",");
/* 92 */     _sb_.append("B").append(this.content.size()).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\CChatToSomeOne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */