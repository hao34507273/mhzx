/*     */ package mzm.gsp.indiana;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.indiana.main.IndianaOneByOneManager;
/*     */ import mzm.gsp.indiana.main.PCGetIndianaAwardInfo;
/*     */ import mzm.gsp.util.TaskOneByOne;
/*     */ 
/*     */ public class CGetIndianaAwardInfoReq extends __CGetIndianaAwardInfoReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12628993;
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
/*  24 */     IndianaOneByOneManager.getInstance().getTaskOneByOne(Integer.valueOf(this.activity_cfg_id)).add(new PCGetIndianaAwardInfo(roleid, this.activity_cfg_id, this.turn, this.sortid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12628993;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetIndianaAwardInfoReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CGetIndianaAwardInfoReq(int _activity_cfg_id_, int _turn_, int _sortid_)
/*     */   {
/*  44 */     this.activity_cfg_id = _activity_cfg_id_;
/*  45 */     this.turn = _turn_;
/*  46 */     this.sortid = _sortid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.activity_cfg_id);
/*  55 */     _os_.marshal(this.turn);
/*  56 */     _os_.marshal(this.sortid);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  62 */     this.turn = _os_.unmarshal_int();
/*  63 */     this.sortid = _os_.unmarshal_int();
/*  64 */     if (!_validator_()) {
/*  65 */       throw new VerifyError("validator failed");
/*     */     }
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  71 */     if (_o1_ == this) return true;
/*  72 */     if ((_o1_ instanceof CGetIndianaAwardInfoReq)) {
/*  73 */       CGetIndianaAwardInfoReq _o_ = (CGetIndianaAwardInfoReq)_o1_;
/*  74 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  75 */       if (this.turn != _o_.turn) return false;
/*  76 */       if (this.sortid != _o_.sortid) return false;
/*  77 */       return true;
/*     */     }
/*  79 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  83 */     int _h_ = 0;
/*  84 */     _h_ += this.activity_cfg_id;
/*  85 */     _h_ += this.turn;
/*  86 */     _h_ += this.sortid;
/*  87 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  91 */     StringBuilder _sb_ = new StringBuilder();
/*  92 */     _sb_.append("(");
/*  93 */     _sb_.append(this.activity_cfg_id).append(",");
/*  94 */     _sb_.append(this.turn).append(",");
/*  95 */     _sb_.append(this.sortid).append(",");
/*  96 */     _sb_.append(")");
/*  97 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CGetIndianaAwardInfoReq _o_) {
/* 101 */     if (_o_ == this) return 0;
/* 102 */     int _c_ = 0;
/* 103 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 104 */     if (0 != _c_) return _c_;
/* 105 */     _c_ = this.turn - _o_.turn;
/* 106 */     if (0 != _c_) return _c_;
/* 107 */     _c_ = this.sortid - _o_.sortid;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\indiana\CGetIndianaAwardInfoReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */