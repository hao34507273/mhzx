/*     */ package mzm.gsp.fabao;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.fabao.main.PFabaoAddRankScore;
/*     */ 
/*     */ 
/*     */ public class CFabaoAddRankScoreReq
/*     */   extends __CFabaoAddRankScoreReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596000;
/*     */   public int equiped;
/*     */   public long fabaouuid;
/*     */   public int itemkey;
/*     */   public int itemcount;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     Role.addRoleProcedure(roleid, new PFabaoAddRankScore(roleid, this.equiped, this.fabaouuid, this.itemkey, this.itemcount));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  29 */     return 12596000;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CFabaoAddRankScoreReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CFabaoAddRankScoreReq(int _equiped_, long _fabaouuid_, int _itemkey_, int _itemcount_)
/*     */   {
/*  41 */     this.equiped = _equiped_;
/*  42 */     this.fabaouuid = _fabaouuid_;
/*  43 */     this.itemkey = _itemkey_;
/*  44 */     this.itemcount = _itemcount_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.marshal(this.equiped);
/*  53 */     _os_.marshal(this.fabaouuid);
/*  54 */     _os_.marshal(this.itemkey);
/*  55 */     _os_.marshal(this.itemcount);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.equiped = _os_.unmarshal_int();
/*  61 */     this.fabaouuid = _os_.unmarshal_long();
/*  62 */     this.itemkey = _os_.unmarshal_int();
/*  63 */     this.itemcount = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof CFabaoAddRankScoreReq)) {
/*  73 */       CFabaoAddRankScoreReq _o_ = (CFabaoAddRankScoreReq)_o1_;
/*  74 */       if (this.equiped != _o_.equiped) return false;
/*  75 */       if (this.fabaouuid != _o_.fabaouuid) return false;
/*  76 */       if (this.itemkey != _o_.itemkey) return false;
/*  77 */       if (this.itemcount != _o_.itemcount) return false;
/*  78 */       return true;
/*     */     }
/*  80 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  84 */     int _h_ = 0;
/*  85 */     _h_ += this.equiped;
/*  86 */     _h_ += (int)this.fabaouuid;
/*  87 */     _h_ += this.itemkey;
/*  88 */     _h_ += this.itemcount;
/*  89 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  93 */     StringBuilder _sb_ = new StringBuilder();
/*  94 */     _sb_.append("(");
/*  95 */     _sb_.append(this.equiped).append(",");
/*  96 */     _sb_.append(this.fabaouuid).append(",");
/*  97 */     _sb_.append(this.itemkey).append(",");
/*  98 */     _sb_.append(this.itemcount).append(",");
/*  99 */     _sb_.append(")");
/* 100 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CFabaoAddRankScoreReq _o_) {
/* 104 */     if (_o_ == this) return 0;
/* 105 */     int _c_ = 0;
/* 106 */     _c_ = this.equiped - _o_.equiped;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     _c_ = Long.signum(this.fabaouuid - _o_.fabaouuid);
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.itemkey - _o_.itemkey;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.itemcount - _o_.itemcount;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\CFabaoAddRankScoreReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */