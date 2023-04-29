/*     */ package mzm.gsp.fabao;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.item.ItemInfo;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SLongjingPropertyTransferRes
/*     */   extends __SLongjingPropertyTransferRes__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596037;
/*     */   public long totransferitemuuid;
/*     */   public int beforeitemid;
/*     */   public ItemInfo targetiteminfo;
/*     */   public int resttransfercount;
/*     */   public int moneynum;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  25 */     return 12596037;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SLongjingPropertyTransferRes()
/*     */   {
/*  35 */     this.targetiteminfo = new ItemInfo();
/*     */   }
/*     */   
/*     */   public SLongjingPropertyTransferRes(long _totransferitemuuid_, int _beforeitemid_, ItemInfo _targetiteminfo_, int _resttransfercount_, int _moneynum_) {
/*  39 */     this.totransferitemuuid = _totransferitemuuid_;
/*  40 */     this.beforeitemid = _beforeitemid_;
/*  41 */     this.targetiteminfo = _targetiteminfo_;
/*  42 */     this.resttransfercount = _resttransfercount_;
/*  43 */     this.moneynum = _moneynum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     if (!this.targetiteminfo._validator_()) return false;
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.totransferitemuuid);
/*  53 */     _os_.marshal(this.beforeitemid);
/*  54 */     _os_.marshal(this.targetiteminfo);
/*  55 */     _os_.marshal(this.resttransfercount);
/*  56 */     _os_.marshal(this.moneynum);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.totransferitemuuid = _os_.unmarshal_long();
/*  62 */     this.beforeitemid = _os_.unmarshal_int();
/*  63 */     this.targetiteminfo.unmarshal(_os_);
/*  64 */     this.resttransfercount = _os_.unmarshal_int();
/*  65 */     this.moneynum = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof SLongjingPropertyTransferRes)) {
/*  75 */       SLongjingPropertyTransferRes _o_ = (SLongjingPropertyTransferRes)_o1_;
/*  76 */       if (this.totransferitemuuid != _o_.totransferitemuuid) return false;
/*  77 */       if (this.beforeitemid != _o_.beforeitemid) return false;
/*  78 */       if (!this.targetiteminfo.equals(_o_.targetiteminfo)) return false;
/*  79 */       if (this.resttransfercount != _o_.resttransfercount) return false;
/*  80 */       if (this.moneynum != _o_.moneynum) return false;
/*  81 */       return true;
/*     */     }
/*  83 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  87 */     int _h_ = 0;
/*  88 */     _h_ += (int)this.totransferitemuuid;
/*  89 */     _h_ += this.beforeitemid;
/*  90 */     _h_ += this.targetiteminfo.hashCode();
/*  91 */     _h_ += this.resttransfercount;
/*  92 */     _h_ += this.moneynum;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.totransferitemuuid).append(",");
/* 100 */     _sb_.append(this.beforeitemid).append(",");
/* 101 */     _sb_.append(this.targetiteminfo).append(",");
/* 102 */     _sb_.append(this.resttransfercount).append(",");
/* 103 */     _sb_.append(this.moneynum).append(",");
/* 104 */     _sb_.append(")");
/* 105 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\SLongjingPropertyTransferRes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */