/*    */ package mzm.gsp.wing;
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
/*    */ public class SSynWingColor
/*    */   extends __SSynWingColor__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12596534;
/*    */   public int cfgid;
/*    */   public int colorid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12596534;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynWingColor() {}
/*    */   
/*    */ 
/*    */   public SSynWingColor(int _cfgid_, int _colorid_)
/*    */   {
/* 37 */     this.cfgid = _cfgid_;
/* 38 */     this.colorid = _colorid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.cfgid);
/* 47 */     _os_.marshal(this.colorid);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.cfgid = _os_.unmarshal_int();
/* 53 */     this.colorid = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SSynWingColor)) {
/* 63 */       SSynWingColor _o_ = (SSynWingColor)_o1_;
/* 64 */       if (this.cfgid != _o_.cfgid) return false;
/* 65 */       if (this.colorid != _o_.colorid) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.cfgid;
/* 74 */     _h_ += this.colorid;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.cfgid).append(",");
/* 82 */     _sb_.append(this.colorid).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSynWingColor _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.cfgid - _o_.cfgid;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.colorid - _o_.colorid;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\wing\SSynWingColor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */