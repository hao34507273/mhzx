/*    */ package mzm.gsp.backgame;
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
/*    */ public class SGetBackScoreAwardInfo
/*    */   extends __SGetBackScoreAwardInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12604425;
/*    */   public int exp_value;
/*    */   public long silver_value;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12604425;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SGetBackScoreAwardInfo() {}
/*    */   
/*    */ 
/*    */   public SGetBackScoreAwardInfo(int _exp_value_, long _silver_value_)
/*    */   {
/* 37 */     this.exp_value = _exp_value_;
/* 38 */     this.silver_value = _silver_value_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.exp_value);
/* 47 */     _os_.marshal(this.silver_value);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.exp_value = _os_.unmarshal_int();
/* 53 */     this.silver_value = _os_.unmarshal_long();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SGetBackScoreAwardInfo)) {
/* 63 */       SGetBackScoreAwardInfo _o_ = (SGetBackScoreAwardInfo)_o1_;
/* 64 */       if (this.exp_value != _o_.exp_value) return false;
/* 65 */       if (this.silver_value != _o_.silver_value) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += this.exp_value;
/* 74 */     _h_ += (int)this.silver_value;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.exp_value).append(",");
/* 82 */     _sb_.append(this.silver_value).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SGetBackScoreAwardInfo _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = this.exp_value - _o_.exp_value;
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = Long.signum(this.silver_value - _o_.silver_value);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\backgame\SGetBackScoreAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */