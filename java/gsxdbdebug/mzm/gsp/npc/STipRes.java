/*     */ package mzm.gsp.npc;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ 
/*     */ public class STipRes extends __STipRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12586754;
/*     */   public static final int SUCCESS = 0;
/*     */   public static final int YUANBAO_NOT_ENOUGH = 1;
/*     */   public static final int GOLD_NOT_ENOUGH = 2;
/*     */   public static final int SILVER_NOT_ENOUGH = 3;
/*     */   public static final int ITEMID_ERROR = 4;
/*     */   public static final int NPCTRADE_ERROR = 5;
/*     */   public static final int SERVICEID_ERROR = 6;
/*     */   public static final int BAG_SPACE_ERROR = 7;
/*     */   public static final int CLIENT_DATA_ERROR = 8;
/*     */   public static final int EXCEED_MAXNUM_ERROR = 9;
/*     */   public int ret;
/*     */   public int itemid;
/*     */   public int count;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType() {
/*  25 */     return 12586754;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public STipRes() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public STipRes(int _ret_, int _itemid_, int _count_)
/*     */   {
/*  47 */     this.ret = _ret_;
/*  48 */     this.itemid = _itemid_;
/*  49 */     this.count = _count_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.ret);
/*  58 */     _os_.marshal(this.itemid);
/*  59 */     _os_.marshal(this.count);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  64 */     this.ret = _os_.unmarshal_int();
/*  65 */     this.itemid = _os_.unmarshal_int();
/*  66 */     this.count = _os_.unmarshal_int();
/*  67 */     if (!_validator_()) {
/*  68 */       throw new VerifyError("validator failed");
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  74 */     if (_o1_ == this) return true;
/*  75 */     if ((_o1_ instanceof STipRes)) {
/*  76 */       STipRes _o_ = (STipRes)_o1_;
/*  77 */       if (this.ret != _o_.ret) return false;
/*  78 */       if (this.itemid != _o_.itemid) return false;
/*  79 */       if (this.count != _o_.count) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += this.ret;
/*  88 */     _h_ += this.itemid;
/*  89 */     _h_ += this.count;
/*  90 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  94 */     StringBuilder _sb_ = new StringBuilder();
/*  95 */     _sb_.append("(");
/*  96 */     _sb_.append(this.ret).append(",");
/*  97 */     _sb_.append(this.itemid).append(",");
/*  98 */     _sb_.append(this.count).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(STipRes _o_) {
/* 104 */     if (_o_ == this) return 0;
/* 105 */     int _c_ = 0;
/* 106 */     _c_ = this.ret - _o_.ret;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.itemid - _o_.itemid;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.count - _o_.count;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\npc\STipRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */