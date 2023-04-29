/*     */ package mzm.gsp.drawcarnival;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SDrawError
/*     */   extends __SDrawError__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12630019;
/*     */   public static final int CUT_YUAN_BAO_FAIL = 1;
/*     */   public static final int HAS_MORE_FREE_PASS = 2;
/*     */   public static final int REMOVE_ITEM_FAIL = 3;
/*     */   public static final int LAST_AWARD_NOT_RECEIVED = 4;
/*     */   public int code;
/*     */   public int pass_type_id;
/*     */   public int pass_count;
/*     */   public byte is_use_yuan_bao;
/*     */   public FreePassInfo free_pass_info;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12630019;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SDrawError()
/*     */   {
/*  42 */     this.free_pass_info = new FreePassInfo();
/*     */   }
/*     */   
/*     */   public SDrawError(int _code_, int _pass_type_id_, int _pass_count_, byte _is_use_yuan_bao_, FreePassInfo _free_pass_info_) {
/*  46 */     this.code = _code_;
/*  47 */     this.pass_type_id = _pass_type_id_;
/*  48 */     this.pass_count = _pass_count_;
/*  49 */     this.is_use_yuan_bao = _is_use_yuan_bao_;
/*  50 */     this.free_pass_info = _free_pass_info_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  54 */     if (!this.free_pass_info._validator_()) return false;
/*  55 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  59 */     _os_.marshal(this.code);
/*  60 */     _os_.marshal(this.pass_type_id);
/*  61 */     _os_.marshal(this.pass_count);
/*  62 */     _os_.marshal(this.is_use_yuan_bao);
/*  63 */     _os_.marshal(this.free_pass_info);
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  68 */     this.code = _os_.unmarshal_int();
/*  69 */     this.pass_type_id = _os_.unmarshal_int();
/*  70 */     this.pass_count = _os_.unmarshal_int();
/*  71 */     this.is_use_yuan_bao = _os_.unmarshal_byte();
/*  72 */     this.free_pass_info.unmarshal(_os_);
/*  73 */     if (!_validator_()) {
/*  74 */       throw new VerifyError("validator failed");
/*     */     }
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  80 */     if (_o1_ == this) return true;
/*  81 */     if ((_o1_ instanceof SDrawError)) {
/*  82 */       SDrawError _o_ = (SDrawError)_o1_;
/*  83 */       if (this.code != _o_.code) return false;
/*  84 */       if (this.pass_type_id != _o_.pass_type_id) return false;
/*  85 */       if (this.pass_count != _o_.pass_count) return false;
/*  86 */       if (this.is_use_yuan_bao != _o_.is_use_yuan_bao) return false;
/*  87 */       if (!this.free_pass_info.equals(_o_.free_pass_info)) return false;
/*  88 */       return true;
/*     */     }
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  94 */     int _h_ = 0;
/*  95 */     _h_ += this.code;
/*  96 */     _h_ += this.pass_type_id;
/*  97 */     _h_ += this.pass_count;
/*  98 */     _h_ += this.is_use_yuan_bao;
/*  99 */     _h_ += this.free_pass_info.hashCode();
/* 100 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 104 */     StringBuilder _sb_ = new StringBuilder();
/* 105 */     _sb_.append("(");
/* 106 */     _sb_.append(this.code).append(",");
/* 107 */     _sb_.append(this.pass_type_id).append(",");
/* 108 */     _sb_.append(this.pass_count).append(",");
/* 109 */     _sb_.append(this.is_use_yuan_bao).append(",");
/* 110 */     _sb_.append(this.free_pass_info).append(",");
/* 111 */     _sb_.append(")");
/* 112 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SDrawError _o_) {
/* 116 */     if (_o_ == this) return 0;
/* 117 */     int _c_ = 0;
/* 118 */     _c_ = this.code - _o_.code;
/* 119 */     if (0 != _c_) return _c_;
/* 120 */     _c_ = this.pass_type_id - _o_.pass_type_id;
/* 121 */     if (0 != _c_) return _c_;
/* 122 */     _c_ = this.pass_count - _o_.pass_count;
/* 123 */     if (0 != _c_) return _c_;
/* 124 */     _c_ = this.is_use_yuan_bao - _o_.is_use_yuan_bao;
/* 125 */     if (0 != _c_) return _c_;
/* 126 */     _c_ = this.free_pass_info.compareTo(_o_.free_pass_info);
/* 127 */     if (0 != _c_) return _c_;
/* 128 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\drawcarnival\SDrawError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */