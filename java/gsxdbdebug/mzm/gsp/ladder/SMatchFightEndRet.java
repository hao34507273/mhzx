/*     */ package mzm.gsp.ladder;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SMatchFightEndRet
/*     */   extends __SMatchFightEndRet__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12607258;
/*     */   public static final int TEAM_A_WIN = 0;
/*     */   public static final int TEAM_A_LOSE = 1;
/*     */   public ArrayList<RoleEndRetInfo> teamaendretinfo;
/*     */   public ArrayList<RoleEndRetInfo> teambendretinfo;
/*     */   public int ret;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12607258;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SMatchFightEndRet()
/*     */   {
/*  38 */     this.teamaendretinfo = new ArrayList();
/*  39 */     this.teambendretinfo = new ArrayList();
/*     */   }
/*     */   
/*     */   public SMatchFightEndRet(ArrayList<RoleEndRetInfo> _teamaendretinfo_, ArrayList<RoleEndRetInfo> _teambendretinfo_, int _ret_) {
/*  43 */     this.teamaendretinfo = _teamaendretinfo_;
/*  44 */     this.teambendretinfo = _teambendretinfo_;
/*  45 */     this.ret = _ret_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     for (RoleEndRetInfo _v_ : this.teamaendretinfo)
/*  50 */       if (!_v_._validator_()) return false;
/*  51 */     for (RoleEndRetInfo _v_ : this.teambendretinfo)
/*  52 */       if (!_v_._validator_()) return false;
/*  53 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  57 */     _os_.compact_uint32(this.teamaendretinfo.size());
/*  58 */     for (RoleEndRetInfo _v_ : this.teamaendretinfo) {
/*  59 */       _os_.marshal(_v_);
/*     */     }
/*  61 */     _os_.compact_uint32(this.teambendretinfo.size());
/*  62 */     for (RoleEndRetInfo _v_ : this.teambendretinfo) {
/*  63 */       _os_.marshal(_v_);
/*     */     }
/*  65 */     _os_.marshal(this.ret);
/*  66 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  70 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  71 */       RoleEndRetInfo _v_ = new RoleEndRetInfo();
/*  72 */       _v_.unmarshal(_os_);
/*  73 */       this.teamaendretinfo.add(_v_);
/*     */     }
/*  75 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  76 */       RoleEndRetInfo _v_ = new RoleEndRetInfo();
/*  77 */       _v_.unmarshal(_os_);
/*  78 */       this.teambendretinfo.add(_v_);
/*     */     }
/*  80 */     this.ret = _os_.unmarshal_int();
/*  81 */     if (!_validator_()) {
/*  82 */       throw new VerifyError("validator failed");
/*     */     }
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  88 */     if (_o1_ == this) return true;
/*  89 */     if ((_o1_ instanceof SMatchFightEndRet)) {
/*  90 */       SMatchFightEndRet _o_ = (SMatchFightEndRet)_o1_;
/*  91 */       if (!this.teamaendretinfo.equals(_o_.teamaendretinfo)) return false;
/*  92 */       if (!this.teambendretinfo.equals(_o_.teambendretinfo)) return false;
/*  93 */       if (this.ret != _o_.ret) return false;
/*  94 */       return true;
/*     */     }
/*  96 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 100 */     int _h_ = 0;
/* 101 */     _h_ += this.teamaendretinfo.hashCode();
/* 102 */     _h_ += this.teambendretinfo.hashCode();
/* 103 */     _h_ += this.ret;
/* 104 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 108 */     StringBuilder _sb_ = new StringBuilder();
/* 109 */     _sb_.append("(");
/* 110 */     _sb_.append(this.teamaendretinfo).append(",");
/* 111 */     _sb_.append(this.teambendretinfo).append(",");
/* 112 */     _sb_.append(this.ret).append(",");
/* 113 */     _sb_.append(")");
/* 114 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\SMatchFightEndRet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */