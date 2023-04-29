/*    */ package mzm.gsp.chat;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CChatInBattle
/*    */   extends __CChatInBattle__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585225;
/*    */   public int contenttype;
/*    */   public Octets content;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12585225;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CChatInBattle()
/*    */   {
/* 32 */     this.content = new Octets();
/*    */   }
/*    */   
/*    */   public CChatInBattle(int _contenttype_, Octets _content_) {
/* 36 */     this.contenttype = _contenttype_;
/* 37 */     this.content = _content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 41 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 45 */     _os_.marshal(this.contenttype);
/* 46 */     _os_.marshal(this.content);
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 51 */     this.contenttype = _os_.unmarshal_int();
/* 52 */     this.content = _os_.unmarshal_Octets();
/* 53 */     if (!_validator_()) {
/* 54 */       throw new VerifyError("validator failed");
/*    */     }
/* 56 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 60 */     if (_o1_ == this) return true;
/* 61 */     if ((_o1_ instanceof CChatInBattle)) {
/* 62 */       CChatInBattle _o_ = (CChatInBattle)_o1_;
/* 63 */       if (this.contenttype != _o_.contenttype) return false;
/* 64 */       if (!this.content.equals(_o_.content)) return false;
/* 65 */       return true;
/*    */     }
/* 67 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 71 */     int _h_ = 0;
/* 72 */     _h_ += this.contenttype;
/* 73 */     _h_ += this.content.hashCode();
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append(this.contenttype).append(",");
/* 81 */     _sb_.append("B").append(this.content.size()).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\CChatInBattle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */