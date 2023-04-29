/*     */ package mzm.gsp.personal;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSearchAdvertsSuccess
/*     */   extends __SSearchAdvertsSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12603662;
/*     */   public ArrayList<AdvertInfo> adverts;
/*     */   public int size;
/*     */   public int adverttype;
/*     */   public int page;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12603662;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSearchAdvertsSuccess()
/*     */   {
/*  36 */     this.adverts = new ArrayList();
/*     */   }
/*     */   
/*     */   public SSearchAdvertsSuccess(ArrayList<AdvertInfo> _adverts_, int _size_, int _adverttype_, int _page_) {
/*  40 */     this.adverts = _adverts_;
/*  41 */     this.size = _size_;
/*  42 */     this.adverttype = _adverttype_;
/*  43 */     this.page = _page_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     for (AdvertInfo _v_ : this.adverts)
/*  48 */       if (!_v_._validator_()) return false;
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.compact_uint32(this.adverts.size());
/*  54 */     for (AdvertInfo _v_ : this.adverts) {
/*  55 */       _os_.marshal(_v_);
/*     */     }
/*  57 */     _os_.marshal(this.size);
/*  58 */     _os_.marshal(this.adverttype);
/*  59 */     _os_.marshal(this.page);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  65 */       AdvertInfo _v_ = new AdvertInfo();
/*  66 */       _v_.unmarshal(_os_);
/*  67 */       this.adverts.add(_v_);
/*     */     }
/*  69 */     this.size = _os_.unmarshal_int();
/*  70 */     this.adverttype = _os_.unmarshal_int();
/*  71 */     this.page = _os_.unmarshal_int();
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof SSearchAdvertsSuccess)) {
/*  81 */       SSearchAdvertsSuccess _o_ = (SSearchAdvertsSuccess)_o1_;
/*  82 */       if (!this.adverts.equals(_o_.adverts)) return false;
/*  83 */       if (this.size != _o_.size) return false;
/*  84 */       if (this.adverttype != _o_.adverttype) return false;
/*  85 */       if (this.page != _o_.page) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.adverts.hashCode();
/*  94 */     _h_ += this.size;
/*  95 */     _h_ += this.adverttype;
/*  96 */     _h_ += this.page;
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.adverts).append(",");
/* 104 */     _sb_.append(this.size).append(",");
/* 105 */     _sb_.append(this.adverttype).append(",");
/* 106 */     _sb_.append(this.page).append(",");
/* 107 */     _sb_.append(")");
/* 108 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\personal\SSearchAdvertsSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */