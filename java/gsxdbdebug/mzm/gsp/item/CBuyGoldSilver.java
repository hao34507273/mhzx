/*     */ package mzm.gsp.item;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.item.main.PBuyGoldSilver;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CBuyGoldSilver
/*     */   extends __CBuyGoldSilver__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584790;
/*     */   public int yuanbaonum;
/*     */   public int moneytype;
/*     */   public long clientyuanbao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     Role.addRoleProcedure(roleid, new PBuyGoldSilver(roleid, this.yuanbaonum, this.moneytype, this.clientyuanbao));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  30 */     return 12584790;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CBuyGoldSilver() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CBuyGoldSilver(int _yuanbaonum_, int _moneytype_, long _clientyuanbao_)
/*     */   {
/*  41 */     this.yuanbaonum = _yuanbaonum_;
/*  42 */     this.moneytype = _moneytype_;
/*  43 */     this.clientyuanbao = _clientyuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.yuanbaonum);
/*  52 */     _os_.marshal(this.moneytype);
/*  53 */     _os_.marshal(this.clientyuanbao);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.yuanbaonum = _os_.unmarshal_int();
/*  59 */     this.moneytype = _os_.unmarshal_int();
/*  60 */     this.clientyuanbao = _os_.unmarshal_long();
/*  61 */     if (!_validator_()) {
/*  62 */       throw new VerifyError("validator failed");
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  68 */     if (_o1_ == this) return true;
/*  69 */     if ((_o1_ instanceof CBuyGoldSilver)) {
/*  70 */       CBuyGoldSilver _o_ = (CBuyGoldSilver)_o1_;
/*  71 */       if (this.yuanbaonum != _o_.yuanbaonum) return false;
/*  72 */       if (this.moneytype != _o_.moneytype) return false;
/*  73 */       if (this.clientyuanbao != _o_.clientyuanbao) return false;
/*  74 */       return true;
/*     */     }
/*  76 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  80 */     int _h_ = 0;
/*  81 */     _h_ += this.yuanbaonum;
/*  82 */     _h_ += this.moneytype;
/*  83 */     _h_ += (int)this.clientyuanbao;
/*  84 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  88 */     StringBuilder _sb_ = new StringBuilder();
/*  89 */     _sb_.append("(");
/*  90 */     _sb_.append(this.yuanbaonum).append(",");
/*  91 */     _sb_.append(this.moneytype).append(",");
/*  92 */     _sb_.append(this.clientyuanbao).append(",");
/*  93 */     _sb_.append(")");
/*  94 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CBuyGoldSilver _o_) {
/*  98 */     if (_o_ == this) return 0;
/*  99 */     int _c_ = 0;
/* 100 */     _c_ = this.yuanbaonum - _o_.yuanbaonum;
/* 101 */     if (0 != _c_) return _c_;
/* 102 */     _c_ = this.moneytype - _o_.moneytype;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = Long.signum(this.clientyuanbao - _o_.clientyuanbao);
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CBuyGoldSilver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */