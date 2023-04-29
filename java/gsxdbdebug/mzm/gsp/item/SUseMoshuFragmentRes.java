/*     */ package mzm.gsp.item;
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
/*     */ public class SUseMoshuFragmentRes
/*     */   extends __SUseMoshuFragmentRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584844;
/*     */   public int itemid;
/*     */   public int cutitemnum;
/*     */   public int exchangetype;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12584844;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SUseMoshuFragmentRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SUseMoshuFragmentRes(int _itemid_, int _cutitemnum_, int _exchangetype_)
/*     */   {
/*  36 */     this.itemid = _itemid_;
/*  37 */     this.cutitemnum = _cutitemnum_;
/*  38 */     this.exchangetype = _exchangetype_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  42 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  46 */     _os_.marshal(this.itemid);
/*  47 */     _os_.marshal(this.cutitemnum);
/*  48 */     _os_.marshal(this.exchangetype);
/*  49 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  53 */     this.itemid = _os_.unmarshal_int();
/*  54 */     this.cutitemnum = _os_.unmarshal_int();
/*  55 */     this.exchangetype = _os_.unmarshal_int();
/*  56 */     if (!_validator_()) {
/*  57 */       throw new VerifyError("validator failed");
/*     */     }
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  63 */     if (_o1_ == this) return true;
/*  64 */     if ((_o1_ instanceof SUseMoshuFragmentRes)) {
/*  65 */       SUseMoshuFragmentRes _o_ = (SUseMoshuFragmentRes)_o1_;
/*  66 */       if (this.itemid != _o_.itemid) return false;
/*  67 */       if (this.cutitemnum != _o_.cutitemnum) return false;
/*  68 */       if (this.exchangetype != _o_.exchangetype) return false;
/*  69 */       return true;
/*     */     }
/*  71 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  75 */     int _h_ = 0;
/*  76 */     _h_ += this.itemid;
/*  77 */     _h_ += this.cutitemnum;
/*  78 */     _h_ += this.exchangetype;
/*  79 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  83 */     StringBuilder _sb_ = new StringBuilder();
/*  84 */     _sb_.append("(");
/*  85 */     _sb_.append(this.itemid).append(",");
/*  86 */     _sb_.append(this.cutitemnum).append(",");
/*  87 */     _sb_.append(this.exchangetype).append(",");
/*  88 */     _sb_.append(")");
/*  89 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SUseMoshuFragmentRes _o_) {
/*  93 */     if (_o_ == this) return 0;
/*  94 */     int _c_ = 0;
/*  95 */     _c_ = this.itemid - _o_.itemid;
/*  96 */     if (0 != _c_) return _c_;
/*  97 */     _c_ = this.cutitemnum - _o_.cutitemnum;
/*  98 */     if (0 != _c_) return _c_;
/*  99 */     _c_ = this.exchangetype - _o_.exchangetype;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\SUseMoshuFragmentRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */