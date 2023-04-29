/*    */ package apollo;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class SpeakerStatusInfo implements Marshal
/*    */ {
/*    */   public Octets account;
/*    */   public int room_type;
/*    */   public byte is_open_mic;
/*    */   public byte online_status;
/*    */   
/*    */   public SpeakerStatusInfo()
/*    */   {
/* 17 */     this.account = new Octets();
/*    */   }
/*    */   
/*    */   public SpeakerStatusInfo(Octets _account_, int _room_type_, byte _is_open_mic_, byte _online_status_) {
/* 21 */     this.account = _account_;
/* 22 */     this.room_type = _room_type_;
/* 23 */     this.is_open_mic = _is_open_mic_;
/* 24 */     this.online_status = _online_status_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 28 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 32 */     _os_.marshal(this.account);
/* 33 */     _os_.marshal(this.room_type);
/* 34 */     _os_.marshal(this.is_open_mic);
/* 35 */     _os_.marshal(this.online_status);
/* 36 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 40 */     this.account = _os_.unmarshal_Octets();
/* 41 */     this.room_type = _os_.unmarshal_int();
/* 42 */     this.is_open_mic = _os_.unmarshal_byte();
/* 43 */     this.online_status = _os_.unmarshal_byte();
/* 44 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 48 */     if (_o1_ == this) return true;
/* 49 */     if ((_o1_ instanceof SpeakerStatusInfo)) {
/* 50 */       SpeakerStatusInfo _o_ = (SpeakerStatusInfo)_o1_;
/* 51 */       if (!this.account.equals(_o_.account)) return false;
/* 52 */       if (this.room_type != _o_.room_type) return false;
/* 53 */       if (this.is_open_mic != _o_.is_open_mic) return false;
/* 54 */       if (this.online_status != _o_.online_status) return false;
/* 55 */       return true;
/*    */     }
/* 57 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 61 */     int _h_ = 0;
/* 62 */     _h_ += this.account.hashCode();
/* 63 */     _h_ += this.room_type;
/* 64 */     _h_ += this.is_open_mic;
/* 65 */     _h_ += this.online_status;
/* 66 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 70 */     StringBuilder _sb_ = new StringBuilder();
/* 71 */     _sb_.append("(");
/* 72 */     _sb_.append("B").append(this.account.size()).append(",");
/* 73 */     _sb_.append(this.room_type).append(",");
/* 74 */     _sb_.append(this.is_open_mic).append(",");
/* 75 */     _sb_.append(this.online_status).append(",");
/* 76 */     _sb_.append(")");
/* 77 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\SpeakerStatusInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */