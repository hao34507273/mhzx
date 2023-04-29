/*     */ package mzm.gsp.constellation;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.award.AwardBean;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SChooseCardExtraRes
/*     */   extends __SChooseCardExtraRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12612103;
/*     */   public int constellation;
/*     */   public int index;
/*     */   public AwardBean award;
/*     */   public AwardBean extra_award;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12612103;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SChooseCardExtraRes()
/*     */   {
/*  36 */     this.award = new AwardBean();
/*  37 */     this.extra_award = new AwardBean();
/*     */   }
/*     */   
/*     */   public SChooseCardExtraRes(int _constellation_, int _index_, AwardBean _award_, AwardBean _extra_award_) {
/*  41 */     this.constellation = _constellation_;
/*  42 */     this.index = _index_;
/*  43 */     this.award = _award_;
/*  44 */     this.extra_award = _extra_award_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     if (!this.award._validator_()) return false;
/*  49 */     if (!this.extra_award._validator_()) return false;
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.constellation);
/*  55 */     _os_.marshal(this.index);
/*  56 */     _os_.marshal(this.award);
/*  57 */     _os_.marshal(this.extra_award);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.constellation = _os_.unmarshal_int();
/*  63 */     this.index = _os_.unmarshal_int();
/*  64 */     this.award.unmarshal(_os_);
/*  65 */     this.extra_award.unmarshal(_os_);
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SChooseCardExtraRes)) {
/*  75 */       SChooseCardExtraRes _o_ = (SChooseCardExtraRes)_o1_;
/*  76 */       if (this.constellation != _o_.constellation) return false;
/*  77 */       if (this.index != _o_.index) return false;
/*  78 */       if (!this.award.equals(_o_.award)) return false;
/*  79 */       if (!this.extra_award.equals(_o_.extra_award)) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += this.constellation;
/*  88 */     _h_ += this.index;
/*  89 */     _h_ += this.award.hashCode();
/*  90 */     _h_ += this.extra_award.hashCode();
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.constellation).append(",");
/*  98 */     _sb_.append(this.index).append(",");
/*  99 */     _sb_.append(this.award).append(",");
/* 100 */     _sb_.append(this.extra_award).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\constellation\SChooseCardExtraRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */