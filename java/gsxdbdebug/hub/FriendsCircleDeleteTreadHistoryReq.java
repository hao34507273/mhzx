/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class FriendsCircleDeleteTreadHistoryReq
/*    */   implements Marshal, Comparable<FriendsCircleDeleteTreadHistoryReq>
/*    */ {
/*    */   public long tread_role_id;
/*    */   public long be_trod_role_id;
/*    */   public long tread_serial_id;
/*    */   
/*    */   public FriendsCircleDeleteTreadHistoryReq() {}
/*    */   
/*    */   public FriendsCircleDeleteTreadHistoryReq(long _tread_role_id_, long _be_trod_role_id_, long _tread_serial_id_)
/*    */   {
/* 19 */     this.tread_role_id = _tread_role_id_;
/* 20 */     this.be_trod_role_id = _be_trod_role_id_;
/* 21 */     this.tread_serial_id = _tread_serial_id_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 25 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 29 */     _os_.marshal(this.tread_role_id);
/* 30 */     _os_.marshal(this.be_trod_role_id);
/* 31 */     _os_.marshal(this.tread_serial_id);
/* 32 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 36 */     this.tread_role_id = _os_.unmarshal_long();
/* 37 */     this.be_trod_role_id = _os_.unmarshal_long();
/* 38 */     this.tread_serial_id = _os_.unmarshal_long();
/* 39 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 43 */     if (_o1_ == this) return true;
/* 44 */     if ((_o1_ instanceof FriendsCircleDeleteTreadHistoryReq)) {
/* 45 */       FriendsCircleDeleteTreadHistoryReq _o_ = (FriendsCircleDeleteTreadHistoryReq)_o1_;
/* 46 */       if (this.tread_role_id != _o_.tread_role_id) return false;
/* 47 */       if (this.be_trod_role_id != _o_.be_trod_role_id) return false;
/* 48 */       if (this.tread_serial_id != _o_.tread_serial_id) return false;
/* 49 */       return true;
/*    */     }
/* 51 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 55 */     int _h_ = 0;
/* 56 */     _h_ += (int)this.tread_role_id;
/* 57 */     _h_ += (int)this.be_trod_role_id;
/* 58 */     _h_ += (int)this.tread_serial_id;
/* 59 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     StringBuilder _sb_ = new StringBuilder();
/* 64 */     _sb_.append("(");
/* 65 */     _sb_.append(this.tread_role_id).append(",");
/* 66 */     _sb_.append(this.be_trod_role_id).append(",");
/* 67 */     _sb_.append(this.tread_serial_id).append(",");
/* 68 */     _sb_.append(")");
/* 69 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(FriendsCircleDeleteTreadHistoryReq _o_) {
/* 73 */     if (_o_ == this) return 0;
/* 74 */     int _c_ = 0;
/* 75 */     _c_ = Long.signum(this.tread_role_id - _o_.tread_role_id);
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = Long.signum(this.be_trod_role_id - _o_.be_trod_role_id);
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     _c_ = Long.signum(this.tread_serial_id - _o_.tread_serial_id);
/* 80 */     if (0 != _c_) return _c_;
/* 81 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\FriendsCircleDeleteTreadHistoryReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */