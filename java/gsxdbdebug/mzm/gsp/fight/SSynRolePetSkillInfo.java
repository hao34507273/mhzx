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
/*     */ public class SSynRolePetSkillInfo
/*     */   extends __SSynRolePetSkillInfo__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12594210;
/*     */   public long fight_uuid;
/*     */   public long petuuid;
/*     */   public HashMap<Integer, Integer> skillmap;
/*     */   public int seq;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12594210;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSynRolePetSkillInfo()
/*     */   {
/*  36 */     this.skillmap = new HashMap();
/*     */   }
/*     */   
/*     */   public SSynRolePetSkillInfo(long _fight_uuid_, long _petuuid_, HashMap<Integer, Integer> _skillmap_, int _seq_) {
/*  40 */     this.fight_uuid = _fight_uuid_;
/*  41 */     this.petuuid = _petuuid_;
/*  42 */     this.skillmap = _skillmap_;
/*  43 */     this.seq = _seq_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  47 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  51 */     _os_.marshal(this.fight_uuid);
/*  52 */     _os_.marshal(this.petuuid);
/*  53 */     _os_.compact_uint32(this.skillmap.size());
/*  54 */     for (Map.Entry<Integer, Integer> _e_ : this.skillmap.entrySet()) {
/*  55 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  56 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*     */     }
/*  58 */     _os_.marshal(this.seq);
/*  59 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  63 */     this.fight_uuid = _os_.unmarshal_long();
/*  64 */     this.petuuid = _os_.unmarshal_long();
/*  65 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  67 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  69 */       int _v_ = _os_.unmarshal_int();
/*  70 */       this.skillmap.put(Integer.valueOf(_k_), Integer.valueOf(_v_));
/*     */     }
/*  72 */     this.seq = _os_.unmarshal_int();
/*  73 */     if (!_validator_()) {
/*  74 */       throw new VerifyError("validator failed");
/*     */     }
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  80 */     if (_o1_ == this) return true;
/*  81 */     if ((_o1_ instanceof SSynRolePetSkillInfo)) {
/*  82 */       SSynRolePetSkillInfo _o_ = (SSynRolePetSkillInfo)_o1_;
/*  83 */       if (this.fight_uuid != _o_.fight_uuid) return false;
/*  84 */       if (this.petuuid != _o_.petuuid) return false;
/*  85 */       if (!this.skillmap.equals(_o_.skillmap)) return false;
/*  86 */       if (this.seq != _o_.seq) return false;
/*  87 */       return true;
/*     */     }
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  93 */     int _h_ = 0;
/*  94 */     _h_ += (int)this.fight_uuid;
/*  95 */     _h_ += (int)this.petuuid;
/*  96 */     _h_ += this.skillmap.hashCode();
/*  97 */     _h_ += this.seq;
/*  98 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 102 */     StringBuilder _sb_ = new StringBuilder();
/* 103 */     _sb_.append("(");
/* 104 */     _sb_.append(this.fight_uuid).append(",");
/* 105 */     _sb_.append(this.petuuid).append(",");
/* 106 */     _sb_.append(this.skillmap).append(",");
/* 107 */     _sb_.append(this.seq).append(",");
/* 108 */     _sb_.append(")");
/* 109 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\fight\SSynRolePetSkillInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */