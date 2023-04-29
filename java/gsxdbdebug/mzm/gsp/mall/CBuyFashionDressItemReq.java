/*     */ package mzm.gsp.mall;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.mall.main.PCBuyFashionDressItemReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CBuyFashionDressItemReq
/*     */   extends __CBuyFashionDressItemReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12585485;
/*     */   public int itemid;
/*     */   public int count;
/*     */   public long clientyuanbao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     if (roleid < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleid, new PCBuyFashionDressItemReq(roleid, this.itemid, this.count, this.clientyuanbao));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12585485;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CBuyFashionDressItemReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CBuyFashionDressItemReq(int _itemid_, int _count_, long _clientyuanbao_)
/*     */   {
/*  44 */     this.itemid = _itemid_;
/*  45 */     this.count = _count_;
/*  46 */     this.clientyuanbao = _clientyuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.itemid);
/*  55 */     _os_.marshal(this.count);
/*  56 */     _os_.marshal(this.clientyuanbao);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.itemid = _os_.unmarshal_int();
/*  62 */     this.count = _os_.unmarshal_int();
/*  63 */     this.clientyuanbao = _os_.unmarshal_long();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof CBuyFashionDressItemReq)) {
/*  73 */       CBuyFashionDressItemReq _o_ = (CBuyFashionDressItemReq)_o1_;
/*  74 */       if (this.itemid != _o_.itemid) return false;
/*  75 */       if (this.count != _o_.count) return false;
/*  76 */       if (this.clientyuanbao != _o_.clientyuanbao) return false;
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int _h_ = 0;
/*  84 */     _h_ += this.itemid;
/*  85 */     _h_ += this.count;
/*  86 */     _h_ += (int)this.clientyuanbao;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.itemid).append(",");
/*  94 */     _sb_.append(this.count).append(",");
/*  95 */     _sb_.append(this.clientyuanbao).append(",");
/*  96 */     _sb_.append(")");
/*  97 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CBuyFashionDressItemReq _o_) {
/* 101 */     if (_o_ == this) return 0;
/* 102 */     int _c_ = 0;
/* 103 */     _c_ = this.itemid - _o_.itemid;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.count - _o_.count;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = Long.signum(this.clientyuanbao - _o_.clientyuanbao);
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mall\CBuyFashionDressItemReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */