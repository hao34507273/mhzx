/*    */ package mzm.gsp.magicmark;
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
/*    */ public class SMagicMarkUnSelectPropRes
/*    */   extends __SMagicMarkUnSelectPropRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12609541;
/*    */   public static final int SUCCESS = 1;
/*    */   public static final int ERROR_NOT_SELECT = 2;
/*    */   public static final int ERROR_ROLE_LEVEL_NOT_ENOUGH = 3;
/*    */   public int ret;
/*    */   public int magicmarktype;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12609541;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SMagicMarkUnSelectPropRes() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SMagicMarkUnSelectPropRes(int _ret_, int _magicmarktype_)
/*    */   {
/* 41 */     this.ret = _ret_;
/* 42 */     this.magicmarktype = _magicmarktype_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 50 */     _os_.marshal(this.ret);
/* 51 */     _os_.marshal(this.magicmarktype);
/* 52 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 56 */     this.ret = _os_.unmarshal_int();
/* 57 */     this.magicmarktype = _os_.unmarshal_int();
/* 58 */     if (!_validator_()) {
/* 59 */       throw new VerifyError("validator failed");
/*    */     }
/* 61 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 65 */     if (_o1_ == this) return true;
/* 66 */     if ((_o1_ instanceof SMagicMarkUnSelectPropRes)) {
/* 67 */       SMagicMarkUnSelectPropRes _o_ = (SMagicMarkUnSelectPropRes)_o1_;
/* 68 */       if (this.ret != _o_.ret) return false;
/* 69 */       if (this.magicmarktype != _o_.magicmarktype) return false;
/* 70 */       return true;
/*    */     }
/* 72 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 76 */     int _h_ = 0;
/* 77 */     _h_ += this.ret;
/* 78 */     _h_ += this.magicmarktype;
/* 79 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 83 */     StringBuilder _sb_ = new StringBuilder();
/* 84 */     _sb_.append("(");
/* 85 */     _sb_.append(this.ret).append(",");
/* 86 */     _sb_.append(this.magicmarktype).append(",");
/* 87 */     _sb_.append(")");
/* 88 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SMagicMarkUnSelectPropRes _o_) {
/* 92 */     if (_o_ == this) return 0;
/* 93 */     int _c_ = 0;
/* 94 */     _c_ = this.ret - _o_.ret;
/* 95 */     if (0 != _c_) return _c_;
/* 96 */     _c_ = this.magicmarktype - _o_.magicmarktype;
/* 97 */     if (0 != _c_) return _c_;
/* 98 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\magicmark\SMagicMarkUnSelectPropRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */