/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class FriendsCircleDeleteGiveGiftHistoryReq
/*    */   implements Marshal, Comparable<FriendsCircleDeleteGiveGiftHistoryReq>
/*    */ {
/*    */   public long give_gift_role_id;
/*    */   public long receive_gift_role_id;
/*    */   public long give_gift_serial_id;
/*    */   
/*    */   public FriendsCircleDeleteGiveGiftHistoryReq() {}
/*    */   
/*    */   public FriendsCircleDeleteGiveGiftHistoryReq(long _give_gift_role_id_, long _receive_gift_role_id_, long _give_gift_serial_id_)
/*    */   {
/* 19 */     this.give_gift_role_id = _give_gift_role_id_;
/* 20 */     this.receive_gift_role_id = _receive_gift_role_id_;
/* 21 */     this.give_gift_serial_id = _give_gift_serial_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.give_gift_role_id);
/* 30 */     _os_.marshal(this.receive_gift_role_id);
/* 31 */     _os_.marshal(this.give_gift_serial_id);
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 36 */     this.give_gift_role_id = _os_.unmarshal_long();
/* 37 */     this.receive_gift_role_id = _os_.unmarshal_long();
/* 38 */     this.give_gift_serial_id = _os_.unmarshal_long();
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof FriendsCircleDeleteGiveGiftHistoryReq)) {
/* 45 */       FriendsCircleDeleteGiveGiftHistoryReq _o_ = (FriendsCircleDeleteGiveGiftHistoryReq)_o1_;
/* 46 */       if (this.give_gift_role_id != _o_.give_gift_role_id) return false;
/* 47 */       if (this.receive_gift_role_id != _o_.receive_gift_role_id) return false;
/* 48 */       if (this.give_gift_serial_id != _o_.give_gift_serial_id) return false;
/* 49 */       return true;
/*    */     }
/* 51 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 55 */     int _h_ = 0;
/* 56 */     _h_ += (int)this.give_gift_role_id;
/* 57 */     _h_ += (int)this.receive_gift_role_id;
/* 58 */     _h_ += (int)this.give_gift_serial_id;
/* 59 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     StringBuilder _sb_ = new StringBuilder();
/* 64 */     _sb_.append("(");
/* 65 */     _sb_.append(this.give_gift_role_id).append(",");
/* 66 */     _sb_.append(this.receive_gift_role_id).append(",");
/* 67 */     _sb_.append(this.give_gift_serial_id).append(",");
/* 68 */     _sb_.append(")");
/* 69 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(FriendsCircleDeleteGiveGiftHistoryReq _o_) {
/* 73 */     if (_o_ == this) return 0;
/* 74 */     int _c_ = 0;
/* 75 */     _c_ = Long.signum(this.give_gift_role_id - _o_.give_gift_role_id);
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = Long.signum(this.receive_gift_role_id - _o_.receive_gift_role_id);
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     _c_ = Long.signum(this.give_gift_serial_id - _o_.give_gift_serial_id);
/* 80 */     if (0 != _c_) return _c_;
/* 81 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\FriendsCircleDeleteGiveGiftHistoryReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */