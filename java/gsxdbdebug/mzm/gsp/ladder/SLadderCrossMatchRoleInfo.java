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
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SLadderCrossMatchRoleInfo
/*     */   extends __SLadderCrossMatchRoleInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12607256;
/*     */   public ArrayList<RoleLadderCrossMatchInfo> matchteamainfos;
/*     */   public ArrayList<RoleLadderCrossMatchInfo> matchteambinfos;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12607256;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public SLadderCrossMatchRoleInfo()
/*     */   {
/*  34 */     this.matchteamainfos = new ArrayList();
/*  35 */     this.matchteambinfos = new ArrayList();
/*     */   }
/*     */   
/*     */   public SLadderCrossMatchRoleInfo(ArrayList<RoleLadderCrossMatchInfo> _matchteamainfos_, ArrayList<RoleLadderCrossMatchInfo> _matchteambinfos_) {
/*  39 */     this.matchteamainfos = _matchteamainfos_;
/*  40 */     this.matchteambinfos = _matchteambinfos_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  44 */     for (RoleLadderCrossMatchInfo _v_ : this.matchteamainfos)
/*  45 */       if (!_v_._validator_()) return false;
/*  46 */     for (RoleLadderCrossMatchInfo _v_ : this.matchteambinfos)
/*  47 */       if (!_v_._validator_()) return false;
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  52 */     _os_.compact_uint32(this.matchteamainfos.size());
/*  53 */     for (RoleLadderCrossMatchInfo _v_ : this.matchteamainfos) {
/*  54 */       _os_.marshal(_v_);
/*     */     }
/*  56 */     _os_.compact_uint32(this.matchteambinfos.size());
/*  57 */     for (RoleLadderCrossMatchInfo _v_ : this.matchteambinfos) {
/*  58 */       _os_.marshal(_v_);
/*     */     }
/*  60 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  64 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  65 */       RoleLadderCrossMatchInfo _v_ = new RoleLadderCrossMatchInfo();
/*  66 */       _v_.unmarshal(_os_);
/*  67 */       this.matchteamainfos.add(_v_);
/*     */     }
/*  69 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  70 */       RoleLadderCrossMatchInfo _v_ = new RoleLadderCrossMatchInfo();
/*  71 */       _v_.unmarshal(_os_);
/*  72 */       this.matchteambinfos.add(_v_);
/*     */     }
/*  74 */     if (!_validator_()) {
/*  75 */       throw new VerifyError("validator failed");
/*     */     }
/*  77 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  81 */     if (_o1_ == this) return true;
/*  82 */     if ((_o1_ instanceof SLadderCrossMatchRoleInfo)) {
/*  83 */       SLadderCrossMatchRoleInfo _o_ = (SLadderCrossMatchRoleInfo)_o1_;
/*  84 */       if (!this.matchteamainfos.equals(_o_.matchteamainfos)) return false;
/*  85 */       if (!this.matchteambinfos.equals(_o_.matchteambinfos)) return false;
/*  86 */       return true;
/*     */     }
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  92 */     int _h_ = 0;
/*  93 */     _h_ += this.matchteamainfos.hashCode();
/*  94 */     _h_ += this.matchteambinfos.hashCode();
/*  95 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuilder _sb_ = new StringBuilder();
/* 100 */     _sb_.append("(");
/* 101 */     _sb_.append(this.matchteamainfos).append(",");
/* 102 */     _sb_.append(this.matchteambinfos).append(",");
/* 103 */     _sb_.append(")");
/* 104 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\ladder\SLadderCrossMatchRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */