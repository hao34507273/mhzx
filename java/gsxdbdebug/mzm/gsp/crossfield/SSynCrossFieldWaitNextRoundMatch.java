/*    */ package mzm.gsp.crossfield;
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
/*    */ public class SSynCrossFieldWaitNextRoundMatch
/*    */   extends __SSynCrossFieldWaitNextRoundMatch__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12619538;
/*    */   public static final int REASON_MATCH_ROLE_NOT_ENOUGH = 0;
/*    */   public static final int REASON_NO_ROAM_SERVER = 1;
/*    */   public static final int REASON_ROAM_SERVER_ROLE_TOO_MUCH = 2;
/*    */   public static final int REASON_MATCH_ROLE_TOO_MUCH = 3;
/*    */   public byte reason;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12619538;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSynCrossFieldWaitNextRoundMatch() {}
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SSynCrossFieldWaitNextRoundMatch(byte _reason_)
/*    */   {
/* 41 */     this.reason = _reason_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 45 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 49 */     _os_.marshal(this.reason);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.reason = _os_.unmarshal_byte();
/* 55 */     if (!_validator_()) {
/* 56 */       throw new VerifyError("validator failed");
/*    */     }
/* 58 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 62 */     if (_o1_ == this) return true;
/* 63 */     if ((_o1_ instanceof SSynCrossFieldWaitNextRoundMatch)) {
/* 64 */       SSynCrossFieldWaitNextRoundMatch _o_ = (SSynCrossFieldWaitNextRoundMatch)_o1_;
/* 65 */       if (this.reason != _o_.reason) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.reason;
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append(this.reason).append(",");
/* 81 */     _sb_.append(")");
/* 82 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSynCrossFieldWaitNextRoundMatch _o_) {
/* 86 */     if (_o_ == this) return 0;
/* 87 */     int _c_ = 0;
/* 88 */     _c_ = this.reason - _o_.reason;
/* 89 */     if (0 != _c_) return _c_;
/* 90 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossfield\SSynCrossFieldWaitNextRoundMatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */