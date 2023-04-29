/*     */ package mzm.gsp.item;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.item.main.PLockEquipHun;
/*     */ 
/*     */ public class CLockHunReq extends __CLockHunReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584787;
/*     */   public int bagid;
/*     */   public long uuid;
/*     */   public byte hunindex;
/*     */   public byte isautocostyuanbao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  18 */     long roleid = Role.getRoleId(this);
/*  19 */     Role.addRoleProcedure(roleid, new PLockEquipHun(roleid, this.bagid, this.uuid, this.hunindex, this.isautocostyuanbao == 1));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  27 */     return 12584787;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CLockHunReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CLockHunReq(int _bagid_, long _uuid_, byte _hunindex_, byte _isautocostyuanbao_)
/*     */   {
/*  39 */     this.bagid = _bagid_;
/*  40 */     this.uuid = _uuid_;
/*  41 */     this.hunindex = _hunindex_;
/*  42 */     this.isautocostyuanbao = _isautocostyuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.bagid);
/*  51 */     _os_.marshal(this.uuid);
/*  52 */     _os_.marshal(this.hunindex);
/*  53 */     _os_.marshal(this.isautocostyuanbao);
/*  54 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  58 */     this.bagid = _os_.unmarshal_int();
/*  59 */     this.uuid = _os_.unmarshal_long();
/*  60 */     this.hunindex = _os_.unmarshal_byte();
/*  61 */     this.isautocostyuanbao = _os_.unmarshal_byte();
/*  62 */     if (!_validator_()) {
/*  63 */       throw new VerifyError("validator failed");
/*     */     }
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  69 */     if (_o1_ == this) return true;
/*  70 */     if ((_o1_ instanceof CLockHunReq)) {
/*  71 */       CLockHunReq _o_ = (CLockHunReq)_o1_;
/*  72 */       if (this.bagid != _o_.bagid) return false;
/*  73 */       if (this.uuid != _o_.uuid) return false;
/*  74 */       if (this.hunindex != _o_.hunindex) return false;
/*  75 */       if (this.isautocostyuanbao != _o_.isautocostyuanbao) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.bagid;
/*  84 */     _h_ += (int)this.uuid;
/*  85 */     _h_ += this.hunindex;
/*  86 */     _h_ += this.isautocostyuanbao;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.bagid).append(",");
/*  94 */     _sb_.append(this.uuid).append(",");
/*  95 */     _sb_.append(this.hunindex).append(",");
/*  96 */     _sb_.append(this.isautocostyuanbao).append(",");
/*  97 */     _sb_.append(")");
/*  98 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CLockHunReq _o_) {
/* 102 */     if (_o_ == this) return 0;
/* 103 */     int _c_ = 0;
/* 104 */     _c_ = this.bagid - _o_.bagid;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = Long.signum(this.uuid - _o_.uuid);
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = this.hunindex - _o_.hunindex;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.isautocostyuanbao - _o_.isautocostyuanbao;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CLockHunReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */