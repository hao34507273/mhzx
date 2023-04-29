/*    */ package mzm.gsp.drawandguess;
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
/*    */ public class SNotifyDrawAndGuessInvite
/*    */   extends __SNotifyDrawAndGuessInvite__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12617233;
/*    */   public long timestamp;
/*    */   public long sessionid;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12617233;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SNotifyDrawAndGuessInvite() {}
/*    */   
/*    */ 
/*    */   public SNotifyDrawAndGuessInvite(long _timestamp_, long _sessionid_)
/*    */   {
/* 37 */     this.timestamp = _timestamp_;
/* 38 */     this.sessionid = _sessionid_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.timestamp);
/* 47 */     _os_.marshal(this.sessionid);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.timestamp = _os_.unmarshal_long();
/* 53 */     this.sessionid = _os_.unmarshal_long();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SNotifyDrawAndGuessInvite)) {
/* 63 */       SNotifyDrawAndGuessInvite _o_ = (SNotifyDrawAndGuessInvite)_o1_;
/* 64 */       if (this.timestamp != _o_.timestamp) return false;
/* 65 */       if (this.sessionid != _o_.sessionid) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.timestamp;
/* 74 */     _h_ += (int)this.sessionid;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.timestamp).append(",");
/* 82 */     _sb_.append(this.sessionid).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SNotifyDrawAndGuessInvite _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.timestamp - _o_.timestamp);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = Long.signum(this.sessionid - _o_.sessionid);
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawandguess\SNotifyDrawAndGuessInvite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */