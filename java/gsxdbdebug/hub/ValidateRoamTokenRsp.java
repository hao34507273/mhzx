/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ValidateRoamTokenRsp
/*    */   implements Marshal, Comparable<ValidateRoamTokenRsp>
/*    */ {
/*    */   public static final int YES = 0;
/*    */   public static final int NO = 1;
/*    */   public int ret;
/*    */   
/*    */   public ValidateRoamTokenRsp() {}
/*    */   
/*    */   public ValidateRoamTokenRsp(int _ret_)
/*    */   {
/* 20 */     this.ret = _ret_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 24 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 28 */     _os_.marshal(this.ret);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.ret = _os_.unmarshal_int();
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 38 */     if (_o1_ == this) return true;
/* 39 */     if ((_o1_ instanceof ValidateRoamTokenRsp)) {
/* 40 */       ValidateRoamTokenRsp _o_ = (ValidateRoamTokenRsp)_o1_;
/* 41 */       if (this.ret != _o_.ret) return false;
/* 42 */       return true;
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 48 */     int _h_ = 0;
/* 49 */     _h_ += this.ret;
/* 50 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 54 */     StringBuilder _sb_ = new StringBuilder();
/* 55 */     _sb_.append("(");
/* 56 */     _sb_.append(this.ret).append(",");
/* 57 */     _sb_.append(")");
/* 58 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ValidateRoamTokenRsp _o_) {
/* 62 */     if (_o_ == this) return 0;
/* 63 */     int _c_ = 0;
/* 64 */     _c_ = this.ret - _o_.ret;
/* 65 */     if (0 != _c_) return _c_;
/* 66 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\ValidateRoamTokenRsp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */