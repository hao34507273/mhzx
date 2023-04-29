/*     */ package mzm.gsp.petarena;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.petarena.main.PCGetDefendPetTeam;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CGetDefendPetTeam
/*     */   extends __CGetDefendPetTeam__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12628243;
/*     */   public long target_roleid;
/*     */   public int rank;
/*     */   public int serial;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 1L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCGetDefendPetTeam(roleId, this.target_roleid, this.rank, this.serial));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12628243;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetDefendPetTeam() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetDefendPetTeam(long _target_roleid_, int _rank_, int _serial_)
/*     */   {
/*  44 */     this.target_roleid = _target_roleid_;
/*  45 */     this.rank = _rank_;
/*  46 */     this.serial = _serial_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.target_roleid);
/*  55 */     _os_.marshal(this.rank);
/*  56 */     _os_.marshal(this.serial);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.target_roleid = _os_.unmarshal_long();
/*  62 */     this.rank = _os_.unmarshal_int();
/*  63 */     this.serial = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof CGetDefendPetTeam)) {
/*  73 */       CGetDefendPetTeam _o_ = (CGetDefendPetTeam)_o1_;
/*  74 */       if (this.target_roleid != _o_.target_roleid) return false;
/*  75 */       if (this.rank != _o_.rank) return false;
/*  76 */       if (this.serial != _o_.serial) return false;
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int _h_ = 0;
/*  84 */     _h_ += (int)this.target_roleid;
/*  85 */     _h_ += this.rank;
/*  86 */     _h_ += this.serial;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.target_roleid).append(",");
/*  94 */     _sb_.append(this.rank).append(",");
/*  95 */     _sb_.append(this.serial).append(",");
/*  96 */     _sb_.append(")");
/*  97 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGetDefendPetTeam _o_) {
/* 101 */     if (_o_ == this) return 0;
/* 102 */     int _c_ = 0;
/* 103 */     _c_ = Long.signum(this.target_roleid - _o_.target_roleid);
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.rank - _o_.rank;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = this.serial - _o_.serial;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\CGetDefendPetTeam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */