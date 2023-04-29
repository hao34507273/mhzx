/*     */ package mzm.gsp.planttree;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.planttree.main.PCAddPoint;
/*     */ 
/*     */ 
/*     */ public class CAddPointReq
/*     */   extends __CAddPointReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12611592;
/*     */   public int activity_cfg_id;
/*     */   public int add_point_operation_cfg_id;
/*     */   public int money_type;
/*     */   public int money_num;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     if (roleid < 0L)
/*  22 */       return;
/*  23 */     Role.addRoleProcedure(roleid, new PCAddPoint(roleid, this.activity_cfg_id, this.add_point_operation_cfg_id, this.money_type, this.money_num));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12611592;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CAddPointReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CAddPointReq(int _activity_cfg_id_, int _add_point_operation_cfg_id_, int _money_type_, int _money_num_)
/*     */   {
/*  45 */     this.activity_cfg_id = _activity_cfg_id_;
/*  46 */     this.add_point_operation_cfg_id = _add_point_operation_cfg_id_;
/*  47 */     this.money_type = _money_type_;
/*  48 */     this.money_num = _money_num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.activity_cfg_id);
/*  57 */     _os_.marshal(this.add_point_operation_cfg_id);
/*  58 */     _os_.marshal(this.money_type);
/*  59 */     _os_.marshal(this.money_num);
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     this.activity_cfg_id = _os_.unmarshal_int();
/*  65 */     this.add_point_operation_cfg_id = _os_.unmarshal_int();
/*  66 */     this.money_type = _os_.unmarshal_int();
/*  67 */     this.money_num = _os_.unmarshal_int();
/*  68 */     if (!_validator_()) {
/*  69 */       throw new VerifyError("validator failed");
/*     */     }
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  75 */     if (_o1_ == this) return true;
/*  76 */     if ((_o1_ instanceof CAddPointReq)) {
/*  77 */       CAddPointReq _o_ = (CAddPointReq)_o1_;
/*  78 */       if (this.activity_cfg_id != _o_.activity_cfg_id) return false;
/*  79 */       if (this.add_point_operation_cfg_id != _o_.add_point_operation_cfg_id) return false;
/*  80 */       if (this.money_type != _o_.money_type) return false;
/*  81 */       if (this.money_num != _o_.money_num) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += this.activity_cfg_id;
/*  90 */     _h_ += this.add_point_operation_cfg_id;
/*  91 */     _h_ += this.money_type;
/*  92 */     _h_ += this.money_num;
/*  93 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuilder _sb_ = new StringBuilder();
/*  98 */     _sb_.append("(");
/*  99 */     _sb_.append(this.activity_cfg_id).append(",");
/* 100 */     _sb_.append(this.add_point_operation_cfg_id).append(",");
/* 101 */     _sb_.append(this.money_type).append(",");
/* 102 */     _sb_.append(this.money_num).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CAddPointReq _o_) {
/* 108 */     if (_o_ == this) return 0;
/* 109 */     int _c_ = 0;
/* 110 */     _c_ = this.activity_cfg_id - _o_.activity_cfg_id;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.add_point_operation_cfg_id - _o_.add_point_operation_cfg_id;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = this.money_type - _o_.money_type;
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     _c_ = this.money_num - _o_.money_num;
/* 117 */     if (0 != _c_) return _c_;
/* 118 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\planttree\CAddPointReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */