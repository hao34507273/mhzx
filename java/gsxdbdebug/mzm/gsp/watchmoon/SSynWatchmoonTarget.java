/*    */ package mzm.gsp.watchmoon;
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
/*    */ public class SSynWatchmoonTarget
/*    */   extends __SSynWatchmoonTarget__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12600848;
/*    */   public long partnerroleid;
/*    */   public long endtime;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12600848;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSynWatchmoonTarget() {}
/*    */   
/*    */ 
/*    */   public SSynWatchmoonTarget(long _partnerroleid_, long _endtime_)
/*    */   {
/* 37 */     this.partnerroleid = _partnerroleid_;
/* 38 */     this.endtime = _endtime_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.partnerroleid);
/* 47 */     _os_.marshal(this.endtime);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.partnerroleid = _os_.unmarshal_long();
/* 53 */     this.endtime = _os_.unmarshal_long();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SSynWatchmoonTarget)) {
/* 63 */       SSynWatchmoonTarget _o_ = (SSynWatchmoonTarget)_o1_;
/* 64 */       if (this.partnerroleid != _o_.partnerroleid) return false;
/* 65 */       if (this.endtime != _o_.endtime) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.partnerroleid;
/* 74 */     _h_ += (int)this.endtime;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.partnerroleid).append(",");
/* 82 */     _sb_.append(this.endtime).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSynWatchmoonTarget _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.partnerroleid - _o_.partnerroleid);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = Long.signum(this.endtime - _o_.endtime);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\watchmoon\SSynWatchmoonTarget.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */