/*    */ package mzm.gsp.grc;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class GrcUserReceiveGiftTimesInfo implements Marshal, Comparable<GrcUserReceiveGiftTimesInfo>
/*    */ {
/*    */   public int gift_type;
/*    */   public int today_receive_times;
/*    */   
/*    */   public GrcUserReceiveGiftTimesInfo() {}
/*    */   
/*    */   public GrcUserReceiveGiftTimesInfo(int _gift_type_, int _today_receive_times_)
/*    */   {
/* 16 */     this.gift_type = _gift_type_;
/* 17 */     this.today_receive_times = _today_receive_times_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     _os_.marshal(this.gift_type);
/* 26 */     _os_.marshal(this.today_receive_times);
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 31 */     this.gift_type = _os_.unmarshal_int();
/* 32 */     this.today_receive_times = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 37 */     if (_o1_ == this) return true;
/* 38 */     if ((_o1_ instanceof GrcUserReceiveGiftTimesInfo)) {
/* 39 */       GrcUserReceiveGiftTimesInfo _o_ = (GrcUserReceiveGiftTimesInfo)_o1_;
/* 40 */       if (this.gift_type != _o_.gift_type) return false;
/* 41 */       if (this.today_receive_times != _o_.today_receive_times) return false;
/* 42 */       return true;
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 48 */     int _h_ = 0;
/* 49 */     _h_ += this.gift_type;
/* 50 */     _h_ += this.today_receive_times;
/* 51 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuilder _sb_ = new StringBuilder();
/* 56 */     _sb_.append("(");
/* 57 */     _sb_.append(this.gift_type).append(",");
/* 58 */     _sb_.append(this.today_receive_times).append(",");
/* 59 */     _sb_.append(")");
/* 60 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(GrcUserReceiveGiftTimesInfo _o_) {
/* 64 */     if (_o_ == this) return 0;
/* 65 */     int _c_ = 0;
/* 66 */     _c_ = this.gift_type - _o_.gift_type;
/* 67 */     if (0 != _c_) return _c_;
/* 68 */     _c_ = this.today_receive_times - _o_.today_receive_times;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\grc\GrcUserReceiveGiftTimesInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */