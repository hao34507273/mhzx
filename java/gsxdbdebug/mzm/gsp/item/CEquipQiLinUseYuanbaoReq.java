/*     */ package mzm.gsp.item;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.item.main.PEquipQiLinUseYuanbaoReq;
/*     */ 
/*     */ public class CEquipQiLinUseYuanbaoReq extends __CEquipQiLinUseYuanbaoReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584853;
/*     */   public int bagid;
/*     */   public int key;
/*     */   public int itemid;
/*     */   public int itemnum;
/*     */   public int clientneedyuanbao;
/*     */   public long clientyuanbao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     Role.addRoleProcedure(roleid, new PEquipQiLinUseYuanbaoReq(roleid, this.bagid, this.key, this.itemid, this.itemnum, this.clientneedyuanbao, this.clientyuanbao));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  29 */     return 12584853;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CEquipQiLinUseYuanbaoReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CEquipQiLinUseYuanbaoReq(int _bagid_, int _key_, int _itemid_, int _itemnum_, int _clientneedyuanbao_, long _clientyuanbao_)
/*     */   {
/*  43 */     this.bagid = _bagid_;
/*  44 */     this.key = _key_;
/*  45 */     this.itemid = _itemid_;
/*  46 */     this.itemnum = _itemnum_;
/*  47 */     this.clientneedyuanbao = _clientneedyuanbao_;
/*  48 */     this.clientyuanbao = _clientyuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.bagid);
/*  57 */     _os_.marshal(this.key);
/*  58 */     _os_.marshal(this.itemid);
/*  59 */     _os_.marshal(this.itemnum);
/*  60 */     _os_.marshal(this.clientneedyuanbao);
/*  61 */     _os_.marshal(this.clientyuanbao);
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  66 */     this.bagid = _os_.unmarshal_int();
/*  67 */     this.key = _os_.unmarshal_int();
/*  68 */     this.itemid = _os_.unmarshal_int();
/*  69 */     this.itemnum = _os_.unmarshal_int();
/*  70 */     this.clientneedyuanbao = _os_.unmarshal_int();
/*  71 */     this.clientyuanbao = _os_.unmarshal_long();
/*  72 */     if (!_validator_()) {
/*  73 */       throw new VerifyError("validator failed");
/*     */     }
/*  75 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  79 */     if (_o1_ == this) return true;
/*  80 */     if ((_o1_ instanceof CEquipQiLinUseYuanbaoReq)) {
/*  81 */       CEquipQiLinUseYuanbaoReq _o_ = (CEquipQiLinUseYuanbaoReq)_o1_;
/*  82 */       if (this.bagid != _o_.bagid) return false;
/*  83 */       if (this.key != _o_.key) return false;
/*  84 */       if (this.itemid != _o_.itemid) return false;
/*  85 */       if (this.itemnum != _o_.itemnum) return false;
/*  86 */       if (this.clientneedyuanbao != _o_.clientneedyuanbao) return false;
/*  87 */       if (this.clientyuanbao != _o_.clientyuanbao) return false;
/*  88 */       return true;
/*     */     }
/*  90 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  94 */     int _h_ = 0;
/*  95 */     _h_ += this.bagid;
/*  96 */     _h_ += this.key;
/*  97 */     _h_ += this.itemid;
/*  98 */     _h_ += this.itemnum;
/*  99 */     _h_ += this.clientneedyuanbao;
/* 100 */     _h_ += (int)this.clientyuanbao;
/* 101 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 105 */     StringBuilder _sb_ = new StringBuilder();
/* 106 */     _sb_.append("(");
/* 107 */     _sb_.append(this.bagid).append(",");
/* 108 */     _sb_.append(this.key).append(",");
/* 109 */     _sb_.append(this.itemid).append(",");
/* 110 */     _sb_.append(this.itemnum).append(",");
/* 111 */     _sb_.append(this.clientneedyuanbao).append(",");
/* 112 */     _sb_.append(this.clientyuanbao).append(",");
/* 113 */     _sb_.append(")");
/* 114 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CEquipQiLinUseYuanbaoReq _o_) {
/* 118 */     if (_o_ == this) return 0;
/* 119 */     int _c_ = 0;
/* 120 */     _c_ = this.bagid - _o_.bagid;
/* 121 */     if (0 != _c_) return _c_;
/* 122 */     _c_ = this.key - _o_.key;
/* 123 */     if (0 != _c_) return _c_;
/* 124 */     _c_ = this.itemid - _o_.itemid;
/* 125 */     if (0 != _c_) return _c_;
/* 126 */     _c_ = this.itemnum - _o_.itemnum;
/* 127 */     if (0 != _c_) return _c_;
/* 128 */     _c_ = this.clientneedyuanbao - _o_.clientneedyuanbao;
/* 129 */     if (0 != _c_) return _c_;
/* 130 */     _c_ = Long.signum(this.clientyuanbao - _o_.clientyuanbao);
/* 131 */     if (0 != _c_) return _c_;
/* 132 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CEquipQiLinUseYuanbaoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */