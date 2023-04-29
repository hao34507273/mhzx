/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SGetPointRaceRankFail
/*     */   extends __SGetPointRaceRankFail__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617018;
/*     */   public int retcode;
/*     */   public byte rank_type;
/*     */   public int from;
/*     */   public int to;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12617018;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetPointRaceRankFail() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SGetPointRaceRankFail(int _retcode_, byte _rank_type_, int _from_, int _to_)
/*     */   {
/*  39 */     this.retcode = _retcode_;
/*  40 */     this.rank_type = _rank_type_;
/*  41 */     this.from = _from_;
/*  42 */     this.to = _to_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.retcode);
/*  51 */     _os_.marshal(this.rank_type);
/*  52 */     _os_.marshal(this.from);
/*  53 */     _os_.marshal(this.to);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.retcode = _os_.unmarshal_int();
/*  59 */     this.rank_type = _os_.unmarshal_byte();
/*  60 */     this.from = _os_.unmarshal_int();
/*  61 */     this.to = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SGetPointRaceRankFail)) {
/*  71 */       SGetPointRaceRankFail _o_ = (SGetPointRaceRankFail)_o1_;
/*  72 */       if (this.retcode != _o_.retcode) return false;
/*  73 */       if (this.rank_type != _o_.rank_type) return false;
/*  74 */       if (this.from != _o_.from) return false;
/*  75 */       if (this.to != _o_.to) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.retcode;
/*  84 */     _h_ += this.rank_type;
/*  85 */     _h_ += this.from;
/*  86 */     _h_ += this.to;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.retcode).append(",");
/*  94 */     _sb_.append(this.rank_type).append(",");
/*  95 */     _sb_.append(this.from).append(",");
/*  96 */     _sb_.append(this.to).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGetPointRaceRankFail _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.retcode - _o_.retcode;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.rank_type - _o_.rank_type;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.from - _o_.from;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.to - _o_.to;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\SGetPointRaceRankFail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */