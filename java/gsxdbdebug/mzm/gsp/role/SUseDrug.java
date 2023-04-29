/*     */ package mzm.gsp.role;
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
/*     */ public class SUseDrug
/*     */   extends __SUseDrug__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12586006;
/*     */   public int itemkey;
/*     */   public int bagid;
/*     */   public int drugbuffid;
/*     */   public int collisionbuffid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12586006;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SUseDrug() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SUseDrug(int _itemkey_, int _bagid_, int _drugbuffid_, int _collisionbuffid_)
/*     */   {
/*  39 */     this.itemkey = _itemkey_;
/*  40 */     this.bagid = _bagid_;
/*  41 */     this.drugbuffid = _drugbuffid_;
/*  42 */     this.collisionbuffid = _collisionbuffid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.itemkey);
/*  51 */     _os_.marshal(this.bagid);
/*  52 */     _os_.marshal(this.drugbuffid);
/*  53 */     _os_.marshal(this.collisionbuffid);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.itemkey = _os_.unmarshal_int();
/*  59 */     this.bagid = _os_.unmarshal_int();
/*  60 */     this.drugbuffid = _os_.unmarshal_int();
/*  61 */     this.collisionbuffid = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SUseDrug)) {
/*  71 */       SUseDrug _o_ = (SUseDrug)_o1_;
/*  72 */       if (this.itemkey != _o_.itemkey) return false;
/*  73 */       if (this.bagid != _o_.bagid) return false;
/*  74 */       if (this.drugbuffid != _o_.drugbuffid) return false;
/*  75 */       if (this.collisionbuffid != _o_.collisionbuffid) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.itemkey;
/*  84 */     _h_ += this.bagid;
/*  85 */     _h_ += this.drugbuffid;
/*  86 */     _h_ += this.collisionbuffid;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.itemkey).append(",");
/*  94 */     _sb_.append(this.bagid).append(",");
/*  95 */     _sb_.append(this.drugbuffid).append(",");
/*  96 */     _sb_.append(this.collisionbuffid).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SUseDrug _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.itemkey - _o_.itemkey;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.bagid - _o_.bagid;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.drugbuffid - _o_.drugbuffid;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.collisionbuffid - _o_.collisionbuffid;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\SUseDrug.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */