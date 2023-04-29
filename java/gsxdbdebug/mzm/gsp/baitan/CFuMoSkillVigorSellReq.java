/*     */ package mzm.gsp.baitan;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.baitan.main.PFUMoSkillVigorSellReq;
/*     */ 
/*     */ public class CFuMoSkillVigorSellReq
/*     */   extends __CFuMoSkillVigorSellReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12584965;
/*     */   public int skillid;
/*     */   public int skillbagid;
/*     */   public int price;
/*     */   public int num;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleId = Role.getRoleId(this);
/*  20 */     if (roleId < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     Role.addRoleProcedure(roleId, new PFUMoSkillVigorSellReq(roleId, this.skillbagid, this.skillid, this.price, this.num));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  31 */     return 12584965;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CFuMoSkillVigorSellReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CFuMoSkillVigorSellReq(int _skillid_, int _skillbagid_, int _price_, int _num_)
/*     */   {
/*  43 */     this.skillid = _skillid_;
/*  44 */     this.skillbagid = _skillbagid_;
/*  45 */     this.price = _price_;
/*  46 */     this.num = _num_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  50 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  54 */     _os_.marshal(this.skillid);
/*  55 */     _os_.marshal(this.skillbagid);
/*  56 */     _os_.marshal(this.price);
/*  57 */     _os_.marshal(this.num);
/*  58 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  62 */     this.skillid = _os_.unmarshal_int();
/*  63 */     this.skillbagid = _os_.unmarshal_int();
/*  64 */     this.price = _os_.unmarshal_int();
/*  65 */     this.num = _os_.unmarshal_int();
/*  66 */     if (!_validator_()) {
/*  67 */       throw new VerifyError("validator failed");
/*     */     }
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  73 */     if (_o1_ == this) return true;
/*  74 */     if ((_o1_ instanceof CFuMoSkillVigorSellReq)) {
/*  75 */       CFuMoSkillVigorSellReq _o_ = (CFuMoSkillVigorSellReq)_o1_;
/*  76 */       if (this.skillid != _o_.skillid) return false;
/*  77 */       if (this.skillbagid != _o_.skillbagid) return false;
/*  78 */       if (this.price != _o_.price) return false;
/*  79 */       if (this.num != _o_.num) return false;
/*  80 */       return true;
/*     */     }
/*  82 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  86 */     int _h_ = 0;
/*  87 */     _h_ += this.skillid;
/*  88 */     _h_ += this.skillbagid;
/*  89 */     _h_ += this.price;
/*  90 */     _h_ += this.num;
/*  91 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  95 */     StringBuilder _sb_ = new StringBuilder();
/*  96 */     _sb_.append("(");
/*  97 */     _sb_.append(this.skillid).append(",");
/*  98 */     _sb_.append(this.skillbagid).append(",");
/*  99 */     _sb_.append(this.price).append(",");
/* 100 */     _sb_.append(this.num).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CFuMoSkillVigorSellReq _o_) {
/* 106 */     if (_o_ == this) return 0;
/* 107 */     int _c_ = 0;
/* 108 */     _c_ = this.skillid - _o_.skillid;
/* 109 */     if (0 != _c_) return _c_;
/* 110 */     _c_ = this.skillbagid - _o_.skillbagid;
/* 111 */     if (0 != _c_) return _c_;
/* 112 */     _c_ = this.price - _o_.price;
/* 113 */     if (0 != _c_) return _c_;
/* 114 */     _c_ = this.num - _o_.num;
/* 115 */     if (0 != _c_) return _c_;
/* 116 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\baitan\CFuMoSkillVigorSellReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */