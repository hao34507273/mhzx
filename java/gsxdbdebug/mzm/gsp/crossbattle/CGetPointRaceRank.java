/*     */ package mzm.gsp.crossbattle;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.crossbattle.point.PCGetPointRaceRank;
/*     */ 
/*     */ 
/*     */ public class CGetPointRaceRank
/*     */   extends __CGetPointRaceRank__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12617021;
/*     */   public byte rank_type;
/*     */   public int from;
/*     */   public int to;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 1L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCGetPointRaceRank(roleId, this.rank_type, this.from, this.to));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12617021;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetPointRaceRank() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetPointRaceRank(byte _rank_type_, int _from_, int _to_)
/*     */   {
/*  43 */     this.rank_type = _rank_type_;
/*  44 */     this.from = _from_;
/*  45 */     this.to = _to_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.rank_type);
/*  54 */     _os_.marshal(this.from);
/*  55 */     _os_.marshal(this.to);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.rank_type = _os_.unmarshal_byte();
/*  61 */     this.from = _os_.unmarshal_int();
/*  62 */     this.to = _os_.unmarshal_int();
/*  63 */     if (!_validator_()) {
/*  64 */       throw new VerifyError("validator failed");
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof CGetPointRaceRank)) {
/*  72 */       CGetPointRaceRank _o_ = (CGetPointRaceRank)_o1_;
/*  73 */       if (this.rank_type != _o_.rank_type) return false;
/*  74 */       if (this.from != _o_.from) return false;
/*  75 */       if (this.to != _o_.to) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.rank_type;
/*  84 */     _h_ += this.from;
/*  85 */     _h_ += this.to;
/*  86 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  90 */     StringBuilder _sb_ = new StringBuilder();
/*  91 */     _sb_.append("(");
/*  92 */     _sb_.append(this.rank_type).append(",");
/*  93 */     _sb_.append(this.from).append(",");
/*  94 */     _sb_.append(this.to).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGetPointRaceRank _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = this.rank_type - _o_.rank_type;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.from - _o_.from;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.to - _o_.to;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\crossbattle\CGetPointRaceRank.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */