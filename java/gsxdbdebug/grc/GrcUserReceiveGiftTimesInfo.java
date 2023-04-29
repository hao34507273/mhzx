/*    */ package grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class GrcUserReceiveGiftTimesInfo implements Marshal, Comparable<GrcUserReceiveGiftTimesInfo>
/*    */ {
/*    */   public int gift_type;
/*    */   public int today_receive_times;
/*    */   
/*    */   public GrcUserReceiveGiftTimesInfo()
/*    */   {
/* 13 */     this.gift_type = 1;
/*    */   }
/*    */   
/*    */   public GrcUserReceiveGiftTimesInfo(int _gift_type_, int _today_receive_times_) {
/* 17 */     this.gift_type = _gift_type_;
/* 18 */     this.today_receive_times = _today_receive_times_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 26 */     _os_.marshal(this.gift_type);
/* 27 */     _os_.marshal(this.today_receive_times);
/* 28 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 32 */     this.gift_type = _os_.unmarshal_int();
/* 33 */     this.today_receive_times = _os_.unmarshal_int();
/* 34 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 38 */     if (_o1_ == this) return true;
/* 39 */     if ((_o1_ instanceof GrcUserReceiveGiftTimesInfo)) {
/* 40 */       GrcUserReceiveGiftTimesInfo _o_ = (GrcUserReceiveGiftTimesInfo)_o1_;
/* 41 */       if (this.gift_type != _o_.gift_type) return false;
/* 42 */       if (this.today_receive_times != _o_.today_receive_times) return false;
/* 43 */       return true;
/*    */     }
/* 45 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 49 */     int _h_ = 0;
/* 50 */     _h_ += this.gift_type;
/* 51 */     _h_ += this.today_receive_times;
/* 52 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 56 */     StringBuilder _sb_ = new StringBuilder();
/* 57 */     _sb_.append("(");
/* 58 */     _sb_.append(this.gift_type).append(",");
/* 59 */     _sb_.append(this.today_receive_times).append(",");
/* 60 */     _sb_.append(")");
/* 61 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(GrcUserReceiveGiftTimesInfo _o_) {
/* 65 */     if (_o_ == this) return 0;
/* 66 */     int _c_ = 0;
/* 67 */     _c_ = this.gift_type - _o_.gift_type;
/* 68 */     if (0 != _c_) return _c_;
/* 69 */     _c_ = this.today_receive_times - _o_.today_receive_times;
/* 70 */     if (0 != _c_) return _c_;
/* 71 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\grc\GrcUserReceiveGiftTimesInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */