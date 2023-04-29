/*    */ package mzm.gsp.qingfu;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class RMBGiftBagTierInfo implements Marshal, Comparable<RMBGiftBagTierInfo>
/*    */ {
/*    */   public int buy_times;
/*    */   public int award_times;
/*    */   public long award_timestamp;
/*    */   
/*    */   public RMBGiftBagTierInfo()
/*    */   {
/* 14 */     this.buy_times = 0;
/* 15 */     this.award_times = 0;
/* 16 */     this.award_timestamp = 0L;
/*    */   }
/*    */   
/*    */   public RMBGiftBagTierInfo(int _buy_times_, int _award_times_, long _award_timestamp_) {
/* 20 */     this.buy_times = _buy_times_;
/* 21 */     this.award_times = _award_times_;
/* 22 */     this.award_timestamp = _award_timestamp_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.marshal(this.buy_times);
/* 31 */     _os_.marshal(this.award_times);
/* 32 */     _os_.marshal(this.award_timestamp);
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 37 */     this.buy_times = _os_.unmarshal_int();
/* 38 */     this.award_times = _os_.unmarshal_int();
/* 39 */     this.award_timestamp = _os_.unmarshal_long();
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 44 */     if (_o1_ == this) return true;
/* 45 */     if ((_o1_ instanceof RMBGiftBagTierInfo)) {
/* 46 */       RMBGiftBagTierInfo _o_ = (RMBGiftBagTierInfo)_o1_;
/* 47 */       if (this.buy_times != _o_.buy_times) return false;
/* 48 */       if (this.award_times != _o_.award_times) return false;
/* 49 */       if (this.award_timestamp != _o_.award_timestamp) return false;
/* 50 */       return true;
/*    */     }
/* 52 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 56 */     int _h_ = 0;
/* 57 */     _h_ += this.buy_times;
/* 58 */     _h_ += this.award_times;
/* 59 */     _h_ += (int)this.award_timestamp;
/* 60 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 64 */     StringBuilder _sb_ = new StringBuilder();
/* 65 */     _sb_.append("(");
/* 66 */     _sb_.append(this.buy_times).append(",");
/* 67 */     _sb_.append(this.award_times).append(",");
/* 68 */     _sb_.append(this.award_timestamp).append(",");
/* 69 */     _sb_.append(")");
/* 70 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(RMBGiftBagTierInfo _o_) {
/* 74 */     if (_o_ == this) return 0;
/* 75 */     int _c_ = 0;
/* 76 */     _c_ = this.buy_times - _o_.buy_times;
/* 77 */     if (0 != _c_) return _c_;
/* 78 */     _c_ = this.award_times - _o_.award_times;
/* 79 */     if (0 != _c_) return _c_;
/* 80 */     _c_ = Long.signum(this.award_timestamp - _o_.award_timestamp);
/* 81 */     if (0 != _c_) return _c_;
/* 82 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\RMBGiftBagTierInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */