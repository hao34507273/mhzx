/*     */ package mzm.gsp.teamplatform;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.ArrayList;
/*     */ import mzm.gsp.Role;
/*     */ import mzm.gsp.teamplatform.match.MatchNRTimeTaskManager;
/*     */ import mzm.gsp.teamplatform.match.PStartMatch;
/*     */ 
/*     */ public class CStartMatch
/*     */   extends __CStartMatch__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12593677;
/*     */   public ArrayList<MatchCfg> matchcfgids;
/*     */   public LevelCfg levelrange;
/*     */   
/*     */   protected void process()
/*     */   {
/*  19 */     long roleid = Role.getRoleId(this);
/*  20 */     if (roleid < 0L) {
/*  21 */       return;
/*     */     }
/*  23 */     MatchNRTimeTaskManager.getInstance().addTask(new PStartMatch(roleid, this.matchcfgids, this.levelrange));
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public int getType()
/*     */   {
/*  32 */     return 12593677;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public CStartMatch()
/*     */   {
/*  39 */     this.matchcfgids = new ArrayList();
/*  40 */     this.levelrange = new LevelCfg();
/*     */   }
/*     */   
/*     */   public CStartMatch(ArrayList<MatchCfg> _matchcfgids_, LevelCfg _levelrange_) {
/*  44 */     this.matchcfgids = _matchcfgids_;
/*  45 */     this.levelrange = _levelrange_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  49 */     for (MatchCfg _v_ : this.matchcfgids)
/*  50 */       if (!_v_._validator_()) return false;
/*  51 */     if (!this.levelrange._validator_()) return false;
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  56 */     _os_.compact_uint32(this.matchcfgids.size());
/*  57 */     for (MatchCfg _v_ : this.matchcfgids) {
/*  58 */       _os_.marshal(_v_);
/*     */     }
/*  60 */     _os_.marshal(this.levelrange);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  65 */     for (int _size_ = _os_.uncompact_uint32(); _size_ > 0; _size_--) {
/*  66 */       MatchCfg _v_ = new MatchCfg();
/*  67 */       _v_.unmarshal(_os_);
/*  68 */       this.matchcfgids.add(_v_);
/*     */     }
/*  70 */     this.levelrange.unmarshal(_os_);
/*  71 */     if (!_validator_()) {
/*  72 */       throw new VerifyError("validator failed");
/*     */     }
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  78 */     if (_o1_ == this) return true;
/*  79 */     if ((_o1_ instanceof CStartMatch)) {
/*  80 */       CStartMatch _o_ = (CStartMatch)_o1_;
/*  81 */       if (!this.matchcfgids.equals(_o_.matchcfgids)) return false;
/*  82 */       if (!this.levelrange.equals(_o_.levelrange)) return false;
/*  83 */       return true;
/*     */     }
/*  85 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  89 */     int _h_ = 0;
/*  90 */     _h_ += this.matchcfgids.hashCode();
/*  91 */     _h_ += this.levelrange.hashCode();
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.matchcfgids).append(",");
/*  99 */     _sb_.append(this.levelrange).append(",");
/* 100 */     _sb_.append(")");
/* 101 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\teamplatform\CStartMatch.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */