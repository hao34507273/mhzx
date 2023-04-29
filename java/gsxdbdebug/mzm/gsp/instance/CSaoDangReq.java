/*     */ package mzm.gsp.instance;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.instance.main.PCSaoDang;
/*     */ 
/*     */ 
/*     */ public class CSaoDangReq
/*     */   extends __CSaoDangReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12591381;
/*     */   public int instancecfgid;
/*     */   public int process;
/*     */   public int cost_item_num;
/*     */   public int cost_yuanbao_num;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     Role.addRoleProcedure(roleid, new PCSaoDang(roleid, this.instancecfgid, this.process, this.cost_item_num, this.cost_yuanbao_num));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  30 */     return 12591381;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CSaoDangReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CSaoDangReq(int _instancecfgid_, int _process_, int _cost_item_num_, int _cost_yuanbao_num_)
/*     */   {
/*  42 */     this.instancecfgid = _instancecfgid_;
/*  43 */     this.process = _process_;
/*  44 */     this.cost_item_num = _cost_item_num_;
/*  45 */     this.cost_yuanbao_num = _cost_yuanbao_num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.instancecfgid);
/*  54 */     _os_.marshal(this.process);
/*  55 */     _os_.marshal(this.cost_item_num);
/*  56 */     _os_.marshal(this.cost_yuanbao_num);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.instancecfgid = _os_.unmarshal_int();
/*  62 */     this.process = _os_.unmarshal_int();
/*  63 */     this.cost_item_num = _os_.unmarshal_int();
/*  64 */     this.cost_yuanbao_num = _os_.unmarshal_int();
/*  65 */     if (!_validator_()) {
/*  66 */       throw new VerifyError("validator failed");
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  72 */     if (_o1_ == this) return true;
/*  73 */     if ((_o1_ instanceof CSaoDangReq)) {
/*  74 */       CSaoDangReq _o_ = (CSaoDangReq)_o1_;
/*  75 */       if (this.instancecfgid != _o_.instancecfgid) return false;
/*  76 */       if (this.process != _o_.process) return false;
/*  77 */       if (this.cost_item_num != _o_.cost_item_num) return false;
/*  78 */       if (this.cost_yuanbao_num != _o_.cost_yuanbao_num) return false;
/*  79 */       return true;
/*     */     }
/*  81 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  85 */     int _h_ = 0;
/*  86 */     _h_ += this.instancecfgid;
/*  87 */     _h_ += this.process;
/*  88 */     _h_ += this.cost_item_num;
/*  89 */     _h_ += this.cost_yuanbao_num;
/*  90 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  94 */     StringBuilder _sb_ = new StringBuilder();
/*  95 */     _sb_.append("(");
/*  96 */     _sb_.append(this.instancecfgid).append(",");
/*  97 */     _sb_.append(this.process).append(",");
/*  98 */     _sb_.append(this.cost_item_num).append(",");
/*  99 */     _sb_.append(this.cost_yuanbao_num).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CSaoDangReq _o_) {
/* 105 */     if (_o_ == this) return 0;
/* 106 */     int _c_ = 0;
/* 107 */     _c_ = this.instancecfgid - _o_.instancecfgid;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     _c_ = this.process - _o_.process;
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     _c_ = this.cost_item_num - _o_.cost_item_num;
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.cost_yuanbao_num - _o_.cost_yuanbao_num;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\instance\CSaoDangReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */