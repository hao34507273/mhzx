/*    */ package mzm.gsp.fight;
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
/*    */ public class SSyncRealtimeRecordRoundInfo
/*    */   extends __SSyncRealtimeRecordRoundInfo__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12594223;
/*    */   public long recordid;
/*    */   public int round;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12594223;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SSyncRealtimeRecordRoundInfo() {}
/*    */   
/*    */ 
/*    */   public SSyncRealtimeRecordRoundInfo(long _recordid_, int _round_)
/*    */   {
/* 37 */     this.recordid = _recordid_;
/* 38 */     this.round = _round_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.recordid);
/* 47 */     _os_.marshal(this.round);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.recordid = _os_.unmarshal_long();
/* 53 */     this.round = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SSyncRealtimeRecordRoundInfo)) {
/* 63 */       SSyncRealtimeRecordRoundInfo _o_ = (SSyncRealtimeRecordRoundInfo)_o1_;
/* 64 */       if (this.recordid != _o_.recordid) return false;
/* 65 */       if (this.round != _o_.round) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.recordid;
/* 74 */     _h_ += this.round;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.recordid).append(",");
/* 82 */     _sb_.append(this.round).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SSyncRealtimeRecordRoundInfo _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.recordid - _o_.recordid);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.round - _o_.round;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\SSyncRealtimeRecordRoundInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */