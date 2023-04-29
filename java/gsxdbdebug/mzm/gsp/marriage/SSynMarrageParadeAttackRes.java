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
/*    */ public class SSynMarrageParadeAttackRes
/*    */   extends __SSynMarrageParadeAttackRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12599863;
/*    */   public int paraderoletype;
/*    */   public int attackedstate;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12599863;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynMarrageParadeAttackRes() {}
/*    */   
/*    */ 
/*    */   public SSynMarrageParadeAttackRes(int _paraderoletype_, int _attackedstate_)
/*    */   {
/* 37 */     this.paraderoletype = _paraderoletype_;
/* 38 */     this.attackedstate = _attackedstate_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.paraderoletype);
/* 47 */     _os_.marshal(this.attackedstate);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.paraderoletype = _os_.unmarshal_int();
/* 53 */     this.attackedstate = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SSynMarrageParadeAttackRes)) {
/* 63 */       SSynMarrageParadeAttackRes _o_ = (SSynMarrageParadeAttackRes)_o1_;
/* 64 */       if (this.paraderoletype != _o_.paraderoletype) return false;
/* 65 */       if (this.attackedstate != _o_.attackedstate) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.paraderoletype;
/* 74 */     _h_ += this.attackedstate;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.paraderoletype).append(",");
/* 82 */     _sb_.append(this.attackedstate).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSynMarrageParadeAttackRes _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.paraderoletype - _o_.paraderoletype;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.attackedstate - _o_.attackedstate;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\marriage\SSynMarrageParadeAttackRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */