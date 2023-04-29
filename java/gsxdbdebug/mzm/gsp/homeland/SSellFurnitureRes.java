/*     */ package mzm.gsp.homeland;
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
/*     */ public class SSellFurnitureRes
/*     */   extends __SSellFurnitureRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12605467;
/*     */   public long furnitureuuid;
/*     */   public int furnitureid;
/*     */   public int moneytype;
/*     */   public int moneynum;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12605467;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSellFurnitureRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public SSellFurnitureRes(long _furnitureuuid_, int _furnitureid_, int _moneytype_, int _moneynum_)
/*     */   {
/*  37 */     this.furnitureuuid = _furnitureuuid_;
/*  38 */     this.furnitureid = _furnitureid_;
/*  39 */     this.moneytype = _moneytype_;
/*  40 */     this.moneynum = _moneynum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  48 */     _os_.marshal(this.furnitureuuid);
/*  49 */     _os_.marshal(this.furnitureid);
/*  50 */     _os_.marshal(this.moneytype);
/*  51 */     _os_.marshal(this.moneynum);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  56 */     this.furnitureuuid = _os_.unmarshal_long();
/*  57 */     this.furnitureid = _os_.unmarshal_int();
/*  58 */     this.moneytype = _os_.unmarshal_int();
/*  59 */     this.moneynum = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof SSellFurnitureRes)) {
/*  69 */       SSellFurnitureRes _o_ = (SSellFurnitureRes)_o1_;
/*  70 */       if (this.furnitureuuid != _o_.furnitureuuid) return false;
/*  71 */       if (this.furnitureid != _o_.furnitureid) return false;
/*  72 */       if (this.moneytype != _o_.moneytype) return false;
/*  73 */       if (this.moneynum != _o_.moneynum) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += (int)this.furnitureuuid;
/*  82 */     _h_ += this.furnitureid;
/*  83 */     _h_ += this.moneytype;
/*  84 */     _h_ += this.moneynum;
/*  85 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  89 */     StringBuilder _sb_ = new StringBuilder();
/*  90 */     _sb_.append("(");
/*  91 */     _sb_.append(this.furnitureuuid).append(",");
/*  92 */     _sb_.append(this.furnitureid).append(",");
/*  93 */     _sb_.append(this.moneytype).append(",");
/*  94 */     _sb_.append(this.moneynum).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(SSellFurnitureRes _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = Long.signum(this.furnitureuuid - _o_.furnitureuuid);
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.furnitureid - _o_.furnitureid;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.moneytype - _o_.moneytype;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.moneynum - _o_.moneynum;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\homeland\SSellFurnitureRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */