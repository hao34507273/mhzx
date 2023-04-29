/*    */ package mzm.gsp.zoo;
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
/*    */ public class SEmbryoAddDaySuccess
/*    */   extends __SEmbryoAddDaySuccess__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12615425;
/*    */   public long animalid;
/*    */   public int last_time;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12615425;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public SEmbryoAddDaySuccess() {}
/*    */   
/*    */ 
/*    */   public SEmbryoAddDaySuccess(long _animalid_, int _last_time_)
/*    */   {
/* 37 */     this.animalid = _animalid_;
/* 38 */     this.last_time = _last_time_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 42 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 46 */     _os_.marshal(this.animalid);
/* 47 */     _os_.marshal(this.last_time);
/* 48 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 52 */     this.animalid = _os_.unmarshal_long();
/* 53 */     this.last_time = _os_.unmarshal_int();
/* 54 */     if (!_validator_()) {
/* 55 */       throw new VerifyError("validator failed");
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof SEmbryoAddDaySuccess)) {
/* 63 */       SEmbryoAddDaySuccess _o_ = (SEmbryoAddDaySuccess)_o1_;
/* 64 */       if (this.animalid != _o_.animalid) return false;
/* 65 */       if (this.last_time != _o_.last_time) return false;
/* 66 */       return true;
/*    */     }
/* 68 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 72 */     int _h_ = 0;
/* 73 */     _h_ += (int)this.animalid;
/* 74 */     _h_ += this.last_time;
/* 75 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder _sb_ = new StringBuilder();
/* 80 */     _sb_.append("(");
/* 81 */     _sb_.append(this.animalid).append(",");
/* 82 */     _sb_.append(this.last_time).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(SEmbryoAddDaySuccess _o_) {
/* 88 */     if (_o_ == this) return 0;
/* 89 */     int _c_ = 0;
/* 90 */     _c_ = Long.signum(this.animalid - _o_.animalid);
/* 91 */     if (0 != _c_) return _c_;
/* 92 */     _c_ = this.last_time - _o_.last_time;
/* 93 */     if (0 != _c_) return _c_;
/* 94 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\zoo\SEmbryoAddDaySuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */