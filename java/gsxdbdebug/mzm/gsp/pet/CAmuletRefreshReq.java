/*     */ package mzm.gsp.pet;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.pet.main.PPetAmuletRefreshReq;
/*     */ 
/*     */ public class CAmuletRefreshReq extends __CAmuletRefreshReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12590614;
/*     */   public int itemkey;
/*     */   public int costtype;
/*     */   public int costyuanbao;
/*     */   public long yuanbaonum;
/*     */   public long petid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new PPetAmuletRefreshReq(roleId, this.itemkey, this.costtype, this.costyuanbao, this.yuanbaonum, this.petid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12590614;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CAmuletRefreshReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CAmuletRefreshReq(int _itemkey_, int _costtype_, int _costyuanbao_, long _yuanbaonum_, long _petid_)
/*     */   {
/*  44 */     this.itemkey = _itemkey_;
/*  45 */     this.costtype = _costtype_;
/*  46 */     this.costyuanbao = _costyuanbao_;
/*  47 */     this.yuanbaonum = _yuanbaonum_;
/*  48 */     this.petid = _petid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.marshal(this.itemkey);
/*  57 */     _os_.marshal(this.costtype);
/*  58 */     _os_.marshal(this.costyuanbao);
/*  59 */     _os_.marshal(this.yuanbaonum);
/*  60 */     _os_.marshal(this.petid);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  65 */     this.itemkey = _os_.unmarshal_int();
/*  66 */     this.costtype = _os_.unmarshal_int();
/*  67 */     this.costyuanbao = _os_.unmarshal_int();
/*  68 */     this.yuanbaonum = _os_.unmarshal_long();
/*  69 */     this.petid = _os_.unmarshal_long();
/*  70 */     if (!_validator_()) {
/*  71 */       throw new VerifyError("validator failed");
/*     */     }
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  77 */     if (_o1_ == this) return true;
/*  78 */     if ((_o1_ instanceof CAmuletRefreshReq)) {
/*  79 */       CAmuletRefreshReq _o_ = (CAmuletRefreshReq)_o1_;
/*  80 */       if (this.itemkey != _o_.itemkey) return false;
/*  81 */       if (this.costtype != _o_.costtype) return false;
/*  82 */       if (this.costyuanbao != _o_.costyuanbao) return false;
/*  83 */       if (this.yuanbaonum != _o_.yuanbaonum) return false;
/*  84 */       if (this.petid != _o_.petid) return false;
/*  85 */       return true;
/*     */     }
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  91 */     int _h_ = 0;
/*  92 */     _h_ += this.itemkey;
/*  93 */     _h_ += this.costtype;
/*  94 */     _h_ += this.costyuanbao;
/*  95 */     _h_ += (int)this.yuanbaonum;
/*  96 */     _h_ += (int)this.petid;
/*  97 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 101 */     StringBuilder _sb_ = new StringBuilder();
/* 102 */     _sb_.append("(");
/* 103 */     _sb_.append(this.itemkey).append(",");
/* 104 */     _sb_.append(this.costtype).append(",");
/* 105 */     _sb_.append(this.costyuanbao).append(",");
/* 106 */     _sb_.append(this.yuanbaonum).append(",");
/* 107 */     _sb_.append(this.petid).append(",");
/* 108 */     _sb_.append(")");
/* 109 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CAmuletRefreshReq _o_) {
/* 113 */     if (_o_ == this) return 0;
/* 114 */     int _c_ = 0;
/* 115 */     _c_ = this.itemkey - _o_.itemkey;
/* 116 */     if (0 != _c_) return _c_;
/* 117 */     _c_ = this.costtype - _o_.costtype;
/* 118 */     if (0 != _c_) return _c_;
/* 119 */     _c_ = this.costyuanbao - _o_.costyuanbao;
/* 120 */     if (0 != _c_) return _c_;
/* 121 */     _c_ = Long.signum(this.yuanbaonum - _o_.yuanbaonum);
/* 122 */     if (0 != _c_) return _c_;
/* 123 */     _c_ = Long.signum(this.petid - _o_.petid);
/* 124 */     if (0 != _c_) return _c_;
/* 125 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\pet\CAmuletRefreshReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */