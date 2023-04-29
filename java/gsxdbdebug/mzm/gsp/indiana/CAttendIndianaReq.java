/*     */ package mzm.gsp.indiana;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.indiana.main.PCAttendIndiana;
/*     */ 
/*     */ 
/*     */ public class CAttendIndianaReq
/*     */   extends __CAttendIndianaReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12628995;
/*     */   public int activity_cfg_id;
/*     */   public int turn;
/*     */   public int sortid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleid = Role.getRoleId(this);
/*  20 */     if (roleid < 0L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleid, new PCAttendIndiana(roleid, this.activity_cfg_id, this.turn, this.sortid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12628995;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CAttendIndianaReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CAttendIndianaReq(int _activity_cfg_id_, int _turn_, int _sortid_)
/*     */   {
/*  43 */     this.activity_cfg_id = _activity_cfg_id_;
/*  44 */     this.turn = _turn_;
/*  45 */     this.sortid = _sortid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.activity_cfg_id);
/*  54 */     _os_.marshal(this.turn);
/*  55 */     _os_.marshal(this.sortid);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  61 */     this.turn = _os_.unmarshal_int();
/*  62 */     this.sortid = _os_.unmarshal_int();
/*  63 */     if (!_validator_()) {
/*  64 */       throw new VerifyError("validator failed");
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof CAttendIndianaReq)) {
/*  72 */       CAttendIndianaReq _o_ = (CAttendIndianaReq)_o1_;
/*  73 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  74 */       if (this.turn != _o_.turn) return false;
/*  75 */       if (this.sortid != _o_.sortid) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.activity_cfg_id;
/*  84 */     _h_ += this.turn;
/*  85 */     _h_ += this.sortid;
/*  86 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  90 */     StringBuilder _sb_ = new StringBuilder();
/*  91 */     _sb_.append("(");
/*  92 */     _sb_.append(this.activity_cfg_id).append(",");
/*  93 */     _sb_.append(this.turn).append(",");
/*  94 */     _sb_.append(this.sortid).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CAttendIndianaReq _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = this.turn - _o_.turn;
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = this.sortid - _o_.sortid;
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\CAttendIndianaReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */