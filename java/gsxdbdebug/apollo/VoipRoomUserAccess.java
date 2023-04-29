/*    */ package apollo;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class VoipRoomUserAccess implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public Octets open_id;
/*    */   public int member_id;
/*    */   public long room_key;
/*    */   public long extra_data;
/*    */   public java.util.LinkedList<Octets> access_ip_list;
/*    */   
/*    */   public VoipRoomUserAccess()
/*    */   {
/* 16 */     this.open_id = new Octets();
/* 17 */     this.member_id = 0;
/* 18 */     this.room_key = 0L;
/* 19 */     this.extra_data = 0L;
/* 20 */     this.access_ip_list = new java.util.LinkedList();
/*    */   }
/*    */   
/*    */   public VoipRoomUserAccess(Octets _open_id_, int _member_id_, long _room_key_, long _extra_data_, java.util.LinkedList<Octets> _access_ip_list_) {
/* 24 */     this.open_id = _open_id_;
/* 25 */     this.member_id = _member_id_;
/* 26 */     this.room_key = _room_key_;
/* 27 */     this.extra_data = _extra_data_;
/* 28 */     this.access_ip_list = _access_ip_list_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 36 */     _os_.marshal(this.open_id);
/* 37 */     _os_.marshal(this.member_id);
/* 38 */     _os_.marshal(this.room_key);
/* 39 */     _os_.marshal(this.extra_data);
/* 40 */     _os_.compact_uint32(this.access_ip_list.size());
/* 41 */     for (Octets _v_ : this.access_ip_list) {
/* 42 */       _os_.marshal(_v_);
/*    */     }
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 48 */     this.open_id = _os_.unmarshal_Octets();
/* 49 */     this.member_id = _os_.unmarshal_int();
/* 50 */     this.room_key = _os_.unmarshal_long();
/* 51 */     this.extra_data = _os_.unmarshal_long();
/* 52 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*    */     {
/* 54 */       Octets _v_ = _os_.unmarshal_Octets();
/* 55 */       this.access_ip_list.add(_v_);
/*    */     }
/* 57 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 61 */     if (_o1_ == this) return true;
/* 62 */     if ((_o1_ instanceof VoipRoomUserAccess)) {
/* 63 */       VoipRoomUserAccess _o_ = (VoipRoomUserAccess)_o1_;
/* 64 */       if (!this.open_id.equals(_o_.open_id)) return false;
/* 65 */       if (this.member_id != _o_.member_id) return false;
/* 66 */       if (this.room_key != _o_.room_key) return false;
/* 67 */       if (this.extra_data != _o_.extra_data) return false;
/* 68 */       if (!this.access_ip_list.equals(_o_.access_ip_list)) return false;
/* 69 */       return true;
/*    */     }
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 75 */     int _h_ = 0;
/* 76 */     _h_ += this.open_id.hashCode();
/* 77 */     _h_ += this.member_id;
/* 78 */     _h_ += (int)this.room_key;
/* 79 */     _h_ += (int)this.extra_data;
/* 80 */     _h_ += this.access_ip_list.hashCode();
/* 81 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuilder _sb_ = new StringBuilder();
/* 86 */     _sb_.append("(");
/* 87 */     _sb_.append("B").append(this.open_id.size()).append(",");
/* 88 */     _sb_.append(this.member_id).append(",");
/* 89 */     _sb_.append(this.room_key).append(",");
/* 90 */     _sb_.append(this.extra_data).append(",");
/* 91 */     _sb_.append(this.access_ip_list).append(",");
/* 92 */     _sb_.append(")");
/* 93 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\VoipRoomUserAccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */