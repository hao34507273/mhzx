/*    */ package mzm.gsp.marriage;
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
/*    */ public class SAgreeOrRefuseDivorce
/*    */   extends __SAgreeOrRefuseDivorce__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12599821;
/*    */   public int operator;
/*    */   public long roleid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12599821;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SAgreeOrRefuseDivorce() {}
/*    */   
/*    */ 
/*    */   public SAgreeOrRefuseDivorce(int _operator_, long _roleid_)
/*    */   {
/* 37 */     this.operator = _operator_;
/* 38 */     this.roleid = _roleid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.operator);
/* 47 */     _os_.marshal(this.roleid);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.operator = _os_.unmarshal_int();
/* 53 */     this.roleid = _os_.unmarshal_long();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SAgreeOrRefuseDivorce)) {
/* 63 */       SAgreeOrRefuseDivorce _o_ = (SAgreeOrRefuseDivorce)_o1_;
/* 64 */       if (this.operator != _o_.operator) return false;
/* 65 */       if (this.roleid != _o_.roleid) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.operator;
/* 74 */     _h_ += (int)this.roleid;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.operator).append(",");
/* 82 */     _sb_.append(this.roleid).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SAgreeOrRefuseDivorce _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.operator - _o_.operator;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\SAgreeOrRefuseDivorce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */