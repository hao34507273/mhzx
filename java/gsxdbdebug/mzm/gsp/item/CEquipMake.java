/*     */ package mzm.gsp.item;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ 
/*     */ public class CEquipMake extends __CEquipMake__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584759;
/*     */   public int eqpid;
/*     */   public int eqpmakecfgid;
/*     */   public int isuseyuanbao;
/*     */   public long clientsilvernum;
/*     */   public HashMap<Integer, Integer> itemid2nummap;
/*     */   public int clientneedyuanbao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  18 */     long roleid = mzm.gsp.Role.getRoleId(this);
/*  19 */     mzm.gsp.Role.addRoleProcedure(roleid, new mzm.gsp.item.main.PEquipMake(roleid, this.eqpid, this.eqpmakecfgid, this.isuseyuanbao, this.clientsilvernum, this.itemid2nummap, this.clientneedyuanbao));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  27 */     return 12584759;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CEquipMake()
/*     */   {
/*  38 */     this.itemid2nummap = new HashMap();
/*     */   }
/*     */   
/*     */   public CEquipMake(int _eqpid_, int _eqpmakecfgid_, int _isuseyuanbao_, long _clientsilvernum_, HashMap<Integer, Integer> _itemid2nummap_, int _clientneedyuanbao_) {
/*  42 */     this.eqpid = _eqpid_;
/*  43 */     this.eqpmakecfgid = _eqpmakecfgid_;
/*  44 */     this.isuseyuanbao = _isuseyuanbao_;
/*  45 */     this.clientsilvernum = _clientsilvernum_;
/*  46 */     this.itemid2nummap = _itemid2nummap_;
/*  47 */     this.clientneedyuanbao = _clientneedyuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  51 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  55 */     _os_.marshal(this.eqpid);
/*  56 */     _os_.marshal(this.eqpmakecfgid);
/*  57 */     _os_.marshal(this.isuseyuanbao);
/*  58 */     _os_.marshal(this.clientsilvernum);
/*  59 */     _os_.compact_uint32(this.itemid2nummap.size());
/*  60 */     for (java.util.Map.Entry<Integer, Integer> _e_ : this.itemid2nummap.entrySet()) {
/*  61 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  62 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  64 */     _os_.marshal(this.clientneedyuanbao);
/*  65 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  69 */     this.eqpid = _os_.unmarshal_int();
/*  70 */     this.eqpmakecfgid = _os_.unmarshal_int();
/*  71 */     this.isuseyuanbao = _os_.unmarshal_int();
/*  72 */     this.clientsilvernum = _os_.unmarshal_long();
/*  73 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  75 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  77 */       int _v_ = _os_.unmarshal_int();
/*  78 */       this.itemid2nummap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  80 */     this.clientneedyuanbao = _os_.unmarshal_int();
/*  81 */     if (!_validator_()) {
/*  82 */       throw new VerifyError("validator failed");
/*     */     }
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  88 */     if (_o1_ == this) return true;
/*  89 */     if ((_o1_ instanceof CEquipMake)) {
/*  90 */       CEquipMake _o_ = (CEquipMake)_o1_;
/*  91 */       if (this.eqpid != _o_.eqpid) return false;
/*  92 */       if (this.eqpmakecfgid != _o_.eqpmakecfgid) return false;
/*  93 */       if (this.isuseyuanbao != _o_.isuseyuanbao) return false;
/*  94 */       if (this.clientsilvernum != _o_.clientsilvernum) return false;
/*  95 */       if (!this.itemid2nummap.equals(_o_.itemid2nummap)) return false;
/*  96 */       if (this.clientneedyuanbao != _o_.clientneedyuanbao) return false;
/*  97 */       return true;
/*     */     }
/*  99 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 103 */     int _h_ = 0;
/* 104 */     _h_ += this.eqpid;
/* 105 */     _h_ += this.eqpmakecfgid;
/* 106 */     _h_ += this.isuseyuanbao;
/* 107 */     _h_ += (int)this.clientsilvernum;
/* 108 */     _h_ += this.itemid2nummap.hashCode();
/* 109 */     _h_ += this.clientneedyuanbao;
/* 110 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 114 */     StringBuilder _sb_ = new StringBuilder();
/* 115 */     _sb_.append("(");
/* 116 */     _sb_.append(this.eqpid).append(",");
/* 117 */     _sb_.append(this.eqpmakecfgid).append(",");
/* 118 */     _sb_.append(this.isuseyuanbao).append(",");
/* 119 */     _sb_.append(this.clientsilvernum).append(",");
/* 120 */     _sb_.append(this.itemid2nummap).append(",");
/* 121 */     _sb_.append(this.clientneedyuanbao).append(",");
/* 122 */     _sb_.append(")");
/* 123 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CEquipMake.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */