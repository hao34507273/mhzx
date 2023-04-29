/*     */ package mzm.gsp.award;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ public class AwardInfoBean implements com.goldhuman.Common.Marshal.Marshal
/*     */ {
/*     */   public ArrayList<MoneyAwardBean> moneybeans;
/*     */   public ArrayList<ExpAwardBean> expbeans;
/*     */   public java.util.HashMap<Integer, Integer> itemmap;
/*     */   public int appellationid;
/*     */   public int titleid;
/*     */   
/*     */   public AwardInfoBean()
/*     */   {
/*  16 */     this.moneybeans = new ArrayList();
/*  17 */     this.expbeans = new ArrayList();
/*  18 */     this.itemmap = new java.util.HashMap();
/*     */   }
/*     */   
/*     */   public AwardInfoBean(ArrayList<MoneyAwardBean> _moneybeans_, ArrayList<ExpAwardBean> _expbeans_, java.util.HashMap<Integer, Integer> _itemmap_, int _appellationid_, int _titleid_) {
/*  22 */     this.moneybeans = _moneybeans_;
/*  23 */     this.expbeans = _expbeans_;
/*  24 */     this.itemmap = _itemmap_;
/*  25 */     this.appellationid = _appellationid_;
/*  26 */     this.titleid = _titleid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  30 */     for (MoneyAwardBean _v_ : this.moneybeans)
/*  31 */       if (!_v_._validator_()) return false;
/*  32 */     for (ExpAwardBean _v_ : this.expbeans)
/*  33 */       if (!_v_._validator_()) return false;
/*  34 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  38 */     _os_.compact_uint32(this.moneybeans.size());
/*  39 */     for (MoneyAwardBean _v_ : this.moneybeans) {
/*  40 */       _os_.marshal(_v_);
/*     */     }
/*  42 */     _os_.compact_uint32(this.expbeans.size());
/*  43 */     for (ExpAwardBean _v_ : this.expbeans) {
/*  44 */       _os_.marshal(_v_);
/*     */     }
/*  46 */     _os_.compact_uint32(this.itemmap.size());
/*  47 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.itemmap.entrySet()) {
/*  48 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  49 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  51 */     _os_.marshal(this.appellationid);
/*  52 */     _os_.marshal(this.titleid);
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  57 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  58 */       MoneyAwardBean _v_ = new MoneyAwardBean();
/*  59 */       _v_.unmarshal(_os_);
/*  60 */       this.moneybeans.add(_v_);
/*     */     }
/*  62 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  63 */       ExpAwardBean _v_ = new ExpAwardBean();
/*  64 */       _v_.unmarshal(_os_);
/*  65 */       this.expbeans.add(_v_);
/*     */     }
/*  67 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  69 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  71 */       int _v_ = _os_.unmarshal_int();
/*  72 */       this.itemmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  74 */     this.appellationid = _os_.unmarshal_int();
/*  75 */     this.titleid = _os_.unmarshal_int();
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  80 */     if (_o1_ == this) return true;
/*  81 */     if ((_o1_ instanceof AwardInfoBean)) {
/*  82 */       AwardInfoBean _o_ = (AwardInfoBean)_o1_;
/*  83 */       if (!this.moneybeans.equals(_o_.moneybeans)) return false;
/*  84 */       if (!this.expbeans.equals(_o_.expbeans)) return false;
/*  85 */       if (!this.itemmap.equals(_o_.itemmap)) return false;
/*  86 */       if (this.appellationid != _o_.appellationid) return false;
/*  87 */       if (this.titleid != _o_.titleid) return false;
/*  88 */       return true;
/*     */     }
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  94 */     int _h_ = 0;
/*  95 */     _h_ += this.moneybeans.hashCode();
/*  96 */     _h_ += this.expbeans.hashCode();
/*  97 */     _h_ += this.itemmap.hashCode();
/*  98 */     _h_ += this.appellationid;
/*  99 */     _h_ += this.titleid;
/* 100 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 104 */     StringBuilder _sb_ = new StringBuilder();
/* 105 */     _sb_.append("(");
/* 106 */     _sb_.append(this.moneybeans).append(",");
/* 107 */     _sb_.append(this.expbeans).append(",");
/* 108 */     _sb_.append(this.itemmap).append(",");
/* 109 */     _sb_.append(this.appellationid).append(",");
/* 110 */     _sb_.append(this.titleid).append(",");
/* 111 */     _sb_.append(")");
/* 112 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\award\AwardInfoBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */