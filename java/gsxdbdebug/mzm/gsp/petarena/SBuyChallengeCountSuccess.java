/*    */ package mzm.gsp.petarena;
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
/*    */ public class SBuyChallengeCountSuccess
/*    */   extends __SBuyChallengeCountSuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12628236;
/*    */   public int challenge_count;
/*    */   public int buy_count;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12628236;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SBuyChallengeCountSuccess() {}
/*    */   
/*    */ 
/*    */   public SBuyChallengeCountSuccess(int _challenge_count_, int _buy_count_)
/*    */   {
/* 37 */     this.challenge_count = _challenge_count_;
/* 38 */     this.buy_count = _buy_count_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.challenge_count);
/* 47 */     _os_.marshal(this.buy_count);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.challenge_count = _os_.unmarshal_int();
/* 53 */     this.buy_count = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SBuyChallengeCountSuccess)) {
/* 63 */       SBuyChallengeCountSuccess _o_ = (SBuyChallengeCountSuccess)_o1_;
/* 64 */       if (this.challenge_count != _o_.challenge_count) return false;
/* 65 */       if (this.buy_count != _o_.buy_count) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.challenge_count;
/* 74 */     _h_ += this.buy_count;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.challenge_count).append(",");
/* 82 */     _sb_.append(this.buy_count).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SBuyChallengeCountSuccess _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.challenge_count - _o_.challenge_count;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.buy_count - _o_.buy_count;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\SBuyChallengeCountSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */