/*     */ package mzm.gsp.masswedding;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynMassWeddingStage
/*     */   extends __SSynMassWeddingStage__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12604935;
/*     */   public static final int BLESS_NO = 0;
/*     */   public static final int BLESS_YES = 1;
/*     */   public static final int MASSWEDDING_END_NO = 0;
/*     */   public static final int MASSWEDDING_END_YES = 1;
/*     */   public int stage;
/*     */   public int blessed;
/*     */   public HashSet<Long> supportset;
/*     */   public int massweddingplayend;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12604935;
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
/*     */   public SSynMassWeddingStage()
/*     */   {
/*  41 */     this.supportset = new HashSet();
/*     */   }
/*     */   
/*     */   public SSynMassWeddingStage(int _stage_, int _blessed_, HashSet<Long> _supportset_, int _massweddingplayend_) {
/*  45 */     this.stage = _stage_;
/*  46 */     this.blessed = _blessed_;
/*  47 */     this.supportset = _supportset_;
/*  48 */     this.massweddingplayend = _massweddingplayend_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.stage);
/*  57 */     _os_.marshal(this.blessed);
/*  58 */     _os_.compact_uint32(this.supportset.size());
/*  59 */     for (Long _v_ : this.supportset) {
/*  60 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  62 */     _os_.marshal(this.massweddingplayend);
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     this.stage = _os_.unmarshal_int();
/*  68 */     this.blessed = _os_.unmarshal_int();
/*  69 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  71 */       long _v_ = _os_.unmarshal_long();
/*  72 */       this.supportset.add(Long.valueOf(_v_));
/*     */     }
/*  74 */     this.massweddingplayend = _os_.unmarshal_int();
/*  75 */     if (!_validator_()) {
/*  76 */       throw new VerifyError("validator failed");
/*     */     }
/*  78 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  82 */     if (_o1_ == this) return true;
/*  83 */     if ((_o1_ instanceof SSynMassWeddingStage)) {
/*  84 */       SSynMassWeddingStage _o_ = (SSynMassWeddingStage)_o1_;
/*  85 */       if (this.stage != _o_.stage) return false;
/*  86 */       if (this.blessed != _o_.blessed) return false;
/*  87 */       if (!this.supportset.equals(_o_.supportset)) return false;
/*  88 */       if (this.massweddingplayend != _o_.massweddingplayend) return false;
/*  89 */       return true;
/*     */     }
/*  91 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  95 */     int _h_ = 0;
/*  96 */     _h_ += this.stage;
/*  97 */     _h_ += this.blessed;
/*  98 */     _h_ += this.supportset.hashCode();
/*  99 */     _h_ += this.massweddingplayend;
/* 100 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 104 */     StringBuilder _sb_ = new StringBuilder();
/* 105 */     _sb_.append("(");
/* 106 */     _sb_.append(this.stage).append(",");
/* 107 */     _sb_.append(this.blessed).append(",");
/* 108 */     _sb_.append(this.supportset).append(",");
/* 109 */     _sb_.append(this.massweddingplayend).append(",");
/* 110 */     _sb_.append(")");
/* 111 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\masswedding\SSynMassWeddingStage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */