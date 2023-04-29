/*     */ package mzm.gsp.market;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.pet.PetInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SQueryPetInfoRes
/*     */   extends __SQueryPetInfoRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601348;
/*     */   public long marketid;
/*     */   public int petcfgid;
/*     */   public int price;
/*     */   public MarketPet marketpet;
/*     */   public PetInfo petinfo;
/*     */   public long sellerroleid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12601348;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SQueryPetInfoRes()
/*     */   {
/*  36 */     this.marketpet = new MarketPet();
/*  37 */     this.petinfo = new PetInfo();
/*     */   }
/*     */   
/*     */   public SQueryPetInfoRes(long _marketid_, int _petcfgid_, int _price_, MarketPet _marketpet_, PetInfo _petinfo_, long _sellerroleid_) {
/*  41 */     this.marketid = _marketid_;
/*  42 */     this.petcfgid = _petcfgid_;
/*  43 */     this.price = _price_;
/*  44 */     this.marketpet = _marketpet_;
/*  45 */     this.petinfo = _petinfo_;
/*  46 */     this.sellerroleid = _sellerroleid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     if (!this.marketpet._validator_()) return false;
/*  51 */     if (!this.petinfo._validator_()) return false;
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.marketid);
/*  57 */     _os_.marshal(this.petcfgid);
/*  58 */     _os_.marshal(this.price);
/*  59 */     _os_.marshal(this.marketpet);
/*  60 */     _os_.marshal(this.petinfo);
/*  61 */     _os_.marshal(this.sellerroleid);
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  66 */     this.marketid = _os_.unmarshal_long();
/*  67 */     this.petcfgid = _os_.unmarshal_int();
/*  68 */     this.price = _os_.unmarshal_int();
/*  69 */     this.marketpet.unmarshal(_os_);
/*  70 */     this.petinfo.unmarshal(_os_);
/*  71 */     this.sellerroleid = _os_.unmarshal_long();
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof SQueryPetInfoRes)) {
/*  81 */       SQueryPetInfoRes _o_ = (SQueryPetInfoRes)_o1_;
/*  82 */       if (this.marketid != _o_.marketid) return false;
/*  83 */       if (this.petcfgid != _o_.petcfgid) return false;
/*  84 */       if (this.price != _o_.price) return false;
/*  85 */       if (!this.marketpet.equals(_o_.marketpet)) return false;
/*  86 */       if (!this.petinfo.equals(_o_.petinfo)) return false;
/*  87 */       if (this.sellerroleid != _o_.sellerroleid) return false;
/*  88 */       return true;
/*     */     }
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  94 */     int _h_ = 0;
/*  95 */     _h_ += (int)this.marketid;
/*  96 */     _h_ += this.petcfgid;
/*  97 */     _h_ += this.price;
/*  98 */     _h_ += this.marketpet.hashCode();
/*  99 */     _h_ += this.petinfo.hashCode();
/* 100 */     _h_ += (int)this.sellerroleid;
/* 101 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 105 */     StringBuilder _sb_ = new StringBuilder();
/* 106 */     _sb_.append("(");
/* 107 */     _sb_.append(this.marketid).append(",");
/* 108 */     _sb_.append(this.petcfgid).append(",");
/* 109 */     _sb_.append(this.price).append(",");
/* 110 */     _sb_.append(this.marketpet).append(",");
/* 111 */     _sb_.append(this.petinfo).append(",");
/* 112 */     _sb_.append(this.sellerroleid).append(",");
/* 113 */     _sb_.append(")");
/* 114 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\SQueryPetInfoRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */