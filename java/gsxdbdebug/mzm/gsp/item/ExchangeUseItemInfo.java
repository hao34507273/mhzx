/*    */ package mzm.gsp.item;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class ExchangeUseItemInfo implements Marshal, Comparable<ExchangeUseItemInfo>
/*    */ {
/*    */   public int exchange_times;
/*    */   public int daily_exchange_times;
/*    */   
/*    */   public ExchangeUseItemInfo() {}
/*    */   
/*    */   public ExchangeUseItemInfo(int _exchange_times_, int _daily_exchange_times_)
/*    */   {
/* 16 */     this.exchange_times = _exchange_times_;
/* 17 */     this.daily_exchange_times = _daily_exchange_times_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     _os_.marshal(this.exchange_times);
/* 26 */     _os_.marshal(this.daily_exchange_times);
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 31 */     this.exchange_times = _os_.unmarshal_int();
/* 32 */     this.daily_exchange_times = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 37 */     if (_o1_ == this) return true;
/* 38 */     if ((_o1_ instanceof ExchangeUseItemInfo)) {
/* 39 */       ExchangeUseItemInfo _o_ = (ExchangeUseItemInfo)_o1_;
/* 40 */       if (this.exchange_times != _o_.exchange_times) return false;
/* 41 */       if (this.daily_exchange_times != _o_.daily_exchange_times) return false;
/* 42 */       return true;
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 48 */     int _h_ = 0;
/* 49 */     _h_ += this.exchange_times;
/* 50 */     _h_ += this.daily_exchange_times;
/* 51 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuilder _sb_ = new StringBuilder();
/* 56 */     _sb_.append("(");
/* 57 */     _sb_.append(this.exchange_times).append(",");
/* 58 */     _sb_.append(this.daily_exchange_times).append(",");
/* 59 */     _sb_.append(")");
/* 60 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ExchangeUseItemInfo _o_) {
/* 64 */     if (_o_ == this) return 0;
/* 65 */     int _c_ = 0;
/* 66 */     _c_ = this.exchange_times - _o_.exchange_times;
/* 67 */     if (0 != _c_) return _c_;
/* 68 */     _c_ = this.daily_exchange_times - _o_.daily_exchange_times;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\ExchangeUseItemInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */