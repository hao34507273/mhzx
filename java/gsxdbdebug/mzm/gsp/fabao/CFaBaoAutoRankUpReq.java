/*     */ package mzm.gsp.fabao;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.Role;
/*     */ 
/*     */ public class CFaBaoAutoRankUpReq extends __CFaBaoAutoRankUpReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12596041;
/*     */   public int equiped;
/*     */   public long fabaouuid;
/*     */   public int uptorank;
/*     */   public HashMap<Integer, CostInfo> bagid2costinfo;
/*     */   public int useyuanbaonum;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleid = Role.getRoleId(this);
/*  21 */     if (roleid < 1L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleid, new mzm.gsp.fabao.main.PFaBaoAutoRankUpReq(roleid, this.equiped, this.fabaouuid, this.uptorank, this.bagid2costinfo, this.useyuanbaonum));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  33 */     return 12596041;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CFaBaoAutoRankUpReq()
/*     */   {
/*  43 */     this.bagid2costinfo = new HashMap();
/*     */   }
/*     */   
/*     */   public CFaBaoAutoRankUpReq(int _equiped_, long _fabaouuid_, int _uptorank_, HashMap<Integer, CostInfo> _bagid2costinfo_, int _useyuanbaonum_) {
/*  47 */     this.equiped = _equiped_;
/*  48 */     this.fabaouuid = _fabaouuid_;
/*  49 */     this.uptorank = _uptorank_;
/*  50 */     this.bagid2costinfo = _bagid2costinfo_;
/*  51 */     this.useyuanbaonum = _useyuanbaonum_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  55 */     for (Map.Entry<Integer, CostInfo> _e_ : this.bagid2costinfo.entrySet()) {
/*  56 */       if (!((CostInfo)_e_.getValue())._validator_()) return false;
/*     */     }
/*  58 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  62 */     _os_.marshal(this.equiped);
/*  63 */     _os_.marshal(this.fabaouuid);
/*  64 */     _os_.marshal(this.uptorank);
/*  65 */     _os_.compact_uint32(this.bagid2costinfo.size());
/*  66 */     for (Map.Entry<Integer, CostInfo> _e_ : this.bagid2costinfo.entrySet()) {
/*  67 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  68 */       _os_.marshal((Marshal)_e_.getValue());
/*     */     }
/*  70 */     _os_.marshal(this.useyuanbaonum);
/*  71 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  75 */     this.equiped = _os_.unmarshal_int();
/*  76 */     this.fabaouuid = _os_.unmarshal_long();
/*  77 */     this.uptorank = _os_.unmarshal_int();
/*  78 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  80 */       int _k_ = _os_.unmarshal_int();
/*  81 */       CostInfo _v_ = new CostInfo();
/*  82 */       _v_.unmarshal(_os_);
/*  83 */       this.bagid2costinfo.put(Integer.valueOf(_k_), _v_);
/*     */     }
/*  85 */     this.useyuanbaonum = _os_.unmarshal_int();
/*  86 */     if (!_validator_()) {
/*  87 */       throw new VerifyError("validator failed");
/*     */     }
/*  89 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  93 */     if (_o1_ == this) return true;
/*  94 */     if ((_o1_ instanceof CFaBaoAutoRankUpReq)) {
/*  95 */       CFaBaoAutoRankUpReq _o_ = (CFaBaoAutoRankUpReq)_o1_;
/*  96 */       if (this.equiped != _o_.equiped) return false;
/*  97 */       if (this.fabaouuid != _o_.fabaouuid) return false;
/*  98 */       if (this.uptorank != _o_.uptorank) return false;
/*  99 */       if (!this.bagid2costinfo.equals(_o_.bagid2costinfo)) return false;
/* 100 */       if (this.useyuanbaonum != _o_.useyuanbaonum) return false;
/* 101 */       return true;
/*     */     }
/* 103 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 107 */     int _h_ = 0;
/* 108 */     _h_ += this.equiped;
/* 109 */     _h_ += (int)this.fabaouuid;
/* 110 */     _h_ += this.uptorank;
/* 111 */     _h_ += this.bagid2costinfo.hashCode();
/* 112 */     _h_ += this.useyuanbaonum;
/* 113 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 117 */     StringBuilder _sb_ = new StringBuilder();
/* 118 */     _sb_.append("(");
/* 119 */     _sb_.append(this.equiped).append(",");
/* 120 */     _sb_.append(this.fabaouuid).append(",");
/* 121 */     _sb_.append(this.uptorank).append(",");
/* 122 */     _sb_.append(this.bagid2costinfo).append(",");
/* 123 */     _sb_.append(this.useyuanbaonum).append(",");
/* 124 */     _sb_.append(")");
/* 125 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fabao\CFaBaoAutoRankUpReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */