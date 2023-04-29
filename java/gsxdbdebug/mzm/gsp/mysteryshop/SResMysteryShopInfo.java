/*     */ package mzm.gsp.mysteryshop;
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
/*     */ public class SResMysteryShopInfo
/*     */   extends __SResMysteryShopInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12614404;
/*     */   public int shoptype;
/*     */   public int refresh_times;
/*     */   public int used_free_refresh_times;
/*     */   public int can_free_refresh_times;
/*     */   public ArrayList<MysteryGoodsInfo> goods_list;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12614404;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SResMysteryShopInfo()
/*     */   {
/*  37 */     this.goods_list = new ArrayList();
/*     */   }
/*     */   
/*     */   public SResMysteryShopInfo(int _shoptype_, int _refresh_times_, int _used_free_refresh_times_, int _can_free_refresh_times_, ArrayList<MysteryGoodsInfo> _goods_list_) {
/*  41 */     this.shoptype = _shoptype_;
/*  42 */     this.refresh_times = _refresh_times_;
/*  43 */     this.used_free_refresh_times = _used_free_refresh_times_;
/*  44 */     this.can_free_refresh_times = _can_free_refresh_times_;
/*  45 */     this.goods_list = _goods_list_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     for (MysteryGoodsInfo _v_ : this.goods_list)
/*  50 */       if (!_v_._validator_()) return false;
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.shoptype);
/*  56 */     _os_.marshal(this.refresh_times);
/*  57 */     _os_.marshal(this.used_free_refresh_times);
/*  58 */     _os_.marshal(this.can_free_refresh_times);
/*  59 */     _os_.compact_uint32(this.goods_list.size());
/*  60 */     for (MysteryGoodsInfo _v_ : this.goods_list) {
/*  61 */       _os_.marshal(_v_);
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  67 */     this.shoptype = _os_.unmarshal_int();
/*  68 */     this.refresh_times = _os_.unmarshal_int();
/*  69 */     this.used_free_refresh_times = _os_.unmarshal_int();
/*  70 */     this.can_free_refresh_times = _os_.unmarshal_int();
/*  71 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  72 */       MysteryGoodsInfo _v_ = new MysteryGoodsInfo();
/*  73 */       _v_.unmarshal(_os_);
/*  74 */       this.goods_list.add(_v_);
/*     */     }
/*  76 */     if (!_validator_()) {
/*  77 */       throw new VerifyError("validator failed");
/*     */     }
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  83 */     if (_o1_ == this) return true;
/*  84 */     if ((_o1_ instanceof SResMysteryShopInfo)) {
/*  85 */       SResMysteryShopInfo _o_ = (SResMysteryShopInfo)_o1_;
/*  86 */       if (this.shoptype != _o_.shoptype) return false;
/*  87 */       if (this.refresh_times != _o_.refresh_times) return false;
/*  88 */       if (this.used_free_refresh_times != _o_.used_free_refresh_times) return false;
/*  89 */       if (this.can_free_refresh_times != _o_.can_free_refresh_times) return false;
/*  90 */       if (!this.goods_list.equals(_o_.goods_list)) return false;
/*  91 */       return true;
/*     */     }
/*  93 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  97 */     int _h_ = 0;
/*  98 */     _h_ += this.shoptype;
/*  99 */     _h_ += this.refresh_times;
/* 100 */     _h_ += this.used_free_refresh_times;
/* 101 */     _h_ += this.can_free_refresh_times;
/* 102 */     _h_ += this.goods_list.hashCode();
/* 103 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 107 */     StringBuilder _sb_ = new StringBuilder();
/* 108 */     _sb_.append("(");
/* 109 */     _sb_.append(this.shoptype).append(",");
/* 110 */     _sb_.append(this.refresh_times).append(",");
/* 111 */     _sb_.append(this.used_free_refresh_times).append(",");
/* 112 */     _sb_.append(this.can_free_refresh_times).append(",");
/* 113 */     _sb_.append(this.goods_list).append(",");
/* 114 */     _sb_.append(")");
/* 115 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mysteryshop\SResMysteryShopInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */