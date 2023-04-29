/*     */ package mzm.gsp.petarena;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.petarena.main.PCStartFight;
/*     */ 
/*     */ 
/*     */ public class CStartFight
/*     */   extends __CStartFight__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12628226;
/*     */   public long target_roleid;
/*     */   public int rank;
/*     */   public int teamid;
/*     */   public int serial;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 1L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PCStartFight(roleId, this.target_roleid, this.rank, this.teamid, this.serial));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12628226;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CStartFight() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CStartFight(long _target_roleid_, int _rank_, int _teamid_, int _serial_)
/*     */   {
/*  45 */     this.target_roleid = _target_roleid_;
/*  46 */     this.rank = _rank_;
/*  47 */     this.teamid = _teamid_;
/*  48 */     this.serial = _serial_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.target_roleid);
/*  57 */     _os_.marshal(this.rank);
/*  58 */     _os_.marshal(this.teamid);
/*  59 */     _os_.marshal(this.serial);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.target_roleid = _os_.unmarshal_long();
/*  65 */     this.rank = _os_.unmarshal_int();
/*  66 */     this.teamid = _os_.unmarshal_int();
/*  67 */     this.serial = _os_.unmarshal_int();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof CStartFight)) {
/*  77 */       CStartFight _o_ = (CStartFight)_o1_;
/*  78 */       if (this.target_roleid != _o_.target_roleid) return false;
/*  79 */       if (this.rank != _o_.rank) return false;
/*  80 */       if (this.teamid != _o_.teamid) return false;
/*  81 */       if (this.serial != _o_.serial) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += (int)this.target_roleid;
/*  90 */     _h_ += this.rank;
/*  91 */     _h_ += this.teamid;
/*  92 */     _h_ += this.serial;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.target_roleid).append(",");
/* 100 */     _sb_.append(this.rank).append(",");
/* 101 */     _sb_.append(this.teamid).append(",");
/* 102 */     _sb_.append(this.serial).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CStartFight _o_) {
/* 108 */     if (_o_ == this) return 0;
/* 109 */     int _c_ = 0;
/* 110 */     _c_ = Long.signum(this.target_roleid - _o_.target_roleid);
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.rank - _o_.rank;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = this.teamid - _o_.teamid;
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     _c_ = this.serial - _o_.serial;
/* 117 */     if (0 != _c_) return _c_;
/* 118 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\petarena\CStartFight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */