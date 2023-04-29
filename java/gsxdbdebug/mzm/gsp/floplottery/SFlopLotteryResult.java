/*    */ package mzm.gsp.floplottery;
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
/*    */ public class SFlopLotteryResult
/*    */   extends __SFlopLotteryResult__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12618497;
/*    */   public long uid;
/*    */   public FlopLotteryResult floplotteryresult;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12618497;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SFlopLotteryResult()
/*    */   {
/* 34 */     this.floplotteryresult = new FlopLotteryResult();
/*    */   }
/*    */   
/*    */   public SFlopLotteryResult(long _uid_, FlopLotteryResult _floplotteryresult_) {
/* 38 */     this.uid = _uid_;
/* 39 */     this.floplotteryresult = _floplotteryresult_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 43 */     if (!this.floplotteryresult._validator_()) return false;
/* 44 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 48 */     _os_.marshal(this.uid);
/* 49 */     _os_.marshal(this.floplotteryresult);
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 54 */     this.uid = _os_.unmarshal_long();
/* 55 */     this.floplotteryresult.unmarshal(_os_);
/* 56 */     if (!_validator_()) {
/* 57 */       throw new VerifyError("validator failed");
/*    */     }
/* 59 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 63 */     if (_o1_ == this) return true;
/* 64 */     if ((_o1_ instanceof SFlopLotteryResult)) {
/* 65 */       SFlopLotteryResult _o_ = (SFlopLotteryResult)_o1_;
/* 66 */       if (this.uid != _o_.uid) return false;
/* 67 */       if (!this.floplotteryresult.equals(_o_.floplotteryresult)) return false;
/* 68 */       return true;
/*    */     }
/* 70 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 74 */     int _h_ = 0;
/* 75 */     _h_ += (int)this.uid;
/* 76 */     _h_ += this.floplotteryresult.hashCode();
/* 77 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 81 */     StringBuilder _sb_ = new StringBuilder();
/* 82 */     _sb_.append("(");
/* 83 */     _sb_.append(this.uid).append(",");
/* 84 */     _sb_.append(this.floplotteryresult).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\floplottery\SFlopLotteryResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */