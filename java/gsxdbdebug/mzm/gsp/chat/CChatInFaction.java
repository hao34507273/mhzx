/*    */ package mzm.gsp.chat;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.chat.main.PCChatInFaction;
/*    */ 
/*    */ public class CChatInFaction
/*    */   extends __CChatInFaction__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585228;
/*    */   public int contenttype;
/*    */   public Octets content;
/*    */   
/*    */   protected void process()
/*    */   {
/* 18 */     long roleId = Role.getRoleId(this);
/* 19 */     if (roleId < 0L) {
/* 20 */       return;
/*    */     }
/* 22 */     Role.addRoleProcedure(roleId, new PCChatInFaction(roleId, this.contenttype, this.content));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 30 */     return 12585228;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CChatInFaction()
/*    */   {
/* 37 */     this.content = new Octets();
/*    */   }
/*    */   
/*    */   public CChatInFaction(int _contenttype_, Octets _content_) {
/* 41 */     this.contenttype = _contenttype_;
/* 42 */     this.content = _content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.contenttype);
/* 51 */     _os_.marshal(this.content);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.contenttype = _os_.unmarshal_int();
/* 57 */     this.content = _os_.unmarshal_Octets();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof CChatInFaction)) {
/* 67 */       CChatInFaction _o_ = (CChatInFaction)_o1_;
/* 68 */       if (this.contenttype != _o_.contenttype) return false;
/* 69 */       if (!this.content.equals(_o_.content)) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.contenttype;
/* 78 */     _h_ += this.content.hashCode();
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.contenttype).append(",");
/* 86 */     _sb_.append("B").append(this.content.size()).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\CChatInFaction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */