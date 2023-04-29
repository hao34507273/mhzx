/*     */ package mzm.gsp.fabao;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.fabao.main.PFabaoUpRankReq;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CFabaoUpRankReq
/*     */   extends __CFabaoUpRankReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12595970;
/*     */   public int equiped;
/*     */   public long fabaouuid;
/*     */   public int useyuanbao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     Role.addRoleProcedure(roleid, new PFabaoUpRankReq(roleid, this.equiped, this.fabaouuid, this.useyuanbao));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  29 */     return 12595970;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CFabaoUpRankReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CFabaoUpRankReq(int _equiped_, long _fabaouuid_, int _useyuanbao_)
/*     */   {
/*  40 */     this.equiped = _equiped_;
/*  41 */     this.fabaouuid = _fabaouuid_;
/*  42 */     this.useyuanbao = _useyuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  46 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  50 */     _os_.marshal(this.equiped);
/*  51 */     _os_.marshal(this.fabaouuid);
/*  52 */     _os_.marshal(this.useyuanbao);
/*  53 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  57 */     this.equiped = _os_.unmarshal_int();
/*  58 */     this.fabaouuid = _os_.unmarshal_long();
/*  59 */     this.useyuanbao = _os_.unmarshal_int();
/*  60 */     if (!_validator_()) {
/*  61 */       throw new VerifyError("validator failed");
/*     */     }
/*  63 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  67 */     if (_o1_ == this) return true;
/*  68 */     if ((_o1_ instanceof CFabaoUpRankReq)) {
/*  69 */       CFabaoUpRankReq _o_ = (CFabaoUpRankReq)_o1_;
/*  70 */       if (this.equiped != _o_.equiped) return false;
/*  71 */       if (this.fabaouuid != _o_.fabaouuid) return false;
/*  72 */       if (this.useyuanbao != _o_.useyuanbao) return false;
/*  73 */       return true;
/*     */     }
/*  75 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  79 */     int _h_ = 0;
/*  80 */     _h_ += this.equiped;
/*  81 */     _h_ += (int)this.fabaouuid;
/*  82 */     _h_ += this.useyuanbao;
/*  83 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  87 */     StringBuilder _sb_ = new StringBuilder();
/*  88 */     _sb_.append("(");
/*  89 */     _sb_.append(this.equiped).append(",");
/*  90 */     _sb_.append(this.fabaouuid).append(",");
/*  91 */     _sb_.append(this.useyuanbao).append(",");
/*  92 */     _sb_.append(")");
/*  93 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CFabaoUpRankReq _o_) {
/*  97 */     if (_o_ == this) return 0;
/*  98 */     int _c_ = 0;
/*  99 */     _c_ = this.equiped - _o_.equiped;
/* 100 */     if (0 != _c_) return _c_;
/* 101 */     _c_ = Long.signum(this.fabaouuid - _o_.fabaouuid);
/* 102 */     if (0 != _c_) return _c_;
/* 103 */     _c_ = this.useyuanbao - _o_.useyuanbao;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\CFabaoUpRankReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */