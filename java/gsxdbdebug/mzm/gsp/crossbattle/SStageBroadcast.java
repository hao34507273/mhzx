/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SStageBroadcast
/*     */   extends __SStageBroadcast__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617017;
/*     */   public static final int STG_PREPARE = 0;
/*     */   public static final int STG_MATCH = 1;
/*     */   public static final int STG_FINISH_MATCH = 2;
/*     */   public static final int STG_RETURN_ORIGINAL = 3;
/*     */   public int zone;
/*     */   public int index;
/*     */   public byte backup;
/*     */   public int stage;
/*     */   public int countdown;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617017;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SStageBroadcast() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SStageBroadcast(int _zone_, int _index_, byte _backup_, int _stage_, int _countdown_)
/*     */   {
/*  45 */     this.zone = _zone_;
/*  46 */     this.index = _index_;
/*  47 */     this.backup = _backup_;
/*  48 */     this.stage = _stage_;
/*  49 */     this.countdown = _countdown_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.zone);
/*  58 */     _os_.marshal(this.index);
/*  59 */     _os_.marshal(this.backup);
/*  60 */     _os_.marshal(this.stage);
/*  61 */     _os_.marshal(this.countdown);
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  66 */     this.zone = _os_.unmarshal_int();
/*  67 */     this.index = _os_.unmarshal_int();
/*  68 */     this.backup = _os_.unmarshal_byte();
/*  69 */     this.stage = _os_.unmarshal_int();
/*  70 */     this.countdown = _os_.unmarshal_int();
/*  71 */     if (!_validator_()) {
/*  72 */       throw new VerifyError("validator failed");
/*     */     }
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  78 */     if (_o1_ == this) return true;
/*  79 */     if ((_o1_ instanceof SStageBroadcast)) {
/*  80 */       SStageBroadcast _o_ = (SStageBroadcast)_o1_;
/*  81 */       if (this.zone != _o_.zone) return false;
/*  82 */       if (this.index != _o_.index) return false;
/*  83 */       if (this.backup != _o_.backup) return false;
/*  84 */       if (this.stage != _o_.stage) return false;
/*  85 */       if (this.countdown != _o_.countdown) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.zone;
/*  94 */     _h_ += this.index;
/*  95 */     _h_ += this.backup;
/*  96 */     _h_ += this.stage;
/*  97 */     _h_ += this.countdown;
/*  98 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 102 */     StringBuilder _sb_ = new StringBuilder();
/* 103 */     _sb_.append("(");
/* 104 */     _sb_.append(this.zone).append(",");
/* 105 */     _sb_.append(this.index).append(",");
/* 106 */     _sb_.append(this.backup).append(",");
/* 107 */     _sb_.append(this.stage).append(",");
/* 108 */     _sb_.append(this.countdown).append(",");
/* 109 */     _sb_.append(")");
/* 110 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SStageBroadcast _o_) {
/* 114 */     if (_o_ == this) return 0;
/* 115 */     int _c_ = 0;
/* 116 */     _c_ = this.zone - _o_.zone;
/* 117 */     if (0 != _c_) return _c_;
/* 118 */     _c_ = this.index - _o_.index;
/* 119 */     if (0 != _c_) return _c_;
/* 120 */     _c_ = this.backup - _o_.backup;
/* 121 */     if (0 != _c_) return _c_;
/* 122 */     _c_ = this.stage - _o_.stage;
/* 123 */     if (0 != _c_) return _c_;
/* 124 */     _c_ = this.countdown - _o_.countdown;
/* 125 */     if (0 != _c_) return _c_;
/* 126 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SStageBroadcast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */