/*    */ package apollo;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class VoipRoomUser implements com.goldhuman.Common.Marshal.Marshal
/*    */ {
/*    */   public Octets open_id;
/*    */   public Octets client_ip;
/*    */   public int net_type;
/*    */   
/*    */   public VoipRoomUser()
/*    */   {
/* 14 */     this.open_id = new Octets();
/* 15 */     this.client_ip = new Octets();
/* 16 */     this.net_type = 0;
/*    */   }
/*    */   
/*    */   public VoipRoomUser(Octets _open_id_, Octets _client_ip_, int _net_type_) {
/* 20 */     this.open_id = _open_id_;
/* 21 */     this.client_ip = _client_ip_;
/* 22 */     this.net_type = _net_type_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 30 */     _os_.marshal(this.open_id);
/* 31 */     _os_.marshal(this.client_ip);
/* 32 */     _os_.marshal(this.net_type);
/* 33 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/* 37 */     this.open_id = _os_.unmarshal_Octets();
/* 38 */     this.client_ip = _os_.unmarshal_Octets();
/* 39 */     this.net_type = _os_.unmarshal_int();
/* 40 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 44 */     if (_o1_ == this) return true;
/* 45 */     if ((_o1_ instanceof VoipRoomUser)) {
/* 46 */       VoipRoomUser _o_ = (VoipRoomUser)_o1_;
/* 47 */       if (!this.open_id.equals(_o_.open_id)) return false;
/* 48 */       if (!this.client_ip.equals(_o_.client_ip)) return false;
/* 49 */       if (this.net_type != _o_.net_type) return false;
/* 50 */       return true;
/*    */     }
/* 52 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 56 */     int _h_ = 0;
/* 57 */     _h_ += this.open_id.hashCode();
/* 58 */     _h_ += this.client_ip.hashCode();
/* 59 */     _h_ += this.net_type;
/* 60 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 64 */     StringBuilder _sb_ = new StringBuilder();
/* 65 */     _sb_.append("(");
/* 66 */     _sb_.append("B").append(this.open_id.size()).append(",");
/* 67 */     _sb_.append("B").append(this.client_ip.size()).append(",");
/* 68 */     _sb_.append(this.net_type).append(",");
/* 69 */     _sb_.append(")");
/* 70 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\VoipRoomUser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */