/*    */ package mzm.gsp.qingfu;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class MonthCardActivityInfo
/*    */   implements Marshal, Comparable<MonthCardActivityInfo>
/*    */ {
/*    */   public static final int STATUS_NOT_PURCHASE = 1;
/*    */   public static final int STATUS_TODAY_IS_AWARDED = 2;
/*    */   public static final int STATUS_TODAY_NOT_AWARDED = 3;
/*    */   public int phase;
/*    */   public byte status;
/*    */   public int remain_days;
/*    */   
/*    */   public MonthCardActivityInfo() {}
/*    */   
/*    */   public MonthCardActivityInfo(int _phase_, byte _status_, int _remain_days_)
/*    */   {
/* 21 */     this.phase = _phase_;
/* 22 */     this.status = _status_;
/* 23 */     this.remain_days = _remain_days_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 31 */     _os_.marshal(this.phase);
/* 32 */     _os_.marshal(this.status);
/* 33 */     _os_.marshal(this.remain_days);
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 38 */     this.phase = _os_.unmarshal_int();
/* 39 */     this.status = _os_.unmarshal_byte();
/* 40 */     this.remain_days = _os_.unmarshal_int();
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 45 */     if (_o1_ == this) return true;
/* 46 */     if ((_o1_ instanceof MonthCardActivityInfo)) {
/* 47 */       MonthCardActivityInfo _o_ = (MonthCardActivityInfo)_o1_;
/* 48 */       if (this.phase != _o_.phase) return false;
/* 49 */       if (this.status != _o_.status) return false;
/* 50 */       if (this.remain_days != _o_.remain_days) return false;
/* 51 */       return true;
/*    */     }
/* 53 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 57 */     int _h_ = 0;
/* 58 */     _h_ += this.phase;
/* 59 */     _h_ += this.status;
/* 60 */     _h_ += this.remain_days;
/* 61 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 65 */     StringBuilder _sb_ = new StringBuilder();
/* 66 */     _sb_.append("(");
/* 67 */     _sb_.append(this.phase).append(",");
/* 68 */     _sb_.append(this.status).append(",");
/* 69 */     _sb_.append(this.remain_days).append(",");
/* 70 */     _sb_.append(")");
/* 71 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(MonthCardActivityInfo _o_) {
/* 75 */     if (_o_ == this) return 0;
/* 76 */     int _c_ = 0;
/* 77 */     _c_ = this.phase - _o_.phase;
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     _c_ = this.status - _o_.status;
/* 80 */     if (0 != _c_) return _c_;
/* 81 */     _c_ = this.remain_days - _o_.remain_days;
/* 82 */     if (0 != _c_) return _c_;
/* 83 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\MonthCardActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */