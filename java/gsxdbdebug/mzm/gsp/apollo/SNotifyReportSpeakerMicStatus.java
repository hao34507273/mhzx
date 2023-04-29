/*    */ package mzm.gsp.apollo;
/*    */ 
/*    */ import com.goldhuman.Common.Marshal.MarshalException;
/*    */ import com.goldhuman.Common.Marshal.OctetsStream;
/*    */ import com.goldhuman.Common.Octets;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SNotifyReportSpeakerMicStatus
/*    */   extends __SNotifyReportSpeakerMicStatus__
/*    */ {
/*    */   public static final int PROTOCOL_TYPE = 12602636;
/*    */   public int room_type;
/*    */   public Octets openid;
/*    */   public byte status;
/*    */   
/*    */   protected void process() {}
/*    */   
/*    */   public int getType()
/*    */   {
/* 27 */     return 12602636;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public SNotifyReportSpeakerMicStatus()
/*    */   {
/* 35 */     this.room_type = 1;
/* 36 */     this.openid = new Octets();
/* 37 */     this.status = 0;
/*    */   }
/*    */   
/*    */   public SNotifyReportSpeakerMicStatus(int _room_type_, Octets _openid_, byte _status_) {
/* 41 */     this.room_type = _room_type_;
/* 42 */     this.openid = _openid_;
/* 43 */     this.status = _status_;
/*    */   }
/*    */   
/*    */   public final boolean _validator_() {
/* 47 */     return true;
/*    */   }
/*    */   
/*    */   public OctetsStream marshal(OctetsStream _os_) {
/* 51 */     _os_.marshal(this.room_type);
/* 52 */     _os_.marshal(this.openid);
/* 53 */     _os_.marshal(this.status);
/* 54 */     return _os_;
/*    */   }
/*    */   
/*    */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/* 58 */     this.room_type = _os_.unmarshal_int();
/* 59 */     this.openid = _os_.unmarshal_Octets();
/* 60 */     this.status = _os_.unmarshal_byte();
/* 61 */     if (!_validator_()) {
/* 62 */       throw new VerifyError("validator failed");
/*    */     }
/* 64 */     return _os_;
/*    */   }
/*    */   
/*    */   public boolean equals(Object _o1_) {
/* 68 */     if (_o1_ == this) return true;
/* 69 */     if ((_o1_ instanceof SNotifyReportSpeakerMicStatus)) {
/* 70 */       SNotifyReportSpeakerMicStatus _o_ = (SNotifyReportSpeakerMicStatus)_o1_;
/* 71 */       if (this.room_type != _o_.room_type) return false;
/* 72 */       if (!this.openid.equals(_o_.openid)) return false;
/* 73 */       if (this.status != _o_.status) return false;
/* 74 */       return true;
/*    */     }
/* 76 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 80 */     int _h_ = 0;
/* 81 */     _h_ += this.room_type;
/* 82 */     _h_ += this.openid.hashCode();
/* 83 */     _h_ += this.status;
/* 84 */     return _h_;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 88 */     StringBuilder _sb_ = new StringBuilder();
/* 89 */     _sb_.append("(");
/* 90 */     _sb_.append(this.room_type).append(",");
/* 91 */     _sb_.append("B").append(this.openid.size()).append(",");
/* 92 */     _sb_.append(this.status).append(",");
/* 93 */     _sb_.append(")");
/* 94 */     return _sb_.toString();
/*    */   }
/*    */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\apollo\SNotifyReportSpeakerMicStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */