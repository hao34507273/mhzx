/*    */ package mzm.gsp.drawandguess;
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
/*    */ public class SNotifyAgreeOrRefuseDrawAndGuess
/*    */   extends __SNotifyAgreeOrRefuseDrawAndGuess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12617244;
/*    */   public long member_roleid;
/*    */   public int operator;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12617244;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SNotifyAgreeOrRefuseDrawAndGuess() {}
/*    */   
/*    */ 
/*    */   public SNotifyAgreeOrRefuseDrawAndGuess(long _member_roleid_, int _operator_)
/*    */   {
/* 37 */     this.member_roleid = _member_roleid_;
/* 38 */     this.operator = _operator_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.member_roleid);
/* 47 */     _os_.marshal(this.operator);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.member_roleid = _os_.unmarshal_long();
/* 53 */     this.operator = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SNotifyAgreeOrRefuseDrawAndGuess)) {
/* 63 */       SNotifyAgreeOrRefuseDrawAndGuess _o_ = (SNotifyAgreeOrRefuseDrawAndGuess)_o1_;
/* 64 */       if (this.member_roleid != _o_.member_roleid) return false;
/* 65 */       if (this.operator != _o_.operator) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.member_roleid;
/* 74 */     _h_ += this.operator;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.member_roleid).append(",");
/* 82 */     _sb_.append(this.operator).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SNotifyAgreeOrRefuseDrawAndGuess _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.member_roleid - _o_.member_roleid);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.operator - _o_.operator;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\SNotifyAgreeOrRefuseDrawAndGuess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */