/*     */ package mzm.gsp.multioccupation;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.multioccupation.main.PSwitchOccupationReq;
/*     */ 
/*     */ public class CSwitchOccupationReq
/*     */   extends __CSwitchOccupationReq__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12606977;
/*     */   public int new_occupation;
/*     */   public int old_occupation;
/*     */   public long current_gold;
/*     */   public int npcid;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleid = Role.getRoleId(this);
/*  20 */     Role.addRoleProcedure(roleid, new PSwitchOccupationReq(roleid, this.new_occupation, this.old_occupation, this.current_gold, this.npcid));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  30 */     return 12606977;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public CSwitchOccupationReq() {}
/*     */   
/*     */ 
/*     */ 
/*     */   public CSwitchOccupationReq(int _new_occupation_, int _old_occupation_, long _current_gold_, int _npcid_)
/*     */   {
/*  42 */     this.new_occupation = _new_occupation_;
/*  43 */     this.old_occupation = _old_occupation_;
/*  44 */     this.current_gold = _current_gold_;
/*  45 */     this.npcid = _npcid_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  53 */     _os_.marshal(this.new_occupation);
/*  54 */     _os_.marshal(this.old_occupation);
/*  55 */     _os_.marshal(this.current_gold);
/*  56 */     _os_.marshal(this.npcid);
/*  57 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  61 */     this.new_occupation = _os_.unmarshal_int();
/*  62 */     this.old_occupation = _os_.unmarshal_int();
/*  63 */     this.current_gold = _os_.unmarshal_long();
/*  64 */     this.npcid = _os_.unmarshal_int();
/*  65 */     if (!_validator_()) {
/*  66 */       throw new VerifyError("validator failed");
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  72 */     if (_o1_ == this) return true;
/*  73 */     if ((_o1_ instanceof CSwitchOccupationReq)) {
/*  74 */       CSwitchOccupationReq _o_ = (CSwitchOccupationReq)_o1_;
/*  75 */       if (this.new_occupation != _o_.new_occupation) return false;
/*  76 */       if (this.old_occupation != _o_.old_occupation) return false;
/*  77 */       if (this.current_gold != _o_.current_gold) return false;
/*  78 */       if (this.npcid != _o_.npcid) return false;
/*  79 */       return true;
/*     */     }
/*  81 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  85 */     int _h_ = 0;
/*  86 */     _h_ += this.new_occupation;
/*  87 */     _h_ += this.old_occupation;
/*  88 */     _h_ += (int)this.current_gold;
/*  89 */     _h_ += this.npcid;
/*  90 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  94 */     StringBuilder _sb_ = new StringBuilder();
/*  95 */     _sb_.append("(");
/*  96 */     _sb_.append(this.new_occupation).append(",");
/*  97 */     _sb_.append(this.old_occupation).append(",");
/*  98 */     _sb_.append(this.current_gold).append(",");
/*  99 */     _sb_.append(this.npcid).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */   public int compareTo(CSwitchOccupationReq _o_) {
/* 105 */     if (_o_ == this) return 0;
/* 106 */     int _c_ = 0;
/* 107 */     _c_ = this.new_occupation - _o_.new_occupation;
/* 108 */     if (0 != _c_) return _c_;
/* 109 */     _c_ = this.old_occupation - _o_.old_occupation;
/* 110 */     if (0 != _c_) return _c_;
/* 111 */     _c_ = Long.signum(this.current_gold - _o_.current_gold);
/* 112 */     if (0 != _c_) return _c_;
/* 113 */     _c_ = this.npcid - _o_.npcid;
/* 114 */     if (0 != _c_) return _c_;
/* 115 */     return _c_;
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\multioccupation\CSwitchOccupationReq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */