/*     */ package mzm.gsp.mall;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.mall.main.PExchangeItemUseJifen;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CExchangeItemUseJifen
/*     */   extends __CExchangeItemUseJifen__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12585483;
/*     */   public int jifentype;
/*     */   public int itemid;
/*     */   public int count;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     Role.addRoleProcedure(roleid, new PExchangeItemUseJifen(roleid, this.itemid, this.count, this.jifentype));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  30 */     return 12585483;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CExchangeItemUseJifen() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CExchangeItemUseJifen(int _jifentype_, int _itemid_, int _count_)
/*     */   {
/*  41 */     this.jifentype = _jifentype_;
/*  42 */     this.itemid = _itemid_;
/*  43 */     this.count = _count_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.jifentype);
/*  52 */     _os_.marshal(this.itemid);
/*  53 */     _os_.marshal(this.count);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.jifentype = _os_.unmarshal_int();
/*  59 */     this.itemid = _os_.unmarshal_int();
/*  60 */     this.count = _os_.unmarshal_int();
/*  61 */     if (!_validator_()) {
/*  62 */       throw new VerifyError("validator failed");
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  68 */     if (_o1_ == this) return true;
/*  69 */     if ((_o1_ instanceof CExchangeItemUseJifen)) {
/*  70 */       CExchangeItemUseJifen _o_ = (CExchangeItemUseJifen)_o1_;
/*  71 */       if (this.jifentype != _o_.jifentype) return false;
/*  72 */       if (this.itemid != _o_.itemid) return false;
/*  73 */       if (this.count != _o_.count) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += this.jifentype;
/*  82 */     _h_ += this.itemid;
/*  83 */     _h_ += this.count;
/*  84 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  88 */     StringBuilder _sb_ = new StringBuilder();
/*  89 */     _sb_.append("(");
/*  90 */     _sb_.append(this.jifentype).append(",");
/*  91 */     _sb_.append(this.itemid).append(",");
/*  92 */     _sb_.append(this.count).append(",");
/*  93 */     _sb_.append(")");
/*  94 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CExchangeItemUseJifen _o_) {
/*  98 */     if (_o_ == this) return 0;
/*  99 */     int _c_ = 0;
/* 100 */     _c_ = this.jifentype - _o_.jifentype;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = this.itemid - _o_.itemid;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.count - _o_.count;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\CExchangeItemUseJifen.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */