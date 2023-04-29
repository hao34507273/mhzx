/*    */ package apollo;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ 
/*    */ public class GlobalRoomInfo implements Marshal, Comparable<GlobalRoomInfo>
/*    */ {
/*    */   public long room_id;
/*    */   public long room_gid;
/*    */   public long room_key;
/*    */   
/*    */   public GlobalRoomInfo() {}
/*    */   
/*    */   public GlobalRoomInfo(long _room_id_, long _room_gid_, long _room_key_)
/*    */   {
/* 17 */     this.room_id = _room_id_;
/* 18 */     this.room_gid = _room_gid_;
/* 19 */     this.room_key = _room_key_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 23 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 27 */     _os_.marshal(this.room_id);
/* 28 */     _os_.marshal(this.room_gid);
/* 29 */     _os_.marshal(this.room_key);
/* 30 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 34 */     this.room_id = _os_.unmarshal_long();
/* 35 */     this.room_gid = _os_.unmarshal_long();
/* 36 */     this.room_key = _os_.unmarshal_long();
/* 37 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 41 */     if (_o1_ == this) return true;
/* 42 */     if ((_o1_ instanceof GlobalRoomInfo)) {
/* 43 */       GlobalRoomInfo _o_ = (GlobalRoomInfo)_o1_;
/* 44 */       if (this.room_id != _o_.room_id) return false;
/* 45 */       if (this.room_gid != _o_.room_gid) return false;
/* 46 */       if (this.room_key != _o_.room_key) return false;
/* 47 */       return true;
/*    */     }
/* 49 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 53 */     int _h_ = 0;
/* 54 */     _h_ += (int)this.room_id;
/* 55 */     _h_ += (int)this.room_gid;
/* 56 */     _h_ += (int)this.room_key;
/* 57 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 61 */     StringBuilder _sb_ = new StringBuilder();
/* 62 */     _sb_.append("(");
/* 63 */     _sb_.append(this.room_id).append(",");
/* 64 */     _sb_.append(this.room_gid).append(",");
/* 65 */     _sb_.append(this.room_key).append(",");
/* 66 */     _sb_.append(")");
/* 67 */     return _sb_.toString();
/*    */   }
/*    */   
/*    */   public int compareTo(GlobalRoomInfo _o_) {
/* 71 */     if (_o_ == this) return 0;
/* 72 */     int _c_ = 0;
/* 73 */     _c_ = Long.signum(this.room_id - _o_.room_id);
/* 74 */     if (0 != _c_) return _c_;
/* 75 */     _c_ = Long.signum(this.room_gid - _o_.room_gid);
/* 76 */     if (0 != _c_) return _c_;
/* 77 */     _c_ = Long.signum(this.room_key - _o_.room_key);
/* 78 */     if (0 != _c_) return _c_;
/* 79 */     return _c_;
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\GlobalRoomInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */