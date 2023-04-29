/*     */ package mzm.gsp.homeland;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SBuyFurnitureRes
/*     */   extends __SBuyFurnitureRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12605493;
/*     */   public HashSet<Long> furnitureuuids;
/*     */   public int furnitureid;
/*     */   public int buynum;
/*     */   public int restcanbuynum;
/*     */   public int moneytype;
/*     */   public int moneynum;
/*     */   public int restfreshnum;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12605493;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SBuyFurnitureRes()
/*     */   {
/*  37 */     this.furnitureuuids = new HashSet();
/*     */   }
/*     */   
/*     */   public SBuyFurnitureRes(HashSet<Long> _furnitureuuids_, int _furnitureid_, int _buynum_, int _restcanbuynum_, int _moneytype_, int _moneynum_, int _restfreshnum_) {
/*  41 */     this.furnitureuuids = _furnitureuuids_;
/*  42 */     this.furnitureid = _furnitureid_;
/*  43 */     this.buynum = _buynum_;
/*  44 */     this.restcanbuynum = _restcanbuynum_;
/*  45 */     this.moneytype = _moneytype_;
/*  46 */     this.moneynum = _moneynum_;
/*  47 */     this.restfreshnum = _restfreshnum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.compact_uint32(this.furnitureuuids.size());
/*  56 */     for (Long _v_ : this.furnitureuuids) {
/*  57 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  59 */     _os_.marshal(this.furnitureid);
/*  60 */     _os_.marshal(this.buynum);
/*  61 */     _os_.marshal(this.restcanbuynum);
/*  62 */     _os_.marshal(this.moneytype);
/*  63 */     _os_.marshal(this.moneynum);
/*  64 */     _os_.marshal(this.restfreshnum);
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  69 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--)
/*     */     {
/*  71 */       long _v_ = _os_.unmarshal_long();
/*  72 */       this.furnitureuuids.add(Long.valueOf(_v_));
/*     */     }
/*  74 */     this.furnitureid = _os_.unmarshal_int();
/*  75 */     this.buynum = _os_.unmarshal_int();
/*  76 */     this.restcanbuynum = _os_.unmarshal_int();
/*  77 */     this.moneytype = _os_.unmarshal_int();
/*  78 */     this.moneynum = _os_.unmarshal_int();
/*  79 */     this.restfreshnum = _os_.unmarshal_int();
/*  80 */     if (!_validator_()) {
/*  81 */       throw new VerifyError("validator failed");
/*     */     }
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  87 */     if (_o1_ == this) return true;
/*  88 */     if ((_o1_ instanceof SBuyFurnitureRes)) {
/*  89 */       SBuyFurnitureRes _o_ = (SBuyFurnitureRes)_o1_;
/*  90 */       if (!this.furnitureuuids.equals(_o_.furnitureuuids)) return false;
/*  91 */       if (this.furnitureid != _o_.furnitureid) return false;
/*  92 */       if (this.buynum != _o_.buynum) return false;
/*  93 */       if (this.restcanbuynum != _o_.restcanbuynum) return false;
/*  94 */       if (this.moneytype != _o_.moneytype) return false;
/*  95 */       if (this.moneynum != _o_.moneynum) return false;
/*  96 */       if (this.restfreshnum != _o_.restfreshnum) return false;
/*  97 */       return true;
/*     */     }
/*  99 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 103 */     int _h_ = 0;
/* 104 */     _h_ += this.furnitureuuids.hashCode();
/* 105 */     _h_ += this.furnitureid;
/* 106 */     _h_ += this.buynum;
/* 107 */     _h_ += this.restcanbuynum;
/* 108 */     _h_ += this.moneytype;
/* 109 */     _h_ += this.moneynum;
/* 110 */     _h_ += this.restfreshnum;
/* 111 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 115 */     StringBuilder _sb_ = new StringBuilder();
/* 116 */     _sb_.append("(");
/* 117 */     _sb_.append(this.furnitureuuids).append(",");
/* 118 */     _sb_.append(this.furnitureid).append(",");
/* 119 */     _sb_.append(this.buynum).append(",");
/* 120 */     _sb_.append(this.restcanbuynum).append(",");
/* 121 */     _sb_.append(this.moneytype).append(",");
/* 122 */     _sb_.append(this.moneynum).append(",");
/* 123 */     _sb_.append(this.restfreshnum).append(",");
/* 124 */     _sb_.append(")");
/* 125 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\SBuyFurnitureRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */