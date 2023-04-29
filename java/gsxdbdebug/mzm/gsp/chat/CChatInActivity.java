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
/*    */ 
/*    */ 
/*    */ public class CChatInActivity
/*    */   extends __CChatInActivity__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12585219;
/*    */   public int contenttype;
/*    */   public Octets content;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12585219;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public CChatInActivity()
/*    */   {
/* 34 */     this.content = new Octets();
/*    */   }
/*    */   
/*    */   public CChatInActivity(int _contenttype_, Octets _content_) {
/* 38 */     this.contenttype = _contenttype_;
/* 39 */     this.content = _content_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 47 */     _os_.marshal(this.contenttype);
/* 48 */     _os_.marshal(this.content);
/* 49 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 53 */     this.contenttype = _os_.unmarshal_int();
/* 54 */     this.content = _os_.unmarshal_Octets();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof CChatInActivity)) {
/* 64 */       CChatInActivity _o_ = (CChatInActivity)_o1_;
/* 65 */       if (this.contenttype != _o_.contenttype) return false;
/* 66 */       if (!this.content.equals(_o_.content)) return false;
/* 67 */       return true;
/*    */     }
/* 69 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 73 */     int _h_ = 0;
/* 74 */     _h_ += this.contenttype;
/* 75 */     _h_ += this.content.hashCode();
/* 76 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuilder _sb_ = new StringBuilder();
/* 81 */     _sb_.append("(");
/* 82 */     _sb_.append(this.contenttype).append(",");
/* 83 */     _sb_.append("B").append(this.content.size()).append(",");
/* 84 */     _sb_.append(")");
/* 85 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\chat\CChatInActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */