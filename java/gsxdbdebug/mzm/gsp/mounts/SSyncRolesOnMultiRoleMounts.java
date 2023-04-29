/*     */ package mzm.gsp.mounts;
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
/*     */ public class SSyncRolesOnMultiRoleMounts
/*     */   extends __SSyncRolesOnMultiRoleMounts__
/*     */ {
/*     */   public static final int PROTOCOL_TYPE = 12606253;
/*     */   public long team_id;
/*     */   public int mounts_cfg_id;
/*     */   public HashMap<Integer, Long> on_mounts_role_id_map;
/*     */   
/*     */   protected void process() {}
/*     */   
/*     */   public int getType()
/*     */   {
/*  27 */     return 12606253;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SSyncRolesOnMultiRoleMounts()
/*     */   {
/*  35 */     this.on_mounts_role_id_map = new HashMap();
/*     */   }
/*     */   
/*     */   public SSyncRolesOnMultiRoleMounts(long _team_id_, int _mounts_cfg_id_, HashMap<Integer, Long> _on_mounts_role_id_map_) {
/*  39 */     this.team_id = _team_id_;
/*  40 */     this.mounts_cfg_id = _mounts_cfg_id_;
/*  41 */     this.on_mounts_role_id_map = _on_mounts_role_id_map_;
/*     */   }
/*     */   
/*     */   public final boolean _validator_() {
/*  45 */     return true;
/*     */   }
/*     */   
/*     */   public OctetsStream marshal(OctetsStream _os_) {
/*  49 */     _os_.marshal(this.team_id);
/*  50 */     _os_.marshal(this.mounts_cfg_id);
/*  51 */     _os_.compact_uint32(this.on_mounts_role_id_map.size());
/*  52 */     for (Map.Entry<Integer, Long> _e_ : this.on_mounts_role_id_map.entrySet()) {
/*  53 */       _os_.marshal(((Integer)_e_.getKey()).intValue());
/*  54 */       _os_.marshal(((Long)_e_.getValue()).longValue());
/*     */     }
/*  56 */     return _os_;
/*     */   }
/*     */   
/*     */   public OctetsStream unmarshal(OctetsStream _os_) throws MarshalException {
/*  60 */     this.team_id = _os_.unmarshal_long();
/*  61 */     this.mounts_cfg_id = _os_.unmarshal_int();
/*  62 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  64 */       int _k_ = _os_.unmarshal_int();
/*     */       
/*  66 */       long _v_ = _os_.unmarshal_long();
/*  67 */       this.on_mounts_role_id_map.put(Integer.valueOf(_k_), Long.valueOf(_v_));
/*     */     }
/*  69 */     if (!_validator_()) {
/*  70 */       throw new VerifyError("validator failed");
/*     */     }
/*  72 */     return _os_;
/*     */   }
/*     */   
/*     */   public boolean equals(Object _o1_) {
/*  76 */     if (_o1_ == this) return true;
/*  77 */     if ((_o1_ instanceof SSyncRolesOnMultiRoleMounts)) {
/*  78 */       SSyncRolesOnMultiRoleMounts _o_ = (SSyncRolesOnMultiRoleMounts)_o1_;
/*  79 */       if (this.team_id != _o_.team_id) return false;
/*  80 */       if (this.mounts_cfg_id != _o_.mounts_cfg_id) return false;
/*  81 */       if (!this.on_mounts_role_id_map.equals(_o_.on_mounts_role_id_map)) return false;
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  88 */     int _h_ = 0;
/*  89 */     _h_ += (int)this.team_id;
/*  90 */     _h_ += this.mounts_cfg_id;
/*  91 */     _h_ += this.on_mounts_role_id_map.hashCode();
/*  92 */     return _h_;
/*     */   }
/*     */   
/*     */   public String toString() {
/*  96 */     StringBuilder _sb_ = new StringBuilder();
/*  97 */     _sb_.append("(");
/*  98 */     _sb_.append(this.team_id).append(",");
/*  99 */     _sb_.append(this.mounts_cfg_id).append(",");
/* 100 */     _sb_.append(this.on_mounts_role_id_map).append(",");
/* 101 */     _sb_.append(")");
/* 102 */     return _sb_.toString();
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\mzm\gsp\mounts\SSyncRolesOnMultiRoleMounts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */