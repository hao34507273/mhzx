/*     */ package mzm.gsp.cake;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.cake.main.PCheckCakeHistory;
/*     */ 
/*     */ 
/*     */ public class CCheckCakeHistoryReq
/*     */   extends __CCheckCakeHistoryReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12627721;
/*     */   public int activityid;
/*     */   public long factionid;
/*     */   public long roleid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 1L)
/*     */     {
/*  22 */       return;
/*     */     }
/*  24 */     Role.addRoleProcedure(roleId, new PCheckCakeHistory(roleId, this.activityid, this.factionid, this.roleid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12627721;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CCheckCakeHistoryReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CCheckCakeHistoryReq(int _activityid_, long _factionid_, long _roleid_)
/*     */   {
/*  43 */     this.activityid = _activityid_;
/*  44 */     this.factionid = _factionid_;
/*  45 */     this.roleid = _roleid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.activityid);
/*  54 */     _os_.marshal(this.factionid);
/*  55 */     _os_.marshal(this.roleid);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.activityid = _os_.unmarshal_int();
/*  61 */     this.factionid = _os_.unmarshal_long();
/*  62 */     this.roleid = _os_.unmarshal_long();
/*  63 */     if (!_validator_()) {
/*  64 */       throw new VerifyError("validator failed");
/*     */     }
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  70 */     if (_o1_ == this) return true;
/*  71 */     if ((_o1_ instanceof CCheckCakeHistoryReq)) {
/*  72 */       CCheckCakeHistoryReq _o_ = (CCheckCakeHistoryReq)_o1_;
/*  73 */       if (this.activityid != _o_.activityid) return false;
/*  74 */       if (this.factionid != _o_.factionid) return false;
/*  75 */       if (this.roleid != _o_.roleid) return false;
/*  76 */       return true;
/*     */     }
/*  78 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  82 */     int _h_ = 0;
/*  83 */     _h_ += this.activityid;
/*  84 */     _h_ += (int)this.factionid;
/*  85 */     _h_ += (int)this.roleid;
/*  86 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  90 */     StringBuilder _sb_ = new StringBuilder();
/*  91 */     _sb_.append("(");
/*  92 */     _sb_.append(this.activityid).append(",");
/*  93 */     _sb_.append(this.factionid).append(",");
/*  94 */     _sb_.append(this.roleid).append(",");
/*  95 */     _sb_.append(")");
/*  96 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CCheckCakeHistoryReq _o_) {
/* 100 */     if (_o_ == this) return 0;
/* 101 */     int _c_ = 0;
/* 102 */     _c_ = this.activityid - _o_.activityid;
/* 103 */     if (0 != _c_) return _c_;
/* 104 */     _c_ = Long.signum(this.factionid - _o_.factionid);
/* 105 */     if (0 != _c_) return _c_;
/* 106 */     _c_ = Long.signum(this.roleid - _o_.roleid);
/* 107 */     if (0 != _c_) return _c_;
/* 108 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\cake\CCheckCakeHistoryReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */