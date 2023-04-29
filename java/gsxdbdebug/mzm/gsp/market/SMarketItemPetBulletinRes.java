/*     */ package mzm.gsp.market;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SMarketItemPetBulletinRes
/*     */   extends __SMarketItemPetBulletinRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12601451;
/*     */   public String rolename;
/*     */   public int price;
/*     */   public int itemidorpetcfgid;
/*     */   public int puborsell;
/*     */   public long marketid;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12601451;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SMarketItemPetBulletinRes()
/*     */   {
/*  35 */     this.rolename = "";
/*     */   }
/*     */   
/*     */   public SMarketItemPetBulletinRes(String _rolename_, int _price_, int _itemidorpetcfgid_, int _puborsell_, long _marketid_) {
/*  39 */     this.rolename = _rolename_;
/*  40 */     this.price = _price_;
/*  41 */     this.itemidorpetcfgid = _itemidorpetcfgid_;
/*  42 */     this.puborsell = _puborsell_;
/*  43 */     this.marketid = _marketid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.rolename, "UTF-16LE");
/*  52 */     _os_.marshal(this.price);
/*  53 */     _os_.marshal(this.itemidorpetcfgid);
/*  54 */     _os_.marshal(this.puborsell);
/*  55 */     _os_.marshal(this.marketid);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.rolename = _os_.unmarshal_String("UTF-16LE");
/*  61 */     this.price = _os_.unmarshal_int();
/*  62 */     this.itemidorpetcfgid = _os_.unmarshal_int();
/*  63 */     this.puborsell = _os_.unmarshal_int();
/*  64 */     this.marketid = _os_.unmarshal_long();
/*  65 */     if (!_validator_()) {
/*  66 */       throw new VerifyError("validator failed");
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  72 */     if (_o1_ == this) return true;
/*  73 */     if ((_o1_ instanceof SMarketItemPetBulletinRes)) {
/*  74 */       SMarketItemPetBulletinRes _o_ = (SMarketItemPetBulletinRes)_o1_;
/*  75 */       if (!this.rolename.equals(_o_.rolename)) return false;
/*  76 */       if (this.price != _o_.price) return false;
/*  77 */       if (this.itemidorpetcfgid != _o_.itemidorpetcfgid) return false;
/*  78 */       if (this.puborsell != _o_.puborsell) return false;
/*  79 */       if (this.marketid != _o_.marketid) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += this.rolename.hashCode();
/*  88 */     _h_ += this.price;
/*  89 */     _h_ += this.itemidorpetcfgid;
/*  90 */     _h_ += this.puborsell;
/*  91 */     _h_ += (int)this.marketid;
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append("T").append(this.rolename.length()).append(",");
/*  99 */     _sb_.append(this.price).append(",");
/* 100 */     _sb_.append(this.itemidorpetcfgid).append(",");
/* 101 */     _sb_.append(this.puborsell).append(",");
/* 102 */     _sb_.append(this.marketid).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\market\SMarketItemPetBulletinRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */