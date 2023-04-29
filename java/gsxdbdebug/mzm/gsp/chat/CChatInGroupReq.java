/*    */ package mzm.gsp.chat;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.chat.main.PChatInGroupReq;
/*    */ 
/*    */ 
/*    */ public class CChatInGroupReq
/*    */   extends __CChatInGroupReq__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585253;
/*    */   public long groupid;
/*    */   public int contenttype;
/*    */   public Octets content;
/*    */   
/*    */   protected void process()
/*    */   {
/* 20 */     long roleId = Role.getRoleId(this);
/* 21 */     if (roleId < 0L) {
/* 22 */       return;
/*    */     }
/* 24 */     Role.addRoleProcedure(roleId, new PChatInGroupReq(roleId, this.groupid, this.contenttype, this.content));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 32 */     return 12585253;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public CChatInGroupReq()
/*    */   {
/* 40 */     this.content = new Octets();
/*    */   }
/*    */   
/*    */   public CChatInGroupReq(long _groupid_, int _contenttype_, Octets _content_) {
/* 44 */     this.groupid = _groupid_;
/* 45 */     this.contenttype = _contenttype_;
/* 46 */     this.content = _content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 50 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 54 */     _os_.marshal(this.groupid);
/* 55 */     _os_.marshal(this.contenttype);
/* 56 */     _os_.marshal(this.content);
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 61 */     this.groupid = _os_.unmarshal_long();
/* 62 */     this.contenttype = _os_.unmarshal_int();
/* 63 */     this.content = _os_.unmarshal_Octets();
/* 64 */     if (!_validator_()) {
/* 65 */       throw new VerifyError("validator failed");
/*    */     }
/* 67 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 71 */     if (_o1_ == this) return true;
/* 72 */     if ((_o1_ instanceof CChatInGroupReq)) {
/* 73 */       CChatInGroupReq _o_ = (CChatInGroupReq)_o1_;
/* 74 */       if (this.groupid != _o_.groupid) return false;
/* 75 */       if (this.contenttype != _o_.contenttype) return false;
/* 76 */       if (!this.content.equals(_o_.content)) return false;
/* 77 */       return true;
/*    */     }
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 83 */     int _h_ = 0;
/* 84 */     _h_ += (int)this.groupid;
/* 85 */     _h_ += this.contenttype;
/* 86 */     _h_ += this.content.hashCode();
/* 87 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 91 */     StringBuilder _sb_ = new StringBuilder();
/* 92 */     _sb_.append("(");
/* 93 */     _sb_.append(this.groupid).append(",");
/* 94 */     _sb_.append(this.contenttype).append(",");
/* 95 */     _sb_.append("B").append(this.content.size()).append(",");
/* 96 */     _sb_.append(")");
/* 97 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\CChatInGroupReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */