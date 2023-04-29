/*     */ package apollo;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.apollo.main.ApolloInterface;
/*     */ 
/*     */ 
/*     */ public class SSyncGlobalRoomInfo
/*     */   extends __SSyncGlobalRoomInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12004;
/*     */   public int room_type;
/*     */   public GlobalRoomInfo room_info;
/*     */   public int reserved1;
/*     */   public int reserved2;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     ApolloInterface.onSSyncGlobalRoomInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  27 */     return 12004;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncGlobalRoomInfo()
/*     */   {
/*  36 */     this.room_info = new GlobalRoomInfo();
/*  37 */     this.reserved1 = 0;
/*  38 */     this.reserved2 = 0;
/*     */   }
/*     */   
/*     */   public SSyncGlobalRoomInfo(int _room_type_, GlobalRoomInfo _room_info_, int _reserved1_, int _reserved2_) {
/*  42 */     this.room_type = _room_type_;
/*  43 */     this.room_info = _room_info_;
/*  44 */     this.reserved1 = _reserved1_;
/*  45 */     this.reserved2 = _reserved2_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     if (!this.room_info._validator_()) return false;
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.room_type);
/*  55 */     _os_.marshal(this.room_info);
/*  56 */     _os_.marshal(this.reserved1);
/*  57 */     _os_.marshal(this.reserved2);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.room_type = _os_.unmarshal_int();
/*  63 */     this.room_info.unmarshal(_os_);
/*  64 */     this.reserved1 = _os_.unmarshal_int();
/*  65 */     this.reserved2 = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SSyncGlobalRoomInfo)) {
/*  75 */       SSyncGlobalRoomInfo _o_ = (SSyncGlobalRoomInfo)_o1_;
/*  76 */       if (this.room_type != _o_.room_type) return false;
/*  77 */       if (!this.room_info.equals(_o_.room_info)) return false;
/*  78 */       if (this.reserved1 != _o_.reserved1) return false;
/*  79 */       if (this.reserved2 != _o_.reserved2) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += this.room_type;
/*  88 */     _h_ += this.room_info.hashCode();
/*  89 */     _h_ += this.reserved1;
/*  90 */     _h_ += this.reserved2;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.room_type).append(",");
/*  98 */     _sb_.append(this.room_info).append(",");
/*  99 */     _sb_.append(this.reserved1).append(",");
/* 100 */     _sb_.append(this.reserved2).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSyncGlobalRoomInfo _o_) {
/* 106 */     if (_o_ == this) return 0;
/* 107 */     int _c_ = 0;
/* 108 */     _c_ = this.room_type - _o_.room_type;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.room_info.compareTo(_o_.room_info);
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.reserved1 - _o_.reserved1;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = this.reserved2 - _o_.reserved2;
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\apollo\SSyncGlobalRoomInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */