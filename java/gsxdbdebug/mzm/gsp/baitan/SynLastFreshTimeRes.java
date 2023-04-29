/*    */ package mzm.gsp.baitan;
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
/*    */ public class SynLastFreshTimeRes
/*    */   extends __SynLastFreshTimeRes__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12584996;
/*    */   public long lastfreshtime;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 25 */     return 12584996;
/*    */   }
/*    */   
/*    */ 
/*    */   public SynLastFreshTimeRes() {}
/*    */   
/*    */ 
/*    */   public SynLastFreshTimeRes(long _lastfreshtime_)
/*    */   {
/* 34 */     this.lastfreshtime = _lastfreshtime_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 38 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 42 */     _os_.marshal(this.lastfreshtime);
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 47 */     this.lastfreshtime = _os_.unmarshal_long();
/* 48 */     if (!_validator_()) {
/* 49 */       throw new VerifyError("validator failed");
/*    */     }
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 55 */     if (_o1_ == this) return true;
/* 56 */     if ((_o1_ instanceof SynLastFreshTimeRes)) {
/* 57 */       SynLastFreshTimeRes _o_ = (SynLastFreshTimeRes)_o1_;
/* 58 */       if (this.lastfreshtime != _o_.lastfreshtime) return false;
/* 59 */       return true;
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 65 */     int _h_ = 0;
/* 66 */     _h_ += (int)this.lastfreshtime;
/* 67 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 71 */     StringBuilder _sb_ = new StringBuilder();
/* 72 */     _sb_.append("(");
/* 73 */     _sb_.append(this.lastfreshtime).append(",");
/* 74 */     _sb_.append(")");
/* 75 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SynLastFreshTimeRes _o_) {
/* 79 */     if (_o_ == this) return 0;
/* 80 */     int _c_ = 0;
/* 81 */     _c_ = Long.signum(this.lastfreshtime - _o_.lastfreshtime);
/* 82 */     if (0 != _c_) return _c_;
/* 83 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\SynLastFreshTimeRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */