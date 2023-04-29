/*     */ package hub;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class Pong
/*     */   extends __Pong__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 14007;
/*     */   public byte direction;
/*     */   public int src_id;
/*     */   public int dst_id;
/*     */   public long code;
/*     */   
/*     */   protected void process()
/*     */   {
/*  17 */     KeepAliveManager.getInstance().onKeepAlive(getConnection());
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  25 */     return 14007;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Pong()
/*     */   {
/*  34 */     this.direction = 0;
/*     */   }
/*     */   
/*     */   public Pong(byte _direction_, int _src_id_, int _dst_id_, long _code_) {
/*  38 */     this.direction = _direction_;
/*  39 */     this.src_id = _src_id_;
/*  40 */     this.dst_id = _dst_id_;
/*  41 */     this.code = _code_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  49 */     _os_.marshal(this.direction);
/*  50 */     _os_.marshal(this.src_id);
/*  51 */     _os_.marshal(this.dst_id);
/*  52 */     _os_.marshal(this.code);
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  57 */     this.direction = _os_.unmarshal_byte();
/*  58 */     this.src_id = _os_.unmarshal_int();
/*  59 */     this.dst_id = _os_.unmarshal_int();
/*  60 */     this.code = _os_.unmarshal_long();
/*  61 */     if (!_validator_()) {
/*  62 */       throw new VerifyError("validator failed");
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  68 */     if (_o1_ == this) return true;
/*  69 */     if ((_o1_ instanceof Pong)) {
/*  70 */       Pong _o_ = (Pong)_o1_;
/*  71 */       if (this.direction != _o_.direction) return false;
/*  72 */       if (this.src_id != _o_.src_id) return false;
/*  73 */       if (this.dst_id != _o_.dst_id) return false;
/*  74 */       if (this.code != _o_.code) return false;
/*  75 */       return true;
/*     */     }
/*  77 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  81 */     int _h_ = 0;
/*  82 */     _h_ += this.direction;
/*  83 */     _h_ += this.src_id;
/*  84 */     _h_ += this.dst_id;
/*  85 */     _h_ += (int)this.code;
/*  86 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  90 */     StringBuilder _sb_ = new StringBuilder();
/*  91 */     _sb_.append("(");
/*  92 */     _sb_.append(this.direction).append(",");
/*  93 */     _sb_.append(this.src_id).append(",");
/*  94 */     _sb_.append(this.dst_id).append(",");
/*  95 */     _sb_.append(this.code).append(",");
/*  96 */     _sb_.append(")");
/*  97 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(Pong _o_) {
/* 101 */     if (_o_ == this) return 0;
/* 102 */     int _c_ = 0;
/* 103 */     _c_ = this.direction - _o_.direction;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.src_id - _o_.src_id;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = this.dst_id - _o_.dst_id;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     _c_ = Long.signum(this.code - _o_.code);
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\hub\Pong.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */