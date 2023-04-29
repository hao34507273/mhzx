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
/*     */ public class SUseExpItemRes
/*     */   extends __SUseExpItemRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12585994;
/*     */   public int itemid;
/*     */   public int addexp;
/*     */   public int usednum;
/*     */   public int leftnum;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12585994;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SUseExpItemRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SUseExpItemRes(int _itemid_, int _addexp_, int _usednum_, int _leftnum_)
/*     */   {
/*  39 */     this.itemid = _itemid_;
/*  40 */     this.addexp = _addexp_;
/*  41 */     this.usednum = _usednum_;
/*  42 */     this.leftnum = _leftnum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.itemid);
/*  51 */     _os_.marshal(this.addexp);
/*  52 */     _os_.marshal(this.usednum);
/*  53 */     _os_.marshal(this.leftnum);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.itemid = _os_.unmarshal_int();
/*  59 */     this.addexp = _os_.unmarshal_int();
/*  60 */     this.usednum = _os_.unmarshal_int();
/*  61 */     this.leftnum = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SUseExpItemRes)) {
/*  71 */       SUseExpItemRes _o_ = (SUseExpItemRes)_o1_;
/*  72 */       if (this.itemid != _o_.itemid) return false;
/*  73 */       if (this.addexp != _o_.addexp) return false;
/*  74 */       if (this.usednum != _o_.usednum) return false;
/*  75 */       if (this.leftnum != _o_.leftnum) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.itemid;
/*  84 */     _h_ += this.addexp;
/*  85 */     _h_ += this.usednum;
/*  86 */     _h_ += this.leftnum;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.itemid).append(",");
/*  94 */     _sb_.append(this.addexp).append(",");
/*  95 */     _sb_.append(this.usednum).append(",");
/*  96 */     _sb_.append(this.leftnum).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SUseExpItemRes _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.itemid - _o_.itemid;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.addexp - _o_.addexp;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.usednum - _o_.usednum;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.leftnum - _o_.leftnum;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\SUseExpItemRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */