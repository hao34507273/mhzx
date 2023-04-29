/*    */ package hub;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ 
/*    */ public class FriendsCircleTreadReq
/*    */   implements Marshal, Comparable<FriendsCircleTreadReq>
/*    */ {
/*    */   public long active_tread_role_id;
/*    */   public long be_trod_role_id;
/*    */   public byte is_can_get_more_treasure_box;
/*    */   public long tread_serial_id;
/*    */   public byte is_auto_tread;
/*    */   
/*    */   public FriendsCircleTreadReq() {}
/*    */   
/*    */   public FriendsCircleTreadReq(long _active_tread_role_id_, long _be_trod_role_id_, byte _is_can_get_more_treasure_box_, long _tread_serial_id_, byte _is_auto_tread_)
/*    */   {
/* 21 */     this.active_tread_role_id = _active_tread_role_id_;
/* 22 */     this.be_trod_role_id = _be_trod_role_id_;
/* 23 */     this.is_can_get_more_treasure_box = _is_can_get_more_treasure_box_;
/* 24 */     this.tread_serial_id = _tread_serial_id_;
/* 25 */     this.is_auto_tread = _is_auto_tread_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 29 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 33 */     _os_.marshal(this.active_tread_role_id);
/* 34 */     _os_.marshal(this.be_trod_role_id);
/* 35 */     _os_.marshal(this.is_can_get_more_treasure_box);
/* 36 */     _os_.marshal(this.tread_serial_id);
/* 37 */     _os_.marshal(this.is_auto_tread);
/* 38 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 42 */     this.active_tread_role_id = _os_.unmarshal_long();
/* 43 */     this.be_trod_role_id = _os_.unmarshal_long();
/* 44 */     this.is_can_get_more_treasure_box = _os_.unmarshal_byte();
/* 45 */     this.tread_serial_id = _os_.unmarshal_long();
/* 46 */     this.is_auto_tread = _os_.unmarshal_byte();
/* 47 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 51 */     if (_o1_ == this) return true;
/* 52 */     if ((_o1_ instanceof FriendsCircleTreadReq)) {
/* 53 */       FriendsCircleTreadReq _o_ = (FriendsCircleTreadReq)_o1_;
/* 54 */       if (this.active_tread_role_id != _o_.active_tread_role_id) return false;
/* 55 */       if (this.be_trod_role_id != _o_.be_trod_role_id) return false;
/* 56 */       if (this.is_can_get_more_treasure_box != _o_.is_can_get_more_treasure_box) return false;
/* 57 */       if (this.tread_serial_id != _o_.tread_serial_id) return false;
/* 58 */       if (this.is_auto_tread != _o_.is_auto_tread) return false;
/* 59 */       return true;
/*    */     }
/* 61 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 65 */     int _h_ = 0;
/* 66 */     _h_ += (int)this.active_tread_role_id;
/* 67 */     _h_ += (int)this.be_trod_role_id;
/* 68 */     _h_ += this.is_can_get_more_treasure_box;
/* 69 */     _h_ += (int)this.tread_serial_id;
/* 70 */     _h_ += this.is_auto_tread;
/* 71 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 75 */     StringBuilder _sb_ = new StringBuilder();
/* 76 */     _sb_.append("(");
/* 77 */     _sb_.append(this.active_tread_role_id).append(",");
/* 78 */     _sb_.append(this.be_trod_role_id).append(",");
/* 79 */     _sb_.append(this.is_can_get_more_treasure_box).append(",");
/* 80 */     _sb_.append(this.tread_serial_id).append(",");
/* 81 */     _sb_.append(this.is_auto_tread).append(",");
/* 82 */     _sb_.append(")");
/* 83 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(FriendsCircleTreadReq _o_) {
/* 87 */     if (_o_ == this) return 0;
/* 88 */     int _c_ = 0;
/* 89 */     _c_ = Long.signum(this.active_tread_role_id - _o_.active_tread_role_id);
/* 90 */     if (0 != _c_) return _c_;
/* 91 */     _c_ = Long.signum(this.be_trod_role_id - _o_.be_trod_role_id);
/* 92 */     if (0 != _c_) return _c_;
/* 93 */     _c_ = this.is_can_get_more_treasure_box - _o_.is_can_get_more_treasure_box;
/* 94 */     if (0 != _c_) return _c_;
/* 95 */     _c_ = Long.signum(this.tread_serial_id - _o_.tread_serial_id);
/* 96 */     if (0 != _c_) return _c_;
/* 97 */     _c_ = this.is_auto_tread - _o_.is_auto_tread;
/* 98 */     if (0 != _c_) return _c_;
/* 99 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\FriendsCircleTreadReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */