/*     */ package mzm.gsp.mall;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.mall.main.PBuyCurrentLimitItem;
/*     */ 
/*     */ 
/*     */ public class CBuyCurrentLimitItemReq
/*     */   extends __CBuyCurrentLimitItemReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12585486;
/*     */   public int malltype;
/*     */   public int itemid;
/*     */   public int count;
/*     */   public long clientyuanbao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     if (roleid <= 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleid, new PBuyCurrentLimitItem(roleid, this.malltype, this.itemid, this.count, this.clientyuanbao));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12585486;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CBuyCurrentLimitItemReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CBuyCurrentLimitItemReq(int _malltype_, int _itemid_, int _count_, long _clientyuanbao_)
/*     */   {
/*  45 */     this.malltype = _malltype_;
/*  46 */     this.itemid = _itemid_;
/*  47 */     this.count = _count_;
/*  48 */     this.clientyuanbao = _clientyuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.malltype);
/*  57 */     _os_.marshal(this.itemid);
/*  58 */     _os_.marshal(this.count);
/*  59 */     _os_.marshal(this.clientyuanbao);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.malltype = _os_.unmarshal_int();
/*  65 */     this.itemid = _os_.unmarshal_int();
/*  66 */     this.count = _os_.unmarshal_int();
/*  67 */     this.clientyuanbao = _os_.unmarshal_long();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof CBuyCurrentLimitItemReq)) {
/*  77 */       CBuyCurrentLimitItemReq _o_ = (CBuyCurrentLimitItemReq)_o1_;
/*  78 */       if (this.malltype != _o_.malltype) return false;
/*  79 */       if (this.itemid != _o_.itemid) return false;
/*  80 */       if (this.count != _o_.count) return false;
/*  81 */       if (this.clientyuanbao != _o_.clientyuanbao) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.malltype;
/*  90 */     _h_ += this.itemid;
/*  91 */     _h_ += this.count;
/*  92 */     _h_ += (int)this.clientyuanbao;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.malltype).append(",");
/* 100 */     _sb_.append(this.itemid).append(",");
/* 101 */     _sb_.append(this.count).append(",");
/* 102 */     _sb_.append(this.clientyuanbao).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CBuyCurrentLimitItemReq _o_) {
/* 108 */     if (_o_ == this) return 0;
/* 109 */     int _c_ = 0;
/* 110 */     _c_ = this.malltype - _o_.malltype;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.itemid - _o_.itemid;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = this.count - _o_.count;
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     _c_ = Long.signum(this.clientyuanbao - _o_.clientyuanbao);
/* 117 */     if (0 != _c_) return _c_;
/* 118 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\CBuyCurrentLimitItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */