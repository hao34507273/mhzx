/*    */ package apollo;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class ReportSpeakerMicStatusArg implements Marshal
/*    */ {
/*    */   public Octets account;
/*    */   public int room_type;
/*    */   public byte is_open_mic;
/*    */   public int reserved1;
/*    */   public int reserved2;
/*    */   
/*    */   public ReportSpeakerMicStatusArg()
/*    */   {
/* 18 */     this.account = new Octets();
/* 19 */     this.reserved1 = 0;
/* 20 */     this.reserved2 = 0;
/*    */   }
/*    */   
/*    */   public ReportSpeakerMicStatusArg(Octets _account_, int _room_type_, byte _is_open_mic_, int _reserved1_, int _reserved2_) {
/* 24 */     this.account = _account_;
/* 25 */     this.room_type = _room_type_;
/* 26 */     this.is_open_mic = _is_open_mic_;
/* 27 */     this.reserved1 = _reserved1_;
/* 28 */     this.reserved2 = _reserved2_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 32 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 36 */     _os_.marshal(this.account);
/* 37 */     _os_.marshal(this.room_type);
/* 38 */     _os_.marshal(this.is_open_mic);
/* 39 */     _os_.marshal(this.reserved1);
/* 40 */     _os_.marshal(this.reserved2);
/* 41 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 45 */     this.account = _os_.unmarshal_Octets();
/* 46 */     this.room_type = _os_.unmarshal_int();
/* 47 */     this.is_open_mic = _os_.unmarshal_byte();
/* 48 */     this.reserved1 = _os_.unmarshal_int();
/* 49 */     this.reserved2 = _os_.unmarshal_int();
/* 50 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 54 */     if (_o1_ == this) return true;
/* 55 */     if ((_o1_ instanceof ReportSpeakerMicStatusArg)) {
/* 56 */       ReportSpeakerMicStatusArg _o_ = (ReportSpeakerMicStatusArg)_o1_;
/* 57 */       if (!this.account.equals(_o_.account)) return false;
/* 58 */       if (this.room_type != _o_.room_type) return false;
/* 59 */       if (this.is_open_mic != _o_.is_open_mic) return false;
/* 60 */       if (this.reserved1 != _o_.reserved1) return false;
/* 61 */       if (this.reserved2 != _o_.reserved2) return false;
/* 62 */       return true;
/*    */     }
/* 64 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 68 */     int _h_ = 0;
/* 69 */     _h_ += this.account.hashCode();
/* 70 */     _h_ += this.room_type;
/* 71 */     _h_ += this.is_open_mic;
/* 72 */     _h_ += this.reserved1;
/* 73 */     _h_ += this.reserved2;
/* 74 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 78 */     StringBuilder _sb_ = new StringBuilder();
/* 79 */     _sb_.append("(");
/* 80 */     _sb_.append("B").append(this.account.size()).append(",");
/* 81 */     _sb_.append(this.room_type).append(",");
/* 82 */     _sb_.append(this.is_open_mic).append(",");
/* 83 */     _sb_.append(this.reserved1).append(",");
/* 84 */     _sb_.append(this.reserved2).append(",");
/* 85 */     _sb_.append(")");
/* 86 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\ReportSpeakerMicStatusArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */