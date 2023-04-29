/*    */ package mzm.gsp.grc;
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
/*    */ public class SNotifyPrivilegeAwardTip
/*    */   extends __SNotifyPrivilegeAwardTip__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600345;
/*    */   public static final int AWARD_TYPE_SIGN = 1;
/*    */   public int award_type;
/*    */   public int privilege_type;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12600345;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SNotifyPrivilegeAwardTip()
/*    */   {
/* 36 */     this.award_type = 1;
/* 37 */     this.privilege_type = 0;
/*    */   }
/*    */   
/*    */   public SNotifyPrivilegeAwardTip(int _award_type_, int _privilege_type_) {
/* 41 */     this.award_type = _award_type_;
/* 42 */     this.privilege_type = _privilege_type_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.award_type);
/* 51 */     _os_.marshal(this.privilege_type);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.award_type = _os_.unmarshal_int();
/* 57 */     this.privilege_type = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SNotifyPrivilegeAwardTip)) {
/* 67 */       SNotifyPrivilegeAwardTip _o_ = (SNotifyPrivilegeAwardTip)_o1_;
/* 68 */       if (this.award_type != _o_.award_type) return false;
/* 69 */       if (this.privilege_type != _o_.privilege_type) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.award_type;
/* 78 */     _h_ += this.privilege_type;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.award_type).append(",");
/* 86 */     _sb_.append(this.privilege_type).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SNotifyPrivilegeAwardTip _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.award_type - _o_.award_type;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.privilege_type - _o_.privilege_type;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\SNotifyPrivilegeAwardTip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */