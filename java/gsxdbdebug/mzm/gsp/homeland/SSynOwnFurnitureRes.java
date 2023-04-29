/*     */ package mzm.gsp.homeland;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynOwnFurnitureRes
/*     */   extends __SSynOwnFurnitureRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12605443;
/*     */   public HashMap<Integer, FurnitureUuIds> furnitures;
/*     */   public HashMap<Integer, FurnitureUuIds> court_yard_furnitures;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12605443;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SSynOwnFurnitureRes()
/*     */   {
/*  32 */     this.furnitures = new HashMap();
/*  33 */     this.court_yard_furnitures = new HashMap();
/*     */   }
/*     */   
/*     */   public SSynOwnFurnitureRes(HashMap<Integer, FurnitureUuIds> _furnitures_, HashMap<Integer, FurnitureUuIds> _court_yard_furnitures_) {
/*  37 */     this.furnitures = _furnitures_;
/*  38 */     this.court_yard_furnitures = _court_yard_furnitures_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  42 */     for (Map.Entry<Integer, FurnitureUuIds> _e_ : this.furnitures.entrySet()) {
/*  43 */       if (!((FurnitureUuIds)_e_.getValue())._validator_()) return false;
/*     */     }
/*  45 */     for (Map.Entry<Integer, FurnitureUuIds> _e_ : this.court_yard_furnitures.entrySet()) {
/*  46 */       if (!((FurnitureUuIds)_e_.getValue())._validator_()) return false;
/*     */     }
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.compact_uint32(this.furnitures.size());
/*  53 */     for (Map.Entry<Integer, FurnitureUuIds> _e_ : this.furnitures.entrySet()) {
/*  54 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  55 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  57 */     _os_.compact_uint32(this.court_yard_furnitures.size());
/*  58 */     for (Map.Entry<Integer, FurnitureUuIds> _e_ : this.court_yard_furnitures.entrySet()) {
/*  59 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  60 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  66 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  68 */       int _k_ = _os_.unmarshal_int();
/*  69 */       FurnitureUuIds _v_ = new FurnitureUuIds();
/*  70 */       _v_.unmarshal(_os_);
/*  71 */       this.furnitures.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  73 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  75 */       int _k_ = _os_.unmarshal_int();
/*  76 */       FurnitureUuIds _v_ = new FurnitureUuIds();
/*  77 */       _v_.unmarshal(_os_);
/*  78 */       this.court_yard_furnitures.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  80 */     if (!_validator_()) {
/*  81 */       throw new VerifyError("validator failed");
/*     */     }
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  87 */     if (_o1_ == this) return true;
/*  88 */     if ((_o1_ instanceof SSynOwnFurnitureRes)) {
/*  89 */       SSynOwnFurnitureRes _o_ = (SSynOwnFurnitureRes)_o1_;
/*  90 */       if (!this.furnitures.equals(_o_.furnitures)) return false;
/*  91 */       if (!this.court_yard_furnitures.equals(_o_.court_yard_furnitures)) return false;
/*  92 */       return true;
/*     */     }
/*  94 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  98 */     int _h_ = 0;
/*  99 */     _h_ += this.furnitures.hashCode();
/* 100 */     _h_ += this.court_yard_furnitures.hashCode();
/* 101 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 105 */     StringBuilder _sb_ = new StringBuilder();
/* 106 */     _sb_.append("(");
/* 107 */     _sb_.append(this.furnitures).append(",");
/* 108 */     _sb_.append(this.court_yard_furnitures).append(",");
/* 109 */     _sb_.append(")");
/* 110 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\SSynOwnFurnitureRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */