/*    */ package apollo;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.Marshal;
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ public class ReportSpeakerOnlineInfoArg
/*    */   implements Marshal
/*    */ {
/*    */   public static final int STATUS_OFFLINE = 1;
/*    */   public static final int STATUS_OFFLINE_PROTECT = 2;
/*    */   public static final int STATUS_ONLINE = 3;
/*    */   public Octets account;
/*    */   public byte online_status;
/*    */   public int reserved1;
/*    */   public int reserved2;
/*    */   
/*    */   public ReportSpeakerOnlineInfoArg()
/*    */   {
/* 21 */     this.account = new Octets();
/* 22 */     this.online_status = 1;
/* 23 */     this.reserved1 = 0;
/* 24 */     this.reserved2 = 0;
/*    */   }
/*    */   
/*    */   public ReportSpeakerOnlineInfoArg(Octets _account_, byte _online_status_, int _reserved1_, int _reserved2_) {
/* 28 */     this.account = _account_;
/* 29 */     this.online_status = _online_status_;
/* 30 */     this.reserved1 = _reserved1_;
/* 31 */     this.reserved2 = _reserved2_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 35 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 39 */     _os_.marshal(this.account);
/* 40 */     _os_.marshal(this.online_status);
/* 41 */     _os_.marshal(this.reserved1);
/* 42 */     _os_.marshal(this.reserved2);
/* 43 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 47 */     this.account = _os_.unmarshal_Octets();
/* 48 */     this.online_status = _os_.unmarshal_byte();
/* 49 */     this.reserved1 = _os_.unmarshal_int();
/* 50 */     this.reserved2 = _os_.unmarshal_int();
/* 51 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 55 */     if (_o1_ == this) return true;
/* 56 */     if ((_o1_ instanceof ReportSpeakerOnlineInfoArg)) {
/* 57 */       ReportSpeakerOnlineInfoArg _o_ = (ReportSpeakerOnlineInfoArg)_o1_;
/* 58 */       if (!this.account.equals(_o_.account)) return false;
/* 59 */       if (this.online_status != _o_.online_status) return false;
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
/* 70 */     _h_ += this.online_status;
/* 71 */     _h_ += this.reserved1;
/* 72 */     _h_ += this.reserved2;
/* 73 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder _sb_ = new StringBuilder();
/* 78 */     _sb_.append("(");
/* 79 */     _sb_.append("B").append(this.account.size()).append(",");
/* 80 */     _sb_.append(this.online_status).append(",");
/* 81 */     _sb_.append(this.reserved1).append(",");
/* 82 */     _sb_.append(this.reserved2).append(",");
/* 83 */     _sb_.append(")");
/* 84 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\ReportSpeakerOnlineInfoArg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */