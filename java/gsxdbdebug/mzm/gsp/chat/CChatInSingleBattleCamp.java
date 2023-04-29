/*    */ package mzm.gsp.chat;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ import mzm.gsp.Role;
/*    */ import mzm.gsp.chat.main.PCChatInSingleBattleCamp;
/*    */ 
/*    */ public class CChatInSingleBattleCamp extends __CChatInSingleBattleCamp__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585277;
/*    */   public int contenttype;
/*    */   public Octets content;
/*    */   
/*    */   protected void process()
/*    */   {
/* 17 */     long roleId = Role.getRoleId(this);
/* 18 */     if (roleId < 0L) {
/* 19 */       return;
/*    */     }
/* 21 */     Role.addRoleProcedure(roleId, new PCChatInSingleBattleCamp(roleId, this.contenttype, this.content));
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int getType()
/*    */   {
/* 29 */     return 12585277;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CChatInSingleBattleCamp()
/*    */   {
/* 36 */     this.content = new Octets();
/*    */   }
/*    */   
/*    */   public CChatInSingleBattleCamp(int _contenttype_, Octets _content_) {
/* 40 */     this.contenttype = _contenttype_;
/* 41 */     this.content = _content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.contenttype);
/* 50 */     _os_.marshal(this.content);
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 55 */     this.contenttype = _os_.unmarshal_int();
/* 56 */     this.content = _os_.unmarshal_Octets();
/* 57 */     if (!_validator_()) {
/* 58 */       throw new VerifyError("validator failed");
/*    */     }
/* 60 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 64 */     if (_o1_ == this) return true;
/* 65 */     if ((_o1_ instanceof CChatInSingleBattleCamp)) {
/* 66 */       CChatInSingleBattleCamp _o_ = (CChatInSingleBattleCamp)_o1_;
/* 67 */       if (this.contenttype != _o_.contenttype) return false;
/* 68 */       if (!this.content.equals(_o_.content)) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.contenttype;
/* 77 */     _h_ += this.content.hashCode();
/* 78 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 82 */     StringBuilder _sb_ = new StringBuilder();
/* 83 */     _sb_.append("(");
/* 84 */     _sb_.append(this.contenttype).append(",");
/* 85 */     _sb_.append("B").append(this.content.size()).append(",");
/* 86 */     _sb_.append(")");
/* 87 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\CChatInSingleBattleCamp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */