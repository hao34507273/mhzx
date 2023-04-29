/*    */ package mzm.gsp.luckystar;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class LuckyStarAwardInfo
/*    */   implements Marshal, Comparable<LuckyStarAwardInfo>
/*    */ {
/*    */   public int lucky_star_gift_cfg_id;
/*    */   public int has_buy_times;
/*    */   
/*    */   public LuckyStarAwardInfo() {}
/*    */   
/*    */   public LuckyStarAwardInfo(int _lucky_star_gift_cfg_id_, int _has_buy_times_)
/*    */   {
/* 18 */     this.lucky_star_gift_cfg_id = _lucky_star_gift_cfg_id_;
/* 19 */     this.has_buy_times = _has_buy_times_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.lucky_star_gift_cfg_id);
/* 28 */     _os_.marshal(this.has_buy_times);
/* 29 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 33 */     this.lucky_star_gift_cfg_id = _os_.unmarshal_int();
/* 34 */     this.has_buy_times = _os_.unmarshal_int();
/* 35 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 39 */     if (_o1_ == this) return true;
/* 40 */     if ((_o1_ instanceof LuckyStarAwardInfo)) {
/* 41 */       LuckyStarAwardInfo _o_ = (LuckyStarAwardInfo)_o1_;
/* 42 */       if (this.lucky_star_gift_cfg_id != _o_.lucky_star_gift_cfg_id) return false;
/* 43 */       if (this.has_buy_times != _o_.has_buy_times) return false;
/* 44 */       return true;
/*    */     }
/* 46 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 50 */     int _h_ = 0;
/* 51 */     _h_ += this.lucky_star_gift_cfg_id;
/* 52 */     _h_ += this.has_buy_times;
/* 53 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     StringBuilder _sb_ = new StringBuilder();
/* 58 */     _sb_.append("(");
/* 59 */     _sb_.append(this.lucky_star_gift_cfg_id).append(",");
/* 60 */     _sb_.append(this.has_buy_times).append(",");
/* 61 */     _sb_.append(")");
/* 62 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(LuckyStarAwardInfo _o_) {
/* 66 */     if (_o_ == this) return 0;
/* 67 */     int _c_ = 0;
/* 68 */     _c_ = this.lucky_star_gift_cfg_id - _o_.lucky_star_gift_cfg_id;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     _c_ = this.has_buy_times - _o_.has_buy_times;
/* 71 */     if (0 != _c_) return _c_;
/* 72 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\luckystar\LuckyStarAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */