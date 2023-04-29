/*     */ package mzm.gsp.item;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.item.main.PExchangeItem;
/*     */ 
/*     */ public class CExchangeUseItem
/*     */   extends __CExchangeUseItem__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584764;
/*     */   public int exchangecfgid;
/*     */   public int exchangecount;
/*     */   public long clientneedyuanbao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  18 */     long roleid = Role.getRoleId(this);
/*  19 */     Role.addRoleProcedure(roleid, new PExchangeItem(roleid, this.exchangecfgid, this.exchangecount, this.clientneedyuanbao));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  28 */     return 12584764;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CExchangeUseItem() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CExchangeUseItem(int _exchangecfgid_, int _exchangecount_, long _clientneedyuanbao_)
/*     */   {
/*  39 */     this.exchangecfgid = _exchangecfgid_;
/*  40 */     this.exchangecount = _exchangecount_;
/*  41 */     this.clientneedyuanbao = _clientneedyuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  49 */     _os_.marshal(this.exchangecfgid);
/*  50 */     _os_.marshal(this.exchangecount);
/*  51 */     _os_.marshal(this.clientneedyuanbao);
/*  52 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  56 */     this.exchangecfgid = _os_.unmarshal_int();
/*  57 */     this.exchangecount = _os_.unmarshal_int();
/*  58 */     this.clientneedyuanbao = _os_.unmarshal_long();
/*  59 */     if (!_validator_()) {
/*  60 */       throw new VerifyError("validator failed");
/*     */     }
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  66 */     if (_o1_ == this) return true;
/*  67 */     if ((_o1_ instanceof CExchangeUseItem)) {
/*  68 */       CExchangeUseItem _o_ = (CExchangeUseItem)_o1_;
/*  69 */       if (this.exchangecfgid != _o_.exchangecfgid) return false;
/*  70 */       if (this.exchangecount != _o_.exchangecount) return false;
/*  71 */       if (this.clientneedyuanbao != _o_.clientneedyuanbao) return false;
/*  72 */       return true;
/*     */     }
/*  74 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  78 */     int _h_ = 0;
/*  79 */     _h_ += this.exchangecfgid;
/*  80 */     _h_ += this.exchangecount;
/*  81 */     _h_ += (int)this.clientneedyuanbao;
/*  82 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  86 */     StringBuilder _sb_ = new StringBuilder();
/*  87 */     _sb_.append("(");
/*  88 */     _sb_.append(this.exchangecfgid).append(",");
/*  89 */     _sb_.append(this.exchangecount).append(",");
/*  90 */     _sb_.append(this.clientneedyuanbao).append(",");
/*  91 */     _sb_.append(")");
/*  92 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CExchangeUseItem _o_) {
/*  96 */     if (_o_ == this) return 0;
/*  97 */     int _c_ = 0;
/*  98 */     _c_ = this.exchangecfgid - _o_.exchangecfgid;
/*  99 */     if (0 != _c_) return _c_;
/* 100 */     _c_ = this.exchangecount - _o_.exchangecount;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = Long.signum(this.clientneedyuanbao - _o_.clientneedyuanbao);
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CExchangeUseItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */