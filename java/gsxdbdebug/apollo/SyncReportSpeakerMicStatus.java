/*     */ package apollo;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ public class SyncReportSpeakerMicStatus extends __SyncReportSpeakerMicStatus__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12007;
/*     */   public int room_type;
/*     */   public Octets openid;
/*     */   public int zoneid;
/*     */   public byte is_open_mic;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     mzm.gsp.apollo.main.ApolloInterface.onSyncReportSpeakerMicStatus(this);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  27 */     return 12007;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SyncReportSpeakerMicStatus()
/*     */   {
/*  38 */     this.openid = new Octets();
/*  39 */     this.zoneid = 0;
/*  40 */     this.is_open_mic = 0;
/*  41 */     this.reserved1 = 0;
/*  42 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public SyncReportSpeakerMicStatus(int _room_type_, Octets _openid_, int _zoneid_, byte _is_open_mic_, int _reserved1_, int _reserved2_) {
/*  46 */     this.room_type = _room_type_;
/*  47 */     this.openid = _openid_;
/*  48 */     this.zoneid = _zoneid_;
/*  49 */     this.is_open_mic = _is_open_mic_;
/*  50 */     this.reserved1 = _reserved1_;
/*  51 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  59 */     _os_.marshal(this.room_type);
/*  60 */     _os_.marshal(this.openid);
/*  61 */     _os_.marshal(this.zoneid);
/*  62 */     _os_.marshal(this.is_open_mic);
/*  63 */     _os_.marshal(this.reserved1);
/*  64 */     _os_.marshal(this.reserved2);
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  69 */     this.room_type = _os_.unmarshal_int();
/*  70 */     this.openid = _os_.unmarshal_Octets();
/*  71 */     this.zoneid = _os_.unmarshal_int();
/*  72 */     this.is_open_mic = _os_.unmarshal_byte();
/*  73 */     this.reserved1 = _os_.unmarshal_int();
/*  74 */     this.reserved2 = _os_.unmarshal_int();
/*  75 */     if (!_validator_()) {
/*  76 */       throw new VerifyError("validator failed");
/*     */     }
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  82 */     if (_o1_ == this) return true;
/*  83 */     if ((_o1_ instanceof SyncReportSpeakerMicStatus)) {
/*  84 */       SyncReportSpeakerMicStatus _o_ = (SyncReportSpeakerMicStatus)_o1_;
/*  85 */       if (this.room_type != _o_.room_type) return false;
/*  86 */       if (!this.openid.equals(_o_.openid)) return false;
/*  87 */       if (this.zoneid != _o_.zoneid) return false;
/*  88 */       if (this.is_open_mic != _o_.is_open_mic) return false;
/*  89 */       if (this.reserved1 != _o_.reserved1) return false;
/*  90 */       if (this.reserved2 != _o_.reserved2) return false;
/*  91 */       return true;
/*     */     }
/*  93 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  97 */     int _h_ = 0;
/*  98 */     _h_ += this.room_type;
/*  99 */     _h_ += this.openid.hashCode();
/* 100 */     _h_ += this.zoneid;
/* 101 */     _h_ += this.is_open_mic;
/* 102 */     _h_ += this.reserved1;
/* 103 */     _h_ += this.reserved2;
/* 104 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 108 */     StringBuilder _sb_ = new StringBuilder();
/* 109 */     _sb_.append("(");
/* 110 */     _sb_.append(this.room_type).append(",");
/* 111 */     _sb_.append("B").append(this.openid.size()).append(",");
/* 112 */     _sb_.append(this.zoneid).append(",");
/* 113 */     _sb_.append(this.is_open_mic).append(",");
/* 114 */     _sb_.append(this.reserved1).append(",");
/* 115 */     _sb_.append(this.reserved2).append(",");
/* 116 */     _sb_.append(")");
/* 117 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\SyncReportSpeakerMicStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */