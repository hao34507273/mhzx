/*    */ package mzm.gsp.chat;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ 
/*    */ public class CChatInMap extends __CChatInMap__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585230;
/*    */   public int contenttype;
/*    */   public Octets content;
/*    */   
/*    */   protected void process()
/*    */   {
/* 16 */     long roleId = Role.getRoleId(this);
/* 17 */     if (roleId < 0L) {
/* 18 */       return;
/*    */     }
/* 20 */     Role.addRoleProcedure(roleId, new mzm.gsp.chat.main.PCChatInMap(roleId, this.contenttype, this.content));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 28 */     return 12585230;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CChatInMap()
/*    */   {
/* 35 */     this.content = new Octets();
/*    */   }
/*    */   
/*    */   public CChatInMap(int _contenttype_, Octets _content_) {
/* 39 */     this.contenttype = _contenttype_;
/* 40 */     this.content = _content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.contenttype);
/* 49 */     _os_.marshal(this.content);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.contenttype = _os_.unmarshal_int();
/* 55 */     this.content = _os_.unmarshal_Octets();
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof CChatInMap)) {
/* 65 */       CChatInMap _o_ = (CChatInMap)_o1_;
/* 66 */       if (this.contenttype != _o_.contenttype) return false;
/* 67 */       if (!this.content.equals(_o_.content)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += this.contenttype;
/* 76 */     _h_ += this.content.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.contenttype).append(",");
/* 84 */     _sb_.append("B").append(this.content.size()).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\CChatInMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */