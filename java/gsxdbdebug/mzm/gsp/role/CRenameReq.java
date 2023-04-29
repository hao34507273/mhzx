/*     */ package mzm.gsp.role;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.Role;
/*     */ 
/*     */ public class CRenameReq extends __CRenameReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12585986;
/*     */   public static final int yuanBao = 1;
/*     */   public static final int item = 2;
/*     */   public String newname;
/*     */   public int isuseyuanbao;
/*     */   public HashMap<Integer, Long> rolestate;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new mzm.gsp.role.main.PRenameReq(roleId, this.newname, ((Long)this.rolestate.get(Integer.valueOf(1))).longValue(), ((Long)this.rolestate.get(Integer.valueOf(2))).longValue(), this.isuseyuanbao == 1));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12585986;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CRenameReq()
/*     */   {
/*  42 */     this.newname = "";
/*  43 */     this.rolestate = new HashMap();
/*     */   }
/*     */   
/*     */   public CRenameReq(String _newname_, int _isuseyuanbao_, HashMap<Integer, Long> _rolestate_) {
/*  47 */     this.newname = _newname_;
/*  48 */     this.isuseyuanbao = _isuseyuanbao_;
/*  49 */     this.rolestate = _rolestate_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.marshal(this.newname, "UTF-16LE");
/*  58 */     _os_.marshal(this.isuseyuanbao);
/*  59 */     _os_.compact_uint32(this.rolestate.size());
/*  60 */     for (Map.Entry<Integer, Long> _e_ : this.rolestate.entrySet()) {
/*  61 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  62 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*     */     }
/*  64 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  68 */     this.newname = _os_.unmarshal_String("UTF-16LE");
/*  69 */     this.isuseyuanbao = _os_.unmarshal_int();
/*  70 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  72 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  74 */       long _v_ = _os_.unmarshal_long();
/*  75 */       this.rolestate.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*     */     }
/*  77 */     if (!_validator_()) {
/*  78 */       throw new VerifyError("validator failed");
/*     */     }
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  84 */     if (_o1_ == this) return true;
/*  85 */     if ((_o1_ instanceof CRenameReq)) {
/*  86 */       CRenameReq _o_ = (CRenameReq)_o1_;
/*  87 */       if (!this.newname.equals(_o_.newname)) return false;
/*  88 */       if (this.isuseyuanbao != _o_.isuseyuanbao) return false;
/*  89 */       if (!this.rolestate.equals(_o_.rolestate)) return false;
/*  90 */       return true;
/*     */     }
/*  92 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  96 */     int _h_ = 0;
/*  97 */     _h_ += this.newname.hashCode();
/*  98 */     _h_ += this.isuseyuanbao;
/*  99 */     _h_ += this.rolestate.hashCode();
/* 100 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 104 */     StringBuilder _sb_ = new StringBuilder();
/* 105 */     _sb_.append("(");
/* 106 */     _sb_.append("T").append(this.newname.length()).append(",");
/* 107 */     _sb_.append(this.isuseyuanbao).append(",");
/* 108 */     _sb_.append(this.rolestate).append(",");
/* 109 */     _sb_.append(")");
/* 110 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\role\CRenameReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */