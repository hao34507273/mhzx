/*    */ package mzm.gsp.qingfu;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class ReceiverGiftInfo implements Marshal, Comparable<ReceiverGiftInfo>
/*    */ {
/*    */   public int receive_available;
/*    */   public int sender2receiver_count;
/*    */   
/*    */   public ReceiverGiftInfo() {}
/*    */   
/*    */   public ReceiverGiftInfo(int _receive_available_, int _sender2receiver_count_)
/*    */   {
/* 16 */     this.receive_available = _receive_available_;
/* 17 */     this.sender2receiver_count = _sender2receiver_count_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 21 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 25 */     _os_.marshal(this.receive_available);
/* 26 */     _os_.marshal(this.sender2receiver_count);
/* 27 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 31 */     this.receive_available = _os_.unmarshal_int();
/* 32 */     this.sender2receiver_count = _os_.unmarshal_int();
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 37 */     if (_o1_ == this) return true;
/* 38 */     if ((_o1_ instanceof ReceiverGiftInfo)) {
/* 39 */       ReceiverGiftInfo _o_ = (ReceiverGiftInfo)_o1_;
/* 40 */       if (this.receive_available != _o_.receive_available) return false;
/* 41 */       if (this.sender2receiver_count != _o_.sender2receiver_count) return false;
/* 42 */       return true;
/*    */     }
/* 44 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 48 */     int _h_ = 0;
/* 49 */     _h_ += this.receive_available;
/* 50 */     _h_ += this.sender2receiver_count;
/* 51 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuilder _sb_ = new StringBuilder();
/* 56 */     _sb_.append("(");
/* 57 */     _sb_.append(this.receive_available).append(",");
/* 58 */     _sb_.append(this.sender2receiver_count).append(",");
/* 59 */     _sb_.append(")");
/* 60 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(ReceiverGiftInfo _o_) {
/* 64 */     if (_o_ == this) return 0;
/* 65 */     int _c_ = 0;
/* 66 */     _c_ = this.receive_available - _o_.receive_available;
/* 67 */     if (0 != _c_) return _c_;
/* 68 */     _c_ = this.sender2receiver_count - _o_.sender2receiver_count;
/* 69 */     if (0 != _c_) return _c_;
/* 70 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\qingfu\ReceiverGiftInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */