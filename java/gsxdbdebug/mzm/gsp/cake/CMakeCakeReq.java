/*     */ package mzm.gsp.cake;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.cake.main.PCMakeCakeReq;
/*     */ 
/*     */ public class CMakeCakeReq extends __CMakeCakeReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12627714;
/*     */   public int activityid;
/*     */   public int clientturn;
/*     */   public long cakemasterid;
/*     */   public long uuid;
/*     */   public int num;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 1L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCMakeCakeReq(roleId, this.activityid, this.cakemasterid, this.uuid, this.num, this.clientturn));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12627714;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CMakeCakeReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CMakeCakeReq(int _activityid_, int _clientturn_, long _cakemasterid_, long _uuid_, int _num_)
/*     */   {
/*  45 */     this.activityid = _activityid_;
/*  46 */     this.clientturn = _clientturn_;
/*  47 */     this.cakemasterid = _cakemasterid_;
/*  48 */     this.uuid = _uuid_;
/*  49 */     this.num = _num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.activityid);
/*  58 */     _os_.marshal(this.clientturn);
/*  59 */     _os_.marshal(this.cakemasterid);
/*  60 */     _os_.marshal(this.uuid);
/*  61 */     _os_.marshal(this.num);
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  66 */     this.activityid = _os_.unmarshal_int();
/*  67 */     this.clientturn = _os_.unmarshal_int();
/*  68 */     this.cakemasterid = _os_.unmarshal_long();
/*  69 */     this.uuid = _os_.unmarshal_long();
/*  70 */     this.num = _os_.unmarshal_int();
/*  71 */     if (!_validator_()) {
/*  72 */       throw new VerifyError("validator failed");
/*     */     }
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  78 */     if (_o1_ == this) return true;
/*  79 */     if ((_o1_ instanceof CMakeCakeReq)) {
/*  80 */       CMakeCakeReq _o_ = (CMakeCakeReq)_o1_;
/*  81 */       if (this.activityid != _o_.activityid) return false;
/*  82 */       if (this.clientturn != _o_.clientturn) return false;
/*  83 */       if (this.cakemasterid != _o_.cakemasterid) return false;
/*  84 */       if (this.uuid != _o_.uuid) return false;
/*  85 */       if (this.num != _o_.num) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.activityid;
/*  94 */     _h_ += this.clientturn;
/*  95 */     _h_ += (int)this.cakemasterid;
/*  96 */     _h_ += (int)this.uuid;
/*  97 */     _h_ += this.num;
/*  98 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 102 */     StringBuilder _sb_ = new StringBuilder();
/* 103 */     _sb_.append("(");
/* 104 */     _sb_.append(this.activityid).append(",");
/* 105 */     _sb_.append(this.clientturn).append(",");
/* 106 */     _sb_.append(this.cakemasterid).append(",");
/* 107 */     _sb_.append(this.uuid).append(",");
/* 108 */     _sb_.append(this.num).append(",");
/* 109 */     _sb_.append(")");
/* 110 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CMakeCakeReq _o_) {
/* 114 */     if (_o_ == this) return 0;
/* 115 */     int _c_ = 0;
/* 116 */     _c_ = this.activityid - _o_.activityid;
/* 117 */     if (0 != _c_) return _c_;
/* 118 */     _c_ = this.clientturn - _o_.clientturn;
/* 119 */     if (0 != _c_) return _c_;
/* 120 */     _c_ = Long.signum(this.cakemasterid - _o_.cakemasterid);
/* 121 */     if (0 != _c_) return _c_;
/* 122 */     _c_ = Long.signum(this.uuid - _o_.uuid);
/* 123 */     if (0 != _c_) return _c_;
/* 124 */     _c_ = this.num - _o_.num;
/* 125 */     if (0 != _c_) return _c_;
/* 126 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\CMakeCakeReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */