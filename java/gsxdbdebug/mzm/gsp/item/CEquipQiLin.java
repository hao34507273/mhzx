/*     */ package mzm.gsp.item;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ 
/*     */ public class CEquipQiLin extends __CEquipQiLin__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584709;
/*     */   public int bagid;
/*     */   public int key;
/*     */   public int isuseyuanbao_qilingzhu;
/*     */   public int isusezhenlingstone;
/*     */   public int isuseyuanbao_zhenlingstone;
/*     */   
/*     */   protected void process()
/*     */   {
/*  17 */     long roleid = Role.getRoleId(this);
/*  18 */     Role.addRoleProcedure(roleid, new mzm.gsp.item.main.PEquipQiLin(roleid, this));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  26 */     return 12584709;
/*     */   }
/*     */   
/*     */ 
/*     */   public int isuseluckystone;
/*     */   
/*     */   public int luckystonenum;
/*     */   
/*     */   public int isuseyuanbao_luckystone;
/*     */   
/*     */   public int costtotalyuanbao;
/*     */   
/*     */   public long clientsilvernum;
/*     */   
/*     */   public int clistrengthlevel;
/*     */   public CEquipQiLin() {}
/*     */   
/*     */   public CEquipQiLin(int _bagid_, int _key_, int _isuseyuanbao_qilingzhu_, int _isusezhenlingstone_, int _isuseyuanbao_zhenlingstone_, int _isuseluckystone_, int _luckystonenum_, int _isuseyuanbao_luckystone_, int _costtotalyuanbao_, long _clientsilvernum_, int _clistrengthlevel_)
/*     */   {
/*  45 */     this.bagid = _bagid_;
/*  46 */     this.key = _key_;
/*  47 */     this.isuseyuanbao_qilingzhu = _isuseyuanbao_qilingzhu_;
/*  48 */     this.isusezhenlingstone = _isusezhenlingstone_;
/*  49 */     this.isuseyuanbao_zhenlingstone = _isuseyuanbao_zhenlingstone_;
/*  50 */     this.isuseluckystone = _isuseluckystone_;
/*  51 */     this.luckystonenum = _luckystonenum_;
/*  52 */     this.isuseyuanbao_luckystone = _isuseyuanbao_luckystone_;
/*  53 */     this.costtotalyuanbao = _costtotalyuanbao_;
/*  54 */     this.clientsilvernum = _clientsilvernum_;
/*  55 */     this.clistrengthlevel = _clistrengthlevel_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  59 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  63 */     _os_.marshal(this.bagid);
/*  64 */     _os_.marshal(this.key);
/*  65 */     _os_.marshal(this.isuseyuanbao_qilingzhu);
/*  66 */     _os_.marshal(this.isusezhenlingstone);
/*  67 */     _os_.marshal(this.isuseyuanbao_zhenlingstone);
/*  68 */     _os_.marshal(this.isuseluckystone);
/*  69 */     _os_.marshal(this.luckystonenum);
/*  70 */     _os_.marshal(this.isuseyuanbao_luckystone);
/*  71 */     _os_.marshal(this.costtotalyuanbao);
/*  72 */     _os_.marshal(this.clientsilvernum);
/*  73 */     _os_.marshal(this.clistrengthlevel);
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws com.goldhuman.Common.Marshal.MarshalException {
/*  78 */     this.bagid = _os_.unmarshal_int();
/*  79 */     this.key = _os_.unmarshal_int();
/*  80 */     this.isuseyuanbao_qilingzhu = _os_.unmarshal_int();
/*  81 */     this.isusezhenlingstone = _os_.unmarshal_int();
/*  82 */     this.isuseyuanbao_zhenlingstone = _os_.unmarshal_int();
/*  83 */     this.isuseluckystone = _os_.unmarshal_int();
/*  84 */     this.luckystonenum = _os_.unmarshal_int();
/*  85 */     this.isuseyuanbao_luckystone = _os_.unmarshal_int();
/*  86 */     this.costtotalyuanbao = _os_.unmarshal_int();
/*  87 */     this.clientsilvernum = _os_.unmarshal_long();
/*  88 */     this.clistrengthlevel = _os_.unmarshal_int();
/*  89 */     if (!_validator_()) {
/*  90 */       throw new VerifyError("validator failed");
/*     */     }
/*  92 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  96 */     if (_o1_ == this) return true;
/*  97 */     if ((_o1_ instanceof CEquipQiLin)) {
/*  98 */       CEquipQiLin _o_ = (CEquipQiLin)_o1_;
/*  99 */       if (this.bagid != _o_.bagid) return false;
/* 100 */       if (this.key != _o_.key) return false;
/* 101 */       if (this.isuseyuanbao_qilingzhu != _o_.isuseyuanbao_qilingzhu) return false;
/* 102 */       if (this.isusezhenlingstone != _o_.isusezhenlingstone) return false;
/* 103 */       if (this.isuseyuanbao_zhenlingstone != _o_.isuseyuanbao_zhenlingstone) return false;
/* 104 */       if (this.isuseluckystone != _o_.isuseluckystone) return false;
/* 105 */       if (this.luckystonenum != _o_.luckystonenum) return false;
/* 106 */       if (this.isuseyuanbao_luckystone != _o_.isuseyuanbao_luckystone) return false;
/* 107 */       if (this.costtotalyuanbao != _o_.costtotalyuanbao) return false;
/* 108 */       if (this.clientsilvernum != _o_.clientsilvernum) return false;
/* 109 */       if (this.clistrengthlevel != _o_.clistrengthlevel) return false;
/* 110 */       return true;
/*     */     }
/* 112 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 116 */     int _h_ = 0;
/* 117 */     _h_ += this.bagid;
/* 118 */     _h_ += this.key;
/* 119 */     _h_ += this.isuseyuanbao_qilingzhu;
/* 120 */     _h_ += this.isusezhenlingstone;
/* 121 */     _h_ += this.isuseyuanbao_zhenlingstone;
/* 122 */     _h_ += this.isuseluckystone;
/* 123 */     _h_ += this.luckystonenum;
/* 124 */     _h_ += this.isuseyuanbao_luckystone;
/* 125 */     _h_ += this.costtotalyuanbao;
/* 126 */     _h_ += (int)this.clientsilvernum;
/* 127 */     _h_ += this.clistrengthlevel;
/* 128 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 132 */     StringBuilder _sb_ = new StringBuilder();
/* 133 */     _sb_.append("(");
/* 134 */     _sb_.append(this.bagid).append(",");
/* 135 */     _sb_.append(this.key).append(",");
/* 136 */     _sb_.append(this.isuseyuanbao_qilingzhu).append(",");
/* 137 */     _sb_.append(this.isusezhenlingstone).append(",");
/* 138 */     _sb_.append(this.isuseyuanbao_zhenlingstone).append(",");
/* 139 */     _sb_.append(this.isuseluckystone).append(",");
/* 140 */     _sb_.append(this.luckystonenum).append(",");
/* 141 */     _sb_.append(this.isuseyuanbao_luckystone).append(",");
/* 142 */     _sb_.append(this.costtotalyuanbao).append(",");
/* 143 */     _sb_.append(this.clientsilvernum).append(",");
/* 144 */     _sb_.append(this.clistrengthlevel).append(",");
/* 145 */     _sb_.append(")");
/* 146 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CEquipQiLin _o_) {
/* 150 */     if (_o_ == this) return 0;
/* 151 */     int _c_ = 0;
/* 152 */     _c_ = this.bagid - _o_.bagid;
/* 153 */     if (0 != _c_) return _c_;
/* 154 */     _c_ = this.key - _o_.key;
/* 155 */     if (0 != _c_) return _c_;
/* 156 */     _c_ = this.isuseyuanbao_qilingzhu - _o_.isuseyuanbao_qilingzhu;
/* 157 */     if (0 != _c_) return _c_;
/* 158 */     _c_ = this.isusezhenlingstone - _o_.isusezhenlingstone;
/* 159 */     if (0 != _c_) return _c_;
/* 160 */     _c_ = this.isuseyuanbao_zhenlingstone - _o_.isuseyuanbao_zhenlingstone;
/* 161 */     if (0 != _c_) return _c_;
/* 162 */     _c_ = this.isuseluckystone - _o_.isuseluckystone;
/* 163 */     if (0 != _c_) return _c_;
/* 164 */     _c_ = this.luckystonenum - _o_.luckystonenum;
/* 165 */     if (0 != _c_) return _c_;
/* 166 */     _c_ = this.isuseyuanbao_luckystone - _o_.isuseyuanbao_luckystone;
/* 167 */     if (0 != _c_) return _c_;
/* 168 */     _c_ = this.costtotalyuanbao - _o_.costtotalyuanbao;
/* 169 */     if (0 != _c_) return _c_;
/* 170 */     _c_ = Long.signum(this.clientsilvernum - _o_.clientsilvernum);
/* 171 */     if (0 != _c_) return _c_;
/* 172 */     _c_ = this.clistrengthlevel - _o_.clistrengthlevel;
/* 173 */     if (0 != _c_) return _c_;
/* 174 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\item\CEquipQiLin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */