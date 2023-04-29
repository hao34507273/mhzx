/*     */ package mzm.gsp.indiana;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SRoleGetIndianaAwardBrd
/*     */   extends __SRoleGetIndianaAwardBrd__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12628999;
/*     */   public int activity_cfg_id;
/*     */   public int turn;
/*     */   public int sortid;
/*     */   public long roleid;
/*     */   public Octets role_name;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12628999;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SRoleGetIndianaAwardBrd()
/*     */   {
/*  37 */     this.role_name = new Octets();
/*     */   }
/*     */   
/*     */   public SRoleGetIndianaAwardBrd(int _activity_cfg_id_, int _turn_, int _sortid_, long _roleid_, Octets _role_name_) {
/*  41 */     this.activity_cfg_id = _activity_cfg_id_;
/*  42 */     this.turn = _turn_;
/*  43 */     this.sortid = _sortid_;
/*  44 */     this.roleid = _roleid_;
/*  45 */     this.role_name = _role_name_;
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
/*  56 */     _os_.marshal(this.roleid);
/*  57 */     _os_.marshal(this.role_name);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  63 */     this.turn = _os_.unmarshal_int();
/*  64 */     this.sortid = _os_.unmarshal_int();
/*  65 */     this.roleid = _os_.unmarshal_long();
/*  66 */     this.role_name = _os_.unmarshal_Octets();
/*  67 */     if (!_validator_()) {
/*  68 */       throw new VerifyError("validator failed");
/*     */     }
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  74 */     if (_o1_ == this) return true;
/*  75 */     if ((_o1_ instanceof SRoleGetIndianaAwardBrd)) {
/*  76 */       SRoleGetIndianaAwardBrd _o_ = (SRoleGetIndianaAwardBrd)_o1_;
/*  77 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  78 */       if (this.turn != _o_.turn) return false;
/*  79 */       if (this.sortid != _o_.sortid) return false;
/*  80 */       if (this.roleid != _o_.roleid) return false;
/*  81 */       if (!this.role_name.equals(_o_.role_name)) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.activity_cfg_id;
/*  90 */     _h_ += this.turn;
/*  91 */     _h_ += this.sortid;
/*  92 */     _h_ += (int)this.roleid;
/*  93 */     _h_ += this.role_name.hashCode();
/*  94 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  98 */     StringBuilder _sb_ = new StringBuilder();
/*  99 */     _sb_.append("(");
/* 100 */     _sb_.append(this.activity_cfg_id).append(",");
/* 101 */     _sb_.append(this.turn).append(",");
/* 102 */     _sb_.append(this.sortid).append(",");
/* 103 */     _sb_.append(this.roleid).append(",");
/* 104 */     _sb_.append("B").append(this.role_name.size()).append(",");
/* 105 */     _sb_.append(")");
/* 106 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\SRoleGetIndianaAwardBrd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */