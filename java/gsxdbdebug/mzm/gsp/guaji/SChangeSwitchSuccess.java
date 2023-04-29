/*    */ package mzm.gsp.guaji;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
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
/*    */ 
/*    */ public class SChangeSwitchSuccess
/*    */   extends __SChangeSwitchSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12591112;
/*    */   public int switch_type;
/*    */   public byte open;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12591112;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SChangeSwitchSuccess() {}
/*    */   
/*    */ 
/*    */   public SChangeSwitchSuccess(int _switch_type_, byte _open_)
/*    */   {
/* 37 */     this.switch_type = _switch_type_;
/* 38 */     this.open = _open_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.switch_type);
/* 47 */     _os_.marshal(this.open);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.switch_type = _os_.unmarshal_int();
/* 53 */     this.open = _os_.unmarshal_byte();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SChangeSwitchSuccess)) {
/* 63 */       SChangeSwitchSuccess _o_ = (SChangeSwitchSuccess)_o1_;
/* 64 */       if (this.switch_type != _o_.switch_type) return false;
/* 65 */       if (this.open != _o_.open) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.switch_type;
/* 74 */     _h_ += this.open;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.switch_type).append(",");
/* 82 */     _sb_.append(this.open).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SChangeSwitchSuccess _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.switch_type - _o_.switch_type;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.open - _o_.open;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\guaji\SChangeSwitchSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */