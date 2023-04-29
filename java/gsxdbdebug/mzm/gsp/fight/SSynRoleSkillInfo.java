/*     */ package mzm.gsp.fight;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.MarshalException;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map.Entry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SSynRoleSkillInfo
/*     */   extends __SSynRoleSkillInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12594209;
/*     */   public long fight_uuid;
/*     */   public HashMap<Integer, Integer> skillmap;
/*     */   public int seq;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12594209;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynRoleSkillInfo()
/*     */   {
/*  35 */     this.skillmap = new HashMap();
/*     */   }
/*     */   
/*     */   public SSynRoleSkillInfo(long _fight_uuid_, HashMap<Integer, Integer> _skillmap_, int _seq_) {
/*  39 */     this.fight_uuid = _fight_uuid_;
/*  40 */     this.skillmap = _skillmap_;
/*  41 */     this.seq = _seq_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  49 */     _os_.marshal(this.fight_uuid);
/*  50 */     _os_.compact_uint32(this.skillmap.size());
/*  51 */     for (Map.Entry<Integer, Integer> _e_ : this.skillmap.entrySet()) {
/*  52 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  53 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  55 */     _os_.marshal(this.seq);
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.fight_uuid = _os_.unmarshal_long();
/*  61 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  63 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  65 */       int _v_ = _os_.unmarshal_int();
/*  66 */       this.skillmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  68 */     this.seq = _os_.unmarshal_int();
/*  69 */     if (!_validator_()) {
/*  70 */       throw new VerifyError("validator failed");
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof SSynRoleSkillInfo)) {
/*  78 */       SSynRoleSkillInfo _o_ = (SSynRoleSkillInfo)_o1_;
/*  79 */       if (this.fight_uuid != _o_.fight_uuid) return false;
/*  80 */       if (!this.skillmap.equals(_o_.skillmap)) return false;
/*  81 */       if (this.seq != _o_.seq) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += (int)this.fight_uuid;
/*  90 */     _h_ += this.skillmap.hashCode();
/*  91 */     _h_ += this.seq;
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.fight_uuid).append(",");
/*  99 */     _sb_.append(this.skillmap).append(",");
/* 100 */     _sb_.append(this.seq).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\SSynRoleSkillInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */