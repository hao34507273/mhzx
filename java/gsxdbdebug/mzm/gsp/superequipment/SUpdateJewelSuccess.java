/*     */ package mzm.gsp.superequipment;
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
/*     */ public class SUpdateJewelSuccess
/*     */   extends __SUpdateJewelSuccess__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12618768;
/*     */   public int bagid;
/*     */   public int grid;
/*     */   public int index;
/*     */   public int jewelcfgid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12618768;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SUpdateJewelSuccess() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SUpdateJewelSuccess(int _bagid_, int _grid_, int _index_, int _jewelcfgid_)
/*     */   {
/*  39 */     this.bagid = _bagid_;
/*  40 */     this.grid = _grid_;
/*  41 */     this.index = _index_;
/*  42 */     this.jewelcfgid = _jewelcfgid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.bagid);
/*  51 */     _os_.marshal(this.grid);
/*  52 */     _os_.marshal(this.index);
/*  53 */     _os_.marshal(this.jewelcfgid);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.bagid = _os_.unmarshal_int();
/*  59 */     this.grid = _os_.unmarshal_int();
/*  60 */     this.index = _os_.unmarshal_int();
/*  61 */     this.jewelcfgid = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SUpdateJewelSuccess)) {
/*  71 */       SUpdateJewelSuccess _o_ = (SUpdateJewelSuccess)_o1_;
/*  72 */       if (this.bagid != _o_.bagid) return false;
/*  73 */       if (this.grid != _o_.grid) return false;
/*  74 */       if (this.index != _o_.index) return false;
/*  75 */       if (this.jewelcfgid != _o_.jewelcfgid) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.bagid;
/*  84 */     _h_ += this.grid;
/*  85 */     _h_ += this.index;
/*  86 */     _h_ += this.jewelcfgid;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.bagid).append(",");
/*  94 */     _sb_.append(this.grid).append(",");
/*  95 */     _sb_.append(this.index).append(",");
/*  96 */     _sb_.append(this.jewelcfgid).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SUpdateJewelSuccess _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.bagid - _o_.bagid;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.grid - _o_.grid;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.index - _o_.index;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.jewelcfgid - _o_.jewelcfgid;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\superequipment\SUpdateJewelSuccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */