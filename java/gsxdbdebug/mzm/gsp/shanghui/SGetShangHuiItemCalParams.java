/*     */ package mzm.gsp.shanghui;
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
/*     */ public class SGetShangHuiItemCalParams
/*     */   extends __SGetShangHuiItemCalParams__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12592655;
/*     */   public int itemid;
/*     */   public int canbuynum;
/*     */   public int orgdayprice;
/*     */   public int recommandprice;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12592655;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SGetShangHuiItemCalParams() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SGetShangHuiItemCalParams(int _itemid_, int _canbuynum_, int _orgdayprice_, int _recommandprice_)
/*     */   {
/*  39 */     this.itemid = _itemid_;
/*  40 */     this.canbuynum = _canbuynum_;
/*  41 */     this.orgdayprice = _orgdayprice_;
/*  42 */     this.recommandprice = _recommandprice_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.itemid);
/*  51 */     _os_.marshal(this.canbuynum);
/*  52 */     _os_.marshal(this.orgdayprice);
/*  53 */     _os_.marshal(this.recommandprice);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.itemid = _os_.unmarshal_int();
/*  59 */     this.canbuynum = _os_.unmarshal_int();
/*  60 */     this.orgdayprice = _os_.unmarshal_int();
/*  61 */     this.recommandprice = _os_.unmarshal_int();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof SGetShangHuiItemCalParams)) {
/*  71 */       SGetShangHuiItemCalParams _o_ = (SGetShangHuiItemCalParams)_o1_;
/*  72 */       if (this.itemid != _o_.itemid) return false;
/*  73 */       if (this.canbuynum != _o_.canbuynum) return false;
/*  74 */       if (this.orgdayprice != _o_.orgdayprice) return false;
/*  75 */       if (this.recommandprice != _o_.recommandprice) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.itemid;
/*  84 */     _h_ += this.canbuynum;
/*  85 */     _h_ += this.orgdayprice;
/*  86 */     _h_ += this.recommandprice;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.itemid).append(",");
/*  94 */     _sb_.append(this.canbuynum).append(",");
/*  95 */     _sb_.append(this.orgdayprice).append(",");
/*  96 */     _sb_.append(this.recommandprice).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SGetShangHuiItemCalParams _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.itemid - _o_.itemid;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.canbuynum - _o_.canbuynum;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.orgdayprice - _o_.orgdayprice;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.recommandprice - _o_.recommandprice;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\shanghui\SGetShangHuiItemCalParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */