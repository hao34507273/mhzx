/*     */ package mzm.gsp.roledye;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.roledye.main.PAddClothesColorReq;
/*     */ 
/*     */ public class CAddClothesColorReq extends __CAddClothesColorReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12597251;
/*     */   public int hairid;
/*     */   public int clothid;
/*     */   public int fashiondresscfgid;
/*     */   public HashMap<Integer, Integer> hairitemcfgid2useyuanbao;
/*     */   public HashMap<Integer, Integer> clothitemcfgid2useyuanbao;
/*     */   
/*     */   protected void process()
/*     */   {
/*  20 */     long roleId = Role.getRoleId(this);
/*  21 */     if (roleId < 0L)
/*     */     {
/*  23 */       return;
/*     */     }
/*  25 */     Role.addRoleProcedure(roleId, new PAddClothesColorReq(roleId, this.hairid, this.clothid, this.fashiondresscfgid, this.hairitemcfgid2useyuanbao, this.clothitemcfgid2useyuanbao));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  36 */     return 12597251;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public CAddClothesColorReq()
/*     */   {
/*  46 */     this.hairitemcfgid2useyuanbao = new HashMap();
/*  47 */     this.clothitemcfgid2useyuanbao = new HashMap();
/*     */   }
/*     */   
/*     */   public CAddClothesColorReq(int _hairid_, int _clothid_, int _fashiondresscfgid_, HashMap<Integer, Integer> _hairitemcfgid2useyuanbao_, HashMap<Integer, Integer> _clothitemcfgid2useyuanbao_) {
/*  51 */     this.hairid = _hairid_;
/*  52 */     this.clothid = _clothid_;
/*  53 */     this.fashiondresscfgid = _fashiondresscfgid_;
/*  54 */     this.hairitemcfgid2useyuanbao = _hairitemcfgid2useyuanbao_;
/*  55 */     this.clothitemcfgid2useyuanbao = _clothitemcfgid2useyuanbao_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  59 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  63 */     _os_.marshal(this.hairid);
/*  64 */     _os_.marshal(this.clothid);
/*  65 */     _os_.marshal(this.fashiondresscfgid);
/*  66 */     _os_.compact_uint32(this.hairitemcfgid2useyuanbao.size());
/*  67 */     for (Map.Entry<Integer, Integer> _e_ : this.hairitemcfgid2useyuanbao.entrySet()) {
/*  68 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  69 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  71 */     _os_.compact_uint32(this.clothitemcfgid2useyuanbao.size());
/*  72 */     for (Map.Entry<Integer, Integer> _e_ : this.clothitemcfgid2useyuanbao.entrySet()) {
/*  73 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  74 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  80 */     this.hairid = _os_.unmarshal_int();
/*  81 */     this.clothid = _os_.unmarshal_int();
/*  82 */     this.fashiondresscfgid = _os_.unmarshal_int();
/*  83 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  85 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  87 */       int _v_ = _os_.unmarshal_int();
/*  88 */       this.hairitemcfgid2useyuanbao.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  90 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  92 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  94 */       int _v_ = _os_.unmarshal_int();
/*  95 */       this.clothitemcfgid2useyuanbao.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  97 */     if (!_validator_()) {
/*  98 */       throw new VerifyError("validator failed");
/*     */     }
/* 100 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/* 104 */     if (_o1_ == this) return true;
/* 105 */     if ((_o1_ instanceof CAddClothesColorReq)) {
/* 106 */       CAddClothesColorReq _o_ = (CAddClothesColorReq)_o1_;
/* 107 */       if (this.hairid != _o_.hairid) return false;
/* 108 */       if (this.clothid != _o_.clothid) return false;
/* 109 */       if (this.fashiondresscfgid != _o_.fashiondresscfgid) return false;
/* 110 */       if (!this.hairitemcfgid2useyuanbao.equals(_o_.hairitemcfgid2useyuanbao)) return false;
/* 111 */       if (!this.clothitemcfgid2useyuanbao.equals(_o_.clothitemcfgid2useyuanbao)) return false;
/* 112 */       return true;
/*     */     }
/* 114 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 118 */     int _h_ = 0;
/* 119 */     _h_ += this.hairid;
/* 120 */     _h_ += this.clothid;
/* 121 */     _h_ += this.fashiondresscfgid;
/* 122 */     _h_ += this.hairitemcfgid2useyuanbao.hashCode();
/* 123 */     _h_ += this.clothitemcfgid2useyuanbao.hashCode();
/* 124 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 128 */     StringBuilder _sb_ = new StringBuilder();
/* 129 */     _sb_.append("(");
/* 130 */     _sb_.append(this.hairid).append(",");
/* 131 */     _sb_.append(this.clothid).append(",");
/* 132 */     _sb_.append(this.fashiondresscfgid).append(",");
/* 133 */     _sb_.append(this.hairitemcfgid2useyuanbao).append(",");
/* 134 */     _sb_.append(this.clothitemcfgid2useyuanbao).append(",");
/* 135 */     _sb_.append(")");
/* 136 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\roledye\CAddClothesColorReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */