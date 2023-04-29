/*    */ package mzm.gsp.hula;
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
/*    */ public class SSynDoudouComeoutStagetRes
/*    */   extends __SSynDoudouComeoutStagetRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12608777;
/*    */   public int seed;
/*    */   public int turn;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12608777;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynDoudouComeoutStagetRes() {}
/*    */   
/*    */ 
/*    */   public SSynDoudouComeoutStagetRes(int _seed_, int _turn_)
/*    */   {
/* 37 */     this.seed = _seed_;
/* 38 */     this.turn = _turn_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.seed);
/* 47 */     _os_.marshal(this.turn);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.seed = _os_.unmarshal_int();
/* 53 */     this.turn = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SSynDoudouComeoutStagetRes)) {
/* 63 */       SSynDoudouComeoutStagetRes _o_ = (SSynDoudouComeoutStagetRes)_o1_;
/* 64 */       if (this.seed != _o_.seed) return false;
/* 65 */       if (this.turn != _o_.turn) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.seed;
/* 74 */     _h_ += this.turn;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.seed).append(",");
/* 82 */     _sb_.append(this.turn).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSynDoudouComeoutStagetRes _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.seed - _o_.seed;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.turn - _o_.turn;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\hula\SSynDoudouComeoutStagetRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */