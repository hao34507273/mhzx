/*     */ package mzm.gsp.mall;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.mall.main.PBuyLimitItem;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CBuyLimitItemReq
/*     */   extends __CBuyLimitItemReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12585478;
/*     */   public int itemid;
/*     */   public int count;
/*     */   public long clientyuanbao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     Role.addRoleProcedure(roleid, new PBuyLimitItem(roleid, this.itemid, this.count, this.clientyuanbao));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  30 */     return 12585478;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CBuyLimitItemReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CBuyLimitItemReq(int _itemid_, int _count_, long _clientyuanbao_)
/*     */   {
/*  41 */     this.itemid = _itemid_;
/*  42 */     this.count = _count_;
/*  43 */     this.clientyuanbao = _clientyuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.itemid);
/*  52 */     _os_.marshal(this.count);
/*  53 */     _os_.marshal(this.clientyuanbao);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.itemid = _os_.unmarshal_int();
/*  59 */     this.count = _os_.unmarshal_int();
/*  60 */     this.clientyuanbao = _os_.unmarshal_long();
/*  61 */     if (!_validator_()) {
/*  62 */       throw new VerifyError("validator failed");
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  68 */     if (_o1_ == this) return true;
/*  69 */     if ((_o1_ instanceof CBuyLimitItemReq)) {
/*  70 */       CBuyLimitItemReq _o_ = (CBuyLimitItemReq)_o1_;
/*  71 */       if (this.itemid != _o_.itemid) return false;
/*  72 */       if (this.count != _o_.count) return false;
/*  73 */       if (this.clientyuanbao != _o_.clientyuanbao) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += this.itemid;
/*  82 */     _h_ += this.count;
/*  83 */     _h_ += (int)this.clientyuanbao;
/*  84 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  88 */     StringBuilder _sb_ = new StringBuilder();
/*  89 */     _sb_.append("(");
/*  90 */     _sb_.append(this.itemid).append(",");
/*  91 */     _sb_.append(this.count).append(",");
/*  92 */     _sb_.append(this.clientyuanbao).append(",");
/*  93 */     _sb_.append(")");
/*  94 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CBuyLimitItemReq _o_) {
/*  98 */     if (_o_ == this) return 0;
/*  99 */     int _c_ = 0;
/* 100 */     _c_ = this.itemid - _o_.itemid;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = this.count - _o_.count;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = Long.signum(this.clientyuanbao - _o_.clientyuanbao);
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\CBuyLimitItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */